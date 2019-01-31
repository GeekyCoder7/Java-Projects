
public class QuickSort {

	public void quickSort(int[]a, int left, int right) {
		 partition(a,left,right);
		int pivot = (left+right)/2;
		quickSort(a,left,pivot);
		quickSort(a,pivot+1,right);
	}
	
	 private void partition(int[]a, int left, int right) {
		 int pivot = (left+right)/2;
		 for(int i =0;i<pivot;i++) {
			 if(a[i]<pivot) {
				 
			 }
		 }
		 
		 }
	 
	 private  void swap(int[] nums, int a, int b) {
		    int temp = nums[a];
		    nums[a] = nums[b];
		    nums[b] = temp;
		 }
		 

}
