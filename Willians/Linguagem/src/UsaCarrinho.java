import javax.swing.JOptionPane;


public class UsaCarrinho {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ShoppingCart uol = new ShoppingCart();
		
		int aux = 0;
		int menu=0;
		String p;
		
		
		while(aux==0){
		menu = Integer.parseInt(JOptionPane.showInputDialog("Carrinho de compras UOL"+'\n'+'\n' + "Digite sua opção:" + 
				'\n'+'\n'+
			" 1 - Inserir no carrinho" + '\n'+
			" 2 - Retirar do carrinho"+ '\n'+
			" 3 - Ver produtos e quantidade"+'\n'+
			" 4 - Sair"));
		
		if(menu == 1){
			uol.nomeProduto(JOptionPane.showInputDialog("Digite o nome do produto"));
			uol.colocaNoCarrinho(true);
			}
		if(menu == 2){
			uol.retiraDoCarrinho(true);
		}
		
		if(menu==3){
			JOptionPane.showConfirmDialog(null, "Quantidade de produtos= "+ uol.quantidadeProdutos());
		
		}
		
		if(menu == 4){
			aux= aux+1;
		}
		
		}
	}

}
