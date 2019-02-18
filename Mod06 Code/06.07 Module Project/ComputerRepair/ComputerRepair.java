/**
 * This program asks the user to fill out the necessary inforamation to complete a shell letter.
 * 
 * @author Arnav Dashaputra
 * @version 12/23/2018
 */
import java.util.Scanner;
public class ComputerRepair
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Newegg Shell Letter for Company Employees (Thank You Message and Receipt)");
        System.out.println("We will need a lot of basic information regarding the following letter, so please answer each question in the explained manner.");
        
        //ASKING QUESTIONS
        //DATE
        System.out.println("What is the date? (In MM/DD/YYYY format, e.g. 07/28/2018)");
        String date = in.next();
        
        //SENDER INFO
        System.out.println("What is the title of the sender, or yourself? (Exclude the period, e.g. Mr, Mrs, Dr)");
        String senderTitle = in.next();
        senderTitle += in.nextLine();
        
        System.out.println("What is the first name of the sender, or yourself?");
        String senderFirstName = in.next();
        senderFirstName += in.nextLine();
        
        System.out.println("What is the last name of the sender, or yourself?");
        String senderLastName = in.next();
        senderLastName += in.nextLine();
        
        //RECIPIENT INFO
        System.out.println("What is the title of the recipient? (Exclude the period.)");
        String title = in.next();
        title += in.nextLine();
        
        System.out.println("What is the first name of the recipient?");
        String firstName = in.next();
        firstName += in.nextLine();
        
        System.out.println("What is the last name of the recipient?");
        String lastName = in.next();
        lastName += in.nextLine();
        
        //QTY AND ITEM
        System.out.println("What item was purchased? (E.g. Pro Tower, Cooling Fan, etc.)");
        String product = in.next();
        product += in.nextLine();
        
        System.out.println("What is the price of this item? (Exclude monetary symbols, such as $.)");
        double price = in.nextDouble();
        
        System.out.println("How much of this product was purchased? Please enter an integer.");
        int quantity = in.nextInt();
        
        //FULL NAMES
        String fullName = title + ". " + firstName + " " + lastName;//combines information to get full name of recipient
        String senderFullName = senderTitle + ". " + senderFirstName + " " + senderLastName;//combines information to get full name of sender
        String senderName = senderFirstName + " " + senderLastName;

        //BEGIN LETTER COMPOSITION
        String line0 = " ";
        System.out.println("==================================================================================================================================");
        String line1 = "Newegg Electronics";//Title of company
        String website = "www." + line1.substring(0,6) + ".com";//uses company name for email in letter
        
        String line2 = "To: " + fullName ;

        String line3 = "From: " + senderFullName;
        
        String line4 = "Date: " + date;
        String monthday = date.substring(0,5);//extracts just the day and month from the date for the main body

        String line5 = "Dear " + title + ". " + lastName + ",";

        String line6 = "On " + monthday + " you have purchased " + quantity + "x " + product + " from our company.";
        
        double total = (quantity * price);
        
        String line7 = "Your total today was $" + total + ".";

        String line8 = "We thank you for shopping with us! For more electronics and products, be sure to visit our website, " + website.toLowerCase();

        String line9 = "From,";
        
        String line10 = (senderName + ", Company Representative");
        
        String line11 = "P.S. If this information is not true, please reply to this e-mail immideately!";
        
        String line12 = ("The faster the issue is found, the faster it will be solved for you.");

        System.out.println(line0);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println();
        System.out.println(line5);
        System.out.println(line6);
        System.out.println();
        System.out.println(line7);
        System.out.println();
        System.out.println(line8);
        System.out.println();
        System.out.println(line9);
        System.out.println(line10);
        System.out.println();
        System.out.println(line11);
        System.out.println(line12);
        System.out.println("==================================================================================================================================");

       
    }
}
