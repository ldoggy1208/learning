import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

/**
 * This is a program to show my understanding of how to implement sorting algorithms.
 *
 * @Author Temple
 * @Date Mar 20 2024
 * @Version 1.0
 */
public class TempleLArraySearching {
    static int[] array = new int[0];
    static Scanner scan = new Scanner(System.in);
    static int total = 0;

    public static void main(String[] args) {
        InitializeArray();
        base();
    } // end of main method

    /**
     * Sets all the elements in the array to -1 to be later randomized.
     *
     * @Parameters - array to be initialized
     * @Returns - Nothing
     */
    private static void InitializeArray() {
        System.out.print("Welcome! How long would you like the array to be?\n>");
        int arrayLength = 0;
        try {
            arrayLength = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Restarting.");
            scan.next(); // Clear the invalid input
            InitializeArray();
            return; // Exit the method to avoid further execution
        }
        array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        Randomize(array);
    } // end of InitializeArray method

    /**
     * Randomizes all of the elements in the array.
     *
     * @Parameters - array to be randomized
     * @Returns - Nothing
     */
    private static void Randomize(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) + 1;
        }
        sortAscendingSelection(array);
    } // end of Randomize method

    /**
     * Displays the array for the user to see.
     *
     * @Parameters - Nothing
     * @Returns - Nothing
     */
    private static void Display() {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " : ");
        }
        System.out.println();
    } // end of Display method

    /**
     * Sorts the array from lowest to highest using Selection sort.
     *
     * @Parameters - array to be sorted
     * @Returns - Nothing
     */
    private static void sortAscendingSelection(int[] array) {
        long startTime = System.currentTimeMillis();
        int comparisons = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minpos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minpos]) {
                    minpos = j;
                }
                comparisons++;
            }
            int temp = array[minpos];
            array[minpos] = array[i];
            array[i] = temp;
        }
        System.out.println("Ascending Selection sort complete.\nTime took was " +
                (System.currentTimeMillis() - startTime) + "ms\nThere were " + comparisons + " comparisons.");
    } // end of sortAscendingSelection method

    /**
     * Sorts the array from highest to lowest using selection sort.
     *
     * @Parameters - array to be sorted
     * @Returns - Nothing
     */
    private static void sortDescendingSelection(int[] array) {
        int comparisons = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1; i++) {
            int maxpos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxpos]) {
                    maxpos = j;
                }
                comparisons++;
            }
            int temp = array[maxpos];
            array[maxpos] = array[i];
            array[i] = temp;
        }
        System.out.println("Descending Selection sort complete.\nTime took was " +
                (System.currentTimeMillis() - startTime) + "ms\nThere were " + comparisons + " comparisons.");
    } // end of sortDescendingSelection method

    /**
     * Searches the array with a linear searching method.
     *
     * @Parameters - Nothing
     * @Returns - Nothing
     */
    private static void linearSearch() {
        long startTime = System.currentTimeMillis();
        System.out.print("\n\nWelcome to linear search!\nInput the key from 1 - 100 (inclusive) to look for.\n>");
        int key = 0;
        try {
            key = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("That is not a valid key. Try again.");
            scan.next(); // Clear the invalid input
            linearSearch();
            return; // Exit the method to avoid further execution
        }
        int position = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            System.out.println("The number '" + key + "' was found at position " + position +
                    "\nThe search took " + (System.currentTimeMillis() - startTime) + "ms");
        } else {
            System.out.println("The number '" + key + "' was not found in the array." +
                    "\nThe search took " + (System.currentTimeMillis() - startTime) + "ms");
        }
    } // end of linearSearch method

    /**
     * Searches the array with a binary searching method.
     *
     * @Parameters - Array to be searched through even for the many steps, key to be searched for
     * @Returns - Nothing
     */
    private static void binarySearch(int[] array, int key) {
        // Sort the array before performing binary search
        sortAscendingSelection(array);
        total = 0; // Reset total before each search
        binarySearchHelper(array, key, 0, array.length - 1);
    }

    private static void binarySearchHelper(int[] array, int key, int low, int high) {
        if (low > high) {
            System.out.println("Key not found in the array.");
            return;
        }
        int mid = (low + high) / 2;
        if (array[mid] < key) {
            binarySearchHelper(array, key, mid + 1, high);
        } else if (array[mid] > key) {
            binarySearchHelper(array, key, low, mid - 1);
        } else {
            System.out.println("Key found at index: " + mid);
        }
    }

    /**
     * The central hub of everything to be run.
     *
     * @Parameters - Nothing
     * @Returns - Nothing
     */
    private static void base() {
        System.out.print("\nValid Options are as follows:\n1. Reinitialize array\n2. Selection Sort (Ascending)\n3. Selection Sort (Descending)\n4. Display Array\n5. Randomize Array\n6. Linear Search\n7. Binary Search\n8. Exit\n\nInput Selection\n>");
        String selection = scan.next();
        switch (selection) {
            case "1":
                InitializeArray();
                break;
            case "2":
                sortAscendingSelection(array);
                break;
            case "3":
                sortDescendingSelection(array);
                break;
            case "4":
                Display();
                break;
            case "5":
                Randomize(array);
                break;
            case "6":
                linearSearch();
                break;
            case "7":
                System.out.print("\n\nWelcome to binary search!\nInput the key from 1 - 100 (inclusive) to look for.\n>");
                int key = scan.nextInt();
                binarySearch(array, key);
                break;
            case "8":
                System.out.println("Goodbye!");
                return;
            default:
                System.out.println("Invalid input.");
                break;
        }
        base();
    } // end of base method    
} // end of class