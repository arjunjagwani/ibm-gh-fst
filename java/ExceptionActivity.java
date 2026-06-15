
public class ExceptionActivity {
	public static void exceptionTest(String str) throws Exception {
		if(str==null)
			throw new CustomException("The String is NULL");
		else
			System.out.println(str);
	}
public static void main(String[] args) throws Exception {
	try {
	ExceptionActivity.exceptionTest("This is a String");
	ExceptionActivity.exceptionTest(null);
	}
	catch(CustomException e) {
		
		System.out.println(e.getMessage());
	}
	
}
}
