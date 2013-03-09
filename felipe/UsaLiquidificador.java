import java.io.ObjectInputStream.GetField;

import javax.swing.JOptionPane;
public class UsaLiquidificador {
	public static void main(String[]args){
		Liquidificador comeco = new Liquidificador();

		int menu = 0;
		while(menu != 9){
			menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Opção (1) Ligar." 
		+ "\nOpção (2) Desligar." 
		+ "\nOpção (3) Saber: velocidade atual, velocidade máxima e estado: Ligado ou Desligado."
		+ "\nOpção (4) Mudar velocidade."
		+ "\nOpção (5) Mudar velocidade maxima."
		+ "\nOpção (9) Sair"));
			
			switch (menu){			
			case 1:{
				if(comeco.getEstado() == 'L'){
					JOptionPane.showMessageDialog(null,"Ja esta ligado".toUpperCase());					
				}else{
					comeco.setEstado('L');
					JOptionPane.showMessageDialog(null, "Liquidificador ligado!");
					}
				}break;
			case 2:{
				if(comeco.getEstado() == 'D'){
					JOptionPane.showMessageDialog(null, "Ja esta desligado".toUpperCase());
				}else{
					comeco.setEstado('D');
					JOptionPane.showMessageDialog(null, "Liquidificador deslidado!");
					}
				}break;
			case 3:{
				JOptionPane.showMessageDialog(null, "Velocidade atual: " + comeco.getVelocidade()
						+"\nVelocidade maxima: " + comeco.getVelocidadeMaxima()
						+"\nEstado: " + comeco.getEstado());
				}break;
			case 4:{		
				int x;
				x = comeco.getVelocidade();
					comeco.setVelocidade(Integer.parseInt(JOptionPane.showInputDialog("Informe a velocidade")));
				if( comeco.getEstado() == 'D'){
					JOptionPane.showMessageDialog(null,"Liquidificador esta desligado!");
					comeco.setVelocidade(x);
				}else if(comeco.getVelocidade() <=0 || comeco.getVelocidade() > comeco.getVelocidadeMaxima()){
				JOptionPane.showMessageDialog(null, "A velocidade é invalida!");
				comeco.setVelocidade(x);
				}else{
					JOptionPane.showMessageDialog(null, "Velocidade alterada!");
					}
				}break;
			case 5:{
				int y;
				int x;
				y = comeco.getVelocidade();
				comeco.setVelocidadeMaxima(Integer.parseInt(JOptionPane.showInputDialog("Informe a velocidade")));
				if( comeco.getEstado() == 'D'){
					JOptionPane.showMessageDialog(null, "Liquidificador esta desligado!");
					comeco.setVelocidadeMaxima(y);
				}else if(comeco.getVelocidadeMaxima() <=0 || comeco.getVelocidadeMaxima() < y){
				JOptionPane.showMessageDialog(null, "A velocidade é invalida!");
				comeco.setVelocidadeMaxima(y);
				}else{
					JOptionPane.showMessageDialog(null, "Velocidade maxima alterada!");
					
						}
				}break;
			
			}
		}		
	}
}
