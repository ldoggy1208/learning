import java.util.Scanner;
/*This is a file to do a bunch of little tasks to show my understanding of methods
 *
 * @Author Temple
 * @Date April 20th 2023
 * @version 1.0
*/
public class TempleMethodsTask {
    static Scanner scan = new Scanner(System.in);
    static String result;
    static String baseText;
    static String input1;
    static String input2;
    static String input3;
    static String input4;
    public static void main(String[] args) {
        try {
            System.out.print("\nInput 1 for sum of between numbers:\nInput 2 for Distance between two points:\nInput 3 for factorial:\nInput 4 for odd number checker:\nInput 5 for ()\n>");
            int value = scan.nextInt();

            if (value == 1) {
                System.out.print("\nInput the start number\n>");
                input1 = scan.next();
                System.out.print("\nInput the End number\n>");
                input2 = scan.next();
                sumOfNumbersBetween(Integer.parseInt(input1), Integer.parseInt(input2));
            } else if (value == 2) {
                System.out.print("\nInput the x coordinate of point 1\n>");
                input1 = scan.next();
                System.out.print("\nInput the y coordinate of point 1\n>");
                input2 = scan.next();
                System.out.print("\nInput the x coordinate of point 2\n>");
                input3 = scan.next();
                System.out.print("\nInput the y coordinate of point 2\n>");
                input4 = scan.next();
                distanceBetween(input1, input2, input3, input4);
            } else if (value == 3) {
                System.out.print("\nInput the number to be factored\n>");
                input1 = scan.next();
                factorital(input1);
            } else if (value == 4) {
                System.out.print("\nInput the first number to have sum odd checked\n>");
                input1 = scan.next();
                System.out.print("\nInput the second number to have sum odd checked\n>");
                input2 = scan.next();
                oddChecker(Integer.parseInt(input1), Integer.parseInt(input2));
            } else if (value == 5) {
                System.out.print("\nInput the password key, true means correct, false means incorrect.\n>");
                input1 = scan.next();
                password(Integer.parseInt(input1));
            }

            System.out.println(baseText + result);

        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//end of main

    private static void sumOfNumbersBetween(int startValue, int endValue) {
        try {
            int count = startValue;
            int total = 0;
            while (count <= endValue) {
                total += count;
                count += 1;
            }
            result = Integer.toString(total);
            baseText = "The sum of the numbers between " + startValue + " and " + endValue + " is ";
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter integer values.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//end of numbers between

    private static void distanceBetween(String input1, String input2, String input3, String input4) {
        int x1, y1, x2, y2;
        try {
            x1 = Integer.parseInt(input1);
            y1 = Integer.parseInt(input2);
            x2 = Integer.parseInt(input3);
            y2 = Integer.parseInt(input4);
        } catch (NumberFormatException e) {
            result = "Invalid input format. Please enter integers only.";
            baseText = "";
            return;
        }

    double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    result = Double.toString(distance);
    baseText = "The distance between point ("+x1 +", "+ y1 +") and (" +x2 +", "+ y2+") is ";

    }//end of distance between

    private static void factorital(String input1) {
        try {
            int base = Integer.parseInt(input1);
            int step = base;
            int end = 1;
            if (base > 0) {        
                while (step > 0) {
                    end *= step;
                    step--;
                } 
                result = Integer.toString(end);
            }
            else if (base == 0) {
                result = Integer.toString(1);
            }
            
            baseText = base + " factorial is ";
        } catch (NumberFormatException e) {
            result = "";
            baseText = "Invalid input. Please enter an integer.";
        }
    }//end of factorial

    private static void oddChecker(int n, int i) {
        try {
            int ni = n + i;
            if (ni % 2 == 0) {
                result = "even";
            } else {
                result = "odd";
            }
            baseText = "The sum of "+n +" and "+i +" is ";
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter integers only.");
            System.exit(0);
        }
    }//end of odd checker

    private static void password(int password) {
        boolean answer = false;
        if (password == 69 || password == 420) {
            answer = true; 
        }
        result = Boolean.toString(answer);
        baseText = "";
    }
}//end of class