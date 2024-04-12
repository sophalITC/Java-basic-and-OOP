package FinalWorkFinal;

public class Delete extends SQLConnectionStatement {
    public void DeleteDatabase(int n, String DelMotoCode, String DelMotoSeries, String DelShopName) {
        try {
            String query = "DELETE FROM motorcycledata WHERE MotoCode = ? AND MotorSeries = ? AND ShopName = ?;";
            preparedStmt = connection.prepareStatement(query);

            preparedStmt.setString(1, DelMotoCode);
            preparedStmt.setString(2, DelMotoSeries);
            preparedStmt.setString(3, DelShopName);
            preparedStmt.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
