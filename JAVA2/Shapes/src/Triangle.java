



public class Triangle extends Shape{

	
	public Triangle(double sideA, double sideB, double sideC, double x_coordinate, double y_coordinate) {
		this.sideA=sideA;
		this.sideB=sideB;
		this.sideC=sideC;
		this.x_coordinate=x_coordinate;
		this.y_coordinate=y_coordinate;
		shape="Triangle";
	}

	public double area() {//This method calculates the area of the triangle
		double s = 0.5 * (sideA + sideB + sideC);
		return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
	}
	
	public double perimeter() {//This method perimeter the area of the triangle
		return sideA+sideB+sideC;
	}
	public String toString() {//toString method which returns all the information about the shape(Triangle).
		return "Shape: "+shape  +", X Coordinate: "+x_coordinate+", Y Coordinate: "+y_coordinate+", Side A: "+sideA+
				", Side B: "+sideB+", Side C: "+sideC+", Area: "+area()+", Perimeter: "+perimeter()+", Color: "+color;
	}
}
