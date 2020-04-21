import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {
    public ServerImpl() throws RemoteException {
    }

    public String concatenation(String d1, String d2) throws RemoteException {
        return d1.concat(d2);
    }
}
