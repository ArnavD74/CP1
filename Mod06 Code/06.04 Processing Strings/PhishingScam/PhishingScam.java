
/**
 * The purpose of this program is to create a template of a phishing scam letter.
 * 
 * @author Arnav Dashaputra
 * @version 12/23/2018
 */
public class PhishingScam
{
    public static void main(String[] args)
    {
        //introduction of letter
        String line0 = "RBC Bank";//Title of bank missing from screenshot, gathered from website used in expected output example
        String website = "www." + line0.substring(0,3) + line0.substring(4,8) + ".com";//uses bank's title for website in main body
        
        String line1 = "To: Mr. Bob Smith";
        String firstname = line1.substring(8, 11);//extracts first name of the recipient for the main body
        
        String line2 = "From: Mrs. Julie Macintosh";        
        String sender = line2.substring(11);//extracts full name of the sender for the closure
        
        String line3 = "Date: 08/05/08";
        String monthday = line3.substring(6, 11);//extracts just the day and month from the date for the main body

       
        //main body of letter
        String line4 = "Dear Mr. Smith,";

        String line5 = "On " + monthday + " we noticed a suspicious withdrawal of $123.45 \nfrom your checking account.";

        String line6  = "If this information is not correct, someone \nunknown to you may have access to your account!";
        String line6UpperCase = line6.toUpperCase();
        
        String line7 = "For your safety, please visit " + website + " to \nverify your personal information.";
        
        String line8 = firstname +  ", once you have done this, our fraud \ndepartment will work to resolve this discrepancy.";  

        //closure of letter
        String line9 = "Thank you,";
        
        String line10 = sender;

       //prints statement for letter to stream
        System.out.println(line0);
        System.out.println();
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println();
        System.out.println(line4);
        System.out.println();
        System.out.println(line5);
        System.out.println();
        System.out.println(line6UpperCase);
        System.out.println();
        System.out.println(line7);
        System.out.println();
        System.out.println(line8);
        System.out.println();
        System.out.println(line9);
        System.out.println(line10);

       
    }
}
