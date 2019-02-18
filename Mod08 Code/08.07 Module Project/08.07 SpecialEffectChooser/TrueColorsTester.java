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
public class TrueColorsTester                                               //start of the class
{
    public static void main(String[] args)                              //start of the main method
    {       
        Scanner in = new Scanner(System.in);                                //creates new instance of scanner class
        String pic = null;                                            //initializes string pic
        
        System.out.println("What image would you like to select? Copy one of the below without punctuation.");//asks prompt to user
        System.out.println("Options: Taj Mahal, Pyramid of Giza, Temple of Artemis, Garden of Babylon.");//asks prompt to user
        String picInput = in.next();
        picInput += in.nextLine();
        
        if (picInput.equals("Taj Mahal"))
            pic = "TajMahal.jpg";
        else if (picInput.equals("Temple of Artemis"))
            pic = "ArtemisTemple.jpg";
        else if (picInput.equals("Pyramid of Giza"))
            pic = "Giza.jpg";
        else if (picInput.equals("Garden of Babylon"))
            pic = "BabylonGarden.jpg";
        else
        {
            System.out.println("You did not correctly input the wanted picture. Please re-try, exiting program.");
            System.exit(0);
        }
        
        System.out.println("What special effect do you want on the image you selected?");//asks prompt to user
        System.out.println("Options: Grayscale, Negative, Colorize, Palette");//asks prompt to user
        String effectInput = in.next();
        picInput += in.nextLine();
        
        Picture pictureObject = new Picture(pic);                 //creates a new Picture object representing the file in the parameter list
        int redValue = 0; int greenValue = 0; int blueValue = 0;            //declare and initialize the variables that hold the red, green, and blue values (0-255)
        Color color1 = Color.WHITE;
        Color color2 = Color.WHITE;
        Color color3 = Color.WHITE;
        Color color4 = Color.WHITE;
        Color color5 = Color.WHITE;
        Color color6 = Color.WHITE;
        Color color7 = Color.WHITE;
        Color color8 = Color.WHITE;
                          
        Pixel [] pixelArray = pictureObject.getPixels();
        Pixel targetPixel = new Pixel(pictureObject, 0,0);                //set the coordinate for the image origin
        Color pixelColor = null;                                            //declare a Color object and set its initial value to null (or nothing)          
        
        TrueColors color = new TrueColors();

        for(int x = 0; x < pixelArray.length; x++)                   //outside nested loop to traverse the image from top to bottom
        {
            targetPixel = pixelArray[x];
            pixelColor = targetPixel.getColor();                    //gets the color of the target pixel
                
            redValue = pixelColor.getRed();                         //assign the red component (0-255) of the target pixel to the redValue variable 
            greenValue = pixelColor.getGreen();                     //assign the green component (0-255) of the target pixel to the greenValue variable
            blueValue = pixelColor.getBlue();                       //assign the blue component (0-255) of the target pixel to the blueValue variable
              
            if (effectInput.equals("Grayscale"))
                targetPixel.setColor(color.grayscale(redValue, greenValue, blueValue));      //sets the grayscale effect on the image
            else if (effectInput.equals("Negative"))
                targetPixel.setColor(color.negative(redValue, greenValue, blueValue));      //sets the grayscale effect on the image
            else if (effectInput.equals("Colorize"))
                targetPixel.setColor(color.colorize(redValue, greenValue, blueValue));       //sets the colorize effect on the image
            else if (effectInput.equals("Palette"))
                {
                     
                    targetPixel = (color.colorPalette(targetPixel, redValue, greenValue, blueValue));      //sets the pallete effect on the image
                }
            else
            {
                System.out.println("You did not correctly input the wanted effect. Please re-try, exiting program.");
                System.exit(0);
            }
        }//end of the outer for loop
        
        
        
        pictureObject.show();                                              //shows the altered Picture object (not in the explore tool)
        
        System.out.println("Would you like to save the altered image to disk? Reply just Y or N for Yes or No.");//asks prompt to user
        String saveInput = in.next();
        saveInput += in.nextLine();
        
        if (saveInput.equals("Y") || saveInput.equals("y"))
        {
            pic = effectInput + "_" + pic;
            pictureObject.write(pic);
            System.out.println("File saved as: " + pic + ". Thank you for using the program. Goodbye.");//asks prompt to user
        }
        else if (saveInput.equals("N") || saveInput.equals("n"))
        {
            System.out.println("Thank you for using the program. Goodbye.");
            System.exit(0);
        }
    }//end of main method
}//end of class
