package pckg;

public class Carrot extends Vegetables {
	
	public Carrot(String supplier, String importDate, int Quantity) {
		// TODO Auto-generated constructor stub
		super(supplier,importDate,Quantity);
		Name="Carrot";
	}
	public String toString(){
		return super.toString()+"CAR";
	}
}
