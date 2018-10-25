package pckg;

public class Goods {
protected String supplier,importDate, Name;
protected int Quantity;

	public Goods(String supplier, String importDate, int Quantity) {
		this.supplier=supplier;
		this.importDate=importDate;
		this.Quantity=Quantity;
	}
	public String toString(){
		return importDate;
	}
	protected String getName() {	
		return Name;
	}

}
