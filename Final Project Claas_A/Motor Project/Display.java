package IDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Display {
	  final String url = "jdbc:mysql://localhost:3306/ams";
	  final String uname = "root";
	  final String password="tota2110t";
	  public Connection Display(){
	    Connection con = null;
	    try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      con = DriverManager.getConnection(url,uname,password);
	    }catch (SQLException e) {
	            e.printStackTrace();
	        }catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	     return con;
	  }
	
}
