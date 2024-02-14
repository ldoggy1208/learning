/*This is a program to show my understanding of how 1D arrays work in java
 *
 *@Author Temple
 *@Date Feb 12 2024
 *@Version 1.0
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
public class TempleArray1 {
    static int[] array = new int[10];
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        InitializeArray();
        base();
        //initailize the array and start the menu for selecting options
    }//end of main method

    private static void InitializeArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }//sets each of the 10 positions in the array to -1
        System.out.println("Array Initialized.");
    }//end of InitailizeArray method

    private static void EnterFromKeyboard() {
        for (int i = 0; i < array.length; i++) {
            System.out.print("\nInput a number to put in the array!\n>");
            try {
                int UserInput = scan.nextInt();
                array[i] = UserInput;  
            } //tries to input the inputted number
            catch (InputMismatchException e) {
                System.out.println("That's not a valid number, sorry.");
                InitializeArray();
                return;
            }//if the number isn't valid, restarts this method. Innefective but possible.
        
        }
        System.out.println("Array Entered");
        return;
    }//end of EnterFromKeyboard Method

    private static void Randomize() {
        for (int i=0; i<array.length; i++) {
            array[i] = (int)(Math.random() * 99) + 1;
            System.out.println("Array Randomized");
        }//sets each position in the array to a number between 1 and 100
    }//end of randomize method

    private static void Display() {
        System.out.println();
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]+ " : ");
        }//shows all the choices in the array
    }//end of Display method

    private static void Sum() {
        int sum = 0;
        for (int i=0; i<array.length; i++) {
            sum += array[i];
        }//adds together all the numbers in the array and prints them.
        System.out.println(sum+" is the sum of the array");
    }//end of Sum method

    private static void Average() {
        int total = 0;
        for (int i=0; i<array.length; i++) {
            total += array[i];
        }//adds together all of the numbers in the array and divides them by 10 
        System.out.println(total/10+" Is the average of the array");
    }//end of Average method

    private static void Search() {
        System.out.print("\nInput the number you are looking for\n>");
        String num = scan.nextLine();
        boolean found = false;
        for (int i = 0; i<array.length; i++) {
            if (String.valueOf(array[i]).equals(num)) {
            found = true;
            }//checks to see if the number you want to look for is in the array at all
        }
        if (found == false) {
            System.out.println("The number you were searching for was not found in the array.");
        }//if the number you are looking for is invalid or not in the array this will print.
        else {
            System.out.print("\nThe number "+ num +" is located at positions: ");
            for (int i = 0; i < array.length; i++) {
                if (String.valueOf(array[i]).equals(num)) {
                    System.out.print(i + ", ");
                }//prints the positions of all the number looked for in the array
            }
        }
    }//end of Search Method
    private static void base() {
        System.out.print("\nValid Options are as follows:\n1. Initialize array\n2. Enter Numbers From Keyboard\n3. Randomize Array\n4. Display Array\n5. Sum Array\n6. Average Array\n7. Search in Array\n8. Exit\n\nInput Selection\n>");
        String selection = scan.nextLine();
        switch (selection) {
            case "1":
                InitializeArray();
                break;
            case "2":
                EnterFromKeyboard();
                break;
            case "3":
                Randomize();
                break;
            case "4":
                Display();
                break;
            case "5":
                Sum();
                break;
            case "6":
                Average();
                break;
            case "7":
                Search();
                break;
            case "8":
                System.out.println("Goodbye!");
                return;
            default:
                System.out.println("Invalid input.");
                break;
        }//givevs the options and makes you choose one to print and brings you to that method
        base();
    }// end of base method
}//end of class
