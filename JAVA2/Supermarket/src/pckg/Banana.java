package pckg;

public class Banana extends Fruits {

	public Banana(String supplier, String importDate, int Quantity) {
		// TODO Auto-generated constructor stub
		super(supplier,importDate,Quantity);
		Name="Banana";
	}
	public String toString(){
		return super.toString()+"BAN";
	}
}
