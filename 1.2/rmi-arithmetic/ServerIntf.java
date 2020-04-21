import java.rmi.*;

public interface ServerIntf extends Remote {
    double add(double d1, double d2) throws RemoteException;

    double sub(double d1, double d2) throws RemoteException;

    double mult(double d1, double d2) throws RemoteException;

    double div(double d1, double d2) throws RemoteException;

}
