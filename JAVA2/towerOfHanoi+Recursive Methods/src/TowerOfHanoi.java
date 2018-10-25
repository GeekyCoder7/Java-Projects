/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 23/02/2018
 *Associated files: No associated files. 
 *Program Description: Tower Of Hanoi.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class TowerOfHanoi {
		
		
	public static void towerOfHanoi(String start, String aux, String end,int n){ /*method towerOfHanoi that creates 3 poles start,
																				*middle(or aux), and end, and the number of disks n.*/
																				
	       if (n == 1) {	//if number of disks is 1, we put a disk from the start pole to the end pole.
	           System.out.println("A disk from "+start + " => " + end);
	       } 
	       else {	
	    	   towerOfHanoi(start, end, aux,n - 1); //the mid pole becomes the end pole, and the end pole becomes the middle pole, and then we move the largest disc from the start pole to the end pole. 
	           System.out.println("A disk from "+start + " => " + end);
	           towerOfHanoi(aux, start, end,n - 1);//the start pole becomes the mid pole , and the mid pole becomes the start pole.
	       }
	   }

	   public static void main(String[] args) {
		   int numDiscs=0;
		   boolean isInt=false;
		 @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		 
		 while(!isInt){
				try {
					 System.out.print("Enter number of discs: ");
				   	   numDiscs = scan.nextInt();
				isInt = true;
			}
			catch(InputMismatchException e) {
				System.out.print("Error. ");
			}
				scan.nextLine();
				
			}
			isInt=false; 
	      
	   	towerOfHanoi("1st pole", "2nd pole", "3rd pole",numDiscs);
	   /* #3 209ns
	    * #5 326ns
	    * #10 658ns
	    * #100 Can't be calculated 	(The number of moves is 2^100 - 1 which is a huge number)
	    * #500 Can't be calculated	(The number of moves is 2^500 - 1 which is a huge number)
	    * #1000 Can't be calculated	(The number of moves is 2^1000 - 1 which is a huge number)
	    *Specs:
	    *-CPU: Core i7 4710HQ 2.5GHz
	    *-RAM: 16GB DDR3L
	    *-Storage: SSD HyperX Savage 480GB
	    *-GPU: nVidia Geforce GTX 860m 4GB GDDR5*/
	   }

}
