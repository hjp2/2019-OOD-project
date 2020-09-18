package templateMethod;

import guimaker.DataStation;
import static guimaker.DataStation.haveStorkDataArray;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;


public class HaveStockList extends MyListBox {
    
    public HaveStockList(int x, int y) {
        this.x = x;
        this.y = y;
        
}
    
    
    public void doWork() {
        myList.setSize(470, 300);
        myList.addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(MouseEvent e){
                
                if(e.getClickCount() == 1){
                    DataStation.sellSelectName = myList.getSelectedValue().toString();
                    
                }
                
            }
            
        });
    }

    public void getData() {
        String[] place = haveStorkDataArray.toArray(new String[haveStorkDataArray.size()]);
        myList = new JList(place);
    }

}
