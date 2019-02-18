/**
 * This class clips an image by enlarging or shrinking.
 * 
 * ©FLVS 2008
 * Assignment 09.04 - Code Evaluation 2
 * @author B. Jordan 
 * @version 11/08/08
 */
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
class Clipping
{
    Picture pic = null;
    Picture newPic = null;
    Graphics g = null;
    Graphics2D g2 = null;
    Clipping(Picture p1)
    {
        pic = p1;
        newPic = new Picture(pic.getWidth(),pic.getHeight());
        g = newPic.getGraphics();
        g2 = (Graphics2D)g;
    }
    public Picture clipPicture(Color color)
    {
        newPic.setAllPixelsToAColor(color);
        Ellipse2D.Double clip = new Ellipse2D.Double(0,0,newPic.getHeight(),newPic.getWidth());
        //Rectangle2D.Double clip = new Rectangle2D.Double(10,10,newPic.getHeight()-20,newPic.getWidth()-20);
        g2.setClip(clip);
        g2.drawImage(pic.getImage(),0,0,newPic.getHeight(),newPic.getWidth(),null);
        return newPic;
    }
}