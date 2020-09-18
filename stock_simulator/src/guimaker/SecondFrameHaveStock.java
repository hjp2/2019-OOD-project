package guimaker;

import javax.swing.JLabel;
import javax.swing.JPanel;
import templateMethod.HaveStockList;
import templateMethod.MyButton;
import templateMethod.MyListBox;
import templateMethod.SellButton;

/**
 *
 * @author guswn
 */
public class SecondFrameHaveStock {

    private JPanel myPanel;
    
    public SecondFrameHaveStock(){

        makePanel();
    }
    
    /**
     * 패널을 만드는 메서드.
     */
    private void makePanel(){
        myPanel = new JPanel();
        myPanel.setBounds(650,500,500,400);
        addList();
    }
    
    /**
     * 패널에 리스트 추가.
     */
    private void addList(){
        JLabel haveStock = new JLabel("보유주식");
        haveStock.setBounds(10,0,60,30);
        
        
        MyListBox addHaveStockList = new HaveStockList(10,30);
        addHaveStockList.makeList();
        
        myPanel.add(haveStock);
        myPanel.add(addHaveStockList.getListBox());
    }
    
    /**
     * 패널에 판매 버튼 추가.
     */
    private void addSellButton(){
        MyButton addBuyButton = new SellButton(350,350);
        addBuyButton.makeButton();
        myPanel.add(addBuyButton.getButton());
    }
    
    /**
     * 마이패널 리턴
     * @return JPanel 패널
     */
    public JPanel getPanel(){
        return myPanel;
    }
    
    public void getStockData(){
        
    }
    
}
