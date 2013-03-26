package marco_12_part2;

public class testeEx03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ex03[] myBooks = new ex03[3];
		for (int i = 0; i < myBooks.length; i++) {
			myBooks[i] = new ex03();
		}
				
		int x = 0;
		
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
