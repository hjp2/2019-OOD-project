/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;


/**
 *
 * @author hjp
 */
public class ChartTest extends javax.swing.JFrame  {
    public static void main(final String[] args) {
       //GraphManager demo = new GraphManager(new LineGraph());
    JFreeChart freechart;
    JFrame frame;
    ChartPanel panel;
    ChartFrame frame1;
    Chart chart = new Chart();
    
    chart.setStrategy(new BarLineChart());
    freechart = chart.getChart();
    
    frame = new JFrame();
    panel = new ChartPanel(freechart);
    panel.setSize(600,800);
    //frame1=new ChartFrame("Bar Chart",freechart);
    frame.add(panel);
   
    frame.setSize(800,600); 
    frame.setVisible(true);
    }
}

