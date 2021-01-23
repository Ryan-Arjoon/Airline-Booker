import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.NumberFormat;
public class PlaneMain {

	public static void main(String[] args) {
		//Declare variables
		//Scanner
		Scanner input = new Scanner(System.in);
		//Object to format currency
		NumberFormat money = NumberFormat.getCurrencyInstance();
		//Variables for the total profits of each airline
		double CanadaProfit, AmericanProfit, DeltaProfit;
		//Variables for choosing the menu option, choosing airline, and counter to count the number of each booked airline flight
		int choice, can=0, amer=0, delt=0, airline;

		//Create objects of each airline, size 30 because that is the maximum number of seats
		AirCanada a[] = new AirCanada[30];
		AmericanAir am[] = new AmericanAir[30];
		DeltaAir d[] = new DeltaAir[30];

		//Display the airports information
		Plane.AirportInfo();

		//Loop until the user exits
		do {
			//Reset the totals when the loop starts
			CanadaProfit=0;
			AmericanProfit=0;
			DeltaProfit=0;

			//Display menu and get input for menu
			while(true) {
				System.out.println("----RYAN AIRPORT MAIN MENU----");
				System.out.println("1. Book A Flight");
				System.out.println("2. Display the Total Profits of each Airline");
				System.out.println("3. Display All Booked Flights");
				System.out.println("4. Exit");
				System.out.println("Enter your choice (1-4):");
				try{
					choice = input.nextInt();
					//Check input is invalid
					while(choice <1 || choice >4) {
						System.out.println("Invalid Input\n");
						System.out.println("----RYAN AIRPORT MAIN MENU----");
						System.out.println("1. Book A Flight");
						System.out.println("2. Display the Total Profits of each Airline");
						System.out.println("3. Display All Booked Flights");
						System.out.println("4. Exit");
						System.out.println("Enter your choice (1-4):");
						choice = input.nextInt();
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

			//If 1 is picked book a flight
			if(choice ==1) {
				//Run if there are flights remaining
				if(a.length==30&&am.length==30&&d.length==30) {
					//Choose an Airline menu and get user input
					while(true) {
						System.out.println("----AIRLINES----");
						System.out.println("1. Air Canada");
						System.out.println("2. American Airlines");
						System.out.println("3. Delta Airlines");
						System.out.println("Enter your choice (1-3):");
						try {
							airline = input.nextInt();
							//Check if input is valid
							while(airline < 1 || airline>3) {
								System.out.println("Invalid Input\n");
								System.out.println("----AIRLINES----");
								System.out.println("1. Air Canada");
								System.out.println("2. American Airlines");
								System.out.println("3. Delta Airlines");
								System.out.println("Enter your choice (1-3):");
								airline = input.nextInt();
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

					//If Air Canada is picked
					if(airline ==1) {
						//Only run if there is space left on the flight
						if(can<a.length) {
							//Create object of Air Canada
							a[can] = new AirCanada();

							//Display Air Canada information
							a[can].print();
							System.out.println();

							//Get user to enter name
							System.out.println("Enter your name:");
							a[can].setName(input.next());

							//Get user to enter their ticket number
							while(true) {
								System.out.println("Enter your ticket number:");
								try {
									a[can].setTicketNum(input.nextInt());
									//Ensure ticket number is unique in airline and input is valid
									if(can==0) {
										while(a[can].getTicketNum()<0) {
											System.out.println("Ticket number can only be 0 or greater");
											System.out.println("Ticket number cannot be the same as another passanger");
											System.out.println("Enter your ticket number:");
											a[can].setTicketNum(input.nextInt());
										}
									}
									else {
										for(int i=0;i<can;i++) {
											while(a[i].getTicketNum()==a[can].getTicketNum() || a[can].getTicketNum()<0) {
												System.out.println("Ticket number can only be 0 or greater");
												System.out.println("Ticket number cannot be the same as another passanger");
												System.out.println("Enter your ticket number:");
												a[can].setTicketNum(input.nextInt());
											}
										}
									}
									break;
								}
								//Check exception
								catch(InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Display locations and get user to enter their location
							while(true) {
								AirCanada.location();
								System.out.println("Enter where you would like to travel(1-4):");
								try {
									a[can].setLocationNum(input.nextInt());
									//Check input is valid
									while(a[can].getLocationNum() < 1 || a[can].getLocationNum() >4) {
										System.out.println("Invalid Input\n");
										AirCanada.location();
										System.out.println("Enter where you would like to travel(1-4):");
										a[can].setLocationNum(input.nextInt());
									}
									break;
								}
								//Check exception
								catch(InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Get the number of carry ons user has
							while(true) {
								System.out.println("How much carry on baggage do you have:");
								try {
									a[can].setCarryOn(input.nextInt());
									//Check input is valid
									while(a[can].getCarryOn()>3 ||a[can].getCarryOn()<0) {
										System.out.println("Invalid Input");
										System.out.println("Maximum is 3, minimum 0");
										System.out.println("How much carry on baggage do you have:");
										a[can].setCarryOn(input.nextInt());
									}
									break;
								}
								//Check exception
								catch(InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Get the number of checking baggage user has
							while(true) {
								System.out.println("How much checking baggage do you have:");
								try {
									a[can].setBaggage(input.nextInt());
									//Check input is valid
									while(a[can].getBaggage()<0) {
										System.out.println("Invalid Input");
										System.out.println("How much checking baggage do you have:");
										a[can].setBaggage(input.nextInt());
									}
									break;
								}
								//Check exception
								catch(InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Create array to check the weight of each bag
							int weight1[] = new int [a[can].getBaggage()];

							//Get the weight of each bag
							for(int i=0;i<a[can].getBaggage();i++) {
								while(true) {
									System.out.println("Enter the weight of bag"+(i+1)+" (lbs, whole number):");
									try {
										weight1[i]= input.nextInt();
										//Check that bag does not exceed weight
										while(weight1[i]>50 || weight1[i]<=0) {
											System.out.println("Baggage must be less than or equal to 50lbs and greater than 0lbs");
											System.out.println("Remove items until bag meets requirements");
											System.out.println("Enter the weight of bag"+(i+1)+" (lbs, whole number):");
											weight1[i] = input.nextInt();
										}
										break;
									}
									//Check exception
									catch(InputMismatchException e) {
										System.out.println("You entered bad data");
										System.out.println("Please try again\n");
										String flush = input.next();
									}
								}
							}

							//Set seats that are already taken
							for(int i=0;i<can;i++) {
								a[can].seat[(a[i].getRow()-1)][(a[i].getColoumnNum())-1] = "X";
							}

							//Get user to pick their seat
							while(true) {
								//Display seats
								a[can].displaySeat();
								//Get user to enter their row and column
								System.out.println("Enter your row:");
								try {
									a[can].setRow(input.nextInt());
									System.out.println("Enter the coloumn:");
									a[can].setColoumn(input.next());
									//Set the letter of seat to number for array use
									a[can].change();
									//Check that the seat entered is not already taken, and not out of bounds
									while(a[can].getRow()>5 || a[can].getRow()<1 || a[can].getColoumnNum()>6 || a[can].seat[(a[can].getRow()-1)][(a[can].getColoumnNum())-1].equals("X")){
										a[can].displaySeat();
										System.out.println("Your entry is either out of bounds, bad data, or already taken");
										System.out.println("Enter your row:");
										a[can].setRow(input.nextInt());
										System.out.println("Enter the coloumn:");
										a[can].setColoumn(input.next());
										a[can].change();
									}
									break;
								}
								//Check exception
								catch (InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Get pet information from user
							a[can].Pet();

							//Display the scheduled booking info
							System.out.println("----FLIGHT BOOKED!----");
							System.out.println("----AIR CANADA BOOKED FLIGHT "+(can+1)+"----");
							System.out.println("Name: \t\t\t\t"+a[can].getName());
							System.out.println("Ticket Number: \t\t\t"+a[can].getTicketNum());
							System.out.println("Destination: \t\t\t"+AirCanada.locationName[(a[can].getLocationNum()-1)]);
							System.out.println("Number of Carry Ons: \t\t"+a[can].getCarryOn());
							System.out.println("Number of Checking Baggage: \t"+a[can].getBaggage());
							System.out.println("Seat Location: \t\t\t"+a[can].getRow()+a[can].getColoumn().toUpperCase());
							System.out.println("Number of Pets: \t\t"+a[can].getNumPets());
							//If they have pet display each pet
							if(a[can].getNumPets()>0) {
								for(int i=0;i<a[can].getNumPets();i++) {
									System.out.println("Type of pet "+(i+1)+": \t\t\t"+a[can].getPetType(i));
								}
							}
							//If they have no pets display not applicable
							else {
								System.out.println("Pet Type: "+a[can].getPetType(0));
							}
							System.out.println();

							//Increase Air Canada Counter
							can++;

							//Ready for next user message
							System.out.println("Ready for next command!\n");
						}

						//Display message if there is no space
						else {
							System.out.println("All spaces on this airline are booked!");
							System.out.println("Choose a different airline\n");
						}
					}

					//If American Airlines is picked
					else if(airline == 2) {
						//Only run if there is space left on the flight
						if(amer<am.length) {
							//Create object of American airlines
							am[amer] = new AmericanAir();

							//Display American airlines information
							am[amer].print();
							System.out.println();

							//Get user to enter name
							System.out.println("Enter your name:");
							am[amer].setName(input.next());


							//Get user to enter their ticket number
							while(true) {
								System.out.println("Enter your ticket number:");
								try {
									am[amer].setTicketNum(input.nextInt());
									//Ensure ticket number is unique in airline and valid
									if(amer==0) {
										while(am[amer].getTicketNum()<0) {
											System.out.println("Ticket number can only be 0 or greater");
											System.out.println("Ticket number cannot be the same as another passanger");
											System.out.println("Enter your ticket number:");
											am[amer].setTicketNum(input.nextInt());
										}
									}
									else {
										for(int i=0;i<amer;i++) {
											while(am[i].getTicketNum()==am[amer].getTicketNum() ||am[amer].getTicketNum()<0) {
												System.out.println("Ticket number can only be 0 or greater");
												System.out.println("Ticket number cannot be the same as another passanger");
												System.out.println("Enter your ticket number:");
												am[amer].setTicketNum(input.nextInt());
											}
										}
									}
									break;
								}
								//Check exception
								catch(InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Get user to enter their location
							while(true) {
								//Display location and get user to pick location
								AmericanAir.location();
								System.out.println("Enter where you would like to travel (1-4):");
								try {
									am[amer].setLocationNum(input.nextInt());
									//Check that input is valid
									while(am[amer].getLocationNum() < 1 || am[amer].getLocationNum() >4) {
										System.out.println("Invalid Input\n");
										AmericanAir.location();
										System.out.println("Enter where you would like to travel(1-4):");
										am[amer].setLocationNum(input.nextInt());
									}
									break;
								}
								//Check exception
								catch(InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Get the number of carry ons
							while(true) {
								System.out.println("How much carry on baggage do you have:");
								try {
									am[amer].setCarryOn(input.nextInt());
									//Check input is valid
									while(am[amer].getCarryOn()>2 ||am[amer].getCarryOn()<0) {
										System.out.println("Invalid Input");
										System.out.println("Maximum is 2, minimum 0");
										System.out.println("How much carry on baggage do you have:");
										am[amer].setCarryOn(input.nextInt());
									}
									break;
								}
								//Check exception
								catch(InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Get the number of baggage
							while(true) {
								System.out.println("How much checking baggage do you have:");
								try {
									am[amer].setBaggage(input.nextInt());
									//Check input is valid
									while(am[amer].getBaggage()<0) {
										System.out.println("Invalid Input");
										System.out.println("How much checking baggage do you have:");
										am[amer].setBaggage(input.nextInt());
									}
									break;
								}
								//Check exception
								catch(InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Create array to check the weight of each bag
							int weight2[] = new int [am[amer].getBaggage()];

							//Get the weight of each bag
							for(int i=0;i<am[amer].getBaggage();i++) {
								while(true) {
									System.out.println("Enter the weight of bag"+(i+1)+" (lbs, whole numbers):");
									try {
										weight2[i]= input.nextInt();
										//Check that bag does not exceed weight
										while(weight2[i]>55 || weight2[i]<=0) {
											System.out.println("Baggage must be less than or equal to 55lbs and greater than 0lbs");
											System.out.println("Remove items until bag meets requirements");
											System.out.println("Enter the weight of bag"+(i+1)+" (lbs, whole numbers):");
											weight2[i] = input.nextInt();
										}
										break;
									}
									//Check exception
									catch(InputMismatchException e) {
										System.out.println("You entered bad data");
										System.out.println("Please try again\n");
										String flush = input.next();
									}
								}
							}

							//Ask if they are flying first class
							am[amer].firstClass();

							//Set seats that are already taken
							for(int i=0;i<amer;i++) {
								am[amer].seat[(am[i].getRow()-1)][(am[i].getColoumnNum())-1] = "X";
							}

							//Get the user input for seat 
							while(true) {
								//Display seats
								am[amer].displaySeat();
								//Get input for row and columns
								System.out.println("Enter your row:");
								try {
									am[amer].setRow(input.nextInt());
									System.out.println("Enter the coloumn:");
									am[amer].setColoumn(input.next());
									//Change the seat letters to number for reference in the array
									am[amer].change();
									//Make sure the users seat meets the requirements (first class)
									if(am[amer].firstClass.equalsIgnoreCase("YES")) {
										while(am[amer].getRow()>2 || am[amer].getRow()>5 || am[amer].getRow()<1 || am[amer].getColoumnNum()>6 || am[amer].seat[(am[amer].getRow()-1)][(am[amer].getColoumnNum())-1].equals("X")){
											am[amer].displaySeat();
											System.out.println("Your entry is either out of bounds, already taken, or bad data");
											System.out.println("You are flying first class ensure you pick one of the first 2 rows");
											System.out.println("Enter your row:");
											am[amer].setRow(input.nextInt());
											System.out.println("Enter the coloumn:");
											am[amer].setColoumn(input.next());
											am[amer].change();
										}
									}
									//Make sure the users seat meets the requirements (non first class)
									else {
										while(am[amer].getRow()<=2 || am[amer].getRow()>5 || am[amer].getRow()<1 || am[amer].getColoumnNum()>6 || am[amer].seat[(am[amer].getRow()-1)][(am[amer].getColoumnNum())-1].equals("X")){
											am[amer].displaySeat();
											System.out.println("Your entry is either out of bounds, already taken, or bad data");
											System.out.println("You are not flying first class ensure you pick one of the first 2 rows");
											System.out.println("Enter your row:");
											am[amer].setRow(input.nextInt());
											System.out.println("Enter the coloumn:");
											am[amer].setColoumn(input.next());
											am[amer].change();
										}
									}
									break;
								}
								//Check exception
								catch (InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Display the scheduled booking info
							System.out.println("----FLIGHT BOOKED!----");
							System.out.println("----AMERICAN AIRLINES BOOKED FLIGHT "+(amer+1)+"----");
							System.out.println("Name: \t\t\t\t"+am[amer].getName());
							System.out.println("Ticket Number: \t\t\t"+am[amer].getTicketNum());
							System.out.println("Destination: \t\t\t"+AmericanAir.locationName[(am[amer].getLocationNum()-1)]);
							System.out.println("Number of Carry Ons: \t\t"+am[amer].getCarryOn());
							System.out.println("Number of Checking Baggage: \t"+am[amer].getBaggage());
							System.out.println("Seat Location: \t\t\t"+am[amer].getRow()+am[amer].getColoumn().toUpperCase());
							System.out.println("First Class: \t\t\t"+am[amer].getFirstClass());
							System.out.println();

							//Increase American airlines counter
							amer++;

							//Ready for next user message
							System.out.println("Ready for next command\n");
						}

						//Display message if there is no space on flight
						else {
							System.out.println("All spaces on this airline are booked!");
							System.out.println("Choose a different airline\n");
						}
					}

					//If Delta Airlines is picked
					else {
						//Run if there is space left on airline
						if(delt<d.length) {

							//Create object of delta airlines
							d[delt] = new DeltaAir();

							//Display Delta Airlines information
							d[delt].print();
							System.out.println();

							//Get user to enter name
							System.out.println("Enter your name:");
							d[delt].setName(input.next());

							//Get user to enter their ticket number
							while(true) {
								System.out.println("Enter your ticket number:");
								try {
									d[delt].setTicketNum(input.nextInt());
									//Ensure ticket number is unique in airline and valid
									if(delt==0) {
										while(d[delt].getTicketNum()<0) {
											System.out.println("Ticket can only be 0 or greater");
											System.out.println("Ticket number cannot be the same as another passanger");
											System.out.println("Enter your ticket number:");
											d[delt].setTicketNum(input.nextInt());
										}
									}
									else {
										for(int i=0;i<delt;i++) {
											while(d[i].getTicketNum()==d[delt].getTicketNum() || d[delt].getTicketNum()<0) {
												System.out.println("Ticket can only be 0 or greater");
												System.out.println("Ticket number cannot be the same as another passanger");
												System.out.println("Enter your ticket number:");
												d[delt].setTicketNum(input.nextInt());
											}
										}	
									}
									break;
								}
								//Check exception
								catch(InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Get user to enter their location
							while(true) {
								//Display location
								DeltaAir.location();
								//Get user input
								System.out.println("Enter where you would like to travel(1-4):");
								try {
									d[delt].setLocationNum(input.nextInt());
									//Check input is valid
									while(d[delt].getLocationNum() < 1 || d[delt].getLocationNum() >4) {
										System.out.println("Invalid Input\n");
										DeltaAir.location();
										System.out.println("Enter where you would like to travel(1-4):");
										d[delt].setLocationNum(input.nextInt());
									}
									break;
								}
								//Check exception
								catch(InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Get the number of carry ons
							while(true) {
								System.out.println("How much carry on baggage do you have:");
								try {
									d[delt].setCarryOn(input.nextInt());
									//Check input is valid
									while(d[delt].getCarryOn()>2 ||d[delt].getCarryOn()<0) {
										System.out.println("Invalid Input");
										System.out.println("Maximum is 2, minimum 0");
										System.out.println("How much carry on baggage do you have:");
										d[delt].setCarryOn(input.nextInt());
									}
									break;
								}
								//Check exception
								catch(InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Get the number of baggage
							while(true) {
								System.out.println("How much checking baggage do you have:");
								try {
									d[delt].setBaggage(input.nextInt());
									//Check input is valid
									while(d[delt].getBaggage()<0) {
										System.out.println("Invalid Input");
										System.out.println("How much checking baggage do you have:");
										d[delt].setBaggage(input.nextInt());
									}
									break;
								}
								//Check exception
								catch(InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Create array to check the weight of each bag
							int weight3[] = new int [d[delt].getBaggage()];

							//Get the weight of each bag
							for(int i=0;i<d[delt].getBaggage();i++) {
								while(true) {
									System.out.println("Enter the weight of bag"+(i+1)+" (lbs, whole numbers):");
									try {
										weight3[i]= input.nextInt();
										//Check that bag does not exceed weight
										while(weight3[i]>60 || weight3[i]<=0) {
											System.out.println("Baggage must be less than or equal to 60lbs and greater than 0lbs");
											System.out.println("Remove items until bag meets requirements");
											System.out.println("Enter the weight of bag"+(i+1)+" (lbs, whole numbers):");
											weight3[i] = input.nextInt();
										}
										break;
									}
									//Check exception
									catch(InputMismatchException e) {
										System.out.println("You entered bad data");
										System.out.println("Please try again\n");
										String flush = input.next();
									}
								}
							}

							//Set seats that are already taken
							for(int i=0;i<delt;i++) {
								d[delt].seat[(d[i].getRow()-1)][(d[i].getColoumnNum())-1] = "X";
							}

							//Get user to pick their seat
							while(true) {
								//Display seats
								d[delt].displaySeat();
								//Get user input
								System.out.println("Enter your row:");
								try {
									d[delt].setRow(input.nextInt());
									System.out.println("Enter the coloumn:");
									d[delt].setColoumn(input.next());
									d[delt].change();
									//Check that the seat entered is not already taken, and not out of bounds
									while(d[delt].getRow()>5 || d[delt].getRow()<1 || d[delt].getColoumnNum()>6 || d[delt].seat[(d[delt].getRow()-1)][(d[delt].getColoumnNum())-1].equals("X")){
										d[delt].displaySeat();
										System.out.println("Your entry is either out of bounds, already taken, or bad data");
										System.out.println("Enter your row (1-5):");
										d[delt].setRow(input.nextInt());
										System.out.println("Enter the coloumn (A-F):");
										d[delt].setColoumn(input.next());
										d[delt].change();
									}
									break;
								}
								//Check exception
								catch (InputMismatchException e) {
									System.out.println("You entered bad data");
									System.out.println("Please try again\n");
									String flush = input.next();
								}
							}

							//Get user to enter their option of transportation
							d[delt].transportation();

							//Display the scheduled booking info
							System.out.println("----FLIGHT BOOKED!----");
							System.out.println("----DELTA AIRLINES BOOKED FLIGHT "+(delt+1)+"----");
							System.out.println("Name: \t\t\t\t"+d[delt].getName());
							System.out.println("Ticket Number: \t\t\t"+d[delt].getTicketNum());
							System.out.println("Destination: \t\t\t"+DeltaAir.locationName[(d[delt].getLocationNum()-1)]);
							System.out.println("Number of Carry Ons: \t\t"+d[delt].getCarryOn());
							System.out.println("Number of Checking Baggage: \t"+d[delt].getBaggage());
							System.out.println("Seat Location: \t\t\t"+d[delt].getRow()+d[delt].getColoumn().toUpperCase());
							System.out.println("Travel Option: \t\t\t"+d[delt].getTravel());
							System.out.println();

							//Increase Air Canada Counter
							delt++;

							//Ready for next user message
							System.out.println("Ready for next Commad!\n");
						}

						//Display message if there is no more space
						else {
							System.out.println("All spaces on this airline are booked!");
							System.out.println("Choose a different airline\n");
						}
					}
				}
				//Display message if all flights have been booked
				else {
					System.out.println("All flights have been booked\n");
				}
			}

			//Display the total profit of each airline
			else if(choice ==2) {
				//Display all the Air Canada charges
				System.out.println("-----Air Canada Profits-----");
				//Display a message if there are no booked flights
				if(can==0) {
					System.out.println("No Flights have been booked, no profits recorded\n");
				}
				//Display all the Air Canada charges
				else {
					for(int i=0;i<can;i++) {
						System.out.println("-----Charges Applied to Booked Flight "+(i+1)+"-----");
						a[i].calculateTotal();
						a[i].displayCharges();
						//Add the total for each customer to Air Canada profits
						CanadaProfit += a[i].getTotal();
						System.out.println();
					}
					//Display the total profit for Air Canada
					System.out.println("Air Canada Total Profit: "+money.format(CanadaProfit));	
				}

				//Display all the American Airlines charges
				System.out.println("\n-----American Airlines Profits-----");
				//Display a message if there are no booked flights
				if(amer==0) {
					System.out.println("No Flights have been booked, no profits recorded\n");
				}
				//Display all the American Airlines charges
				else {
					for(int i=0;i<amer;i++) {
						System.out.println("-----Charges Applied to Booked Flight "+(i+1)+"-----");
						am[i].calculateTotal();
						am[i].displayCharges();
						//Add the total for each customer to American Airlines profits
						AmericanProfit += am[i].getTotal();
						System.out.println();
					}
					//Display the total profit for American Airlines
					System.out.println("American Airlines Total Profit: "+money.format(AmericanProfit));
				}

				//Display all the Delta Airline charges
				System.out.println("\n-----Delta Airlines Profits-----");
				//Display a message if there are no booked flights
				if(delt==0) {
					System.out.println("No Flights have been booked, no profits recorded\n");
				}
				//Display all the Delta Airlines charges
				else {
					for(int i=0;i<delt;i++) {
						System.out.println("-----Charges Applied to Booked Flight "+(i+1)+"-----");
						d[i].calculateTotal();
						d[i].displayCharges();
						//Add the total for each customer to American Airlines profits
						DeltaProfit += d[i].getTotal();
						System.out.println();
					}
					//Display the total profit for Delta Airlines
					System.out.println("Delta Airlines Total Profit: "+money.format(DeltaProfit));
				}
				System.out.println();
			}

			//If 3 is picked display all booked flights
			else if(choice ==3) {
				//Display all Air Canada Booked Flights
				System.out.println("----AIR CANADA----");
				//Display message if no flights have been booked
				if(can==0) {
					System.out.println("No flights have been booked yet on Air Canada\n");
				}
				//Display booked flights
				else {
					for(int i=0;i<can;i++) {
						System.out.println("----Booked Flight Number "+(i+1)+"----");
						System.out.println("Name: \t\t\t\t"+a[i].getName());
						System.out.println("Ticket Number: \t\t\t"+a[i].getTicketNum());
						System.out.println("Destination: \t\t\t"+AirCanada.locationName[(a[i].getLocationNum()-1)]);
						System.out.println("Number of Carry Ons: \t\t"+a[i].getCarryOn());
						System.out.println("Number of Checking Baggage: \t"+a[i].getBaggage());
						System.out.println("Seat Location: \t\t\t"+a[i].getRow()+a[i].getColoumn().toUpperCase());
						System.out.println("Number of Pets: \t\t"+a[i].getNumPets());
						//If they have pet display each pet
						if(a[i].getNumPets()>0) {
							for(int x=0;x<a[i].getNumPets();x++) {
								System.out.println("Type of pet "+(x+1)+": \t\t\t"+a[i].getPetType(x));
							}
						}
						//If they have no pets display not applicable
						else {
							System.out.println("Type of Pet: "+a[i].getPetType(0));
						}
						System.out.println();
					}
				}

				//Display all American Airlines Booked Flights
				System.out.println("\n----AMERICAN AIRLINES----");
				//Display message if no flights have been booked
				if(amer==0) {
					System.out.println("No flights have been booked yet on American Airlines\n");
				}
				//Display booked flights
				else {
					for(int i=0;i<amer;i++) {
						System.out.println("----Booked Flight Number "+(i+1)+"----");
						System.out.println("Name: \t\t\t\t"+am[i].getName());
						System.out.println("Ticket Number: \t\t\t"+am[i].getTicketNum());
						System.out.println("Destination: \t\t\t"+AmericanAir.locationName[(am[i].getLocationNum()-1)]);
						System.out.println("Number of Carry Ons: \t\t"+am[i].getCarryOn());
						System.out.println("Number of Checking Baggage: \t"+am[i].getBaggage());
						System.out.println("Seat Location: \t\t\t"+am[i].getRow()+am[i].getColoumn().toUpperCase());
						System.out.println("First Class: \t\t\t"+am[i].getFirstClass());
						System.out.println();
					}
				}

				//Display all Delta Airlines Booked FLights
				System.out.println("\n----DELTA AIRLINES----");
				//Display message if no flights have been booked
				if(delt==0) {
					System.out.println("No flights have been booked yet on Delta Airlines\n");
				}
				//Display booked flights
				else {
					for(int i=0;i<delt;i++) {
						System.out.println("----Booked Flight Number "+(i+1)+"----");
						System.out.println("Name: \t\t\t\t"+d[i].getName());
						System.out.println("Ticket Number: \t\t\t"+d[i].getTicketNum());
						System.out.println("Destination: \t\t\t"+DeltaAir.locationName[(d[i].getLocationNum()-1)]);
						System.out.println("Number of Carry Ons: \t\t"+d[i].getCarryOn());
						System.out.println("Number of Checking Baggage: \t"+d[i].getBaggage());
						System.out.println("Seat Location: \t\t\t"+d[i].getRow()+d[i].getColoumn().toUpperCase());
						System.out.println("Travel Option: \t\t\t"+d[i].getTravel());
						System.out.println();
					}
				}
				System.out.println();
			}

			//Exit if 4 is picked
			else {
				System.out.println("----PROGRAM ENDED----");
			}
			//Loop back until the user exits	
		}while(choice != 4);
	}
}
