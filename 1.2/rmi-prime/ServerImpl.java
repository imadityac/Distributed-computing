import java.rmi.*;
import java.rmi.server.*;
import java.lang.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {
	public ServerImpl() throws RemoteException {
	}
	
	public String isprime(double d1) throws RemoteException {
		int flag=0;
		for (int i=2;i<Math.sqrt(d1)+1;i++)
			if(d1%i==0)
				return "False";
		return "True";
	}

}
