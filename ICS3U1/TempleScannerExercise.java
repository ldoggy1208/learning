import java.util.Scanner;
/*
 * This is a program used for showing
 * my understanding of the Scanner function
 * in Java
 * 
 */
public class TempleScannerExercise {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the radius of circle\n>");
        int radius = scan.nextInt();
        double area = Math.PI * (2 * radius);
        System.out.print("The area of the circle is "+area);
        //end of radius circle question



        scan.close();
    }//end of main method
}//end of class
    
