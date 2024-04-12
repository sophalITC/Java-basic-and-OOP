import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class Calculator extends JFrame{
    JLabel l;
    private String fpayment,spayment, totalInterest, totalPayment,bank,month,amount;
    String lastInterest; //24months
    String lastPayment; //24months
    String newLoan;
    String availableMonth; //full month - 24
    public Calculator(String fpayment, String spayment,String totalInterest, String totalPayment,String bank,String month,String amount){
        this.fpayment = fpayment;
        this.spayment = spayment;
        this.totalInterest = totalInterest;
        this.totalPayment = totalPayment;
        this.bank = bank;
        this.month = month;
        this.amount = amount;
    }
    private void Cal(String fpayment, String spayment,String totalInterest, String totalPayment){
        this.fpayment = fpayment;
        this.spayment = spayment;
        this.totalInterest = totalInterest;
        this.totalPayment = totalPayment;
    }
    private void Cal(String lastInterest, String lastPayment, String newLoan, String availableMonth,String a){
        this.lastInterest = lastInterest;
        this.lastPayment = lastPayment;
        this.newLoan = newLoan;
        this.availableMonth = availableMonth;
    }
    public String getFPayment(){
        return fpayment;
    }
    public String getSPayment(){
        return spayment;
    }
    public String getTotalInterest(){
        return totalInterest;
    }
    public String getTotalPayment(){
        return totalPayment;
    }
    public String getBank(){
        return bank;
    }
    public String getMonth(){
        return month;
    }
    public String getAmount(){
        return amount;
    }
    public String getLastInterest(){
        return lastInterest;
    }
    public String getLastPayment(){
        return lastPayment;
    }
    public String getNewLoan(){
        return newLoan;
    }
    public String getAvailableMonth(){
        return availableMonth;
    }
    public Calculator(String fpayment, String spayment,String totalInterest, String totalPayment){
        this(fpayment, spayment, totalInterest,totalPayment,"","","");
    }
    public Calculator(String bank,String month,String amount){
        this.bank = bank;
        this.month = month;
        this.amount = amount;
        l = new JLabel("Calculator");
        l.setBounds(200, 20, 150, 30);
        add(l);
        Statement sqlSt;
        ResultSet result;
        String SQL = "SELECT * FROM bank WHERE Name = '"+getBank()+"'";
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
            double r, fP = 0,sP = 0;
            double fInterest = Double.parseDouble(bankInfo.get(4))/100;
            double sInterest = Double.parseDouble(bankInfo.get(5))/100;
            int n = Integer.parseInt(bankInfo.get(3))*12;
            int nInput = Integer.parseInt(getMonth());
            double houseInput = Double.parseDouble(getAmount());
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
            double sum1 = totalPayment;
            double sum2 = 0;
            for(int i=0;i<(nInput-12);i++){
                if(i<12){
                    totalPayment = totalPayment + sP;
                    sum2 = sum2 + sP;
                }else{
                    totalPayment = totalPayment + sP;
                }
            }
            double housePrice24 = 0;
            double pricePerMonth = houseInput/(double)nInput;
            for(int i=0;i<24;i++){
                housePrice24 = housePrice24 + pricePerMonth;
            }
            sum1 = sum1 + sum2;
            double sumR = sum1 - housePrice24;
            double newLoan = (Double.parseDouble(getAmount()) - sum1)*(1+sInterest); //pay all money at month 25 with rate per month(not annual rate)
            int aMonth = nInput - 24;
            totalInterest = totalPayment - houseInput;
            String fPformat = String.format("%.4f", fP);
            String sPformat = String.format("%.4f", sP);
            String tInformat = String.format("%.4f", totalInterest);
            String tPmformat = String.format("%.4f", totalPayment);
            Cal(fPformat,sPformat,tInformat,tPmformat);
            String sR = String.format("%.4f",sumR);
            String sPm = String.format("%.4f",sum1);
            String nL = String.format("%.4f",newLoan);
            String aM = String.valueOf(aMonth);
            System.out.println(sPm);
            Cal(sR,sPm,nL,aM,"");
            sqlSt.close();
        }
        catch(ClassNotFoundException ex){ //make sure jar working
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class not found, check the JAR");
        }
        catch(SQLException ex){ //make sure my SQL good
            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL IS BAD!!"+ex.getMessage());
        }

        JButton close = new JButton("Close");
        close.setBounds(250, 310, 100, 30);
        close.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        close.addActionListener(event->{
            dispose();
        });
        add(close);
        JButton refinance = new JButton("Refinance");
        refinance.setBounds(120, 310, 100, 30);
        refinance.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        refinance.addActionListener(event->{
            System.out.println(getLastInterest());
            System.out.println(getLastPayment());
            System.out.println(getNewLoan());
            System.out.println(getAvailableMonth());
            new Refinance(getLastInterest(), getLastPayment(),getNewLoan(),getAvailableMonth());
        });
        add(refinance);
        l = new JLabel("Monthly Payment First 12 months: "+getFPayment()+" USD");
        l.setBounds(50, 50, 400, 30);
        add(l);
        l = new JLabel("Monthly Payment after 12 months: "+getSPayment()+" USD");
        l.setBounds(50, 90, 400, 30);
        add(l);
        l = new JLabel("Total Interest: "+getTotalInterest()+" USD");
        l.setBounds(50, 130, 300, 30);
        add(l);
        l = new JLabel("Total Payment: "+getTotalPayment()+" USD");
        l.setBounds(50, 170, 300, 30);
        add(l);

        setSize(500,400);
        setLayout(null);
        setResizable(false);
        setLocation(300, 20);
        setVisible(true);
    }
}
