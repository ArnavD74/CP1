/**
* Creates a simple animation that can vary depending on the user's choices. 
* 
* @author Arnav Dashaputra
* @version 12/30/2018
*/
import java.awt.*;
import java.util.Scanner;

class AnimationV2   //implementation class
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
public void wait(int ms)
//waits for an inputted amount of time.
{
   try
   {
       Thread.sleep(ms);
   }
   catch(InterruptedException ex)
   {
       Thread.currentThread().interrupt();
   }
}
}
public class AnimationTesterV2  //tester class
{    
    public static void main(String[] args)
    {      
        //initializes objects and sets background picture
        World worldObj = new World();
        Turtle myrtle = new Turtle(0, 0, worldObj);     //starts Myrtle in the correct location for it to start moving and drawing the class
        AnimationV2 line = new AnimationV2();
        
        //initializes all input variables
        int userInput = 0; //can be any value since it will change with users choice
        int n = 0;
        int speed = 1000;  //can be any value since it will change with users choice
        int thick1 = 0;    //can be any value since it will change with users choice
        int thick2 = 0;    //can be any value since it will change with users choice
        
        //prompts user for number of time animation repeats
        Scanner in = new Scanner(System.in);
        System.out.println("How many times would you like to replay the animation? Enter an integer.");
        userInput = in.nextInt();
        
        //prompts user for speed of animation in milliseconds
        System.out.println("What speed do you want the animation to run? (In milliseconds, 1000 = 1 second.) Enter an integer.");
        speed = in.nextInt();
        
        //prompts user for the thickness of the first square
        System.out.println("What thickness do you want the first rectangle to be? Enter an integer.");
        thick1 = in.nextInt();
        
        //prompts user for the thickness of the second square
        System.out.println("What thickness do you want the second rectangle to be? Enter an integer.");
        thick2 = in.nextInt();
        
        
        //animation
        do
        {

            //Green Rectangle
            line.makeRect(myrtle, Color.GREEN, 60, 80, 240, 160, thick1);
            
            //Wait
            line.wait(speed);
            
            //White box that hides
            line.makeRect(myrtle, Color.WHITE, 0, 0, 300, 300, 600);
        
            //Pink Rectangle
            line.makeRect(myrtle, Color.PINK, 30, 20, 280, 300, thick2);
            
            //Wait
            line.wait(speed);
            
            //White box that hides
            line.makeRect(myrtle, Color.WHITE, 0, 0, 300, 300, 600);
            
            //add one to counter (per repetition)
            n++;
        }
        while (n < userInput);
        
        System.out.println(worldObj);
    }//end of main method
}
