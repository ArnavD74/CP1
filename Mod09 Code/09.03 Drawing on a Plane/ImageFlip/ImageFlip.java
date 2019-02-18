/**
* Implementation Class
* Mirrors an image 3 times to create a 2x2 composite panel, then again to form a 4x4 composite panel with 16 instances of the original image, drawn in the Picture method.
*
* @author Arnav Dashaputra
* @version 1/21/2019
*/
import java.awt.*;
public class ImageFlip
{
    private Picture newCanvas = null;
    private Graphics g = null;
    private Graphics2D g2D = null;
    ImageFlip(Picture canvasObject)
    { //initialization
        newCanvas = canvasObject; //creates new canvas object called newCanvas
        g = newCanvas.getGraphics(); //invokes getGraphics method on the canvas object to create graphics object 'g'
        g2D = (Graphics2D)g; //casts the graphics object 'g' to the Graphics2D object 'g2D'
        newCanvas.setAllPixelsToAColor(Color.BLACK); //defaults the canvas to the black color
    }
    public Picture setPicture()
    { //draws shapes that will be used for the flipping and miroring
        g2D.setColor(Color.WHITE);
        g2D.fillOval(0, 0, 15, 15);
        g2D.setColor(Color.RED);
        g2D.drawLine(10, 10, 30, 30);
        g2D.drawLine(30, 30, 20, 20);
        g2D.setColor(Color.ORANGE);
        g2D.drawOval(20, 20, 20, 20);
        g2D.drawOval(40, 40, 20, 20);
        g2D.setColor(Color.YELLOW);
        g2D.drawRect(30, 30, 20, 20);
        g2D.drawRect(60, 60, 20, 20);
        g2D.setColor(Color.GREEN);
        String str = "CODE";
        g2D.drawString(str, 40, 40);
        g2D.drawString(str, 80, 80);
        g2D.setColor(Color.BLUE);
        g2D.fillArc(50, 50, 40, 20, 90, 90); //(int x1, int y1, int w, int h, int startAngle, int arcAngle)
        g2D.fillArc(90, 90, 40, 20, 90, 90);
        g2D.setColor(Color.CYAN);
        g2D.drawRect(60, 60, 20, 20);
        g2D.drawRect(100, 100, 20, 20);
        return newCanvas; //returns the new canvas with the drawings on it
    }
    public static void initFlip(Picture newPicture, Picture oldPicture, int xCordinate, int yCordinate, int picWidth, int picHeight)
    {//copys the original picture for mirroring
        Pixel oldPixel = null; //initializes variables
        Pixel newPixel = null;
        Color Color = null;
        for(int y = 0; y < picHeight; y++)
        { //keep repeating this loop for every pixel in the picture's height
            for(int x = 0; x < picWidth; x++)
            { //keep repeating this loop for every pixel in the picture's width
                oldPixel = oldPicture.getPixel(x,y); //get the x and y pixels of the original picture and store them to oldPixel
                Color = oldPixel.getColor(); //gets the RGB color values of the original picture's pixel of the respective coordinate and casts it to Color variable 'Color'
                newPixel = newPicture.getPixel(x+xCordinate,y+yCordinate); /** Gets the pixel of the new picture and adds the inputted value to both the x and y 
                                                                            location of the pixel so the new image is moved up.*/
                newPixel.setColor(Color); //makes sure the same color is set for both the old and new pixel, so the mirrored images' colors looks the same.
            }
        } //no return is needed since the original canvas is being altered.
    }
    public Picture mirrorX(Picture newPicture, Picture oldPicture, int xPos) //FlipPictureVert = x
    { //mirrors the image over the X axis if the image was said to be in quadrant II on a plane where the center is the origin and XY axises are perpenducular and begin at 0/2π
        Pixel oldPixel = null;
        Pixel newPixel = null;
        Color Color = null;
        for(int y = 0; y < oldPicture.getHeight(); y++)
        {
            xPos=100; //initializes the new x position to 100 so the mirroring is uniform
            for(int x = 100;x > 0; x--, xPos++)
            {
                oldPixel = oldPicture.getPixel(x,y); //get the x and y pixels of the original picture and store them to oldPixel
                Color = oldPixel.getColor(); //gets the (RGB) color values of the original picture's pixel of the respective coordinate and casts it to Color variable 'Color'
                newPixel = newPicture.getPixel(xPos,y); /** Gets the pixel of the new picture and adds the inputted value to only the y value of the pixel, as the x will 
                                                        be increasing by 1 for each iteration until successfully flipped. */
                newPixel.setColor(Color); //makes sure the same color is set for both the old and new pixel, so the mirrored images' colors looks the same.
            }
        }
        return newPicture; //returned the new picture with the image successfully mirrored onto it.
    }
    public Picture mirrorY(Picture newPicture, Picture oldPicture, int yPos) //flipPictureHorz = y
    {  //mirrors the image over the Y axis if the image was said to be in quadrant II on a plane where the center is the origin and XY axises are perpenducular and begin at 0/2π
        Pixel oldPixel = null;
        Pixel newPixel = null;
        Color Color = null;
        for(int y = 0; y < oldPicture.getHeight()-300; y++)
        {
            for(int x = 0;x < oldPicture.getWidth(); x++)
            {
                oldPixel = oldPicture.getPixel(x,y); //get the x and y pixels of the original picture and store them to oldPixel
                Color = oldPixel.getColor(); //gets the RGB color values of the original picture's pixel of the respective coordinate and casts it to Color variable 'Color'
                newPixel = newPicture.getPixel(x,yPos); /**gets the pixel of the new picture and adds the inputted value to only the y value of the pixel, as the x will 
                                                        be increasing by 1 for each iteration until successfully flipped. */
                newPixel.setColor(Color); //makes sure the same color is set for both the old and new pixel, so the mirrored images' colors looks the same.
            }
            yPos--; //removes one from the new y value to make sure the height does not overflow
        }
        return newPicture; //returned the new picture with the image successfully mirrored onto it.
    }
}
