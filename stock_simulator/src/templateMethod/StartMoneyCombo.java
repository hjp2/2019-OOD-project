package templateMethod;

import javax.swing.JComboBox;

/**
 *
 * @author 김현준
 */
public class StartMoneyCombo extends MyComboBox {
    
    private String start_money;

    @Override
    public void makeCombo() {
        myCombo = new JComboBox<>(money);
        myCombo.setBounds(100,40,100,30);
    }

    @Override
    public void doWork() {
        
    }
    
}
