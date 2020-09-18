/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author hjp
 */
public class LineChart implements ChartStrategy{
    CategoryPlot tempPlot;

    @Override
    public void makePlot(CategoryPlot plot) {
        plot = new CategoryPlot();
        CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
        ItemLabelPosition p_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT);
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setBaseItemLabelGenerator(generator);
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseShapesVisible(true);
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setBaseFillPaint(Color.WHITE);
        //renderer2.setBaseItemLabelFont(f);
        renderer.setBasePositiveItemLabelPosition(p_below);
        renderer.setSeriesPaint(0,new Color(219,121,22));
        renderer.setSeriesStroke(0,new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 3.0f));
        plot.setRenderer(renderer);
        
        tempPlot = plot;
    }

    @Override
    public CategoryPlot getPlot() {
        return tempPlot;
    }
    
}
