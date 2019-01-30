package realEstate;

import java.util.Scanner;

public class own {
	String location;
	int num_plots;
	int plotID;
	own nextOwn, prevOwn;
	public own() {
		
		//ASKS FOR LAND LOCATION 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the plot loaction: ");
		String location = sc.nextLine();
		this.location = location;
		
		//ASKS FOR NUMBER OF PLOTS AT THAT LOCATION
		Scanner scc = new Scanner(System.in);
		System.out.println("Enter the number of plots purchased by the customer: ");
		int plots = scc.nextInt();
		this.num_plots = plots;
		
		//ASKS FOR PROPERTY ID
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the property ID: ");
		int ID = s.nextInt();
		this.plotID = ID;
		
		prevOwn = null;
		nextOwn = null;
	}

}
