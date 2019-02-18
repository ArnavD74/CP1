/**
 * Decodes a secret binary message written in the red value of the first line of pixels in an image.
 * 
 * @author Arnav Dashaputra
 * @version 1/13/19
 */
import java.awt.*;
import java.util.Arrays;
import java.lang.Math.*;
class ShowMessage
{
    public void encodeMessage(Picture stegoObject, int [] binaryArray)
    {
        Pixel pixelTarget = new Pixel(stegoObject,0,0);
        Pixel [] pixelArray = stegoObject.getPixels();
        int redValue = 0;

        for(int x = 0; x < binaryArray.length; x++)
        {
            redValue = binaryArray[x];
            pixelTarget = pixelArray[x];
            pixelTarget.setRed(redValue);
        }
        pixelTarget = pixelArray[binaryArray.length];
        pixelTarget.setRed(255);
        
        stegoObject.write("SecretMessage.bmp");
        stegoObject.explore();
        
    }
    //method to decode a binary message hidden within the top row of an image
    public int [] decodeMessage(Picture stegoObject)
    {
       int width = stegoObject.getWidth(); //To assign an initial size to bitArray
       int[] bitArray = new int[width];  //array to store the binary code for the secret message
        
       Pixel pixelTarget = new Pixel(stegoObject,0,0);
       Pixel [] pixelArray = stegoObject.getPixels(); //construct a Pixel object consisting of a 1D array of all the pixels in the Picture object
       //stegoObject.explore();
        
       Pixel [] topPixelArray = Arrays.copyOfRange(pixelArray, 0, width); //Assign the top row of pixels to a separate array. Using CopyOfRange method
      
       int red = 0;
       int lastelement = 0; //store the last element added to the bitarray

       for(int x = 0; x < width; x++)
       {   
            pixelTarget = topPixelArray[x];
            red = pixelTarget.getRed();
            if (red == 255) //since the last value after the encoded text was set to 255
            {
               break;
            }
            bitArray[x] = red;
            lastelement = x;
       }
       int [] result = new int[lastelement + 1]; // this is the Array we will return
       for(int x = 0; x < result.length; x++)
       {  
        result[x] = bitArray[x];
       }
       
       return result;
    }
    // This methond converts binary to ascii text
    public void binaryToAscii(int [] bitArray)
    {
        int descimal = 0;
        String complete = "";
        int [] splitarray = new int[8];
        
        for (int n = 0; n < bitArray.length; n+=8)
        {
            int total = 0;
            splitarray = Arrays.copyOfRange(bitArray, n, n+8);
            for (int x = 0; x < 8; x++)
            {
                int placevalue = (int) Math.pow(2,7-x);
                descimal =  splitarray[x] * placevalue;
                total = total + descimal;
            }
            String str = new Character((char)total).toString();
            complete = complete + str;
        }
        System.out.println(complete);
    }
}
public class ShowMessageTester
{ 
    public static void main(String[] args)
    {
       ShowMessage stego = new ShowMessage();
       
       //Encoder
       int[] bitArray = {0,1,0,1,0,0,0,0,0,1,1,1,0,0,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,1,1,1,0,1,1,1,0,0,1,0,0,1,1,0,0,0,0,1,0,1,1,0,1,1,0,1,0,1,1,0,1,1,0,1,0,1,1,0,1,0,0,1,0,1,1,0,1,1,1,0,0,1,1,0,0,1,1,1};
       Picture stegoObject = new Picture("earth.bmp");
       int lengthofarray = bitArray.length; 
       stego.encodeMessage(stegoObject, bitArray);

       //Decoder 
       Picture encodedObject = new Picture("SecretMessage.bmp"); //Takes the secret bmp image
       int[] result = stego.decodeMessage(encodedObject);
       
       System.out.print("Hidden Binary Values in the Image: ");
       
       for (int i=0; i<result.length; i++) 
       {
         System.out.print(result[i]);
       }
       
       // Binary to Ascii
       System.out.print("\n\nHidden Text: ");
       stego.binaryToAscii(result);
    }
}
