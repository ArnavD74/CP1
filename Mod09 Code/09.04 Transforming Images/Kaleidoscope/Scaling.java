/**
 * This program scales an image by enlarging or shrinking.
 * 
 * ©FLVS 2008
 * Assignment 09.04 - Code Evaluation 1
 * @author B. Jordan 
 * @version 11/08/08
 */
import java.awt.geom.AffineTransform;
import java.awt.Graphics;
import java.awt.Graphics2D;
class Scaling
{
    private Picture originalPicture = null;
    private Picture newPicture = null;
    private Graphics g = null;
    private Graphics2D g2 = null;
    Scaling(Picture pic)
    {
        originalPicture = pic;
    }
    public Picture scalePicture(double xFactor, double yFactor)
    {
        AffineTransform scaleTransform = new AffineTransform();
        scaleTransform.scale(xFactor, yFactor);
        newPicture = new Picture((int)(originalPicture.getWidth()*xFactor), (int)(originalPicture.getHeight()*yFactor));
        g = newPicture.getGraphics();
        g2 = (Graphics2D)g;
        g2.drawImage(originalPicture.getImage(), scaleTransform, null);
        
        return newPicture;
    }
}