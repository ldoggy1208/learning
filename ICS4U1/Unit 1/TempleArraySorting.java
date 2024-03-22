/*This is a program to show my understanding of how to implement sorting algorithms
 *
 *@Author Temple
 *@Date Mar 20 2024
 *@Version 1.0
 */
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class TempleArray1 {
    static int[] array = new int[1000];
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        InitializeArray(array);
        Randomize(array);
        base();
    }//end of main method

    /*@Description - Sets all the elements in the array to -1 to be later randomized
     *@Parameters - array to be initialized
     *@Returns - Nothing
     */
    private static void InitializeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
    }//end of InitailizeArray method

    /*@Description - randomizes all of the elements in the array
     *@Parameters - array to be randomized
     *@Returns - Nothing
     */
    private static void Randomize(int[] array) {
        for (int i=0; i<array.length; i++) {
            array[i] = (int)(Math.random() * 100) + 1;
        }
    }//end of randomize method

    /*@Description - Displays the array for the user to see
     *@Parameters - Nothing
     *@Returns - Nothing
     */
    private static void Display() {
        System.out.println();
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]+ " : ");
        }
    }//end of Display method

    /*@Description - Sorts the array from lowest to highest using bubble sort
     *@Parameters - array to be sorted
     *@Returns - Nothing
     */
    private static void sortAscendingBubble(int[] array) {
        int swaps = 0;
        int comparisons = 0;
        long startTime = System.currentTimeMillis();
        int i = array.length-1;
        while (2 <= i) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    int held = array[j];
                    array[j] = array[j+1];
                    array[j+1] = held;
                    swaps++;
                }
            comparisons++;
            }
            i--;
        }
        System.out.println("Ascending Bubble Sort complete.\nTime took was "+ (System.currentTimeMillis() - startTime) + "\nThere were " + swaps + " Swaps and " + comparisons + " Comparisons");
    }//end of sortAscendingBubble

    /*@Description - Sorts the array from highest to lowest using bubble sort
     *@Parameters - array to be sorted
     *@Returns - Nothing
     */
    private static void sortDescendingBubble(int[] array) {
        int comparisons = 0;
        int swaps = 0;
        long startTime = System.currentTimeMillis();
        int i = array.length-1;
        while (2 <= i) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j+1]) {
                    int held = array[j];
                    array[j] = array[j+1];
                    array[j+1] = held;
                    swaps++;
                }
                comparisons++;
            }
            i--;
        }
        System.out.println("Descending Bubble Sort complete.\nTime took was "+ (System.currentTimeMillis() - startTime) + "\nThere were " + swaps + " Swaps and " + comparisons + " Comparisons");
    }//end of sortDescendingBubble

    /*@Description - Sorts the array from lowest to highest using Selection sort
     *@Parameters - array to be sorted
     *@Returns - Nothing
     */
    private static void sortAscendingSelection(int[] array) {
    long startTime = System.currentTimeMillis();
    int comparisons = 0;
    int i = 0;
    while (i < array.length-1) {
        int min = array[i];
        int minpos = i;
        for (int j = i+1; j < array.length-1; j++) {
            if (array[j] < min) {
                min = array[j];
                minpos = j;
            }
            comparisons++;
        }
        array[minpos] = array[i];
        array[i] = min;
        i++;
    }
    System.out.println("Ascending Selection sort complete.\nTime took was "+ (System.currentTimeMillis() - startTime) + "\nThere was " + comparisons + " Comparisons" );
    }//end of sortAscendingSelection

    /*@Description - Sorts the array from highest to lowest using selection sort
     *@Parameters - array to be sorted
     *@Returns - Nothing
     */
    private static void sortDescendingSelection(int[] array) {
        int comparisons = 0;
        long startTime = System.currentTimeMillis();
        int i = 0;
        while (i < array.length-1) {
            int max = array[i];
            int maxpos = i;
            for (int j = i+1; j < array.length-1; j++) {
                if (array[j] > max) {
                    max = array[j];
                    maxpos = j;
                }
                comparisons++;
            }
            array[maxpos] = array[i];
            array[i] = max;
            i++;
        }
        System.out.println("Descending Selection sort complete.\nTime took was "+ (System.currentTimeMillis() - startTime) + "\nThere was " + comparisons + " Comparisons" );
    }//end of sortDescendingSelection

    /*@Description - Sorts the array from lowest to highest using Insertion sort
     *@Parameters - array to be sorted
     *@Returns - Nothing
     */
    private static void sortAscendingInsertion(int[] array) {
        int comparisons = 0;
        int swaps = 0;
        long startTime = System.currentTimeMillis();
        int pos = 1;
        while (pos < array.length) {
            int current = array[pos];
            int i = pos - 1;
            comparisons++;
            while (i >= 0 && array[i] > current) {
                array[i + 1] = array[i];
                i--;
                swaps++;
            }
            array[i + 1] = current;
            pos++;
        }
        System.out.println("Ascending Insertion sort complete.\nTime took was "+ (System.currentTimeMillis() - startTime)  + "\nThere were " + swaps + " Swaps and " + comparisons + " Comparisons");
    }//end of sortAscendingInsertion

    /*@Description - Sorts the array from highest to lowest using insertion sort
     *@Parameters - array to be sorted
     *@Returns - Nothing
     */
    private static void sortDescendingInsertion(int[] array) {
        int comparisons = 0;
        int swaps = 0;
        long startTime = System.currentTimeMillis();
        int pos = 1;
        while (pos < array.length) {
            int current = array[pos];
            int i = pos - 1; 
            comparisons++;   
            while (i >= 0 && array[i] < current) {
                array[i + 1] = array[i];
                i--;
                swaps++;
            }
            array[i + 1] = current;
            pos++;
    }
    System.out.println("Descending Insertion sort complete.\nTime took was "+ (System.currentTimeMillis() - startTime)  + "\nThere were " + swaps + " Swaps and " + comparisons + " Comparisons");
    }//end of sortDescendingInsertion

    /*@Description - the final boss of the sorting algorithm. tests all the algorithms with 10000 slots instead of 1000
     *@Parameters - Nothing
     *@Returns - Nothing
     */
    private static void Summary() {
        int[] newArray = new int[10000];
        InitializeArray(newArray);
        Randomize(newArray);
        sortAscendingBubble(newArray);
        Randomize(newArray);
        sortDescendingBubble(newArray);
        Randomize(newArray);
        sortAscendingSelection(newArray);
        Randomize(newArray);
        sortDescendingSelection(newArray);
        Randomize(newArray);
        sortAscendingInsertion(newArray);
        Randomize(newArray);
        sortDescendingInsertion(newArray);
    }//end of summary

    /*@Description - The central hub of everything to be run
     *@Parameters - Nothing
     *@Returns - Nothing
     */
    private static void base() {
        System.out.print("\nValid Options are as follows:\n1. Bubble Sort (Ascending)\n2. Bubble Sort (Descending)\n3. Selection Sort (Ascending)\n4. Selection Sort (Descending)\n5. Insertion Sort (Ascending)\n6. Insertion Sort (Descending)\n7. Display Array\n8. Randomize Array\n9. Summary\n10. Exit\n\nInput Selection\n>");
        String selection = scan.nextLine();
        switch (selection) {
            case "1":
                sortAscendingBubble(array);
                break;
            case "2":
                sortDescendingBubble(array);
                break;
            case "3":
                sortAscendingSelection(array);
                break;
            case "4":
                sortDescendingSelection(array);
                break;
            case "5":
                sortAscendingInsertion(array);
                break;
            case "6":
                sortDescendingInsertion(array);
                break;
            case "7":
                Display();
                break;
            case "8":
                Randomize(array);
                break;
            case "9":
                Summary();
                break;
            case "10":
                System.out.println("Goodbye!");
                return;
            default:
                System.out.println("Invalid input.");
                break;
        }
        base();
    }// end of base method
}//end of class
