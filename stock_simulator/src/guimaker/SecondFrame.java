package guimaker;

import static guimaker.DataStation.careTaker;
import static guimaker.DataStation.nowMoney;
import static guimaker.DataStation.nowTimeM;
import static guimaker.DataStation.nowTimeY;
import static guimaker.DataStation.originator;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import singleton.SingletonLogger;
import templateMethod.MainExitButton;
import templateMethod.MyButton;
import templateMethod.NextButton;
import templateMethod.RollbackButton;

/**
 *
 * @author 김현준
 */
public class SecondFrame {
    public static JFrame secondFrame;
    public static boolean barChk;
    public static boolean lineChk;
    private SecondFrameStockListPanel addStockDataPanel;
    private SecondFrameGraphStock addStockGraph;
    private SecondFrameDetailStock addDetailStockPanel;
    private SecondFrameHaveStock addPanelHaveStock;
    
    public SecondFrame(){
        
    }
    
    /**
     * 두번째 프레임을 만들어주는 메소드.
     */
    public void makeSecondFrame(){
        makeFrame();
        addNowMoneyJLabel();
        DataStation.getDetailStockData();
        
        addRollBackButton();
        addNextButton();
        addExitButton();
        addCheckBox();
        addStockDataPanel();
        addSecondPanelGraphStock();
        addSecondPanelDetailStock();
        addSecondPanelHaveStock();
        secondFrame.setVisible(true);
        
    }
    
    /**
     * 프레임을 만드는 메소드.
     */
    private void makeFrame(){
        secondFrame = new JFrame("주식 시뮬레이터");
            
        secondFrame.setSize(1300, 1000);
        secondFrame.setLocation(200, 0);
        secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secondFrame.setLayout(null);
        secondFrame.setVisible(true);
    }
    
    public static JPanel testPanel;
    /**
     * 프레임에 현재 보유금을 표시하는 라벨을 띄운다.
     */
    private static void addNowMoneyJLabel(){
        testPanel = new JPanel();
        testPanel.setBounds(80,10,300,30);
        
        JLabel haveMoney = new JLabel("보유금액 :");
        haveMoney.setBounds(80,10,70,30);
        testPanel.add(haveMoney);
        
        JLabel moneyTest= new JLabel((DataStation.nowMoney)+"");
        moneyTest.setBounds(150,10,70,30);
        testPanel.add(moneyTest);
        secondFrame.add(testPanel, new Integer(2));
    }
    
    /**
     * 프레임에 롤백 버튼을 추가한다.
     * test
     */
    private void addRollBackButton(){
        MyButton rollbackButton = new RollbackButton(10,450);
        rollbackButton.makeButton();
        secondFrame.add(rollbackButton.getButton());
        
    }
    
    /**
     * 프레임에 다음 버튼을 추가한다.
     */
    private void addNextButton(){
        
        MyButton nextButton = new NextButton(1180,450);
        nextButton.makeButton();
        secondFrame.add(nextButton.getButton());
    }
    
    /**
     * 프레임에 종료 버튼을 추가한다.
     */
    private void addExitButton(){
        MyButton exitButton = new MainExitButton(550,900,secondFrame);
        exitButton.makeButton();
        secondFrame.add(exitButton.getButton());
    }
    
    /**
     * 프레임에 체크박스를 추가한다.
     */
    private void addCheckBox(){
        //SecondFrameGraphStock()
        JCheckBox chkLine = new JCheckBox("선형",false);
        JCheckBox chkBars = new JCheckBox("막대",false);
        chkLine.setBounds(750,0,100,30);
        chkBars.setBounds(850,0,100,30);
        chkBars.addActionListener((ActionEvent e) -> {
            if(false==barChk){
                barChk = true;
                addSecondPanelGraphStock();
            }
            else{
                barChk = false;
                addSecondPanelGraphStock();
            }
            SingletonLogger.getInstance().logger.fine(String.valueOf(barChk));
        });
        
        chkLine.addActionListener((ActionEvent e) -> {
            if(false==lineChk){
                lineChk = true;
                addSecondPanelGraphStock();
            }
            else{
                lineChk = false;
                addSecondPanelGraphStock();
            }
            SingletonLogger.getInstance().logger.fine(String.valueOf(lineChk));
        });
        
        secondFrame.add(chkLine);
        secondFrame.add(chkBars);
    }
    
    /**
     * 주식 정보를 나타내는 주식 데이터 패널.
     */
    private void addStockDataPanel(){
        SecondFrameStockListPanel addStockDataPanel1 = new SecondFrameStockListPanel();
        secondFrame.add(addStockDataPanel1.getPanel(), new Integer(1));
    }
    /**
     * 주식 그래프를 나타내기 위한 패널 추가.
     */
    public void addSecondPanelGraphStock(){
        addStockGraph = new SecondFrameGraphStock(barChk, lineChk);
        //secondFrame.add(addStockGraph1.getPanel());
        secondFrame.setVisible(true);
    }
    //public static int test = 300;
    
    /**
     * 세부 주식 정보를 보여주는 주식.
     */
    private void addSecondPanelDetailStock(){
        addDetailStockPanel = new SecondFrameDetailStock();
        secondFrame.add(addDetailStockPanel.getPanel(), new Integer(1));
    }
    
    
    /**
     * 보유주식 정보를 추가하는 패널.
     */
    private void addSecondPanelHaveStock(){
        addPanelHaveStock = new SecondFrameHaveStock();
        secondFrame.add(addPanelHaveStock.getPanel(), new Integer(1));
    }
    
    
}
