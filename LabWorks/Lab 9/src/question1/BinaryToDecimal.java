package question1;

import java.util.*;

public class BinaryToDecimal {
	public static void main(String [] args) {
		Scanner inp= new Scanner(System.in);
		
		
		System.out.println("Enter the binary number");
		String binNum;
		while(true){
		try {
			 binNum= inp.next();
			System.out.println(bin2Dec(binNum));
			break;
		}catch (NumberFormatException Exception) {
			System.out.println("Not a binary number");
			System.out.println("please reenter it again");
			continue;
		}
}
		
		inp.close();
	
		
	}
	
	public static int bin2Dec(String binNum) {
		
		int sum=0;
		
		for(int i=0; i<binNum.length(); i++) {
			if(binNum.charAt(i) !='1' && binNum.charAt(i) != '0') {
				throw new NumberFormatException("The number you entered is not a binary");
			}
			
			else if(binNum.charAt(i)=='1')
		sum +=  (int)Math.pow(2, binNum.length()-1-i);
				
		}
		
		return sum;
	}

}
