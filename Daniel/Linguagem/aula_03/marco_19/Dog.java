package marco_19;

public class Dog {
	private int size;
	private String name;
	
	public Dog(String name, int size){
		this.name = name;
		this.size = size;
	}
	
	void bark(){
		if(size > 60){
			System.out.println("Nome; " + name + " Woof! Woof!");
		}else if (size > 14){
			System.out.println("Nome; " + name + " Ruff! Ruff!");
		}else{
			System.out.println("Nome; " + name + " Yip! Yip!");
		}
			
	}

	void bark(int numOfBarks){
		while (numOfBarks > 0) {
			System.out.println("Ruff! Ruff!");
			numOfBarks--;
		}
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
