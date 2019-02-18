/**
* Creates a simple animation of two boxes and requires user prompt to continue.
* 
* @author Arnav Dashaputra
* @version 12/29/2018
*/
import java.awt.*;
import java.util.Scanner;
class Animation   //implementation class
{
 public void makeRect(Turtle myrtle, Color color, int startx, int starty, int endx, int endy, int thickness)
  //draws a rectangle using Myrtle
 {
     myrtle.hide(); 
     myrtle.penUp();
     myrtle.setColor(color);
     myrtle.setPenWidth(thickness);
     myrtle.moveTo(startx, starty);
     myrtle.penDown();
     myrtle.moveTo(endx, starty);
     myrtle.moveTo(endx, endy);
     myrtle.moveTo(startx, endy);
     myrtle.moveTo(startx, starty);
 }
 public char getInput()
   //Take user input and return char
 {
    String userInput = " ";
    char key = ' ';
    Scanner in = new Scanner(System.in);
    System.out.println("Please press the (lowercase) c key to continue.");
    userInput = in.next();
    in.nextLine();
    key = userInput.charAt(0);
 
    return key;
 }
}
public class AnimationTester  //tester class
{    
    public static void main(String[] args)
    {      
        //initializes objects and sets background picture
        World worldObj = new World();
        Turtle myrtle = new Turtle(0, 0, worldObj);     //starts Myrtle in the correct location for it to start moving and drawing the class
        Animation line = new Animation();
        
        //initializes all input variables
        char key;
        
        //Wait for user input
        key = line.getInput();
        
        //animation
        do
        {
            //Red Rectangle
            line.makeRect(myrtle, Color.RED, 20, 20, 200, 200, 1);
            
            //Wait for user input
            key = line.getInput();
            
            //White box that hides
            line.makeRect(myrtle, Color.WHITE, 0, 0, 300, 300, 500);
        
            //Blue Rectangle
            line.makeRect(myrtle, Color.BLUE, 60, 80, 250, 250, 3);
            
            //Wait for user input
            key = line.getInput();

            //White box that hides
            line.makeRect(myrtle, Color.WHITE, 0, 0, 300, 300, 500);
        }
        while (key == 'c');
        
        System.out.println(worldObj);
    }//end of main method
}
