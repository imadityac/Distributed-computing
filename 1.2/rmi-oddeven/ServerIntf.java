import java.rmi.*;

public interface ServerIntf extends Remote {

    String oddeven(double d1) throws RemoteException;

}
