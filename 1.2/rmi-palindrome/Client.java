import java.rmi.*;

public class Client {
	public static void main(String args[]) {
		try {
			String ServerURL = "rmi://" + args[0] + "/Server";
			ServerIntf ServerIntf = (ServerIntf) Naming.lookup(ServerURL);
			System.out.println("The string is: " + args[1]);

			System.out.println("The String is Palindrome: " + ServerIntf.palindrome(args[1]));

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
