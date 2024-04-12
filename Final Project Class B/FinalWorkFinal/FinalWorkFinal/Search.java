package FinalWorkFinal;

public class Search extends SQLConnectionStatement {
    public void searchSeries(String FindByMotoSeries) {         /* Search By Motor Series */
        String sql = "SELECT * FROM motorcycledata WHERE MotorSeries = '"+FindByMotoSeries+"' ORDER BY Price DESC";
        ShowList(sql);
    }

    public void searchCode(String FindByMotoCode) {             /* Search By Motor Code */
        String sql = "SELECT * FROM motorcycledata WHERE MotoCode = '"+FindByMotoCode+"' ORDER BY Price DESC";
        ShowList(sql);
    }

    public void searchAny(String FindByAnything) {                 /* Search By Shop Name */
        String sql = "SELECT * FROM motorcycledata " +
                "WHERE CONCAT(No, MotoCode, MotorSeries, Color, Year, Price, ShopLocation, ShopName, PhoneNumber) " +
                "LIKE '%"+FindByAnything+"%' ORDER BY Price ASC";
        ShowList(sql);
    }

    public void searchSeriesAndShop(String FindBySeries, String FindByLocation) {               /* Search By Motor Series and Shop Name (Combined) */
        int counter = 0;
        try {
            String sqlDB = "SELECT * FROM motorcycledata WHERE MotorSeries = ? AND ShopLocation = ? ORDER BY Price DESC;";
            preparedStmt = connection.prepareStatement(sqlDB);
            preparedStmt.setString(1, FindBySeries);
            preparedStmt.setString(2, FindByLocation);
            resultSet = preparedStmt.executeQuery();

            System.out.printf("\n%-10s %-20s %-45s %-40s %-20s %-25s %-25s %-50s %-20s\n",
                    "No", "MotoCode", "MotorSeries", "Color", "Year", "Price", "ShopLocation", "ShopName", "PhoneNumber");
            for (int j=1; j<=301; j++) {
                System.out.print("-");
            }
            System.out.println();
            while (resultSet.next()) {
                String No = resultSet.getString("No");
                String MotoCode = resultSet.getString("MotoCode");
                String MotorSeries = resultSet.getString("MotorSeries");
                String Color = resultSet.getString("Color");
                String Year = resultSet.getString("Year");
                String Price = resultSet.getString("Price");
                String ShopLocation = resultSet.getString("ShopLocation");
                String ShopName = resultSet.getString("ShopName");
                String PhoneNumber = resultSet.getString("PhoneNumber");

                System.out.printf("%-10s %-20s %-45s %-40s %-20s %-25s %-25s %-50s %-20s\n",
                        No, MotoCode, MotorSeries, Color, Year, Price, ShopLocation, ShopName, PhoneNumber);
                counter += 1;
            }
            System.out.println("\n\t>>> There are " +counter + " records in our database system.");
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchWithPriceBelow(String FindPrice) {                /* Search By Motor Price */
        String sql = "SELECT * FROM motorcycledata WHERE Price <= '"+FindPrice+"' ORDER BY Price DESC";
        ShowList(sql);
    }
}