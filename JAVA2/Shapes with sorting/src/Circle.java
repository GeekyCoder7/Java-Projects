
public class Circle extends Shape implements Sortable {


public Circle(String color, double x, double y) {
	super(color,x,y);
}

public double area() {
	return PI*Math.pow(radius, 2);
}

public double perimeter() {
	return 2*PI*radius;
}
public String toString() {
	return "Shape: "+shape  +", X Coordinate: "+x_coordinate+", Y Coordinate: "+y_coordinate+", Radius: "+radius+
			", Area: "+area()+", Perimeter: "+perimeter()+", Color: "+color;
}

public String getColor() {
	
	return "";
}

public int compareTo(Object o) {
if(x_coordinate==((Circle) o).x_coordinate) {
if(y_coordinate == ((Circle) o).y_coordinate)
return 0;
else
if(y_coordinate>((Circle) o).y_coordinate)
return 1;
else
return -1;
}
else
if(x_coordinate>((Circle) o).x_coordinate)
return 1;
else
return -1;


}
}
