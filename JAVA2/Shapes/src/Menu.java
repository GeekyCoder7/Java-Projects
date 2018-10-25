/*Name: Nazareth H. Keshishian
  
 *Date Last Modified: 19/02/2018
 *Associated files: Circle.java, EquilateralTriangle.java, Shape.java, Square.java, Triangle.java. 
 * Program Description: A program that has an option to add shapes, a triangle,
 * or an equilateral triangle, a circle, or a square.
 */


import java.util.InputMismatchException;
import java.util.Scanner;



public class Menu {
	 private static  Scanner scan;
	 private Shape[] shapes; 
	 private int numShapes;
	 private static boolean isInt;
	 private boolean isEmpty,close,handle;
	
public Menu(){ //Constructor
		  scan = new Scanner(System.in);
		  shapes= new Shape[1];
		  numShapes=0;
		  isEmpty=true;
		  close=false;
		  handle=false;
	  }
public static void printMenu() {	//Prints the main menu every time called.
	
	System.out.println("1. Add a shape");
	System.out.println("2. Delete a shape");
	System.out.println("3. Compute Area and Perimeter");
	System.out.println("4. Display all");
	System.out.println("5. Move an object");
	System.out.println("6. Exit");
	System.out.println("--------");
	System.out.println("Enter your choice:");
} 
public  void printMenu1() {	//Prints the other menu every time called.
	String a="";
	double radius=0,x_coord = 0,y_coord=0,side_length=0,sideA=0,sideB=0,sideC=0;
	
	while(!close) {
		if(numShapes==shapes.length){
			 increaseSize();
		 }
	System.out.println("A. Add a Circle");
	System.out.println("B. Add a Square");
	System.out.println("C. Add a Triangle");
	System.out.println("D. Return to main menu");
	System.out.println("-----------------");
	System.out.println("Enter shape:");
	a=scan.next();
	
	switch(a) {
	case "A":
		
		while(!isInt){
			try {
			System.out.println("Enter the radius of the circle:");
			radius=scan.nextDouble();
			isInt = true;
		}
		catch(InputMismatchException e) {
			System.out.print("Error. ");
		}
			scan.nextLine();
			
		}
		isInt=false; 
		
		
		while(!isInt){
			try {
				System.out.println("Enter x coordinate");
				x_coord=scan.nextDouble();
			isInt = true;
		}
		catch(InputMismatchException e) {
			System.out.print("Error. ");
		}
			scan.nextLine();
			
		}
		isInt=false; 
		
		
		while(!isInt){
			try {
				System.out.println("Enter y coordinate");
				y_coord=scan.nextDouble();
			isInt = true;
		}
		catch(InputMismatchException e) {
			System.out.print("Error. ");
		}
			scan.nextLine();
			
		}
		isInt=false; 
		shapes[numShapes]=new Circle(radius,x_coord,y_coord);
		numShapes++;
		System.out.println("A Circle has been added successfully.");
		break;
	case "B":
		while(!isInt){
			try {
				System.out.println("Enter the side length of the square:");
				side_length=scan.nextDouble();
			isInt = true;
		}
		catch(InputMismatchException e) {
			System.out.print("Error. ");
		}
			scan.nextLine();
			
		}
		isInt=false; 
		
		
		while(!isInt){
			try {
				System.out.println("Enter x coordinate");
				x_coord=scan.nextDouble();
			isInt = true;
		}
		catch(InputMismatchException e) {
			System.out.print("Error. ");
		}
			scan.nextLine();
			
		}
		isInt=false; 
		
		
		while(!isInt){
			try {
				System.out.println("Enter y coordinate");
				y_coord=scan.nextDouble();
			isInt = true;
		}
		catch(InputMismatchException e) {
			System.out.print("Error. ");
		}
			scan.nextLine();
			
		}
		isInt=false; 

		shapes[numShapes]=new Square(side_length,x_coord,y_coord);
		numShapes++;
		System.out.println("A square has been added successfully.");
		break;
		
	case "C":
		
		while(!isInt){
			try {
				System.out.println("Enter the first side of the triangle:");
				sideA=scan.nextDouble();
			isInt = true;
		}
		catch(InputMismatchException e) {
			System.out.print("Error. ");
		}
			scan.nextLine();
			
		}
		isInt=false;
		

		while(!isInt){
			try {
				System.out.println("Enter the second side of the triangle:");
				sideB=scan.nextDouble();
			isInt = true;
		}
		catch(InputMismatchException e) {
			System.out.print("Error. ");
		}
			scan.nextLine();
			
		}
		isInt=false;
		
		while(!isInt){
			try {
				System.out.println("Enter the third side of the triangle:");
				sideC=scan.nextDouble();
			isInt = true;
		}
		catch(InputMismatchException e) {
			System.out.print("Error. ");
		}
			scan.nextLine();
			
		}
		isInt=false;
		
		while(!isInt){
			try {
				System.out.println("Enter x coordinate");
				x_coord=scan.nextDouble();
			isInt = true;
		}
		catch(InputMismatchException e) {
			System.out.print("Error. ");
		}
			scan.nextLine();
			
		}
		isInt=false;
		
		while(!isInt){
			try {
				System.out.println("Enter y coordinate");
				y_coord=scan.nextDouble();
			isInt = true;
		}
		catch(InputMismatchException e) {
			System.out.print("Error. ");
		}
			scan.nextLine();
			
		}
		isInt=false;
		
		if(sideA==sideB&&sideB==sideC) {
			shapes[numShapes]=new EquilateralTriangle(sideA,sideB,sideC,x_coord,y_coord);
			numShapes++;
			System.out.println("An equilateral triangle has been added successfully.");
		}
		else {
			shapes[numShapes]=new Triangle(sideA,sideB,sideC,x_coord,y_coord);
			numShapes++;
			System.out.println("A triangle has been added successfully.");
		}
		break;
	case "D":
		close=true;
		break;
		default:
			System.out.println("Invalid choice, please don't forget to enter in capital letters");
			break;
	}
	}
	
}
public Shape returnShape(String shapeName, double x,double y) {
	for(int i=0;i<numShapes;i++){
	if(shapes[i].shape.equalsIgnoreCase(shapeName)&&shapes[i].x_coordinate==x&&shapes[i].y_coordinate==y) {
		return shapes[i];
	}
	}
	return null;
}

public void printParimeterArea(double x,double y){			//This method prints the area and the perimeter of the shapes according to their coordinates.	
	 for(int i=0;i<numShapes;i++){
		 if(shapes[i].x_coordinate==x&&shapes[i].y_coordinate==y) {
			 if(shapes[i].shape.equals("Circle")) {
			 double area = ((Circle) shapes[i]).area();
			 double perimeter = ((Circle) shapes[i]).perimeter();
			 handle=true;
					System.out.println("Area of this Circle: "+area+", Perimeter: "+perimeter);					
			} 
			 
			 else if(shapes[i].shape.equals("Square")) {
				 double area = ((Square) shapes[i]).area();
				 double perimeter = ((Square) shapes[i]).perimeter();
				 handle=true;
						System.out.println("Area of this Square: "+area+", Perimeter: "+perimeter);					
				} 
			 else if(shapes[i].shape.equals("Triangle")) {
				 double area = ((Triangle) shapes[i]).area();
				 double perimeter = ((Triangle) shapes[i]).perimeter();
				 handle=true;
						System.out.println("Area of this Triangle: "+area+", Perimeter: "+perimeter);					
				} 
			 else if(shapes[i].shape.equals("Equilateral Triangle")) {
				 double area = ((EquilateralTriangle) shapes[i]).area();
				 double perimeter = ((EquilateralTriangle) shapes[i]).perimeter();
				 handle=true;
						System.out.println("Area of this Equilateral Triangle: "+area+", Perimeter: "+perimeter);					
				} 
		 }
		 else if(!handle) {
			 System.out.println("No object with those coordinates found.");
			 handle=true;
		 }
		 
	 }
											
	
	}

private void increaseSize() {							//This method increases the size of the array if it gets full.
	 Shape[] temp = new Shape[shapes.length*2+1];

	 for (int i=0;i<numShapes;i++){
		temp[i]=shapes[i];
	}
	shapes=temp;
}

public void delete(double x,double y){				//This method search the Shape by its name in the Array and Deletes if found.
	boolean found =false;
	
	 for(int i=0;i<numShapes&&!found;){
		 if(shapes[i].x_coordinate==x&&shapes[i].y_coordinate==y) {
				 numShapes--;								
				 shapes[i]=shapes[numShapes];
				 shapes[numShapes]=null;
			 System.out.println("Shape deleted.");
			 found=true;
			 
		 }
		 else if(!found) {
			 System.out.println("Object not found to delete");
			 found=true;
			// i=numShapes;
		 }			 //Return the index if the employees name is found			
	 }	
	//Else returns -1	
	}



public void listAll(){				//This method lists all elements in the shapes array.
	
	 for(int i=0;i<numShapes;i++){
		 System.out.println(shapes[i]);
	 	
	 }
}

	public static void main(String[] args) {	//Main method
		int num=0;
		double x_coord=0,y_coord=0,distance=0;
		Shape s1;
		String choice="",object="";
		Menu m1 = new Menu();
		
	while(true){
		if(m1.numShapes==0){				
			m1.isEmpty=true;					
		}
		else if (m1.numShapes>=1){
			m1.isEmpty=false;
		}
		 if(m1.numShapes==m1.shapes.length){
			 m1.increaseSize();
		 }
		printMenu();
		num=0;
			try {
				num=scan.nextInt();
			}
			catch(InputMismatchException e) {
			
			}
			scan.nextLine();
		
		switch(num){
		case 1:
			m1.close=false;
			m1.printMenu1();
			break;
		case 2:
			if(m1.isEmpty){
				System.out.println("No shapes to delete.");
			}
		else if(!m1.isEmpty){
			
			while(!isInt){
				try {
					System.out.println("Enter x coordinate:");
					 x_coord =scan.nextDouble();
				isInt = true;
			}
			catch(InputMismatchException e) {
				System.out.print("Error. ");
			}
				scan.nextLine();
				
			}
			isInt=false;
			
			
			while(!isInt){
				try {
					System.out.println("Enter y coordinate:");
					 y_coord = scan.nextDouble();
				isInt = true;
			}
			catch(InputMismatchException e) {
				System.out.print("Error. ");
			}
				scan.nextLine();
				
			}
			isInt=false;
			
			
			m1.delete(x_coord, y_coord); 
			
		}//Delete
			break;
		case 3:
			if(m1.isEmpty){
			System.out.println("No shapes in the list.");
			}
			else if(!m1.isEmpty){
				while(!isInt){
					try {
						
						System.out.println("Enter x coordinate:");
						 x_coord = scan.nextDouble();
					isInt = true;
				}
				catch(InputMismatchException e) {
					System.out.print("Error. ");
				}
					scan.nextLine();
					
				}
				isInt=false;
			
				while(!isInt){
					try {
						System.out.println("Enter y coordinate:");
						 y_coord = scan.nextDouble();
					isInt = true;
				}
				catch(InputMismatchException e) {
					System.out.print("Error. ");
				}
					scan.nextLine();
					
				}
				isInt=false;
				
				
				 m1.printParimeterArea(x_coord,y_coord);
				 //compute and display area and perimeter of the shapes
				}
			break;
		case 4: 
			if(m1.isEmpty){
			 System.out.println("No shapes to list.");
			}
			 else if(!m1.isEmpty){
		
			m1.listAll(); //List all
			 }
			break;
		case 5:
			System.out.println("Enter the shape of the object you want to move: ");
			object= scan.next();
			if(object.equalsIgnoreCase("Triangle")||object.equalsIgnoreCase("Equilateral Triangle")
					||object.equalsIgnoreCase("Square")) {
				
				while(!isInt){
					try {
						System.out.println("Enter the X coordinate, to identify the object you want to move: ");
						 x_coord = scan.nextDouble();
					isInt = true;
				}
				catch(InputMismatchException e) {
					System.out.print("Error. ");
				}
					scan.nextLine();
					
				}
				isInt=false;
				
				while(!isInt){
					try {
						System.out.println("Enter its y coordinate:");
						y_coord = scan.nextDouble();
					isInt = true;
				}
				catch(InputMismatchException e) {
					System.out.print("Error. ");
				}
					scan.nextLine();
					
				}
				isInt=false;
				
				
				s1=m1.returnShape(object,x_coord,y_coord);
				if(s1!=null) {
					
				
					while(!isInt){
						try {
							System.out.println("Enter the distance by which you want to move the object: ");
							distance=scan.nextDouble();
						isInt = true;
					}
					catch(InputMismatchException e) {
						System.out.print("Error. ");
					}
						scan.nextLine();
						
					}
					isInt=false;
					
				
				System.out.println("Do you want to move the object horizontally or vertically? ");
				choice = scan.next();
				if(choice.equalsIgnoreCase("horizontally")) {
					
					System.out.println("Left or right?");
					choice=scan.next();
					if(choice.equalsIgnoreCase("left")) {
						if(s1.x_coordinate-distance>=-100) {
						s1.x_coordinate-=distance;
						System.out.println("Object moved.");
					}
						else {
							System.out.println("We cannot move left this object");
						}
					}
					
					else if(choice.equalsIgnoreCase("right")) {
						if(s1.x_coordinate+distance<=100) {
							s1.x_coordinate+=distance;
							System.out.println("Object moved.");
						}
						else {
							System.out.println("We cannot move right this object");
						}
					}
				}
				
				else if (choice.equalsIgnoreCase("vertically")) {
					System.out.println("Up or down?");
					choice=scan.next();
					if(choice.equalsIgnoreCase("up")) {
						if(s1.y_coordinate+distance<=100) {
							s1.y_coordinate+=distance;
							System.out.println("Object moved.");
						}
						else {
							System.out.println("We cannot move up this object");
						}
					}
					
					else if(choice.equalsIgnoreCase("down")) {
						if(s1.y_coordinate-distance>=-100) {
							s1.y_coordinate-=distance;
							System.out.println("Object moved.");
						}
						else {
							System.out.println("We cannot move down this object");
						}
					}
					
				}
			}
				else {
					System.out.println("Object not found.");
				}
			}
			
			else if(object.equalsIgnoreCase("Circle")) {
				System.out.println("You cannot move a circle.");
			}
			else {
				System.out.println("Object not found.");
			}
			
			break;
		case 6:
			System.out.println("Application closed.");
			System.exit(0);
			break;
		default:										//Invalid number if different from 1,2,3,4,5,6.
			System.out.println("Invalid Number, please enter a valid one.");
			break;
		}
	}
	}

}
