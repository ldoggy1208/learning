import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;


public class IOSummative {
    static String fileName = "Phonebook.txt";
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        updatePhonebook();
        String phonebook[][] = new String[20][2];
        try {
            while (true) {
                int choice;
                System.out.println("#### Phonebook###\n\n1-Display phonebook\n2-Search for name\n3-Search phone number\n4-Add name and phone number\n5-Delete contact\n6-Update name\n7-Update number\n8-Exit");
                System.out.print("\nChoose your option\n>");
                choice = Integer.parseInt(scan.nextLine());
    
                if (choice == 1) {
                    displayPhonebook();
                }
    
                else if (choice == 2) {
                    searchName(phonebook);
                }
    
                else if (choice == 3) {
                    searchPhoneNumber(phonebook);
                }
    
                else if (choice == 4) {
                    addNamePhone(phonebook);
                }
                
                else if (choice == 5) {
                    deleteNamePhone(phonebook);
                }
    
                else if (choice == 6) {
                    updateName(phonebook);
                }
                
                else if (choice == 7) {
                    updatePhone(phonebook);
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
    }//end of main

    private static void updateName(String[][] phonebook) throws IOException{
        System.out.print("\nInput the row # of which the name you would like to update\n>");
        int choice = scan.nextInt() - 1;
        if (phonebook[choice][0] == null && phonebook[choice][1] == null) {
            choice++;
        }
        System.out.print("\nWhat would you like to change the name to?\n>");
        String name = scan.next();
        phonebook[choice][0] = name;
        updatePhonebook();
    }//end of updateName

    private static void updatePhone(String[][] phonebook) throws IOException{
        System.out.print("\nInput the row # of which the number you would like to update\n>");
        int choice = scan.nextInt() - 1;
        System.out.print("\nWhat would you like to change the number to?\n>");
        String phone = scan.next();
        phonebook[choice][1] = phone;
        updatePhonebook();
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
		System.out.print("Input the row # that you would like to delete: ");
		int rowNum = Integer.parseInt(scan.nextLine());
		phonebook[rowNum] = new String[2];
        for (;rowNum < phonebook.length - 1; rowNum++) {
            phonebook[rowNum] = phonebook[rowNum + 1];
        }
        phonebook[rowNum] = new String[2];
        updatePhonebook();
	}//end of deleteNamePhone

    private static void searchPhoneNumber(String[][] phonebook) {
        System.out.print("\nInput the phone number to search for\n>");
        String search = scan.nextLine();
        for (int i = 0; i < phonebook.length; i++) {
            if (phonebook[i][1] == search) {
                String name = phonebook [i][0];
                System.out.println(search+" is "+name+"'s phone number");
            }
        }
    }//end of searchPhoneNumber

    private static void searchName(String[][] phonebook) {
        System.out.print("\nInput the name to search for\n>");
        String search = scan.nextLine();
        for (int i = 0; i < phonebook.length; i++) {
            if (phonebook[i][0].equals(search)) {
                String number = phonebook[i][1];
                System.out.println(search+"'s phone number is "+number);
            }
        }
    }//end of searchName

    public static void displayPhonebook() {
		try {
			File phonefile = new File(fileName);
			Scanner scan = new Scanner(phonefile);
			while (scan.hasNextLine()) {
			    String data = scan.nextLine();
			    System.out.println(data);
			//FileReader input = new FileReader(Phonebooktxt); 
			}
		    System.out.println("\n");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("record not found please import \\"+fileName);
			System.out.println("\n");
		}
    }//end of displayPhonebook

    private static void addNamePhone(String[][] phonebook)throws IOException {
		int i = 0;
		for(; i < phonebook.length && phonebook[i][0] != null; i++) {}
		if(i < phonebook.length) {
			System.out.print("Input the name of the contact you would like to add: ");
			phonebook[i][0] = scan.nextLine();
			System.out.print("Input the phone number of the contact you would like to add: ");
			phonebook[i][1] = scan.nextLine();
		}
		else
			System.out.println("NO EMPTY SPACE IN PHONEBOOK");
        updatePhonebook();
	}//end of addNamePhone
}//end of class
