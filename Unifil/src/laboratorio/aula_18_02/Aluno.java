/*Crie a classe Aluno de acordo com as definições abaixo: 

1)	Atributos privados:
a)	nome – Nome do aluno
b)	nota[ ] – nota bimestral (média)
c)	exame – nota do exame

2)	Construtores:
a)	Sem parâmetro – inicializar atributos nota e exame.
b)	Com parâmetro nome – inicializar atributos nome, nota e exame.

3)	Métodos públicos para:
a)	Atualizar o atributo nome.
b)	Atribuir nota em cada bimestre. Nota de 0 a 100 são válidas e bimestre de 1 a 4 são válidos.
c)	Atribuir nota do exame. Nota de 0 a 100 são válidas. Permitir atribuir nota do exame somente se todas as notas bimestrais foram atribuídas.
d)	Obter o nome do aluno.
e)	Obter a media.
f)	Obter a situação do aluno.
g)	Obter média final
*/

package laboratorio.aula_18_02;

import javax.swing.JOptionPane;

public class Aluno {
	
	//definicao de atributos
	private String nome;
	private double nota[];// = new double[4];
	private double exame;
	private String cidade;

	//construtor
	public Aluno() {
		nota = new double[4];
		inicializarAtributos();
		
	}
	
	//construtor sobrecarga ---- com parametro
	public Aluno(String nome) {
		this.nome = nome;
		inicializarAtributos();
	}

	//metodos para inicializar o atributo
	private void inicializarAtributos(){
		for (int i = 0; i < nota.length; i++) {
			nota[i] =  -1;//- 1 indica a nota
		}					//nao definida
		exame = -1;
		cidade = "Londrina";
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNota(double novaNota, int bimestre) {
//		for (int i = 0; i < nota.length; i++) {
//			nota[i] = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota do " + (i + 1) + " Bimestre"));
//			verificaNota(nota[i]);
//		}
		this.nota[bimestre] = novaNota;
		if(bimestre >= 1 && bimestre <= 4 && novaNota >= 1 && novaNota <= 4){
			
		}
	}
	
	public void verificaNota(double valor){
		while (valor > 100 || valor < 0) {
			JOptionPane.showMessageDialog(null,"Erro, a nota deve estar de 0 a 100");
			valor = Double.parseDouble(JOptionPane.showInputDialog("Informa a nota"));
		}
	}

	public void setExame() {
		int n = 0;
		for (int i = 0; i < nota.length; i++) {
			if (nota[i] == 0) {
				n = n + 1;
			}
		}

		if (n != 4) {
			exame = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota do exame"));
			verificaNota(exame);
		} else {
			JOptionPane.showMessageDialog(null, "as notas ainda não foram informada");
		}
	}


	public double getMedia() {
		double total = 0;
		for (int i = 0; i < nota.length; i++) {
			total = total + nota[i];
		}
		total = total / 4;
		return total;
	}
	
	public String getSituacao() {
		double total;
		total = getMediaFinal();
		if(total < 70){
			return  "vc está de exame ou reprovado nota " + total;
		}else{
			return "aprovado nota " + total;
		}
	}
	
	public double getMediaFinal(){
		double mediaFinal = 0;
		mediaFinal = getMedia() + exame;
		return mediaFinal;
	}
}
