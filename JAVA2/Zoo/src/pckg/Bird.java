package pckg;

public class Bird extends Animal{

	public Bird(int age) {
		super(age);
	}

	public boolean canFly(){
		return true;
	}
	public String toString(){
		return "Bird"+", age: "+age+" can fly";
	}
	
}
