/**
 * Outputs a table showing statistics of people's favorite operating system.
 * 
 * @author Arnav Dashaputra
 * @version 12/28/2018
 */
import java.awt.*;
class Survey   //implementation class
{
    public void drawBar(Turtle myrtle, int votes)
    //sets the movements needed for one unit/vote on the bar graph, were 0 would be no votes.
    {
        myrtle.forward(23 * votes);
        myrtle.turnRight();
        myrtle.forward(30);
        myrtle.turnRight();
        myrtle.forward(23 * votes);
        myrtle.penUp();
        myrtle.turnLeft();
        myrtle.forward(19);
        myrtle.penDown();
        myrtle.turnLeft();
    }
    //parses the string of digits
    public int stringInt(String stringOfDigits)
    {
        int number; 
        number = Integer.parseInt(stringOfDigits);
        return number;                                                   //return the total calculated
    }
}
public class SurveyTester  //tester class
{    
    public static void main(String[] args)
    {      
        //initializes objects and sets background picture
        World worldObj = new World();
        Turtle myrtle = new Turtle(248, 383, worldObj);     //starts Myrtle in the correct location for it to start moving and drawing the class
        myrtle.hide();
        myrtle.setColor(Color.RED);                         //sets line color (and Myrtle) to red.
        Picture pictureObj = new Picture("wallpaper.png");  //imports background of bar graph
        worldObj.setPicture(pictureObj);                    //sets background picture to imported image
        
        String data = "02080501";           //sets the total survey results for 10 people in a single string, each 2 digits corresponds to the number of votes
        Survey survey = new Survey();       //creates object survey from Survey class
        
        int number = 0;                                                //declare and initialize the total variable
        String subData = "";                                            //declare and initialize the subData variable
        
        for(int x = 0; x < data.length() ; x+=2)              //traverse the length of the loop by increments of 2
        {
            subData = data.substring(x, x+2);                 //pick out the substrings of 2 digit numbers
            number = survey.stringInt(subData);
            survey.drawBar(myrtle, number);
        }//end of loop

        System.out.println(worldObj);
    }//end of main method
}//end of class