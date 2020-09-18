package undo;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MementoPatternDemo {
    public static void main(String[] args) { 
        ArrayList <String> al = new ArrayList<>() ; //url로부터 받아오는 모든 정보를 담는 arraylist
        ArrayList <String> bl = new ArrayList<>(); //al의 arraylist에서 comma를 제거하여 bl에 저장
       for(int i=1; i<100; i++){
        String url = "https://finance.naver.com/item/sise_day.nhn?code=055550&page="+i; //주식정보 받아오는 주소(1페이지부터)
        Document doc = null;
        
        try {
            doc = Jsoup.connect(url).get();
            
        }
        catch(IOException e){
            e.printStackTrace();
         }
        
        Elements elements = doc.select(".type2 tr .tah"); //가져올 태그, 클래스
        
       System.out.println("====================================");
      
        for(Element element : elements){
         
           al.add(element.text());   //태그의 텍스트만 가져옴
         }
     }
          for(int j =0; j<6930; j++){
        
         bl.add(al.get(j).replaceAll(",", ""));   //텍스트의 comma를 제거한 내용만 가져옴
         try{
            String csvFileName = "c:/csv/shinhan.csv";  //csv파일 경로 or 이름
            
            String title = "날짜, 종가, 전일비, 시가, 고가, 저가, 거래량";
          
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream
            (csvFileName), "MS949"));
        
            writer.write(title + "\n"); //csv파일 작성
            
            for(int i=0; i<990; i++){
            
                for(int z=0; z<7; z++){
            writer.write(bl.get(7*i+z)+ ",");
           
                }
            writer.write("\n");
            }
             writer.close();
           }
        
          catch (IOException e){
              e.printStackTrace();
          }
    }
    }
}