
public class BubbleSort {

	
	public void BubbleSort(int[]a) {
		for(int i=0; i<a.length-1;i++) {
			if(a[i]>a[i+1]) {
			int temp=a[i];
			a[i]=a[i+1];
			a[i+1]=temp;
			}
			
		}
		checkSorted(a);
	}
	
	public void checkSorted(int[]a) {
		int i =0;
		
			for(int j=0;j<a.length-1;j++) {
				if(a[j]>a[j+1]) {
					i++;
					
				}
		}
			if(i==0) {
				print(a);
			}
			
			if(i>0) {
				BubbleSort(a);
			}
	}
	
	
	public void print(int[] a) {
		for(int i =0; i<a.length;i++) {
			System.out.print(a[i]+" - ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort b = new BubbleSort();
		int a[] = {1,5,8,4,6,2,4,7,2,1,5,4,55,11,22,44,99,88,77,66,596};
		b.checkSorted(a);
	}

}
