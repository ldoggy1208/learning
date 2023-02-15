/* This file is for displaying my knowledge
 * of different types of variables and how
 * to calculate simple equations
 */
public class TempleVariables {

    public static void main(String[] args) {

        int width = 10;
        int length = 20;

        //This is the creation of the variables

        System.out.print("The length of the rectangle is "+length);
        System.out.print(" cm long\nThe width of the rectangle is "+width);
        System.out.print(" cm wide");
        //This is the displaying of the length and width

        int area = length * width;
        int perimeter = 2 * length + 2 * width;
        //This is the calculation of the area and perimeter

        System.out.print("\nThe perimeter of the rectangle is "+perimeter);
        System.out.print(" cm \nThe area of the rectangle is "+area);
        System.out.print(" cm^2");
        //end of rectangle question

        double radius = 14;
        final double pi = 31.141592653589793238464;
        //setting of the radius and pi

        System.out.print("\n\nThe radius of the circle is "+radius);
        System.out.print(" cm");
        //declaring the radius
        double area2 = (radius * radius) * pi;
        double circumference = 2*pi*radius;
        //calculating the circumference and area of the circle
        System.out.print("\nThe area of the circle is "+area2);
        System.out.print(" cm^2");
        System.out.print("\nThe circumference of the circle is "+circumference);
        System.out.print(" cm");
        //declaring the circumference and area of a circle
        //end of circle question

        
        int tempC = 100;
        int tempF = 0;

        tempF = tempC * 9 / 5 + 32;
        //setting and calculating the temperatures
        System.out.print("\n\n100 degrees celsius is equal to "+tempF);
        System.out.print(" degrees fahrenheit");
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

        System.out.print("\n\nThe average of all my marks was "+Average);
        //declaring the average
        //end of marks question
    }//end of main method
}//end of class