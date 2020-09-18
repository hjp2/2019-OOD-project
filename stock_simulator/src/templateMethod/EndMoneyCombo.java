package templateMethod;

import javax.swing.JComboBox;

/**
 *
 * @author 김현준
 */
public class EndMoneyCombo extends MyComboBox {

    private String end_money;
    
    @Override
    public void makeCombo() {
        myCombo = new JComboBox<>(money);
        myCombo.setBounds(280,40,100,30);
    }

    @Override
    public void doWork() {
        
    }
    
}
