
/**
 * Compares two different types of cars and finds the EPA MPG. 
 *
 * @author (Arnav Dashaputra)
 * @version (12/16/2018)
 */

public class VehicleComparison
{
        public static void main (String[] args)
        {
         int monthlymiles = 2400;//sets number of miles driven per month for both cars
         double fuelprice = 2.87;//the fuel price, which stays static
         
         int mpg1 = 22;//miles per gallon (MPG) for the first car, Pacifica
         double monthlygallons1 = (monthlymiles / mpg1);//the number of gallons used per month for car 1
         double monthlycost1 = (monthlygallons1 * fuelprice);//the total cost of gas per month for car 1
         
         int mpg2 = 23;//MPG for the second car, QX60 AWD
         double monthlygallons2 = (monthlymiles / mpg2);//the number of gallons used per month for car 2
         double monthlycost2 = (monthlygallons2 * fuelprice);//the total cost of gas per month for car 2
         
         double costdifference = (monthlycost1 - monthlycost2);//the diffrence of costs of gas used per month for both cars
         
         System.out.println("                                   Fuel     Monthly     Monthly    Monthly"); //headers
         System.out.println("   Car  Model              MPG     Price     Miles      Gallons     Cost");  //headers
         System.out.println("==============================================================================="); //divider
         System.out.println("19 Chrystler Pacifica      22      2.87      2400   " + "     "   + monthlygallons1 + "     "  + monthlycost1 );//prints car 1's data
         System.out.println("19 Infiniti QX60 AWD       23      2.87      2400   " + "     "   + monthlygallons2 + "     "  + monthlycost2 );//prints car 2's data
         System.out.println (" ");//blank space
         System.out.println ("Cost Difference:  $ " + costdifference);//prints cost difference
        }
    
    
    
}

