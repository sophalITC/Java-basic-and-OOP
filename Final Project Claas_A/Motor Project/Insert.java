package IDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Insert {
	  public void insert() {
	    String url = "jdbc:mysql://localhost:3306/ams";
	    String uname = "root";
	    String password="tota2110t";
	    String query="insert into Project(ID,Shop,Model,Year,Price)" + "values(?,?,?,?,?)";
	    System.out.printf("\n\t=======\n\t\t========\n\t\t\t=======>This section you can  add  motors information ==========<\n\n");
	    System.out.printf("\n\t=============>The formation of motor will have ID,Shop name,Model,Year and price.==========>\n");
	    Scanner input = new Scanner(System.in);
	    int i;
	    do {
	    System.out.printf("\n\t\tEnter ID: ");
	    int ID = input.nextInt();
	    String dd = input.nextLine();
	    System.out.printf("\n\t\tEnter shop: ");
	    String Shop= input.nextLine();
	    System.out.printf("\n\t\tEnter Model: ");
	    String Model=input.nextLine();
	    System.out.printf("\n\t\tEnter Year: ");
	    int Year = input.nextInt();
	    System.out.printf("\n\t\tEnter Price: ");
	    int Price= input.nextInt();
	    PreparedStatement ps =null;
	    try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	    }catch(ClassNotFoundException e) {
	      //ToDo auto generated catch 
	      e.printStackTrace();
	    }
	    try {
	      Connection con = DriverManager.getConnection(url, uname, password);
	      ps = con.prepareStatement(query);
	      ps.setInt(1, ID);
	      ps.setString(2, Shop);
	      ps.setString(3, Model);
	      ps.setInt(4, Year);
	      ps.setInt(5, Price);
	      ps.execute();
	      
	      con.close();


	      // closing connection
	      con.close();
	  }
	     
	      
	    catch(SQLException e) {
	      e.printStackTrace();
	    }
		    
		  System.out.printf("\n\t\tDo you want to do it again?(yes=1 / No=0.)");
	      System.out.println("\n\t\tEnter answer: ");
	      i=input.nextInt();
          }while(i!=0);
	  }
}
