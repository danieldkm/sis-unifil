package singleton.exemplo;

import javax.swing.JFrame;

public class SingletonFrame extends JFrame{

	private static SingletonFrame myInstance = null; 
	// the constructor 
	private SingletonFrame() { 
	this.setSize(400, 100); 
	this.setTitle("Singleton Frame. @" + this.getClass().hashCode());
	this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
	} 
	public static SingletonFrame getInstance() { 
	if (myInstance == null) 
		myInstance = new SingletonFrame(); 
	return myInstance; 
	} 
	
}
