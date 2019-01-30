package realEstate;
import java.util.Scanner;

public class realEstate {
	Land root;
	customer[] custData;
	
	
	//A CONSTURCTOR FOR THE REALESTATE CLASS ***SORTS ALL DATA ACCORDING TO MONTHS
	public realEstate() {
		Scanner scc = new Scanner(System.in);
		System.out.println("Please enter the month in capitals...");
		String month = scc.nextLine();
		System.out.println("Happy New month!!! It's " + month);
		customer[] processing = new customer[30]; //There can be a maximum of 30 customers per month
		this.custData = processing;
	}
	
	
	//CUSTOMER METHODS
	//No. 1: NUM_CUSTOMERS ***COUNT THE NUMBER OF CUSTOMERS IN A MONTH
	public int numCustomers() {
		int count = 0;
		for(int i = 0; i < custData.length;i ++) {
			if(custData[i] != null) {
				count = count + 1;
			}
		}
		System.out.println("Current number of customer(s): " + count);
		return count;
	}
	//No. 2: ADD_CUSTOMER
	public customer addCustomer(){
		customer newCust = new customer();
		custData[numCustomers()] = newCust;
		return newCust;
	}
	//No. 3: FIND CUSTOMER
	public customer findCust() {
		customer searchCust = null;
		//ASKS FOR THE CUSTOMER'S NAME
		Scanner scc = new Scanner(System.in);
 		System.out.println("Enter the search customer's full name: "); 
 		String the_name = scc.nextLine();
 		for(int i = 0; i < numCustomers();i++) {
 			if(custData[i].cust_Name == the_name) {
 				searchCust = custData[i];
 			}
 		}
 		//System.out.println(searchCust.cust_Name + " ID: " + searchCust.cust_No);
 		return searchCust;
	}
	//No. 4: CHANGE AMOUNT OWED
	public double creditOrDeposit() {
		customer focusCust = findCust();
		//ASKS FOR THE AMOUNT
		Scanner sc = new Scanner(System.in);
 		System.out.println("Enter the amount in cedis: "); 
 		int amount = sc.nextInt(); 
 		//ASKS IF IT'S A DEBIT OR CREDIT
 		Scanner scc = new Scanner(System.in);
 		System.out.println("Is it payment or sale? ");
 		String type = scc.nextLine();
 		if(type == "payment") {
 			focusCust.amountOwed = focusCust.amountOwed - amount;
 			System.out.println(amount + " has just been debited to "+ focusCust.cust_Name);
 		}else {
 			focusCust.amountOwed = focusCust.amountOwed + amount;
 			System.out.println(amount + " has just been credited to "+ focusCust.cust_Name);
 		}
 		return focusCust.amountOwed;
	}
	//No. 5: DISPLAY AMOUNT OWED
	public void displayAmountOwed() {
		customer focusCust = findCust();
		System.out.println("The customer " + focusCust.cust_Name + " owes " + focusCust.amountOwed + " ghana cedis");
	}
	//No. 6: DISPLAY CUSTOMER PROPERTIES
	public void displayCustProperties() {
		customer focusCust = findCust();
		System.out.println(focusCust.cust_Name + "owns the following property: ");
		//*** display each own property's location and number of plots
		if(focusCust.property.length != 0) {
			for(own x:focusCust.property) {
				System.out.println("plot number "+x.plotID + "which has "+ x.num_plots + " at " + x.location);
			}
		}else {System.out.println("The customer has no recorded property with us!");}
	}
	//END OF CUSTOMER METHODS
	
	//LAND METHODS
	//No. 1: ADD NEW LAND
	public Land addNewLand() {
		Land newland = new Land();
		Land focusLand = null;
		if(root == null) {
			newland = focusLand;
		}else {
			if(focusLand.cost <= newland.cost) {
				focusLand = focusLand.leftLand;
				if(focusLand == null) {
					focusLand = newland;
				}else {
					addNewLand();
				}
			}else {
				focusLand = focusLand.rightLand;
				if(focusLand == null) {
					focusLand = newland;
				}else {
					addNewLand();
				}
			}
		}
		return newland;
	}
	//No. 2: FIND LAND
	public Land findLand() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the price point ");
		int price = s.nextInt();
		Land focus = root;
		if(focus == null || focus.cost == price) {
			return root;
		}
		if(root.cost > price) {
			focus = focus.leftLand;
			return findLand();
		}else {
			focus = focus.rightLand;
			return findLand();
		}
	}
	//No. 3: REMOVE PLOTS/SELL LAND
	public int sellLand() {
		Land focusLand = findLand();
		Scanner ss = new Scanner(System.in);
		System.out.print("Please enter number of plots being sold ");
		int numplots = ss.nextInt();
		
		focusLand.plots = focusLand.plots - numplots;
		System.out.print(numplots + " have just been sold at "+focusLand.location);
		return numplots;
	}
	//No. 4: CHECK REMAINING PLOTS
	public int countLandPlots() {
		Land focusLand = findLand();
		return focusLand.plots;
		
	}
	//No. 5: ADD MORE PLOTS TO EXISTING SITES
	public int addMorePlots() {
		Land focusLand = findLand();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of extra plots: ");
		int addPlot = s.nextInt();
		
		focusLand.plots = focusLand.plots + addPlot;
		System.out.println(addPlot + " new plot(s)");
		return addPlot;
	}
}
