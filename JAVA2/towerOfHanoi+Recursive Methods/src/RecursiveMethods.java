/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 23/02/2018
 *Associated files: No associated files.
 *Program Description: A Program with Recursive Methods
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class RecursiveMethods {
    Scanner scan= new Scanner(System.in);
    static String s1="";
    
    
    public static void printMenu() {        //A default printMenu method which prints the menu(Used to simplify code in the main())
        System.out.println("1. Find");
        System.out.println("2. Remove Duplicates");
        System.out.println("3. Count Words");
        System.out.println("4. Repeat");
        System.out.println("5. Exit");
        System.out.println("---------------------");
        System.out.println("Enter a choice:");
    }
    
    public static boolean Find( int[] nums, int number,int i){    //This methods searches by recursion an integer in an array of integer
        
        boolean Found =false;
        if(i==nums.length-1&&!Found) { //if the index i reaches to the last one , and the number is still not found , we return false.
            return false;
        }
        
        if(number==nums[i]) {    //otherwise, if we find the number at index i , we return true.
            Found=true;
            return true;
        }
        
        return Find(nums,number,i+1); //this method recursively searches the number in the array, from index i (which is set to 0 by default), to the last index.
    }
    
    public static String removeDuplicats(String s)
    {
        if (s.length()<= 1) { //if the string is an empty string or has only 1 character, return that string as it is.
            return s;
        }
        if(s.substring(1,2).equals(s.substring(0,1))) { //if the first and the second characters are the same, we remove them.
            return removeDuplicats(s.substring(1));
        }
        else {
            return s.substring(0,1)+removeDuplicats(s.substring(1));
        }
    }
    
    public static int countWords(String s) {//This method counts the number of words in a string
        if (s.isEmpty()) { //if s.length()=0, we return 0.
            return 0;
            
        }
        if (s.indexOf(" ")==-1) {//if there is no space in the string, we return 1.(only one string in the sentence).
            return 1;
        }
        return 1+countWords(s.substring(s.indexOf(" ")+1));//else if there is a space in the string, we jump to the next string after the space and we count the words accordingly.
    }
    
    private static String repeat(String s,int n){ //this method returns a new string s1, which is the string s repeated n times.
        
        if(n > 0){ //if n>0 , we add s to s1
            s1+=s;
        }
        if(n==0) { //if n is 0 , we return s1
            return s1;
        }
        
        return repeat(s,n-1); //Recursive method that adds s to s1 until n becomes 0.
    }
    
    public static void main(String[] args) {
        int num=0,count=0;
        String input="",input1="";
        int[] Nums = new int[10];
        boolean found=false,stop=false,isInt=false;
        RecursiveMethods rm =new RecursiveMethods();
        
        
        while(true){
            
            printMenu();
            
            try {
                num=rm.scan.nextInt();
            }
            catch(InputMismatchException e) {
                System.out.print("Please enter a number");
            }
            rm.scan.nextLine();
            
            switch(num){
                case 1:
                    System.out.println("Do you want to add numbers in the array? (y/n)");
                    input=rm.scan.next();
                    if(input.equalsIgnoreCase("y")) {
                        stop=false;
                    }
                    
                    while(!stop) {
                        
                        while(!isInt){
                            try {
                                System.out.println("Enter a number to put in the array:");
                                num=rm.scan.nextInt();
                                isInt = true;
                            }
                            catch(InputMismatchException e) {
                                System.out.print("Error. ");
                            }
                            rm.scan.nextLine();
                            
                        }
                        isInt=false;
                        if(count==Nums.length){        //If the initial size of the array gets full, this method automatically creates a new array 2x bigger
                            
                            int[] temp = new int[Nums.length*2+1];
                            
                            for (int i=0;i<count;i++){
                                temp[i]=Nums[i];
                            }
                            Nums=temp;
                        }
                        Nums[count]=num;
                        count++;
                        System.out.println("Do you want to continue adding? (y/n)");
                        input=rm.scan.next();
                        if(input.equalsIgnoreCase("n")) {
                            stop=true;
                            
                        }
                    }
                    System.out.println("Enter a number to search in the array:");
                    num = rm.scan.nextInt();
                    found=Find(Nums, num,0);
                    if(found){
                        System.out.println(num+" is found.");
                    }
                    else {
                        System.out.println(num+" is not found.");
                    }
                    
                    break;
                case 2:
                    System.out.println("Enter a string: ");
                    input=rm.scan.next();
                    input1=removeDuplicats(input);
                    System.out.println("Old String: "+input+", New String: "+input1);
                    break;
                case 3:
                    System.out.println("Enter a phrase: ");
                    input=rm.scan.nextLine();
                    System.out.println("Number of words in this String: "+
                                       countWords(input));
                    break;
                case 4:
                    String s;
                    System.out.println("Enter a string: ");
                    input=rm.scan.next();
                    
                    while(!isInt){
                        try {
                            System.out.println("Enter the number of repetition: ");
                            num=rm.scan.nextInt();
                            isInt = true;
                        }
                        catch(InputMismatchException e) {
                            System.out.print("Error. ");
                        }
                        rm.scan.nextLine();
                        
                    }
                    isInt=false;
                    
                    
                    s= repeat(input, num);
                    System.out.println("Repeated String: "+s);
                    break;
                case 5:
                    System.out.println("Application Closed.");
                    System.exit(0);
                default:
                    System.out.println("(Invalid Number)");
                    break;
            }
        }
    }
}

