
public class InsertionSort {

	public static void InsertionSort(int[]a) {
		for(int i =0;i<a.length;i++) {
			for(int j =i;j>0&&a[j]<a[j-1];j--) {
				int temp = a[j];
				a[j]=a[j-1];
				a[j-1]=temp;
			}
		}
		print(a);
	}
	
	public static void print(int[]a) {
		for(int i =0; i<a.length;i++) {
			System.out.print(a[i]+" - ");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,5,8,4,6,2,4,7,2,1,5,4,55,11,22,44,99,88,77,66,596};
		InsertionSort(a);
	}

}
