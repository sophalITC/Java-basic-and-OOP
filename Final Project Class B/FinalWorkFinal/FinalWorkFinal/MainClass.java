package FinalWorkFinal;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {                /* Main Method */
        MainClass main = new MainClass();
        if (main.LoggedIn()) {
            if (main.CheckAdminOrUser.equals("Admin")) {
                main.AdminMainSection();
            } else if (main.CheckAdminOrUser.equals("User")) {
                main.UserMainSection();
            }
        } else {
            System.out.println("\n\t>>> Access Denied!\n");
        }
    }

    // Methods and Attributes Declaration
    String CheckAdminOrUser;
    Scanner input = new Scanner(System.in);
    public boolean LoggedIn() {             /* Log In Section */
        boolean matched = false;
        Login login = new Login();
        SignUp signup = new SignUp();
        String choice = null;
        do {
            try {
                System.out.print("""
                            ----------- Menu -------------            
                            >>> 1. Login
                            >>> 2. Sign Up / Register
                            >>> 3. Exit\n
                        """);
                System.out.print("Select the option: ");
                choice = input.nextLine();
                switch (choice) {
                    case "1": {
                        matched = login.ToLogin();
                        CheckAdminOrUser = login.AdminORUser();
                    }
                    break;
                    case "2": {
                        signup.AddToDB();
                    }
                    break;
                    case "3": {
                        System.out.println("\n\t>>> THANK YOU FOR USING OUR MOTORCYCLE COMPARISON PRICE SYSTEM <3\n");
                        System.exit(0);
                    }
                    break;
                    default: {
                        System.out.println("\n\t>>> Invalid Input! Please Try Again!\n");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (matched == false);
        return true;
    }
    public void AdminMainSection() {                /* User Main Section */
        Add add = new Add();
        Display dis = new Display();
        Delete delete = new Delete();
        Search search = new Search();
        Update update = new Update();
        int option;
        do {
            System.out.println("""
                        >>> 1]. Insert Data into Database
                        >>> 2]. Display Data from Database
                        >>> 3]. Delete Data from Database
                        >>> 4]. Update Data in Database
                        >>> 5]. Search Data from Database
                        >>> 6]. Terminate Program!\n
                    """);
            System.out.print("Enter your choice: ");
            option = input.nextInt();
            switch (option) {
                case 1: {           // Insert
                    int n;
                    int no;
                    String motocode = null;
                    String motorseries = null;
                    String color = null;
                    String year = null;
                    String price = null;
                    String shoplocation = null;
                    String shopname = null;
                    String phonenumber = null;

                    System.out.println();
                    System.out.print("\t>>> How many new data you want to insert into database ? : ");
                    n = input.nextInt();

                    for (int i = 1; i <= n; i++) {
                        System.out.print("\nInput No: ");
                        no = input.nextInt();
                        input.nextLine();
                        System.out.print("Input Motor Code: ");
                        motocode = input.nextLine();
                        System.out.print("Input Motor Serie: ");
                        motorseries = input.nextLine();
                        System.out.print("Input Color: ");
                        color = input.nextLine();
                        System.out.print("Input Year: ");
                        year = input.nextLine();
                        System.out.print("Input Price: ");
                        price = input.nextLine();
                        System.out.print("Input Shop Location: ");
                        shoplocation = input.nextLine();
                        System.out.print("Input Shop Name: ");
                        shopname = input.nextLine();
                        System.out.print("Input Phone Number: ");
                        phonenumber = input.nextLine();
                        add.AddDatabase(
                                n, no, motocode, motorseries, color, year, price, shoplocation, shopname, phonenumber
                        );
                    }
                    if (n == 1) {
                        System.out.println("\n\t>>> " + n + " data has inserted successfully into database!\n");
                    } else if (n > 1) {
                        System.out.println("\n\t>>> " + n + " data have inserted successfully into database!\n");
                    } else if (n == 0) {
                        System.out.println("\n\t>>> You've inputed 0!? Please Try Again!\n");
                    }
                }
                break;
                case 2: {           // Display
                    System.out.println();
                    System.out.println("""
                                >>> 1]. Display without Sorting
                                >>> 2]. Display with Descending Sorting
                                >>> 3]. Display with Ascending Sorting
                            """);

                    int DisChoice;
                    System.out.print("Input your sorting choice: ");
                    DisChoice = input.nextInt();

                    if (DisChoice == 1) {
                        dis.NormalDisplayDatabase();
                    } else if (DisChoice == 2) {
                        dis.DESCDisplayDatabase();
                    } else if (DisChoice == 3) {
                        dis.ASCDisplayDatabase();
                    } else {
                        System.out.println("\n\t>>> Invalid Input! Please Try Again!\n");
                    }
                }
                break;
                case 3: {           // Delete
                    int n;
                    String DelMotoCode = null;
                    String DelMotoSeries = null;
                    String DelShopName = null;

                    System.out.println();
                    System.out.print("\t>>> How many new data you want to delete into database ? : ");
                    n = input.nextInt();

                    input.nextLine();
                    for (int i = 1; i <= n; i++) {
                        System.out.print("\nInput Motor Code you want to delete from database: ");
                        DelMotoCode = input.nextLine();
                        System.out.print("Input Motor Series you want to delete from database: ");
                        DelMotoSeries = input.nextLine();
                        System.out.print("Input Shop Name you want to delete from database: ");
                        DelShopName = input.nextLine();
                        delete.DeleteDatabase(n, DelMotoCode, DelMotoSeries, DelShopName);
                    }
                    if (n == 1) {
                        System.out.println("\n\t>>> " + n + " data has deleted successfully into database!\n");
                    } else if (n > 1) {
                        System.out.println("\n\t>>> " + n + " data have deleted successfully into database!\n");
                    } else if (n == 0) {
                        System.out.println("\n\t>>> You've inputed 0!? Please Try Again!\n");
                    }
                }
                break;
                case 4: {           // Update
                    int n = 0;
                    int no;
                    String motocode = null;
                    String motorseries = null;
                    String color = null;
                    String year = null;
                    String price = null;
                    String shoplocation = null;
                    String shopname = null;
                    String phonenumber = null;
                    String newphonenumber = null;

                    System.out.println();
                    System.out.print("\t>>> How many new data you want to update in database ? : ");
                    n = input.nextInt();

                    System.out.println();
                    for (int i = 1; i<= n; i++) {
                        System.out.println("\n----- New Information -----");
                        System.out.print("Input New No: ");
                        no = input.nextInt();
                        input.nextLine();
                        System.out.print("Input New Motor Code: ");
                        motocode = input.nextLine();
                        System.out.print("Input New Motor Serie: ");
                        motorseries = input.nextLine();
                        System.out.print("Input New Color: ");
                        color = input.nextLine();
                        System.out.print("Input New Year: ");
                        year = input.nextLine();
                        System.out.print("Input New Price: ");
                        price = input.nextLine();
                        System.out.print("Input New Shop Location: ");
                        shoplocation = input.nextLine();
                        System.out.print("Input New Shop Name: ");
                        shopname = input.nextLine();
                        System.out.print("Input New Phone Number: ");
                        newphonenumber = input.nextLine();

                        System.out.print("Input Old Moto Code: ");
                        phonenumber = input.nextLine();
                        update.UpdateInfo(
                                n, no, motocode, motorseries, color, year, price, shoplocation, shopname, newphonenumber, phonenumber
                        );
                    }
                    if (n == 1) {
                        System.out.println("\n\t>>> " + n + " data has updated successfully into database!\n");
                    } else if (n > 1) {
                        System.out.println("\n\t>>> " + n + " data have updated successfully into database!\n");
                    } else if (n == 0) {
                        System.out.println("\n\t>>> You've inputed 0!? Please Try Again!\n");
                    }
                }
                break;
                case 5: {                // Search
                    int choice;
                    String FindByMotoSeries, FindByMotoCode, ContainingString, FindLocation, FindPrice;
                    System.out.println();
                    System.out.println("""
                                >>> 1]. Search By Motor Series
                                >>> 2]. Search By Motor Code
                                >>> 3]. Search By Containing String in Data
                                >>> 4]. Search By MotorSeries and Location
                                >>> 5]. Search By Price (E.g. Below 2950)
                            """);

                    System.out.print("Enter your choice: ");
                    choice = input.nextInt();
                    
                    if (choice == 1) {
                        System.out.println();
                        input.nextLine();
                        System.out.print("Input Motor Series you want to search: ");
                        FindByMotoSeries = input.nextLine();
                        search.searchSeries(
                                FindByMotoSeries
                        );
                    } else if (choice == 2) {
                        System.out.println();
                        input.nextLine();
                        System.out.print("Input Specific Motor Code you want to search: ");
                        FindByMotoCode = input.nextLine();
                        search.searchCode(
                                FindByMotoCode
                        );
                    } else if (choice == 3) {
                        System.out.println();
                        input.nextLine();
                        System.out.print("Input Containing Motor Series you want to search: ");
                        ContainingString = input.nextLine();
                        search.searchAny(
                                ContainingString
                        );
                    } else if (choice == 4) {
                        System.out.println();
                        input.nextLine();
                        System.out.print("Input Motor Series you want to search: ");
                        FindByMotoSeries = input.nextLine();
                        System.out.print("Input Location or Province: ");
                        FindLocation = input.nextLine();
                        search.searchSeriesAndShop(
                                FindByMotoSeries, FindLocation
                        );
                    } else if (choice == 5) {
                        System.out.println();
                        input.nextLine();
                        System.out.print("Input Motor's Price you want to search: ");
                        FindPrice = input.nextLine();
                        search.searchWithPriceBelow(
                                FindPrice
                        );
                    } else {
                        System.out.println("\n\t>>> Invalid Input! Please Try Again!\n");
                    }
                }
                break;
                case 6: {         // Terminate Program
                    System.out.println("\n\t>>> THANK YOU FOR USING OUR MOTORCYCLE COMPARISON PRICE PROGRAM!\n");
                }
                break;
                default: {
                    System.out.println("\n\t>>> Invalid Input! Please Try Again!\n");
                }
                break;
            }
        } while (option != 6);
    }
    public void UserMainSection() {             /* User Main Section */
        Display dis = new Display();
        Search search = new Search();
        int option;
        do {
            System.out.println("""
                        >>> 1]. Display Data from Database
                        >>> 2]. Search Data from Database
                        >>> 3]. Terminate Program!
                    """);
            System.out.print("Enter your choice: ");
            option = input.nextInt();
            switch (option) {
                case 1: {           // Display
                    System.out.println();
                    System.out.println("""
                                >>> 1]. Display without Sorting
                                >>> 2]. Display with Descending Sorting
                                >>> 3]. Display with Ascending Sorting
                            """);

                    int DisChoice;
                    System.out.print("Input your sorting choice: ");
                    DisChoice = input.nextInt();

                    if (DisChoice == 1) {
                        dis.NormalDisplayDatabase();
                    } else if (DisChoice == 2) {
                        dis.DESCDisplayDatabase();
                    } else if (DisChoice == 3) {
                        dis.ASCDisplayDatabase();
                    } else {
                        System.out.println("\n\t>>> Invalid Input!!!\n");
                    }
                }
                break;
                case 2: {                // Search
                    int choice;
                    String FindByMotoSeries, FindByMotoCode, ContainingString, FindLocation, FindPrice;
                    System.out.println();
                    System.out.println("""
                                >>> 1]. Search By Motor Series
                                >>> 2]. Search By Motor Code
                                >>> 3]. Search By Containing String in Data
                                >>> 4]. Search By MotorSeries and Location
                                >>> 5]. Search By Price (E.g. Below 2950)
                            """);

                    System.out.print("Enter your choice: ");
                    choice = input.nextInt();

                    if (choice == 1) {
                        System.out.println();
                        input.nextLine();
                        System.out.print("Input Motor Series you want to search: ");
                        FindByMotoSeries = input.nextLine();
                        search.searchSeries(
                                FindByMotoSeries
                        );
                    } else if (choice == 2) {
                        System.out.println();
                        input.nextLine();
                        System.out.print("Input Specific Motor Code you want to search: ");
                        FindByMotoCode = input.nextLine();
                        search.searchCode(
                                FindByMotoCode
                        );
                    } else if (choice == 3) {
                        System.out.println();
                        input.nextLine();
                        System.out.print("Input Containing Motor Series you want to search: ");
                        ContainingString = input.nextLine();
                        search.searchAny(
                                ContainingString
                        );
                    } else if (choice == 4) {
                        System.out.println();
                        input.nextLine();
                        System.out.print("Input Motor Series you want to search: ");
                        FindByMotoSeries = input.nextLine();
                        System.out.print("Input Location or Province: ");
                        FindLocation = input.nextLine();
                        search.searchSeriesAndShop(
                                FindByMotoSeries, FindLocation
                        );
                    } else if (choice == 5) {
                        System.out.println();
                        input.nextLine();
                        System.out.print("Input Motor's Price you want to search: ");
                        FindPrice = input.nextLine();
                        search.searchWithPriceBelow(
                                FindPrice
                        );
                    } else {
                        System.out.println("\n\t>>> Invalid Input! Please Try Again!\n");
                    }
                }
                break;
                case 3: {         // Terminate Program
                    System.out.println("\n\t>>> THANK YOU FOR USING OUR MOTORCYCLE COMPARISON PRICE PROGRAM!\n");
                }
                break;
                default: {
                    System.out.println("\n\t>>> Invalid Input! Please Try Again!\n");
                }
                break;
            }
        } while (option != 3);
    }
}