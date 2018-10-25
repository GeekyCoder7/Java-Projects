package lab10;
import java.util.*;
public class Queue1 {
static ArrayList <String> aL = new ArrayList<String>();


public static void EnQueue(String item){
	aL.add(item);
}

public static void DeQueue(){
	if(!aL.isEmpty()){
	aL.remove(0);
}
	else{
		System.out.println("ArrayList is empty");
	}
}

public static void removeObj(String item){
	if(!aL.isEmpty()){
	aL.remove(item);
}
	else{
		System.out.println("ArrayList is empty");
	}
}

public static void removeObjLocation(int item){
	if(!aL.isEmpty()){
	aL.remove(item);
}
else{
	System.out.println("ArrayList is empty");
}
}

public static String print(){
	String str= aL.toString();
	return str;
}

}
