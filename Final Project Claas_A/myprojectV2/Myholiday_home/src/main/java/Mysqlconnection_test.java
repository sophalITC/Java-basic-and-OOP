
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Mysqlconnection_test
 */
@WebServlet("/Mysqlconnection_test")
public class Mysqlconnection_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
        //initializing connections
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqltest","root","2004@");
            stmt = con.createStatement();   
            rs = stmt.executeQuery("select * from User");
            while (rs.next()) {
                pw.print("<br>"+rs.getString("Name")+", "+rs.getString("Email"));
            }
        }// End of try block
        catch(Exception e) {e.printStackTrace();}
	}

}
