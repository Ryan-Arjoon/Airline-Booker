
public interface information {
	//Declare final variable
	//Static variable to store the the base charge applied to all airline flights 
	int baseCharge = 200;
	
	//Abstract method for airlines to display their flight regulations
	public void print();
	
	//Abstract method for displaying the charges applied to customers in each airline
	public void displayCharges();
}
