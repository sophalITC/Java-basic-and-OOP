import java.sql.*;
public abstract class SqlConnection {
    static final String DB_URL = "jdbc:mysql://localhost:3306/itcroom";
    static final String USER = "root";
    static final String PASS = "happyams";

    Connection con;
    Statement statement;
    ResultSet result;
    PreparedStatement preStatement;
    SqlConnection(){
        try{
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = con.createStatement();
        }catch(SQLException error){
        }
    }

    public abstract void View()throws Exception;

    public abstract void Insert(String day, String time, int room, String group, String available, String building) throws Exception;

    public abstract void SearchAvailable(String available)throws Exception;

    public abstract void SearchRoom(int room)throws Exception;

    public abstract void SearchGroup(String group)throws Exception;

    public abstract void SearchBuilding(String building)throws Exception;

    public abstract void SearcchDay(String day)throws Exception;

    public abstract void SearchTime(String time)throws Exception;

    public abstract void Update(String day, String time, int room, String newTime, String newDay, int newRoom, String newGroup, String newAvailable, String newBuilding)throws Exception;

    public abstract void Delete(int room, String time, String day, String building)throws Exception;

    public void close()throws Exception{
        con.close();
    }

    public class DB_URL {
    }
}
