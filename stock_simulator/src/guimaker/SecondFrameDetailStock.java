package guimaker;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import templateMethod.DetailList;
import templateMethod.MyListBox;

/**
 *
 * @author 김현준
 */
public class SecondFrameDetailStock {
    
    private JPanel myPanel;
    
    public SecondFrameDetailStock(){

        makePanel();
        addDetailList();
    }
    
    /**
     * 패널을 만드는 메서드.
     */
    private void makePanel(){
        myPanel = new JPanel();
        myPanel.setBounds(100,500,500,400);
    }
    
    /**
     * 마이패널 리턴
     * @return JPanel 패널
     */
    public JPanel getPanel(){
        return myPanel;
    }
    
    /**
     * 패널에 리스트박스를 추가하는 메소드.
     */
    private void addDetailList(){
        JLabel detail = new JLabel("상세정보");
        detail.setBounds(10,0,60,30);
        MyListBox addDetailList = new DetailList(10,30);
        addDetailList.makeList();
        myPanel.add(detail);
        myPanel.add(addDetailList.getListBox());
    }
    
}
