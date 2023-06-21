/*This program is a program to show my use of java throughout the semester
 * by making a mailing list. 
 * 
 * @Author Temple
 * @Date Wednesday June 21st 2023
 * @Version 1.0
 */

import java.util.Scanner;
import java.text.DecimalFormat;
public class Temple_Liam_FinalExam {
    static boolean valid = false;
    static boolean local = false;
    public static void main(String[] args) {
        String input;
        Scanner scan = new Scanner(System.in);
        System.out.print("\nInput the name of the sender of the package\n>");
        String name = scan.nextLine();
        System.out.print("\nInput the postal code for the package in the following format(L3X-1A7).\n>");
        input = scan.nextLine();
        postalChecker(input);
        if (valid == true) {
            double price = costCalculator();
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            System.out.println("The package will cost $" + decimalFormat.format(price) +" to ship.");
        }
        else {
            System.out.println("Invalid postal code.");
        }
        scan.close();
        System.out.println("Thank you "+name +" for using our postal cost calculator");
    }//end of main

    private static void postalChecker(String postalCode) {
        if (postalCode.length() == 7 && postalCode.substring(3, 4).equals("-")) {
            valid = true;
        }
        if (postalCode.substring(0, 3).equals("L3X") || postalCode.substring(0, 3).equals("L2X")) {
            local = true;
        }
    }//end of postalChecker

    private static double costCalculator() {
        double cost = 0;
        Scanner scan = new Scanner(System.in);
        if (local == true) {
            cost += 5;
            System.out.print("\nInput the weight of the package in KG\n>");
            cost += (1.5 * scan.nextDouble());
        }
        else {
            cost += 10;
            System.out.print("\nInput the weight of the package in KG\n>");
            double input = scan.nextDouble();
            if (input <= 2) {
                cost += 1.5 * input;
            }
            else if (input > 2 && input <= 4.5) {
                cost += 2.5 * input;
            }
            else {
                cost += 3* input;
            }
        }
        return cost;
    }//end of costCalculator
}//end of class