import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class RegistrationForm extends JFrame {
    private static JTextField tfusername;
    private static JTextField tfEmail;
    private static JPasswordField pfPassword;
    private static JLabel lbusername;
    private static JLabel lbEmail;
    private static JLabel lbPassword;
    private static JButton btnRegister;
    private static JButton btnCancel;

    public void RegisterAccount() {
        /*************** Form Panel ***************/
        JLabel lbRegisterForm = new JLabel("Client Regiter Account", SwingConstants.CENTER);

        lbusername = new JLabel("Username");
        tfusername= new JTextField();

        lbEmail = new JLabel("Email");
        tfEmail = new JTextField();

        lbPassword = new JLabel("Password");
        pfPassword = new JPasswordField();

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbRegisterForm);
        formPanel.add(lbusername);
        formPanel.add(tfusername);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);
    
        /*************** Buttons Panel ***************/
        btnRegister = new JButton("Register account");
        btnRegister.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfusername.getText();
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());
                if (username.isEmpty() || email.isEmpty() ||  password.isEmpty()) {
                    JOptionPane.showMessageDialog(RegistrationForm.this,
                            "Please enter all fields",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ClientUser user = addUserToDatabase(username,email,password);

                if (user != null) {
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(RegistrationForm.this,
                            "Failed to register new user",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });

        btnCancel = new JButton("Close");
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnRegister);
        buttonsPanel.add(btnCancel);



        /*************** Initialise the frame ***************/
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("Client Register Account");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1000, 700);
        setMinimumSize(new Dimension(350, 450));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private ClientUser addUserToDatabase(String username, String email, String password) {
        ClientUser user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/client(project)";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (username, email, password) " +
                    "VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            //Insert row into the table
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                user = new ClientUser();
                user.username = username;
                user.email = email;
                user.password = password;
            }

            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }

  
//    public static void main(String[] args) {
//         RegistrationForm register = new RegistrationForm();
//         register.RegisterAccount();
//     }  
}
