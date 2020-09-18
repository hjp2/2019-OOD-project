package templateMethod;

import javax.swing.JComboBox;

public class EndTimeComboYear extends MyComboBox {
    
    private String end_yaer;
    
    public EndTimeComboYear() {
        makeCombo();
    }

    public void makeCombo() {
        myCombo = new JComboBox<>(year);
        myCombo.setBounds(720,40,60,30);
    }

    public void doWork() {
    }

}
