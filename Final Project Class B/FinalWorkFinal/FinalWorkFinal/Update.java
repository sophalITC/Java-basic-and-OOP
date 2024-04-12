package FinalWorkFinal;

public class Update extends SQLConnectionStatement {
    public void UpdateInfo(int n, int No, String MotoCode, String MotoSeries,
                           String Color, String Year, String Price,
                           String ShopLocation, String ShopName,
                           String NewPhoneNumber, String OldMotoCode) {
        try {
            String Query = "UPDATE motorcycledata SET No = ?, MotoCode = ?, MotorSeries = ?, Color = ?, Year = ?, Price = ?, " +
                    "ShopLocation = ?, ShopName = ?, PhoneNumber = ? WHERE MotoCode = ?";
            preparedStmt = connection.prepareStatement(Query);

            preparedStmt.setInt(1, No);
            preparedStmt.setString(2, MotoCode);
            preparedStmt.setString(3, MotoSeries);
            preparedStmt.setString(4, Color);
            preparedStmt.setString(5, Year);
            preparedStmt.setString(6, Price);
            preparedStmt.setString(7, ShopLocation);
            preparedStmt.setString(8, ShopName);
            preparedStmt.setString(9, NewPhoneNumber);
            preparedStmt.setString(10, OldMotoCode);
            preparedStmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
