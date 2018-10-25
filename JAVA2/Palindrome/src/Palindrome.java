

public class Palindrome {

	public static boolean numberOfCopies(String s, String sub, int n){
	
	
		if(n==0){
			return true;
		}
		if(s.length()<sub.length()){
	
			return false;
	}
	else
		if(s.substring(0,sub.length()).equals(sub)){
			n--;
		}

	return  numberOfCopies(s.substring(1), sub, n);
}
	
	
	public static boolean isPalindrome(String str) {
		
	        if(str.length()==0||str.length()==1){
	            return true; 
	        }
	        
	        if(str.charAt(0)==str.charAt(str.length()-1)){
	            return isPalindrome(str.substring(1,str.length()-1));
	        }
	        
	        return false;
	        
	    }

	
	public static void main(String[] args) {
		String str="HAHAHAYZ";
		System.out.println(numberOfCopies(str,"HA",3));
		
	}

}
