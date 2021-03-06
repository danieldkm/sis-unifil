package ex_21_03;

/*Exerc�cio:

 Crie a classe Turma de acordo com as defini��es abaixo: 

 1)	Atributos privados:
 a.	turma � String - Nome da turma.
 b.	turno � String - Nome do turno. 
 c.	aluno � Vector - Aluno.

 2)	Construtor sem par�metro � instanciar o vector.

 3)	Construtor com par�metro nome da turma � inicializar atributo turma e instanciar o vector.

 4)	M�todos p�blicos set e get nos atributos turma e turno.

 5)	M�todo p�blico para matricular aluno � adicionar aluno no vector

 6)	M�todo p�blico para cancelar matricula � excluir aluno do vector.

 7)	M�todo p�blico para obter a quantidade de alunos matriculados.

 8)	M�todo p�blico para listar alunos da turma. 
 */
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JOptionPane;

import aula_01.Aluno;

public class Turma {
	private String nomeTurma;
	private String nomeTurno;
	private Vector aluno;
	private static final int n = 0;

	public Turma() {
		aluno = new Vector();
	}

	// Testando o atributo do tipo final ou static
	// final n�o deixa fazer a altera��o no atributo
	// static ainda deixa fazer a altera��o no atributo mas n�o deixa de ser
	// constante
	public static int getN() {
		return n;
	}

	public Turma(String turma) {
		this.nomeTurma = turma;
		aluno = new Vector();
	}

	public String getNomeTurma() {
		return this.nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public String getNomeTurno() {
		return nomeTurno;
	}

	public void setNomeTurno(String nomeTurno) {
		this.nomeTurno = nomeTurno;
	}

	public void adicionar(String nomeAluno) {
		this.aluno.addElement(nomeAluno);
		System.out.println("adicionado " + aluno);
	}

	public void adicionar(Aluno nomeAluno) {
		this.aluno.addElement(nomeAluno);
	}

	public void cancelarMatricula(String nomeAluno) {
		if (aluno.indexOf(nomeAluno) < 0) {
			JOptionPane.showMessageDialog(null, "Aluno n�o existe");
		}
		aluno.removeElement(nomeAluno);
	}

	public void quantidadeAlunos() {
		System.out.println(aluno.size() + " Alunos matriculados");
	}

	// lista todos os alunos, pulando sempre um elemento, pois estou gravando
	// duas vezes, um como Objeto e outro como String
	public void listarAlunos() {
		// System.out.println(aluno.get(0));
		// Enumeration<Aluno> enume = aluno.elements();
		for (int i = 0; i < aluno.capacity(); i += 2) {
			try {
				System.out.println(aluno.get(i) + " " + i);
				// System.out.println(enume.nextElement());
			} catch (Exception e) {
				aluno.trimToSize();
				System.out.println(e);
			}
		}
		// corre��o do professor!!!
		// for (int i = 0; i < aluno.size(); i++) {
		// Aluno aux = (Aluno) aluno.get(i);
		// System.out.println(aux.getNome() + " " + aux.getSituacao());
		// }
	}

	//correcao do prof.
	public void listar() {
		for (int i = 0; i < aluno.size(); i++) {
			Aluno aux = (Aluno) aluno.get(i);
			System.out.println(aux.getNome() + " " + aux.getSituacao());
		}
	}
	
	public void listar2() {
		for (int i = 0; i < aluno.size(); i++) {
			System.out.println(aluno.get(i));
		}
	}

	// procurar o aluno por vector String e chama os metodos para adicionar as
	// notas
	public void procurarAluno() {
		String nome = JOptionPane.showInputDialog("Informe o nome do aluno");
		System.out.println(aluno.contains(nome));
		if (aluno.contains(nome)) {
			Aluno a = new Aluno(nome);
			a.setNota();
			JOptionPane.showMessageDialog(null, "Aluno: " + a.getNome());
			JOptionPane.showMessageDialog(null, "M�dia: " + a.getMedia());
			if (a.getMedia() > 70) {
				JOptionPane.showMessageDialog(null,
						"Situa��o: " + a.getSituacao());
			} else {
				JOptionPane.showMessageDialog(null,
						"Situa��o: " + a.getSituacao());
				a.setExame();
			}
			JOptionPane.showMessageDialog(null,
					"M�dia final: " + a.getMediaFinal());
			JOptionPane.showMessageDialog(null, "Situa��o: " + a.getSituacao());
		} else {
			JOptionPane.showMessageDialog(null, "Esse aluno n�o existe");
		}
	}
	
	public int getAlunosMatriculados(){
		return aluno.size();
	}
	
	public boolean cancelar(Aluno alu){
		return aluno.removeElement(alu);
	}
	
	public boolean cancelar(String alu){
		return aluno.removeElement(alu);
	}
	
	public Aluno getAluno(String nome){
		Aluno aux = null;
		for (int i = 0; i < aluno.size(); i++) {
//			System.out.println("aux " + aux + " get " + aluno.get(i));
//			String s = (String) aluno.get(i);//forma 1
			aux =/*forma1 new Aluno(s);*//*forma2*/(Aluno) aluno.get(i);
//			System.out.println("aux " + aux);
			if(aux.getNome().equals(nome)){
				return aux;
			}
		}
		return aux;
	}

	@Override
	public String toString() {
		return aluno.toString();
	}

}
