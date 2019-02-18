/**
 * This program retrieves information from a web site.
 * FLVS 2008
 * Assignment 09.05 - Code Evaluation 1
 * @author B. Jordan, A. Ross
 * @version 10/20/08, 08/2016
 */
import java.awt.*;
public class PlotDataTester
{
    public static void main(String[] args)
    {
        Picture canvas = new Picture(1200,1200); //creates  and initializes canvas for drawing
        World worldObj = new World();
        worldObj.setPicture(canvas); 
        Turtle turtle = new Turtle(0, 0, canvas); //creates new turtle named turtle at the origin of the new canvas
        
        String cityName = "Honolulu"; //City the temperatures will be collected from
        String urlString = "https://forecast.weather.gov/product.php?site=CRH&product=CF6&issuedby=HNL"; //weather.gov url to Honolulu
        RetrieveData findData = new RetrieveData(urlString, cityName.toUpperCase());
        PlotData graph = new PlotData(urlString, cityName.toUpperCase());
        
        int[] maximumTemp = new int[31];
        maximumTemp = findData.getMaxTemp();
        int x = 320;
        String temp = findData.crawlWebSite();
        
        if(temp == null) //if the website can not be crawled, report it is unreachable
        {
            System.out.println("Data Unreachable " + urlString);
        }
        else //if the system can be crawled and does not report null temperatues, report data was successfully fetched.
        {
            System.out.println("Data Fetched Successfully!");
        }
        for(int day = 0; day < maximumTemp.length; day++ )
        {
           System.out.println((day + 1) + "  " + maximumTemp[day] + "  " );
           if(x<=900)
           {
              graph.drawLine(turtle, Color.RED, x, 900, x, 900 - (maximumTemp[day]*6));
              x+=20;
           }
        }
        for(int x2 = 1; x2<=10; x2++)
        { //draws axis lines            
            graph.drawString(worldObj, Color.BLUE, (x2 + "0"), 255, 900 - (x2 * 60));          
        }
        for(int x3 = 0; x3<=30; x3+=5)
        { //draws axis lines               
            graph.drawString(worldObj, Color.BLUE, (String.valueOf(x3)), 297 + (x3 * 20), 940);  
        }
        graph.drawString(worldObj, Color.BLACK, ("Maximum Temperature Readings"), 475, 100); //creates graph title
        graph.drawString(worldObj, Color.BLACK, (cityName + ", HI - August 2018" ), 475, 115);  //creates graph title
        graph.drawString(worldObj, Color.BLACK, ("Temp (F)"), 190, 600);  //creates axis title
        graph.drawString(worldObj, Color.BLACK, ("Days of the Month"), 525, 970);  //creates axis title
        graph.drawGraph(turtle); //draws the graph
        canvas.show(); //shows final canvas
    }
}
