/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author hjp
 */
public class Chart {
    ChartStrategy chartStrategy;
    DefaultCategoryDataset dataset;
    CategoryPlot plot;
    JFreeChart chart;
    StockData data;
    
    public Chart(){
        data = new StockData();
        dataset = new DefaultCategoryDataset();
        plot = new CategoryPlot();
        
        dataset = data.getData(dataset);
    }   
    
    public JFreeChart getChart(){
   
        plot.setDataset(dataset);
        plot.setDataset(1, dataset);
        plot.setOrientation(PlotOrientation.VERTICAL);             // 그래프 표시 방향
        plot.setRangeGridlinesVisible(true);                       // X축 가이드 라인 표시여부
        plot.setDomainGridlinesVisible(true);  
        
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
             
        // X축 세팅
        plot.setDomainAxis(new CategoryAxis());              // X축 종류 설정
        //plot.getDomainAxis().setTickLabelFont(axisF); // X축 눈금라벨 폰트 조정
        //plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);       // 카테고리 라벨 위치 조정
            
        // Y축 세팅
        plot.setRangeAxis(new NumberAxis());                 // Y축 종류 설정
        //plot.getRangeAxis().setTickLabelFont(axisF);  // Y축 눈금라벨 폰트 조정
        
        chart = new JFreeChart(plot);
        chart.removeLegend();
        return chart;
    }
  
    public void setStrategy(ChartStrategy chartStrategy){
        this.chartStrategy = chartStrategy;
        this.chartStrategy.makePlot(plot);
        this.plot = chartStrategy.getPlot();
        
    }
    
    
}
