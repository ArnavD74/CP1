
/**
 * Write a description of class MovieTickets here.
 *
 * @author Arnav Dashaputra
 * @version 12/24/2018
 */
import java.util.Scanner; //import Scanner class
public class MovieTickets
{
    public static void main(String [ ] args)

    {
        Scanner in = new Scanner(System.in); //creates new instance of scanner class
        
        System.out.println("Good Evening.");//opening of letter
        System.out.print("What movie would you like to see? ");//asks first prompt to user
        String movie = in.next();//getting the first token of the name of the movie the user inputs
        movie += in.nextLine();//adds the remaining tokens to the first token
        
        System.out.print("Enter your debit card number (#####-###-####): ");//asks user for card number
        String debit = in.next();//creates string debit for the debit card number of the user
        
        String lastfour = debit.substring(10,14); //gathers the last 4 digits of the debit card for the receipt

        System.out.print("Enter your PIN (#####): ");//asks user for their pin
        int pin = in.nextInt();//gets pin number to integer variable pin

        System.out.print("How many tickets? ");//asks user how many tickets they want to purchase
        int tickets = in.nextInt();//get number of tickets wanted to integer variable tickets
        
        System.out.print("What is the ticket price? ");//asks user what the ticket price is
        double price = in.nextDouble();//gets the ticket price to double variable price
        
        double total = (tickets * price);//multiplies the total number of tickets by the price of each ticket 
        //to find total for e-receipt
        
        //prints e-Receipt following variables created previously to display all the correct information
        //prints closure of message
        System.out.println();
        System.out.println("Your e-Receipt");
        System.out.println("Account: ####-###-" + lastfour);
        System.out.println("Movie: " + movie);
        System.out.println("Number of Tickets: " + tickets);
        System.out.println("Ticket Price: " + price);
        System.out.println("$" + total + " will be debited to your account.");
        System.out.println("Thank you. Enjoy your movie tonight.");
        
        
    }       
            
}
