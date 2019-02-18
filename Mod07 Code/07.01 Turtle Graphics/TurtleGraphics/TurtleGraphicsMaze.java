/**
 * A turtle navigates through a maze, highlights its 
 * 
 * @author Arnav Dashaputra
 * @version 12/27/2018
 * 
 */
import java.awt.*;
public class TurtleGraphicsMaze
{
    public static void main(String[] args)
    {
        
        Picture pictureObj = new Picture("Maze_Background.png");    //create a Picture object for the maze background image
        World worldObj = new World();                               //create a World object to draw in
        worldObj.setPicture(pictureObj);                            //set the maze background image in the World object
            
        Turtle myrtle = new Turtle(91,139, worldObj);               //create a Turtle object starting at coordinate (19,139) in the World object
        myrtle.setHeight(12);                                       //set myrtle's height at 12 pixels
        myrtle.setWidth(12);                                        //set myrtle's width at 12 pixels
        myrtle.setHeading(90);                                      //set myrtle's heading to due East (90 degrees)
        myrtle.show();                                              //show the Turtle object
        
        
        //the rest of the code goes here
        myrtle.setColor(Color.RED);//sets Myrtle's color to red
        myrtle.penUp();
        myrtle.forward(150);   //Moves Myrtle forward
        myrtle.turnRight();   //Turns Myrtle
        myrtle.forward(50);
        myrtle.turnLeft();
        myrtle.forward(250);
        myrtle.turn(150);
        myrtle.forward(140);
        myrtle.turnRight();
        myrtle.forward(10);
        myrtle.penDown();
        myrtle.forward(30);
        myrtle.turn(232);
        myrtle.forward(65);
        myrtle.turn(-111);
        myrtle.forward(20);
        myrtle.penUp();
        myrtle.forward(20);
        myrtle.penDown();
        myrtle.forward(33);
        myrtle.turn(-120);
        myrtle.forward(27);
        myrtle.penUp();
        myrtle.turn(200);
        myrtle.forward(100);
        myrtle.penDown();
        myrtle.turn(70);
        myrtle.forward(80);
        myrtle.turn(120);
        myrtle.forward(15);
        myrtle.penUp();
        myrtle.forward(22);
        myrtle.penDown();
        myrtle.forward(15);
        myrtle.turnRight();
        myrtle.forward(20);
        myrtle.penUp();
        myrtle.forward(24);
        myrtle.penDown();
        myrtle.forward(46);
        myrtle.turn(150);
        myrtle.forward(30);
        myrtle.penUp();
        myrtle.turn(30);
        myrtle.forward(200);
        myrtle.penDown();
        

        System.out.println(worldObj);
        int a = (150 + 50 + 250 + 140 + 10 + 30 + 65 + 20 + 20 + 33 + 27 + 100 + 80 + 15 + 22 + 15 + 20 + 24 + 46 +30 + 200);   //calculates the distance Myrtle moves
        System.out.println("Myrtle moved " + a + " pixels."); //displays the distance Myrtle moves
        
    }
}
