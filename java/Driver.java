
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MountainBike mb=new MountainBike(5, 0, 22);
		mb.bicycleDesc();
		
		mb.speedUp(25);
		
		mb.applyBrake(13);
		
		mb.speedUp(40);
		
		mb.bicycleDesc();

	}

}
