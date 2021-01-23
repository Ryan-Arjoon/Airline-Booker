import java.util.InputMismatchException;
public class DeltaAir extends Plane implements information{
	//Declare variables
	//Static variable to hold the prices of each location
	static final int locationPrice[] = {490,1095,572,522};
	//Static variable to hold the location
	static final String locationName[] = {"Punta Cana","Santiago","Puerto Plata","Santo Domingo"}; 
	//Variable to store if user needs travel and the type of travel
	String travel;
	//Variables for the type of transit in the menu, and the transit cost
	int transport=0, transitCost=0;

	//Static method to display the location Delta Airlines can go
	public static void location() {
		System.out.println("----DELTA AIRLINES LOCATIONS (DESTINATIONS)----");
		System.out.println("   City\t\t\t\tAirport\t\t\t\t\t\tPrice");
		System.out.println("1. Punta Cana \t\t\tPunta Cana International Airport\t\t$490");
		System.out.println("2. Santiago de los Caballeros \tCibao International Airport\t\t\t$1095");
		System.out.println("3. Puerto Plata \t\tGregorio Luperón International Airport\t\t$572");
		System.out.println("4. Santo Domingo \t\tGeneral Andrews Airport\t\t\t\t$522");
	}

	//Method for user to select their type of transit
	public void transportation() {
		//Ask user if they need transit
		System.out.println("Would you like transportation when you land from the airport (y/n):");
		setTravel(input.next());
		//Check input is valid
		while(!getTravel().equalsIgnoreCase("y") && !getTravel().equalsIgnoreCase("n")) {
			System.out.println("Invalid Input\n");
			System.out.println("Would you like transportation when you land from the airport (y/n):");
			setTravel(input.next());
		}
		//Get user to choose their type of travel
		if(getTravel().equalsIgnoreCase("y")) {
			while(true) {
				System.out.println("   Transit \t\tPrice");
				System.out.println("1. Taxi\t\t\t$20");
				System.out.println("2. Train Pass\t\t$50");
				System.out.println("3. Car Rental\t\t$81");
				System.out.println("Enter your transit form (1-3):");
				try {
					setTransport(input.nextInt());
					//Check if input is valid
					while(getTransport() <1 || getTransport() >3) {
						System.out.println("Invalid Input\n");
						System.out.println("1. Taxi\t\t$20");
						System.out.println("2. Train Pass\t\t$50");
						System.out.println("3. Car Rental\t\t$81");
						System.out.println("Enter your transit form (1-3):");
						setTransport(input.nextInt());
					}
					break;
				}
				//Check for exception
				catch(InputMismatchException e) {
					System.out.println("You entered bad data");
					System.out.println("Please try again\n");
					String flush = input.next();
				}
			}

			//Set the travel based on what is picked
			if(getTransport()==1) {
				setTravel("Taxi");
			}
			else if(getTransport()==2) {
				setTravel("Train Past");
			}
			else {
				setTravel("Car Rental");
			}
		}
		//If user does not want transportation
		else {
			setTravel("NO");
		}
	}

	//Mutator methods
	//Set the type of travel
	public void setTravel(String t) {
		travel = t;
	}
	//Set the number related to the type of travel
	public void setTransport(int t) {
		transport = t;
	}
	//Set the cost of transit
	public void setTransitCost(int t) {
		transitCost = t;
	}

	//Accessor Methods
	//Return the type of travel
	public String getTravel(){
		return travel;
	}
	//Return the number of the travel type
	public int getTransport() {
		return transport;
	}
	//Return the cost of transit
	public int getTransitCost() {
		return transitCost;
	}

	//Override abstract method to display Delta Airlines regulations
	public void print() {
		System.out.println("----DELTA AIRLINES REGULATIONS----");
		System.out.println("Carry Ons Allowed: 2");
		System.out.println("Baggage Weight Limit: 60lbs");
		System.out.println("1st bag: $45");
		System.out.println("Each additional bag: $52.91");
		System.out.println("Pets: Not Permitted");
		System.out.println("First Class: N/A");
		System.out.println("Transportation: Offered");
	}

	//Override abstract method to calculate the total profit
	public void calculateTotal() {
		//Get the baggage charge based on the number of baggage
		if(super.getBaggage()==1) {
			super.setBaggageCharge(45);
		}
		else if(super.getBaggage()>=2) {
			super.setBaggageCharge(45+((super.getBaggage()-1)*52.91));
		}
		//Calculate the transit cost based on transit picked
		if(getTransport()==1) {
			setTransitCost(20);
		}
		else if(transport==2) {
			setTransitCost(50);
		}
		else if(transport ==3){
			setTransitCost(81);
		}
		//Calculate the total charge
		setTotal(locationPrice[(super.getLocationNum()-1)]+baggageCharge+transitCost+baseCharge);
	}

	//Override abstract method for displaying the charges applied to each customer
	public void displayCharges() {
		System.out.println("Base Charge: \t\t"+money.format(baseCharge));
		System.out.println("Baggage Charge: \t"+money.format(super.getBaggageCharge()));
		System.out.println("Transit Charge: \t"+money.format(getTransitCost()));
		System.out.println("Location Charge: \t"+money.format(locationPrice[(getLocationNum()-1)]));
		System.out.println("Total Charge: \t\t"+money.format(super.getTotal()));
	}
}
