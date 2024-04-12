import java.sql.*;

public class SqlUser {
    static final String DB_URL = "jdbc:mysql://localhost:3306/itcroom";
    static final String USER = "root";
    static final String PASS = "happyams";

    Connection con;
    Statement statement;
    ResultSet result;
    PreparedStatement preStatement;
    SqlUser(){
        try{
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = con.createStatement();
        }catch(SQLException error){
        }
    }
    
    public void View()throws Exception{
        result = statement.executeQuery("SELECT * FROM user_info");
        System.out.printf("|%-10s|%-17s|%-17s", "ID", "NAME", "EMAIL", "PASSWORD");
        while(result.next()){
            System.out.printf("\n|%-10s|%-17s|%-17s",result.getString(1), result.getString(2), result.getString(3));
               
        }
        System.out.println("\n--------------------------------------------------------------");
        
    }

    public void Insert(String name, String password, String email) throws Exception{
        Encryptor encrypt = new Encryptor();
        String sqlQuery = "INSERT INTO user_info(USER_NAME, PASSWORD, EMAIL) VALUES(?,?,?)";
        preStatement = con.prepareStatement(sqlQuery);
        preStatement.setString(1, name);
        preStatement.setString(2, encrypt.encryptString(password));
        preStatement.setString(3, email);
        preStatement.execute();

    }
    public void SearchName(String name)throws Exception{
        preStatement = con.prepareStatement("SELECT * FROM USER_INFO WHERE NAME = ?");
        preStatement.setString(1, name);
        result = preStatement.executeQuery();
        System.out.printf("|%-10s|%-17s|%-17s", "ID", "NAME", "EMAIL");
        while(result.next()){
            System.out.printf("\n|%-10s|%-17s|%-17s",result.getString(1), result.getString(2), result.getString(3));
        }
        System.out.println("\n--------------------------------------------------------------");
    }
    public void SearchEmail(String email)throws Exception{
        preStatement = con.prepareStatement("SELECT * FROM USER_INFO WHERE EMAIL = ?");
        preStatement.setString(1, email);
        result = preStatement.executeQuery();
        System.out.printf("|%-10s|%-17s|%-17s", "ID", "NAME", "EMAIL");
        while(result.next()){
            System.out.printf("\n|%-10s|%-17s|%-17s",result.getString(1), result.getString(2), result.getString(3));
        }
        System.out.println("\n--------------------------------------------------------------");
    } 

    public void Update(String name, String password, String email)throws Exception{
        preStatement = con.prepareStatement("UPDATE USER_INFO SET USER_NAME = ?, PASSWORD = ? WHERE email = ?");
        preStatement.setString(1, name);
        preStatement.setString(2, password);
        preStatement.setString(3, email);
        preStatement.executeUpdate();
    }

    public void Delete(String email)throws Exception{
        preStatement = con.prepareStatement("DELETE FROM USER_INFO WHERE EMAIL = ?");
        preStatement.setString(1, email);
        preStatement.executeUpdate();
    } 

    public void close() throws Exception{
        con.close();
    }
}
