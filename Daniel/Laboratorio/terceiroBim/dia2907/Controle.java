package dia2907;

import javax.swing.JOptionPane;

public class Controle {

	private Consulta[] consultas;
	private int qtdConsulta;

	public Controle() {
		consultas = new Consulta[4];
	}

	public void incluir(String tipo, String nome, int matricula,
			int numeroDepe, int ano, double valor) {
		if (tipo.equals("PRATA")) {
			ConsultaPrata cp = new ConsultaPrata();
			cp.setInstaciar(nome, matricula, numeroDepe, ano, valor);
			consultas[0] = cp;
			consultas[0].setQtd(0);
		} else if (tipo.equals("OURO")) {
			ConsultaOuro co = new ConsultaOuro();
			co.setInstaciar(nome, matricula, numeroDepe, ano, valor);
			consultas[1] = co;
			consultas[1].setQtd(1);
		} else if (tipo.equals("DIA")) {
			ConsultaDiamante cd = new ConsultaDiamante();
			cd.setInstaciar(nome, matricula, numeroDepe, ano, valor);
			consultas[2] = cd;
			consultas[2].setQtd(2);
		} else if (tipo.equals("FAM")) {
			ConsultaFamilia cf = new ConsultaFamilia();
			cf.setInstaciar(nome, matricula, numeroDepe, ano, valor);
			consultas[3] = cf;
			consultas[3].setQtd(3);
		} else {
			System.out.println("Tipo inválido");
		}
	}

	public void exibir() {
		if (consultas[0] != null) {
			JOptionPane.showMessageDialog(null,
					"Tipo; PRATA\nMatricula " + consultas[0].getMatricula()
							+ " Nome: " + consultas[0].getNome());
		}
		if (consultas[1] != null) {
			JOptionPane.showMessageDialog(null,
					"Tipo; OURO\nMatricula " + consultas[1].getMatricula()
							+ " Nome: " + consultas[1].getNome());
		}

		if (consultas[2] != null) {
			JOptionPane.showMessageDialog(null,
					"Tipo; DIAMANTE\nMatricula " + consultas[2].getMatricula()
							+ " Nome: " + consultas[2].getNome());
		}
		if (consultas[3] != null) {
			JOptionPane.showMessageDialog(null,
					"Tipo; FAMILIA\nMatricula " + consultas[3].getMatricula()
							+ " Nome: " + consultas[3].getNome());
		}
	}

	public void totalConsulta() {
		if (consultas[0] != null) {
			JOptionPane.showMessageDialog(null,
					"Tipo; PRATA\n" + consultas[0].getQtd(0));
		}

		if (consultas[1] != null) {
			JOptionPane.showMessageDialog(null,
					"Tipo; OURO\n" + consultas[1].getQtd(1));
		}

		if (consultas[2] != null) {
			JOptionPane.showMessageDialog(null, "Tipo; DIAMANTE\n"
					+ consultas[2].getQtd(2));
		}
		if (consultas[3] != null) {
			JOptionPane.showMessageDialog(null, "Tipo; FAMILIA\n"
					+ consultas[3].getQtd(3));
		}

	}

	public void valorTotal() {
		if (consultas[0] != null) {
			JOptionPane.showMessageDialog(null,
					"Tipo; PRATA\n" + consultas[0].getValorConsulta());
		}

		if (consultas[1] != null) {
			JOptionPane.showMessageDialog(null,
					"Tipo; OURO\n" + consultas[1].getValorConsulta());
		}

		if (consultas[2] != null) {
			JOptionPane.showMessageDialog(null, "Tipo; DIAMANTE\n"
					+ consultas[2].getValorConsulta());
		}
		if (consultas[3] != null) {
			JOptionPane.showMessageDialog(null, "Tipo; FAMILIA\n"
					+ consultas[3].getValorConsulta());
		}
	}
}
