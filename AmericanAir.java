public class AmericanAir extends Plane implements information{
	//Declare Variables
	//Variable for first class charge
	int firstClassCharge=0;
	//Static variable to hold the prices of each location
	static final int locationPrice[] = {396,296,610,571};
	//Static variable to hold the locations
	static final String locationName[] = {"Boston","Chicago","Pittsburgh","New York"}; 
	//Variable to hold if they are flying first class
	String firstClass;

	//Static method to display the locations American Airline can go
	public static void location(){
		System.out.println("----AMERICAN AIRLINES LOCATIONS (DESTINATIONS)----");
		System.out.println("   City\t\t\tAirport\t\t\t\t\t\tPrice");
		System.out.println("1. Boston \t\tBaltimore-Washington International Airport\t$396");
		System.out.println("2. Chicago \t\tO'Hare International Airport\t\t\t$296");
		System.out.println("3. Pittsburgh \t\tPittsburgh International Airport\t\t$610");
		System.out.println("4. New York City \tJohn F. Kennedy International Airport\t\t$571");
	}

	//First class method to ask user if they are flying first class
	public void firstClass() {
		//Ask user if they are flying first class
		System.out.println("First Class Benefits: Extra Space, free food and beverage service, and private suite");
		System.out.println("Charge: $200");
		System.out.println("Will you be flying first class(y/n):");
		setFirstClass(input.next());
		//Account for user input error
		while(!getFirstClass().equalsIgnoreCase("y") && !getFirstClass().equalsIgnoreCase("n")) {
			System.out.println("Input Invalid\n");
			System.out.println("First Class Benefits: Extra Space, free food and beverage service, and private suite");
			System.out.println("Charge: $200");
			System.out.println("Will you be flying first class(y/n):");
			setFirstClass(input.next());
		}
		//Set the first class variable if they are flying first class
		if(firstClass.equalsIgnoreCase("y")) {
			setFirstClass("YES");
		}
		//Set the first class variable if they are not flying first class
		else {
			setFirstClass("NO");
		}
	}

	//Mutator Methods
	//Set the value if the user is flying first class
	public void setFirstClass(String f) {
		firstClass = f;
	}
	//Set the charge of the first class
	public void setFirstClassCharge(int f) {
		firstClassCharge = f;
	}

	//Accessor methods
	//Return the value if user is first class
	public String getFirstClass() {
		return firstClass;
	}
	//Return the charge of first class
	public int getFirstClassCharge() {
		return firstClassCharge;
	}

	//Override abstract method to display regulations
	public void print() {
		System.out.println("----AMERICAN AIRLINES REGULATIONS----");
		System.out.println("Carry Ons Allowed: 2");
		System.out.println("Baggage Weight Limit: 55lbs");
		System.out.println("1st bag: $30");
		System.out.println("2nd bag: $40");
		System.out.println("Each Additional Bag: $150");
		System.out.println("Pets: Not Permitted");
		System.out.println("First Class: Optional $200");
		System.out.println("Transportation: Not Offered");
	}

	//Override abstract method to calculate the total profit
	public void calculateTotal() {
		//Get the baggage charge based on the number of baggage
		if(super.getBaggage()==1) {
			setBaggageCharge(30);
		}
		else if(super.getBaggage()==2) {
			setBaggageCharge(40);
		}
		else if (super.getBaggage()>=3){
			setBaggageCharge(30+40+((super.getBaggage()-2)*150));
		}
		//Set the first class charge
		if(getFirstClass().equals("YES")) {
			setFirstClassCharge(200);
		}
		//Calculate the total charge
		setTotal(locationPrice[(super.getLocationNum()-1)]+baggageCharge+firstClassCharge+baseCharge);
	}

	//Override abstract method for displaying the charges applied to each customer
	public void displayCharges() {
		System.out.println("Base Charge: \t\t"+money.format(baseCharge));
		System.out.println("Baggage Charge: \t"+money.format(super.getBaggageCharge()));
		System.out.println("First Class Charge: \t"+money.format(getFirstClassCharge()));
		System.out.println("Location Charge: \t"+money.format(locationPrice[(getLocationNum()-1)]));
		System.out.println("Total Charge: \t\t"+money.format(super.getTotal()));
	}
}
