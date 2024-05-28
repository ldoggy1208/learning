/*This is a file to show my work for the first test? Idk what to put up here 
 *
 *@Author Temple
 *@Date March 27 2023
 *@Version 1.0
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class Marks {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {

		String[][] marks = { { "Michael", "12" }, { "Chris", "22" }, { "Jessica", "55" }, { "Matthew", "77" },
				{ "Ashley", "33" }, { "Jenn", "55" }, { "Joshua", "23" }, { "Amanda", "46" }, { "Daniel", "76" },
				{ "David", "87" }, { "James", "88" }, { "Robert", "86" }, { "John", "15" }, { "Joseph", "17" },
				{ "Andrew", "95" }, { "Ryan", "94" }, { "Brandon", "93" }, { "Jason", "95" }, { "Justin", "99" },
				{ "Sarah", "94" }, { "William", "94" }, { "Jon", "74" }, { "Stephan", "73" }, { "Brian", "37" },
				{ "Nicole", "77" }, { "Nick", "73" }, { "Anthony", "79" }, { "Heather", "83" }, { "Eric", "100" },
				{ "Eliza", "85" }, { "Adam", "85" }, { "Megan", "89" }, { "Melissa", "84" }, { "Kevin", "84" },
				{ "Steven", "38" }, { "Thomas", "44" }, { "Timothy", "89" }, { "Kristin", "66" }, { "Kyle", "68" },
				{ "Rachel", "69" }, { "Laura", "64" }, { "Lauren", "63" }, { "Amber", "74" }, { "Britany", "88" },
				{ "Daniel", "99" }, { "Richard", "78" }, { "Kimbrly", "49" }, { "Jeffrey", "94" }, { "Amy", "55" },
				{ "Crystal", "67" }, { "Micelle", "100" }, { "Tiffany", "79" }, { "Jeremy", "87" }, { "Benji", "98" },
				{ "Mark", "77" }, { "Emily", "89" }, { "Aaron", "97" }, { "Charles", "56" }, { "Rebecca", "66" },
				{ "Jacob", "67" }, { "Stephen", "68" }, { "Patrick", "69" }, { "Sean", "76" }, { "Erin", "45" },
				{ "Zachary", "67" }, { "Jamie", "67" }, { "Kelly", "66" }, { "Sam", "63" }, { "Nathan", "59" },
				{ "Sara", "67" }, { "Dustin", "98" }, { "Paul", "77" }, { "Angela", "75" }, { "Tyler", "68" },
				{ "Scott", "98" }, { "Kathy", "88" }, { "Andrea", "45" }, { "Gregory", "56" }, { "Erica", "67" },
				{ "Mary", "68" }, { "Travis", "45" }, { "Lisa", "68" }, { "Kenneth", "87" }, { "Bryan", "78" },
				{ "Lindsey", "88" }, { "Kristen", "76" }, { "Jose", "66" }, { "Alexa", "86" }, { "Jesse", "100" },
				{ "Katie", "97" }, { "Lindsay", "96" }, { "Shannon", "95" }, { "Vanessa", "94" }, { "Cortney", "93" },
				{ "Tina", "47" }, { "Alicia", "67" }, { "Cody", "75" }, { "Allison", "77" }, { "Bradley", "68" },
				{ "Samuel", "95" } };
		base(marks);
	}
	/*@Description - This method is the base area for all the code and methods to be called from.
	 * @Parameters - Student marks
	 * @Returns - None
	 */
	private static void base(String[][] marks) {
        System.out.print("\nValid Options are as follows:\n1. Display array\n2. How many students are passing\n3. Search for mark\n4. Exit\n>");
		String selection = scan.nextLine();
        switch (selection) {
            case "1":
				display(marks);
                break;
            case "2":
				passing(marks);
                break;
            case "3":
			System.out.print("\n\nWelcome to binary search!\nInput the key from 1 - 100 (inclusive) to look for.\n>");
			int key = 0;
			try {
				key = scan.nextInt();
				int total = 0;
				String[][] newMarks = sort(marks);
				//I'm not sure if the below search code will work or not and i'm not sure how to fix it quickly
				search(newMarks, key, total);
			}
			catch (InputMismatchException e) {
				System.out.println("That is not a vaild key. Try again.");
				base(marks);
			}
                break;
            case "4":
                System.out.println("Goodbye!");
                return;
            default:
                System.out.println("Invalid input.");
                break;
        }
        base(marks);
    }// end of base method

	/*@Description - Displays the student's names and their marks
	 * @Parameters - Student Marks
	 * @Returns - nothing
	 */
	private static void display(String[][] marks) {
        for (int col = 0; col < marks.length; col++) {
            System.out.println("Student name: " + marks[col][0] + ", Student mark: " + marks[col][1]);
        }
        return;
    }//end of display

	/*@Description - Checks to see how many students are passing
	 * @Parameters - Student Marks
	 * @Returns - nothing
	 */
	private static void passing(String[][] marks) {
		int passingStudents = 0;
		for (int i = 0; i < array.length; i++) {
			if (Integer.parseInt(marks[i][1]) <= 50) {
				passingStudents++;
			}
		}
		System.out.println("There are " + passingStudents + " passing students in this class");
	}//end of passing

	
	private static void search(String[][] marks, int key, int total) {
		int midway = array.length/2;
    	if (array[midway][1] > key) {
    		int[] continuedArray = new int[array.length-midway];
    		for (int i = midway; i < array.length-1; i++) {
    			continuedArray[i] = array[i+midway];
                total += midway;
    		}
    		search(continuedArray, key, total);
    	}
    	else if (array[midway][1] < key) {
    		int[] continuedArray = new int [midway];
    		for (int i = 0; i < midway; i++) {
    			continuedArray[i] = array[i];
    		}
    		search(continuedArray, key, total);
    	}
    	else {
            boolean first = true;
            boolean last = true;
			int firstpos = 0;
			int lastpos = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == key) {
                    if (first) {
						first = false;
						firstpost = total+i;
					}
					if (first != true && last != true) {
						if (array[i+1][1] != key) {
							lastpos = total + i;
						}
					}
                }
            }
		System.out.println("The number " + key + "was found at positions " + firstpos + " through " + lastpos);
    	//if the midway point in the array is the key then the 
    	}
	}

	/*@Description - sorts the array to search through it later
	 * @Parameters - Array to be sorted
	 * @Returns - Sorted array
	 */
	private static String[][] sort(String[][] array) {
		int i = 0;
		while (i < array.length) {
			String[] min = array[i];
			int minpos = i;
			for (int j = i+1; j < array.length; j++) {
				if (Integer.parseInt(array[j][1]) < Integer.parseInt(min[1])) {
					min = array[j];
					minpos = j;
				}
			}
			array[minpos] = array[i];
			array[i] = min;
			i++;
		}
		return(array);
	}
// a) Implement a menu driven interface for the upcoming methods
// APP 1 COM 1			
// b) Implement a method that will display content of the array in a presentable way
// APP 1 COM 1	
// c) Implement a method that will determine the amount of passing students (more than 50%)
// APP 3 COM 1
// d) Implement a method that will allow user to search for a specific mark using RECURSIVE binary search
// APP 4 COM 1

// e) Extra 2 marks if your steps "c" and "d" is working as intended without parsing
}

