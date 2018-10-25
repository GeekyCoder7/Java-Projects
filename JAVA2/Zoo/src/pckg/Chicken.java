package pckg;

public class Chicken extends Bird{

	public Chicken(int age) {
		super(age);
	}
	
	public boolean canFly(){
		return false;
	}
	
	public boolean isDangerous(){
		return false;
	}
	
	public void makeSound(){
		System.out.println("puck");
	}
	public String toString(){
		return "Chicken"+", age: "+age+" can fly";
	}

}
