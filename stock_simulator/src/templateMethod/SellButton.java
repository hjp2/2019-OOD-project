package templateMethod;

import guimaker.DataStation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import singleton.SingletonLogger;

public class SellButton extends MyButton {
    
    public SellButton(int x, int y) {
      
        button = new JButton("판매");
        buttonX = x;
        buttonY = y;
    }


    public void doWork() {
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SingletonLogger.getInstance().logger.fine("판매 버튼을 눌렀을 때 일을 한다.");
                
                JFrame myFrame = new JFrame("구매 확인");
        
                myFrame.setSize(300, 400);
                myFrame.setLocation(500, 300);
                myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                myFrame.setLayout(null);
                
                MyButton addBuyOKButton = new SellOKButton(75,300, myFrame);
                addBuyOKButton.makeButton();
                myFrame.add(addBuyOKButton.getButton());
                
                JLabel addL = new JLabel(DataStation.sellSelectName);
                addL.setBounds(100,50,100,50);
                
                JComboBox addC = new JComboBox(DataStation.chooseV);
                addC.setBounds(100,130,60,40);
                myFrame.add(addC);
                myFrame.add(addL);
                myFrame.setVisible(true);
                
            }
        });
    }

}
