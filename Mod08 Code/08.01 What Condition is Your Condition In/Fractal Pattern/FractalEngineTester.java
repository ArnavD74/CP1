/**
 * This program is a shell to test the Fractal Engine class.  Complete the missing parts. 
 *
 * @author Arnav Dashaputra
 * @version 12/30/2018
 */
import java.awt.*;
class FractalEngine
{
    FractalEngine()       //default constructor for Fractal class
    {
    }
    
    //write the set up drawing method here
    public void draw(Turtle myrtle)
    {
       myrtle.hide();
       myrtle.turnLeft();
       myrtle.penDown();
       myrtle.setPenWidth(1);
       myrtle.setColor(Color.BLACK);
    }
    
    //write the drawFractal method here
    public void drawFractal(Turtle myrtle, String command, int lineLength)
    {
        if(command.equals("F"))
            myrtle.forward(lineLength);
        else if(command.equals("-"))
            myrtle.turnLeft();
        else if(command.equals("+"))
            myrtle.turnRight();        
     }
}
public class FractalEngineTester
{
    public static void main(String[] args)
    {
       //create objects for the world, the turtle, and the fractal class here
       World worldObj = new World();
       Turtle myrtle = new Turtle(200, 200, worldObj);
       FractalEngine fractal = new FractalEngine();
       
       int lineLength = 5;    //change the line length as needed
       
       String command = " ";
       
       
       //Part 1: The following series of drawing rules are supplied to help test your program.
       //only one can be uncommented at a time.
       //String rule = "F";
       //String rule = "F-F+F+F-F";
       //String rule = "F-F+F+F-F-F-F+F+F-F+F-F+F+F-F+F-F+F+F-F-F-F+F+F-F";
       //String rule = "F-F+F+F-F-F-F+F+F-F+F-F+F+F-F+F-F+F+F-F-F-F+F+F-F-F-F+F+F-F-F-F+F+F-F+F-F+F+F-F+F-F+F+F-F-F-F+F+F-F+F-F+F+F-F-F-F+F+F-F+F-F+F+F-F+F-F+F+F-F-F-F+F+F-F+F-F+F+F-F-F-F+F+F-F+F-F+F+F-F+F-F+F+F-F-F-F+F+F-F-F-F+F+F-F-F-F+F+F-F+F-F+F+F-F+F-F+F+F-F-F-F+F+F-F";
       
       //Part 2: My own fractal pattern
       //only one can be uncommented at a time.
       String rule = "F-F+F+F-F+F-F+F+F-F+F-F+F+F-F+F-F+F+F-F+F-F+F+F-F";
       
       
       for(int n = 0; n < rule.length() ; n+=1)              //traverse the length of the loop by increments of 1
       {
           command = rule.substring(n, n+1);                 //pick out the substrings of 1 digit numbers
           System.out.println(command);
           fractal.draw(myrtle);
           fractal.drawFractal(myrtle, command, lineLength);
       }//end of loop
    }
}