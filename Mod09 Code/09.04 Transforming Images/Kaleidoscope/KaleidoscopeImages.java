/**
 * Implementation class for image kaleidoscoper. 
 *
 * @author Arnav Dashaputra
 * @version 1/26/2019
 */
import java.awt.*;
public class KaleidoscopeImages
{
    public static void initMirror(Picture newPicture, Picture oldPicture, int xCordinate, int yCordinate, int picWidth, int picHeight)
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
    public Picture mirrorXY(Picture newPicture,Picture oldPicture, int xPos, int yPos)
    {//mirrors the image over the X and Y axis if the image was said to be in quadrant II on a plane where the center is the origin and XY axises are perpenducular and begin at 0/2π
        Pixel oldPixel, newPixel = null; //initializes variables
        Color Color, targetColor = null;
        int w = oldPicture.getWidth(); //gets width of the original picture and sets to w
        for(int y = 0; y < oldPicture.getHeight(); y++, w--,yPos--)
        {
            for(int x = 0; x < w; x++)
            {
               oldPixel = oldPicture.getPixel(x,y); //get the x and y pixels of the original picture and store them to oldPixel
               Color = oldPixel.getColor();  //gets the (RGB) color values of the original picture's pixel of the respective coordinate and casts it to Color variable 'Color'
               newPixel = newPicture.getPixel(xPos,yPos); /** Gets the pixel of the new picture and adds the inputted value to both the x and y value of the pixel, as both x and y will 
                                                        be increasing by 1 for each iteration until successfully flipped. */
               newPixel.setColor(Color);  //makes sure the same color is set for both the old and new pixel, so the mirrored images' colors looks the same.
            }
        }
        return newPicture; //returned the new picture with the image successfully mirrored onto it.
    }
    public Picture mirrorX(Picture newPicture,Picture oldPicture , int xPos)
    {//mirrors the image over the X axis if the image was said to be in quadrant II on a plane where the center is the origin and XY axises are perpenducular and begin at 0/2π
        Pixel oldPixel = null; //initializes variables
        Pixel newPixel = null;
        Color Color = null;
        for(int y = 0; y < oldPicture.getHeight(); y++)
        {
            xPos=200; //initializes the new x position to 100 so the mirroring is uniform
            for(int x = 199; x >= 0; x--, xPos++)
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
    public Picture mirrorY(Picture newPicture, Picture oldPicture, int yPos)
    { //mirrors the image over the Y axis if the image was said to be in quadrant II on a plane where the center is the origin and XY axises are perpenducular and begin at 0/2π
        Pixel oldPixel = null; //initializes variables
        Pixel newPixel = null;
        Color Color = null;
        for(int y = 199; y >= 0; yPos++)
        {
            for(int x = 0;  x < oldPicture.getWidth(); x++)
            {
               oldPixel = oldPicture.getPixel(x,y); //get the x and y pixels of the original picture and store them to oldPixel
               Color = oldPixel.getColor(); //gets the RGB color values of the original picture's pixel of the respective coordinate and casts it to Color variable 'Color'
               newPixel = newPicture.getPixel(x,yPos); /**gets the pixel of the new picture and adds the inputted value to only the y value of the pixel, as the x will 
                                                        be increasing by 1 for each iteration until successfully flipped. */
               newPixel.setColor(Color); //makes sure the same color is set for both the old and new pixel, so the mirrored images' colors looks the same.
            }
            y--; //removes one from the new y value to make sure the height does not overflow
        }
        return newPicture; //returned the new picture with the image successfully mirrored onto it.
    }
}
