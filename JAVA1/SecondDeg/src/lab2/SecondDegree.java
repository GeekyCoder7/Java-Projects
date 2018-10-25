package lab2;
import java.util.Scanner;

public class SecondDegree {
	private static Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		scan = new Scanner(System.in);
		double X1,X2;
		System.out.println("A program to find the roots of a second degree equation");
		
		System.out.println("Enter A");
		int A = scan.nextInt();
		
		System.out.println("Enter B");
		int B = scan.nextInt();
		
		System.out.println("Enter C");
		int C = scan.nextInt();
		
		double delta = Math.pow(B, 2) -4*A*C;
		
		if(delta<0){
			System.out.println("No roots");
			
		}
		
		if(delta>0){
		X1=(-B-Math.sqrt(delta))/(2*A);	
		X2=(-B+Math.sqrt(delta))/(2*A);	
		System.out.println("2 roots : ");
		System.out.println("X1 = "+X1);
		System.out.println("X2= "+X2);
		}
		
		if(delta==0){
			X1=-B/(2*A);
			System.out.println("1 double root : "+ X1);
		}
	}
}
