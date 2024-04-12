

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int found=0;
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String province2 = req.getParameter("province");
		ArrayList<home> h = new ArrayList<home>();
		int i;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///homecollection","root","2004@");
			String query = "select * from info";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 String location = rs.getString("location");
				 int id = rs.getInt("id");
				 String types = rs.getString("type");
				 String landsize = rs.getString("landsize");
				 String room = rs.getString("room");
				 String direction = rs.getString("direction");
				 String price = rs.getString("price");
				 String special = rs.getString("special");
				 home h1 = new home(id,types,landsize,room,location,direction,special,price);
				 h.add(h1);
				 found=1;
			}
			
		}catch(SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
		if(found==1) {
			pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
			pw.println("<table class='table table-hover table-striped'>");
		    pw.println("<tr>");
		    pw.println("<th>ID</th>");
		    pw.println("<th>Home type</th>");
		    pw.println("<th>Land size</th>");
		    pw.println("<th>Room</th>");
		    pw.println("<th>Location</th>");
		    pw.println("<th>Direction</th>");
		    pw.println("<th>price</th>");
		    pw.println("<th>Special</th>");
		    pw.println("</tr>");
			for( i=0; i<h.size();i++) {
				if (h.get(i).location.equalsIgnoreCase(province2)) {
				pw.println("<tr>");
	            pw.println("<td>"+h.get(i).id+"</td>");
	            pw.println("<td>"+h.get(i).type+"</td>");
	            pw.println("<td>"+h.get(i).landsize+"</td>");
	            pw.println("<td>"+h.get(i).room+"</td>");
	            pw.println("<td>"+h.get(i).location+"</td>");
	            pw.println("<td>"+h.get(i).dicrection+"</td>");
	            pw.println("<td>"+h.get(i).price+"</td>");
	            pw.println("<td>"+h.get(i).special+"</td>");
	            pw.println("</tr>");
	            found = 1;
				}	
			}
			pw.println("</table>");
			
		}else {
			pw.println("Sorry, we don't have this record in our website.");
		}

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}