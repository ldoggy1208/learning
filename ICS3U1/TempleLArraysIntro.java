/* This is a program to show my understanding of arrays
 * 
 * @Author Temple
 * @Date April 25th 2023
 * @Version 1.0
 */
public class TempleLArraysIntro {
    
    public static void main(String[] args) {
        String romanNumerals[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int fibonacci[] = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        String rainbowColours[] = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Purple"};
        String countingWords[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        String headandShouldersWords[] = {"Head", "Shoulders", "Knees", "Toes", "Eyes", "Ears", "Mouth", "Nose"};
        String periodStartTimes[] = {"8:05", "9:25", "10:45", "12:05", "1:25"};
        int squares[] = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
        char alphabetStart[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        
        stringArrayPrint(romanNumerals);
        System.out.println("\n");
        intArrayPrint(fibonacci);
        System.out.println("\n");
        stringArrayPrint(rainbowColours);
        System.out.println("\n");
        stringArrayPrint(countingWords);
        System.out.println("\n");
        stringArrayPrint(headandShouldersWords);
        System.out.println("\n");
        stringArrayPrint(periodStartTimes);
        System.out.println("\n");
        intArrayPrint(squares);
        System.out.println("\n");
        charArrayPrint(alphabetStart);
    }//end of main

    private static void stringArrayPrint(String[] array) {
        for (int i = 0; i < array.length; i++ ) {
            System.out.println(array[i]);
        }
    }//end of stringArrayPrint

    private static void intArrayPrint(int[] array) {
        for (int i = 0; i < array.length; i++ ) {
            System.out.println(array[i]);
        }
    }//end of stringArrayPrint

    private static void charArrayPrint(char[] array) {
        for (int i = 0; i < array.length; i++ ) {
            System.out.println(array[i]);
        }
    }//end of charArrayPrint

}//end of class