package FinalWorkFinal;

import java.sql.PreparedStatement;

    /*
        INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
        VALUES ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway');

        INSERT INTO motorcycledata (No, MotoSeries, Color, Year, Price, ShopLocation, ShopName, PhoneNumber)
        VALUES (123, "Honda Dream", "BLack", "2023", "3000", "Phnom Penh", "Pailin Motor Shop", "0162345343");
    */

public class Add extends SQLConnectionStatement {
    public void AddDatabase(int n, int No, String MotoCode, String MotorSeries, String Color, String Year,
                            String Price, String ShopLocation, String ShopName, String PhoneNumber) {
        try {
            String Addquery = " INSERT INTO motorcycledata (No, MotoCode, MotorSeries, Color, Year, Price, ShopLocation, ShopName, PhoneNumber)" +
                    "  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement prepared = connection.prepareStatement(Addquery);

            prepared.setInt(1, No);
            prepared.setString(2, MotoCode);
            prepared.setString(3, MotorSeries);
            prepared.setString(4, Color);
            prepared.setString(5, Year);
            prepared.setString(6, Price);
            prepared.setString(7, ShopLocation);
            prepared.setString(8, ShopName);
            prepared.setString(9, PhoneNumber);
            prepared.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}