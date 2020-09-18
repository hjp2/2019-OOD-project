package templateMethod;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import singleton.SingletonLogger;

/**
 *
 * @author 김현준
 */
public class MoneyPanel extends Panel {
    
    private final JPanel detailPanels;
    private JTextField money;
    
    public MoneyPanel(){
        detailPanels = new JPanel();
        
        setLocation();
        addLabel();
        addTextField();
        doWork();
        setPanel(detailPanels);
    }

    @Override
    public final void setLocation() {
        detailPanels.setLocation(110, 110);
    }

    @Override
    public final void addLabel() {
        detailPanels.add(new JLabel(" 보유금 :"));
    }

    @Override
    public final void addTextField() {
        money = new JTextField(10);
        detailPanels.add(money);
    }

    @Override
    public final void doWork() {
        SingletonLogger print = SingletonLogger.getInstance();
        print.logger.fine("판넬이 할 일을 설정한다.");
    }
    
}
