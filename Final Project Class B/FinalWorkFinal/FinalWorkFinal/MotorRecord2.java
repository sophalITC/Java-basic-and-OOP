package FinalWorkFinal;
public class MotorRecord2{
    private String No;
    private String MotoCode;
    private String MotorSeries;
    private String Color;
    private String Year;
    private String Price;
    private String ShopLocation;
    private String ShopName;
    private String PhoneNumber;
    MotorRecord2(){}
    public MotorRecord2(String no, String motorCode, String motorSeries, String color, String year,
                        String price, String shopLocation, String shopName, String phoneNumber) {
        No = no;
        MotoCode = motorCode;
        MotorSeries = motorSeries;
        Color = color;
        Year = year;
        Price = price;
        ShopLocation = shopLocation;
        ShopName = shopName;
        PhoneNumber = phoneNumber;
    }
    public String getNo() {
        return No;
    }
    public void setNo(String no) {
        No = no;
    }
    public String getMotoCode() {
        return MotoCode;
    }
    public void setMotoCode(String motoCode) {
        MotoCode = motoCode;
    }
    public String getMotorSeries() {
        return MotorSeries;
    }
    public void setMotorSeries(String motorSeries) {
        MotorSeries = motorSeries;
    }
    public String getColor() {
        return Color;
    }
    public void setColor(String color) {
        Color = color;
    }
    public String getYear() {
        return Year;
    }
    public void setYear(String year) {
        Year = year;
    }
    public String getPrice() {
        return Price;
    }
    public void setPrice(String price) {
        Price = price;
    }
    public String getShopLocation() {
        return ShopLocation;
    }
    public void setShopLocation(String shopLocation) {
        ShopLocation = shopLocation;
    }
    public String getShopName() {
        return ShopName;
    }
    public void setShopName(String shopName) {
        ShopName = shopName;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return String.format("%-10s %-20s %-45s %-40s %-20s %-25s %-25s %-50s %-20s",
                No, MotoCode, MotorSeries, Color, Year, Price, ShopLocation, ShopName, PhoneNumber);
    }
}
