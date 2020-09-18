package guimaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import templateMethod.ExitProgramButton;
import templateMethod.MyButton;

/**
 *
 * @author guswn
 */
public class ThirdFrame {
    
    private JFrame myFrame;
    private String nowMoney;
    private String goalMoney;
    private String firstMoney;
    
    public ThirdFrame(){
        getNowData();
        makeThirdFrame();
        addExitButton();
        addRankButton();
        myFrame.setVisible(true);
    }
    
    /**
     * 
     */
    private void getNowData(){
        nowMoney = DataStation.nowMoney+"";
        firstMoney = DataStation.haveMoney+"";
        goalMoney = DataStation.goalMoney+"";
    }
    
    /**
     * 프레임을 만들기 위한 메서드.
     */
    private void makeThirdFrame(){
        myFrame = new JFrame("시뮬레이션 결과");
        
        myFrame.setSize(1000, 300);
        myFrame.setLocation(200, 200);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(null);
        addExitButton();
        addShowResult();
        
        myFrame.setVisible(true);
    }
    
    /**
     * 종료버튼을 프레임에 추가한다.
     */
    private void addExitButton(){
        MyButton addExitButton = new ExitProgramButton(400,200);
        addExitButton.makeButton();
        myFrame.add(addExitButton.getButton());
    }
    
    /**
     * 선택한 값 적용
     */
    private void addShowResult(){
        String finalResult = " 최종 결과    " + " 시작 금액 : " + firstMoney + " 목표 금액 : " + goalMoney + " 현재 금액 : " + nowMoney;
        JLabel showResult = new JLabel(finalResult);
        showResult.setBounds(100,20,500,50);
        myFrame.add(showResult);
    }
    
    /**
     * 랭킹 적용하는 라벨 추가.
     */
    private void addRankButton(){
        
        JTextField addNicName = new JTextField("나의 닉네임");
        addNicName.setBounds(300,120,150,50);
        
        JButton showRank = new JButton("랭킹보기");
        showRank.setBounds(470,120,100,50);
        
        showRank.addActionListener((ActionEvent e) -> {
            DataStation.nickName = addNicName.getText();
            
            myFrame = new JFrame("랭킹");
            
            String [] test = DataStation.makeRankListData();
            
            myFrame.setSize(250, 250);
            myFrame.setLocation(500, 500);
            myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            myFrame.setLayout(null);
            
            JList rankList = new JList(test);
            rankList.setBounds(0,0,250,250);
            myFrame.add(rankList);
            
            myFrame.setVisible(true);
        });
        
        myFrame.add(addNicName);
        myFrame.add(showRank);
        
    }
    
    
}
