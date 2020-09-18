
package remote.service.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MyRemote extends Remote{
    List<List<String>> stock() throws RemoteException;
}
