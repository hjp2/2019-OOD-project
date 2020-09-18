package guimaker;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import singleton.SingletonLogger;
import templateMethod.EndMoneyCombo;
import templateMethod.EndTimeComboMonth;
import templateMethod.EndTimeComboYear;
import templateMethod.MyButton;
import templateMethod.MyComboBox;
import templateMethod.StartButton;
import templateMethod.StartMoneyCombo;
import templateMethod.StartTimeComboMonth;
import templateMethod.StartTimeComboYear;

/**
 *
 * @author 김현준
 * 템플릿 메서드로 만들어진 재료들을 프레임에 추가하는 클래스
 */
public class FirstFrame {
    
    private JFrame myFrame;
    JTextField textField;
    JTextField goalMoneyTF;
    
    private String start_time_month;
    private String start_time_year;
    private String end_time_month;
    private String end_time_year;
    private String start_money;
    private String end_money;
    private MyComboBox startComboY;
    private MyComboBox startComboM;
    private MyComboBox endComboM;
    private MyComboBox endComboY;
    private MyComboBox addStartMoneyCombo;
    private MyComboBox addEndMoneyCombo;
    
    /**
     * FirstFrame의 생성자
     */
    public FirstFrame(){
        DataStation.haveStorkDataArray.add("보유 주식 정보 리스트");
    }
    /**
     * 프레임을 만드는 메소드.
     */
    public void makeFirstFrame(){
        myFrame = new JFrame("주식 시뮬레이터");
        
        myFrame.setSize(1000, 300);
        myFrame.setLocation(200, 200);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(null);
        addMoneyCombo();
        addStartTimeCombo();
        addEndTimeCombo();
        addButton();
        addAdaptButton();
        myFrame.setVisible(true);
    }
    
    /**
     * 시작 버튼을 추가하는 메소드.
     */
    private void addButton(){
        MyButton addButton = new StartButton(500,200, myFrame);
        addButton.makeButton();
        myFrame.add(addButton.getButton());
    }
    

    /**
     * 보유금과 목표금을 정하기 위한 필드를
     * 설정하는 메소드.
     */
    private void addMoneyCombo(){
        JLabel nowHave = new JLabel("보유금 :");
        nowHave.setBounds(30,40,50,30);
        
        addStartMoneyCombo = new StartMoneyCombo();
        addStartMoneyCombo.makeCombo();
        
        myFrame.add(nowHave);
        myFrame.add(addStartMoneyCombo.getCombo());
        
        JLabel goalMoney = new JLabel("목표금 :");
        goalMoney.setBounds(220,40,50,30);
        
        addEndMoneyCombo = new EndMoneyCombo();
        addEndMoneyCombo.makeCombo();
        
       
        
        myFrame.add(goalMoney);
        myFrame.add(addEndMoneyCombo.getCombo());
    }
    
    /**
     * 시작시간을 설정하는 콤보박스를
     * 추가하는 메소드
     * 미리 만들어진 콤보박스를 사용한다.
     */
    private void addStartTimeCombo(){
        JLabel startTime = new JLabel("시작일 :");
        startTime.setBounds(410,40,50,30);
        myFrame.add(startTime);
        
        startComboY = new StartTimeComboYear();
        myFrame.add(startComboY.getCombo());
        
        JLabel startTimeY = new JLabel("년");
        startTimeY.setBounds(530,40,50,30);
        myFrame.add(startTimeY);
        
        startComboM = new StartTimeComboMonth();
        myFrame.add(startComboM.getCombo());
        
        JLabel startTimeM = new JLabel("월");
        startTimeM.setBounds(625,40,50,30);
        myFrame.add(startTimeM);
    }
    
    /**
     * 종료시간을 설정하는 콤보박스를
     * 추가하는 메소드
     * 미리 만들어진 콤보박스를 사용한다.
     */
    private void addEndTimeCombo(){
        JLabel endTime = new JLabel("종료일 :");
        endTime.setBounds(670,40,50,30);
        myFrame.add(endTime);
        
        endComboY = new EndTimeComboYear();
        myFrame.add(endComboY.getCombo());
        
        JLabel endTimeY = new JLabel("년");
        endTimeY.setBounds(785,40,50,30);
        myFrame.add(endTimeY);
        
        endComboM = new EndTimeComboMonth();
        myFrame.add(endComboM.getCombo());
        
        JLabel endTimeM = new JLabel("월");
        endTimeM.setBounds(885,40,50,30);
        myFrame.add(endTimeM);
    }
    
    public static boolean canNext = false;
    
    public static boolean isCanNext(){
        return canNext;
    }
    
    private void addAdaptButton(){
        JButton adaptButton = new JButton("입력 확인");
        adaptButton.setBounds(330,200,150,40);
        
        adaptButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                start_time_year = startComboY.getCombo().getSelectedItem().toString();
                start_time_month = startComboM.getCombo().getSelectedItem().toString();
                DataStation.startTime = start_time_year + " " + start_time_month;
                DataStation.nowTimeY = Integer.parseInt(start_time_year);
                DataStation.nowTimeM = Integer.parseInt(start_time_month);
                        
                end_time_year = endComboY.getCombo().getSelectedItem().toString();
                end_time_month = endComboM.getCombo().getSelectedItem().toString();
                DataStation.endTime = end_time_year + " " + end_time_month;
                
                start_money = addStartMoneyCombo.getCombo().getSelectedItem().toString();
                end_money = addEndMoneyCombo.getCombo().getSelectedItem().toString();
                DataStation.haveMoney = Integer.parseInt(start_money);
                DataStation.goalMoney = Integer.parseInt(end_money);
                
                String show_massage = start_time_month + start_time_year + end_time_month + end_time_year + start_money + end_money;
                SingletonLogger.getInstance().logger.fine(show_massage);
                
                if(Integer.parseInt(start_time_year) < Integer.parseInt(end_time_year) && Integer.parseInt(start_money) < Integer.parseInt(end_money))
                {
                    canNext = true;
                    JFrame okFrame;
                    okFrame = new JFrame("확인창");
                    
                    okFrame.setSize(100, 100);
                    okFrame.setLocation(400, 300);
                    okFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    okFrame.setLayout(new FlowLayout());
                    okFrame.add(new JLabel("올바른 값 입력 확인"));
                    okFrame.setVisible(true);
                    DataStation.makeEndTime();
                }
                else{
                    JFrame exFrame;
                    exFrame = new JFrame("확인창");
                    
                    exFrame.setSize(500, 100);
                    exFrame.setLocation(400, 300);
                    exFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    exFrame.setLayout(new FlowLayout());
                    exFrame.add(new JLabel("조건 : 시작 년도는 종료 년도 보다 작아야한다 시작금액은 종료금액보다 작아야 한다"));
                    exFrame.setVisible(true);
                }
                
            }
        });
        myFrame.add(adaptButton);
    }
    
}
