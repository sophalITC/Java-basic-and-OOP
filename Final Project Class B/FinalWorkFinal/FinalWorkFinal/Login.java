package FinalWorkFinal;

import java.util.Scanner;
public class Login extends ConnectDB {
    int AdminOrUser;
    String id;
    String email;
    String username;
    String password;
    Scanner input = new Scanner(System.in);
    public Login() {}
    public void inputData() {
        System.out.print("""
                    
                    >>> 1]. For Admin
                    >>> 2]. For User
                    
                """);
        System.out.print("Enter your choice: ");
        AdminOrUser = input.nextInt();
        input.nextLine();

        System.out.println("\n----------- Log In -----------");
        System.out.print("Enter your Username: ");
        username = input.nextLine();
        System.out.print("Enter your Password: ");
        password = input.nextLine();
    }
    public boolean CorrectInput() {
        inputData();
        boolean matched = false;
        try {
            String encrypted = MyAESAppEncDec.encrypt(password, secretKey);
            if (SearchData(AdminOrUser, this.username, encrypted)) {
                matched = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return matched;
    }
    public boolean ToLogin() {
        if (CorrectInput()) {
            System.out.println("\n\t>>> Login Successfully!");
            System.out.print("\t>>> Accessed Granted!\n\n");
            return true;
        } else {
            System.out.println("\n\t>>> Wrong Username or Password, Please Try Again!");
            System.out.print("\t>>> Accessed Denied!\n\n");
            return false;
        }
    }
    public String AdminORUser() {
        String type;
        if (AdminOrUser == 1) {
            type = "Admin";
        } else {
            type = "User";
        }
        return type;
    }
}

// Lay./333@$