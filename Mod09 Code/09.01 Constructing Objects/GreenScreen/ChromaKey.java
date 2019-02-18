
/**
 * Write a description of class ChromaKeyTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
public class ChromaKey
{
  public void replaceBackground (Picture pictureObject, Picture pictureBackground)
  {
    Pixel backgroundPixel = null; // curr
    Pixel originalPixel = null; //old
    
    Pixel [] originalPixelArray = pictureObject.getPixels();
    Pixel [] BackgroundArray = pictureBackground.getPixels();
    
    
    for (int x=0; x < originalPixelArray.length; x++)
    {
        backgroundPixel = BackgroundArray[x];
        originalPixel = originalPixelArray[x];
        int redValue = originalPixel.getRed();
        int greenValue = originalPixel.getGreen();
        int blueValue = originalPixel.getBlue();
        if ((redValue > 235 && redValue <= 255) && (blueValue > 235 && blueValue <= 255) && (greenValue > 235 && greenValue <= 255)) 
        {
            Color backgroundColor = backgroundPixel.getColor();
      
            originalPixel.setColor(backgroundColor);

        }
    }
    pictureObject.explore();
  }
}