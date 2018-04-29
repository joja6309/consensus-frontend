import java.nio.file.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.*;
import java.awt.Graphics;
import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.net.URL;
import java.awt.image.Raster;
import java.nio.file.*;
import java.awt.Graphics2D;
import org.jfree.chart.ChartUtilities;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
public class Utils
{
    private Utils(){}
    

    public static void createDirectory(String path)
    {
      if (!Files.isDirectory(Paths.get(path))) {
          try
          {
            Files.createDirectory(Paths.get(path));
          }
          catch (IOException e) {
                System.err.println(e);
            }
      }
     
}
public static BufferedImage getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        return null;
    }
public static void WriteImage(BufferedImage img,String ext,String writePath)
  {
     try {
            File imgFile = new File(writePath);
    ImageIO.write(img,ext,imgFile);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    
  }
  private static JFreeChart createChartPanel(BufferedImage image) {
        // dataset
        int BINS = 256;
        HistogramDataset dataset = new HistogramDataset();
        Raster raster = image.getRaster();
        final int w = image.getWidth();
        final int h = image.getHeight();
        double[] r = new double[w * h];
        r = raster.getSamples(0, 0, w, h, 0, r);
       
        dataset.addSeries("Red", r, BINS);
        r = raster.getSamples(0, 0, w, h, 1, r);
       
        dataset.addSeries("Green", r, BINS);
        r = raster.getSamples(0, 0, w, h, 2, r);
        dataset.addSeries("Blue", r, BINS);
        // chart
        //"Histogram", "Value","Count",
        JFreeChart chart = ChartFactory.createHistogram("","","",dataset, PlotOrientation.VERTICAL, false, false, false);
        
        XYPlot plot = (XYPlot) chart.getPlot();
        XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardXYBarPainter());
        // translucent red, green & blue
        Paint[] paintArray = {
            new Color(0x80ff0000, true),
            new Color(0x8000ff00, true),
            new Color(0x800000ff, true)
        };
        plot.setDrawingSupplier(new DefaultDrawingSupplier(
            paintArray,
            DefaultDrawingSupplier.DEFAULT_FILL_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));
        //ChartPanel panel = new ChartPanel(chart);
       // panel.setMouseWheelEnabled(true);
        return chart;
    }
     public static void WriteHistogram(Image img,String ext,String writePath)
  {
    
        // JFrame frame = new JFrame("Histogram");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 
        // frame.pack();
        // frame.setLocationRelativeTo(null);
        // //f.setVisible(true);
        //  //frame.add(this);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(400,400);
        // frame.setVisible(true);

        try
        {
            //BufferedImage image = new BufferedImage(400,400, BufferedImage.TYPE_INT_RGB);
            OutputStream out = new FileOutputStream(writePath);
            ChartUtilities.writeChartAsPNG(out, createChartPanel(img.image), 400,400);

            // Graphics2D graphics2D = img.image.createGraphics();
            // frame.paint(graphics2D);
            //ImageIO.write(image,"jpeg", new File(writePath));
        }
        catch(Exception exception)
        {
            //code
        }
      
   

  }
  // private void WriteHistogram(BufferedImage img,String ext,String writePath)
  // {
    
  //       this.f = new JFrame("Histogram");
  //       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //       f.add(createChartPanel());
  //       f.pack();
  //       f.setLocationRelativeTo(null);
  //       //f.setVisible(true);
  //        //frame.add(this);
  //       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //       frame.setSize(400,400);
  //       frame.setVisible(true);

  //       try
  //       {
  //           BufferedImage image = new BufferedImage(400,400, BufferedImage.TYPE_INT_RGB);
  //           Graphics2D graphics2D = image.createGraphics();
  //           frame.paint(graphics2D);
  //           ImageIO.write(image,"jpeg", new File(writePath));
  //       }
  //       catch(Exception exception)
  //       {
  //           //code
  //       }
  //       // 
  //       // BufferedImage objBufferedImage=f.createBufferedImage(600,800);
  //       // ByteArrayOutputStream bas = new ByteArrayOutputStream();
  //       // try {
  //       //     ImageIO.write(objBufferedImage, "png", bas);
  //       // } catch (IOException e) {
  //       //     e.printStackTrace();
  //        }
 
public static BufferedImage[] SplitImage(BufferedImage image, int rows, int cols)
    {

        int chunks = rows * cols;
        int chunkWidth = image.getWidth() / cols; // determines the chunk width and height
        int chunkHeight = image.getHeight() / rows;
        int count = 0;
        BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                //Initialize the image array with image chunks
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());
                // draws the image chunk
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0, 
                            chunkWidth, chunkHeight, 
                            chunkWidth * y, chunkHeight * x, 
                            chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                gr.dispose();
            }
        }
        return imgs;
    }
}

