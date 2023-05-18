import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOSummative {
    static String phonebook[][] = new String[20][2];
    static String fileName = "Phonebook.txt";
    public static void main(String[] args) throws IOException{
        updatePhonebook();
        Scanner scan = new Scanner(System.in);
        try {
            while (true) {
                int choice;
                System.out.println("#### Phonebook###\n\n1-Display phonebook\n2-Search for name\n3-Search phone number\n4-Add name and phone number\n5-Delete name\n6-Update name\n7-Update number\n7-Exit");
                System.out.print("\n\nChoose your option\n>");
                choice = scan.nextInt();
    
                if (choice == 1) {
    
                }
    
                else if (choice == 2) {
    
                }
    
                else if (choice == 3) {
    
                }
    
                else if (choice == 4) {
    
                }
                
                else if (choice == 5) {
    
                }
    
                else if (choice == 6) {
                    updateName();
                }
                
                else if (choice == 7) {
                    updatePhone();
                }
                
                else if (choice == 8) {
                    exit();
                }
    
                else {
                    System.out.println("Invalid selection.");
                }
         
            }
        }
        catch (Exception e) {
            System.out.println("An error occured: " + e.getMessage());

        }
    }

    private static void updateName() throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.print("\nInput the contact number of which the name you would like to update\n>");
        int choice = scan.nextInt() - 1;
        System.out.print("\nWhat would you like to change the name to?\n>");
        String name = scan.next();
        phonebook[choice][0] = name;
        updatePhonebook();
    }

    private static void updatePhone() throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.print("\nInput the contact number of which the number you would like to update\n>");
        int choice = scan.nextInt() - 1;
        System.out.print("\nWhat would you like to change the number to?\n>");
        String phone = scan.next();
        phonebook[choice][1] = phone;
        updatePhonebook();
    }

    private static void exit() {
        System.exit(0);
    }

    private static void updatePhonebook() throws IOException{
        FileWriter fw = new FileWriter(fileName);
        int contactNumber = 0;
        for (int i = 0; i < phonebook.length; i++) {
            contactNumber += 1;
            fw.write(contactNumber);
            for (int index = 0; index < 2; index++) {
                contactNumber += 1;
                fw.write(" - "+phonebook[i][index]);

            }
        }
    }

}
