package templateMethod;

import dataPackage.DetailData;
import guimaker.DataStation;
import static guimaker.DataStation.getStockDataFromProxy;
import guimaker.TestDrive;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import static singleton.SingletonLogger.logger;


public class DetailList extends MyListBox {
    
    public DetailList(int x, int y) {
        
        this.x = x;
        this.y = y;
        
    }
    
    
    /**
     * 이 리스트는 액션 리스너가 없다.
     */
    public void doWork() {
        logger.finest("리스트의 크기를 다시 정해주었다.");
        myList.setSize(450,360);
    }

    public void getData() {
        List<String> addArrayList = new ArrayList<String>();
        addArrayList = DetailData.getData();
        addArrayList.add(0, "날짜    현재가격    최고가   최저가  ");
        String[] test = addArrayList.toArray(new String[addArrayList.size()]);
        System.out.println(addArrayList.get(0) + " " + addArrayList.get(1));
        myList = new JList(test);
    }

}
