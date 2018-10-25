



public class Square extends Shape{
	
	public Square(double side_length, double x_coordinate, double y_coordinate) {
		this.side_length=side_length;
		this.x_coordinate=x_coordinate;
		this.y_coordinate=y_coordinate;
		shape="Square";		
	}

	public double area() {//This method calculates the area of the Square
		return Math.pow(side_length, 2);
	}

	public double perimeter() {//This method calculates the perimeter of the Square
		return 4*side_length;
	}
	public String toString() {//toString method which returns all the information about the shape(Square).
		return "Shape: "+shape  +", X Coordinate: "+x_coordinate+", Y Coordinate: "+y_coordinate+", Side Lenght: "+side_length+
				", Area: "+area()+", Perimeter: "+perimeter()+", Color: "+color;
	}
}
