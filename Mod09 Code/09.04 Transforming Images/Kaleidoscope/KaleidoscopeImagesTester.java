/**
 * Tester class for image kaleidoscoper. 
 *
 * @author Arnav Dashaputra
 * @version 1/26/2019
 */
import java.awt.*;
public class KaleidoscopeImagesTester
{
    public static void main(String[] args)
    {
        Picture canvas = new Picture(400, 400);
        Picture image = new Picture("Kaleidoscope.jpg");
        KaleidoscopeImages draw = new KaleidoscopeImages();
        
        draw.initMirror(canvas, image, 0, 0, 200, 200);
        draw.mirrorXY(canvas, image, 200, 200);
        draw.mirrorX(canvas, canvas, 200);
        draw.mirrorY(canvas, canvas, 200);
        canvas.show(); //shows original image
        
        Scaling scale = new Scaling(canvas);
        Picture scalePicture =  scale.scalePicture(.75,.75);
        scalePicture.show(); //shows scaled picture
        
        Clipping clip = new Clipping(canvas);
        Picture clipPicture = clip.clipPicture(Color.black);
        clipPicture.show(); //shows clipped final picture
    }
}
