/*Name: Nazareth H. Keshishian
 *Date Last Modified: 05/11/2018
 *Program Description: Bubble Sort.
 */
class Main { 

public static void main(String[] args) {
	int[] a = {19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};//reverse order
	int[] d = {15,12,1,6,4,8,7,9,2,14,3,11,13,18,16,0,19,17,5,10};//random
	quicksort(a,0,a.length-1);
	System.out.println("a.The array is sorted in reverse order:");
	print(a);
	System.out.println();
	quicksort(d,0,d.length-1);
	System.out.println("d. The array is randomly sorted:");
	print(d);
	System.out.println();
}

public static void quicksort(int[] nums, int a, int b) {
    if (a<b) {
       int x = partition(nums,a,b);
       quicksort(nums,a,x-1);
       quicksort(nums,x+1,b);
     }
 }

 private static int partition(int[] nums, int a, int b) {
	int x = nums[b];
    int i = a-1;
    
    for (int j=a;j<b;j++) {
       if (nums[j]<=x) {
          i++;
          swap(nums,i,j);
       }
    }
    swap(nums,i+1,b);
    return i+1;
 }

 private static void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
 }
 

private static void print(int[] a) {
	for(int i = 0; i<a.length;i++) {
		if(i<=a.length-2) {
		System.out.print(a[i]+" - ");
		}
		else {
			System.out.print(a[i]);
			System.out.println();
		}
	}
}


	
}