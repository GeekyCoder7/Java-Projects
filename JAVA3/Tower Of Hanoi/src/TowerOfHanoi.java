/*Name: Nazareth H. Keshishian
 *Date Last Modified: 05/11/2018
 *Program Description: Tower of hanoi.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class TowerOfHanoi {

	
	public static void towerOfHanoi(String start, String aux, String end,int n){ /*method towerOfHanoi that creates 3 poles start,
		*middle(or aux), and end, and the number of disks n.*/
			
		if (n == 1) {	//if number of disks is 1, we put a disk from the start pole to the end pole.
			//O(1) running time
			System.out.println("Disk moved from "+start + " => " + end);
		}
		
		
		else {	
			//T(N-1) 
		towerOfHanoi(start, end, aux,n - 1); //the mid pole becomes the end pole, and the end pole becomes the middle pole, and then we move the largest disc from the start pole to the end pole. 
		System.out.println("Disk moved from "+start + " => " + end);
			//T(N-1) 
		towerOfHanoi(aux, start, end,n - 1);//the start pole becomes the mid pole , and the mid pole becomes the start pole.
	}/*=> T(N) = T(N-1) + T(N-1) = 2 T(N-1) and T(N-1)= 2T(N-2) and so on...
		See answer in the scanned paper.
	*/
}
	
	public static void main(String[] args) {
		   int numDiscs=0;
		   boolean isInt=false;
		
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
		
	}
	
}
