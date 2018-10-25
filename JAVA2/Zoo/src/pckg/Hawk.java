package pckg;

public class Hawk extends Bird {

	public Hawk(int age) {
		super(age);
	}
	
	public void makeSound(){
		System.out.println("qwiiiii");
	}
	public String toString(){
		return "Hawk"+", age: "+age+" can fly";
	}
}
