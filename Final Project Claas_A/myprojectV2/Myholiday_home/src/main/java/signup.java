

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
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
		ArrayList<sign_up> s1 = new ArrayList<sign_up>();
		encryt en = new encryt();
		int found = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///homecollection","root","2004@");
			String query = "select * from loging1";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 String name1 = rs.getString("name");
				 String email1 = rs.getString("email");
				 String password2 = rs.getString("password");
				 sign_up s2 = new sign_up(name1,email1,en.deencrypt(password2).toString());
				 s1.add(s2);
			}
			for (int i=0;i<s1.size();i++) {
				if(s1.get(i).name.equalsIgnoreCase(name)&&s1.get(i).email.equals(email)&&s1.get(i).password.equalsIgnoreCase(password1)) {
					RequestDispatcher rd = req.getRequestDispatcher("index.html");
			 		rd.forward(req, res);
			 		found = 1;
				} 
			}
			if(found==0) {
				pw.println("<h2 class='bg-danger text-light text-center'>Sorry something went wrong(:</h2>");
			}
			
	} catch(SQLException se) {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
