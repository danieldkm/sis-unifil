package exercicio_01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;

public class Song {
	
	private String title;
	private String artist;
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public void play(){
		JLabel c = new JLabel();
		final DateFormat formato = new SimpleDateFormat("HH:mm:ss");  
		System.out.println(formato);
		char[] a;
		String b = "aaaaaaaaa";	
		a = b.toCharArray();
		for (int i = 0; i < a.length; i++) {
			System.out.println("Posicao " + i + " Letra " + a[i]);
		}
	}
}
