import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class LoginForm extends JFrame {
    private static JTextField tfEmail;
    private static JPasswordField pfPassword;
    private static JLabel lbEmail;
    private static JLabel lbPassword;
    private static JButton btnLogin;
    private static JButton btnRegister;
    private static JButton btnCancel;

    public void initialize() {
        /*************** Form Panel ***************/
        JLabel lbLoginForm = new JLabel("Login Client Account", SwingConstants.CENTER);

        lbEmail = new JLabel("Email");
        tfEmail = new JTextField();

        lbPassword = new JLabel("Password");
        pfPassword = new JPasswordField();

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbLoginForm);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);

        /*************** Buttons Panel ***************/
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                ClientUser user = getAuthenticatedUser(email, password);

                if (user != null) {
                    new HomePage();
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "Email or Password Invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });

        btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationForm registerForm = new RegistrationForm();
                registerForm.RegisterAccount();
                
            }

        });
        
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnRegister);
        buttonsPanel.add(btnCancel);



        /*************** Initialise the frame ***************/
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("Login Client Account");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1000, 700);
        setMinimumSize(new Dimension(350, 450));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }



    private ClientUser getAuthenticatedUser(String email, String password) {
        ClientUser user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/client(project)";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new ClientUser();
                user.username = resultSet.getString("username");
                user.email = resultSet.getString("email");
                user.password = resultSet.getString("password");
            }

            stmt.close();
            //preparedStatement.close();
            conn.close();

        }catch(Exception e){
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        loginForm.initialize();
    }
}
