/**
 * Fetches data from web site
 * @author Arnav Dashaputra
 * @version 1/27/2018
 */
import java.net.URL;
import java.io.*;
import java.awt.*;
public class PlotData
{
    private String city = null;
    private String temp = null;
    private String line = null;
    private String aLine = null;
    private String urlStr = null;
    private int [] maxTemp = new int[31];
    private int [] minTemp = new int[31];
    PlotData(String url, String location)
    {
        city = location;
        urlStr = url;
    }
    public static void drawLine(Turtle turtle, Color color, int x1, int y1, int x2, int y2)
    {
        turtle.hide();
        turtle.penUp();
        turtle.setPenColor(color);
        turtle.setPenWidth(2);
        turtle.moveTo(x1, y1);
        turtle.penDown();
        turtle.moveTo(x2, y2);  
    }
    public String crawlWebSite()
    {
        String max = null;
        String min = null;
        int index = 0;
        try
        {
            URL url = new URL(urlStr);
            InputStream inStr = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStr));
            while((line = reader.readLine()) != null && line.indexOf(city) < 0)
            {}
            if(line != null)
            {
                for(int n = 0; n <= 11; n++)
                    temp = reader.readLine();
                temp = reader.readLine();
                while(temp.charAt(0) != '=')
                {
                    maxTemp[index] = Integer.parseInt(temp.substring(4,6));
                    minTemp[index] = Integer.parseInt(temp.substring(8,10));
                    temp = reader.readLine();
                    index++;
                }
            }
        }
        catch(FileNotFoundException ex)
        {
            SimpleOutput.showError("Could not connect to " + urlStr);
        }
        catch (Exception ex)
        {
            SimpleOutput.showError("Error during read or write");
            ex.printStackTrace();
        }
         return temp;
    }
    public static void drawGraph(Turtle turtleTheTurtle)
    {
       Picture canvas = new Picture(1200,1200);
       //Turtle turtleTheTurtle = new Turtle(0, 0, canvas);     //create a turtle object to draw with
       drawLine(turtleTheTurtle, Color.black, 300, 900, 300, 300);
       drawLine(turtleTheTurtle, Color.black, 300, 900, 900, 900);
       drawLine(turtleTheTurtle, Color.black, 900, 300, 300, 300);
       drawLine(turtleTheTurtle, Color.black, 900, 300, 900, 900);
       int x = 300;
       int y = 900;
       for(x = 300; x<=900;x+=20)
       {
           drawLine(turtleTheTurtle , Color.BLACK, x , y , x , y+20);
       }
       x = 300;
       for(y = 900; y>=300; y-=60)
       {
           drawLine(turtleTheTurtle , Color.BLACK, x , y , x-20 , y);
       }
    }
    public static void drawString(World worldObj, Color color, String str, int x1, int y1)
    {
        Graphics draw = worldObj.getGraphics();
        draw.setColor(color);
        draw.drawString(str , x1 , y1);
    }
    public int[] getMaxTemp()
    {
        return maxTemp;
    }
    public int[] getMinTemp()
    {
        return minTemp;
    }
}