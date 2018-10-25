package lab3;

public class StringPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String college = new String ("PoDunk College");
		String town = "Anytown, USA";												//part(a)
		int stringLength;
		String change1, change2, change3;
		stringLength = college.length();												//part(b)
		System.out.println(college + " contains "+ stringLength + " characters.");
		change1=college.toUpperCase();
		change2=change1.replace('O', '*');
		change3=college.concat(town);
		System.out.println(change1);
		System.out.println(change2);
		System.out.println("The final string is "+change3);
		
	}

}
