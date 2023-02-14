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
        System.out.print(" cm long\n The width of the rectangle is "+width);
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
        //settingg of the radius

        System.out.print("\n\nThe radius of the circle is "+radius);
        System.out.print(" cm");
        //declaring the radius
        double area2 = radius * radius * 3.14;
        double circumference = 2*3.14*radius;
        //calculating the circumference and area of the circle
        System.out.print("\nThe area of the circle is "+area2);
        System.out.print("cm^2");
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
    }//end of main method
}//end of class