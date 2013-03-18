import java.util.Vector;


public class TesteVetor {

	
	public static void main(String[] args) {
	
		Vector vector1 = new Vector(5);
		vector1.addElement("Willians");
		vector1.addElement("Camila");
		
		System.out.println("Numero de componetes do vetor (Size): " + vector1.size());
		System.out.println("capacity: "+ vector1.capacity());
		
		if(vector1.removeElement("Willians")){
			System.out.println("Removido 1");
			
		}else{
			System.out.println("Não removido");
		}
		System.out.println();
		System.out.println("Numero de componetes do vetor (Size): " + vector1.size());
		System.out.println("capacity: "+ vector1.capacity());
		
	}

}
