package fractalzoomer.utils;


import fractalzoomer.main.MainWindow;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hrkalona2
 */
public class MainPanel extends JPanel {
  private MainWindow ptr;
   
    public MainPanel(MainWindow ptr) {
        this.ptr = ptr;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        if(!ptr.getFirstPaint()) {
            ptr.getMainPanel().getGraphics().drawImage(new BufferedImage(MainWindow.FAST_JULIA_IMAGE_SIZE, MainWindow.FAST_JULIA_IMAGE_SIZE, BufferedImage.TYPE_INT_ARGB), ptr.getScrollPane().getHorizontalScrollBar().getValue(), ptr.getScrollPane().getVerticalScrollBar().getValue(), null);
            ptr.getScrollPane().getHorizontalScrollBar().setValue((int)(ptr.getScrollPane().getHorizontalScrollBar().getMaximum() / 2 - ptr.getScrollPane().getHorizontalScrollBar().getSize().getWidth() / 2));
            ptr.getScrollPane().getVerticalScrollBar().setValue((int)(ptr.getScrollPane().getVerticalScrollBar().getMaximum() / 2 - ptr.getScrollPane().getVerticalScrollBar().getSize().getHeight() / 2));
            ptr.setFirstPaint();
        }


       if(ptr.getWholeImageDone()) {
            g.drawImage(ptr.getImage(), 0, 0, null);
                
            if(ptr.getBoundaries()) {
                ptr.drawBoundaries((Graphics2D)g, true);
            }
                
            if(ptr.getGrid()) {
                ptr.drawGrid((Graphics2D)g, true);
            }
                
            if(ptr.getZoomWindow()) {
               ptr.drawZoomWindow((Graphics2D)g);
            }
       }
       else {
            if(!ptr.getColorCycling()) {
                g.drawImage(ptr.getLastUsed(), 0, 0, null);
                    
                if(ptr.getBoundaries() && ptr.getLastUsed() != null) {
                    ptr.drawBoundaries((Graphics2D)g, true);
                }
                    
                if(ptr.getGrid() && ptr.getLastUsed() != null) {
                    ptr.drawGrid((Graphics2D)g, true);
                }
                    
                if(ptr.getZoomWindow() && ptr.getLastUsed() != null) {
                   ptr.drawZoomWindow((Graphics2D)g);
                }
           }
       }
            
    }
  
}
