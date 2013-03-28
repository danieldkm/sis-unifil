package slide1;

public class ex02 {
	public class televisao{
		private int polegas;
		private String cor;
		private String marca;
		
		public int getPolegas() {
			return polegas;
		}
		public void setPolegas(int polegas) {
			this.polegas = polegas;
		}
		public String getCor() {
			return cor;
		}
		public void setCor(String cor) {
			this.cor = cor;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String ligar(){
			return "Ligado";
		}
		public String desligar(){
			return "Desligado";
		}
	}
}
