package lab6;

import java.util.Scanner;

public class PalindromeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str, another = "y";
		int left, right;
		Scanner scan = new Scanner (System.in);
		while(another.equalsIgnoreCase("y")){
			System.out.println("Enter a potential palindrome: ");
			str = scan.nextLine();
			left=0;
			right = str.length()-1;
			while(str.charAt(left)==str.charAt(right)&&left<right){
				left++;
				right--;
			}
			System.out.println();
			if(right<left||left==right){
				System.out.println("That string IS a palindrome.");
				
			}else {
				System.out.println("That string is NOT a palindrome.");	
				}
			System.out.println();
			System.out.print("Test another palindrome (y/n)? ");
			another = scan.nextLine();
			if(another!="y"||another!="n"||another!="Y"||another!="N"){
				System.out.println("Please enter y or n");
				another = scan.nextLine();
			}
			}
		}
	}

