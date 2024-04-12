import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
class Data{
    String line="";
    String splitBy=",";
    Scanner scan= new Scanner(System.in);
    Data(){}
}
class Accoun extends Data{
    Accoun(){
//        try {
////            BufferedReader br = new BufferedReader(new FileReader("Accounting.csv")); // Read csv file
////            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category"); // Heading
////            while ((line = br.readLine()) != null)   //returns a Boolean value
////            {
////                String[] employee = line.split(splitBy);
////                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
////            }
////        } catch (IOException e){ // When we input incorrectly, The error will be raised. Example: Input name of not correct, it will raise the error
////            e.printStackTrace();
////        }
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","1502e20200863");
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from c");
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category"); // Heading
            while(resultSet.next()){
                System.out.printf("%16s%45s%45s%38s%39s%28s\n",resultSet.getString("Number")
                        ,resultSet.getString("Title"),resultSet.getString("Des"),resultSet.getString("Location"),resultSet.getString("date"),resultSet.getString("category"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class Adminstra extends Data{
    Adminstra(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Adminstration.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
class Archit extends Data{
    Archit(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Adminstration.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Assistant extends Data{
    Assistant(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Assistant1.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index is out of range!");
        }
    }
}
class Audit_and_Taxation extends Data{
    Audit_and_Taxation(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Audit_and_taxation.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Bank_and_Insurance extends Data{
    Bank_and_Insurance(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Banking_and_Insurance.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Cashier_and_Receptionist extends Data{
    Cashier_and_Receptionist(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Cash.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Catering_and_restaurant extends Data{
   Catering_and_restaurant(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Catering_and_restaurant.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Clean_and_Maid extends Data{
    Clean_and_Maid(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Clean_and_maid.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Consultant extends Data{
    Consultant(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Consultant (2).csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Customer_Service extends Data{
    Customer_Service(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Customer_Service.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Design extends Data{
    Design(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Design.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Education_Training extends Data{
    Education_Training(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Education_and_Training.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Finance extends Data{
    Finance(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Finance.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Freight extends Data{
    Freight(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Freight_delivery_warehouse.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Hotel extends Data{
    Hotel(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Hotel_hopitality.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Humance extends Data{
    Humance(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Human_Resource.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Information extends Data{
    Information(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Information_Technology.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Lawyer extends Data{
    Lawyer(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Lawyer_legalService (2).csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Management extends Data{
    Management(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Management.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Manufacturing extends Data{
    Manufacturing(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Manufacturing.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Marketing extends Data{
    Marketing(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Marketing1.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Mechandising extends Data{
    Mechandising(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Mechandising_Purchasing.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Media extends Data{
    Media(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Media_and_Advertising.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Medical extends Data{
    Medical(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Medical_Nurse_Health.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Operation extends Data{
    Operation(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Operation.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Project extends Data{
    Project(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Project_Management.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class QC extends Data{
    QC(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("QC.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Resort extends Data{
    Resort(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Resort.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Sale extends Data{
    Sale(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Sale.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Security extends Data{
    Security(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Security_Driver.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Technician extends Data{
    Technician(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Technician.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Telecommunication extends Data{
    Telecommunication(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Telecommunication.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Translation extends Data{
    Translation(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Translation.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Travel extends Data{
    Travel(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Travel_Agent.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class Other extends Data{
    Other(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Other.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
class List extends  Data{
    List(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("piseth.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
//        catch ( ArrayIndexOutOfBoundsException e){
//            System.out.println("Index is out of range");
//        }
    }
}
public class Code_Category {
    public static void Account(){
                                                        //Function Using
//        String line = "";
//        String splitBy = ",";
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("Accounting.csv"));
//            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
//            while ((line = br.readLine()) != null)   //returns a Boolean value
//            {
//                String[] employee = line.split(splitBy);
//                System.out.printf("\n%16s%45s%45s%38s%39s%28s\n", employee[0], employee[1], employee[2], employee[3], employee[4], employee[5]);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
                                                    //Instance class Using
        Accoun a= new Accoun();
    }
    public static void Admin(){
        Adminstra ad= new Adminstra();
    }
    public static void Architect(){
        Archit ar= new Archit();
    }
    public static void Assis(){
        Assistant ar= new Assistant();
    }
    public static void Audit(){
        Audit_and_Taxation au= new Audit_and_Taxation();
    }
    public static void seth(){
        List l= new List();
    }
    public static void oth(){Other o= new Other();}
    public static void Bank(){Bank_and_Insurance b= new Bank_and_Insurance();}
    public  static void Cashier(){Cashier_and_Receptionist c= new Cashier_and_Receptionist();}
    public  static void Cate(){Catering_and_restaurant rest= new Catering_and_restaurant();}
    public  static void Clean(){Clean_and_Maid clean= new Clean_and_Maid();}
    public  static void Consultant(){Consultant con= new Consultant();}
    public  static void Customer(){Customer_Service cum= new Customer_Service();}
    public  static void desi(){Design de= new Design();}
    public  static void Educ(){Education_Training edu= new Education_Training();}
    public  static void Fina(){Finance fin= new Finance();}
    public  static void Frieg(){Freight fr= new Freight();}
    public  static void Hotel(){Hotel ho = new Hotel();}
    public  static void Human(){Humance h= new Humance();}
    public  static void Info(){Information in= new Information();}
    public  static void law(){Lawyer la= new Lawyer();}
    public  static void Manange(){Management man= new Management();}
    public  static void Manufact(){Manufacturing man= new Manufacturing();}
    public  static void Mark(){Marketing ma= new Marketing();}
    public  static void Mechan(){Mechandising ne= new Mechandising();}
    public  static void Media(){Media Me= new Media();}
    public  static void Medical(){Medical dic= new Medical();}
    public  static void Operation(){Operation o= new Operation();}
    public  static void Project(){Project pro= new Project();}
    public  static void QC(){QC qual= new QC();}
    public  static void Resort(){Resort re= new Resort();}
    public  static void Sal(){Sale sa= new Sale();}
    public  static void Security(){Security secur= new Security();}
    public  static void Technic(){Technician tech= new Technician();}
    public  static void Telecom(){Telecommunication tele= new Telecommunication();}
    public  static void Translation(){Translation tran= new Translation();}
    public  static void Trave(){Travel tra= new Travel();}
    public static void Phnom(){
        Scanner scan= new Scanner(System.in);
        String line="";
        String splitby=",";
        try{
            BufferedReader bf= new BufferedReader(new FileReader("Accounting.csv"));
            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
            while((line=bf.readLine())!=null){
                String[] collumn=line.split(splitby);
                if(collumn[3].equalsIgnoreCase("Phnom Penh")){
//                    System.out.println(collumn[3]);
                    System.out.printf("%16s%45s%45s%38s%39s%28s\n",collumn[0],collumn[1],collumn[2],collumn[3],collumn[4],collumn[5]);
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
//    public static void admin(){
//        Scanner scan= new Scanner(System.in);
//        String line="";
//        String splitby=",";
//        try{
//            BufferedReader bf= new BufferedReader(new FileReader("Accounting.csv"));
//            System.out.printf("%16s%45s%45s%38s%39s%28s\n", "Number", "Title", "Company", "Location", "Date", "Category");
//            while((line=bf.readLine())!=null){
//                String[] collumn=line.split(splitby);
//                if(collumn[3].equalsIgnoreCase("Phnom Penh")){
////                    System.out.println(collumn[3]);
//                    System.out.printf("%16s%45s%45s%38s%39s%28s\n",collumn[0],collumn[1],collumn[2],collumn[3],collumn[4],collumn[5]);
//                }
//
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) {
        String line = "";
        String splitBy = ",";
        Scanner scan= new Scanner(System.in); String to;
        String op="";
//        int choice;
        String choice="";
       do {
           System.out.println("""
                   \n[1].List all Job\t\t[2].Search Job\t\t[3].Search Job by Location\t\t[4].Exit\n
                   Choose from 1-3:
                   """);
//           choice=scan.nextInt();
//           while(!scan.hasNextInt()){
//               scan.nextLine();
//               System.out.println("Input again as Number:");
//           }
//           choice=scan.nextInt();
           choice=scan.nextLine();
           String Tolower=choice.toLowerCase();
           to=("list all job".contains(Tolower) || "1".contains(Tolower))?"1"
                   :("search job".contains(Tolower) || "2".contains(Tolower))?"2"
                   :("search job by location".contains(Tolower)|| "3".contains(Tolower))?"3":
                   ("exit".contains(Tolower)|| "4".contains(Tolower))?"4":"5";

           switch (to) {
               case "1":
                   seth();
                   break;
               case "2":
               do {
                   System.out.println("""
                               \n[1].Accounting\t\t\t\t[2].Adminstration\t\t\t\t[3].Architecture\t\t\t\t\t[4].Assistant\n
                           [5].Assistant\t\t\t\t[6].Audit and Taxation\t\t\t[7].Banking and Insurance\t\t\t[8].Cashier and Reception\n
                           [9].Catering and Resturant\t[10].Clean and Maid\t\t\t\t[11].Consultant\t\t\t\t\t\t[12].Customer Sercice\n
                           [13].Design\t\t\t\t\t[14].Education and Training\t\t[15].Finance\t\t\t\t\t\t[16].Freight, Delivery and Warehouse\n
                           [17].Hotel and Hospitality\t[18].Human Resource\t\t\t\t[19].Information Teachnology\t\t[20].Lawyer and Legal Service\n
                           [21].Management\t\t\t\t[22].Manufacturing\t\t\t\t[23].Mechandising and Purcharsing\t[24].Media and Advertising\n
                           [25].Medical, Nurse and Health\t[26].Operation\t\t\t\t[27].Project Management\t\t\t\t[28].Quality Control\n
                           [29].Resort and Casino\t\t[30].Sale\t\t\t\t\t\t[31].Security and Driver\t\t\t[32].Technician\n
                           [33].Telecommunication\t\t[34].Translation and Interpretation\t[35].Travel Agencyt\t\t\t\t[36].Other\n
                           [37].Quit
                           """);
                   System.out.println("You can Type as the serial Number:");
                   op=scan.nextLine();
//                   while (!scan.hasNextInt()) {
//                       scan.nextLine();
//                       System.out.println("Please input again as number :");
//                   }
//                   op = scan.nextInt();
//                   if (op == 1) {Account();} else if (op == 2) {Admin();} else if (op == 3) {Architect();} else if (op == 4) {Assis();} else if (op == 5) {Audit();} else if(op==6){Audit();} else if(op==7){Bank();} else if(op==8){Cashier();} else if(op==9){Cate();} else if(op==10){Clean();} else if(op==11){Consultant();} else if(op==12){Customer();} else if(op==13){desi();} else if(op==14){Educ();}else if(op==15){Fina();} else if(op==16){Frieg();} else if(op==17){Hotel();} else if(op==18){Human();} else if(op==19){Info();} else if(op==20){law();} else if(op==21){Manange();} else if(op==22){Manufact();}else if(op==23){Mark();}else if(op==24){Mechan();}else if(op==25){Medical();}else if(op==26){Operation();}else if(op==27){Project();}else if(op==28){QC();}else if(op==29){Resort();}else if(op==30){Sal();}else if(op==31){Security();}else if(op==32){Technic();}else if(op==33){Telecom();} else if(op==34){Translation();} else if(op==35){Trave();} else if (op == 36) {oth();}
//                   else{
//                       System.out.println("Please Input again!");
////                       break;
//                   }
                   String tolower=op.toLowerCase();
                   String ternary=("account".contains(tolower) || "1".contains(tolower))?"1"
                           :("adminstration".contains(tolower) || "2".contains(tolower))?"2"
                           :("architecture".contains(tolower)|| "3".contains(tolower))?"3"
                           :("assistant".contains(tolower)|| "4".contains(tolower))?"4"
                           :("assistant".contains(tolower)|| "5".contains(tolower))?"5"
                           :("audit and taxation".contains(tolower)|| "6".contains(tolower))?"6"
                           :("banking and Insurance".contains(tolower)|| "7".contains(tolower))?"7"
                           :("cashier and reception".contains(tolower) || "8".contains(tolower))?"8"
                           :("catering and restaurant".contains(tolower) || "9".contains(tolower))?"9"
                           :("clean and maid".contains(tolower) || "10".contains(tolower))?"10"
                           : ("consultant".contains(tolower)|| "11".contains(tolower))?"11"
                           :("customer service".contains(tolower) || "12".contains(tolower))?"12"
                           :("design".contains(tolower)||"13".contains(tolower))?"13"
                           :("education and training".contains(tolower)|| "14".contains(tolower))?"14"
                           :("finance".contains(tolower)|| "15".contains(tolower))?"15"
                           :("freight, delivery and warehouse".contains(tolower)|| "16".contains(tolower))?"16"
                           :("hotel and hospitality".contains(tolower) || "17".contains(tolower))?"17"
                           :("human resource".contains(tolower)|| "18".contains(tolower))?"18"
                           :("information technology".contains(tolower)|| "19".contains(tolower))?"19"
                           :("lawyer and legal service".contains(tolower) || "20".contains(tolower))?"20"
                           :("management".contains(tolower) || "21".contains(tolower))?"21"
                           :("manufacturing".contains(tolower)|| "22".contains(tolower))?"22"
                           :("mechandising and purchasing".contains(tolower) || "23".contains(tolower))?"23"
                           :("media and advertising".contains(tolower) || "24".contains(tolower))?"24"
                           :("medical, nurse and health".contains(tolower) || "25".contains(tolower))?"25"
                           :("operation".contains(tolower)||"26".contains(tolower))?"26"
                           :("project management".contains(tolower) || "27".contains(tolower))?"27"
                           :("resort and casino".contains(tolower) || "29".contains(tolower))?"29"
                           :("quality control".contains(tolower) || "28".contains(tolower))?"28"
                           :("sale".contains(tolower) || "30".contains(tolower))?"30"
                           :("security and driver".contains(tolower) || "31".contains(tolower))?"31"
                           :("technician".contains(tolower) || "32".contains(tolower))?"32"
                           :("telecommunication".contains(tolower) || "33".contains(tolower))?"33"
                           :("translation and interpretation".contains(tolower)||"34".contains(tolower))?"34"
                           :("travel agency".contains(tolower) || "35".contains(tolower))?"35"
                           :("other".contains(tolower) || "36".contains(tolower))?"36"
                           :("quit".contains(tolower) || "37".contains(tolower))?"37"
                           :"B sl o ";
                   switch (ternary){
                       case "1":
                           Account();
                           break;
                       case "2":
                           Admin();
                           break;
                       case "3":
                           Architect();
                           break;
                       case "4":
                       case "5":
                           Assis();
                           break;
                       case "6":
                           Audit();
                           break;
                       case "7":
                           Bank();
                           break;
                       case "8":
                           Cashier();
                           break;
                       case "9":
                           Cate();
                           break;
                       case "10":
                           Clean();
                           break;
                       case "11":
                           Consultant();
                           break;
                       case "12":
                           Customer();
                           break;
                       case "13":
                           desi();
                           break;
                       case "14":
                           Educ();
                           break;
                       case "15":
                           Fina();
                           break;
                       case "16":
                           Frieg();
                           break;
                       case "17":
                           Hotel();
                           break;
                       case "18":
                           Human();
                           break;
                       case "19":
                           Info();
                           break;
                       case "20":
                           law();
                           break;
                       case "21":
                           Manange();
                           break;
                       case "22":
                           Manufact();
                           break;
                       case "23":
                           Mechan();
                           break;
                       case "24":
                           Media();
                           break;
                       case "25":
                           Medical();
                           break;
                       case "26":
                           Operation();
                           break;
                       case "27":
                           Project();
                           break;
                       case "28":
                           QC();
                           break;
                       case "29":
                           Resort();break;
                       case "30":
                           Sal();
                           break;
                       case "31":
                           Security();break;
                       case "32":
                           Technic();
                           break;
                       case "33":
                           Telecom();
                           break;
                       case "34":
                           Translation();
                           break;
                       case "35":
                           Trave();
                           break;
                       case "36":
                           oth();
                           break;


                   }

               } while (!op.contains("37"));
               break;
               case "3":
                   do {
                       System.out.println("""
                               \n[1].Accounting\t\t\t\t[2].Adminstration\t\t\t\t[3].Architecture\t\t\t\t\t[4].Assistant\n
                           [5].Assistant\t\t\t\t[6].Audit and Taxation\t\t\t[7].Banking and Insurance\t\t\t[8].Cashier and Reception\n
                           [9].Catering and Resturant\t[10].Clean and Maid\t\t\t\t[11].Consultant\t\t\t\t\t\t[12].Customer Sercice\n
                           [13].Design\t\t\t\t\t[14].Education and Training\t\t[15].Finance\t\t\t\t\t\t[16].Freight, Delivery and Warehouse\n
                           [17].Hotel and Hospitality\t[18].Human Resource\t\t\t\t[19].Information Teachnology\t\t[20].Lawyer and Legal Service\n
                           [21].Management\t\t\t\t[22].Manufacturing\t\t\t\t[23].Mechandising and Purcharsing\t[24].Media and Advertising\n
                           [25].Medical, Nurse and Health\t[26].Operation\t\t\t\t[27].Project Management\t\t\t\t[28].Quality Control\n
                           [29].Resort and Casino\t\t[30].Sale\t\t\t\t\t\t[31].Security and Driver\t\t\t[32].Technician\n
                           [33].Telecommunication\t\t[34].Translation and Interpretation\t[35].Travel Agencyt\t\t\t\t[36].Other\n
                           [38].Quit
                           """);
                       System.out.println("You can Type as the serial Number:");
                       op=scan.nextLine();
                       String tolower=op.toLowerCase();
                       String ternary=("account".contains(tolower) || "1".contains(tolower))?"1"
                               :("adminstration".contains(tolower) || "2".contains(tolower))?"2"
                               :("architecture".contains(tolower)|| "3".contains(tolower))?"3"
                               :("assistant".contains(tolower)|| "4".contains(tolower))?"4"
                               :("assistant".contains(tolower)|| "5".contains(tolower))?"5"
                               :("audit and taxation".contains(tolower)|| "6".contains(tolower))?"6"
                               :("banking and Insurance".contains(tolower)|| "7".contains(tolower))?"7"
                               :("cashier and reception".contains(tolower) || "8".contains(tolower))?"8"
                               :("catering and restaurant".contains(tolower) || "9".contains(tolower))?"9"
                               :("clean and maid".contains(tolower) || "10".contains(tolower))?"10"
                               : ("consultant".contains(tolower)|| "11".contains(tolower))?"11"
                               :("customer service".contains(tolower) || "12".contains(tolower))?"12"
                               :("design".contains(tolower)||"13".contains(tolower))?"13"
                               :("education and training".contains(tolower)|| "14".contains(tolower))?"14"
                               :("finance".contains(tolower)|| "15".contains(tolower))?"15"
                               :("freight, delivery and warehouse".contains(tolower)|| "16".contains(tolower))?"16"
                               :("hotel and hospitality".contains(tolower) || "17".contains(tolower))?"17"
                               :("human resource".contains(tolower)|| "18".contains(tolower))?"18"
                               :("information technology".contains(tolower)|| "19".contains(tolower))?"19"
                               :("lawyer and legal service".contains(tolower) || "20".contains(tolower))?"20"
                               :("management".contains(tolower) || "21".contains(tolower))?"21"
                               :("manufacturing".contains(tolower)|| "22".contains(tolower))?"22"
                               :("mechandising and purchasing".contains(tolower) || "23".contains(tolower))?"23"
                               :("media and advertising".contains(tolower) || "24".contains(tolower))?"24"
                               :("medical, nurse and health".contains(tolower) || "25".contains(tolower))?"25"
                               :("operation".contains(tolower)||"26".contains(tolower))?"26"
                               :("project management".contains(tolower) || "27".contains(tolower))?"27"
                               :("resort and casino".contains(tolower) || "29".contains(tolower))?"29"
                               :("quality control".contains(tolower) || "28".contains(tolower))?"28"
                               :("sale".contains(tolower) || "30".contains(tolower))?"30"
                               :("security and driver".contains(tolower) || "31".contains(tolower))?"31"
                               :("technician".contains(tolower) || "32".contains(tolower))?"32"
                               :("telecommunication".contains(tolower) || "33".contains(tolower))?"33"
                               :("translation and interpretation".contains(tolower)||"34".contains(tolower))?"34"
                               :("travel agency".contains(tolower) || "35".contains(tolower))?"35"
                               :("other".contains(tolower) || "36".contains(tolower))?"36"
                               :"B sl o ";
                       switch (ternary){
                           case "1":
                              String ch;
                              do {
                                  System.out.println("""
                                       \n[1].Phnom Penh\t\t\t[2].Siem Reap\t\t\t[3].Battambang\t\t\t[4].Kampot\n
                                       [5].Kampong Cham\t\t[6].Kampong Chhnang\t\t\t[7].Pursat\t\t\t[8].Mondulkiri\n
                                       [9].Kandal\t\t\t[10].Kratie\t\t\t[11].Banteay Meanchey\t\t\t[12].Takeo\n
                                       [13].Pailin\t\t\t[14].Koh Kong\t\t\t[15].Kampong Thom\t\t\t[16].Kep\n
                                       [17].Ratanakiri\t\t\t[18].Stung Treng\t\t\t[19].Kampong Speu\t\t\t[20].Prey Veng\n
                                       [21].Preah Sihanouk\t\t\t[22].Svay Rieng\t\t\t[23].Preah Vihear\t\t\t[24].Tbong Kmoum\n
                                       [26].Quit\n
                                       Please Enter as serial number or name of location:
                                       """);
                                  ch=scan.nextLine();
                                  String ter=ch.toLowerCase();
                                  String t=("phnom penh".contains(ter) || "1".contains(ter))?"1"
                                          :("siem reap".contains(ter) || "2".contains(ter))?"2"
                                          :("battambang".contains(ter) || "3".contains(ter))?"3"
                                          :("kampot".contains(ter) || "4".contains(ter))?"4"
                                          :("kampong cham".contains(ter) || "5".contains(ter))?"5"
                                          :("kampong chhnang".contains(ter) || "6".contains(ter))?"6"
                                          :("pursat".contains(ter) || "7".contains(ter))?"7"
                                          :("mondulkiri".contains(ter) || "8".contains(ter))?"8"
                                          :("kandal".contains(ter) || "9".contains(ter))?"9"
                                          :("kratie".contains(ter) || "10".contains(ter))?"10"
                                          :("banteay meanchey".contains(ter) || "11".contains(ter))?"11"
                                          :("takeo".contains(ter) || "12".contains(ter))?"12"
                                          :("pailin".contains(ter) || "13".contains(ter))?"13"
                                          :("koh kong".contains(ter) || "14".contains(ter))?"14"
                                          :("kampong thom".contains(ter) || "15".contains(ter))?"15"
                                          :("kep".contains(ter) || "16".contains(ter))?"16"
                                          :("ratanakiri".contains(ter) || "17".contains(ter))?"17"
                                          :("stung treng".contains(ter) || "18".contains(ter))?"18"
                                          :("kampong speu".contains(ter) || "19".contains(ter))?"19"
                                          :("prey veng".contains(ter) || "20".contains(ter))?"20"
                                          :("preah sihanouk".contains(ter) || "21".contains(ter))?"21"
                                          :("svay rieng".contains(ter) || "22".contains(ter))?"22"
                                          :("preah vihear".contains(ter) || "23".contains(ter))?"23"
                                          :("tbong kmoum".contains(ter) || "24".contains(ter))?"24"
                                          :"27";
                                  switch (t) {
                                      case "1":
                                          Phnom();
                                          break;
                                      case "2":
                                          break;
                                      case "3":
                                          break;
                                      case "4":
                                          break;
                                      case "5":
                                          break;
                                          case "6":
                                          break;
                                          case "7":
                                          break;
                                          case "8":
                                          break;
                                          case "9":
                                          break;
                                      case "10":
                                          break;
                                      case "11":
                                          break;
                                      case "12":
                                          break;
                                      case "13":
                                          break;
                                      case "14":
                                          break;
                                      case "15":
                                          break;
                                      case "16":
                                          break;
                                      case "17":
                                          break;
                                      case "18":
                                          break;
                                      case "19":
                                          break;
                                      case "20":
                                          break;
                                      case "21":
                                          break;
                                      case "22":
                                          break;
                                      case "23":
                                          break;
                                      case "24":
                                          break;
                                  }


                              }while(!ch.equals("26"));
                               break;
                       }

                   } while (!op.contains("26"));
                   break;
               case "4":
                   System.out.println("Bye");
                   break;
               default:
                   System.out.println("Invalid Choice ");
                   System.out.println("Please Input again");
           }
       }while(!choice.contains("4"));
        System.out.println("B sl o Bye");
    }
}
