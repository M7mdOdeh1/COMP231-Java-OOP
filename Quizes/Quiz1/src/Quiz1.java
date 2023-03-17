import java.util.*;



public class Quiz1 {



	public static void main(String[] args) {

		int count=1;

		Scanner inp=new  Scanner(System.in);

		int number=random();

		System.out.println("guess the number: ");

		int guess=inp.nextInt();

		
		
		
		while(number!=guess) {

			if(guess<number)

				System.out.println("the guess is too low");

			else

				System.out.println("the guess is too high");

			

			System.out.println("guess again: ");

			guess=inp.nextInt();

			count++;

		}

		System.out.println("congrates!!! you guessed the number after "+count+" attempt");

		inp.close();

	}

	

	public static int random() {

		

		return (int)(Math.random()*100);

	}



}

