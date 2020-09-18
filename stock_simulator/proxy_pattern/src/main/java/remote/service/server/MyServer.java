
package remote.service.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyServer implements MyRemote{
    
    private static final Logger logger= Logger.getLogger(MyRemote.class.getName());
    static List<List<String>> whole = new ArrayList<List<String>>(); //이중배열
    static List<List<String>> week = new ArrayList<List<String>>();
    static List<List<String>> user = new ArrayList<List<String>>(); //이중배열
    static List<List<String>> money = new ArrayList<List<String>>();
    
    static List<String> every(String a){ 
       
        BufferedReader br = null;
        List<String> tmp = new ArrayList<String>();
        try{
            br = Files.newBufferedReader(Paths.get("C:\\csv\\"+a+".csv"));
            Charset.forName("UTF-8");
            String line = "";
           
            while((line = br.readLine()) != null){
                //CSV 1행을 저장하는 리스트
                
                  String[] array = line.split(",");
                 // for (String output : array){
                      tmp = Arrays.asList(array);
                      
                      System.out.println(tmp);
                      whole.add(tmp);
                 // }
                }
            
            System.out.println(whole.get(0).get(0));
            
            System.out.println("-----------------------");
            return tmp;
           
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("no file ");
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("인풋 아웃풋 오류");
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return tmp;
    }
    static void month(String num){
       
        for(int i=0; i<whole.size(); i++){
            for(int j=0; j<4; j++){
            if(whole.get(i).get(j).contains(num)){
                
                week.add(whole.get(i));
          }
       }
        
 }
        for(int k=0; k<week.size(); k++){
        System.out.println(week.get(k));
}
       
}
  
      @Override
    public List<List<String>> stock(){
        MyServer.every("SK하이닉스");
        MyServer.month("2018.12");
        List<List<String>> test = MyServer.week;
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
}



 

