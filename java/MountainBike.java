
public class MountainBike extends Bicycle{
	private int seatHeight;
 public MountainBike(int g,int cs,int sh) {
	 super(g,cs);
	 seatHeight=sh;
	// TODO Auto-generated constructor stub
}
 public void setHeight(int seatHeight) {
	 this.seatHeight=seatHeight;
 }
 @Override
 public void bicycleDesc() {
	 super.bicycleDesc();
	 System.out.println("Seat Height: "+seatHeight);
	 System.out.println("\n");
 }
}
