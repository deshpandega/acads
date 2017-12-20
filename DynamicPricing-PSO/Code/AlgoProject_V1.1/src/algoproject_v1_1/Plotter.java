/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoproject_v1_1;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


/**
 *
 * @author Gaurang Deshpande
 * <deshpande.ga@husky.neu.edu/gaurangdeshpande89@gmail.com>
 */
public class Plotter extends ApplicationFrame implements Runnable{

    static XYSeriesCollection serDataset;

    public static XYSeriesCollection getSerDataset() {
        return serDataset;
    }
    public static void setSerDataset(XYSeriesCollection serDataset) {
        Plotter.serDataset = serDataset;
    }
    
//    @Override
//    public void paint(Graphics g) {
//        JFreeChart scatterPlot = createChart();
//        scatterPlot.draw( (Graphics2D)g,getBounds()); 
//    }
    
//    @Override
//    public void init(){
//        JFreeChart scatterPlot = createChart();
//        
//    }
    
//    private static JFreeChart createChart(){
//        JFreeChart scatterPlot = ChartFactory.createScatterPlot(
//                    "Particle Movement",
//                    "Price", "Revenue",
//                    serDataset,
//                    PlotOrientation.VERTICAL ,
//                    true , true , false
//            );
//        
//        XYPlot xyPlot = (XYPlot) scatterPlot.getPlot();
//        xyPlot.setDomainCrosshairVisible(true);
//        xyPlot.setRangeCrosshairVisible(true);
//        xyPlot.setBackgroundPaint(Color.lightGray);
//        xyPlot.setDomainGridlinePaint(Color.white);
//        xyPlot.setRangeGridlinePaint(Color.white);
//        xyPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
//        XYItemRenderer renderer = xyPlot.getRenderer();
//        renderer.setSeriesPaint(1, Color.red);
//        renderer.setSeriesPaint(0, Color.blue);
//        renderer.setSeriesStroke(1, new BasicStroke(1.0f));
//        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
//        renderer.setBaseItemLabelsVisible(true);
//        renderer.setBaseSeriesVisible(true);
//        renderer.setPlot(xyPlot);
//
//        NumberAxis xAxis = (NumberAxis) xyPlot.getDomainAxis();
//        xAxis.setRange(Util.varPriceMin, Util.varPriceMax);
//        xAxis.setTickUnit(new NumberTickUnit((Util.varPriceMax-Util.varPriceMin)/15));
//        xAxis.setVerticalTickLabels(true);
//        
//        return scatterPlot;
//    }

    public Plotter(String title) {
        super(title);
    }

    @Override
    public void run() {
        JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                "Particle Movement",
                "Price", "Revenue",
                serDataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        XYPlot xyPlot = (XYPlot) scatterPlot.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesPaint(1, Color.red);
        renderer.setSeriesPaint(0, Color.blue);

        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));

        NumberAxis xAxis = (NumberAxis) xyPlot.getDomainAxis();
        xAxis.setRange(Util.varPriceMin, Util.varPriceMax);
        xAxis.setTickUnit(new NumberTickUnit(2));
//        xAxis.setVerticalTickLabels(true);
        
        NumberAxis yAxis = (NumberAxis) xyPlot.getRangeAxis();
        yAxis.setRange(6000, 12000);
        yAxis.setTickUnit(new NumberTickUnit(300));
//        yAxis.setVerticalTickLabels(true);

        ChartPanel panel = new ChartPanel(scatterPlot);
        panel.setPreferredSize(new java.awt.Dimension(1080, 768));
        final XYPlot plot = scatterPlot.getXYPlot();

        plot.setRenderer(renderer);
        setContentPane( panel ); 

        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
        
        try{Thread.sleep(100);}catch(InterruptedException e){System.out.println(e);}  
    }
}