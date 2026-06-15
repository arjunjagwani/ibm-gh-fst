import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> colours=new HashMap<>();
		colours.put(11, "Red");
		colours.put(22, "Yellow");
		colours.put(33, "Blue");
		colours.put(44, "Green");
		colours.put(55, "Teal");
		System.out.println(colours);
		colours.remove(44);
		
		
		System.out.println("Green Colour exists or not :"+ colours.containsValue("Green"));
		
		
		System.out.println("Size: "+colours.size());
	}

}
