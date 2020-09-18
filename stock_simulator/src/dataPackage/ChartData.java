/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataPackage;

import guimaker.DataStation;
import static guimaker.DataStation.makingDate;
import static guimaker.TestDrive.client;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hjp
 */
public class ChartData {
    
    public static ArrayList<Integer> data = new ArrayList<>();
   //ArrayList<String> originaldata = new ArrayList<String>();
    public static List<List<String>> originaldata = new ArrayList<List<String>>();
    
    
    public ChartData(){
        client.callRemoteMethod("SKT", "2014.01");
    }
    
    /**
     * 그래프를 만들기 위해 필요한 데이터를
     * 생성하는 메소드.
     */
    public static void makeData(){
        data.removeAll(data);
        
        for(int i = 0; i<originaldata.size();i++){
            data.add(Integer.parseInt(originaldata.get(i).get(1)));
            System.out.println(Integer.parseInt(originaldata.get(i).get(1)));
        }
        
    }
    
    public static void setData(){
        originaldata = DataStation.getStockDataFromProxy;
        System.out.println(DataStation.getStockDataFromProxy.get(0));
        System.out.println(originaldata.get(0));
    }
    
    public static ArrayList<Integer> getData(){
        setData();
        makeData();
        return data;
        
    }
}
    

