package IDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Search {
	final String url= "jdbc:mysql://localhost:3306/ams";
	final String uname = "root";
	final String password="tota2110t";
	public Connection Search()
	{
  
    Connection con = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, uname, password);
        //String query
        //= "Search FROM information where ID = 123 ";
        
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
    catch (ClassNotFoundException e) {
    	        e.printStackTrace();
    }

        return con;
}

    }


