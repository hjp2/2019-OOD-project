package templateMethod;

import guimaker.DataStation;
import static guimaker.SecondFrame.secondFrame;
import guimaker.SecondFrameDetailStock;
import guimaker.SecondFrameHaveStock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import singleton.SingletonLogger;

class BuyOKButton extends MyButton {
    private JFrame instanceFrame;
    JComboBox com;
    public BuyOKButton(int x, int y, JFrame frame, JComboBox com) {
        this.com = com;
        this.instanceFrame = frame;
        button = new JButton("구매 확인");
        buttonX = x;
        buttonY = y;
    }


    public void doWork() {
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SingletonLogger.getInstance().logger.fine("구매 확인 버튼을 눌렀을 때 일을 한다.");
                
                DataStation.howMuch = com.getSelectedItem().toString();
                
                DataStation.howmuchHaveMoney();
                
                JPanel testPanel = new JPanel();
                testPanel.setBounds(80,10,300,30);

                JLabel haveMoney = new JLabel("보유금액 :");
                haveMoney.setBounds(80,10,70,30);
                testPanel.add(haveMoney);

                JLabel moneyTest= new JLabel((DataStation.nowMoney)+"");
                moneyTest.setBounds(150,10,70,30);
                testPanel.add(moneyTest);
                secondFrame.add(testPanel,new Integer(1));
                
                
                SecondFrameHaveStock updatePanel= new SecondFrameHaveStock();
                secondFrame.add(updatePanel.getPanel(), new Integer(1));
                
                
                
                    
                secondFrame.setVisible(true);
                
                instanceFrame.dispose();
                
            }
        });
    }

}
