import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {
	public ServerImpl() throws RemoteException {
	}
	
	public String oddeven(double d1) throws RemoteException {
		if (d1%2==0)
			return "Even";
		else if (d1%2!=0)
			return "Odd";
		else
			return "Incorrect input";
	}
}
