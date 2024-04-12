package FinalWorkFinal;

public class Display extends SQLConnectionStatement {
    public void NormalDisplayDatabase() {
        String sql = "select * from motorcycledata";
        ShowList(sql);
    }

    public void DESCDisplayDatabase() {
        String sql = "SELECT * FROM motorcycledata ORDER BY Price DESC";
        ShowList(sql);
    }

    public void ASCDisplayDatabase() {
        String sql = "SELECT * FROM motorcycledata ORDER BY Price ASC";
        ShowList(sql);
    }
}
