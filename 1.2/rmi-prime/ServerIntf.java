import java.rmi.*;

public interface ServerIntf extends Remote {

    String isprime(double d1) throws RemoteException;

}
