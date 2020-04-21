import java.rmi.*;

public interface ServerIntf extends Remote {

    String concatenation(String d1, String d2) throws RemoteException;

}
