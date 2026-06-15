
public class MyBook extends Book {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBook newNovel=new MyBook();
		newNovel.setTitle("Atomic Habits");
		System.out.println(newNovel.getTitle());
	}

	@Override
	public void setTitle(String t) {
		// TODO Auto-generated method stub
		this.title=t;
	}

}
