package aula_01;

public class AlunoCorrecao {
	private String nome;
	private double[] nota;
	private double exame;

	public AlunoCorrecao() {
		nota = new double[4];
		nota[0] = -1;
		nota[1] = -1;
		nota[2] = -1;
		nota[3] = -1;
		exame = -1;
	}

	public AlunoCorrecao(String n) {
		nota = new double[4];
		nota[0] = -1;
		nota[1] = -1;
		nota[2] = -1;
		nota[3] = -1;
		exame = -1;
		nome = n;
	}

	public void setNome(String n) {
		nome = n;
	}

	public void setNota(double no, int bim) {
		if (bim > 0 && bim < 5) {
			if (no <= 100 && no >= 0) {
				nota[bim - 1] = no;
			}
		}
	}

	public void setExame(double no) {
		if (nota[0] != -1 && nota[1] != -1 && nota[2] != -1 && nota[3] != -1) {
			if (no <= 100 && no >= 0) {
				exame = no;
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public double getMediaAnual() {
		double med = 0;
		int n = 0; // contador de nota lancada
		for (int i = 0; i < 4; i++) {
			if (nota[i] != -1) {
				med = med + nota[i];
				n++;
			}
		}
		if (n == 0) {
			return 0;
		}
		return med / n;
	}

	public String getSituacao() {
		if (nota[0] == -1 || nota[1] == -1 || nota[2] == -1 || nota[3] == -1) {
			return "ano em andamento";
		}
		if (getMediaAnual() < 50) {
			return "reprovado";
		}
		if (getMediaAnual() >= 70) {
			return "aprovado";
		}
		if (exame != -1) {
			if (getMediaFinal() < 50) {
				return "reprovado depois de exame";
			}
			return "aprovado depois de exame";
		}
		return "esperando exame";
	}

	public double getMediaFinal() {
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
