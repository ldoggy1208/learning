import java.util.Scanner;
/*This is a program to show my understanding of the IPO concept
 * 
 * @Author Temple
 * @Date Wednesday March 15th 2023
 * @Version 1.0
 */
public class TempleIPO {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the X coordinate of point 1\n>");
        int x1 = scan.nextInt();
        System.out.print("Input the Y coordinate of point 1\n>");
        int y1 = scan.nextInt();
        System.out.print("Input the X coordinate of point 2\n>");
        int x2 = scan.nextInt();
        System.out.print("Input the Y coordinate of point 2\n>");
        int y2 = scan.nextInt();

        double slope = (y2 - y1)/(x2 - x1);
        System.out.print("The slope of your line is "+slope);

        double yintercept = y1 - (x1 * slope);
        System.out.print("\nThe Y-Intercept of your line is "+yintercept);
        scan.close();//closing the scan
    }//end of main method
}//end of class
