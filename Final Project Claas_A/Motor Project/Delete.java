package IDBC;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Delete {
	static final String url
    = "jdbc:mysql://localhost:3306/ams";
	public void delete()
{
	 Scanner input = new Scanner(System.in);
	 String uname = "root";
	 String password="tota2110t";  
	 System.out.println("\n\t=======\n\t\t========\n\t\t\t=======>This section you can delete some motors information==========<\n\n");
     System.out.println("\t\tyou will delete information by:\n\t\t1.Price.\n\t\t2.Shop.\n\t\t3.Model\n\t\t4.Year.\n\t\t5.ID.\n");
	 int i;
     do{
     try {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,uname,password);
        Statement stmt = conn.createStatement();
        System.out.println("Enter your choice: ");
   	    int n= input.nextInt();
        if(n==1) {
        System.out.printf("\t\tYou will delete information motor by Price. ");
        System.out.printf("\n\t\tEnter  price: ");
        int price= input.nextInt();
        String query= "delete from project where Price = ? ";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, price);  
        int result = ps.executeUpdate();
        
        if (result > 0)
            System.out.println("\t\tSuccessful deleted.\n");
        else
            System.out.println("unsuccessful deletion.\n");
        conn.close();
    }if(n==2) {
    	String dd = input.nextLine();
    	System.out.printf("\t\tYou will delete information motor by Shop. ");
    	System.out.printf("\n\t\tEnter  Shop: ");
        String shop= input.nextLine();
        String query= "delete from project where Shop = ? ";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, shop);
      
        int result = ps.executeUpdate();
        
        if (result > 0)
            System.out.println("\t\tSuccessful deleted.\n");
        else
            System.out.println("unsuccessful deletion.\n ");
        conn.close();
    }
    if(n==3) {
    	String dd = input.nextLine();
    	System.out.printf("\t\tYou will delete information motor by Model. ");
    	System.out.printf("\t\tEnter  Model: ");
        String model= input.nextLine();
        String query= "delete from project where Model= ? ";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, model);
      
        int result = ps.executeUpdate();
        
        if (result > 0)
            System.out.println("\t\tSuccessful deleted.\n");
        else
            System.out.println("unsuccessful deletion.\n ");
        conn.close();
    	
    }if(n==4) {
    	String dd = input.nextLine();
    	System.out.printf("\t\tYou will delete information motor by Year. ");
    	System.out.printf("\n\t\tEnter  Year: ");
        int year= input.nextInt();
        String query= "delete from project where Year= ? ";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,year);
        int result = ps.executeUpdate();
        if (result > 0)
            System.out.println("\t\tSuccessful deleted.\n");
        else
            System.out.println("unsuccessful deletion.\n ");
        conn.close();
    }if(n==5) {
    	String dd = input.nextLine();
    	System.out.printf("\t\tYou will delete information motor by ID. ");
    	System.out.printf("\n\t\tEnter  ID: ");
        int id= input.nextInt();
        String query= "delete from project where ID = ? ";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,id);
      
        int result = ps.executeUpdate();
        
        if (result > 0)
            System.out.println("\t\tSuccessful deleted.\n");
        else
            System.out.println("unsuccessful deletion.\n ");
        conn.close();
    }
	   
    }
    catch (SQLException e) {
        System.out.println(e);
    }
     	System.out.printf("\t\tDo you want to do it again?(yes=1 / No=0.)");
	    System.out.println("\n\t\tEnter answer: ");
	    i=input.nextInt();
       }while(i!=0);
}
}
