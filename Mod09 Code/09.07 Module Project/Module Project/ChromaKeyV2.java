/**
 * Program that lets user choose an animal to display onto a choosen background, then apply a chosen filter, and then asks if user wants to save image.
 *
 * @author Arnav Dashaputra
 * @version 1/18/2019
 */
import java.awt.*;
public class ChromaKeyV2
{
  public Picture replaceBackground (Picture pictureObject, Picture pictureBackground)
  {
    Pixel backgroundPixel = null; //initializes variables for old and current pixels of the two images
    Pixel originalPixel = null;
    
    Pixel [] originalPixelArray = pictureObject.getPixels(); //casts the pixels of the images to arrays
    Pixel [] BackgroundArray = pictureBackground.getPixels();
    
    for (int x=0; x < originalPixelArray.length; x++)
    { //gets just the animal out of the rest of the image.
        backgroundPixel = BackgroundArray[x];
        originalPixel = originalPixelArray[x];
        int redValue = originalPixel.getRed(); //gets the red value of the current pixel location
        int greenValue = originalPixel.getGreen(); //gets the red value of the current pixel location
        int blueValue = originalPixel.getBlue(); //gets the red value of the current pixel location
        if ((redValue > 235 && redValue <= 255) && (blueValue > 235 && blueValue <= 255) && (greenValue > 235 && greenValue <= 255)) 
        { //gets just the animal out of the rest of the image.
            Color backgroundColor = backgroundPixel.getColor();
            originalPixel.setColor(backgroundColor);
        }
    }
    return pictureObject; //returns a pictureObject of just the animal for the tester class.
  }
}