package pckg;

public class Vegetables extends Goods {

	public Vegetables(String supplier, String importDate, int Quantity) {
		// TODO Auto-generated constructor stub
		super(supplier,importDate,Quantity);
	}

	public void makeSalad(Vegetables v){
		System.out.println("Vegetable"+Name+" and "+v.getName() +" are now Salad");//for now
	}
	public String toString(){
		return importDate;
	}
	
}
