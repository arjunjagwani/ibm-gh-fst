import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs=new HashSet<>();
		hs.add("Arjun");
		hs.add("Yash");
		hs.add("Shiva");
		hs.add("Samiksha");
		hs.add("Pranav");
		hs.add("Aastha");
		System.out.println("Size: "+hs.size());
		System.out.println("Removing Name:"+ hs.remove("Arjun"));
		System.out.println("Removing Name:"+ hs.remove("Narayan"));
		
		
		System.out.println("Aastha Name exists or not :"+ hs.contains("Aastha"));
		
		
		
		System.out.println("Updated Size: "+hs.size());
	}

}
