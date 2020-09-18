package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import remote.Data;

public interface MyRemote extends Remote{
    List<List<String>> stock(String comPany, String date) throws RemoteException;
    List<Data> rank(String name, int money) throws RemoteException;
}