package pckg;

public class Strawberry extends Fruits {
	
	public Strawberry(String supplier, String importDate, int Quantity) {
		// TODO Auto-generated constructor stub
		super(supplier,importDate,Quantity);
		Name="Strawberry";
	}
	
	public String toString(){
		return super.toString()+"STW";
	}
	
}
