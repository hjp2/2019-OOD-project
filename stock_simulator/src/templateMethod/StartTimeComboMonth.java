package templateMethod;

import javax.swing.JComboBox;

public class StartTimeComboMonth extends MyComboBox {
    
    private String start_month;
    
    public  StartTimeComboMonth() {
        
        makeCombo();
    }
    
    public void makeCombo() {
        myCombo = new JComboBox<>(month);
        myCombo.setBounds(560,40,60,30);
    }

    public void doWork() {
    }

}
