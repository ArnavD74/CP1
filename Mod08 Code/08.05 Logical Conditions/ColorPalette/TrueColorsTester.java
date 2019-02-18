/**
 * Edits an existing picture to have a grayscale effect, then uses a custom color pallete to create a new colorizing effect.
 * 
 * @author Arnav Dashaputra
 * @version 1/1/2019
 */
import java.awt.*;                                                      //import the awt graphics package
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
    public Pixel colorPalette (Pixel targetPixel, int redValue, int blueValue, int greenValue)
    //creates method to set the colors to gray
    {
        if(redValue < 30 && blueValue < 30 && greenValue < 30)
            targetPixel.setColor(Color.RED);
        if((redValue > 30 && redValue <= 60) && (blueValue > 30 && blueValue <= 60) && (greenValue > 30 && greenValue <= 60))
            targetPixel.setColor(Color.orange);    
        if((redValue > 60 && redValue <= 90) && (blueValue > 60 && blueValue <= 90) && (greenValue > 60 && greenValue <= 90))
            targetPixel.setColor(Color.YELLOW);
        if((redValue > 90 && redValue <= 120) && (blueValue > 90 && blueValue <= 120) && (greenValue > 90 && greenValue <= 120))
            targetPixel.setColor(Color.GREEN);
        if((redValue > 120 && redValue <= 180) && (blueValue > 120 && blueValue <= 180) && (greenValue > 120 && greenValue <= 180))
            targetPixel.setColor(Color.cyan);
        if((redValue > 180 && redValue <= 210) && (blueValue > 180 && blueValue <= 210) && (greenValue > 180 && greenValue <= 210))
            targetPixel.setColor(Color.BLUE);
        if((redValue > 210 && redValue <= 240) && (blueValue > 210 && blueValue <= 240) && (greenValue > 210 && greenValue <= 240))
            targetPixel.setColor(Color.white);
        if((redValue > 240 && redValue <= 255) && (blueValue > 240 && blueValue <= 255) && (greenValue > 240 && greenValue <= 255))
            targetPixel.setColor(Color.magenta);
        return targetPixel;
    }
}
public class TrueColorsTester                                               //start of the class
{
    public static void main(String[] args)                              //start of the main method
    {       
        Picture pictureObject = new Picture("washingtonmonument.jpg");     //creates a new Picture object representing the file in the parameter list
        
        pictureObject.explore(); // Show the original image in explore tool
        
        int redValue = 0; int greenValue = 0; int blueValue = 0;        //declare and initialize the variables that hold the red, green, and blue values (0-255)
        
        Pixel [] pixelArray = pictureObject.getPixels();
        Pixel targetPixel = new Pixel(pictureObject, 0,0);              //set the coordinate for the image origin
        
        Color pixelColor = null;                                        //declare a Color object and set its initial value to null (or nothing)
        
        TrueColors color = new TrueColors();

        
        for(int x = 0; x < pixelArray.length; x++)                 //outside nested loop to traverse the image from top to bottom
        {
            targetPixel = pixelArray[x];
            
            pixelColor = targetPixel.getColor();                    //gets the color of the target pixel
            
            redValue = pixelColor.getRed();                         //assign the red component (0-255) of the target pixel to the redValue variable 
            greenValue = pixelColor.getGreen();                     //assign the green component (0-255) of the target pixel to the greenValue variable
            blueValue = pixelColor.getBlue();                       //assign the blue component (0-255) of the target pixel to the blueValue variable

            targetPixel.setColor(color.grayscale(redValue, greenValue, blueValue));      //sets the grayscale effect on the image
        }//end of the outer for loop
        
        pictureObject.write("GrayWashingtonMonument.jpg");                  //write the altered Picture object to a new file
        pictureObject.explore();                                              //shows the gray altered Picture object in explore tool
        
        Picture grayPictureObject = new Picture("GrayWashingtonMonument.jpg");
        Pixel [] grayPixelArray = grayPictureObject.getPixels();
        Pixel grayTargetPixel = new Pixel(grayPictureObject, 0,0);              //set the coordinate for the image origin
        
        Color grayPixelColor = null;                                        //declare a Color object and set its initial value to null (or nothing)

        
        for(int x = 0; x < grayPixelArray.length; x++)                 //outside nested loop to traverse the image from top to bottom
        {
            grayTargetPixel = grayPixelArray[x];
            
            grayPixelColor = grayTargetPixel.getColor();                    //gets the color of the target pixel
            
            redValue = grayPixelColor.getRed();                         //assign the red component (0-255) of the target pixel to the redValue variable 
            greenValue = grayPixelColor.getGreen();                     //assign the green component (0-255) of the target pixel to the greenValue variable
            blueValue = grayPixelColor.getBlue();                       //assign the blue component (0-255) of the target pixel to the blueValue variable

            grayTargetPixel = (color.colorPalette(grayTargetPixel, redValue, greenValue, blueValue));      //sets the pallete effect on the image
        }//end of the outer for loop
        
        grayPictureObject.explore();                                 //shows the palette altered Picture object in explore tool
        grayPictureObject.write("PaletteWashingtonMonument.jpg");  //writes a new image

    }//end of main method
}//end of class
