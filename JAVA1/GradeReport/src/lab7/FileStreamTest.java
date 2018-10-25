package lab7;
import java.io.*;
import java.util.Scanner;
public class FileStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int counter=0;
		try{
			File inputFile = new File("C:/Users/201701143/Desktop/Dev/lab7/src/lab7/source.txt");
			File outputFile = new File("C:/Users/201701143/Desktop/Dev/lab7/src/lab7/destination.txt");
			
			//Scanner scan = new Scanner(inputFile);
			//str=scan.nextLine();
			FileInputStream fis = new FileInputStream(inputFile);
			FileOutputStream fos = new FileOutputStream(outputFile);
			int c;
			
			while((c=fis.read())!=-1){
				fos.write(c);
				counter++;
				
				System.out.println("Copying the charcter was finished successfully!");
				
			}
			fis.close();
			fos.close();
		}	catch (FileNotFoundException e){
			System.err.println("FileStreamstest: "+e);
			
		}	catch(IOException e){
			System.err.println("FileStreamsTest: "+e);
		}
		
		//System.out.println("Number of characters "+ (str.length()));
		System.out.println("Number of characters "+ counter);
		
		
	}

}
