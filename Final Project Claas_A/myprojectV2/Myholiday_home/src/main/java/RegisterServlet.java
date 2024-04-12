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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final static String query = "insert into comment(gender,date,feedback) values(?,?,?)";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //link the bootstrap
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        //get the values
        String gender = req.getParameter("gender");
        String date = req.getParameter("date");
        String feedback = req.getParameter("feedback");
        //load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        //generate the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///homecollection","root","2004@");
                PreparedStatement ps = con.prepareStatement(query);){
            //set the values
            ps.setString(1, gender);
            ps.setString(2, date);
            ps.setString(3, feedback);
            //execute the query
            int count = ps.executeUpdate();
            pw.println("<div class='card' style='margin:auto;width:500px;margin-top:100px'>");
            if(count==1) {
                pw.println("<h2 class='bg-danger text-light text-center'>Thank you for your feedback!</h2>");
            }else {
                pw.println("<h2 class='bg-danger text-light text-center'>Feedback Not Registered</h2>");
            }
        }catch(SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        pw.println("<a href='index.html'><button class='btn btn-outline-success'>Back to main page</button></a>");
        pw.println("</div>");
        //close the stram
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
}
