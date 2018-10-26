import java.util.Random;
import java.util.Scanner;

public class RandomPassGen {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your desired password length: ");
		int length = scan.nextInt();
		System.out.println("Your desired password length is "+ length +", which is: "+GeneratePassword(length));
		
	}
	
	public static String GeneratePassword(int length) {
		String[] characters = {"0123456789","~!@#$%^&*()-_=+[{]}|;:\'\",<.>/?","ABCDEFGHIJKLMNOPQRSTUVWXYZ","abcdefghijklmnopqrstuvwxyz"};
		Random rand = new Random();
		String password="";
			for(int i=0;i<length;i++) {
				int random = rand.nextInt(4);//choose a number from 0 to 3(inclusive)
				int string_size = characters[random].length();//get length of the selected string
				int random1 = rand.nextInt(string_size);//choose a number from0 to length-1 of selected string
				char item = characters[random].charAt(random1);//selects the character
				password=password+item;//Concatenates with the password
			}
		return password;
	}

}
