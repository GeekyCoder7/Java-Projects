
/*Name: Nazareth H. Keshishian
 *Student ID: 201701143
 *Date Last Modified: 18/10/2018
 *Associated files: Job.java. 
 * Program Description: Heap.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Heap {
    Job[] heap;
    int end;
    
    public Heap(){
        heap = new Job[100];
        end = 1;
        try {
            File file = new File("jobs.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNext()){
                String[] line = (scan.nextLine()).split(",");
                insert(line[0], Integer.parseInt(line[1]));
            }
        }catch(FileNotFoundException e){
            System.out.println("Couldn't read file");
        }
    }
    

    public boolean prioritize(String owner){    //O(n+lgn)=O(n)
        for(int i=1 ;i<end; i++){
            if(heap[i].getOwner().equalsIgnoreCase(owner)){
                heap[i].length = heap[1].length -1;
                swim(i);
                return true;
            }
        }
        return false;
    }
    
    public void printMenu(){
        int ans = 0;
        Scanner scan = new Scanner(System.in);
        while(ans!=6){
            ans = 0;
            while(true){
                try{
                	System.out.println("1.Insert");
                    System.out.println("2.Delete");
                    System.out.println("3.Prioritize");
                    System.out.println("4.ShowD");
                    System.out.println("5.ShowI");
                    System.out.println("6.Exit");
                    ans = scan.nextInt();
                    break;
                }catch(Exception e){
                    scan.nextLine();
                }
                System.out.println("Wrong input!");
            }
            switch(ans){
                case 1:{
                    System.out.println("Enter Name:");
                    String name = scan.next();
                    System.out.println("Enter length:");
                    int pri = -1;
                    while(true){
                        try{
                            pri = scan.nextInt();
                            break;
                        }catch(Exception e){
                            scan.nextLine();
                            System.out.println("wrong input!");
                        }
                    }
                    if(pri<0){
                        System.out.println("Priority can't be negative");
                    }
                    else {
                        insert(name, pri);
                        System.out.println("Success");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Enter Name:");
                    String name = scan.next();
                    boolean a = delete(name);
                    if(a)
                        System.out.println("Success");
                    else System.out.println("Name not found");
                    break;
                }
                case 3:{
                    System.out.println("Enter Name:");
                    String name = scan.next();
                    boolean a = prioritize(name);
                    if(a)
                        System.out.println("Success");
                    else System.out.println("Name not found");
                    break;
                }
                case 4:{
                    showD();
                    break;
                }
                case 5:{
                    showI();
                    break;
                }
                case 6:{
                    System.out.println("Program terminated");
                    break;
                }
                default:{
                    System.out.println("Invalid input!");
                }
            }
        }
    }

    public void showI(){ 	//O(nlgn)
        int[] array = toArray();
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    
    
    public void showD(){	//O(nlgn)
        int[] array = toArray();
        for(int i=array.length -1; i>=0; i--){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    
    
    public int[] toArray(){	//O(nlgn)
        int[] array = new int[end-1];
        int count = 0;
        Job[] oldheap = new Job[heap.length];
        int oldend = end;
        for(int i=1; i<end; i++){
            oldheap[i] = heap[i];
        }
        while(end>1){
            array[count++] = heap[1].length;
            deleteMax();
        }
        heap = oldheap;
        end = oldend;
        return array;
    }
    
    
    public void insert(String owner, int length){//O(lgn)
        increaseCapacity();
        heap[end] = new Job(owner, length);
        swim(end);
        end++;
    }
    
    
    public void deleteMax(){//O(lgn)
        heap[1] = heap[end-1];
        heap[end--] = null;
        sink(1);
    }
    
   
    public boolean delete(String owner){ //O(n+lgn)=O(n)
        for(int i=1 ;i<end; i++){
            if(heap[i].getOwner().equals(owner)){
                heap[i] = heap[end-1];
                heap[end--] = null;
                sink(i);
                swim(i);
                return true;
            }
        }
        return false;
    }
    

    public int sink(int i){     //O(lgn)
        while((i*2<end && heap[i].length>heap[2*i].length)
        		||(i*2+1<end && heap[i].length>heap[2*i+1].length)){
            if(i*2+1<end && heap[2*i].length>heap[2*i+1].length){
                Job temp = heap[i];
                heap[i] = heap[i*2+1];
                heap[i*2+1] = temp;
                i = i*2+1;
            }
            else {
                Job temp = heap[i];
                heap[i] = heap[i*2];
                heap[i*2] = temp;
                i = i*2;
            }
        }
        return i;
    }
    
    //O(lgn)
    public int swim(int i){
        while(i>1 && heap[i].length<heap[i/2].length){
            Job temp = heap[i];
            heap[i] = heap[i/2];
            heap[i/2] = temp;
            i = i/2;
        }
        return i;
    }
    
    private void increaseCapacity(){
        if(heap.length==end){
            Job[] heap_n = new Job[end*2];
            for(int i=1; i<end; i++){
            	heap_n[i] = heap[i];
            }
            heap = heap_n;
        }
    }
    
    public static void main(String[] args){
        Heap heap = new Heap();
        heap.printMenu();
    }
}


