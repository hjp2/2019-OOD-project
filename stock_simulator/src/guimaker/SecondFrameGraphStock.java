package guimaker;

import java.awt.GridLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import strategy.BarChart;
import strategy.BarLineChart;
import strategy.Chart;
import strategy.LineChart;

/**
 *
 * @author 김현준
 */
public class SecondFrameGraphStock {

    private JPanel myPanel;
    private boolean line;
    private boolean bar;
   
    
    

    
    
    public SecondFrameGraphStock(boolean bar, boolean line){
        this.line = line;
        this.bar = bar;
        makePanel();
    }
    
    /**
     * 패널을 만드는 메서드.
     */
    public void makePanel(){
        myPanel = new JPanel();
        myPanel.setBounds(650,50,500,400);
        myPanel.setLayout(new GridLayout());
        
        addGraph();
    }
    
    public JPanel getPanel(){
        return myPanel;
    }
    
    private void addGraph(){
        JFreeChart chart = null;
        Chart demo = new Chart();
        if(line == true && bar == false){
            demo.setStrategy(new LineChart());
            System.out.println("라인차트 생성");
        }
        if(bar == true && line == false){
            demo.setStrategy(new BarChart());
            System.out.println("바 차트 생성");
        }
        if((line && bar) ==true){
            demo.setStrategy(new BarLineChart());
            System.out.println("바, 라인 생성");

        }
        if((line == false) && (bar == false)){
            demo.setStrategy(new BarChart());
        }
        
        chart = demo.getChart();
        ChartPanel cpanel=new ChartPanel(chart);
        
        cpanel.setVisible(true);
        
        //cpanel.setBounds(650,50,500,400);
        //cpanel.setSize(10,10);
        //cpanel.setLocation(0,0);
        
        myPanel.add(cpanel, new Integer(1));
        
        SecondFrame.secondFrame.add(myPanel, new Integer(1));
        SecondFrame.secondFrame.setVisible(true);
        }
    
}
