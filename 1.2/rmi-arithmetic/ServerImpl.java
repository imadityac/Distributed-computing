import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {
    public ServerImpl() throws RemoteException {
    }

    public double add(double d1, double d2) throws RemoteException {
        return d1 + d2;
    }

    public double sub(double d1, double d2) throws RemoteException {
        return d1 - d2;
    }

    public double mult(double d1, double d2) throws RemoteException {
        return d1 * d2;
    }

    public double div(double d1, double d2) throws RemoteException {
        return d1 / d2;
    }
}
