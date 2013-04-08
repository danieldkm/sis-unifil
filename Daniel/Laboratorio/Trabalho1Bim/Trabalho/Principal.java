package Trabalho;
/*
Classe Principal
Crie um menu para realizar as operações da classe Controle.*/
public class Principal {
	public static void main(String[] args) {
		Controle controle = new Controle();
		System.out.println("cadastra Equipe");
		controle.cadastrarEquipe("Equipe1");
		controle.cadastrarEquipe("Equipe2");
		
		System.out.println("\n\n\n\n");
		System.out.println("cadastrar jogador");
		controle.cadastrarJogador("Jogador1", 1);
		controle.cadastrarJogador("Jogador2", 2);
		controle.cadastrarJogador("Jogador3", 4);
		controle.cadastrarJogador("Jogador4", 2);
		controle.cadastrarJogador("Jogador5", 5);
		controle.cadastrarJogador("Jogador6", 5);
		
		System.out.println("\n\n\n\n");
		System.out.println("Contratar");
		controle.contratarJogador("Equipe1", "Jogador1");
		controle.contratarJogador("Equipe1", "Jogador2");
		controle.contratarJogador("Equipe1", "Jogador3");
		controle.contratarJogador("Equipe1", "Jogador4");
		controle.contratarJogador("Equipe1", "Jogador5");
		controle.contratarJogador("Equipe1", "Jogador6");
		controle.contratarJogador("Equipe2", "Jogador3");
		controle.contratarJogador("Equipe2", "Jogador4");
		controle.contratarJogador("Equipe2", "Jogador5");
		controle.contratarJogador("Equipe2", "Jogador6");
		controle.contratarJogador("Equipe2", "Jogador1");
		controle.contratarJogador("Equipe2", "Jogador2");
		
		System.out.println("\n\n\n\n");
		System.out.println("Demitir");
		controle.demitirJogador("Equipe2", "Jogador5");
		
		System.out.println("\n\n\n\n");
		System.out.println("mostar");
		controle.mostrarJogadoresEquipe("Equipe1");
		controle.mostrarJogadoresEquipe("Equipe2");
		
		System.out.println("\n\n\n\n");
		System.out.println("posicao");
		controle.mostrarPosicaoJogador(2);
	}
}
