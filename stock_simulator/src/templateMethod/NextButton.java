package templateMethod;

import guimaker.DataStation;
import guimaker.SecondFrame;
import static guimaker.SecondFrame.secondFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import singleton.SingletonLogger;

public class NextButton extends MyButton {
    
    private JLabel frame;
    
    public NextButton(int x, int y ) {
        button = new JButton("다음");
        buttonX = x;
        buttonY = y;
    }
    
    public void doWork() {
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SingletonLogger.getInstance().logger.fine("넥스트 버튼을 눌렀을 때 일을 한다.");
                if(DataStation.nowPage < DataStation.lastPage){
                    DataStation.pushNext();
                    SingletonLogger.getInstance().logger.fine(DataStation.nowTimeY + "." + DataStation.nowTimeM);
                    DataStation.nowPage += 1;
                    
                    secondFrame.dispose();
                    SecondFrame.barChk = false;
                    SecondFrame.lineChk = false;
                    SecondFrame tset = new SecondFrame();
                    tset.makeSecondFrame();
                    //돈 깍을 필요가 없어 주석처리 DataStation.nowMoney = DataStation.nowMoney - 100000;
                    
                }
                else{
                    JFrame instanceFrame = new JFrame("Fail");
            
                    instanceFrame.setSize(200, 130);
                    instanceFrame.setLocation(400, 500);
                    instanceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    instanceFrame.setLayout(null);
                    JLabel addLabel = new JLabel("마지막 페이지 입니다");
                    addLabel.setBounds(40,0,150,100);
                    instanceFrame.add(addLabel);
                    instanceFrame.setVisible(true);
                }
                
                
            }
        });
    }
    
    
    public void setSizes(){
        button.setSize(80,50);
    }

}
