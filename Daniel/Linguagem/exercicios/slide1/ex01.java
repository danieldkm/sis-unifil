package slide1;

public class ex01 {
	public class veiculo {
		private String cor;
		private String marca;
		private String modelo;

		void setCor(String cor) {
			this.cor = cor;
		}

		public String getCor() {
			return cor;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		
		public String velocidadeAtual(){
			return "100Km";
		}
	}
}
