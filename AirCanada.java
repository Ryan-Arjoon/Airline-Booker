import java.util.InputMismatchException;
public class AirCanada extends Plane implements information{
	//Create Variables
	//Variable array to hold the prices of different locations
	static final int locationPrice[] = {447,477,285,565};
	//Static variable to hold the prices of each location
	static final String locationName[] = {"Calgary","Regina","Vancouver","Halifax"};
	//Array to store the type of pets
	String petType[];
	//Variables to store the number of pets, and the charge for the pets
	int numPets, petCharge=0;

	//Default Constructor
	public AirCanada(){

	}

	//Overloaded Constructor to store initial values
	public AirCanada(String n, int t, int l, int c, int b, int r, String col, int np) {
		name = n;
		ticketNum = t;
		locationNum = l;
		carryOn = c;
		baggage = b;
		row = r;
		coloumnLetter = col;
		numPets = np;
	}

	//Static method to display the locations Air Canada can go
	public static void location(){
		System.out.println("----AIR CANADA LOCATIONS (DESTINATIONS)----");
		System.out.println("   City\t\tAirport\t\t\t\t\t\tPrice");
		System.out.println("1. Calgary \tCalgary International Airport\t\t\t$447");
		System.out.println("2. Regina \tRegina International Airport\t\t\t$477");
		System.out.println("3. Vancouver \tVancouver International Airport\t\t\t$285");
		System.out.println("4. Halifax \tHalifax Stanfield International Airport\t\t$565");
	}

	//Method for users to enter their pet information
	public void Pet() {
		//Ask the user how many pets they have
		while(true) {
			System.out.println("How many pets will you be traveling with:");
			try {
				setNumPets(input.nextInt());
				//Ensure input is valid
				while(getNumPets()<0) {
					System.out.println("Invalid Input\n");
					System.out.println("How many pets will you be traveling with:");
					setNumPets(input.nextInt());
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
		//Array to store the different pet types
		if(getNumPets()>0){
			petType = new String[getNumPets()];
		}
		else {
			petType = new String[1];
		}

		//If they have pets have the user enter the type of each pet
		if(getNumPets()>0) {
			for(int i=0;i<getNumPets();i++) {
				System.out.println("Enter the type of pet "+(i+1)+":");
				setPetType(input.next(),i);
			}
		}
		//If they have no pets set not applicable
		else {
			petType[0] = "N/A";
		}
	}

	//Mutator Methods
	//Set the pet type
	public void setPetType(String p, int i){
		petType[i] = p;
	}
	//Set the number of pets
	public void setNumPets(int n) {
		numPets = n;
	}
	//Set the charge of pets
	public void setPetCharge(int p) {
		petCharge = p;
	}

	//Accessor methods
	//Return the type of pet
	public String getPetType(int i) {
		return petType[i];
	}
	//Return the number of pets
	public int getNumPets() {
		return numPets;
	}
	//Return the pet charge
	public int getPetCharge() {
		return petCharge;
	}

	//Override abstract method to display airline regulations
	public void print() {
		System.out.println("----AIR CANADA REGULATIONS----");
		System.out.println("Carry Ons Allowed: 3");
		System.out.println("Baggage Weight Limit: 50lbs");
		System.out.println("1st bag: $31.50");
		System.out.println("2nd bag: $52.50");
		System.out.println("Each additional bag: $105.00");
		System.out.println("Pets: Permitted");
		System.out.println("Charge per pet: $50");
		System.out.println("First Class: N/A");
		System.out.println("Transportation: Not Offered");
	}

	//Override abstract method to calculate the total profit
	public void calculateTotal() {
		//Get the baggage charge based on number of bags
		if(super.getBaggage()==1) {
			super.setBaggageCharge(31.50);
		}
		else if(super.getBaggage()==2) {
			super.setBaggageCharge(31.50+52.50);
		}
		else if(super.getBaggage()>=3) {
			super.setBaggageCharge(31.50+52.50+((super.getBaggage()-2)*52.50));
		}

		//Get the pet charge based on the number of pets
		setPetCharge(50*numPets);

		//Calculate the total charge
		super.setTotal(locationPrice[(super.getLocationNum())-1]+petCharge+baggageCharge+baseCharge);
	}

	//Override abstract method for displaying the charges applied to each customer
	public void displayCharges() {
		System.out.println("Base Charge: \t\t"+money.format(baseCharge));
		System.out.println("Baggage Charge: \t"+money.format(super.getBaggageCharge()));
		System.out.println("Pet Charge: \t\t"+money.format(getPetCharge()));
		System.out.println("Location Charge: \t"+money.format(locationPrice[(getLocationNum()-1)]));
		System.out.println("Total Charge: \t\t"+money.format(super.getTotal()));
	}
}
