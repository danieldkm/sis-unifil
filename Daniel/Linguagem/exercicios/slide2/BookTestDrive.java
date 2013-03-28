package slide2;


public class BookTestDrive {

	public static void main(String[] args) {
		Books[] myBooks = new Books[3];
		//erro 1 não estava instanciando o objeto do tipo vetor
		for (int i = 0; i < myBooks.length; i++) {
			myBooks[i] = new Books();
		}
				
		int x = 0; // erro 2 não tinha o nome do tipo int
		
		myBooks[0].setTitle("The Grapes of Java");
		myBooks[1].setTitle("The Java Gatsby");
		myBooks[2].setTitle("The java Cookbook");
		
		myBooks[0].setAuthor("bob");
		myBooks[1].setAuthor("sue");
		myBooks[2].setAuthor("ian");
		
		while(x < 3){
			System.out.print(myBooks[x].getTitle());
			System.out.print(" by ");
			System.out.println(myBooks[x].getAuthor());
			x = x + 1;
		}

	}

}
