import java.rmi.*;

public interface ServerIntf extends Remote {

    String strrev(String d1) throws RemoteException;

}
