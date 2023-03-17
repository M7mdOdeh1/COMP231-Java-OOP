package question1;

public class MyString {

	public MyString() {

	}

	public static int numberOfSentences(String str) {
		String[] token = str.split("[.?!,]");
 
		return token.length;
	}

	public static int numberOfWords(String str) {
		int count = 0;
		String[] token = str.split(" ");

		for (int i = 0; i < token.length; i++) {
			if (token[i].length() < 4)
				continue;
			count++;
		}
		return count;

	}

	public static String reverseString(String str) {
		char ch[] = str.toCharArray();
		String reverse = "";
		for (int i = ch.length - 1; i >= 0; i--) {
			reverse += ch[i];
		}
		return reverse;
	}

	private static String Filter(String str) {
		String filter = str.toLowerCase();
		String filtered="";
		
		for (int i = 0; i < filter.length(); i++) {
			if(Character.isLetter(filter.charAt(i)))
				filtered += filter.charAt(i);
			
		}
		
		return filtered;
	}

	public static boolean isPalindrome(String str) {
		String filter = Filter(str);
		String reverse = reverseString(filter);

		return reverse.equals(filter);
	}

	public static String shortHanded(String str) {
		String short_handed1 = str.replaceAll("and", "&").replaceAll("to", "2").replaceAll("you", "U").replaceAll("for","4");
		String[] token= short_handed1.split(" ");
		String short_handed2="";
		
		for (int i = 0; i < token.length; i++) {
			if (token[i].length()<2 && (token[i].charAt(0)== 'I' || token[i].charAt(0)== 'U'))  {
				short_handed2 += token[i].concat(" ");
				continue;
			}			
			short_handed2+=token[i].replaceAll("[AEIOUaeiou]", "").concat(" ");
		}
		
		return short_handed2;

	}

}
