package question1;

public class Q1 {	
		public static void main(String[] args) {
			
			String str = "you are welcome to our journey, and take this for safetey. What is today?";
	
			System.out.println("the number of sentences is: " + MyString.numberOfSentences(str));
			System.out.println("The number of words is: " + MyString.numberOfWords(str));
			System.out.println("reversed String : " + MyString.reverseString(str));
			
			if (MyString.isPalindrome(str))
				System.out.println("The string is Palidrome");
			else
				System.out.println("The string is not Palidrome");
			
			System.out.println("Short handed: "+ MyString.shortHanded(str));
			
		}	

}
