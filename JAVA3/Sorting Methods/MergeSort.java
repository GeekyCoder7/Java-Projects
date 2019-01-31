
public class MergeSort {
	
	public static int[] merge(int[]a,int []b) {
		int[]c = new int[a.length+b.length];
		int index_a=0, index_b=0;
		for(int index_c =0;index_c<c.length;index_c++) {
			if(a[index_a]<=b[index_b]) { //a<=b
				c[index_c]=a[index_a];
				index_a++;
				index_c++;
			}
			else if(b[index_b]<a[index_a]) { //b<a
				c[index_c]=b[index_b];
				index_b++;
				index_c++;
			}
			else if(a.length==index_a) { //a is exhausted
				c[index_c]=b[index_b];
				index_b++;
				index_c++;
			}
			else if(b.length==index_b) { //b is exhausted
				c[index_c]=a[index_a];
				index_a++;
				index_c++;
			}
			
		}
	print(c);
	return c;
	}
	
	
	public static int[] mergeSort(int[] a,int l , int r) {
		if(r<=l) {
			return null;
		}
		int m =(r+l)/2;
		int[] b=mergeSort(a,l,m);
		int[] c=mergeSort(a,m+1,r);
		return merge(b,c);
	}
	
	public static void print(int[] a) {
		for(int i =0; i<a.length;i++) {
			System.out.print(a[i]+" - ");
		}
	}
	public static void main(String[] args) {
		int[] a = {1,3,8,21,332,6,9,20,30,40};//reverse order
		
		mergeSort(a,0,a.length);
	}
}
