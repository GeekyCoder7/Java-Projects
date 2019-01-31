
public class ShellSort {

	public static void shellSort(int gap, int[]a) {
		if(gap==0) {
			print(a);
			return;
		}
		else {
			for(int i=gap;i<a.length;i++) {
				for(int j=i;j>=gap;j=j-gap) {
					if(a[j]<a[j-gap]) {
						swap(a,j,j-gap);
					}
				}
			}
			shellSort(gap/2,a);
		}
	}

	public static void print(int[]a) {
		for(int i =0; i<a.length;i++) {
			System.out.print(a[i]+" - ");
		}
	}
	
	 private static void swap(int[] nums, int a, int b) {
		    int temp = nums[a];
		    nums[a] = nums[b];
		    nums[b] = temp;
		 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,5,8,4,6,2,4,7,2,1,5,4,55,11,22,44,99,88,77,66,596};
		shellSort(a.length/2,a);
	}

}
