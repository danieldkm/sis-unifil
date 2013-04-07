package Trabalho;
/*Crie as classes descritas abaixo para controle de jogadores de uma equipe.

Classe Jogador

*/
public class Jogador {
	//Atributos privados para nome do jogador e posição de jogo.
	private String nome;
	private int posicao;
	
	//Construtor com parâmetros para inicializar nome e posição.
	public Jogador(String nome, int posicao){
		this.nome = nome;
		this.posicao = posicao;
	}
	
	//Métodos get / set para nome e posição.
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setPosicao(int posicao){
		this.posicao = posicao;
	}
	
	public int getPocisao(){
		return posicao;
	}
	
	@Override
	public String toString(){
		return "nome " + this.nome + " posicao " + this.posicao;
	}
}
