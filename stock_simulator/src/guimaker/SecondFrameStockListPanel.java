package guimaker;


import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import templateMethod.BuyButton;
import templateMethod.MyButton;
import templateMethod.MyListBox;
import templateMethod.StockDataList;

/**
 *
 * @author 김현준
 */
public class SecondFrameStockListPanel {
    
    private JPanel myPanel;
    
    /**
     * 생성자에서 메서드를 부른다.
     */
    public SecondFrameStockListPanel(){

        makePanel();
        addStockList();
        addBuyButton();
    }
    
    /**
     * 패널을 만드는 메서드.
     */
    private void makePanel(){
        myPanel = new JPanel();
        myPanel.setBounds(100,50,500,400);
        myPanel.setLayout(new GridLayout());
    }
    
    /**
     * 주식정보 리스트를 패널에 추가한다.
     */
    private void addStockList(){
        JLabel stock = new JLabel("회사정보");
        stock.setBounds(20,0,70,30);
        
        myPanel.add(stock);
        
        MyListBox stockDataList = new StockDataList(20,30);
        stockDataList.makeList();
        myPanel.add(stockDataList.getListBox());
    }
    
    /**
     * 패널에 구매 버튼을 추가한다.
     */
    private void addBuyButton(){
        MyButton addBuyButton = new BuyButton(20,340);
        addBuyButton.makeButton();
        myPanel.add(addBuyButton.getButton());
    }
    
    /**
     * 패널을 리턴한다
     * @return JPanel 패널
     */
    public JPanel getPanel(){
        return myPanel;
    }
    
}
