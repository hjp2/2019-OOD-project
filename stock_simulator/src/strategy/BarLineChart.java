/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author hjp
 */
public class BarLineChart implements ChartStrategy {
    CategoryPlot tempPlot;

    @Override
    public void makePlot(CategoryPlot plot) {
        CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
        ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
        ItemLabelPosition p_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT);
        BarRenderer renderer = new BarRenderer();
        renderer.setBaseItemLabelGenerator(generator);
        renderer.setBaseItemLabelsVisible(false);
        renderer.setBasePositiveItemLabelPosition(p_center);
        //renderer.setBaseItemLabelFont(f);
        renderer.setSeriesPaint(0, new Color(0,162,255));
        plot.setRenderer(renderer);
        
        LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        renderer2.setBaseItemLabelGenerator(generator);
        renderer2.setBaseItemLabelsVisible(false);
        renderer2.setBaseShapesVisible(true);
        renderer2.setDrawOutlines(true);
        renderer2.setUseFillPaint(true);
        renderer2.setBaseFillPaint(Color.WHITE);
        //renderer2.setBaseItemLabelFont(f);
        renderer2.setBasePositiveItemLabelPosition(p_below);
        renderer2.setSeriesPaint(0,new Color(219,121,22));
        renderer2.setSeriesStroke(0,new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 3.0f));
        //plot.setRenderer(renderer);


        plot.setRenderer(1, renderer2);
        
        tempPlot=plot;
    }

    @Override
    public CategoryPlot getPlot() {
        return tempPlot;
    }
    
    
}
