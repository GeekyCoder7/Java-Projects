package pretoPost;

public class Main {

	
	public static String pretoPost(String s, Stack s1){
		if(s.length()==0){
			return s1.pop();
		}
		else if(s.charAt(s.length()-1)=='+'||s.charAt(s.length()-1)=='-'||
				s.charAt(s.length()-1)=='*'||s.charAt(s.length()-1)=='/'){
			s1.push(s1.pop()+" "+s1.pop()+" "+s.charAt(s.length()-1));
			return pretoPost(s.substring(0, s.length()-1),s1);
		}
		else if(s.charAt(s.length()-1)>='0'&&s.charAt(s.length()-1)<='9'){
			s1.push(s.charAt(s.length()-1)+"");
			return pretoPost(s.substring(0, s.length()-1),s1);
		}
		else return pretoPost(s.substring(0, s.length()-1),s1);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s1 = new Stack();
System.out.println(pretoPost("+ 3 * 2 5",s1));
	}

}
