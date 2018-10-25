package lab3;

import java.util.Random;
public class RollingDice {

	private static Random generator;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generator = new Random();
		int randNum,sum = 0;
		
		for(int i=1;i<3;i++){
		randNum=generator.nextInt(6)+1;
		sum += randNum;
		System.out.println("Dice "+i+": "+randNum);
		}
		System.out.println("Sum: "+sum);
	}

}
