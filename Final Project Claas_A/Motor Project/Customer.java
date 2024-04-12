package IDBC;
import java.util.Scanner;
public class Customer {
	public void customer() {
		 Scanner input= new Scanner (System.in);
		 System.out.printf("\n\t\tYou want:\n\t\t1.View information\n\t\t2.Search infotmation");
         int i1=0;
         int o;
		 do {
		 System.out.print("\n\t\tEnter your option: ");
	     int m = input.nextInt();
	     if(m==1) {
	    	 View v1= new  View();
	    	 v1.view();
	     }
	     if(m==2) {
        Searching d1= new Searching();
        d1.SearchCus();
        
	     }
	     System.out.print("\n\t\tDo you want to do it again?(yes=1 / No=0.)");
	     System.out.print("\n\t\tEnter answer: ");
	     input.nextLine();
	     o = input.nextInt();
		 }while(i1!=o);
	     
   }
  
	}

