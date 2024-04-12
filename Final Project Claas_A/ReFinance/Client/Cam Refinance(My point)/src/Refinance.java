import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
public class Refinance extends JFrame{
    String lastInterest; //24months
    String lastPayment; //24months
    String newLoan;
    String availableMonth; //full month - 24
    String newfpayment;
    String newspayment;
    String newTotalInterest; //all(old and new)
    String newTotalPayment; //all(old and new)
    JLabel l;
    ArrayList<String> bankList = new ArrayList<String>();
    public void info(String nfp, String nsp,String nti,String ntp){
        this.newfpayment = nfp;
        this.newspayment = nsp;
        this.newTotalInterest = nti;
        this.newTotalPayment = ntp;
    }
    public String getnfp(){
        return newfpayment;
    }
    public String getnsp(){
        return newspayment;
    }
    public String getnti(){
        return newTotalInterest;
    }
    public String getntp(){
        return newTotalPayment;
    }

    public Refinance(String lastInterest, String lastPayment, String newLoan, String availableMonth){
        this.lastInterest = lastInterest;
        this.lastPayment = lastPayment;
        this.newLoan = newLoan;
        this.availableMonth = availableMonth;
        l = new JLabel("Refinance");
        l.setBounds(230, 20,100,30);
        add(l);

        l = new JLabel("Unpaid payment: "+newLoan+" USD");
        l.setBounds(20, 70, 200, 30);
        add(l);
        //get bank's name from database
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

        cb.setBounds(200, 107, 90, 20);
        add(cb);
        l = new JLabel("Select your bank: ");
        l.setBounds(20, 100, 200, 30);
        add(l);
        l = new JLabel("Months left: "+availableMonth);
        l.setBounds(20, 130, 200, 30);
        add(l);
        l = new JLabel("New First 12 Monthly Payment: ");
        l.setBounds(20, 160, 200, 30);
        add(l);
        JTextField f12p = new JTextField();
        f12p.setBounds(280, 160, 100, 30);
        add(f12p);
        l = new JLabel("New Monthly(after 12 months) Payment: ");
        l.setBounds(20, 190, 250, 30);
        add(l);
        JTextField sp = new JTextField();
        sp.setBounds(280, 190, 100, 30);
        add(sp);
        l = new JLabel("New Total Interest: ");
        l.setBounds(20, 220, 250, 30);
        add(l);
        JTextField ti = new JTextField();
        ti.setBounds(280, 220, 100, 30);
        add(ti);
        l = new JLabel("New Total Payment: ");
        l.setBounds(20, 250, 250, 30);
        add(l);  
        JTextField tp = new JTextField();
        tp.setBounds(280, 250, 100, 30);
        add(tp);
        JButton ref = new JButton("Refinance");
        ref.setBounds(120, 310, 100, 30);
        ref.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        ref.addActionListener(event->{
            Statement sqlSt2;
            ResultSet result2;
            String SQL2 = "SELECT * FROM bank WHERE Name = '"+cb.getItemAt(cb.getSelectedIndex())+"'";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver"); //without text
                String dbURL = "jdbc:mysql://localhost:3306/bank";
                Connection dbConnect = DriverManager.getConnection( dbURL, "root", "");
                sqlSt2= dbConnect.createStatement(); //allows SQL to be executed
                result2 = sqlSt2.executeQuery(SQL2);
                ArrayList<String> bankInfo = new ArrayList<String>();
                while(result2.next()!=false){
                    bankInfo.add(result2.getString("Name"));
                    bankInfo.add(result2.getString("Loan min"));
                    bankInfo.add(result2.getString("Loan max"));
                    bankInfo.add(result2.getString("Period"));
                    bankInfo.add(result2.getString("First Interest"));
                    bankInfo.add(result2.getString("Second Interest"));
                    
                }
                double r, fP = 0,sP = 0;
                double fInterest = Double.parseDouble(bankInfo.get(4))/100;
                double sInterest = Double.parseDouble(bankInfo.get(5))/100;
                int n = Integer.parseInt(bankInfo.get(3))*12;
                int nInput = Integer.parseInt(availableMonth);
                double houseInput = Double.parseDouble(newLoan);
                if(nInput <= n && nInput>0){
                    r = fInterest/12;
                    fP = houseInput/((Math.pow((1+r),nInput)-1)/(r*(Math.pow((1+r),nInput))));//monthly payment for 1st year
                    r = sInterest/12;
                    sP = houseInput/((Math.pow((1+r),nInput)-1)/(r*(Math.pow((1+r),nInput))));//monthly payment after 1st year
                }else{
                    r = 0; fP = 0;sP = 0;
                    fInterest = 0;
                    sInterest = 0;
                    n = 0;
                    nInput = 0;
                    houseInput = 0;
                    JLabel invalid = new JLabel("Invalid month!");
                    invalid.setBounds(200,210,200,30);
                    add(invalid);
                }
                double totalInterest = 0;
                double totalPayment = 0;
                for(int i=0; i<12; i++){
                    totalPayment = totalPayment + fP;
                }
                for(int i=0;i<(nInput-12);i++){
                    totalPayment = totalPayment + sP;
                }
                double newTotalPayment = Double.parseDouble(lastPayment) + totalPayment; //old + new
                totalInterest = totalPayment - houseInput;
                double newTotalInterest = Double.parseDouble(lastInterest) + totalInterest;//old + new
                String fPformat = String.format("%.4f", fP);
                String sPformat = String.format("%.4f", sP);
                String tInformat = String.format("%.4f", newTotalInterest);
                String tPmformat = String.format("%.4f", newTotalPayment);
                newfpayment = fPformat;
                newspayment = sPformat;
                info(newfpayment, newspayment,tInformat, tPmformat);
                f12p.setText(newfpayment+" USD");
                sp.setText(newspayment+" USD");
                ti.setText(tInformat+" USD");
                tp.setText(tPmformat+" USD");
                sqlSt2.close();
            }
            catch(ClassNotFoundException ex){ //make sure jar working
                Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Class not found, check the JAR");
            }
            catch(SQLException ex){ //make sure my SQL good
                Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("SQL IS BAD!!"+ex.getMessage());
            } 
        });   
        add(ref);
        JButton close = new JButton("Close");
        close.setBounds(280, 310, 100, 30);
        close.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        close.addActionListener(event->{
            dispose();
        });
        add(close);

        setSize(500,400);
        setLayout(null);
        setResizable(false);
        setLocation(300, 250);
        setVisible(true);
    }
}
