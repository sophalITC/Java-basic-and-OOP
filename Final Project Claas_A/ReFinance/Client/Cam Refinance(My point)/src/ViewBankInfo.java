import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class ViewBankInfo extends JFrame{
    JLabel l;
    private String bankName;
    private String loanMin;
    private String loanMax;
    private String period;
    private String fRate;
    private String sRate;
    public ViewBankInfo(String bankName, String loanMin, String loanMax, String period, String fRate, String sRate){
        this.bankName = bankName;
        this.loanMin = loanMin;
        this.loanMax = loanMax;
        this.period = period;
        this.fRate = fRate;
        this.sRate = sRate;
        l = new JLabel("Bank's Information");
        l.setBounds(200, 20, 200, 30);
        l.setForeground(Color.gray);
        add(l);
        l = new JLabel("Bank name:     "+getName());
        l.setBounds(20,70,150, 30);
        l.setForeground(Color.gray);
        add(l);
        l = new JLabel("Loan from: "+getLoanMin()+"USD to "+getLoanMax()+"USD");
        l.setBounds(20,100,200, 30);
        l.setForeground(Color.gray);
        add(l);
        l = new JLabel("Period: "+getPeriod()+" Years");
        l.setBounds(20,130,150, 30);
        l.setForeground(Color.gray);
        add(l);
        l = new JLabel("First Year Interest: "+getfRate()+"%");
        l.setBounds(20,160,200, 30);
        l.setForeground(Color.gray);
        add(l);
        l = new JLabel("Second Year Interest: "+getsRate()+"%");
        l.setBounds(20,190,200, 30);
        l.setForeground(Color.gray);
        add(l);
        JButton close = new JButton("Close");
        close.setBounds(200, 210, 100, 30);
        close.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        close.addActionListener(event->{
            dispose();
        });
        add(close);
        


        setSize(500,300);
        setLayout(null);
        setResizable(false);
        setLocation(300, 20);
        setVisible(true);
        
    }
    public ViewBankInfo(){
        
    }
    public String getName(){
        return bankName;
    }
    public String getLoanMin(){
        return loanMin;
    }
    public String getLoanMax(){
        return loanMax;
    }
    public String getPeriod(){
        return period;
    }
    public String getfRate(){
        return fRate;
    }
    public String getsRate(){
        return sRate;
    }
}
