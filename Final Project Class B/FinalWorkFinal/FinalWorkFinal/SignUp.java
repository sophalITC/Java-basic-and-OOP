package FinalWorkFinal;

import java.sql.SQLException;
public class SignUp extends Login {
    public SignUp() {}
    @Override
    public void inputData() {
        System.out.print("""
                
                    >>> 1]. For Admin
                    >>> 2]. For User
                
                """);
        System.out.print("Enter your choice: ");
        AdminOrUser = input.nextInt();
        input.nextLine();
        System.out.println("\n----------- Sign Up -----------");
        System.out.print("Enter your ID: ");
        id = input.nextLine();
        System.out.print("Enter your Username: ");
        username = input.nextLine();
        System.out.print("Enter your Email: ");
        email = input.nextLine();
        System.out.print("Enter your Password: ");
        password = input.nextLine();
    }
    public void AddToDB() {
        inputData();
        try {
            SignUpInsert(AdminOrUser, id, username, email, password);
            System.out.println("\n\t>>> Signed Up Successfully!\n");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

// LayGgWp@333