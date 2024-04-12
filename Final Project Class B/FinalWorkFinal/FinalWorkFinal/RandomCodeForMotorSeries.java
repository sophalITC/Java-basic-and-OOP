package FinalWorkFinal;

import java.util.ArrayList;

public class RandomCodeForMotorSeries extends SQLConnectionStatement {
    public int countRecord() {      // Connector and Count record from database Method
        int count = 0;
        try {
            statement = connection.createStatement();
            String countQuery = "SELECT count(*) FROM motorcycledata;";
            resultSet = statement.executeQuery(countQuery);
            resultSet.next();
            count = resultSet.getInt(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }
    public String getAlphaNumericString(int digits) {        // Generate Code Method
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer(digits);
        for (int i = 0; i < digits; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
    public void updateMotorCode(String arr, int index) {     // Update MotoCode Method
        try {
            String Query = "UPDATE motorcycledata SET MotoCode = ? WHERE No = ?;";
            preparedStmt = connection.prepareStatement(Query);
            preparedStmt.setString(1, arr);
            preparedStmt.setInt(2, index);
            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        RandomCodeForMotorSeries random = new RandomCodeForMotorSeries();
        ArrayList<String> codeList = new ArrayList<>();
        int digits = 5;                         // 5 digits of MotoCode
        int countCode = 0;                      // count number of records from database
        int n = random.countRecord();           // number of records

        // Print and add code into arraylist
        for (int i=1; i<=n; i++) {
            String code = random.getAlphaNumericString(digits);
            System.out.println(code);
            codeList.add(code);
            countCode += 1;
        };
        System.out.println("\nThere are " + countCode + " codes.\n");

        // Update MotoCode into database
        for (int i=0; i<n; i++)  {
            random.updateMotorCode(codeList.get(i), i+1);
        }
    }
}