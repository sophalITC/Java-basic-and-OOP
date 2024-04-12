package IDBC;
import java.util.Scanner;
public class Passwordcus {
		    public void login(){
		        Scanner scanner = new Scanner(System.in);
		        try(scanner){
		            System.out.printf("Enter username: ");
		            String username = scanner.nextLine();

		            System.out.printf("Enter password: ");
		            String password = scanner.nextLine();

		            if("Customer".equals(username)&&"12345678c".equals(password)){
		            	System.out.println("User Successfully loged-in...");
		            	Customer cu = new Customer();
				        cu.customer();
		                
		            }else{
		                System.out.println("In valid username of password ");
		                System.exit(0);
		            }

		        }
		    
		}
	}


