
package templateMethod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SellOKButton extends MyButton {
    
    private JFrame myFrame;
    public SellOKButton(int x, int y, JFrame frame) {
        myFrame = frame;
        button = new JButton("확인");
        buttonX = x;
        buttonY = y;
    }

  public void doWork() {
      
      button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               
                myFrame.dispose();
                
            }
        });
  }

}
