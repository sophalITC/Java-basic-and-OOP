package IDBC;
import java.util.*;
import java.lang.*;
import java.util.Scanner;
import java.sql.*;
public class Passwordd {	
	    public void Login(){
	    Resgister connection = new Resgister();
	    Connection con = null;
	    PreparedStatement p= null;
	    ResultSet rs=null;
	    // step 3
	    con = connection.connectDB();
	    
	    
	      try{
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter your lucky code: ");
	        int ID = scanner.nextInt();
	        
	        String sql;
	        if(ID==1) {
	           sql= "select * from Login where id= 1";
	        }else if(ID==2) {
	           sql= "select * from Login where id= 2";
	        }else if(ID==3) {
	           sql= "select * from Login where id= 3";
	        }else if(ID==4) {
	           sql= "select * from Login where id= 4";
	        }else if(ID==5) {
	              sql= "select * from Login where id= 5";
	           }else if(ID==6) {
	              sql= "select * from Login where id= 6";
	           }else if(ID==7) {
	              sql= "select * from Login where id= 7";
	           }else if(ID==8) {
	              sql= "select * from Login where id= 8";
	           }else if(ID==9) {
	             sql= "select * from Login where id= 9";
	          }else if(ID==10){
	              sql= "select * from Login where id= 10";
	           }else if(ID==11) {
	             sql= "select * from Login where id= 11";
	          }else if(ID==12) {
	             sql= "select * from Login where id= 12";
	          }else if(ID==13) {
	             sql= "select * from Login where id= 13";
	          }else if(ID==14) {
	            sql= "select * from Login where id= 14";
	         }else if(ID==15) {
	             sql= "select * from Login where id= 15";
	          }else if(ID==16) {
	            sql= "select * from Login where id= 16";
	         }else if(ID==17) {
	            sql= "select * from Login where id= 17";
	         }else if(ID==18) {
	           sql= "select * from Login where id= 18";
	        }else if(ID==19) {
	            sql= "select * from Login where id= 19";
	         }else {
	           sql= "select * from Login where id= 20";
	        }
	        
	        
	      // Step 4
	      //String sql= "select * from Login ";
	      
	      //Step 5
	      p = con.prepareStatement(sql);
	            rs = p.executeQuery();
	 
	      // Step 6: Process the results
	      //System.out.println("id\t\tname");
	      
	      //int rs=null;
	      if(rs.next()) {
	         int id = rs.getInt("ID");
	         scanner.nextLine();
	                 String name = rs.getString("Username");
	                 String email=rs.getString("Email");
	                 
	              // Print and display name, emailID and password
	              // System.out.println(id + "\t\t" + name );
	          
	            System.out.print("Enter Email: ");
	            String password = scanner.nextLine();
	            System.out.print("Enter Password: ");
	            String username = scanner.nextLine();
	            if(name.equals(username)&&email.equals(password)){
	                System.out.println("User Successfully loged-in...");
	            }
	            else{
	                System.out.println("In valid username of password ");
	                System.out.println("exit...");
	                System.exit(0);
	            }
	            }
	       }catch(Exception e) {
	         System.out.println("Something went wrong.");
	       }
	   }
	
}
