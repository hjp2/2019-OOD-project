package guimaker;

import remote.MyRemote;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import singleton.SingletonLogger;

/**
 * 
 * @author 김현준
 */
public class TestDrive {
    
    public static MyRemote stub;
    public static TestDrive client;
    
    public static void main(String[] args){
        client = new TestDrive();
        client.lookup();
        client.callRemoteMethod("SKT", "2018.01");

        SingletonLogger.getInstance().logger.finest("테스트 중입니다.");
        new FirstFrame().makeFirstFrame();  

    }
    
    
    public static void lookup(){
        try{
            Registry registry = LocateRegistry.getRegistry("localhost");
            stub = (MyRemote) registry.lookup("RemoteHello");
            SingletonLogger.getInstance().logger.info("주식 정보를 불러옵니다!");
            }catch (NotBoundException | RemoteException ex){
                SingletonLogger.getInstance().logger.severe(ex.getMessage());
            }
    }
    public static void callRemoteMethod(String comPany, String date){
        try{
            DataStation.getStockDataFromProxy = stub.stock(comPany, date);
            
            SingletonLogger.getInstance().logger.info(DataStation.getStockDataFromProxy.get(0).get(0) + DataStation.getStockDataFromProxy.get(0).get(1));
           }catch (RemoteException ex){
                SingletonLogger.getInstance().logger.severe(ex.getMessage());
                
        }
    }
    
    public static void callRankMethod(String name, int monoey){
        try {
            DataStation.getRankData = stub.rank(name, monoey);
        } catch (RemoteException ex) {
            Logger.getLogger(TestDrive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}

