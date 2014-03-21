package singleton.exemplo;

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;

public class MainFrame extends JFrame{


	JButton jButton1 = new JButton(); 
	JButton jButton2 = new JButton(); 
	public MainFrame() { 
		init(); 
	} 
	public static void main(String[] args) { 
		MainFrame frame = new MainFrame(); 
		frame.setSize(300, 250); 
		frame.setVisible(true); 
	} 

	private void init() { 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		jButton1.setText("Show Singleton Frame"); 
		jButton1.setBounds(new Rectangle(12, 12, 220, 40)); 
		jButton1.addActionListener(
				new java.awt.event.ActionListener() { 
					public void actionPerformed(ActionEvent e) { 
						SingletonFrame singletonFrame = SingletonFrame.getInstance();
						singletonFrame.setVisible(true); 
					} 
				}
				); 
		jButton2.setText("Show the same Singleton Frame"); 
		jButton2.setBounds(new Rectangle(12, 72, 220, 40)); 
		jButton2.addActionListener(
				new java.awt.event.ActionListener() { 
					public void actionPerformed(ActionEvent e) { 
						SingletonFrame singletonFrame = SingletonFrame.getInstance(); 
						singletonFrame.setVisible(true); 
					}
				}
				); 
		this.getContentPane().setLayout(null); 
		this.getContentPane().add(jButton1, null);
		this.getContentPane().add(jButton2, null); 
	} 
} 

