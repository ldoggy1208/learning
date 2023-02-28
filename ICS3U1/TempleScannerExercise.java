import java.util.Scanner;
/*
 * This is a program used for showing
 * my understanding of the Scanner function
 * in Java
 * 
 */
public class TempleScannerExercise {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the radius of circle\n>");
        int radius = scan.nextInt();
        double area = Math.PI * (2 * radius);
        System.out.print("The area of the circle is "+area +"\n");
        //end of radius circle question

        System.out.print("Input the ammount of cents\n>");
        int cents = scan.nextInt();
        int dollars = cents / 100;
        int remain = cents - (dollars * 100);
        System.out.print(cents +" cents is equal to "+dollars +" dollars and "+remain +" cents\n");
        //end of cents to dollars question

        System.out.print("Input the ammount of cents\n>");
        int centinp = scan.nextInt();
        int loonies = centinp / 100;
        int loonremain = centinp - (100 * loonies);
        int quarters = loonremain / 25;
        int quartremain = loonremain - (25 * quarters);
        int dimes = quartremain / 10;
        int dimeremain = quartremain - (10 * dimes);
        int nickles = dimeremain / 5;
        int pennies = dimeremain - (5 * nickles);
        System.out.print(centinp +" cents is equal to " +loonies +" dollars, " +quarters +" quarters, " +dimes +" dimes, " +nickles +" nickles, and " +pennies +" pennies.");
        //end of exact change question
        scan.close(); //closing the scan
    }//end of main method
}//end of class
    
