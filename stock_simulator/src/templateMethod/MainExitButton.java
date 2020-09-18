package templateMethod;

import guimaker.DataStation;
import guimaker.SecondFrame;
import guimaker.ThirdFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import singleton.SingletonLogger;

public class MainExitButton extends MyButton {
    
    private JFrame myFrame;
    public MainExitButton(int x, int y, JFrame frame) {
        this.myFrame = frame;
        button = new JButton("그만하기");
        buttonX = x;
        buttonY = y;
        
    }

    
    public void doWork() {
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SingletonLogger.getInstance().logger.fine("종료하기 버튼을 눌렀을 때 일을 한다.");
                myFrame.dispose();
                DataStation.calculateAllHaveStock();
                new ThirdFrame();
            }
        });
    }


}
