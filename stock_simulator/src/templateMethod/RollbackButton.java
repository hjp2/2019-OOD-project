
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

public class RollbackButton extends MyButton {
    
    /**
     * 롤백 버튼의 생성자
     * @param x 좌표
     * @param y 좌표
     */
    public RollbackButton(int x, int y) {
      
        button = new JButton("롤백");
        buttonX = x;
        buttonY = y;
        
    }
    
    public void setSizes(){
        button.setSize(80,50);
    }

    /**
     * 버튼 액션 리스너를 추가한다.
     */
    public void doWork() {
        button.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e) {
                  SingletonLogger.getInstance().logger.fine("롤백 버튼을 눌렀을 때 일을 한다.");
                  if(0 == DataStation.nowPage){
                    JFrame instanceFrame = new JFrame("Fail");
            
                    instanceFrame.setSize(200, 130);
                    instanceFrame.setLocation(400, 500);
                    instanceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    instanceFrame.setLayout(null);
                    JLabel addLabel = new JLabel("처음 페이지 입니다");
                    addLabel.setBounds(40,0,150,100);
                    instanceFrame.add(addLabel);
                    instanceFrame.setVisible(true);
                }
                else{
                    DataStation.pushRollBack();
                    DataStation.nowPage = DataStation.nowPage - 1;
                    SingletonLogger.getInstance().logger.fine(DataStation.nowTimeY +"." + DataStation.nowTimeM);
                    
                    secondFrame.dispose();
                    SecondFrame.barChk = false;
                    SecondFrame.lineChk = false;
                    SecondFrame tset = new SecondFrame();
                    tset.makeSecondFrame();
                }

              }
          });
    }

}
