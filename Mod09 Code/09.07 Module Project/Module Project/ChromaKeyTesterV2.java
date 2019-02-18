/**
 * Program that lets user choose an animal to display onto a choosen background, then apply a chosen filter, and then asks if user wants to save image.
 *
 * @author Arnav Dashaputra
 * @version 1/27/2019
 */
import java.awt.*; //imports all required java classes for this project
import java.util.Scanner; //imports scanner class
public class ChromaKeyTesterV2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in); //creates new scanner
        
        System.out.println("Hello, Welcome to the Custom Chroma Key Viewer!"); //Greets user
        System.out.println("What animal would you like to place?"); //asks user for what image they want to place
        System.out.println("- Shark"); //lists option
        System.out.println("- Bunny"); //lists option
        System.out.println("- Cat"); //lists option
        System.out.println("- Chicken"); //lists option
        String picInput = in.next(); //gathers input as string named picInput
        picInput += in.nextLine(); //takes any subsequent strings
        
        String picObject = null; //initializes string named picObject for title of image
        
        if (picInput.equals("Shark")) //if the user inputs this phrase,
            picObject = "shark.jpeg"; //choose this image.
        else if (picInput.equals("Bunny")) //if the user inputs this phrase,
            picObject = "bunny.jpg"; //choose this image.
        else if (picInput.equals("Cat")) //if the user inputs this phrase,
            picObject = "cat.jpg"; //choose this image.
        else if (picInput.equals("Chicken")) //if the user inputs this phrase,
            picObject = "chicken.jpg"; //choose this image.
        else //if none of the options were chosen,
        {
            System.out.println("You did not correctly input the wanted picture. Please re-try, exiting program."); //tell the user the program will exit,
            System.exit(0); //and exit the program.
        }
            
        System.out.println("What location do you want your animal to be?"); //asks user for location image they want the original image to be
        System.out.println("- Rainforest");  //lists option
        System.out.println("- Stage");  //lists option
        System.out.println("- Ocean");  //lists option
        System.out.println("- Desert");  //lists option
        String chosenBackground = in.next(); //gathers input as string named chosenBackground
        chosenBackground += in.nextLine(); //takes any subsequent strings
        
        String picBackground = null; //initializes string named picBackground for title of image
        
        if (chosenBackground.equals("Rainforest")) //if the user inputs this phrase,
            picBackground = "rainforest.jpg"; //choose this image.
        else if (chosenBackground.equals("Stage")) //if the user inputs this phrase,
            picBackground = "stage.jpg"; //choose this image.
        else if (chosenBackground.equals("Ocean")) //if the user inputs this phrase,
            picBackground = "ocean.jpg"; //choose this image.
        else if (chosenBackground.equals("Desert")) //if the user inputs this phrase,
            picBackground = "desert.jpg"; //choose this image.
        else //if none of the options were chosen,
        {
            System.out.println("You did not correctly input the wanted picture. Please re-try, exiting program."); //tell the user the program will exit,
            System.exit(0); //and exit the program.
        }
        
        Picture pictureObject = new Picture(picObject); //initializes all new picture objects, background, and edited pictures, and calls in the other two classes.
        Picture pictureBackground = new Picture (picBackground);
        Picture pictureChroma = new Picture();
        ChromaKeyV2 chroma = new ChromaKeyV2();
        pictureChroma = chroma.replaceBackground(pictureObject, pictureBackground);
        TrueColors color = new TrueColors();
        
        System.out.println("What filter do you want on the picture?"); //asks user for the filter they want to put on the picture
        System.out.println("- Grayscale"); //lists option
        System.out.println("- Negative"); //lists option
        System.out.println("- Colorize"); //lists option
        System.out.println("- Palette"); //lists option
        System.out.println("- None"); //lists option
        String chosenFilter = in.next(); //gathers input as string named chosenBackground
        chosenFilter += in.nextLine(); //takes any subsequent strings
        
        String picFilter = null;  //initializes string named picFilter for title of image
        
        Picture pictureEdit = new Picture(pictureChroma);                 //creates a new Picture object representing the file in the parameter list
        int redValue = 0; int greenValue = 0; int blueValue = 0;            //declare and initialize the variables that hold the red, green, and blue values (0-255)
        Pixel [] pixelArray = pictureObject.getPixels();
        Pixel targetPixel = new Pixel(pictureObject, 0,0);                //set the coordinate for the image origin
        
        Color pixelColor = null;                                           //declare a Color object and set its initial value to null (or nothing)          
        
        for(int x = 0; x < pixelArray.length; x++)                   //outside nested loop to traverse the image from top to bottom
        {
            targetPixel = pixelArray[x];
            pixelColor = targetPixel.getColor();                    //gets the color of the target pixel
            redValue = pixelColor.getRed();                         //assign the red component (0-255) of the target pixel to the redValue variable 
            greenValue = pixelColor.getGreen();                     //assign the green component (0-255) of the target pixel to the greenValue variable
            blueValue = pixelColor.getBlue();                       //assign the blue component (0-255) of the target pixel to the blueValue variable
            if (chosenFilter.equals("Grayscale"))
                targetPixel.setColor(color.grayscale(redValue, greenValue, blueValue));      //sets the grayscale effect on the image
            else if (chosenFilter.equals("Negative"))
                targetPixel.setColor(color.negative(redValue, greenValue, blueValue));      //sets the grayscale effect on the image
            else if (chosenFilter.equals("Colorize"))
                targetPixel.setColor(color.colorize(redValue, greenValue, blueValue));       //sets the colorize effect on the image
            else if (chosenFilter.equals("Palette"))
                targetPixel = (color.colorPalette(targetPixel, redValue, greenValue, blueValue));      //sets the pallete effect on the image
            else if (chosenFilter.equals("None"))
                continue;   /** If the user selects no filter, continue the program by exiting the current loop. 
                                This way the for if else loop does not move onto the else statement and terminate the program. */
            else
            { //if none of the options were chosen,
                System.out.println("You did not correctly input the wanted effect. Please re-try, exiting program."); //tell the user the program will exit,
                System.exit(0); //and exit the program.
            }
        }
        
        Picture pictureSave = new Picture(); //create new picture called pictureSave
        
        if (chosenFilter.equals("None")) //as continued from the above loop, if the user selected none, change pictureEdit directly to pictureSave
            pictureSave = pictureEdit;
        else //if not and the user selected a filter, cast pictureChroma to pictureSave.
            pictureSave = pictureChroma;
        pictureSave.explore(); //explore the final image result.
            
        System.out.println("Would you like to save the altered image to disk? Reply just Y or N for Yes or No.");//asks prompt to user to save file
        String saveInput = in.next(); //gathers input as string named saveInput
        saveInput += in.nextLine(); //takes any subsequent strings
        
        String[] parts = picObject.split("\\."); /** Splits the picObject string into the text, and anything after the '.' 
                                                     so that the .jpg is not in the first segment of file name. */
        String pictureName = parts[0]; //only gathers the first part of the split, discarding the .jpg.
        if (saveInput.equals("Y") || saveInput.equals("y")) //if the user said yes to saving the file,
        {
            picObject = chosenFilter + "_" + pictureName + "_" + picBackground; //save picObject as the chosen filter, the name of the picture, and the name of the background the user chose.
            pictureSave.write(picObject); //write the final image, picObject, with the title from pictureSave described above.
            System.out.println("File saved as: " + picObject + ". Thank you for using the program. Goodbye.");  /** tells user the name of
                                                                                                   the new file, named based on their decisions, and thanks the user for using the program. */
        }
        else if (saveInput.equals("N") || saveInput.equals("n")) //if the user said no to saving the file,
        {
            System.out.println("Thank you for using the program. Goodbye."); //thank the user for using the program
            System.exit(0); //and termiate the program.
        }
    }
}