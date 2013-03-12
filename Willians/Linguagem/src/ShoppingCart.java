
public class ShoppingCart {

	private String modelo;
	private boolean aceita;
	private boolean retira;
	private int qprodutos = 0;
	private String produtos[] = new String [15];
	
	public ShoppingCart() {
		
		}
	
	public void colocaNoCarrinho(boolean v){
			this.aceita = v;
			this.qprodutos +=1; 
		}
	
	public void retiraDoCarrinho(boolean f){
		this.retira = f;
		this.qprodutos+=-1;
	}
	
	public int quantidadeProdutos(){
		return this.qprodutos;
	}

	public void nomeProduto(String nome){
		for(int i=0; i<15 ;i++){
		this.produtos[i]+=nome;	
		
		}
	}
		
	public String Produto(){
		
		return this.Produto();
	
	
	}

		
	}
	
	
	

