import java.util.Scanner;
import java.lang.Math;

public class TestProgramTemple{
    public static void main(String[] args) {
        final double PI = 3.1415926535897932384626;
        int radius;
        double volume;

        Scanner scan = new Scanner(System.in);
        System.out.print("Input the radius of the circle.\n>");
        radius = scan.nextInt();
        volume = (4.0/3.0) * PI * Math.pow(radius, 3);
        System.out.println("The volume of your sphere is "+String.format("%.1f", volume));
        scan.close();
    }
}