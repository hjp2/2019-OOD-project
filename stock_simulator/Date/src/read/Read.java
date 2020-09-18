package read;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Read {
    
    static List<List<String>> whole = new ArrayList<List<String>>(); //이중배열
    static List<List<String>> week = new ArrayList<List<String>>();
    
    static void every(String a){ 
       
        BufferedReader br = null;
        
        try{
            br = Files.newBufferedReader(Paths.get("C:\\csv\\"+a+".csv"));
            Charset.forName("UTF-8");
            String line = "";
            
            while((line = br.readLine()) != null){
                //CSV 1행을 저장하는 리스트
                List<String> tmp = new ArrayList<String>();
                  String[] array = line.split(",");
                 // for (String output : array){
                      tmp = Arrays.asList(array);
                      
                      System.out.println(tmp);
                    whole.add(tmp);
                 // }
                }
            System.out.println(whole.get(0).get(0));
            
            System.out.println("-----------------------");
   
           
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("씨발");
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
}