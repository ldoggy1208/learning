/* @Author Temple
 * @Date Feb 20, 2024
 * @Version 1.0
 * 
 * This is a file used to show my understanding of 2 dimensional arrays 
 */
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

import javax.swing.plaf.TreeUI;
public class TempleArray2 {
    static String[][] students = new String[6][4];
    private static final int studentNum = 0;
    private static final int firstName = 1;
    private static final int lastName = 2;
    private static final int studentMark = 3;
    static Scanner scan = new Scanner(System.in);
    static Random Random = new Random();
    public static void main(String[] args) {
        for (int i=0; i < students.length; i++) {
            randomizeStudents(i);
        }
        home();
    }//end of main method.

    /*@Description - The method is used to randomize the first name, last name, student number, and mark of the srudent slot given.
     *@parameters - student slot
     *@returns - nothing
     */
    private static void randomizeStudents(int slot) {
        String[] firstNamesList = {"Michael", "Joshua", "Josh", "Liam", "Tony", "Cameron", "Ethan", "Kieth", "David", "Susan", "Alex", "Judy", "Jane", "Anuar", "Lucas", "Tyler", "Danielle", "Shawn", "Sean", "Olivia", "Emily", "Ramona", "Scott", "Steve", "Joe"};
        String[] lastNamesList = {"Skyba", "Searle", "Morton", "Temple", "Brooks", "Simmerson", "Fuerth", "Heath", "Herdman", "Smith", "Ramos", "Riley", "Francis", "Woodhouse", "Suhr"};
        System.out.println(firstNamesList.length);
        System.out.println(lastNamesList.length);
        students[slot][firstName] = firstNamesList[Random.nextInt(firstNamesList.length)];
        students[slot][lastName] = lastNamesList[Random.nextInt(lastNamesList.length)];
        students[slot][studentMark] = (String.valueOf(Random.nextInt(101)));
        String studentNumber = "";
        if (students[slot][firstName] == "Liam"&& students[slot][lastName] == "Temple") {
            studentNumber = "340888700";
        }
        else {
            for (int i = 0; i < 9; i++) {
                studentNumber = (String.valueOf(studentNumber + Random.nextInt(10)));
            }
        }
        students[slot][studentNum] = studentNumber;
        return;
    }// end of randomizeStudents

    /*@Description - not asked for, but it was just here for some reason and I kept it. Sums the marks and displays them
     *@Perameters - nothing
     *@Returns - nothing
     */
    private static void sumMarks() {
        int sum = 0;
        for (int i = 0; i < students.length; i++) {
            sum += Integer.parseInt(students[i][studentMark]);
        }
        System.out.println("The sum of all marks is "+sum);
        return;
    }//end of sumMarks

    /*@Description - finds the lowest and the highest marks in the class and tells you what they are
     *@Parameters - Nothing
     *@Returns - Nothing
     */
    private static void minMax() {
        int min = Integer.parseInt(students[0][studentMark]);
        int max = Integer.parseInt(students[0][studentMark]);
        int minPos = 0;
        int maxPos = 0;
        for (int i = 1; i < students.length; i++) {
            if (Integer.parseInt(students[i][studentMark]) > max) {
                max = Integer.parseInt(students[i][studentMark]);
                maxPos = i;
            }
            else if (Integer.parseInt(students[i][studentMark]) < min) {
                min = Integer.parseInt(students[i][studentMark]);
                minPos = i;
            }
        }
        System.out.println("The highest student mark is " + students[maxPos][firstName] + " " + students[maxPos][lastName] + " with a mark of " + max + "\nThe lowest student mark is " + students[minPos][firstName] + " " + students[minPos][lastName] + " with a mark of " + min);       
        return;
    }//end of minMax

    /*@Description - Averages and then displays the marks of the class in a double value
     *@Parameters - Nothing
     *@Retuns - Nothing
     */
    private static void average() {
        int total = 0;
        for (int i = 0; i < students.length; i++) {
            total += Integer.parseInt(students[i][studentMark]);
        }
        double Average = total/students.length;
        System.out.println("The average student mark is " + Average);
        return;
    }//end of average

    /*@Description - Lets the user customly add students and their numbers and values to the array
     *@Parameters - Nothing
     *@Returns - Nothing
     */
    private static void customAdd() {
        int changeSlot;
        System.out.print("\n\nThere are " + students.length + " students in this class. \n Which student slot would you like to change?\n>");
        try {
            changeSlot = scan.nextInt() - 1;
        }
        catch (InputMismatchException e) {
            System.out.println("That is not a valid input unfortunately. Try again.");
            customAdd();
            return;
        }
        if (changeSlot >= students.length) {
            System.out.println("That number is not a slot in the student list. Try again.");
            customAdd();
            return;
        }
        else {
            System.out.print("\n\nInput the first name\n>");
            scan.nextLine();
            nameChanger(firstName, changeSlot);
            
            System.out.print("\n\nInput the last name\n>");
            students[changeSlot][lastName] = scan.nextLine();
            numberChanger(changeSlot);
            markChanger(changeSlot);
        }
    }//end of customAdd

    /*@Description - changes the first or last name of the student int he specific slot
     *@Parameters - Whether it's the first or last name being changed, student slot
     *@Returns - Nothing
     */
    private static void nameChanger(int fl, int slot) {
        students[slot][fl] = scan.nextLine();
        return;
    }//end of nameChanger

    /*@Description - Allows the user to create a new student number for a given slot
     *@Parameters - Student slot
     *@Returns - Nothing
     */
    private static void numberChanger(int slot) {
        System.out.print("\n\nInput the new student number. The number must be 9 numbers long.\n>");
        String newNum = scan.nextLine();
        if (newNum.length() != 9) {
            System.out.println("That student number wasn't the right length. Try again.");
        }
        else {;
            if (newNum.matches("\\d{9}")) {
                students[slot][studentNum] = newNum;
            }
            else {
                System.out.println("That is not all numbers. Try again.");
                numberChanger(slot);
                return;
            }
        }
        return;
    }//end of numberChanger

    /*@Description - Allows the user to create a mark for a student in a specific slot
     *@Parameters - Student slot
     *@Returns - nothing
     */
    private static void markChanger(int slot) {
        System.out.print("\n\nInput the new mark for the student between 0-100.\n>");
        String newMark = scan.nextLine();
        try {
            int testNum = Integer.parseInt(newMark);
        }
        catch (InputMismatchException e) {
            System.out.println("That is not a number. Try again.");
            markChanger(slot);
            return;
        }

        if (Integer.parseInt(newMark) >= 0 && Integer.parseInt(newMark) <= 100) {
            students[slot][studentMark] = newMark;
        }
        else {
            System.out.println("That number is not between 0 and 100. Try again.");
            markChanger(slot);
            return;
        }
        return;
    }//end of markChanger

    /*@Description - Allows the user to change the size of the array and then fills it with random students
     *@Parameters - Nothing
     *@Returns - Nothing
     */
    private static void studentsSizeChanger() {
        int newLength;
        System.out.print("\n\nHow long do you want the array to be?\n>");
        try {
            newLength = scan.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("That is not a valid number for the array");
            studentsSizeChanger();
            return;
        }
        if (newLength <= 0) {
            System.out.println("You can't have 0 or negative students. Try again.");
            studentsSizeChanger();
            return;
        } 
        else {
            students = new String[newLength][4];
            for (int i = 0; i < newLength; i++) {
                randomizeStudents(i);
            }
        }
        return;
    }//end of studentsSizeChanger

    /*@Description - Displays the user's array for them
     *@Parameters - Nothing
     *@Returns - Nothing
     */
    private static void display() {
        for (int col = 0; col < students.length; col++) {
            System.out.println("Student name: " + students[col][firstName] + " " + students[col][lastName] + ", Student #: " + students[col][studentNum] + ", Student mark: " + students[col][studentMark]);
        }
        return;
    }//end of display

    /*@Description - is the general home of the program where different actions can be performed
     *@Parameters - Nothing
     *@Returns - nothing.
     */
    private static void home() {
        System.out.print("\n\nWelcome to student menu config. choose an option to do. Valid options are:\n1. Sum marks\n2. Average marks\n3. Minimum and Maximum marks\n4. Display students\n5. Customize students\n6. Randomize students\n7. Increase students size (Warning. Randomizes students when done.)\n8. Close the program.\n\n>");
        String selection = scan.nextLine();
        switch (selection) {
            case "1":
                sumMarks();
                break;
            case "2":
                average();
                break;
            case "3":
                minMax();
                break;
            case "4":
                display();
                break;
            case "5":
                customAdd();
                break;
            case "6": 
                for (int i = 0; i < students.length; i++) {
                    randomizeStudents(i);
                }
                break;
            case "7":
                studentsSizeChanger();
                break;
            case "8":
                System.out.println("Goodbye!");
                scan.close();
                return;
            default:
                System.out.println("Invalid input");
                break;
        }
        home();
    }//end of home;
}//end of class