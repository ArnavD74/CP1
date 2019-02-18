/**
 * Creates audio sounds effects
 * 
 * @author Arnav Dashaputra
 * @version 1/29/19
 */
public class SoundFX
{
	//The adjustVolume method changes the volume of a source file by the xFactor parameter and writes the new audio to a file.
    public void adjustVolume(String sourceFile, double adjustFactor)
    {
        Sound sourceObj = new Sound(sourceFile);                                //Construct a new Sound object called sourceObj. A Sound object takes sourceFile as parameter to represent the source sound file.
        SoundSample[] sampleArray = sourceObj.getSamples();                     //The getSamples() method is invoked on the sourceObject to assign all of the audio sample values to the sampleArray which is of type SoundSample.
        SoundSample sampleObj = null;                                           //The SoundSample object called sampleObj is declared and initialized to null.
        int sampleValue = 0;                                                    //The sampleValue variable is declare as an int and is initialized to 0.
        for(int index = 0; index < sampleArray.length; index++)                 //A for loop is created to traverse the lenght of the sampleArray.
        {
            sampleObj = sampleArray[index];                                     //An element in the sampleArray at the index variable position is assigned to sampleObj.
            sampleValue = sampleObj.getValue();                                 //The getValue() method is invoked on the sampleObj to get the sample and assign it to the sampleValue variable.
            sampleObj.setValue((int)(sampleValue * adjustFactor));              //The setValue() method is invoked on the sampleObj. The sampleValue is multiplied by the adjustFactor variable to increase the volume.  This value is re-set to this position in the sampleObj.
        }
        sourceObj.play();                                                       //After the loop terminates, the play() method is invoked on the sourceObj and the audio is played at the higher volume.
        sourceObj.write("newVolume.wav");                                       //The write() method is invoked on the sourceObj and the audio at the higher volume is saved as a .wav file.
    }
    //The echo method creates an echo-like effect from the source file based on the delay parameter and writes the new audio to a file.
    public void echo(String sourceFile, int delay)
    {
        Sound sourceObj = new Sound(sourceFile);                                //Construct a new Sound object called sourceObj. A Sound object takes sourceFile as a parameter to represent the sound file.                               
        int sampleValue = 0;                                                    //The sampleValue variable is declare as an int and is initialized to 0.
        for(int index = delay; index < sourceObj.getLength(); index++)          //A for loop is created to traverse the length of the sourceObj.
        {
            sampleValue = (int)(sourceObj.getSampleValueAt(index-delay) * 0.6);                 //The getSampleValueAt() method is invoked on the soruceObj. The sample position is represented by the element position (delay-index) *.6 which is assigned to the sampleValue variable.
            sourceObj.setSampleValueAt(index, sourceObj.getSampleValueAt(index)+sampleValue);   //This statement sets a new sample value in sourceObj at the index position.
        }
        sourceObj.play();                                                       //After the loop terminates, the play() method is invoked on the sourceObj and the audio is played with the echo added.
        sourceObj.write("echo.wav");                                            //The write() method is invoked on the sourceObj and the audio with the echo is saved as a .wav file.
    }
    //The helium method creates a rapid, high pitched audio from a source file and writes the new audio to a file.
    public void helium(String sourceFile)
    {
        Sound sourceObj = new Sound(sourceFile);                                //Construct a new Sound object called sourceObj. A sourceObject now represents the sourceFile object.
        String targetFile = sourceFile;
        Sound target = new Sound(targetFile);                                   //Construct a new Sound object called target. The target object now represents the targetFile object.
        int sampleValue = 0;                                                    //The sampleValue variable is declare as an int and is initialized to 0.
        int targetIndex = 0;                                                    //The targetIndex variable is declared as an int and is initialized to 0.
        for(int index = 0; index < sourceObj.getLength(); index+=2)             //A for loop is created to traverse the length of the sourceObj. Notice that the loop increments by two each time, not 1.
        {
            sampleValue = sourceObj.getSampleValueAt(index);                    //The getSampleValueAt() method gets the sample value at index position of sampleObj.
            target.setSampleValueAt(targetIndex,sampleValue);                   //The setSampleValueAt() method sets the sample value at the targetIndex position in the target file.
            targetIndex++;                                                      //The targetIndex variable is incremented by 1 each time through the loop.
        }
        target.play();                                                          //The play() method is invoked on the target object to play the audio with the high pitched audio.
        target.write("helium.wav");                                            //The write() method is invoked on the target object and the audio with the new higher pitch is saved as a .wav file.
    }  
    public void mirror(String sourceFile)
    {
        Sound sourceObj = new Sound(sourceFile);                                //Construct a new Sound object called sourceObj. A sourceObject now represents the sourceFile object.
        String targetFile = sourceFile;
        Sound target = new Sound(targetFile);                                   //Construct a new Sound object called target. The target object now represents the targetFile object.
        int sampleValue = 0;                                                    //The sampleValue variable is declare as an int and is initialized to 0.
        //int targetFile = 0;
        
        int targetIndex = sourceObj.getLength() - 1;								
        for(int index = 0; index < sourceObj.getLength() ; index++) 		//Until the new variable x set to zero is less than the length of the sound, (and add one to index through each iteration)
        {
            sampleValue = sourceObj.getSampleValueAt(index);                    //The getSampleValueAt() method gets the sample value at index position of sampleObj.
            target.setSampleValueAt(targetIndex,sampleValue);                   //The setSampleValueAt() method sets the sample value at the targetIndex position in the target file.
            targetIndex--;                                                      //The targetIndex variable is incremented by 1 each time through the loop.
        }
        target.play();                                                          //The play() method is invoked on the target object to play the audio with the high pitched audio.
        target.write("Reverse.wav");                                            //The write() method is invoked on the target object and the audio with the new higher pitch is saved as a .wav file.
    }  
}
/**
 *  Note: This code has been adapted from examples in Introduction to Computing and Programming with Java: A Multimedia Approach by Mark Guzdial and Barbara Ericson
 * 
 */


