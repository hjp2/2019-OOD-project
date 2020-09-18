package templateMethod;

import guimaker.DataStation;
import guimaker.SecondFrame;
import guimaker.SecondFrameDetailStock;
import guimaker.SecondFrameGraphStock;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import singleton.SingletonLogger;
import state.*;
import state.KAKAOState;
import state.CompanyList;

public class StockDataList extends MyListBox {
    
    
    public StockDataList(int x, int y) {
        
        
        this.x = x;
        this.y = y;
    }
    
    /**
     * 리스트의 액션리스너를 구현하는 부분.
     */
    public void doWork() {
        myList.setSize(450,300);
        CompanyList list = new CompanyList();
        myList.addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(MouseEvent e){
                
                if(e.getClickCount() == 1){
                    
                    SingletonLogger.getInstance().logger.info("이 리스트를 클릭시 "
                            + "패널을 새로고침 한다.");
                    //DataStation.selectCompany = myList.getSelectedValue().toString();
                    
                    
                    if(myList.getSelectedValue().toString() == "GS"){
                        list.setState(new GSState());
                        
                    }
                    if(myList.getSelectedValue().toString() == "KAKAO"){
                        list.setState(new KAKAOState());
                    }
                    
                    if(myList.getSelectedValue().toString() == "KB금융"){
                        list.setState(new KBState());
                    }
                    if(myList.getSelectedValue().toString() == "KCC"){
                        list.setState(new KCCState());
                    }
                    if(myList.getSelectedValue().toString() == "KT"){
                        list.setState(new KTState());
                    }
                    if(myList.getSelectedValue().toString() == "LG전자"){
                        list.setState(new LGState());
                    }
                    if(myList.getSelectedValue().toString() == "NAVER"){
                        list.setState(new NAVERState());
                    }
                    if(myList.getSelectedValue().toString() == "SKT"){
                        list.setState(new SKTState());
                    }
                    if(myList.getSelectedValue().toString() == "SK하이닉스"){
                        list.setState(new SKState());
                    }
                    if(myList.getSelectedValue().toString() == "SOIL"){
                        list.setState(new SOILState());
                    }
                    if(myList.getSelectedValue().toString() == "삼성전자"){
                        list.setState(new SAMSUNGState());
                    }
                    if(myList.getSelectedValue().toString() == "셀트리온"){
                        list.setState(new CELLTRIONState());
                    }
                    if(myList.getSelectedValue().toString() == "신한은행"){
                        list.setState(new SHINHANState());
                    }
                    if(myList.getSelectedValue().toString() == "이마트"){
                        list.setState(new EMARTState());
                    }
                    if(myList.getSelectedValue().toString() == "현대자동차"){
                        list.setState(new HYUNDAIState());
                    }
                    
                    list.doOperation();
                    
                    SecondFrameGraphStock test = new SecondFrameGraphStock(SecondFrame.barChk, SecondFrame.lineChk);
                    SecondFrame.secondFrame.add(test.getPanel());
                    
                    SecondFrameDetailStock addDetail = new SecondFrameDetailStock();
                    SecondFrame.secondFrame.add(addDetail.getPanel());
                    
                    
                    JLabel haveMoney = new JLabel("현재 회사 : " + DataStation.selectCompany);
                    haveMoney.setBounds(10,10,100,30);
                    JPanel tet = new JPanel();
                    tet.setBounds(100,470,150,30);
                    tet.setLayout(new GridLayout());
                    tet.add(haveMoney);
                    
                    SecondFrame.secondFrame.add(tet,new Integer(1));
                    SecondFrame.secondFrame.setVisible(true);
                }
                
            }
            
        });
        
    }

    public void getData() {
        SingletonLogger.getInstance().logger.fine("이 메서드에서 정보를 받아온다.");
        DataStation.getCompanyStock();
        String[] test = DataStation.stockData.toArray(new String[DataStation.stockData.size()]);
        myList = new JList(needData123123);
    }

}
