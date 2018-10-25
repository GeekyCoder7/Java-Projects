



public class Triangle extends Shape{

	
	public Triangle(String color, double x, double y,double sideA,double sideB,double sideC) {
		//constructor of triangle (to be able to instantiate objects of type triangle) 
		super(color, x, y);
		this.sideA=sideA;
		this.sideB=sideB;
		this.sideC=sideC;
		
		
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
