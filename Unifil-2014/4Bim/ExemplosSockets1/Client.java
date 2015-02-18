package ExemplosSockets1;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class Client extends JFrame {

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverIP;
	private Socket connection;
	private JTextField UsernameField;
	private String Username;
	Color RED = new Color(255, 0, 0);
	Color ORANGE = new Color(255, 128, 0);
	Color YELLOW = new Color(255, 255, 0);
	Color LIGHT_GREEN = new Color(51, 255, 51);
	Color GREEN = new Color(0, 255, 0);
	Color DARK_GREEN = new Color(0, 102, 0);
	Color LIGHT_BLUE = new Color(51, 51, 255);
	Color BLUE = new Color(0, 0, 255);
	Color DARK_BLUE = new Color(0, 0, 102);
	Color PURPLE = new Color(153, 0, 153);

	// constructor
	public Client(String host) {
		super("Azrin IM");
		serverIP = host;

		userText = new JTextField("Enter Message Here.");
		userText.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (userText.getText().equals("Enter Message Here.")) // User
																		// has
																		// not
																		// entered
																		// text
																		// yet
					userText.setText("");
			}
		});

		userText.setEditable(true);
		UsernameField = new JTextField("Enter Username Here.");
		UsernameField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (UsernameField.getText().equals("Enter Username Here.")) // User
																			// has
																			// not
																			// entered
																			// text
																			// yet
					UsernameField.setText("");
			}
		});

		add(new JLabel("Enter Username Here."));
		UsernameField.setEditable(true);
		userText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Username = UsernameField.getText();
				sendMessage(event.getActionCommand());
				userText.setText("");
				UsernameField.setText("");
			}
		});
		add(userText, BorderLayout.SOUTH);
		add(UsernameField, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow), BorderLayout.CENTER);
		setSize(400, 300);
		setVisible(true);
	}

	// connect to server
	public void startRunning() {
		try {
			connectToServer();
			setupStreams();
			whileChatting();
		} catch (EOFException eofException) {
			showMessage("\n Client terminated connection");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			Disconnect();
		}
	}

	// connect to server
	private void connectToServer() throws IOException {
		showMessage("Attempting connection... \n");
		connection = new Socket(InetAddress.getByName(serverIP), 6969);
		showMessage("Connected to: "
				+ connection.getInetAddress().getHostName());
	}

	// set up streams to send and receive messages
	private void setupStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Now connected to Server! \n");
	}

	// while chatting with server
	private void whileChatting() throws IOException {
		ableToType(true);
		do {
			try {
				message = (String) input.readObject();
				showMessage("\n" + message);
			} catch (ClassNotFoundException classNotfoundException) {
				showMessage("\n I dont know that object type");
			}
		} while (!message.equals(Username + ": END"));

	}

	// close the streams and sockets
	private void Disconnect() {
		showMessage("\n Disconnected.");
		ableToType(false);
		try {
			output.close();
			input.close();
			connection.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	// send messages to server
	private void sendMessage(String message) {
		try {
			output.writeObject(Username + ": " + message);
			output.flush();
			showMessage("\n" + Username + ": " + message);
			if (message.equals("RED")) {
				chatWindow.setForeground(RED);
			}
			if (message.equals("ORANGE")) {
				chatWindow.setForeground(ORANGE);
			}
			if (message.equals("YELLOW")) {
				chatWindow.setForeground(YELLOW);
			}
			// I am aware I need to space these if staments better :) .
			if (message.equals("LIGHT_GREEN")) {
				chatWindow.setForeground(LIGHT_GREEN);
			}
			if (message.equals("GREEN")) {
				chatWindow.setForeground(GREEN);
			}
			if (message.equals("DARK_GREEN")) {
				chatWindow.setForeground(DARK_GREEN);
			}
			if (message.equals("LIGHT_BLUE")) {
				chatWindow.setForeground(LIGHT_BLUE);
			}
			if (message.equals("BLUE")) {
				chatWindow.setForeground(BLUE);
			}
			if (message.equals("DARK_BLUE")) {
				chatWindow.setForeground(DARK_BLUE);
			}
			if (message.equals("PURPLE")) {
				chatWindow.setForeground(PURPLE);
			}

		} catch (IOException ioException) {
			chatWindow.append("\n something messed up sending message hoss!");
		}
	}

	// change/update chatWindow
	private void showMessage(final String m) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				chatWindow.append(m);
			}
		});
	}

	// gives user permission to type crap into the text box
	private void ableToType(final boolean tof) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				userText.setEditable(tof);
			}
		});
	}
}