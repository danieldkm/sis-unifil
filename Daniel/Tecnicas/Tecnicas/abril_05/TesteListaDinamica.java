package abril_05;


public class TesteListaDinamica {

	public static void main(String[] args) {
		ListaDinamica lista = new ListaDinamica();
//		NodeAluno aluno = new NodeAluno("a", 2);
		lista.inicio = new NodeAluno("a", 1);//exemplo1
//		lista.inicio = aluno;//exemplo2
		
		
		
		lista.inicio.proximo = new NodeAluno("B",2);//exemplo1
//		lista.inicio.proximo = aluno;//exemplo2
		lista.inicio.proximo.proximo = new NodeAluno("C",3);//exemplo1
		lista.inicio.proximo.proximo.proximo = new NodeAluno("D",4);//exemplo1
		lista.inicio.proximo.proximo.proximo.proximo = new NodeAluno("E",5);//exemplo1
		
		
		NodeAluno auxiliar = lista.inicio;
		
		while (/*auxiliar.proximo != null ||*/ auxiliar != null) {
			System.out.println(auxiliar);
			auxiliar = auxiliar.proximo;
		}
//		System.out.println(auxiliar.proximo);
		
	}

}
