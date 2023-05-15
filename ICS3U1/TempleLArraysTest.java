import java.util.Scanner;
/*This is a file to show my understanding of methods and arrays.
 * 
 * @Author Temple
 * @Date Monday May 15th 2023
 * @Version 1.0
 */
public class TempleLArraysTest {
    
    public static void main(String[] args) {
        double[] first;
        double[] second;
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the length of the first array \n>");
        int length = scan.nextInt();
        first = new double[length];
        second = new double[length];
        for (int i = 0; i < length; i++) {
            Double input;
            System.out.print("Input value (" +i +")\n>");
            input = scan.nextDouble();
            first[i] = input;
        }
        double average = getAverage(first);
        display("first array", first);
        System.out.println("\nfirst array average:\n" + average);
        for (int i = 0; i < length; i++) {
            second[i] = first[i] - average;
        }
        display("second array", second);
        for (int i = 0; i < length; i++) {
            second[i] *= second[i];
        }
        display("second array squared", second);

        double Variance = getAverage(second);
        System.out.println("Variance: "+Variance);
        double standardDeviation = Math.sqrt(Variance);
        System.out.println("Standard Deviation: " + standardDeviation);
        scan.close();
    }//end of main
    
    //parameter: array
    //returns: average
    public static double getAverage(double[] array) {
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        double average = total / array.length;
        return average;
    }//end of average

    //parameter: Array name, Array
    //returns: nothing
    public static void display(String arrayName, double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(arrayName + " value" + i + ":\n"+array[i]);
        }
    }//end of display

}//end of class
