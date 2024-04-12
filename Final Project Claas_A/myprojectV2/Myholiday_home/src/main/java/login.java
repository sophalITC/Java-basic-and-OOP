
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String name = req.getParameter("userName");
		String email = req.getParameter("email");
		String password1 = req.getParameter("password");
		encryt en = new encryt();
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///homecollection","root","2004@");
			String query = "insert into loging1 (name,email,password)"+"values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, en.encrypt(password1).toString());
			boolean susces = ps.execute();
			
	        pw.println("<div class='card' style='margin:auto;width:500px;margin-top:100px'>");
	        if(!susces) {
	             pw.println("<h2 class='bg-danger text-light text-center'>You are sign up successfully!</h2>");
	         }else {
	             pw.println("<h2 class='bg-danger text-light text-center'>Sorry something went wrong(:</h2>");
	         }
			con.close();
	}catch(SQLException se) {
        pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
        se.printStackTrace();
    }catch(Exception e) {
        e.printStackTrace();
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
