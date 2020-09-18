package templateMethod;
import javax.swing.JButton;
/**
 * 작성자 : 김현준
 * 내용 : 버튼을 생성하기 위한 템플릿 메서드 패턴의
 *       추상 클래스.
 */
public abstract class MyButton {
    
    protected JButton button;
    protected int buttonX;
    protected int buttonY;
    
    /**
     * 추상클래스인 버튼의 생성자.
     */
    public MyButton(){
    }
    
    
    /**
     * Button 추상 클래스가 가진 메서드를 사용하여
     * 버튼을 완성시켜주는 makeButton메서드.
     */
    public final void makeButton(){
        setSizes();
        setPosition();
        setPosition();
        doWork();
    }
    
    
    /**
     * 완성된 버튼을 반환해주는 메서드
     * @return (JButton)button
     */
    public JButton getButton(){
        return button;
    }
    
    
    /**
     * 버튼의 크기를 변경할 수 있게 해 주는 함수.
     */
    public void setSizes(){
        button.setSize(130, 40);
    }
   
    /**
     * 버튼의 위치를 정하는 함수.
     */
   public void setPosition(){
        button.setLocation(buttonX, buttonY);
   }
   
   public abstract void doWork();
   
}
