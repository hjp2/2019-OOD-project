package templateMethod;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import singleton.SingletonLogger;

/**
 *
 * @author 김현준
 */

public class GoalPanel extends Panel {
    
    private final JPanel detailPanels;
    private JTextField money;
    
    /**
     * Panel을 상속받은 GoalPanel의 생성자
     * GoalPanel 에서 구현한 함수들을 실행함으로써 판넬을 완성한다.
     */
    public GoalPanel(){
        
        detailPanels = new JPanel();
        
        setLocation();
        addLabel();
        addTextField();
        doWork();
        setPanel(detailPanels);
    }

    @Override
    public final void setLocation() {
        detailPanels.setLocation(410, 110);
    }

    @Override
    public final void addLabel() {
        detailPanels.add(new JLabel(" 목표금액 :"));
    }

    @Override
    public final void addTextField() {
        money = new JTextField(10);
        detailPanels.add(money);
    }

    @Override
    public final void doWork() {
        SingletonLogger print = SingletonLogger.getInstance();
        print.logger.fine("골 판넬이 할 일을 설정한다.");
    }
    
}
