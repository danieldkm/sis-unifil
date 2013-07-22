package dia2207;

public class Teste {

	public static void main(String[] args) {
		
		Funcionario fu[] = new Funcionario[5];
		Comissionado f1 = new Comissionado(10.0,10,"Willians", 1000.00);
		fu[0] = f1;
		Horista f2 = new Horista(40, "Felipe", 22);
		fu[1] = f2;
		Producao f3 = new Producao(100,"Daniel", 1000.00);
		fu[2] = f3;
		Mensalista f4 = new Mensalista("Guiuiuia", 10000.00);
		fu[3] = f4;

		for (int i = 0; i < fu.length; i++) {
			if(fu[i] != null){
//				System.out.println(fu[i]);
				System.out.println(
				fu[i].getClass().toString().substring(14) +
				": " + fu[i].getNome() +
				" ganha por mes: " + fu[i].getGanhoMensal());
			}
			
		}
		
		Funcionario t = new Comissionado(10,12,"A", 16584);
		System.out.println(t.getGanhoMensal());
		
		
	}

}
