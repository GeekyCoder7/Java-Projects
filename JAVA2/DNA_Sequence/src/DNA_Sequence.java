/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 19/03/2018
 *Associated files:Node.java, Main.java. 
 *Program Description: DNA Sequence, contains all the behavior and characteristics of a DNA.
 */

import java.util.Random;


public class DNA_Sequence {	//A constructor for instantiation
protected Node header;	
protected int count;
protected boolean isValidated;
public DNA_Sequence() {
	header=null;
	count=0;
	isValidated=false;
}




public String complementarySTR(String str) {	//method that takes a string, which should be a DNA strand, and generates its complimentary.
	String strc="";
	while(str.length()>=1) {
		if(str.charAt(0)=='A') {	//replace A with T
			strc+="T";
		}
		if(str.charAt(0)=='G') {//replace G with C
			strc+="C";		
				}
		if(str.charAt(0)=='C') {//replace C with G
			strc+="G";
		}
		if(str.charAt(0)=='T') {//replace T with A
			strc+="A";
		}
str=str.substring(1,str.length());
	}
	return strc;
}
public void insertBase(DNA_Sequence d, double probability,DNA_Sequence dll) { //method randomly selects a location and the base to add in its specific location
	Random rand = new Random();
	double random = rand.nextDouble();
	if(probability>=random&&probability<=1) {
	int base_remover=rand.nextInt(13)+3; //from 3 to 15, used if the length is more than 18
	int location_selector = rand.nextInt(12)+3;//from 3 to 14 
	int base_selector = rand.nextInt(4);//from 0 to 3 
	String str_1 = d.printAll();
	String str_1c="";
	
	
	

	switch(base_selector) {
	case 0://adds A at location_selector
		str_1=str_1.substring(0,location_selector)+"A"+str_1.substring(location_selector,str_1.length());
		System.out.println("Nucleotide added, but this strand is invalid. Has more than 18 nucleotides.\n"
				+ "The system is going to remove a random nucleotide automatically in order to make this strand valid,\n"
				+ "and save the strand.");

		str_1=str_1.substring(0,base_remover)+str_1.substring(base_remover+1,str_1.length());
		d.addSequence(str_1);
		str_1c= complementarySTR(str_1);
		dll.addCompSequence(str_1c);
		break;
	case 1://adds C at location_selector
		str_1=str_1.substring(0,location_selector)+"C"+str_1.substring(location_selector,str_1.length());
		System.out.println("Nucleotide added, but this strand is invalid. Has more than 18 nucleotides.\n"
				+ "The system is going to remove a random nucleotide automatically in order to make this strand valid,\n"
				+ "and save the strand.");

		str_1=str_1.substring(0,base_remover)+str_1.substring(base_remover+1,str_1.length());
		d.addSequence(str_1);
		 str_1c= complementarySTR(str_1);
		dll.addCompSequence(str_1c);
		break;
	case 2://adds G at location_selector
		str_1=str_1.substring(0,location_selector)+"G"+str_1.substring(location_selector,str_1.length());
		System.out.println("Nucleotide added, but this strand is invalid. Has more than 18 nucleotides.\n"
				+ "The system is going to remove a random nucleotide automatically in order to make this strand valid,\n"
				+ "and save the strand.");
		str_1=str_1.substring(0,base_remover)+str_1.substring(base_remover+1,str_1.length());
		d.addSequence(str_1);
		 str_1c= complementarySTR(str_1);
		dll.addCompSequence(str_1c);
		break;
	case 3://adds T at location_selector
		str_1=str_1.substring(0,location_selector)+"T"+str_1.substring(location_selector,str_1.length());
		System.out.println("Nucleotide added, but this strand is invalid. Has more than 18 nucleotides.\n"
				+ "The system is going to remove a random nucleotide automatically in order to make this strand valid,\n"
				+ "and save the strand.");

		str_1=str_1.substring(0,base_remover)+str_1.substring(base_remover+1,str_1.length());
		d.addSequence(str_1);
		 str_1c= complementarySTR(str_1);
		dll.addCompSequence(str_1c);
		break;
	}
	System.out.print("New Strand after insertion and deletion: ");
	d.print_All();
	}
	 if(probability>1) {
		System.out.println("Invalid Probability");
	}
	 else {
			System.out.println("No deletion or insertion occured.");
		}
	}
	
	
	
	


public void deleteBase(DNA_Sequence d, double probability,DNA_Sequence dll) { //method randomly selects a location and the base to delete in its specific location
	Random rand = new Random();
	double random = rand.nextDouble();
	
	if(probability>=random&&probability<=1) {
	Node current = d.header.getNext();
	String str="",str1="",str2="",str3c="";
	int base_location=0,base_selector=0,location_selector=0;
	
	base_location = rand.nextInt(12);
	switch(base_location) {
	
	case 0:
	str=current.getData();
	str=str.substring(1,str.length());
	current.setData(str);
	break;
	
	case 1:
		str=current.getData();
		str=str.substring(0,1)+str.substring(2);
		current.setData(str);
		break;
		
	case 2:
		str=current.getData();
		str=str.substring(0,2);
		current.setData(str);
		break;
		
	case 3:
		current=current.getNext();
		str=current.getData();
		str=str.substring(1,str.length());
		current.setData(str);
		break;
		
		case 4:
			current=current.getNext();
			str=current.getData();
			str=str.substring(0,1)+str.substring(2);
			current.setData(str);
			break;
			
		case 5:
			current=current.getNext();
			str=current.getData();
			str=str.substring(0,2);
			current.setData(str);
			break;
		case 6:
			current=current.getNext().getNext();
			str=current.getData();
			str=str.substring(1,str.length());
			current.setData(str);
			break;
			
			case 7:
				current=current.getNext().getNext();
				str=current.getData();
				str=str.substring(0,1)+str.substring(2);
				current.setData(str);
				break;
				
			case 8:
				current=current.getNext().getNext();
				str=current.getData();
				str=str.substring(0,2);
				current.setData(str);
				break;
			case 9:
				current=current.getNext().getNext().getNext();
				str=current.getData();
				str=str.substring(1,str.length());
				current.setData(str);
				break;
				
				case 10:
					current=current.getNext().getNext().getNext();
					str=current.getData();
					str=str.substring(0,1)+str.substring(2);
					current.setData(str);
					break;
					
				case 11:
					current=current.getNext().getNext().getNext();
					str=current.getData();
					str=str.substring(0,2);
					current.setData(str);
					break;
					
		
	}
	
	System.out.print("New Strand after deletion: ");
	d.print_All();
	System.out.println("The DNA strand is now invalid. The system will automatically add a new base in a random location.");
	String str_1 = d.printAll();
	str1=str_1.substring(0,3);
	str2=str_1.substring(str_1.length()-3,str_1.length());
	str_1=str_1.substring(3,str_1.length()-3);
	String str3;
	

	location_selector=rand.nextInt(5); //from 0 to 4
	base_selector = rand.nextInt(4);//from 0 to 3 
	switch(base_selector) {
	case 0://ADD A AT A RANDOM POSITION
		str_1=str_1.substring(0,location_selector)+"A"+str_1.substring(location_selector,str_1.length());
		str3=str1+str_1+str2;
		
		d.addSequence(str3);
		str3c=complementarySTR(str3);
		dll.addCompSequence(str3c);
		break;
	case 1://C
		str_1=str_1.substring(0,location_selector)+"C"+str_1.substring(location_selector,str_1.length());
		str3=str1+str_1+str2;
		d.addSequence(str3);
		str3c=complementarySTR(str3);
		dll.addCompSequence(str3c);
		break;
	case 2://G
		str_1=str_1.substring(0,location_selector)+"G"+str_1.substring(location_selector,str_1.length());
		str3=str1+str_1+str2;
		d.addSequence(str3);
		str3c=complementarySTR(str3);
		dll.addCompSequence(str3c);
		break;
	case 3://T
		str_1=str_1.substring(0,location_selector)+"T"+str_1.substring(location_selector,str_1.length());
		str3=str1+str_1+str2;
		d.addSequence(str3);
		str3c=complementarySTR(str3);
		dll.addCompSequence(str3c);
		break;
	}
	System.out.print("New Strand after re-insertion: ");
	d.print_All();
	}
	else if(probability>1) {
		System.out.println("Invalid Probability");
	}
	else {
		System.out.println("No deletion or insertion occured.");
	}
}





public void addSequence(String str) {	//add the dna sequence in the linkedlist
	
	
	Node current1;
	
	
	if(str.length()<18) {
		System.out.println("Invalid Sequence.(Does not Contain 18 Nucleotides)");
		count++;
		return;
	}
	else if(str.length()==18) {
	
		if(str.substring(0,3).equals("TAC")) {
	header = new Node(str.substring(0,3));
		}
		
		else {
		System.out.println("Invalid Sequence.");
		count++;
		return;
		}
		Node tail = header;
		Node current =header;
		
	
	while(str.length()>=3) {
		str=str.substring(3,str.length());
		if(str.length()>3) {
		current1 = new Node (str.substring(0,3));
		current.setNext(current1);
		current=current.getNext();
		}
		if(str.length()==3) {
			if(str.substring(0,3).equals("ATT")||str.substring(0,3).equals("ATC")||str.substring(0,3).equals("ACT")) {
			current1 = new Node (str.substring(0,3));
			current.setNext(current1);
			current=current.getNext();
			}
			else {
				System.out.println("Invalid Sequence. Sequence must terminate with a stop codon");
				count++;
				return;
			}
		}
		current=header;
		while(tail.getNext()!=null) {
			tail=tail.getNext();
		}

		while(current.getNext()!=null) {
			if(current.getData().equals("ATT")||current.getData().equals("ATC")||current.getData().equals("ACT")) {
				if(current!=tail) {
					System.out.println("Invalid Sequence.(Contains a stop codon in the middle of the sequence)");
					count++;
					return;
				}
			}
			current=current.getNext();
		}
	}
	isValidated=true;
	}
}

public void mutateDNA(DNA_Sequence d, double probability,DNA_Sequence dll) {//method that mutate DNA randomly according to the probability inserted.
	Random rand = new Random();
	double random = rand.nextDouble();
	
	if(probability>1) {
		System.out.println("Probability can't be greater than 1");
	}
	else if(probability>=random&&probability<=1) {
	
	Node current = d.header.getNext();
	int numStrand,numBase,base;
	String str="",str1="";
	
	for(double repeat = 12.0*probability;repeat>0;repeat--) {//12*proba, because we have 12 nucleotides eligible to mutation
		current = d.header.getNext();
	numStrand = rand.nextInt(4);
	while(numStrand>0) {
		current=current.getNext();
		numStrand--;
	}
	str=current.getData();
	 numBase = rand.nextInt(3)+1;
	 base = rand.nextInt(3)+1;
	 
	 if(numBase==1) {
			if(base==1) {
				str="A"+str.substring(1,str.length());
			} 
			else if(base==2) {
				str="C"+str.substring(1,str.length());
			} 
			else if(base==3) {
				str="G"+str.substring(1,str.length());
			} 
			else if(base==4) {
				str="T"+str.substring(1,str.length());
			} 
		 	//we picked the base to mutate	 
	 }
	 
	 else if(numBase==2) {
			 if(base==1) {
					str=str.substring(0,1)+"A"+str.substring(2,str.length());
				} 
				else if(base==2) {
					str=str.substring(0,1)+"C"+str.substring(2,str.length());
				} 
				else if(base==3) {
					str=str.substring(0,1)+"G"+str.substring(2,str.length());
				} 
				else if(base==4) {
					str=str.substring(0,1)+"T"+str.substring(2,str.length());
				} 
	 }
	 else if(numBase==3) {
			 if(base==1) {
					str=str.substring(0,2)+"A";
				} 
				else if(base==2) {
					str=str.substring(0,2)+"C";
				} 
				else if(base==3) {
					str=str.substring(0,2)+"G";
				} 
				else if(base==4) {
					str=str.substring(0,2)+"T";
				} 
	 }

	 current.setData(str);
	}
	str1=d.printAll();
	String compStr = d.complementarySTR(str1);
	dll.addCompSequence(compStr);
	System.out.print("Mutated: ");
	d.print_All();
	System.out.print("Its Complimentary: ");
	dll.print_All();
	
	}
	else {
		System.out.println("No mutation occurred.");
	}
}

public boolean checkValidity() {//returns DNA validity
	return isValidated;
}

public String printAll() { //this method returns the sequence(as it is), as a string 
	String str="";
	if(header==null) {
		System.out.println("Sequence not found.");
		return str;
	}
	else {
		Node current=header;
		while(current.getNext()!=null) {
			str+=current.getData();
			current=current.getNext();
		}//used this dna strand for testing: TACCGATACGATAACATT
		str+=current.getData();
		return str;
}
}

public void print_All() {//method prints the DNA sequence, each codon separated with (-).
	
	if(header==null) {
		System.out.println("Sequence not found.");
	}
	else {
		Node current=header;
		while(current.getNext()!=null) {
			System.out.print(current.getData()+" - ");
			current=current.getNext();
		}
		System.out.println(current.getData());
}
}

public void addCompSequence(String str) {//method that adds the complementary sequence to the linkedlist

	Node current1;
	
	
	if(str.length()<18) {
		System.out.println("Invalid Sequence.(Does not Contain 18 Nucleotides)");
		count++;
		return;
	}
	else if(str.length()==18) {
	
		if(str.substring(0,3).equals("ATG")) {
	header = new Node(str.substring(0,3));
		}
		
		else {
		System.out.println("Invalid Sequence.");
		count++;
		return;
		}
		Node tail = header;
		Node current =header;
		
	
	while(str.length()>=3) {
		str=str.substring(3,str.length());
		if(str.length()>3) {
		current1 = new Node (str.substring(0,3));
		current.setNext(current1);
		current=current.getNext();
		}
		if(str.length()==3) {
			if(str.substring(0,3).equals("TAA")||str.substring(0,3).equals("TAG")||str.substring(0,3).equals("TGA")) {
			current1 = new Node (str.substring(0,3));
			current.setNext(current1);
			current=current.getNext();
			}
			else {
				System.out.println("Invalid Sequence. Sequence must terminate with a stop codon");
				count++;
				return;
			}
		}
		current=header;
		while(tail.getNext()!=null) {
			tail=tail.getNext();
		}

		while(current.getNext()!=null) {
			if(current.getData().equals("TAA")||current.getData().equals("TAG")||current.getData().equals("TGA")) {
				if(current!=tail) {
					System.out.println("Invalid Sequence.(Contains a stop codon in the middle of the sequence)");
					count++;
					return;
				}
			}
			current=current.getNext();
		}
	}
	isValidated=true;
	}
}

}
