import java.util.Scanner;
public class TempleLArraysTest {
    
    public static void main(String[] args) {
        double[] first;
        double[] second;
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the length of the first array \n>");
        int length = scan.nextInt();
        first = new double[length];
        second = new double[length];
        for (int i = 0; i < length - 1; i++) {
            Double input;
            System.out.print("Input value (" +i +")\n>");
            input = scan.nextDouble();
            first[i] = input;
        }
        double average = getAverage(first);
        display("first", first);
        System.out.println("first array average:\n" + average);
        for (int i = 0; i < length - 1; i++) {

        }
        
    }//end of main

    public static double getAverage(double[] array) {
        double total = 0;
        for (int i = 0; i < array.length - 1; i++) {
            total += array[i];
        }
        double average = total / array.length;
        return average;
    }//end of average

    public static void display(String arrayName, double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(arrayName + "array value" + i + ":\n"+array[i]);
        }
    }//end of display

}//end of class
