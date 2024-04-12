package FinalWorkFinal;

import java.sql.*;
import java.util.ArrayList;

public class SQLConnectionStatement {
    Connection connection;
    Statement statement = null;
    PreparedStatement preparedStmt = null;
    ResultSet resultSet = null;

    public SQLConnectionStatement() {
        // below two lines are used for connectivity.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Motor",
                    "root", "LaySENG./333");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //ArrayList Result adding
    public ArrayList<MotorRecord2> Motors(String ShowType){
        ArrayList<MotorRecord2> motoList = new ArrayList<>();
        String sqlQuery = ShowType;
        MotorRecord2 eachMoto;
        try{
            statement= connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()){
                eachMoto = new MotorRecord2();
                eachMoto.setNo(resultSet.getString("No"));
                eachMoto.setMotoCode(resultSet.getString("MotoCode"));
                eachMoto.setMotorSeries(resultSet.getString("MotorSeries"));
                eachMoto.setColor(resultSet.getString("Color"));
                eachMoto.setYear(resultSet.getString("Year"));
                eachMoto.setPrice(resultSet.getString("Price"));
                eachMoto.setShopLocation(resultSet.getString("ShopLocation"));
                eachMoto.setShopName(resultSet.getString("ShopName"));
                eachMoto.setPhoneNumber(resultSet.getString("PhoneNumber"));
                motoList.add(eachMoto);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return motoList;
    }
    //Show List
    public void ShowList(String ShowType){
        ArrayList<MotorRecord2> motoList = Motors(ShowType);
        int counter = 0;
        System.out.printf("\n%-10s %-20s %-45s %-40s %-20s %-25s %-25s %-50s %-20s\n",
                "No", "MotoCode", "MotorSeries", "Color", "Year", "Price", "ShopLocation", "ShopName", "PhoneNumber");
        for (int j=1; j<=301; j++) {
            System.out.print("-");
        }
        System.out.printf("\n");
        for(MotorRecord2 m : motoList){
            System.out.println(m.toString());
            counter++;
        }
        System.out.println("\n\t>>> There are " +counter+ " records in our database system.\n");
    }
}
