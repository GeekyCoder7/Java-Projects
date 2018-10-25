

import pretoPost.Stack;

public class Main {


	public static void inFixToPreFix(String s){
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		Stack s3= new Stack();
		String str="",str1="";
		for(int i =0;i<s.length();i++){
			if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
				s1.push(Character.toString(s.charAt(i)));
			}
			
			else if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/'){
				s2.push(Character.toString(s.charAt(i)));
			}
			
			else if(s.charAt(i)==')'){
				str = s2.pop()+" "+s1.pop()+" "+s1.pop();
				System.out.println(str);
				s3.push(str);
				s3.printAll();
				
			}
		}
		
		
		
	}
	
		public static void main(String[] args){
			inFixToPreFix("(3+(2*5))");
			//System.out.println(inFixToPreFix("(3+(2*5))"));
		}
		
}
