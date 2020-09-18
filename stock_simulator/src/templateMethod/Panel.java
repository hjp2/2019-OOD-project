package templateMethod;

import javax.swing.JPanel;

/**
 *
 * @author 김현준
 * 내용 : 추가할 판넬 들을 만들기 위한 추상 클래스
 * 판넬들을 여러가지 만들기 위해 쓰는 추상클래스
 * 
 */
public abstract class Panel {
    
    private JPanel panel;
    
    /**
     * 추상클래스 Panel의 생성자
     * 판낼을 생성만 하고 panel 변수에 저장한다.
     */
    public Panel(){
    }
    
    /**
     * 판낼을 리턴해준다.
     * @return panel
     * @return 
     */
    public JPanel getPanel(){
        return panel;
    }
    
    /**
     * 판넬을 설정할 수 있다
     * 같은 패키지 내에서만 부를 수 있다.
     * @param panel
     */
    protected void setPanel(JPanel panel){
        this.panel = panel;
    }
    
    /**
     * 판넬의 위치를 설정한다.
     */
    public abstract void setLocation();
    
    /**
     * 라벨을 추가한다.
     */
    public abstract void addLabel();
    
    /**
     * 텍스트필드를 추가한다.
     */
    public abstract void addTextField();
    
    /**
     * 어떠한 할 일을 정하는 함수.
     */
    public abstract void doWork();
    
}
