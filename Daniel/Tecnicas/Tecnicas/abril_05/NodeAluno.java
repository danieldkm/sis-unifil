package abril_05;


public class NodeAluno {
	String nome;
	int pontuacao;

	NodeAluno proximo;

	public NodeAluno(String nome, int pontuacao) {
		this.nome = nome;
		this.pontuacao = pontuacao;
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

	public String toString() {
		return nome + "(" + pontuacao + ")";
	}
}
