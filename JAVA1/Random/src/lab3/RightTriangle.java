package lab3;

import java.util.Scanner;

public class RightTriangle {

	private static Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			double side1, side2,result;
			double hypotenuse;
			scan = new Scanner (System.in);
			System.out.println("Please enter the lenghts of the two sides of "+
									"a right triangle:"	);
			side1=scan.nextDouble();
			
			side2=scan.nextDouble();
			result=Math.pow(side1, 2)+Math.pow(side2, 2);
			//Compute the lenght of hypo.
			hypotenuse=Math.sqrt(result);
			System.out.println("Length of the hypotenuse: "+ hypotenuse);
	}

}
