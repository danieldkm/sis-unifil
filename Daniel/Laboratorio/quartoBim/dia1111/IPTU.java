package dia1111;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class IPTU extends JFrame {

	private JTextField txtArea, txtValor;
	private JCheckBox chbLimpo;
	private JRadioButton rbSim, rbNao;
	private JComboBox cb;
	private Handle handle = new Handle();

	public IPTU() {
		super("IPTU");

		Container con = getContentPane();
		con.setLayout(new FlowLayout());

		JLabel lbl = new JLabel("Área: ");
		con.add(lbl);

		txtArea = new JTextField(8);
		txtArea.addActionListener(handle);
		con.add(txtArea);
		
		chbLimpo = new JCheckBox("Sem Mato");
		chbLimpo.addItemListener(handle);
		con.add(chbLimpo);
				
				
		lbl = new JLabel("Esquina: ");
		con.add(lbl);
		
		ButtonGroup bg = new ButtonGroup();
		rbSim = new JRadioButton("Sim");
		rbSim.setSelected(true);
		rbSim.addItemListener(handle);
		rbNao = new JRadioButton("Não");
		rbNao.addItemListener(handle);
		bg.add(rbSim);
		bg.add(rbNao);
		con.add(rbSim);
		con.add(rbNao);
		
		lbl = new JLabel("Localização: ");
		con.add(lbl);
		
		cb = new JComboBox();
		cb.addItem("Residencial");
		cb.addItem("Comercial");
		cb.addItemListener(handle);
		con.add(cb);
		
		lbl = new JLabel("Valor IPTU: ");
		con.add(lbl);
		
		txtValor = new JTextField(10);
		txtValor.setEnabled(false);
		txtValor.addActionListener(handle);
		con.add(txtValor);
		
		setSize(250, 200);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		IPTU iptu = new IPTU();
		iptu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private boolean getVerificaTxtVazio(){
		try {
			double n = Double.parseDouble(txtArea.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "área não informada","Erro:",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	/*
	 * normal = 1.10;
	 * esquina = 0.20
	 * comercial = 0.10
	 * limpo = 15%
	 * */
	
	private void setCalcular(){
		double valor = 1.10;
		double soma = 0;
		if(getVerificaTxtVazio()){
			if(rbSim.isSelected()){
//				System.out.println("Radio buton selecionado");
				valor += 0.20;
			}
			if(cb.getSelectedItem().equals("Comercial")){
//				System.out.println("cmbobox selecionado");
				valor += 0.10;
			}
			soma = Double.parseDouble(txtArea.getText()) * valor;
			if(chbLimpo.isSelected()){
//				System.out.println("checkbox selecionado vlr" + (soma * (15d/100d)));
				soma += - (soma * (15/100d));
			}
			BigDecimal valorNovo = new BigDecimal(soma);
			txtValor.setText("R$ " + valorNovo.setScale(2, BigDecimal.ROUND_HALF_UP));
		}
	}
	
	public class Handle implements ActionListener, ItemListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == txtArea){
				setCalcular();
			}
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource() == chbLimpo){
				setCalcular();
			} else if(e.getSource() == cb){
				setCalcular();
			} else if(e.getSource() == rbSim){
				setCalcular();
			}else if(e.getSource() == rbNao){
				setCalcular();
			}
			
		}
		
	}


}
