package question3;

public class PassByValue {
	public static void main(String []args) {
		
		City a = new City("palestine", 46, 89, 20);
		
		City b = Clone(a);
		
		b.setCityName("jordan");
		
		
		System.out.println(a.toString());
		
		System.out.println(b.toString());
		
	}
	
	public static City Clone(City c) {
		return c;
	}

}
