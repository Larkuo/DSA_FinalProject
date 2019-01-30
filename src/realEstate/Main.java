package realEstate;

public class Main {
public static void main(String[] args) {
		
		realEstate set_1 = new realEstate();
		
		set_1.addCustomer();
		set_1.addCustomer();
		
		
		set_1.numCustomers();
		
		System.out.println(set_1.findCust());
		
		set_1.creditOrDeposit();
		
		set_1.displayAmountOwed();
		
		set_1.displayCustProperties();
		
		
		/*set_1.addNewLand();
		set_1.addNewLand();
		
		System.out.println(set_1.findLand());
		
		System.out.println(set_1.sellLand());
		
		System.out.println(set_1.addMorePlots());
		
		System.out.println(set_1.countLandPlots());
		
		Cust_1.addNewOwn();
		Cust_1.countOwn();*/
	}
}
