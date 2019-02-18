/**
 * Creates Mondrian art through the movements of Myrtle the Turtle/
 * 
 * @author Arnav Dashaputra
 * @version 12/28/2018
 */
import java.awt.*;
class DrawArt   //implementation class
{
    //Sets conditions to draw a vertical line
    public void drawVertical(Turtle myrtle, Color color, int x, int y1, int y2, int thickness)
    {
        myrtle.hide();
        myrtle.penUp();
        myrtle.setPenWidth(thickness);
        myrtle.setColor(color);
        myrtle.moveTo(x, y1);
        myrtle.penDown();
        myrtle.moveTo(x, y2);
    }
    
    //Sets conditions to draw a horizontal line
    public void drawHorizontal(Turtle myrtle, Color color, int x1, int y, int x2, int thickness)
    {
        myrtle.hide();
        myrtle.penUp();
        myrtle.setPenWidth(thickness);
        myrtle.setColor(color);
        myrtle.moveTo(x1, y);
        myrtle.penDown();
        myrtle.moveTo(x2, y);
    }
}
public class DrawArtTester  //tester class
{    
    public static void main(String[] args)
    {      
        //initializes objects and sets background picture
        World worldObj = new World();
        Turtle myrtle = new Turtle(300, 100, worldObj);
        DrawArt artwork = new DrawArt();
        Picture pictureObj = new Picture("wallpaper.png");
        worldObj.setPicture(pictureObj);

        
        //creating outline box
        artwork.drawHorizontal(myrtle, Color.BLACK, 20, 20, 400, 2); //x1, y, x2, thickness
        artwork.drawVertical(myrtle, Color.BLACK, 20, 20, 400, 2); //x, y1, y2, thickness
        artwork.drawHorizontal(myrtle, Color.BLACK, 20, 400, 400, 2);
        artwork.drawVertical(myrtle, Color.BLACK, 400, 20, 400, 2);
        
        //6+ vertical lines
        artwork.drawVertical(myrtle, Color.BLACK, 272, 20, 397, 3);
        artwork.drawVertical(myrtle, Color.BLACK, 54, 23, 397, 6);
        artwork.drawVertical(myrtle, Color.BLACK, 175, 200, 400, 1);
        artwork.drawVertical(myrtle, Color.BLACK, 100, 379, 396, 8 );
        artwork.drawVertical(myrtle, Color.BLACK, 315, 60, 300, 3 );
        artwork.drawVertical(myrtle, Color.BLACK, 150, 25, 145, 10);
        artwork.drawVertical(myrtle, Color.BLACK, 32, 20, 150, 2);
        
        //5+ horizontal lines
        artwork.drawHorizontal(myrtle, Color.BLACK, 20, 60, 396, 4);
        artwork.drawHorizontal(myrtle, Color.BLACK, 20, 200, 272, 3);
        artwork.drawHorizontal(myrtle, Color.BLACK, 275, 300, 400, 5);
        artwork.drawHorizontal(myrtle, Color.BLACK, 20, 375, 400, 0);
        artwork.drawHorizontal(myrtle, Color.BLACK, 25, 150, 395, 10);
        
        //5 color fills, R/Y/B
        artwork.drawVertical(myrtle, Color.BLUE, 43, 30, 50, 20);
        artwork.drawVertical(myrtle, Color.RED, 294, 82, 125, 40);
        artwork.drawVertical(myrtle, Color.YELLOW, 358, 195, 258, 82);
        artwork.drawHorizontal(myrtle, Color.BLUE, 116, 387, 162, 25);
        artwork.drawHorizontal(myrtle, Color.RED, 80, 177, 249, 46);

        
        System.out.println(worldObj);
    }//end of main method
}//end of class