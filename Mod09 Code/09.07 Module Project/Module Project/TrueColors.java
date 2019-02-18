/**
 * Edits an existing picture with special effects.
 * 
 * @author Arnav Dashaputra
 * @version 1/3/2018
 */
import java.awt.*;                                                      //import the awt graphics package
import java.util.Scanner;
class TrueColors
//creates class for special effect filters.
{
    public Color grayscale(int redValue, int greenValue, int blueValue)
    //creates method to set the colors to gray
    {
        Color grayColor = null;
        int averagecolor = 0;
        averagecolor = ((redValue + greenValue + blueValue) / 3);  //averaging values for pixels creates gray filter
        
        grayColor = new Color(averagecolor, averagecolor, averagecolor );//assign the color of the pixel
        return grayColor;
    }
    public Color negative(int redValue, int greenValue, int blueValue)
    //creates method to make the colors opposite/negative
    {
        Color negativeColor = null;
        
        negativeColor = new Color(255 - redValue, 255 - greenValue, 255 - blueValue); //assigns the colors of the pixel while making them opposite from their initial value to create the negative effect
        return negativeColor;
    }
    public Color colorize(int redValue, int greenValue, int blueValue)
    //creates method to limit all RGB values to be below 200
    {
        Color strangeColor = null;
        
        if (redValue >= 200)  //limits all RGB values to be below 200
        {
         redValue = (redValue - 100);
        }
        if (greenValue >= 200)
        {
         greenValue = (greenValue - 100);
        }
        if (blueValue >= 200)
        {
         blueValue = (blueValue - 100);
        }
        
        strangeColor = new Color(redValue, greenValue, blueValue);//assign the color of the pixel
        return strangeColor;
    }
    public Pixel colorPalette (Pixel targetPixel, int redValue, int blueValue, int greenValue)
    //creates method to set the colors to gray
    {
        if(redValue < 10 && blueValue < 30 && greenValue < 30)
            targetPixel.setColor(Color.RED);
        if((redValue > 30 && redValue <= 60) && (blueValue > 30 && blueValue <= 60) && (greenValue > 30 && greenValue <= 60))
            targetPixel.setColor(Color.orange);    
        if((redValue > 60 && redValue <= 90) && (blueValue > 60 && blueValue <= 90) && (greenValue > 60 && greenValue <= 90))
            targetPixel.setColor(Color.yellow);
        if((redValue > 90 && redValue <= 120) && (blueValue > 90 && blueValue <= 120) && (greenValue > 90 && greenValue <= 120))
            targetPixel.setColor(Color.green);
        if((redValue > 120 && redValue <= 180) && (blueValue > 120 && blueValue <= 180) && (greenValue > 120 && greenValue <= 180))
            targetPixel.setColor(Color.cyan);
        if((redValue > 180 && redValue <= 210) && (blueValue > 180 && blueValue <= 210) && (greenValue > 180 && greenValue <= 210))
            targetPixel.setColor(Color.blue);
        if((redValue > 210 && redValue <= 240) && (blueValue > 210 && blueValue <= 240) && (greenValue > 210 && greenValue <= 240))
            targetPixel.setColor(Color.pink);
        if((redValue > 240 && redValue <= 255) && (blueValue > 240 && blueValue <= 255) && (greenValue > 240 && greenValue <= 255))
            targetPixel.setColor(Color.magenta);
        return targetPixel;
    }
}