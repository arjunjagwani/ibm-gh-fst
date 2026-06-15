
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Activity9 {
	
public static void main(String[] args) {
	
	List<String> myList=new ArrayList<>();
	myList.add("Arjun");
	myList.add("Yash");
	myList.add("Shiva");
	myList.add("Samiksha");
	myList.add("Pranav");
//	Iterator<String> itr=myList.iterator();
//	while(itr.hasNext()) {
//		
//	}
	for(int i=0;i<myList.size();i++) {
		System.out.println(myList.get(i));
	}
	
	System.out.println("Third Name:"+ myList.get(2));
	
	System.out.println("Aastha Name exists or not :"+ myList.contains("Aastha"));
	
	System.out.println("Size: "+myList.size());
	myList.remove(0);
	System.out.println("Size: "+myList.size());
	
}
}
