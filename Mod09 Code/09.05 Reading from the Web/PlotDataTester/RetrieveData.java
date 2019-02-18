/**
 * This program retrieves information from a web site.
 * Assignment 09.05 - Code Evaluation 1
 * @version 10/20/08
 */
import java.net.URL;
import java.io.*;
public class RetrieveData
{
    private String city = null;
    private String temp = null;
    private String line = null;
    private String aLine = null;
    private String urlStr = null;
    private int [] maxTemp = new int[31];
    private int [] minTemp = new int[31];
    RetrieveData(String url, String loc)
    {
        city = loc;
        urlStr = url;
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
    public int[] getMaxTemp()
    {
        return maxTemp;
    }
    public int[] getMinTemp()
    {
        return minTemp;
    }
}