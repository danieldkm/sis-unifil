package ex_21_03;
/*Exercício:

Crie a classe Turma de acordo com as definições abaixo: 

1)	Atributos privados:
a.	turma – String - Nome da turma.
b.	turno – String - Nome do turno. 
c.	aluno – Vector - Aluno.

2)	Construtor sem parâmetro – instanciar o vector.

3)	Construtor com parâmetro nome da turma – inicializar atributo turma e instanciar o vector.

4)	Métodos públicos set e get nos atributos turma e turno.

5)	Método público para matricular aluno – adicionar aluno no vector

6)	Método público para cancelar matricula – excluir aluno do vector.

7)	Método público para obter a quantidade de alunos matriculados.

8)	Método público para listar alunos da turma. 
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
	private static int n = 0;
//	private Aluno nome = new Aluno();
	
	
	public Turma(){
		aluno = new Vector();
	}
	
	public static int getN() {
		return n;
	}

	public static void setN(int n) {
		Turma.n = n;
	}

	public Turma(String turma){
		this.nomeTurma = turma;
		aluno = new Vector();
	}
	
	public String getNomeTurma(){
		return this.nomeTurma;
	}
	
	public void setNomeTurma(String nomeTurma){
		this.nomeTurma = nomeTurma;
	}

	public String getNomeTurno() {
		return nomeTurno;
	}

	public void setNomeTurno(String nomeTurno) {
		this.nomeTurno = nomeTurno;
	}
	
	public void matricular(String nomeAluno){
		this.aluno.addElement(nomeAluno);
	}
	
	public void adicionar(Aluno nomeAluno){
		this.aluno.addElement(nomeAluno);
	}
	
	public void cancelarMatricula(String nomeAluno){
		if(aluno.indexOf(nomeAluno) < 0){
			JOptionPane.showMessageDialog(null, "Aluno não existe");
		}
		aluno.removeElement(nomeAluno);
	}
	
	public void quantidadeAlunos(){
		System.out.println(aluno.size() + " Alunos matriculados");
	}
	
	public void listarAlunos(){
//		System.out.println(aluno.get(0));
//		Enumeration<Aluno> enume = aluno.elements();
//		for (int i = 0; i < aluno.capacity(); i++) {
//			try {
//				System.out.println(enume.nextElement());
//			} catch (Exception e) {
//				aluno.trimToSize();
//				System.out.println(e);
//			}
//		}
		for (int i = 0; i < aluno.size(); i++) {
			Aluno aux = (Aluno)aluno.get(i);
			System.out.println(aux.getNome() /*+ " " + aux.getSituacao()*/);
		}
	}
	
	@Override
	public String toString(){
		return aluno.toString();
	}
	
}
