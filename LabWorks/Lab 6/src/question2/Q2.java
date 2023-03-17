package question2;

public class Q2 {
	public static void main(String[] args) {
		
		String str="WeLcome  Java and  ios .";
		
		Encrypt encrypt= new Encrypt(str);
		
		encrypt.capitalConvertor();
		encrypt.reverseString();
		encrypt.toNumbers();
		encrypt.beginAndEnd();
		
				System.out.println(encrypt.toString());	
	}
	
}
