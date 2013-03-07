import javax.swing.JOptionPane;

		public class Aluno {
		
			// 1- Defini��o dos atributos
		private String nome;
		private float nota[] = new float[4];
		private float exame;
		
		
		// 2-A)Construtor sem par�metro
		public Aluno(){
		
			// chamada do m�todo
		inicializaAtributos();
		}
		
		// 2-B)Construtor com par�metro
		public   Aluno(String nome) {
		this.nome = nome;
		
		// chamada do m�todo
		inicializaAtributos();
		}
		
		// M�todo para inicializar atributos
		private void inicializaAtributos() {
		nota = new float[4];
		for (int i = 0; i < nota.length; i++) {
		nota[i] = -1; // -1 indica nota n�o definida
		}
		exame = -1;
		}
		
		// 3-A)M�todo para atualizar atributo nome
		public void setNome(String nome) {
		this.nome = nome;
		}
		
		// 3-B)M�todo para atribuir notas nos bimestres
		public void setNota(float novaNota, int bimestre) {
		if (bimestre >= 1 && bimestre <= 4 && novaNota >= 0 && novaNota <= 100) {
		this.nota[bimestre - 1] = novaNota;
		}
		}
		
		// 3-C)M�todo para atribuir nota no Exame
		public void setExame(float no) {
		if (nota[0] != -1 && nota[1] != -1 && nota[2] != -1 && nota[3] != -1) {
		if (no <= 100 && no >= 0) {
		exame = no;
		}
		}
		}
		
		// 3-D)M�todo para retornar o atibuto nome
		public String getNome() {
		nome = JOptionPane.showInputDialog("Informe o nome do aluno");
		return nome;
		}
		
		// 3-E)Obter M�dia dos Bimestres
		public float getMediaAnual() {
		float med = 0;
		int n = 0;// contador de nota lan�ada
		for (int i = 0; i < 4; i++) {
		if (nota[i] != -1) {
		med += nota[i]; // med = med + nota[i];
		n++;
		}
		}
		if (n == 0) {
		return 0;
		}
		return med / n;
		}
		
		// 3-F)Obter Situa��o do Aluno
		
		public String getSituacao() {
		if (nota[0] == -1 || nota[1] == -1 || nota[2] == -1 || nota[3] == -1) {
		return "ano em andamento";
		}
		if (getMediaAnual() < 50) {
		return "Aluno Reprovado";
		}
		if (getMediaAnual() >= 70) {
		return "Aluno Aprovado";
		}
		if (exame != -1) {
		if (getMediaAnual() < 50) {
		return "Aluno Reprovado ap�s realizar exame!";
		}
		return "Aluno Aprovado ap�s realizar exame!";
		}
		return "Aguardando aplica��o do exame!";
		}
		
		// 3-G)Obter M�dia Final
		
		public float getMediaFinal() {
		if (nota[0] == -1 || nota[1] == -1 || nota[2] == -1 || nota[3] == -1) {
		return 0;
		}
		if (getMediaAnual() >= 70) {
		return getMediaAnual();
		}
		if (exame != -1) {
		return (getMediaAnual() * 6 + exame * 4) / 10;
		}
		return 0;
		}
		}