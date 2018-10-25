package lab1;

import java.util.Scanner;

public class Time {

	private static Scanner scan;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scan = new Scanner(System.in);
		int numSeconds, numMinutes, numHours,numSec,numMinutes1;
		System.out.println("Enter the number of seconds");
		numSeconds = scan.nextInt();
		numSec = numSeconds%60;
		numMinutes = numSeconds/60;
		numHours = numSeconds/3600;
		numMinutes1 = numMinutes - numHours*60;
		System.out.println(numHours + " hours, " +numMinutes1 + " minutes, "
							+ numSec + " seconds.");
		
	}

}
