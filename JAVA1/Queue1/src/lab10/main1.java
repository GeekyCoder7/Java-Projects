package lab10;
import java.util.*;
public class main1 {
	
 

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num =0, index=0;
		String str1="", str2="",str3="";
		for(int i =1;i>0;i++){
		System.out.println("1. Enqueue");
		System.out.println("2. Dequeue");
		System.out.println("3. Remove");
		System.out.println("4. Print ArrayList");
		
		System.out.println("5. Exit");
		String str;
		num = scan.nextInt();
		if(num==1){
			System.out.println("Enter object to Enqueue: ");
			str1=scan.next();
			//index=scan.nextInt();
			//Queue1.EnQueue(index);
			Queue1.EnQueue(str1);
		}
		
		else if(num==2){
			
			Queue1.DeQueue();
		}
		
else if(num==3){
	System.out.println("Do you want to remove by object or by index?");
	str2=scan.next();
	if (str2.equals("object")){
		System.out.println("Enter object: ");
		str3=scan.next();
		Queue1.removeObj(str3);
	}
	else if(str2.equals("index")){
		System.out.println("Enter index: ");
		index=scan.nextInt();
		Queue1.removeObjLocation(index);
	}
			//Queue1.remove();
		}
		else if(num==4){
			str=Queue1.print();
			System.out.println(str);
			
		}
		
		else if(num==5){
			System.exit(0);
		}
		else {
			System.out.println("Invalid number: Please try again.");
			
		}
		
		
	}
	}

}
