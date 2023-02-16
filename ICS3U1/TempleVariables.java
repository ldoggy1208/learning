import java.util.Scanner;
/* This file is for displaying my knowledge
 * of different types of variables and how
 * to calculate simple equations
 */
public class TempleVariables {

    public static void main(String[] args) {

        int width;
        int length;

        //This is the creation of the variables
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the length of the rectangle\n>");
        length = scan.nextInt();
        System.out.print("The length of the rectangle is "+length +"cm long\n");
        System.out.print("Input the width of the rectangle\n>");
        width = scan.nextInt();
        System.out.print("\nThe width of the rectangle is "+width +"cm wide\n");
        //This is the displaying and getting of the length and width

        int area = length * width;
        int perimeter = 2 * length + 2 * width;
        //This is the calculation of the area and perimeter

        System.out.print("\nThe perimeter of the rectangle is "+perimeter);
        System.out.print(" cm \nThe area of the rectangle is "+area);
        System.out.print(" cm^2");
        //end of rectangle question

        double radius;
        //setting of the radius
        
        System.out.print("\n\nInput the radius of the circle\n>");
        radius = scan.nextInt();
        System.out.print("The radius of the circle is "+radius +"cm");
        //declaring and setting the radius
        double area2 = radius * radius * 3.14;
        double circumference = 2*3.14*radius;
        //calculating the circumference and area of the circle
        System.out.print("\nThe area of the circle is "+area2 +"cm^2");
        System.out.print("\nThe circumference of the circle is "+circumference +"cm");
        //declaring the circumference and area of a circle
        //end of circle question

        
        int tempC;
        int tempF;
        System.out.print("\n\nInput the temperature in Celsius\n>");
        tempC = scan.nextInt();
        tempF = tempC * 9 / 5 + 32;
        //setting and calculating the temperatures
        System.out.print(tempC +" degrees Celsius is equal to "+tempF +" Degrees Fahrenheit");
        //declaring the temperatures
        //end of temperature question

        double Physics = 76.7;
        double Entrepreneurship = 77.0;
        double Foods = 83.8;
        double Math = 90.4;
        double Average = 0;
        //setting the variables
        Average = (Physics + Math + Foods + Entrepreneurship)/4;
        //calculating the average
        System.out.print("\n\nLiam Temple average = "+Average);
        //declaring the average
        //end of marks question

        scan.close();
    }//end of main method
}//end of class