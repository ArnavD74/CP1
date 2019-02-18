/**
 * The purpose of this assignment was to simple sound class to play a song upon request.
 * 
 * Lesson 10.03 - Assignment
 * @author Shreyank Yelagoila 
 * @version 8/6/2018
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
class FileHandler
{
    private String[] playList = new String[5];
    private String[] fileList = new String[5];
    private String file;
    
    FileHandler(String f) 
    {
        file = f;
    }
    
    public void readFile() throws IOException
    {
        int index = 0;
        File fileName = new File(file);
        Scanner inFile = new Scanner(fileName);
        while (inFile.hasNext())
        {
            playList[index] = inFile.nextLine();
            fileList[index] = inFile.nextLine();
            System.out.println(playList[index]);
            System.out.println(fileList[index]);
            index++;
        }
        inFile.close();
    }
    
    public String[] getPlayList()
    {
        return playList;
    }
    
    public String[] getFileList()
    {
        return fileList;
    }
    public static void playSong()
    {
        
        SimpleSound song1 = new SimpleSound("Force.wav");
        SimpleSound song2 = new SimpleSound("Spectre.wav");
        SimpleSound song3 = new SimpleSound("Fade.wav");
        int choice = 0;
        Scanner in = new Scanner(System.in);
        
        //System.out.println("Enter the song you want(1-3 or 0 to quit): ");
        choice = in.nextInt();
        if (choice == 1)
        {
            song1.play();
        }
        if (choice == 2)
        {
            song2.play();
        }
        if  (choice == 3)
        {
            song3.play();
        }
    }
}//end of class 

public class JukeBoxTester
{
    public static void main(String[] args) throws IOException
    {
        int choice = 0;
        FileHandler fileHandler = new FileHandler("PlayList.txt");
        String [] playList = fileHandler.getPlayList();
        String [] fileList = fileHandler.getFileList();
        fileHandler.readFile();
        
       //JukeBox myPod = new JukeBox(/*playList, fileList*/);
       
       fileHandler.playSong();
        
    }
}