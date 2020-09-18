/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.awt.Color;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author hjp
 */
public class BarChart implements ChartStrategy{
    CategoryPlot tempPlot;



    @Override
    public CategoryPlot getPlot() {
        return tempPlot;
    }

    @Override
    public void makePlot(CategoryPlot plot) {
        plot = new CategoryPlot();
        CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
        ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
        BarRenderer renderer = new BarRenderer();
        //CategoryItemRenderer renderer= new BarRenderer();
        renderer.setBaseItemLabelGenerator(generator);
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBasePositiveItemLabelPosition(p_center);
        //renderer.setBaseItemLabelFont(f);
        renderer.setSeriesPaint(0, new Color(0,162,255));
        plot.setRenderer(renderer);
        tempPlot = plot;
    }



    
}
