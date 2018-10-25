
public abstract class Shape implements Sortable {
	protected double x_coordinate,y_coordinate,radius,side_length,sideA,sideB,sideC;
	protected String color,shape;
	protected final double PI=3.14;
	
	
	public Shape(String color, double x, double y) {
		// TODO Auto-generated constructor stub
		this.color=color;
		this.x_coordinate=x;
		this.y_coordinate=y;
	}

	
	
}
