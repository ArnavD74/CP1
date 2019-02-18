/**
 * Combines pictures to create a panorama, then puts a special effect filter on it.
 * 
 * @author Arnav Dashaputra
 * @version 12/31/2018
 */
import java.awt.*;                                                      //import the awt graphics package
class Panorama
//creates class for special effect filters.
{
    public Picture copyImage(int height, int width, Picture sourcePicture, Picture targetPicture, int pic1width, int a)
    {
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                Pixel sourcePixel = sourcePicture.getPixel(x,y);
                Color sourceColor = sourcePixel.getColor();
                Pixel targetPixel = targetPicture.getPixel(x + (pic1width * a) - a, y);
                targetPixel.setColor(sourceColor);
            }
        }
        return targetPicture;
    }
    public Color grayscale(int redValue, int greenValue, int blueValue)
    //creates method to set the colors to gray
    {
        Color grayColor = null;
        int averagecolor = 0;
        averagecolor = ((redValue + greenValue + blueValue) / 3);  //averaging values for pixels creates gray filter
        
        grayColor = new Color(averagecolor, averagecolor, averagecolor );//assign the color of the pixel
        
        return grayColor;
    }
}
public class PanoramaTester                                               //start of the class
{
    public static void main(String[] args)                              //start of the main method
    {       
        Picture pic1 = new Picture("Mars1.jpg");
        Picture pic2 = new Picture("Mars2.jpg");
        Picture pic3 = new Picture("Mars3.jpg");
        Picture pic4 = new Picture("Mars4.jpg");
        Picture pic5 = new Picture("Mars5.jpg");
        
        int targetWidth = pic1.getWidth() + pic2.getWidth() + pic3.getWidth() + pic4.getWidth() + pic5.getWidth();
        int targetHeight = pic1.getHeight();
        
        Panorama panorama = new Panorama();
        Picture targetPicture = new Picture(targetWidth,targetHeight);
        targetPicture.setAllPixelsToAColor(Color.BLACK);
        
        Pixel sourcePixel, targetPixel = null;
        Color sourceColor, targetColor = null;
        
        //Creates panorama and writes to drive
        int pic1height = pic1.getHeight();
        int pic1width = pic1.getWidth();
        int pic2height = pic2.getHeight();
        int pic2width = pic2.getWidth();
        int pic3height = pic3.getHeight();
        int pic3width = pic3.getWidth();
        int pic4height = pic4.getHeight();
        int pic4width = pic4.getWidth();
        int pic5height = pic5.getHeight();
        int pic5width = pic5.getWidth();

        targetPicture = panorama.copyImage(pic1height, pic1width, pic1, targetPicture, pic1width, 0); //(x + (pic1width * a ) - a, y);
        targetPicture = panorama.copyImage(pic2height, pic2width, pic2, targetPicture, pic1width, 1);
        targetPicture = panorama.copyImage(pic3height, pic3width, pic3, targetPicture, pic1width, 2);
        targetPicture = panorama.copyImage(pic4height, pic4width, pic4, targetPicture, pic1width, 3);
        targetPicture = panorama.copyImage(pic5height, pic5width, pic5, targetPicture, pic1width, 4);

        //targetPicture.show();
        targetPicture.write("UnmodifiedPano.jpg");  //writes to drive
        
        //Create grayscale filter and write to drive
        int redValue = 0; int greenValue = 0; int blueValue = 0;        //declare and initialize the variables that hold the red, green, and blue values (0-255)
        
        Color pixelColor = null;                                        //declare a Color object and set its initial value to null (or nothing)
        
        for(int y=0; y < targetPicture.getHeight(); y++)                   //outside nested loop to traverse the image from top to bottom
        {
            for(int x = 0; x < targetPicture.getWidth(); x++)              //inside nested loop to traverse the image from left to right
            {
                targetPixel = targetPicture.getPixel(x,y);                 //gets the x,y coordinate of the target pixel
                pixelColor = targetPixel.getColor();                    //gets the color of the target pixel
                
                redValue = pixelColor.getRed();                         //assign the red component (0-255) of the target pixel to the redValue variable 
                greenValue = pixelColor.getGreen();                     //assign the green component (0-255) of the target pixel to the greenValue variable
                blueValue = pixelColor.getBlue();                       //assign the blue component (0-255) of the target pixel to the blueValue variable

              targetPixel.setColor(panorama.grayscale(redValue, greenValue, blueValue));      //sets the grayscale effect on the image
            }//end of the inner for loop
        }//end of the outer for loop
        
        targetPicture.show();
        targetPicture.write("ModifiedPano.jpg");    //writes to drive
    }//end of main method
}//end of class
