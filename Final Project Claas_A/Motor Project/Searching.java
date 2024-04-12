package IDBC;
import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class Searching {
	 public void SearchCus()
	    {   
		    System.out.print("\n\n\t\t**********-----______ WELCOME TO SEARCHING INFORMATION MOTOR _____-----**********\n");
		 	System.out.printf("\n\t\tYou search information of motor by: ");
		 	System.out.printf("\n\t\t*************************\n\t\t*\t1.ID\t\t*\n\t\t*\t2.Shop\t\t*\n\t\t*\t3.Model\t\t*\n\t\t*\t4.Year\t\t*\n\t\t*\t5.Price\t\t*\n\t\t*************************\n");
		    Scanner input= new Scanner (System.in);
		    int i;
		    do {
		 	System.out.printf("\n\t\t=======>Enter your choice: ");
		 	int n = input.nextInt();
	        Search connection = new Search();
		    Connection con = null;
	        PreparedStatement p = null;
	        ResultSet rs = null;
	        con = connection.Search();
	        try {
	        	 if(n==1){
	            System.out.printf("\n\t\tThis Progress you search motor by ID to see infotmation of Motor" );
	            
	            System.out.printf("\n\t\t------->Enter ID: " );
	            int id = input.nextInt();
	            String query= "select ID,Shop,Model,Year,Price from project where ID =?";
	            p = con.prepareStatement(query);
	            p.setInt(1, id);
	            rs = p.executeQuery();
	        	 
	        	 }if(n==2) {
	     	            System.out.printf("\n\t\tThis Progress you search motor by shop to see infotmation of Motor" );
	     	            System.out.printf("\n\t\t------->Enter Shop: " );
	     	            String dd = input.nextLine();
	     	            String shop = input.nextLine();
	     	            String query
	     	                = "select ID,Shop,Model,Year,Price from project where Shop = ?";
	     	            p = con.prepareStatement(query);
	     	            p.setString(1, shop);
	     	            rs = p.executeQuery();
	        	 }if(n==3) {
	     	            System.out.printf("\n\t\tThis Progress you search motor by price to see infotmation of Motor" );
	     	            System.out.printf("\n\t\t------->Enter Price: " );
	     	            String dd = input.nextLine();
	     	            String model= input.nextLine();
	     	            String query= "select ID,Shop,Model,Year,Price from project where Model = ?";
	     	            p = con.prepareStatement(query);
	     	            p.setString(1, model);
	     	            rs = p.executeQuery();
	        	 }if(n==4) {
 	            System.out.printf("\n\t\tThis Progress you search motor by year to see infotmation of Motor" );
 	            System.out.printf("\n\t\t------->Enter year: " );
 	            String dd = input.nextLine();
 	            int year = input.nextInt();
 	            String query= "select ID,Shop,Model,Year,Price from project where Year = ?";
 	            p = con.prepareStatement(query);
 	            p.setInt(1, year);
 	            rs = p.executeQuery();
    	 }
	        	 if(n==5) {
	     	            System.out.printf("\n\t\tThis Progress you search motor by price to see infotmation of Motor" );
	     	            System.out.printf("\n\t\t------->Enter Price: " );
	     	            String dd = input.nextLine();
	     	            int price = input.nextInt();
	     	            String query= "select ID,Shop,Model,Year,Price from project where Price = ?";
	     	            p = con.prepareStatement(query);
	     	            p.setInt(1, price);
	     	            rs = p.executeQuery();
	        	 }
	                System.out.println( "\n\t\t********************************************************************************\n\t\t\tID\t\tShop\t\tModel\t\tYear\t\tPrice\n\t\t********************************************************************************");
	         	    if (rs.next()) {
	                int ID = rs.getInt("ID");
	                String Shop = rs.getString("Shop");
	                String Model = rs.getString("Model");
	                int Year = rs.getInt("Year");
	                int Price = rs.getInt("Price");
	              System.out.println( "\t\t\t" + ID + "\t\t" + Shop + "\t\t"+ Model+ "\t\t"+Year+"\t\t"+Price);
	              System.out.println("\n\t\t********************************************************************************\t\n");
	            }
	        }
	 
	        catch (SQLException e) {
	 
	        System.out.println(e);
	        }
	        System.out.printf("\t\tDo you want to do it again?(yes=1 / No=0.)");
	        System.out.println("\n\t\tEnter answer: ");
	        i=input.nextInt();
	              }while(i!=0);
	    }

}
