import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Activity1 {
static List<String> list;

@BeforeEach
public void setUp() {
	list=new ArrayList<>();
	list.add("alpha");
	list.add("beta");
}

@Test
public void insertTest() {
	assertEquals(2, list.size(),"Wrong Size");
	list.add("gamma");
	assertEquals(3, list.size(),"Wrong Size");
	
	
	assertEquals("alpha",list.get(0),"Wrong element");
	assertEquals("beta",list.get(1),"Wrong element");
	assertEquals("gamma",list.get(2),"Wrong element");	
}

@Test
public void replaceTest() {
	assertEquals(2, list.size(),"Wrong Size");
	list.add("gamma");
	assertEquals(3, list.size(),"Wrong Size");
	list.set(1, "omega");
	assertEquals("alpha",list.get(0),"Wrong element");
	assertEquals("omega",list.get(1),"Wrong element");
	assertEquals("gamma",list.get(2),"Wrong element");	
}
}
