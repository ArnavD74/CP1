/**
 * The purpose of this program is to draw a picture with graphics methods in the OOP style.
 * 
 * @author Arnav Dashaputra
 * @version 1/19/2019
 */
import java.awt.*;
public class DrawingDemoV2
{
    private Picture tile = null;
    private Graphics g = null;
  
    DrawingDemoV2(Picture pict, Color background)
    {
        tile = pict;
        g = tile.getGraphics();      
        g.setColor(background);
        g.fillRect(0,0, tile.getWidth(), tile.getHeight());
    }
    
    public void drawARectangle(int x1, int y1, int width, int height, Color color)
    {
        g.setColor(color);
        g.drawRect(x1, y1, width, height);      
    }
    
    public void drawAFilledRectangle(int x1, int y1, int width, int height, Color color)
    {
        g.setColor(color);
        g.fillRect(x1, y1, width, height);      
    }
    
    public void drawAnOval(int x1, int y1, int width, int height, Color color)
    {
        g.setColor(color);
        g.drawOval(x1, y1, width, height);  
    }
    
    public void drawAFilledOval(int x1, int y1, int width, int height, Color color)
    {
        g.setColor(color);
        g.fillOval(x1, y1, width, height);  
    }
    
    public void drawAnArc(int x1, int y1, int width, int height, int startAngle, int arcAngle, Color color)
    {
        g.setColor(color);
        g.drawArc(x1, y1, width, height, startAngle, arcAngle);
    }
    
    public void drawALine(int x1, int y1, int x2, int y2, Color color)
    {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
    
 
    public void drawAString(String str, int x1, int y1, Color color)
    {
        g.setColor(color);
        g.drawString(str, x1, y1);
        
    }
    public Picture getPictureTile()
    {
        return tile;
    }    
}
