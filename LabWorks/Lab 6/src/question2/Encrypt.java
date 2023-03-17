package question2;

public class Encrypt {
	private StringBuilder bldr;
	

	public Encrypt(String str) {
		bldr= new StringBuilder(str);
	}
	
	public Encrypt() {
	}
	
	public void capitalConvertor() {    //convert all letters to capital
		bldr.replace(0, bldr.length(),bldr.toString().toUpperCase());
	}
	
	public  void reverseString() {  //reverse the string  
		bldr.reverse();
	}
	
	

	public void toNumbers() {
		bldr.replace(0, bldr.length(), bldr.toString().replaceAll("O", "0"));
		bldr.replace(0, bldr.length(), bldr.toString().replaceAll("S", "\\$"));
		bldr.replace(0, bldr.length(), bldr.toString().replaceAll("L", "1"));		
	}
	
	public void beginAndEnd() {    //add ** to the begin and the end of the string
		bldr.insert(0, "**").append("**");
	}
	
	@Override
	public String toString() {
		return "Encrypt [Encrypted =" + bldr + "]";
	}
	
}
