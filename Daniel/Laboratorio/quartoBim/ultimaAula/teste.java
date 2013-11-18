package ultimaAula;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class teste extends JFrame
{
	JTextField t;
	public teste(){
		super("teste");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		JLabel l = new JLabel("teste");
		container.add(l);
		
		t = new JTextField("teste texto");
		Handle h = new Handle();
		t.addActionListener(h);
		container.add(t);
		
		setSize(150,100);
		setVisible(true);
		
	}
	
	public class Handle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == t){
				t.setText("te22222");
			}
			
		}
	}
	
	public static void main(String[] args) {
		teste t = new teste();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
