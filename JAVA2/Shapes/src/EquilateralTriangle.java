
public class EquilateralTriangle extends Triangle{
	
	public EquilateralTriangle(double sideA, double sideB, double sideC, double x_coordinate, double y_coordinate) {
		
	super(sideA,sideB,sideC,x_coordinate,y_coordinate);
	shape="Equilateral Triangle";
	}

	public double area() {	//This method calculates the area of the triangle
		double s = 0.5 * (sideA + sideB + sideC);
		return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
	}
	
	public double perimeter() {//This method calculates the perimeter of the triangle
		return sideA+sideB+sideC;
	}
	public String toString() {	//toString method which returns all the information about the shape(Equi triangle).
		return "Shape: "+shape  +", X Coordinate: "+x_coordinate+", Y Coordinate: "+y_coordinate+", Side A: "+sideA+
				", Side B: "+sideB+", Side C: "+sideC+", Area: "+area()+", Perimeter: "+perimeter()+", Color: "+color;
	}
}
