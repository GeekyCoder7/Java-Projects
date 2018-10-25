package lab7;
import java.util.Scanner;
public class GradeReport {
	public static void main(String[] args){
int i=0, j=0,x=0,y=0,min=100,max=0,sum=0,c=0;
double avg;
Scanner scan = new Scanner(System.in);
System.out.println("Enter a grade between 0 and 100");
i=scan.nextInt();
		while(i!=-1){
			c++;
			if(i<60){
				j++;
			}
			
			if(i>=60&&i<=80){
				x++;
			}
			
			else if (i>80){
				y++;
			}
			sum+=i;
			if(i<=min){
				min=i;
			}
			
			if(i>=max){
				max=i;
			}
			i=scan.nextInt();
		}
		avg=sum/c;
		System.out.println("Grade State:");
		System.out.println("Number of Grades below 60: "+j);
		System.out.println("Number of Grades between 60 and 80: "+x);
		System.out.println("Enter a grade above 80: "+y );
		System.out.println("Minimum Grade: "+min );
		System.out.println("Maximum Grade: "+max );
		System.out.println("Average of all grades: "+avg );
	}
}