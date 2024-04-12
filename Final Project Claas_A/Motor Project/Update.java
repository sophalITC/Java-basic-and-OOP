package IDBC;
import java.sql.*;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Update {
    public void update()
    {   
    	Scanner input = new Scanner(System.in);
    	String url = "jdbc:mysql://localhost:3306/ams";
        String uname = "root";
        String password="tota2110t";
        System.out.println("\n\t=======\n\t\t========\n\t\t\t=======>This section you can update  motors information==========<\n\n");
        int i;
        do {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
              Connection conn = DriverManager.getConnection(url,uname,password);
              Statement stmt = conn.createStatement();
              System.out.printf("Enter ID you want to update: ");
              int id= input.nextInt();
              System.out.println("you want to update : ");
              System.out.println("1.Price\n2.Year\n3.Shop\n4.Model");
              System.out.println("Enter your option: ");
              int p = input.nextInt();
              if(p==1) {
            	  System.out.println("You will update Price by ID");
                  System.out.printf("Enter New price: ");
                  int price= input.nextInt();
              String query= "update project set Price =?  where ID=?";
              PreparedStatement ps = conn.prepareStatement(query);
              ps.setInt(1, price);
              ps.setInt(2, id);
            int result = ps.executeUpdate();
  
            if (result > 0)
                System.out.println(
                    "table successfully updated.\n");
            else
                System.out.println("unable to update.\n");
            conn.close();
            }
              if(p==2) {
            	  System.out.println("You will update Year by ID");
                  System.out.printf("Enter New Year: ");
                  int year= input.nextInt();
	              String query= "update project set Year =?  where ID=?";
	              PreparedStatement ps = conn.prepareStatement(query);
	              ps.setInt(1, year);
	              ps.setInt(2, id);
            int result = ps.executeUpdate();
  
            if (result > 0)
                System.out.println(
                    "table successfully updated.\n");
            else
                System.out.println("unable to update.\n");
            conn.close();
            } if(p==3) {
            	System.out.println("You will update shop by ID");
              System.out.printf("Enter New Shop: ");
              String shop= input.nextLine();
	          String query= "update project set Shop =?  where ID=?";
	          PreparedStatement ps = conn.prepareStatement(query);
	          ps.setString(1, shop);
	          ps.setInt(2, id);
        int result = ps.executeUpdate();

        if (result > 0)
            System.out.println(
                "table successfully updated.\n");
        else
            System.out.println("unable to update.\n");
        conn.close();
        } if(p==4) {
          System.out.println("You will update model by ID");
          String dd = input.nextLine();
          System.out.printf("Enter New Model: ");
          String model= input.nextLine();
          String query= "update project set Model =?  where ID=?";
          PreparedStatement ps = conn.prepareStatement(query);
          ps.setString(1, model);
          ps.setInt(2, id);
    int result = ps.executeUpdate();

    if (result > 0)
        System.out.println(
            "table successfully updated.\n");
    else
        System.out.println("unable to update.\n");
    conn.close();
    }
 
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        
        System.out.printf("\t\tDo you want to update more?(yes=1 / No=0.)");
        System.out.println("\n\t\tEnter answer: ");
        i=input.nextInt();
        }while(i!=0);
    }
}

    

