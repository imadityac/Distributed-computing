/*
	Name:		Aditya Choudhari
	Roll No.:	45009
	Assignment:	1.1
*/
// A Java program for a Client 
import java.net.*;
import java.io.*;

public class tcpClient {
	// initialize socket and input output streams
	private Socket socket = null;
	private BufferedReader input = null;
	private DataOutputStream out = null;

	// constructor to put ip address and port
	public tcpClient(String address, int port) {
		// establish a connection
		try {
			socket = new Socket(address, port);
			System.out.println("Connected");

			// takes input from terminal
			input = new BufferedReader(new InputStreamReader(System.in));

			// sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException u) {
			System.out.println(u);
		} catch (IOException i) {
			System.out.println(i);
		}

		// string to read message from input
		String line = "";

		// keep reading until "Over" is input
		while (!line.equals("Over")) {
			try {
				line = input.readLine();
				out.writeUTF(line);
			} catch (IOException i) {
				System.out.println(i);
			}
		}

		// close the connection
		try {
			input.close();
			out.close();
			socket.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		tcpClient client = new tcpClient("127.0.0.1", 5000);
	}
}

/*
			++  OUTPUT  ++

aditya@aditya-HP-Laptop-15-bs1xx:~/Downloads/CL-IX/1.1$ javac tcpClient.java

aditya@aditya-HP-Laptop-15-bs1xx:~/Downloads/CL-IX/1.1$ java tcpClient 
Connected
hello
tcp connection
message passing
Over

*/
