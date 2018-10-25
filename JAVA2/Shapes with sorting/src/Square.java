



public class Square extends Shape{
	
	public Square(String color, double x, double y,double side_length) {
		//constructor of square (to be able to instantiate objects of type square) 
		super(color, x, y);
		this.side_length=side_length;
		
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
