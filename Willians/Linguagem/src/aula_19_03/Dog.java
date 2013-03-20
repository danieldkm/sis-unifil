package aula_19_03;

public class Dog {

	private int size;
	private String name;
	public Dog(String nome, int peso){
		this.name = nome;
		this.size= peso;
	}
	
	void bark(){

	if(size > 60){
	
		System.out.println(name + "Woof! Woof!");
		
	}else if(size > 14){
		System.out.println("Ruf! Ruf!");
		
	}else {System.out.println("Yip Yip");
	}
	
}
}
