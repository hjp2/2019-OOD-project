package remote.service.client;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import remote.service.server.MyRemote;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyRemoteClient {
    private MyRemote stub;
    private static final Logger logger = 
            Logger.getLogger(MyRemoteClient.class.getName());

    public static void main(String[] args){
        //MyRemoteClient.every("SK하이닉스");   //회사이름
        //MyRemoteClient.month("2018.12"); //날짜 설정 (2014.01~2018.12)
        MyRemoteClient client = new MyRemoteClient();
        client.lookup();
        client.callRemoteMethod();
    }
        public void lookup(){
            try{
                Registry registry = LocateRegistry.getRegistry("localhost");
                stub = (MyRemote) registry.lookup("RemoteHello");
                logger.info("주식 정보를 불러옵니다!");
                }catch (NotBoundException | RemoteException ex){
                    logger.severe(ex.getMessage());
                }
        }
        public void callRemoteMethod(){
            try{
               List<List<String>> s = stub.stock();
                logger.info(s.get(0).get(0) + s.get(0).get(1));
            }catch (RemoteException ex){
                logger.severe(ex.getMessage());
                
            }
        }
     

    
}
