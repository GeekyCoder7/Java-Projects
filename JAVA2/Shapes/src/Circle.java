


public class Circle extends Shape {



public Circle(double radius, double x_coordinate, double y_coordinate) {//Constructor
	this.radius=radius;
	this.x_coordinate=x_coordinate;
	this.y_coordinate=y_coordinate;
	shape="Circle";
}

public double area() {			//This method calculates the area of the circle
	return PI*Math.pow(radius, 2);
}

public double perimeter() {	//This method calculates the perimeter of the circle
	return 2*PI*radius;
}
public String toString() {	//toString method which returns all the information about the shape(Circle).
	return "Shape: "+shape  +", X Coordinate: "+x_coordinate+", Y Coordinate: "+y_coordinate+", Radius: "+radius+
			", Area: "+area()+", Perimeter: "+perimeter()+", Color: "+color;
}
}
