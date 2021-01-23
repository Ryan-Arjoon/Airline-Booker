import java.util.Scanner;
import java.text.NumberFormat;

public abstract class Plane {
	//Data members
	//Variable to hold customer name, and the letter of their seat
	String name, coloumnLetter;
	//Variables to hold the ticket number, number of carry ons, number of baggage, location flying to, seat row number, and the column number
	int ticketNum, carryOn, baggage, locationNum, row, coloumnNum;
	//Variables to hold the total charge, and the baggage charge
	double total=0, baggageCharge=0;
	//Scanner
	Scanner input = new Scanner(System.in);
	//Object to format currency
	NumberFormat money = NumberFormat.getCurrencyInstance();
	//2D array to hold the available seats
	String seat[][] = {{"*","*","*","*","*","*"},{"*","*","*","*","*","*"},{"*","*","*","*","*","*"},{"*","*","*","*","*","*"},{"*","*","*","*","*","*"}};

	//Default Constructor
	public Plane(){

	}

	//Overloaded Constructor to store initial values
	public Plane(String n, int t, int l, int c, int b, int r, String col) {
		name = n;
		ticketNum = t;
		locationNum = l;
		carryOn = c;
		baggage = b;
		row = r;
		coloumnLetter = col;
	}

	//Method to display the seats on the airline
	public void displaySeat() {
		System.out.println("-----SEATS-----");
		System.out.println("\tA B C\tD E F");
		for(int x=0;x<seat.length;x++) {
			System.out.print("Row "+(x+1)+"\t");
			for(int y=0;y<seat[x].length;y++) {
				System.out.print(seat[x][y]+" ");
				if(y==2) {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}

	//Mutator Methods
	//Set the user name
	public void setName(String n){
		name = n;
	}
	//Set the ticket number
	public void setTicketNum(int n){
		ticketNum = n;
	}
	//Set the number of carry ons
	public void setCarryOn(int c) {
		carryOn = c;
	}
	//Set the number of baggage
	public void setBaggage(int b) {
		baggage = b;
	}
	//Set the location number
	public void setLocationNum(int l) {
		locationNum = l;
	}
	//Set the row number
	public void setRow(int r) {
		row = r;
	}
	//Set the column letter
	public void setColoumn(String c) {
		coloumnLetter = c;
	}
	//Set the column number
	public void setColoumnNum(int c) {
		coloumnNum = c;
	}
	//Set the total cost
	public void setTotal(double t) {
		total = t;
	}
	//Set the baggage charge
	public void setBaggageCharge(double b) {
		baggageCharge = b;
	}

	//Accessor Methods
	//Return user name
	public String getName(){
		return name;
	}
	//Return ticket number
	public int getTicketNum(){
		return ticketNum;
	}
	//Return number of carry ons
	public int getCarryOn() {
		return carryOn;
	}
	//Return the number of baggage
	public int getBaggage() {
		return baggage;
	}
	//Return the loation number
	public int getLocationNum() {
		return locationNum;
	}
	//Return the row number
	public int getRow() {
		return row;
	}
	//Return the column number
	public int getColoumnNum() {
		return coloumnNum;
	}
	//Return the column letter
	public String getColoumn() {
		return coloumnLetter;
	}
	//Return the total cost
	public double getTotal() {
		return total;
	}
	//Return the baggage charge
	public double getBaggageCharge() {
		return baggageCharge;
	}

	//Method to change the seat column letter to a number so it can be used in the array for displaying taken seats
	public void change() {
		//Change the seat letter to a number for use in the array 
		if(getColoumn().equalsIgnoreCase("a")) {
			setColoumnNum(1);
		}
		else if(getColoumn().equalsIgnoreCase("b")) {
			setColoumnNum(2);
		}
		else if(getColoumn().equalsIgnoreCase("c")) {
			setColoumnNum(3);
		}
		else if(getColoumn().equalsIgnoreCase("d")) {
			setColoumnNum(4);
		}
		else if(getColoumn().equalsIgnoreCase("e")) {
			setColoumnNum(5);
		}
		else if (getColoumn().equalsIgnoreCase("f")){
			setColoumnNum(6);
		}
		else {
			setColoumnNum(7);
		}
	}

	//Static method to display the overall airport information
	public static void AirportInfo() {
		System.out.println("----RYAN AIRPORT INFORMATION----");
		System.out.println("Below a menu will be displayed");
		System.out.println("You can pick to book a flight, changed booked flight info, and display booked flight info");
		System.out.println("You can book a flight with one of 3 airlines (Air Canada, American Airlines, Delta Airlines)");
		System.out.println("Each airline gets you to enter information about: name, ticket number, carry-ons, checking baggage, and seat location");
		System.out.println("Airlines offer their own unique sevice: Air Canada - Pet Allowance, American Airlines - First Class, Delta Airlines - Transportation");
		System.out.println("Each Airline has their own locations of travel");
		System.out.println("Customers will share the same plane with those on the same airline despite location");
		System.out.println("All flights are scheduled for 1 week from the date they were booked");
		System.out.println("-------------------------------------\n");
	}

	//Abstract method to calculate the total Cost
	public abstract void calculateTotal();
}
