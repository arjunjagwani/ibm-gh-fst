
public class Bicycle implements BicycleParts,BicycleOperations {
	private int gears;
	private int currentSpeed;
	public Bicycle(int gears,int currentSpeed) {
		// TODO Auto-generated constructor stub
		this.gears=gears;
		this.currentSpeed=currentSpeed;
	}
@Override
public void applyBrake(int decrement) {
	// TODO Auto-generated method stub
	if(currentSpeed-decrement>0) {
	this.currentSpeed=this.currentSpeed-decrement;
	System.out.println("Current Speed: "+currentSpeed);
	}else
		System.out.println("The Bicycle has stopped.");
	System.out.println("\n");
	
}@Override
	public void speedUp(int increment) {
		// TODO Auto-generated method stub
	if(currentSpeed+increment <=30) {
	this.currentSpeed=this.currentSpeed+increment;	
	System.out.println("Current Speed: "+currentSpeed);
	}
	else
		System.out.println("The Bicycle has reached its Max Speed.\nPlease slow down.");
	System.out.println("\n");
	}
public void bicycleDesc() {
	System.out.println("Bicycle Description: ");
	System.out.println("No of Gears: "+gears);
	System.out.println("Max Speed: "+maxSpeed);
	
}
}
