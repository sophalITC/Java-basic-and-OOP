package IDBC;
import java.util.Scanner;
public class Passwordad {
	    public void login(){
	        Scanner scanner = new Scanner(System.in);
	        try(scanner){
	            System.out.printf("Enter username: ");
	            String username = scanner.nextLine();

	            System.out.printf("Enter password: ");
	            String password = scanner.nextLine();

	            if("Lun Tola".equals(username)&&"tota123".equals(password)){
	                System.out.println("User Successfully loged-in...");
	                Adminchoice a1= new Adminchoice();
		   	        a1.adminchoice();
	            }else if("chorn lekhena".equals(username)&&"lekhena".equals(password)){
	                System.out.println("User Successfully loged-in...");
	                Adminchoice a1= new Adminchoice();
		   	        a1.adminchoice();
	            }else{
	                System.out.println("In valid username of password ");
	                System.exit(0);
	            }
	            

	        }
	       
	}
}
