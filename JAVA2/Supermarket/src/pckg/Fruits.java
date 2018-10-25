package pckg;

public class Fruits extends Goods {

	public Fruits(String supplier, String importDate, int Quantity) {
		// TODO Auto-generated constructor stub
		super(supplier,importDate,Quantity);
	}
	public void juiceIt(Fruits f){
		System.out.println("Fruit"+Name+"has been juiced with"+f.getName());//for now
		
	}

	public String toString(){
		return importDate;
	}
	
	 
}
