/**
 * The purpose of this program is to draw a picture with graphics methods in the OOP style.
 * 
 * @author Arnav Dashaputra
 * @version 1/19/2019
 */
import java.awt.Graphics;
import java.awt.Color;
public class DrawingDemoTesterV2
{
    public static void main(String[] args)
    {
        Picture panel1 = new Picture(500,500);
        DrawingDemoV2 house = new DrawingDemoV2(panel1, Color.WHITE);
        
        
        
        house.drawARectangle(50, 150, 250, 250, Color.BLACK); //house
        house.drawAFilledRectangle(150, 320, 40, 80, Color.RED); //door
        house.drawAString("Home Sweet Home", 120, 300, Color.MAGENTA); //text
        house.drawAFilledOval(180, 350, 10, 10, Color.BLUE); //doorknob
        house.drawALine(50, 150, 100, 50, Color.RED); //roof
        house.drawALine(100, 50, 250, 50, Color.RED); //roof
        house.drawALine(250, 50, 300, 150, Color.RED); //roof
        house.drawAFilledOval(100, 200, 30, 30, Color.YELLOW); //left window
        house.drawAFilledRectangle(200, 200, 30, 30, Color.GREEN); //window
        house.drawAnOval(150, 75, 30, 30, Color.BLACK); //attic window
        house.drawAnArc(55, 275, 250, 100, 45, 90, Color.MAGENTA); //nameplate
        
        
        for (int n = 0; n <= 7; n++)
        {
           house.drawAnArc(145 + n, 70 + n, 40, 40, 45, 90, Color.BLACK); //attic windowshade  
        }
        
        Picture picture1 = house.getPictureTile(); 
        picture1.show();

    }
}
