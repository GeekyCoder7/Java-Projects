package pckg;

public class Mamal extends Animal {
	private String name;

	public Mamal(int age, String name){
		super(age);
		this.name=name;
	}
	public boolean isDangerous(){
		if(getName().equalsIgnoreCase("dog")||getName().equalsIgnoreCase("cat")){
		return false;
		}
		else if(getName().equalsIgnoreCase("tiger")||getName().equalsIgnoreCase("lion")){
			return true;
		}
		else 
		return false;
		
	}
	public String getName() {
		return name;
	}
	
	public void makeSound(){
		if(getName().equalsIgnoreCase("dog")){
			System.out.println("wof");
			}
			else if(getName().equalsIgnoreCase("cat")){
				System.out.println("miaou");
			}
			else if(getName().equalsIgnoreCase("tiger")){
				System.out.println("row");
			}
		
	}
	public String toString(){
		return name+", age: "+age;
	}
}
