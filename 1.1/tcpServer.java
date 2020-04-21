/*
	Name:		Aditya Choudhari    
	Roll No.:	45009
	Assignment:	1.1
*/
// A Java program for a Server 
import java.net.*;
import java.io.*;

public class tcpServer {
	// initialize socket and input stream
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;

	// constructor with port
	public tcpServer(int port) {
		// starts server and waits for a connection
		try {
			server = new ServerSocket(port);
			System.out.println("Server started");

			System.out.println("Waiting for a client ...");

			socket = server.accept();
			System.out.println("Client accepted");

			// takes input from the client socket
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

			String line = "";

			// reads message from client until "Over" is sent
			while (!line.equals("Over")) {
				try {
					line = in.readUTF();
					System.out.println(line);

				} catch (IOException i) {
					System.out.println(i);
				}
			}
			System.out.println("Closing connection");

			// close connection
			socket.close();
			in.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		tcpServer server = new tcpServer(5000);
	}
}

/*
			++  OUTPUT ++

aditya@aditya-HP-Laptop-15-bs1xx:~/Downloads/CL-IX/1.1$ javac tcpServer.java

aditya@aditya-HP-Laptop-15-bs1xx:~/Downloads/CL-IX/1.1$ java tcpServer
Server started
Waiting for a client ...
Client accepted
hello
tcp connection
message passing
Over
Closing connection

*/
