package templateMethod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import singleton.SingletonLogger;

public class StartTimeComboYear extends MyComboBox {
    
    private String start_yaer;
    
    public StartTimeComboYear() {
        makeCombo();
    }

    public void makeCombo() {
        myCombo = new JComboBox<>(year);
        myCombo.setBounds(460,40,60,30);
    }

    public void doWork() {
        
        
        
    }

}
