import java.sql.*;
import java.util.ArrayList;

public class sqlStudyRoom extends SqlConnection{

    @Override
    public void View()throws Exception{
        quickSort sort = new quickSort();
        ArrayList <Room> StudyRoom = new ArrayList<>();
        result = statement.executeQuery("SELECT * FROM STUDY_ROOM");
        
         while(result.next()){
            Room studyR = new Room(
            result.getString(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6),result.getString(7));
            StudyRoom.add(studyR);
        }
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s", "BUILDING", "DAY", "TIME", "ROOM", "GROUP", "AVAILABLE");
        for (Room room : sort.sortRoom(StudyRoom)){
            System.out.printf(
            "\n|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s", 
            room.getBuilding(), room.getDayOfWeek(), room.getTime(), room.getRoom(), room.getGroup(), room.getAvailable());
        }
        System.out.println("\n----------------------------------------------------------------------");

       
    }

    @Override
    public void Insert(String day, String time, int room, String group, String available, String building) throws Exception{

        String sqlQuery = "INSERT INTO STUDY_ROOM(DAY_, TIME_, ROOM_, GROUP_, AVAILABLE_, BUILDING_) VALUES(?,?,?,?,?,?)";
        preStatement = con.prepareStatement(sqlQuery);
        preStatement.setString(1, day);
        preStatement.setString(2, time);
        preStatement.setInt(3, room);
        preStatement.setString(4, group);
        preStatement.setString(5, available);
        preStatement.setString(6, building);
        preStatement.execute();

    }

    @Override
    public void Update(String day, String time, int room, String newTime, String newDay, int newRoom, String newGroup, String newAvailable, String newBuilding)throws Exception{
        preStatement = con.prepareStatement(
            "UPDATE STUDY_ROOM SET DAY_ = ?, TIME_ = ?, ROOM_ = ?, GROUP_ = ?, AVAILABLE_ = ?, BUILDING_ = ? WHERE ROOM_ = ? AND TIME_ = ? AND DAY_ = ?"
            );
        preStatement.setString(1, newDay);
        preStatement.setString(2, newTime);
        preStatement.setInt(3, newRoom);
        preStatement.setString(4, newGroup);
        preStatement.setString(5, newAvailable);
        preStatement.setString(6, newBuilding);
        preStatement.setInt(7,room);
        preStatement.setString(8, time);
        preStatement.setString(9, day);

        preStatement.executeUpdate();
    }

    public void Update(String available, String day, String time, int room, String building)throws Exception{
        preStatement = con.prepareStatement(
            "UPDATE STUDY_ROOM SET AVAILABLE_ = ? WHERE ROOM_ = ? AND TIME_ = ? AND DAY_ = ? AND BUILDING_ = ?"
                );
        preStatement.setString(1, available);
        preStatement.setInt(2, room);
        preStatement.setString(3, time);
        preStatement.setString(4, day);
        preStatement.setString(5, building);
    
        preStatement.executeUpdate();
    }

    @Override
    public void Delete(int room, String time, String day, String building)throws Exception{
        preStatement = con.prepareStatement("DELETE FROM STUDY_ROOM WHERE ROOM_ = ? AND TIME_ = ? AND DAY_ = ? AND BUILDING_ = ?");
        preStatement.setInt(1, room);
        preStatement.setString(2, time);
        preStatement.setString(3, day);
        preStatement.setString(4, building);
        preStatement.execute();
    }
   

    @Override
    public void SearchAvailable(String available) throws Exception {
        preStatement = con.prepareStatement("SELECT * FROM LAB WHERE AVAILABLE_ = ?");
        preStatement.setString(1, available);
        result = preStatement.executeQuery();
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s", "BUILDING", "DAY", "TIME", "ROOM", "GROUP", "AVAILABLE");
        while(result.next()){
            System.out.printf("\n|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s",result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
        }
        System.out.println("\n----------------------------------------------------------------------");
        
    }

    @Override
    public void SearchRoom(int room) throws Exception {
        preStatement = con.prepareStatement("SELECT * FROM LAB WHERE ROOM_ = ?");
        preStatement.setInt(1, room);
        result = preStatement.executeQuery();
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s", "BUILDING", "DAY", "TIME", "ROOM", "GROUP", "AVAILABLE");
        while(result.next()){
            System.out.printf("\n|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s",result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
        }
        System.out.println("\n----------------------------------------------------------------------");     
    }

    @Override
    public void SearchGroup(String group) throws Exception {
        preStatement = con.prepareStatement("SELECT * FROM LAB WHERE GROUP_ = ?");
        preStatement.setString(1, group);
        result = preStatement.executeQuery();
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s", "BUILDING", "DAY", "TIME", "ROOM", "GROUP", "AVAILABLE");
        while(result.next()){
            System.out.printf("\n|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s",result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
        }
        System.out.println("\n----------------------------------------------------------------------");
        
    }

    @Override
    public void SearchBuilding(String building) throws Exception {
        preStatement = con.prepareStatement("SELECT * FROM LAB WHERE BUILDING_ = ?");
        preStatement.setString(1, building);
        result = preStatement.executeQuery();
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s", "BUILDING", "DAY", "TIME", "ROOM", "GROUP", "AVAILABLE");
        while(result.next()){
            System.out.printf("\n|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s",result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
        }
        System.out.println("\n----------------------------------------------------------------------");
        
    }

    @Override
    public void SearcchDay(String day) throws Exception {
        preStatement = con.prepareStatement("SELECT * FROM LAB WHERE DAY_ = ?");
        preStatement.setString(1, day);
        result = preStatement.executeQuery();
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s", "BUILDING", "DAY", "TIME", "ROOM", "GROUP", "AVAILABLE");
        while(result.next()){
            System.out.printf("\n|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s",result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
        }
        System.out.println("\n----------------------------------------------------------------------");
        
    }

    @Override
    public void SearchTime(String time) throws Exception {
        preStatement = con.prepareStatement("SELECT * FROM LAB WHERE TIME_ = ?");
        preStatement.setString(1, time);
        result = preStatement.executeQuery();
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s", "BUILDING", "DAY", "TIME", "ROOM", "GROUP", "AVAILABLE");
        while(result.next()){
            System.out.printf("\n|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s",result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
        }
        System.out.println("\n----------------------------------------------------------------------");
        
    }
}
