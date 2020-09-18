package templateMethod;

import java.util.ArrayList;
import java.util.logging.Level;
import singleton.SingletonLogger;

/**
 * 작성자 : 김현준
 * 내용  : 메인함수
 */
public class Main  {
    
    public static void main(String args[]){
        
        ArrayList<String> test = new ArrayList<>();
        test.add("바보");
        test.add("천재");
        ArrayList<ArrayList> ttest = new ArrayList<>();
        ttest.add(test);
        System.out.println(ttest.get(0));
        
    }
}
