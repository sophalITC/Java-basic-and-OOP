
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/putangdata")
public class putang extends HttpServlet {
    private final static String query ="select id,type,landsize,room,location,direction,price,special from info where id=5";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //link the bootstrap
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        pw.println("<marquee><h2 class='text-primary'>Putang Resort infomation</h2></marquee>");
        //load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        //generate the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///homecollection","root","2004@");
                PreparedStatement ps = con.prepareStatement(query);){
            //resultSet
            ResultSet rs = ps.executeQuery();
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
            while(rs.next()) {
                pw.println("<tr>");
                pw.println("<td>"+rs.getInt(1)+"</td>");
                pw.println("<td>"+rs.getString(2)+"</td>");
                pw.println("<td>"+rs.getString(3)+"</td>");
                pw.println("<td>"+rs.getString(4)+"</td>");
                pw.println("<td>"+rs.getString(5)+"</td>");
                pw.println("<td>"+rs.getString(6)+"</td>");
                pw.println("<td>"+rs.getString(7)+"</td>");
                pw.println("<td>"+rs.getString(8)+"</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
        }catch(SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        pw.println("<button class='btn btn-outline-success d-block'><a href='putang.html'>Back</a></button>");
        pw.println("</div>");
        //close the stream
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
}