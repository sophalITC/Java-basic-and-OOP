package IDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Project {
	public static void main(String[] args){
		
		Info in1 = new Info();
		in1.info();
		System.out.printf("\n\t\t******************************************************************************************************************\n");
		Scanner input = new Scanner(System.in);
		int i;
	      do{
	    	  System.out.println("\n\t\t***********************You are:*********************** ");
		        System.out.println("\n\t\t\t\t1.Admin\n\t\t\t\t2.Customer\n\t\t******************************************************");
		        System.out.println("Enter you answer: ");
		        int n = input.nextInt();
		        if(n==1) {
		            System.out.print("\n*****************************welcome to admin part*****************************\n");
		            System.out.println("\n\t\t1.Log in\n\t\t2.Exist");
		            System.out.print("\n\t\tEnter your option: ");
		            int an = input.nextInt();
		        	 if(an==1) {
		   	          Passwordad ad1 = new Passwordad();
		   	          ad1.login();
		   	          
		        	 }else {
		        		 System.exit(0);
		        	 }
		        }else if(n==2) {
		            	System.out.print("\n*****************************welcome to Customer part*****************************\n");
		 	            System.out.println("\n\t\t1.Log in\n\t\t2.Exist");
		 	            System.out.print("\n\t\tEnter your option: ");
			            int ch = input.nextInt();
			            if(ch==1) {
		            	 Passwordcus cu1= new Passwordcus();
		            	 cu1.login(); 	
			            }else {
			            	System.exit(0);
			            }
		        }else {
		        	System.exit(0);
		        }
	        
	    	 
		     //input.nextLine();
	         System.out.print("\n\t\tDo you want to come back home?(yes=0 / No=1.): ");
	         System.out.print("\n\t\tEnter answer: ");
		     i=input.nextInt();
	      	}while(i!=1);    
	      
	}
}
