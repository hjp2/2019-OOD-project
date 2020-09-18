/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import dataPackage.ChartData;
import java.util.ArrayList;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author hjp
 */
public class StockData{

    //ChartData temp;
    ArrayList<Integer> tempdata;
    
    public DefaultCategoryDataset getData(DefaultCategoryDataset data){
        //temp = new ChartData();
        //tempdata = temp.getData();
        ChartData.getData();
        tempdata = ChartData.data;
 
        
        //for(int i=1; i<=31; i++){
        //    data.setValue(i, "a", Integer.toString(i));
        //}
        
        //for(int i:tempdata){
        //    for(int j = 0;j<tempdata;j++){
        //        System.out.printf("%d ",i[j]);
        //        data.setValue(i[1], "a", Integer.toString(i[0]));
        //    }
            
         
            
        //}
        
        for(int i =0; i<tempdata.size(); i++){
            data.setValue(tempdata.get(i), "a", Integer.toString(i));
        }
        

        return data;
        
    }

}
