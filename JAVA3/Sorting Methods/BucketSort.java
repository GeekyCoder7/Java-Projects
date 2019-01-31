
public class BucketSort {
	public static int[] bucketSort(int[] nums) {
		int num = nums[0];
		int nums_length= nums.length;

		for(int i = 0;i<nums.length;i++) {//find greatest element
			if(num<nums[i]) {
				num=nums[i];
			}
			
		}
		int[] bucket= new int[12];
		
		for(int i=0;i<nums.length;i++) {
			bucket[nums[i]]++;
		}
		nums = new int[nums_length];
		int j =0;
		for(int i=0;i<num;i++) {
			int count = bucket[i];
			while(count>0) {
				nums[j]=i;
				j++;
				count--;
			}
		}
		return nums;
	}
	public static void print(int[]a) {
		for(int i =0; i<a.length-1;i++) {
			System.out.print(a[i]+" - ");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {0,1,1,4,2,8,6,11,2};
		a=bucketSort(a);
		print(a);
	}

}
