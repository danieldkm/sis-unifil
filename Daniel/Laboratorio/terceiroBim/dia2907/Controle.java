package dia2907;

import javax.swing.JOptionPane;

public class Controle {

	private Consulta[] consultas;
	private int cont = 0;

	public Controle() {
		consultas = new Consulta[10];
	}

	public void incluir(String tipo, String nome, int matricula,
			int numeroDepe, int ano, double valor) {
		if (tipo.equals("PRATA")) {
			ConsultaPrata cp = new ConsultaPrata();
			cp.setInstaciar(nome, matricula, numeroDepe, ano, valor);
			consultas[cont] = cp;
			cont++;
		} else if (tipo.equals("OURO")) {
			ConsultaOuro co = new ConsultaOuro();
			co.setInstaciar(nome, matricula, numeroDepe, ano, valor);
			consultas[cont] = co;
			cont++;
		} else if (tipo.equals("DIAMANTE")) {
			ConsultaDiamante cd = new ConsultaDiamante();
			cd.setInstaciar(nome, matricula, numeroDepe, ano, valor);
			consultas[cont] = cd;
			cont++;
		} else if (tipo.equals("FAMILIA")) {
			ConsultaFamilia cf = new ConsultaFamilia();
			cf.setInstaciar(nome, matricula, numeroDepe, ano, valor);
			consultas[cont] = cf;
			cont++;
		} else {
			System.out.println("Tipo inválido");
		}
	}

	// TODO -- exibir por tipo, passando por parametro nos metodos, o tipo do
	// plano.
	public void exibir(String tipo) {
		String aux = "";
		System.out.println("felipa viadinho"
				+ consultas[0].getClass().getSimpleName().substring(2, 5));
		for (int i = 0; i < consultas.length; i++) {
			if (consultas[i] != null) {
				aux = consultas[i].getClass().toString().substring(22)
						.toUpperCase();
				System.out.println("????????????????" + aux);

				if (aux.equals(tipo.toUpperCase())) {
					JOptionPane.showMessageDialog(null, consultas[i].getNome()
							+ "\n" + consultas[i].getMatricula());
				}
				// if (aux.equals("PRATA")) {
				// JOptionPane.showMessageDialog(null, consultas[i].getNome()
				// + "\n" + consultas[i].getMatricula());
				// } else if (consultas[i].getClass().toString().substring(22)
				// .toUpperCase().equals("OURO")) {
				// JOptionPane.showMessageDialog(null, consultas[i].getNome()
				// + "\n" + consultas[i].getMatricula());
				// } else if (consultas[i].getClass().toString().substring(22)
				// .toUpperCase().equals("DIAMANTE")) {
				// JOptionPane.showMessageDialog(null, consultas[i].getNome()
				// + "\n" + consultas[i].getMatricula());
				// } else if (consultas[i].getClass().toString().substring(22)
				// .toUpperCase().equals("FAMILIA")) {
				// JOptionPane.showMessageDialog(null, consultas[i].getNome()
				// + "\n" + consultas[i].getMatricula());
				// }
			}
		}
	}

	public void totalConsulta(String tipo) {
		int n = 0;
		for (int i = 0; i < consultas.length; i++) {
			if (consultas[i] != null) {
				if (consultas[i].getClass().toString().substring(22)
						.toUpperCase().equals(tipo.toUpperCase())) {
					n++;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Qtd " + n);
		// JOptionPane.showMessageDialog(null, "Quantidade por tipo\nPrata: "
		// + prata + "\nOuro: " + ouro + "\nDiamante: " + diamante
		// + "\nFamilia: " + familia);
	}

	public void valorTotal(String tipo) {
		double valorTotal = 0;
		for (int i = 0; i < consultas.length; i++) {
			if (consultas[i] != null) {

				if (consultas[i].getClass().toString().substring(22)
						.toUpperCase().equals(tipo.toUpperCase())) {
					valorTotal += consultas[i].getValorConsulta();

				}
			}
		}
		JOptionPane.showMessageDialog(null, "Valor total: "
				+ valorTotal);
	}
}
