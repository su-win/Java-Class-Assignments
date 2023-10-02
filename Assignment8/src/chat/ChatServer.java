package chat;
//Written by: Su Win

import java.awt.BorderLayout;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import javax.swing.*;



public class ChatServer extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private static int WIDTH = 400;
	private static int HEIGHT = 300;
	private int clientNum = 0;
	ArrayList<HandleClient> clients = new ArrayList<HandleClient>();
	private boolean disconnected = false;
    
	JTextArea textArea;
	JScrollPane scrollPane;
	ServerSocket serverSocket;
	
	public ChatServer() {
		super("Chat Server");
		this.setSize(ChatServer.WIDTH, ChatServer.HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		
		textArea = new JTextArea(5,10);
		textArea.setEditable(false);

		scrollPane = new JScrollPane(textArea);
		this.add(scrollPane, BorderLayout.CENTER);
		this.setVisible(true);
		
		
		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener((e) -> System.exit(0));
		menu.add(exitItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}
	

	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
		chatServer.setVisible(true);
	}
	
	
//Task: creating a ChatServer class that creates 
//a window with a JTextArea that displays debug info 
//including who has connected
	@Override
	public void run() {
		try {//create server socket
			serverSocket = new ServerSocket(9898);
			textArea.append("Chat Server started at socket 9898 on " + new Date());
			textArea.append("\nWaiting for connection from client\n");
			
			while(true) {
				//connect to client
				Socket socket = serverSocket.accept();
				clientNum++;
				textArea.append("\nUser " + clientNum + " connect to server.\n");
				
				
				InetAddress inetAdd = socket.getInetAddress();
				//Display client host name and IP address
				textArea.append("\tUser's IP Address: " + inetAdd.getHostAddress() +
						"\n\tUser's Host Name: " + inetAdd.getHostName());
				
				
				HandleClient clientThread = new HandleClient(clientNum, socket);
				clients.add(clientThread);
				clientThread.start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// Define the thread class for handling new connection
	public class HandleClient extends Thread{
		private Socket socket;
		private int clientNum;
		private DataInputStream inputFromClient;
		private DataOutputStream outputToClient;

		
		public HandleClient(int clientNum, Socket socket) {
			this.socket = socket;
			this.clientNum = clientNum;
		}
		
		public void run()throws RuntimeException {
			 try {
	                inputFromClient = new DataInputStream(socket.getInputStream());
					outputToClient = new DataOutputStream(socket.getOutputStream()); 
	              //continuously serve client
	               while(true) {
					
					//receive text from the client
					String msg = inputFromClient.readUTF();
					//if client thread is not the current thread, send out msg to client
					for(HandleClient client: clients) {
						if(client != this) {
							client.outputToClient.writeUTF("User " + clientNum + " : " + msg + "\n");
						}
					}
	              }
	              
				} catch (IOException e) {
					throw new RuntimeException(e);
				
				}
			
		}
	}
	
}
