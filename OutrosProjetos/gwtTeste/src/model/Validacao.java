package model;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import controller.ClienteController;

import entity.Cliente;

public class Validacao {
	private String cpf;
	private boolean erro;

	public Validacao() {
		erro = false;
	}

	public boolean validarNome(String nome) {
		if (nome.equals("")) {
			// JOptionPane.showMessageDialog(null, "Favor preencher o nome");
			return true;
		} else {
			return false;
		}
	}

	public boolean validarDataNascimento(String data) {
		if (data.equals("  /  /    ") || !data.equals("")) {
			Pattern p = Pattern
					.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
			Matcher m = p.matcher(data);
			if (!m.find()) {
				System.err.println("Data inválida.");
				return true;
				// data = "";
				// JOptionPane.showMessageDialog(null, "Data Inválida");
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean validarCPFValido(String cpf) {
		if (ValidaçãoCPF.isCPF(cpf) == false) {
			JOptionPane.showMessageDialog(null, "CPF inválido");
			return true;
			// } else if (ValidaçãoCPF.existeCPF(cpf2)) {
			// JOptionPane.showMessageDialog(null, "CPF já cadastrado");
			// txtClienteCPF.setText("");
			// erro = true;
		} else {
			return false;
		}
	}

	public boolean validarCPFExistente(String cpf) {
		if (ValidaçãoCPF.existeCPF(cpf)) {
			JOptionPane.showMessageDialog(null, "CPF já cadastrado");
			// txtClienteCPF.setText("");
			return true;
		} else {
			return false;
		}
	}

	public boolean validarCPFExistente(String cpf, String id) {
		Cliente cliente = null;
		ClienteController cc = new ClienteController();
		try {
			cliente = cc.buscaClientePorId(Integer.parseInt(id));
		} catch (NumberFormatException e2) {
			e2.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		if (!cliente.getCpf().equals(cpf)) {
			this.cpf = cpf.replace("-", "");
			this.cpf = this.cpf.replace(".", "");
			if (ValidaçãoCPF.isCPF(this.cpf) == false) {
				JOptionPane.showMessageDialog(null, "CPF inválido");
				// txtClienteCPF.setText("");
				return true;
				// txtClienteCPF.setText(cliente.getCpf());
			}
			// } else {
			// cpf = txtClienteCPF.getText();
		} else {
			return false;
		}
		// String cpf = txtClienteCPF.getText().replace(".", "");
		// cpf = cpf.replace("-", "");
		// String cpf2 = txtClienteCPF.getText();
		return false;
	}

	
	public boolean validarSexo(boolean fe, boolean ma){
		if(fe == false && ma == false){
			return true;
		} else {
			return false;
		}
	}
	// String cpf = txtClienteCPF.getText().replace(".", "");
	// cpf = cpf.replace("-", "");
	// String cpf2 = txtClienteCPF.getText();
	// erro = false;
	// boolean cpfValido = ValidaçãoCPF.isCPF(cpf);
	// if (txtClienteNome.getText().equals("")) {
	// JOptionPane.showMessageDialog(null, "Favor preencher o nome");
	// erro = true;
	// }
	//
	// if (erro == false) {
	// if (txtClienteDataNascimento.getText().equals("  /  /    ")
	// || !txtClienteDataNascimento.getText().equals("")) {
	// Pattern p = Pattern
	// .compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
	// Matcher m = p.matcher(txtClienteDataNascimento.getText());
	// if (!m.find()) {
	// System.err.println("Data inválida.");
	// erro = true;
	// txtClienteDataNascimento.setText("");
	// JOptionPane.showMessageDialog(null, "Data Inválida");
	// }
	// }
	// }
	//
	// if (erro == false) {
	// if (rdbtnClienteMasculino.isSelected() == false
	// && rdbtnClienteFeminino.isSelected() == false) {
	// JOptionPane.showMessageDialog(null, "Selecione o sexo");
	// erro = true;
	// }
	// }
	//
	// if (erro == false) {
	// if (cpfValido == false) {
	// JOptionPane.showMessageDialog(null, "CPF inválido");
	// erro = true;
	// } else if (ValidaçãoCPF.existeCPF(cpf2)) {
	// JOptionPane.showMessageDialog(null, "CPF já cadastrado");
	// txtClienteCPF.setText("");
	// erro = true;
	// }
	// }
}
