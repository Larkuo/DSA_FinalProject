package realEstate;

import java.util.Scanner;

public class customer {
	String cust_Name; 
	int cust_No;
	double amountOwed;
	own[] property;
	//A CONSTRUCTOR METHOD TO CREATE NEW CUSTOMER OBJECTS
	public  customer() {
		//ASKS FOR THE NEW CUSTOMER'S ID
		Scanner sc = new Scanner(System.in);
 		System.out.println("Enter the customer ID: "); 
 		int number = sc.nextInt(); 
		this.cust_No = number;
		
		//ASKS FOR THE NEW CUSTOMER'S NAME
		Scanner scc = new Scanner(System.in);
 		System.out.println("Enter the new customer's full name: "); 
 		String name = scc.nextLine(); 
		this.cust_Name = name;
		
		amountOwed = 0.0;//SETS AMOUNT OWED TO 0.00 TILL NEW LAND IS BOUGHT
		own[] property = new own[10];//SETS PROPERTY TO AN EMPTY ARRAY WITH A MAX OF 10 TILL NEW PROPERTY IS BOUGHT
		
		System.out.println("New customer registered!! Welcome to the BTC Estates family! :)");//PRINTS A WELCOME MESSAGE FOR THE NEW CUSTOMER
	}
	
	//OWN METHODS
	//No. 1: ADD NEW OWN
	public own addNewOwn() {
		own newOwn = new own();
		property[countOwn()] = newOwn;
		return newOwn;
	}
	//No. 2: FIND OWN
	public own findOwn() {
		own focus = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the property ID: ");
		int ID = s.nextInt();
		
		for(own x:property) {
			if(x.plotID == ID) {
				focus = x;
			}else {
				focus = null;
			}
		}
		return focus;
	}
	//No. 3: NUMBER OF OWNS
	public int countOwn() {
		int count = 0;
		for(own x:property) {
			if(x != null) {
				count = count ++;
			}
		}
		System.out.println(count);
		return count;
	}
}
