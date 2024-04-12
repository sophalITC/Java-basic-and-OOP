import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class HomePage extends JFrame{
    ArrayList<String> bankList = new ArrayList<String>();
    public HomePage(){

        JLabel t1 = new JLabel("Calculator");
        t1.setBounds(400, 20, 500, 50);
        t1.setForeground(Color.gray);
        t1.setFont(new Font("Serif", Font.BOLD, 25));
        add(t1);

        t1 = new JLabel("Know how to get the lowest pay for your house.");
        t1.setBounds(250, 60, 500, 40);
        t1.setForeground(Color.gray);
        t1.setFont(new Font("Serif", Font.BOLD, 25));
        add(t1);

        t1 = new JLabel("Let's get started.");
        t1.setBounds(370, 100, 500, 40);
        t1.setForeground(Color.gray);
        t1.setFont(new Font("Serif", Font.BOLD, 25));
        add(t1);
        

        t1 = new JLabel("House's Information");
        t1.setBounds(600, 220, 500, 20);
        t1.setForeground(Color.gray);
        t1.setFont(new Font("Serif", Font.BOLD, 20));
        add(t1);

        JLabel houseInfo = new JLabel();
        houseInfo.setBounds(500, 250, 400, 340);
        Border blackline = BorderFactory.createLineBorder(Color.gray);
        houseInfo.setBorder(blackline);
        add(houseInfo);

        JTextField tPrice = new JTextField();
        tPrice.setBounds(700, 300, 150, 30);
        JLabel l = new JLabel("Home Purchase Price: $");
        l.setBounds(530, 300, 200, 30);
        l.setFont(new Font("Serif", Font.BOLD, 15));
        l.setForeground(Color.gray);
        add(tPrice);add(l);

        //get bank's name to store in comboBox
        Statement sqlSt;
        String output;
        ResultSet result;
        String SQL = "SELECT Name FROM bank";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //without text
            String dbURL = "jdbc:mysql://localhost:3306/bank";
            Connection dbConnect = DriverManager.getConnection( dbURL, "root", "");
            sqlSt = dbConnect.createStatement(); //allows SQL to be executed
            result = sqlSt.executeQuery(SQL);
            String tmp;
            while(result.next()!=false){
                output = result.getString("Name");
                tmp = output;
                bankList.add(tmp);
            }
            // for(int i = 0; i<bankList.size(); i++){
            //     System.out.println(bankList.get(i));
            // }
            sqlSt.close();
        }
        catch(ClassNotFoundException ex){ //make sure jar working
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class not found, check the JAR");
        }
        catch(SQLException ex){ //make sure my SQL good
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL IS BAD!!"+ex.getMessage());
        }
        String[] bank = new String[bankList.size()];
        for(int i=0 ; i<bankList.size(); i++){
            bank[i] = bankList.get(i);
        }
        JComboBox cb = new JComboBox(bank);
        cb.setBounds(650, 347, 90, 20);
        l = new JLabel("Select your bank: ");
        l.setBounds(530, 340, 200, 30);
        l.setFont(new Font("Serif", Font.BOLD, 15));
        l.setForeground(Color.gray);

        JButton view = new JButton("View bank's detail");
        view.setBounds(750, 347, 140, 20);
        view.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Statement sqlSt;
                ResultSet result;
                String SQL = "SELECT * FROM bank WHERE Name = '"+cb.getItemAt(cb.getSelectedIndex())+"'";
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver"); //without text
                    String dbURL = "jdbc:mysql://localhost:3306/bank";
                    Connection dbConnect = DriverManager.getConnection( dbURL, "root", "");
                    sqlSt = dbConnect.createStatement(); //allows SQL to be executed
                    result = sqlSt.executeQuery(SQL);
                    ArrayList<String> bankInfo = new ArrayList<String>();
                    while(result.next()!=false){
                        bankInfo.add(result.getString("Name"));
                        bankInfo.add(result.getString("Loan min"));
                        bankInfo.add(result.getString("Loan max"));
                        bankInfo.add(result.getString("Period"));
                        bankInfo.add(result.getString("First Interest"));
                        bankInfo.add(result.getString("Second Interest"));
                        
                    }
                    new ViewBankInfo(bankInfo.get(0), bankInfo.get(1), bankInfo.get(2), bankInfo.get(3), bankInfo.get(4),bankInfo.get(5));
                    sqlSt.close();
                }
                catch(ClassNotFoundException ex){ //make sure jar working
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Class not found, check the JAR");
                }
                catch(SQLException ex){ //make sure my SQL good
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("SQL IS BAD!!"+ex.getMessage());
                }
            }
        });
        JLabel n = new JLabel("Number of months: ");
        n.setBounds(530, 380, 200, 30);
        n.setFont(new Font("Serif", Font.BOLD, 15));
        n.setForeground(Color.gray);
        add(n);
        JTextField tn = new JTextField();
        tn.setBounds(700, 380, 150, 30);
        add(tn);
        add(cb);add(l);add(view);

        JButton cal = new JButton("Calculate");
        cal.setBounds(555, 500, 90, 20);
        cal.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        cal.addActionListener(event->{
            String tmpBank = (String)cb.getItemAt(cb.getSelectedIndex());
            String tmpTn = tn.getText();
            String tmpAmount = tPrice.getText();
            new Calculator(tmpBank, tmpTn,tmpAmount);
        });
        add(cal);

        JButton clear = new JButton("Clear");
        clear.setBounds(760, 500, 90, 20);
        clear.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        clear.addActionListener(event->{
            tn.setText("");
            tPrice.setText("");
        });
        add(clear);
        JButton close = new JButton("Close");
        close.setBounds(660, 500, 90, 20);
        close.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        close.addActionListener(event->{
            dispose();
        });
        add(close);

        setSize(1000,700);
        setLayout(null);
        setResizable(false);
        setLocation(300, 20);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
