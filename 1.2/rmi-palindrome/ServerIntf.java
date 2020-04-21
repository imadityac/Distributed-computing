import java.rmi.*;

public interface ServerIntf extends Remote {

    String palindrome(String d1) throws RemoteException;

}
