import javax.swing.JOptionPane;
public class testeRevisao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int confirmDialog = JOptionPane.YES_OPTION;
		while(confirmDialog == JOptionPane.YES_OPTION){
		Revisao a = new Revisao();
		
		a.atualizarNome(JOptionPane.showInputDialog("Informe o nome do aluno").toUpperCase());
		a.atribuirNota();
		JOptionPane.showConfirmDialog(null,"nome: "+ a.informaNome());
		a.Situacao();
			}
		}
	}



