import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
public class Histogram {

    private static final int BINS = 256;
    //private final BufferedImage image = getImage();
    private HistogramDataset dataset;
    private XYBarRenderer renderer;

    // private BufferedImage getImage() {
    //     try {
    //         return ImageIO.read(new URL(
    //             "http://i.imgur.com/kxXhIH1.jpg"));
    //     } catch (IOException e) {
    //         e.printStackTrace(System.err);
    //     }
    //     return null;
    // }

    // private ChartPanel createChartPanel() {
    //     // dataset
    //     dataset = new HistogramDataset();
    //     Raster raster = image.getRaster();
    //     final int w = image.getWidth();
    //     final int h = image.getHeight();
    //     double[] r = new double[w * h];
    //     r = raster.getSamples(0, 0, w, h, 0, r);
       
    //     dataset.addSeries("Red", r, BINS);
    //     r = raster.getSamples(0, 0, w, h, 1, r);
       
    //     dataset.addSeries("Green", r, BINS);
    //     r = raster.getSamples(0, 0, w, h, 2, r);
    //     dataset.addSeries("Blue", r, BINS);
    //     // chart
    //     //"Histogram", "Value","Count",
    //     JFreeChart chart = 
    //     ChartFactory.createHistogram("","","",dataset, PlotOrientation.VERTICAL, false, false, false);
    //     XYPlot plot = (XYPlot) chart.getPlot();
    //     renderer = (XYBarRenderer) plot.getRenderer();
    //     renderer.setBarPainter(new StandardXYBarPainter());
    //     // translucent red, green & blue
    //     Paint[] paintArray = {
    //         new Color(0x80ff0000, true),
    //         new Color(0x8000ff00, true),
    //         new Color(0x800000ff, true)
    //     };
    //     plot.setDrawingSupplier(new DefaultDrawingSupplier(
    //         paintArray,
    //         DefaultDrawingSupplier.DEFAULT_FILL_PAINT_SEQUENCE,
    //         DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
    //         DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
    //         DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
    //         DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));
    //     ChartPanel panel = new ChartPanel(chart);
    //     panel.setMouseWheelEnabled(true);
    //     return panel;
    // }

    // private JPanel createControlPanel() {
    //     JPanel panel = new JPanel();
    //     panel.add(new JCheckBox(new VisibleAction(0)));
    //     panel.add(new JCheckBox(new VisibleAction(1)));
    //     panel.add(new JCheckBox(new VisibleAction(2)));
    //     return panel;
    // }

    // private class VisibleAction extends AbstractAction {

    //     private final int i;

    //     public VisibleAction(int i) {
    //         this.i = i;
    //         this.putValue(NAME, (String) dataset.getSeriesKey(i));
    //         this.putValue(SELECTED_KEY, true);
    //         renderer.setSeriesVisible(i, true);
    //     }

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         renderer.setSeriesVisible(i, !renderer.getSeriesVisible(i));
    //     }
    // }

    // private void display() {
    //     JFrame f = new JFrame("Histogram");
    //     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     f.add(createChartPanel());
    //     // f.add(createControlPanel(), BorderLayout.SOUTH);
    //     // f.add(new JLabel(new ImageIcon(image)), BorderLayout.WEST);
    //     f.pack();
    //     f.setLocationRelativeTo(null);
    //     // f.setVisible(true);

    //     Container content = f.getContentPane();
    //     BufferedImage img = new BufferedImage(container.getWidth(), container.getHeight(), BufferedImage.TYPE_INT_RGB);
    //     Graphics2D g2d = img.createGraphics();
    //     content.printAll(g2d);
    //     g2d.dispose();
    //     try {
    //                     ImageIO.write(img, "png", new File("PrintMe.png"));
    //                 } catch (IOException ex) {
    //                     ex.printStackTrace();
    //                 }
    // }

    // public static void runHistogram() {
    //     EventQueue.invokeLater(() -> {
    //         new Histogram().display();
    //     });
    // }
}