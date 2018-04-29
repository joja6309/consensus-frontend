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


  public class Image 
  {
    
    public final BufferedImage image;
    public double[] redPixels;
    public double[] greenPixels; 
    public double[] bluePixels;
    public String extension;
    public final String name;
    public final int height;
    public final int width;


    Image(BufferedImage image, String imageName, String ext) throws IOException
    {
         
         this.image =  image;
         Raster raster = image.getRaster();
         this.height = image.getHeight();
         this.width = image.getWidth();
         double[] r = new double [image.getWidth()*image.getHeight()];
         this.redPixels = raster.getSamples(0, 0, image.getWidth(), image.getHeight(), 0, r);
         this.greenPixels = raster.getSamples(0, 0, image.getWidth(), image.getHeight(), 1, r);
         this.bluePixels = raster.getSamples(0, 0,image.getWidth(), image.getHeight(), 1, r);
         this.extension = ext;
         this.name = imageName;
         //this.imageDir = this.workingDir + "/" + this.imageName;
        
    }
    
    
   

  // }
  

   
    


     }
  