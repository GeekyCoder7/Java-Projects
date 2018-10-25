/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 9/04/2018
 *Associated files:Stack.java. 
 *Program Description: program that evaluates a postfix arithmetic expression.
 */




import java.util.Scanner;

public class Main {
static Stack stack = new Stack();
static Stack stack1 = new Stack();
static int result,num1,num2,index,index1,count_num,count_op;
static String number;
static boolean isValid=false;
private static Scanner scan;





	
	public static void main(String[] args) {//Main method
		String str="";
		scan = new Scanner(System.in);
		System.out.print("Enter an operation in postfix notation: ");
		str=scan.nextLine();
		isValid=postfixValidate(str);
		int i = postfixEvaluate(str);
		System.out.println(i);	
	}

	
	public static boolean postfixValidate(String s) {	
		int y=0;// index y	
		if(count_num==1+count_op&&index1==s.length()&&stack1.size()==1) {	
			
			return true;
		}
		else if(count_num<count_op&&index1==s.length()&&stack1.size()>1) {
			
			return false;
		}
		else if(index1==s.length()){
			
			return false;
		
		}
		
		else if(index1<s.length()) {
			if(s.charAt(0)==' ') {//if space
				return postfixValidate(s.substring(1));
			}
			
			while(s.charAt(y)!='+'&&s.charAt(y)!='-'&&s.charAt(y)!='*'&&	//when we have a number more than 1 digit , this method is processed until we reach a space (the end of the digit).
					s.charAt(y)!='/'&&s.charAt(y)!=' '&&
					s.charAt(y+1)!='+'&&s.charAt(y+1)!='-'&&
					s.charAt(y+1)!='*'&&s.charAt(y+1)!='/'&&s.charAt(y+1)!=' ') {
				y++;
			}
			
			if(s.charAt(y)!=' '&&s.charAt(y)!='*'&&s.charAt(y)!='+'&&s.charAt(y)!='-'&&s.charAt(y)!='/') { //if 1 digit number
				number=s.substring(0,y+1);
				
				int x=Integer.parseInt(number);
				count_num++;
				stack1.push(x);
				return postfixValidate(s.substring(index1+y+1));
			}

			else {//if operator (+ - / *)
				switch(s.charAt(0)) {
				case '+':
					num1 = stack1.pop();
					num2=stack1.pop();
					count_op++;
					result=num1+num2;
					stack1.push(result);
					return postfixValidate(s.substring(index1+1));
					
					
				case '-':
					count_op++;
					 num1 = stack1.pop();
					 num2=stack1.pop();
					result=num2-num1;
					stack1.push(result);
					return postfixValidate(s.substring(index1+1));
					
					
				case '/':
					count_op++;
					 num1 = stack1.pop();
					 num2=stack1.pop();
					result=num2/num1;
					stack1.push(result);
					return postfixValidate(s.substring(index1+1));
					
				case '*':
					count_op++;
					 num1 = stack1.pop();
					 num2=stack1.pop();
					result=num1*num2;
					stack1.push(result);
					return postfixValidate(s.substring(index1+1));
				}
			}
			
		}
		
		return postfixValidate(s.substring(index1));
	}
	
	
	
	
	public static int postfixEvaluate(String s) {
		int y=0;
	
		if(index>=s.length()) {
			
			return stack.print();
		}
		else if(!isValid) {//if not valid
			 System.out.println("Expression not valid. Can''t evaluate");
			 return 0;
		 }
		 else if(isValid) {//if valid, continue
			if(index<s.length()) {
				if(s.charAt(0)==' ') {//if space
					return postfixEvaluate(s.substring(1));
				}
				
				while(s.charAt(y)!='+'&&s.charAt(y)!='-'&&s.charAt(y)!='*'&&//when we have a number more than 1 digit , this method is processed until we reach a space (the end of the digit).
						s.charAt(y)!='/'&&s.charAt(y)!=' '&&
						s.charAt(y+1)!='+'&&s.charAt(y+1)!='-'&&
						s.charAt(y+1)!='*'&&s.charAt(y+1)!='/'&&s.charAt(y+1)!=' ') {
					y++;
				}
				
				if(s.charAt(y)!=' '&&s.charAt(y)!='*'&&s.charAt(y)!='+'&&s.charAt(y)!='-'&&s.charAt(y)!='/') { //if 1 digit number
					number=s.substring(0,y+1);
					
					int x=Integer.parseInt(number);
					
					stack.push(x);
					return postfixEvaluate(s.substring(index+y+1));
				}

				else {//if operator (+ - / *)
					switch(s.charAt(0)) {
					case '+':
						num1 = stack.pop();
						num2=stack.pop();
						result=num1+num2;
						stack.push(result);
						return postfixEvaluate(s.substring(index+1));
						
						
					case '-':
						 num1 = stack.pop();
						 num2=stack.pop();
						result=num2-num1;
						stack.push(result);
						return postfixEvaluate(s.substring(index+1));
						
						
					case '/':
						 num1 = stack.pop();
						 num2=stack.pop();
						result=num2/num1;
						stack.push(result);
						return postfixEvaluate(s.substring(index+1));
						
					case '*':
						 num1 = stack.pop();
						 num2=stack.pop();
						result=num1*num2;
						stack.push(result);
						return postfixEvaluate(s.substring(index+1));
					}
				}
				
			}
		 }
		
		
		  
		return postfixEvaluate(s.substring(index+1));
	}
}
