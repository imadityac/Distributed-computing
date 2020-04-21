import java.rmi.*;

public class Client {
	public static void main(String args[]) {
		try {
			String ServerURL = "rmi://" + args[0] + "/Server";
			ServerIntf ServerIntf = (ServerIntf) Naming.lookup(ServerURL);
			double d1 = Double.valueOf(args[1]).doubleValue();
			
			System.out.println("The Number is: " + args[1]);

			System.out.println("The Number is : " + ServerIntf.oddeven(d1));

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
