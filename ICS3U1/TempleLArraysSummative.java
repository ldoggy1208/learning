import java.util.Random;
public class TempleLArraysSummative {
    static double average;
    public static void main(String[] args) {
        int[] list1 = new int [20];
        int[] list2 = new int [20];
        System.out.println("Step 1:");
        Step1(list1, 0);
        Step1(list2, -1);
        display(list1, list2);
        System.out.println("\n\nStep 2:");
        Step2(list2);
        display(list1, list2);
        System.out.println("\n\nStep 3:");
        Step3(list1, list2);
        display(list1, list2);
        System.out.println("\n\nStep 4:");
        Step4(list2);
        display(list1, list2);
        System.out.println("\n\nStep 5:");
        Step5(list1, list2);
        display(list1, list2);
        System.out.println("\n\nStep 6:");
        average = Step6(list1);
        System.out.println("The average of elements in list1 is "+average);
        System.out.println("\n\nStep 7:");

    }//end of main

    private static void Step1(int[] list, int value) {
        for (int index = 0; index < 20; index++) {
            list[index] = value;
        }

    }//end of Step1

    private static void Step2(int[] list) {
        for (int index = 0; index < 20; index++) {
            Random random = new Random();
            list[index] = random.nextInt(100) + 1;
        }
    }//end of Step2

    private static void Step3(int[] list1, int[] list2) {
        for (int index = 0; index < 20; index++) {
            list1[index] = list2[index] * index;
        }
    }//end of Step3

    private static void Step4(int[] list) {
        for (int index = 0; index < 20; index += 2) {
            list[index] = 0;
        }
    }//end of Step4

    private static void Step5(int[] list1, int[] list2) {
        for (int index = 0; index < 20; index++) {
            list1[index] = list1[index] +list2[index];
        }
    }//end of Step5

    private static double Step6(int[] list) {
        for (int index = 0; index < 20; index++) {
            average =+ list[index];
        }
        average/= 20;
        return average;
    }//end of Step6

    private static void Step7(int[] list) {
        
    }//end of Step7

    private static void display(int[] list1, int[] list2) {
        System.out.println("Displaying list 1:");
        for (int index = 0; index < 20; index++) {
            System.out.print(list1[index]+"|");
        }
        System.out.println("\nDisplaying list 2:");
        for (int index = 0; index < 20; index++) {
            System.out.print(list2[index]+ "|");
        }
    }//end of display
}//end of class