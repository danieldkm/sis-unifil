import java.util.Vector;


public class TesteVetor {

	
	public static void main(String[] args) {
	
		Vector vector1 = new Vector();
		vector1.addElement("Willians".toUpperCase());
		vector1.addElement("Camila");
		
		System.out.println("Numero de componetes do vetor (Size): " + vector1.size());
		System.out.println("capacity: "+ vector1.capacity());
		
		if(vector1.removeElement("WiLlians".toUpperCase())){
			System.out.println("Removido 1");
			
		}else{
			System.out.println("N�o removido");
		}
		System.out.println();
		System.out.println("Numero de componetes do vetor (Size): " + vector1.size());
		System.out.println("capacity: "+ vector1.capacity());
		
	}

}
