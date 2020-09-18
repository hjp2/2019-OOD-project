package templateMethod;

import guimaker.DataStation;
import static guimaker.DataStation.careTaker;
import static guimaker.DataStation.nowMoney;
import static guimaker.DataStation.nowTimeM;
import static guimaker.DataStation.nowTimeY;
import static guimaker.DataStation.originator;
import guimaker.FirstFrame;
import guimaker.SecondFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import singleton.SingletonLogger;

/**
 *
 * @author 김현준
 * 내용 : 시작 버튼에 대해 작성한 클래스이다.
 * Button 추상 클래스를 상속받는다.
 */
public class StartButton extends MyButton {
    
    private JFrame frame;
    /**
     * StartButton 생성자
     * 버튼의 x 좌표와 y 좌표 값을 받아서 버튼 생성
     * @param x = 버튼의 x 좌표
     * @param y = 버튼의 y 좌표
     */
    public StartButton(int x, int y, JFrame test){ /* 475, 300*/
        frame = test;
        button = new JButton("시작");
        buttonX = x;
        buttonY = y;
    }


    /**
     *버튼의 역할을 구현하는 함수.
     */
    @Override
    public void doWork() {
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SingletonLogger.getInstance().logger.fine("스타트 버튼을 눌렀을 때 일을 한다.");
                if(FirstFrame.isCanNext()){
                    frame.dispose();
                    DataStation.nowMoney = DataStation.haveMoney;
                    
                    SecondFrame openFrame = new SecondFrame();
                    openFrame.makeSecondFrame();
                }
                else{
                    JFrame exFrame;
                    exFrame = new JFrame("확인창");
                    
                    exFrame.setSize(300, 100);
                    exFrame.setLocation(400, 300);
                    exFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    exFrame.setLayout(new FlowLayout());
                    exFrame.add(new JLabel("입력 확인 버튼을 눌러 값이 옳은지 확인하세요"));
                    exFrame.setVisible(true);
                }

            }
        });
    }
    
    
    public void setSizes(){
        button.setSize(150,40);
    }

}
