import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {
        public ServerImpl() throws RemoteException {
        }

        public String palindrome(String d1) throws RemoteException {
                StringBuilder d2 = new StringBuilder();

                // append a string into StringBuilder input1
                d2.append(d1);
                // reverse StringBuilder input1
                d2 = d2.reverse();

				if (d1.equals(String.valueOf(d2)))
	                return "True";
	            else
	            	return "False";
        }
}
