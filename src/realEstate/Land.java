package realEstate;

import java.util.Scanner;

public class Land {
	int cost;
	String location;
	int plots;
	public Land leftLand;
	public Land rightLand;
	public Land() {
		this.leftLand = null;
		this.rightLand = null;
		
		//ASKS FOR THE NEW LAND LOCATION
		Scanner sc1 = new Scanner(System.in);
 		System.out.println("Enter the land location: "); 
 		String name = sc1.nextLine(); 
		this.location = name;
		
		
		//ASKS FOR THE NEW LAND COST
		Scanner sc2 = new Scanner(System.in);
 		System.out.println("Enter the land selling price: "); 
 		int number = sc2.nextInt(); 
		this.cost = number;
		
		//ASKS FOR THE NEW LAND PLOTS NUMBER
		Scanner sc3 = new Scanner(System.in);
 		System.out.println("Enter number of plots up for sale: "); 
 		int plotss = sc3.nextInt(); 
		this.plots = plotss;
		
		System.out.println("You have documented new available land at " + location + " which goes for " + cost + " cedis per plot with " + plots +" plots up for sale");
		
	}
}
