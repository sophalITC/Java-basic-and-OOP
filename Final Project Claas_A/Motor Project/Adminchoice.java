package IDBC;
import java.util.Scanner;
public class Adminchoice {
	  public void adminchoice() {
	  Scanner input= new Scanner(System.in);
	  
	  System.out.println("\n\t\tWhich one you prefer?\n\t\t1.Add information\n\t\t2.View information\n\t\t3.Update information\n\t\t4.Delete Information");
      int i;
      do {
	  System.out.print("\n\t\tEnter your answer: ");
      int an = input.nextInt();
        if(an==1) {
    	  
          Insert in= new Insert();
          in.insert();
    	  
      }if(an==2) {
    	  View v1= new  View();
	      v1.view();
      }if(an==3) {
    	  Update d =new Update();
    	  d.update();
      }
      if(an==4) {
    	  Delete d =new Delete();
    	  d.delete();
	     }
      
      System.out.printf("\n\t\tCome back to Information?(yes=1 / No=0.)");
      System.out.println("\n\t\tEnter answer: ");
      //System.out.println("\n\t\tWhich one you prefer?\n\t\t1.Add information\n\t\t2.View information\n\t\t3.Update information\n\t\t4.Delete Information");
      i=input.nextInt();
      }while(i!=0);
}
}
