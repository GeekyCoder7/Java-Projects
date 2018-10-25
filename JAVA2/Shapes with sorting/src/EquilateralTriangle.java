
public class EquilateralTriangle extends Triangle{
	
	public EquilateralTriangle(String color, double x, double y, double s1, double s2, double s3) {
		//constructor of Equilateral triangle (to be able to instantiate objects of type Equilateral triangle) 
		super(color, x, y, s1, s2, s3);
		
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
