
public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Plane plane=new Plane(10);
		plane.onboard("Abhay");
		plane.onboard("Rishabh");
		plane.onboard("Yash");
		plane.onboard("Arjun");
		plane.onboard("Divyam");
		plane.onboard("Sumit");
		System.out.println("Take Off time: "+plane.takeOff());
		System.out.println("List of Passengers \n"+plane.getPassengers());
		Thread.sleep(5000);
		plane.land();
		System.out.println("Landing Time: "+plane.getLastTimeLanded());
		
	}

}
