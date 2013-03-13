import java.io.ObjectInputStream.GetField;

import javax.swing.JOptionPane;
public class UsaLiquidificador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		Liquidificador arno = new Liquidificador();
			int menu = 0;
			while(menu != 9){
			menu = Integer.parseInt(JOptionPane.showInputDialog("Digite uma das opções abaixo:" +'\n'+
					"1 – ligar"+'\n'+
					"2 – desligar"+'\n'+
					"3 – mostrar estado"+'\n'+
					"4 – trocar velocidade"+'\n'+
					"5 – atribuir velocidade máxima"+'\n'+
					"9 – fim "));
	
			if(menu==1){
			if(arno.getEstado("Desligado") == "Desligado"){
				
				arno.ligar();
				
				JOptionPane.showMessageDialog(null,"OK"+'\n'+"Ligado");
				
				
			}else{JOptionPane.showMessageDialog(null, "Ele já está ligado");
			}
				}
			
				if(menu==2){
				if(arno.getEstado("Ligado") == "Ligado"){
					arno.desligar();
					JOptionPane.showMessageDialog(null,"OK"+'\n'+"Desligado");
					
				}else
					{
						JOptionPane.showMessageDialog(null, "ERRO"+'\n'+"Ele Já está desligado");
					}
				}
			
				if(menu == 3 ){
				JOptionPane.showMessageDialog(null, "O Liquidificador está: " + arno.getEstado("Ligado") + '\n' + 
													"Velocidade atual é: " +  arno.getVelocidade() + '\n' + 
													"E sua velocidade maxima é de: "+ arno.getVelocidadeMaxima());
				}
	
				
				if(menu == 4){
					arno.setVelocidade(Integer.parseInt(JOptionPane.showInputDialog("Velocidade de 1 a 5")));
					 
					if(arno.getVelocidade() < 0 || arno.getVelocidade() > 5){
						if(arno.getEstado("Desligado") == "Desligado"){
							JOptionPane.showMessageDialog(null, "ERRO" + '\n'+ "Não é possivel trocar a velocidade");
						
							}
						}
					}
				
				if(menu == 5){
					arno.setVelocidadeMaxima(Integer.parseInt(JOptionPane.showInputDialog("Velocidade de 1 a 5")));
					if (arno.getVelocidadeMaxima() < 0 || arno.getVelocidadeMaxima() > 5){
					if(arno.getVelocidade() > arno.getVelocidadeMaxima()){
						JOptionPane.showMessageDialog(null, "ERRO" + '\n'+ "Não é possivel trocar a velocidade");
					}
				}
			}
		}
	}

}











