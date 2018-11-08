package view;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import model.Histogram;

public class HistogramDisplay extends ApplicationFrame{
    private final Histogram<String> histogram;

    public HistogramDisplay(String title, Histogram<String> histogram) {
        super(title);
        this.histogram = histogram;
        setContentPane(CreatePanel());
        pack();        
    }
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel CreatePanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dateSet){
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart", "Dominios email","Nº de emails",
                createDataset(),PlotOrientation.VERTICAL, rootPaneCheckingEnabled, 
                rootPaneCheckingEnabled,rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (String key : histogram.keySet()){
            dataSet.addValue(histogram.get(key),"",key);
        }
        return dataSet;
    }
    
}
