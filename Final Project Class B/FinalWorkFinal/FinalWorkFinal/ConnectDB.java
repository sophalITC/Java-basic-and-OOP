package FinalWorkFinal;

import java.sql.*;
public class ConnectDB {
    // Random and set for final secret key
    final String secretKey = "@rD!v]!)(>:nQyKZKn9mvB=0gCZfUU)Cd{g_UFg#%YR>vv}!12";
    String WhichDB = "";
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    public ConnectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/AdminUserDatabase",
                    "root", "LaySENG./333");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean SearchData(int type, String username, String password) throws SQLException {
        if (type == 1) {
            WhichDB = "AdminInfo";
        } else if (type == 2) {
            WhichDB = "UserInfo";
        }
        try {
            String sqlDB = "SELECT * FROM `AdminUserDatabase`.`" + WhichDB + "` WHERE Username = ? AND Password = ?;";
            preparedStatement = connection.prepareStatement(sqlDB);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }
    public void SignUpInsert(int type, String id, String username, String email, String password) throws SQLException {
        if (type == 1) {
            WhichDB = "AdminInfo";
        } else if (type == 2) {
            WhichDB = "UserInfo";
        }
        try {
            String x = MyAESAppEncDec.encrypt(password, secretKey);

            String sqlDB = "INSERT INTO `AdminUserDatabase`.`" + WhichDB + "` (ID, Username, Email, Password) VALUES (?,?,?,?)";

            preparedStatement = connection.prepareStatement(sqlDB);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, x);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
