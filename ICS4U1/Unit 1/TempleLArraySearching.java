/*This is a program to show my understanding of how to implement sorting algorithms
 *
 *@Author Temple
 *@Date Mar 20 2024
 *@Version 1.0
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
public class TempleLArraySearching {
    static int[] array = new int[0];
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        InitializeArray();
        base();
    }//end of main method

    /*@Description - Sets all the elements in the array to -1 to be later randomized
     *@Parameters - array to be initialized
     *@Returns - Nothing
     */
    private static void InitializeArray() {
    	Scanner scan = new Scanner(System.in);
    	System.out.print("Welcome! How long would you like the array to be?\n>");
    	int arrayLength = 0;
    	try {
			arrayLength = scan.nextInt();
			scan.close();
		} 
    	catch (InputMismatchException e) {
			System.out.println("Invalid input. Restarting.");
			scan.close();
			InitializeArray();
		}
    	array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        Randomize(array);
    }//end of InitailizeArray method

    /*@Description - randomizes all of the elements in the array
     *@Parameters - array to be randomized
     *@Returns - Nothing
     */
    private static void Randomize(int[] array) {
        for (int i=0; i<array.length; i++) {
            array[i] = (int)(Math.random() * 100) + 1;
        }
        sortAscendingSelection(array);
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
    
    /*@Description - Searches the array with a linear searching method
     *@Parameters - Nothing
     *@Returns - Nothing
     */
    private static void linearSearch() {
    	long startTime = System.currentTimeMillis();
    	Scanner scan = new Scanner(System.in);
    	System.out.print("\n\nWelcome to linear search!\nInput the key from 1 - 100 (inclusive) to look for.\n>");
    	int key = 0;
    	try {
    		key = scan.nextInt();
    		scan.close();
    	}
    	catch (InputMismatchException e) {
    		System.out.println("That is not a vaild key. Try again.");
    		linearSearch();
    	}
    	int position = -1;
    	if (key <= 50) {
	    	for (int i = 0; array[i--] == key || i < array.length-1; i++) {
	    		if (array[i] == key) {
	    			position = i++;
	    		}
	    	}
    	}
    	else {
    		for (int i = array.length-1; array[i++] == key || i >= 0; i--) {
    			if (array[i] == key) {
    				position = i--;
    			}
    		}
    	}
    	if (position != -1) {
    		System.out.println("The number '" + key + "' was found at position " + position + "\nThe search took " + (System.currentTimeMillis() - startTime) + "ms");
    	}
    	else {
    		System.out.println("The number '" + key + "' was not found int the array." + "\nThe search took " + (System.currentTimeMillis() - startTime) + "ms");
    	}
    }
    
    /*@Description - Searches the array with a binary searching method
     *@Parameters - Array to be searched through even for the many steps
     *@Returns - Nothing
     */
    private static void binarySearch(int[] array) {
    	long startTime = System.currentTimeMillis();
    	System.out.print("\n\nWelcome to binary search!\nInput the key from 1 - 100 (inclusive) to look for.\n>");
    	int key = 0;
    	try {
    		key = scan.nextInt();
    		scan.close();
    	}
    	catch (InputMismatchException e) {
    		System.out.println("That is not a vaild key. Try again.");
    		binarySearch(array);
    	}
    	int midway = array.length/2;
    	if (array[midway] > key) {
    		int[] continuedArray = new int[array.length-midway];
    		for (int i = midway; i < array.length-1; i++) {
    			continuedArray[i] = array[i+midway];
    		}
    		binarySearch(continuedArray);
    	}
    	else if (array[midway] < key) {
    		int[] continuedArray = new int [midway];
    		for (int i = 0; i < midway; i++) {
    			continuedArray[i] = array[i];
    		}
    		binarySearch(continuedArray);
    	}
    	else {
    	//if the midway point in the array is the key then the 
    	}
    }

    /*@Description - The central hub of everything to be run
     *@Parameters - Nothing
     *@Returns - Nothing
     */
    private static void base() {
        System.out.print("\nValid Options are as follows:\n1. Reinitialize array\n2. Bubble Sort (Descending)\n3. Selection Sort (Ascending)\n4. Selection Sort (Descending)\n5. Insertion Sort (Ascending)\n6. Insertion Sort (Descending)\n7. Display Array\n8. Randomize Array\n9. Summary\n10. Exit\n\nInput Selection\n>");
        String selection = scan.nextLine();
        switch (selection) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                sortAscendingSelection(array);
                break;
            case "4":
                sortDescendingSelection(array);
                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
                Display();
                break;
            case "8":
                Randomize(array);
                break;
            case "9":
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
