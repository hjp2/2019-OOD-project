/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataPackage;

import java.util.ArrayList;

/**
 *
 * @author hjp
 */
public class TestDirve {
    public static void main(String[] args) {
        String a = "2014.01.02, 40, 42, 38";
        String b = "2014.01.03, 40, 42, 38";
        String c = "2014.01.04, 40, 42, 38";
        
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        ArrayList<String> arrayListS = new ArrayList<String>();
        arrayListS.add(a);
        arrayListS.add(b);
        arrayListS.add(c);
        for(int i = 0; i<arrayListS.size();i++){
            int[] temp = {Integer.parseInt(arrayListS.get(i).split(", ")[0].split("\\.")[2]), 
                Integer.parseInt(arrayListS.get(i).split(", ")[1]), 
                Integer.parseInt(arrayListS.get(i).split(", ")[3])
            };
            arrayList.add(temp);
        }
       
 
        
        for(int[] i:arrayList){
            for(int j = 0;j<i.length;j++){
                System.out.printf("%d ",i[j]);
            }
            
        }
    }
}
