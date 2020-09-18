
package remote;


import datamaker.Read;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;
import java.util.List;

public class MyServer implements MyRemote{
    
    private static final Logger logger= Logger.getLogger(MyRemote.class.getName());
    
    
    
    @Override
    public List<List<String>> stock(String comPany , String date){
        Read.every(comPany);
        Read.month(date);
        List<List<String>> test = Read.week;
        System.out.println(Read.week.get(0));
        
        return test;
    }
 
   public static void main(String[] args){
     try{   
        MyServer obj = new MyServer();
        MyRemote stub = (MyRemote)UnicastRemoteObject.exportObject(obj,0);
        
        Registry registry = LocateRegistry.getRegistry("localhost");
        registry.bind("RemoteHello", stub);
        logger.info("프로그램을 시작하겠습니다!");
        }catch (RemoteException | AlreadyBoundException ex){
             logger.severe("이미 바운딩 되었거나 리모트 Exception 발생");
        }
      
    }
   
    @Override
    public List<Data> rank(String name, int money) throws RemoteException {
        
        ReadCSV readCSV = new ReadCSV();
        readCSV.getCSV("./csv/랭킹.csv");
        System.out.println();
        
        readCSV.updateCSV(name,money);
        System.out.println();
        
        readCSV.sorting();
        System.out.println();
        
        readCSV.saveFile();
        System.out.println("test");
        return readCSV.getOriginal() ;
                
    }
}
