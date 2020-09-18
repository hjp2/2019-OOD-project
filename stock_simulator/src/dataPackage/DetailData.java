/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataPackage;

import guimaker.DataStation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hjp
 */
public class DetailData {
    public static List<List<String>> originaldata = new ArrayList<List<String>>();
    public static ArrayList<String> data = new ArrayList<String>();
    
    public DetailData(){
            
    }
    
    /**s
     * 프록시에서 받아온 데이터를 하나씩 나눈 데이터
     * ->  상세 정보 리스트에 저장할 자료로 가공하는 메소드.
     */
    public static void makeData(){
        data.removeAll(data);
        
        String addText = "";
        for(int i = 0; i < originaldata.size() ; i++){
            
            for(int z = 0 ; z < 4; z++){
               addText += originaldata.get(i).get(z) + "  ";
            }
            data.add(addText);
            addText = "";
            
        }
    }
    
    public static void setData(){
        
        originaldata = DataStation.getStockDataFromProxy;
        
    }
    
    public static ArrayList<String> getData(){
        setData();
        makeData();
        return data;
    }
}
