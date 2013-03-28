package slide3;

public class Dog {
	private int size;
	private String name;
	
	Dog(int size){
		this.size = size;
	}
	int getSize(){
		return size;
	}
	
	void setSize(int size){
		this.size = size;
	}
	
	String getName(){
		return name;
	}
	
	void setName(String name){
		this.name = name;
	}
	
	void bark(){
		if(size > 60){
			System.out.println("Woof! Woof!");
		}
		else if (size > 14){
			System.out.println("Ruff! Ruff!");
		}
		else{
			System.out.println("Yip! Yip!");
		}
	}
	
	public static void main(String[] args) {
		Dog d = new Dog(70);
		d.bark();
	}
}
