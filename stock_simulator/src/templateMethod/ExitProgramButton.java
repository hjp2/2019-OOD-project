package templateMethod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ExitProgramButton extends MyButton {
    
   public ExitProgramButton(int x, int y) {
      
        button = new JButton("종료");
        buttonX = x;
        buttonY = y;
    }


    public void doWork() {
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               
                System.exit(0);
                
            }
        });
    }

}
