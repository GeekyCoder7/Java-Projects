
public class SelectionSort {
	
		
	public void selectionSort(int[]a) {
		for(int j=0;j<a.length;j++) {
			int min=a[0];
			int index=0;
			for(int i=j; i<a.length;i++) {
				if(a[i]<min) {
					 index=i;
					min=a[i];
				}
			
				
			}
		
		a[index]=a[j];
		a[j]=min;
		
		
	}
		
		print(a);
}
	
	public void print(int[] a) {
		for(int i =0; i<a.length;i++) {
			System.out.print(a[i]+" - ");
		}
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
				selectionSort(a);
			}
	}
	
	
	public static void main(String[] args) {
		SelectionSort s = new SelectionSort();
		int a[] = {8,5,8,4,6,2,4,7,2,1,5,4,55,11,22,44,99,88,77,66,596};
		s.selectionSort(a);
	}
	
}
