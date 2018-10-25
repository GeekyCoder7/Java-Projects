import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=0;
		String a = "AxBxXC";
		int [] arr ={0,6,2,3,4,7,8,9};
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number");
		number=scan.nextInt();

		System.out.println("The result "+" is: "+count8(number));
	}
	
	public static int Factorial(int z){
		if(z==0){
			return 1;
		}
		return Factorial(z-1)*z;
				
	}
	
	public static int countEars(int numberOfBunnies){
		if(numberOfBunnies==0){
			return 0;
		}
		
		else
		return 2+countEars(numberOfBunnies-1);
	}
	
	public static int powerN(int n, int m){
		if(m==0){
			return 1;
		}
		return powerN(n,(m-1))*n;
	}
	
	public static boolean contains6(int[] arr, int index){
		
	 if(index>=arr.length){
			
			return false;
		}
		
	 else if(arr[index]==6){
			
			return true;
		}
	
		return contains6(arr,index+1);
	

}
	
	public static String moveX(String str){
	if(str.length()==0){
		return "";
	}
	else if (str.charAt(0)!='x'){
		return str.charAt(0)+moveX(str.substring(1));
	}
	else{
		return moveX(str.substring(1))+str.charAt(0);
	}
}
	
	public static int Fibonacci(int n){
		if(n==0){
			return 0;
		}
		if(n==1||n==2){
			return 1;
		}
		
		return Fibonacci(n-1)+Fibonacci(n-2);
	}
	
	public static int count8(int n){
		if(n==8){
			return 1;
		}
		else if(n%100==88){
		return count8(n/10)+2;
	}
		else if(n%10==8){
			return count8(n/10)+1;
		}
		else 
			return count8(n/10);
	}
}
