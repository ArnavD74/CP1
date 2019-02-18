/**
 * Edits an existing picture with special effects.
 * 
 * @author Arnav Dashaputra
 * @version 12/30/2018
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
}

public class TrueColorsTester                                               //start of the class
{
    public static void main(String[] args)                              //start of the main method
    {       
        Picture pictureObj0 = new Picture("washingtonmonument.jpg");     //creates a new Picture object representing the file in the parameter list
        Picture pictureObj = new Picture("washingtonmonument.jpg");     //creates a new Picture object representing the file in the parameter list
        Picture pictureObj1 = new Picture("washingtonmonument.jpg");     //creates a new Picture object representing the file in the parameter list
        Picture pictureObj2 = new Picture("washingtonmonument.jpg");     //creates a new Picture object representing the file in the parameter list
        int redValue = 0; int greenValue = 0; int blueValue = 0;        //declare and initialize the variables that hold the red, green, and blue values (0-255)
        
        Pixel targetPixel = new Pixel(pictureObj, 0,0);                //set the coordinate for the image origin
        Color pixelColor = null;                                        //declare a Color object and set its initial value to null (or nothing)          
        
        TrueColors color = new TrueColors();
        pictureObj0.show();                                              //show the altered Picture object (not in the explore tool)
        
        for(int y=0; y < pictureObj.getHeight(); y++)                   //outside nested loop to traverse the image from top to bottom
        {
            for(int x = 0; x < pictureObj.getWidth(); x++)              //inside nested loop to traverse the image from left to right
            {
                targetPixel = pictureObj.getPixel(x,y);                 //gets the x,y coordinate of the target pixel
                pixelColor = targetPixel.getColor();                    //gets the color of the target pixel
                
                redValue = pixelColor.getRed();                         //assign the red component (0-255) of the target pixel to the redValue variable 
                greenValue = pixelColor.getGreen();                     //assign the green component (0-255) of the target pixel to the greenValue variable
                blueValue = pixelColor.getBlue();                       //assign the blue component (0-255) of the target pixel to the blueValue variable

              targetPixel.setColor(color.grayscale(redValue, greenValue, blueValue));      //sets the grayscale effect on the image
              //targetPixel.setColor(color.negative(redValue, greenValue, blueValue));       //sets the negative effect on the image
              //targetPixel.setColor(color.colorize(redValue, greenValue, blueValue));       //sets the colorize effect on the image
            }//end of the inner for loop
        }//end of the outer for loop
        
        pictureObj.write("GrayWashingtonMonument.jpg");                  //write the altered Picture object to a new file
        pictureObj.show();                                              //show the altered Picture object (not in the explore tool)
        
        for(int y=0; y < pictureObj1.getHeight(); y++)                   //outside nested loop to traverse the image from top to bottom
        {
            for(int x = 0; x < pictureObj1.getWidth(); x++)              //inside nested loop to traverse the image from left to right
            {
                targetPixel = pictureObj1.getPixel(x,y);                 //gets the x,y coordinate of the target pixel
                pixelColor = targetPixel.getColor();                    //gets the color of the target pixel
                
                redValue = pixelColor.getRed();                         //assign the red component (0-255) of the target pixel to the redValue variable 
                greenValue = pixelColor.getGreen();                     //assign the green component (0-255) of the target pixel to the greenValue variable
                blueValue = pixelColor.getBlue();                       //assign the blue component (0-255) of the target pixel to the blueValue variable

              //targetPixel.setColor(color.grayscale(redValue, greenValue, blueValue));      //sets the grayscale effect on the image
              targetPixel.setColor(color.negative(redValue, greenValue, blueValue));       //sets the negative effect on the image
              //targetPixel.setColor(color.colorize(redValue, greenValue, blueValue));       //sets the colorize effect on the image
            }//end of the inner for loop
        }//end of the outer for loop
        
        pictureObj1.write("NegativeWashingtonMonument.jpg");                  //write the altered Picture object to a new file
        pictureObj1.show();                                              //show the altered Picture object (not in the explore tool)
        
        for(int y=0; y < pictureObj2.getHeight(); y++)                   //outside nested loop to traverse the image from top to bottom
        {
            for(int x = 0; x < pictureObj2.getWidth(); x++)              //inside nested loop to traverse the image from left to right
            {
                targetPixel = pictureObj2.getPixel(x,y);                 //gets the x,y coordinate of the target pixel
                pixelColor = targetPixel.getColor();                    //gets the color of the target pixel
                
                redValue = pixelColor.getRed();                         //assign the red component (0-255) of the target pixel to the redValue variable 
                greenValue = pixelColor.getGreen();                     //assign the green component (0-255) of the target pixel to the greenValue variable
                blueValue = pixelColor.getBlue();                       //assign the blue component (0-255) of the target pixel to the blueValue variable

              //targetPixel.setColor(color.grayscale(redValue, greenValue, blueValue));      //sets the grayscale effect on the image
              //targetPixel.setColor(color.negative(redValue, greenValue, blueValue));       //sets the negative effect on the image
              targetPixel.setColor(color.colorize(redValue, greenValue, blueValue));       //sets the colorize effect on the image
            }//end of the inner for loop
        }//end of the outer for loop
        
        pictureObj2.write("ColorizedWashingtonMonument.jpg");                  //write the altered Picture object to a new file
        pictureObj2.show();                                              //show the altered Picture object (not in the explore tool)
    }//end of main method
}//end of class
