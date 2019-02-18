    /**
     * Draws a picture using Myrtle the Turtle.
     *
     * @author Arnav Dashaputra
     * @version 12/27/2018
     */
    import java.awt.*;
    public class DrawHouse
    {
        //draw a line from x1,y1 to x2,y2 in the designated color
        public static void drawLine(Turtle myrtle, Color color, int x1, int y1, int x2, int y2, int thickness)
        {
            myrtle.hide();
            myrtle.penUp();
            myrtle.setPenColor(color);
            myrtle.setPenWidth(thickness);
            
            myrtle.moveTo(x1, y1);
            myrtle.penDown();
            myrtle.moveTo(x2, y2);  
        }
        
        //draw a line from x,y along the designated heading and color for the given length
        public static void drawLineAtAngle(Turtle myrtle, Color color, int x, int y, int length, double heading, int thickness)
        {
            myrtle.hide();
            myrtle.penUp();
            myrtle.setPenColor(color);
            myrtle.setPenWidth(thickness);
            
            myrtle.moveTo(x, y);
            myrtle.setHeading(heading);
            myrtle.penDown();
            myrtle.forward(length);
        }
        
        
        
        public static void main(String[] args)
        {      
           World worldObj = new World();
           Turtle myrtleTheTurtle = new Turtle(0, 0, worldObj); 
           //Rectangle, House body
           drawLine(myrtleTheTurtle, Color.RED, 100, 200, 370, 200, 5);      //invokes the first drawLine() method
           drawLineAtAngle(myrtleTheTurtle, Color.darkGray, 370, 200, 200, 180, 5);               //invokes the second drawLine() method
           drawLine(myrtleTheTurtle, Color.darkGray, 370, 400, 100, 400, 5);                //invokes the second drawLine() method
           drawLineAtAngle(myrtleTheTurtle, Color.darkGray, 100, 200, 200, 180, 5);   //invokes the first drawLine() method
           
           //Triangle, Roof
           drawLineAtAngle(myrtleTheTurtle, Color.RED, 100, 200, 192, 45, 5); //start x, start y, length, angle
           drawLineAtAngle(myrtleTheTurtle, Color.RED, 370, 200, 192, -45, 5);
           
           //Rectangle, Door
           drawLine(myrtleTheTurtle, Color.PINK, 200, 375, 200, 350, 50);  //start x, start y, end x, end y, thickness
           
           //Rectangle, Window
           drawLine(myrtleTheTurtle, Color.BLUE, 290, 280, 290, 280, 40);  //start x, start y, end x, end y, thickness
        
    }//end of main method
}//end of class