package lab1;
import java.util.Random;
import java.util.Scanner;


public class GuessingGame {

	private static Scanner input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int numberToGuess = rand.nextInt(1000);
		int numberOfTries = 0;
		input = new Scanner(System.in);
		int guess;
		boolean win = false, gameOver=false;
		
		
		while(win==false){
			System.out.println("Guess a number between 1 and 1000");
			guess = input.nextInt();
			
			numberOfTries++;
			
			if(guess>1000){
				System.out.println("You should guess a number between 1 and 1000");
			}
			if(numberOfTries>10){
				gameOver=true;
				win=true;
			}
			
			if(guess== numberToGuess){
				gameOver=false;
				win=true;
			}
			
			else if (guess < numberToGuess){
				System.out.println("Your guess is too low");
				
			}
			
			else if (guess > numberToGuess&&guess<=1000){
				System.out.println("Your guess is too high");
				
			}
			
			
			/*else if(numberOfTries>2){
				win=true;
				System.out.println("Game Over!");
			}*/
				
		}
		
		if(gameOver&&win){
			System.out.println("Game Over!");
		}
		
		if(win&&!gameOver){
		
		System.out.println("You win!");
		System.out.println("The number was " + numberToGuess);
		System.out.println("It took you "+ numberOfTries + " tries.");
		}	
	}
	
	
}
