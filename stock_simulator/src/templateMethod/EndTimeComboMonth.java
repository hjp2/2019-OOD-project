package templateMethod;

import javax.swing.JComboBox;

public class EndTimeComboMonth extends MyComboBox {
    
    private String end_month;
    
    public EndTimeComboMonth() {
        makeCombo();
    }
    
    public void makeCombo() {
        myCombo = new JComboBox<>(month);
        myCombo.setBounds(820,40,60,30);
    }

    public void doWork() {
    }

}
