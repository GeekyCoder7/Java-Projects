package lab7;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileScanner {
	private static Scanner scan;

	public static void main(String[] args) throws FileNotFoundException {
		int x=0;
		float y=0,sum=0;
		String str="";
		File file = new File("C:/Users/201701143/Desktop/Dev/lab7/src/lab7/input.txt");
		scan = new Scanner(file);
		
		x = scan.nextInt();
		y = (float) scan.nextDouble();
		sum=x+y;
		str = scan.next();
		System.out.println("The integer read is: "+x);
		System.out.println("The floating point number read is: "+y);
		System.out.println("The String read is: "+"\""+str+"\"");
		System.out.println("Hi! "+str+", the sum of "+x+" and "+y+" is "+sum);
	}
}
