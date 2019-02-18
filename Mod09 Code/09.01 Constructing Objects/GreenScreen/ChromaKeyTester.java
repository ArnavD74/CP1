
/**
 * Write a description of class ChromaKey here.
 *
 * @author Arnav Dashaputra
 * @version 1/19/2019
 */
import java.awt.*;
public class ChromaKeyTester
{
    public static void main(String[] args)
    {
        Picture pictureObject = new Picture("shark.jpeg");
        Picture pictureBackground = new Picture ("rainforest.jpg");
    
        ChromaKey chroma = new ChromaKey();
    
        chroma.replaceBackground(pictureObject, pictureBackground);
    }
}
