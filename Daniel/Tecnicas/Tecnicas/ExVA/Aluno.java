package ExVA;


public class Aluno {

	private String nome;
	private int pontuacao;
	public Aluno proximo;

	public Aluno(String nome, int pontuacao) {
		this.nome = nome;
		this.pontuacao = pontuacao;
	}

	public Aluno(String nome) {
		this.nome = nome;
	}

	public Aluno() {
//		super();
	}

	public Aluno getProximo(){
		return proximo;
	}
	
	public void setProximo(Aluno proximo){
		this.proximo = proximo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public boolean equals(Object obj) {
		Aluno outroAluno = (Aluno) obj;
		Aluno outroAluno2 = (Aluno) obj;
		return this.nome.equals(outroAluno.nome) && this.pontuacao == outroAluno2.pontuacao;
	}

	public String toString() {
		return this.nome + " (" + this.pontuacao + ")";
	}

}
