/*Name: Nazareth H. Keshishian
 *Date Last Modified: 05/11/2018
 *Program Description: Bubble Sort.
 */
public class BubbleSort {

	
	static void bubble(int[] a) {  
		boolean isSorted=false;
		for (int i = 0; i < a.length; i++){
			if(isSorted) {
				return;
			}
			isSorted=true;
			for (int j = a.length-1; j > i; j--){
				if(a[j]<a[j-1]) { //exchange only if number at index j-1 is bigger than number at index j.
					compExch(a, j-1, j); 
					isSorted=false;
				}
			}
		}
	
	}
	
	/*This method is more efficient because the number of comparisons are less than the one we have seen in class.
	*In this case, the number of comparisons are N(N-1)/2, compared to N(N-1) in the one we have seen in class.
	*/

	private static void print(int[] a) {
		for(int i = 0; i<a.length;i++) {
			System.out.print(a[i]+" - ");
		}
	}
	
	private static void compExch(int[] a, int i, int j) {
		
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
		} 

	public static void main(String[] args) {
		int[] a = {1,5,9,4,5,12,48,35,12,54,21,52,6};
		bubble(a);
		print(a);
	}
	
}
