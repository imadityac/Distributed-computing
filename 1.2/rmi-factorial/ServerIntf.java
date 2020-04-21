import java.rmi.*;

public interface ServerIntf extends Remote 
{
	double factorial(double n) throws RemoteException;
}
