import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public void initialize(ClientUser user) {
       /*************** Info Panel ***************/
        // JPanel infoPanel = new JPanel();
        // infoPanel.setLayout(new GridLayout(0, 2, 5, 5));
        // infoPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        // infoPanel.add(new JLabel("username"));
        // infoPanel.add(new JLabel(user.username));
        // infoPanel.add(new JLabel("Email"));
        // infoPanel.add(new JLabel(user.email));
        
        // Component[] labels = infoPanel.getComponents();
        // for (int i = 0; i < labels.length; i++) {
        //     labels[i].setFont(new Font("Segoe print", Font.BOLD, 18));
        // }

        //add(infoPanel, BorderLayout.NORTH);


        setTitle("Dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

