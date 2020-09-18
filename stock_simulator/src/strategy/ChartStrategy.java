/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;

/**
 *
 * @author hjp
 */
public interface ChartStrategy {
    void makePlot(CategoryPlot plot);
    CategoryPlot getPlot();
}
