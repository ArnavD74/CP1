/**
* Implementation Class
* Mirrors an image 3 times to create a 2x2 composite panel, then again to form a 4x4 composite panel with 16 instances of the original image, drawn in the Picture method.
*
* @author Arnav Dashaputra
* @version 1/21/2019
*/
import java.awt.*;
public class ImageFlipTester
{
    public static void main(String [] args)
    {
        Picture canvas = new Picture(100, 100);        
        ImageFlip flip = new ImageFlip(canvas);
        Picture newPicture = new Picture(500, 500);
        
        canvas.show();
        
        canvas = flip.setPicture();
       
        flip.initFlip(newPicture, canvas, 0, 0, 100, 100);
        flip.mirrorX(newPicture, newPicture, 100);
        flip.mirrorY(newPicture, newPicture, 200);
        
        flip.initFlip(newPicture, newPicture, 200, 0, 200, 200);
        flip.initFlip(newPicture, newPicture, 0, 200, 200, 200);
        flip.initFlip(newPicture, newPicture, 200, 200, 200, 200);
        
        newPicture.show();
    }
}
