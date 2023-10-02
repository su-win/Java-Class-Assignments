package chat;
//Written by: Su Win

import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class ChatClient extends JFrame implements Runnable, ActionListener {

	private static final long serialVersionUID = 1L;
	private static int WIDTH = 400;
	private static int HEIGHT = 300;
	private boolean connectedServer = false;
	
	JTextArea chatArea;
	JTextField textField;
	JButton sendButton;
	JScrollPane scrollPane;
	JLabel connectionStatusLabel;
	Socket socket;
	
	DataInputStream inputFromServer;
	DataOutputStream outputToServer;
	
	public ChatClient() {
		super("Chat Client");
		this.setSize(ChatClient.WIDTH, ChatClient.HEIGHT);
		createMenu();
		
		//display connection status
		connectionStatusLabel = new JLabel("Not Connected to server");
		
        
		//top/center panel
		chatArea = new JTextArea(30,30);
		chatArea.setText("Select Start Chat under the File menu to start chatting\n");
		chatArea.setForeground(Color.BLUE);
		chatArea.setEditable(false);
		scrollPane = new JScrollPane(chatArea);
		
		//bottom panel
		textField = new JTextField();
		textField.addActionListener(this);
		
		this.setLayout(new BorderLayout());
		this.add(connectionStatusLabel, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(textField, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		
		JMenuItem startChatItem = new JMenuItem("Start Chat");
		startChatItem.addActionListener(this);
			
		JMenuItem exitItem = new JMenuItem("Exit");		
		exitItem.addActionListener(this);
		
		menu.add(startChatItem);
		menu.add(exitItem);
		
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}
	
	public void run() {
	}

	
	public void actionPerformed(ActionEvent e) {
		
	//Connecting to Server to start chat / Start Chat
		if (e.getActionCommand().equals("Start Chat")){
			
			if (connectedServer){
				chatArea.append("You already to connect to the Server.\nYou can start chart in textfield.");	
				return;
			} 
			
			try {
				socket = new Socket("localhost", 9898);
				inputFromServer = new DataInputStream(socket.getInputStream());
				outputToServer = new DataOutputStream(socket.getOutputStream());
				
				connectionStatusLabel.setText("Connected");
				connectedServer = true;
				
				new Thread(new threadHandle()).start();
			} catch (IOException ex) {
				chatArea.append("Error Connecting to Server");
			}

			
	
	//Sending message
		}else if (e.getSource() == textField){
			
			if (!connectedServer) {
				chatArea.append("\nTo begin chatting, you need to connect server first."
						+ "\nGo to the File menu and click Start Chat to be able to start chatting.\n\n");
				return;
			}
			
			if (connectedServer) {
				try {
					
					chatArea.append("You: " + textField.getText() + "\n");
					outputToServer.writeUTF(textField.getText());
					textField.setText("");
					
				}catch (IOException e1) {
					chatArea.append("Error sending message.\n");
				}
			}
		
		
		//exit
		}else if (e.getActionCommand().equals("Exit")){
			
			if (!connectedServer) {
				return;
			}
			
			try {
				outputToServer.writeUTF("sign out from chat");
				socket.close();
				
			}catch (IOException e1) {
				chatArea.append("Error closing connection\n");
			}
			System.exit(0);
		}
		
		
	}


	
	
	private class threadHandle extends Thread implements Runnable{

		public void run() {
			try {
				while(true) {
					String msg = inputFromServer.readUTF();
					chatArea.append(msg);
				}
			} catch (IOException e) {
				if(connectedServer) {
					chatArea.append("Connection Lost");
				}
					chatArea.append(e.getMessage());
			}
		}
	}


	public static void main(String[] args) {
		ChatClient chatClient = new ChatClient();
		chatClient.setVisible(true);
	}
}


