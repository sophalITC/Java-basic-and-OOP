package IDBC;
import java.sql.*;
public class View {
	  public void view() {
	    // step 2
	    Display connection = new Display();
	    Connection con = null;
	    PreparedStatement p= null;
	    ResultSet rs=null;
	    // step 3
	    con = connection.Display();
	    
	    try {
	      // Step 4
	      String query= "Select * from project ORDER by ID";
	      
	      //Step 5
	      p = con.prepareStatement(query);
	      rs = p.executeQuery();
	 
	      // Step 6: Process the results
	      System.out.println("\n\t=======\n\t\t========\n\t\t\t=======>This section you can see the table of motor information==========<\n\n");
	      System.out.println("*********************************************************************************\n*\t\t\t\t\t\t\t\t\t\t*\n*\tID\t\tShop\t\tModel\t\tYear\t\tPrice\t*\n*\t\t\t\t\t\t\t\t\t\t*\n*********************************************************************************");
	      
	      //int rs=null;
	      while(rs.next()) {
	        int id = rs.getInt("ID");
	                String shop = rs.getString("Shop");
	                String Model = rs.getString("Model");
	                int  year = rs.getInt("Year");
	                int price = rs.getInt("Price");
	                
	                 
	              // Print and display name, emailID and password
	              System.out.println("\t"+id + "\t\t" + shop+ "\t\t" + Model + "\t\t"+ year+ "\t"+price+"\n");
	      }
	      //con.close();
	    }
	    catch (SQLException e) {
	      // print the exception
	      System.out.println(e);
	    }
	  }
	}


