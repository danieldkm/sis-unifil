import javax.swing.JOptionPane;


public class UsaAlarm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Alarm digital = new Alarm();
		
		int menu = 0;
		while(menu != 3){
			
			menu = Integer.parseInt(JOptionPane.showInputDialog("ALARME DIGITAL"+'\n'+'\n' + "Digite sua opção:" + 
																'\n'+'\n'+
															" 1 - Programar Despertador" + '\n'+
															" 2 - Ver a hora"+ '\n'+
															" 3 - Sair"));
			switch (menu){
			case 1 :
				digital.setProgramaHora(Integer.parseInt(JOptionPane.showInputDialog("Digite o horário a ser despertado")));
				break;
			case 2 :
				JOptionPane.showConfirmDialog(null, digital.getHoraAtual());
			}
		}
		
	}

}
