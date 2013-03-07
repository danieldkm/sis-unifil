import javax.swing.JOptionPane;
public class Revisao {
  
	
	private String nome;
	private int nota[] = new int [4];
	private double exame;
	
	
	
	public Revisao(){
		
	}
	
	public Revisao( String nome){
		this.nome = nome;
	}
	
	void atualizarNome(String nome){
		this.nome = nome;
	}
	
	public String informaNome(){
		
		return nome;
		
	}
	
	public void atribuirNota(){
		for(int i = 0; i<4; i++){
			this.nota[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe a "+ (i+1)+"º " +" nota de 0 a 100"));
			
		}
	}
	
	void ExibeNota(){
		for(int i = 0; i<4; i++){
			JOptionPane.showConfirmDialog(null, (i+1)+"º "+" Bimestre: "+nota[i]);
		}
	}
	void Situacao(){
		int soma= 0;
		for(int i= 0; i<4;i++){
			soma=soma+nota[i];
		}
		this.exame = soma/4;
		if(this.exame >=70){
			JOptionPane.showConfirmDialog(null, "Sua media é de: " + this.exame + '\n'
					+ "Aprovado sem exame");
		}else{
			JOptionPane.showConfirmDialog(null, "Sua media é de: " + this.exame+'\n'+
					"Voce está de Exame");
		}
		
	}
	
	
}
	

