import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;

public class IOSummative {
    static String phonebook[][] = new String[20][2];
    static String fileName = "Phonebook.txt";
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        updatePhonebook();
        try {
            while (true) {
                int choice;
                System.out.println("#### Phonebook###\n\n1-Display phonebook\n2-Search for name\n3-Search phone number\n4-Add name and phone number\n5-Delete contact\n6-Update name\n7-Update number\n8-Exit");
                System.out.print("\nChoose your option\n>");
                choice = scan.nextInt();
    
                if (choice == 1) {
    
                }
    
                else if (choice == 2) {
                    searchName(phonebook);
                }
    
                else if (choice == 3) {
                    searchPhoneNumber(phonebook);
                }
    
                else if (choice == 4) {
    
                }
                
                else if (choice == 5) {
                    deleteNamePhone(phonebook);
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
            System.out.println("An error occurred: " + e.getMessage());
        }
        scan.close();
    }//end of main

    private static void updateName() throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.print("\nInput the row # of which the name you would like to update\n>");
        int choice = scan.nextInt() - 1;
        System.out.print("\nWhat would you like to change the name to?\n>");
        String name = scan.next();
        phonebook[choice][0] = name;
        updatePhonebook();
        scan.close();
    }//end of updateName

    private static void updatePhone() throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.print("\nInput the row # of which the number you would like to update\n>");
        int choice = scan.nextInt() - 1;
        System.out.print("\nWhat would you like to change the number to?\n>");
        String phone = scan.next();
        phonebook[choice][1] = phone;
        updatePhonebook();
        scan.close();
    }//end of updatePhone

    private static void exit() {
        System.exit(0);
    }//end of exit

    private static void updatePhonebook() throws IOException{
        String[][] phonebook = readFile("phonebook.txt");
		PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter("phonebook.txt")));
		for(int i = 0; i < phonebook.length; i++) {
			if(phonebook[i][0] != null)
				print.print(String.join(", ", phonebook[i][0], phonebook[i][1]) + "\n");
		}
		print.close();
    }//end of updatePhonebook

    private static String[][] readFile(String filename) {
		String[][] phonebook = new String[20][2];
		String line;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			line = in.readLine();
			for(int index = 0; line != null; index++){
				phonebook[index] = line.split(", ");
				line = in.readLine();
			}
			in.close();
		}
		catch(IOException iox) {
			System.out.println("Problem reading the file");
		}
		
		return phonebook;
	}//end of readfile

    private static void deleteNamePhone(String[][] phonebook) throws IOException{
        Scanner scan = new Scanner(System.in);
		System.out.print("Input the row # that you would like to delete: ");
		int rowNum = scan.nextInt();
		phonebook[rowNum] = new String[2];
        scan.close();
        updatePhonebook();
	}//end of deleteNamePhone

    private static void searchPhoneNumber(String[][] phonebook) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nInput the phone number to search for\n>");
        String search = scan.next();
        for (int i = 0; i < phonebook.length; i++) {
            if (phonebook[i][1] == search) {
                String name = phonebook [i][0];
                System.out.println(search+" is "+name+"'s phone number");
            }
        }
        scan.close();
    }//end of searchPhoneNumber

    private static void searchName(String[][] phonebook) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nInput the name to search for\n>");
        String search = scan.next();
        for (int i = 0; i < phonebook.length; i++) {
            if (phonebook[i][0] == search) {
                String number = phonebook[i][1];
                System.out.println(search+"'s phone number is "+number);
            }
        }
        scan.close();
    }//end of searchName

}//end of class
