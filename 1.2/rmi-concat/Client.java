import java.rmi.*;

public class Client {
    public static void main(String args[]) {
        try {
            String ServerURL = "rmi://" + args[0] + "/Server";
            ServerIntf ServerIntf = (ServerIntf) Naming.lookup(ServerURL);
            System.out.println("The first string is: " + args[1]);
            System.out.println("The second string is: " + args[2]);

            System.out.println("The concatenation is: " + ServerIntf.concatenation(args[1], args[2]));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
