package templateMethod;

import guimaker.DataStation;
import guimaker.SecondFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import singleton.SingletonLogger;

public class BuyButton extends MyButton {
    public BuyButton(int x, int y) {
      
        button = new JButton("구매");
        buttonX = x;
        buttonY = y;
        DataStation.makeChooseL();
    }


    public void doWork() {
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                SingletonLogger.getInstance().logger.fine("구매 버튼을 눌렀을 때 일을 한다.");
                JFrame myFrame = new JFrame("구매 확인");
        
                myFrame.setSize(300, 400);
                myFrame.setLocation(400, 200);
                myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                myFrame.setLayout(null);
                
                
                JLabel addL = new JLabel(DataStation.selectCompany);
                addL.setBounds(100,50,100,50);
                
                JComboBox addC = new JComboBox(DataStation.chooseV);
                addC.setBounds(100,130,60,40);
                
                MyButton addBuyOKButton = new BuyOKButton(75,300, myFrame, addC);
                addBuyOKButton.makeButton();
                myFrame.add(addBuyOKButton.getButton());
                
                myFrame.add(addC);
                myFrame.add(addL);
                myFrame.setVisible(true);
                
            }
        });
    }

}
