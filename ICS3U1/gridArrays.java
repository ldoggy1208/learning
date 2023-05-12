/*This class is a demonstration of 2D grid arrays
 * @Author Temple
 * @Date May 4th 2023
 * @Version 1.0
 */
public class gridArrays {
    
    //declaration of 2D array
    // 2D array is AN ARRAY OF ARRAYS
    //note that every subarray is separated by ',' as well
    static char [][] Letters ={ {'A','B','C','D'}, //row 0
                                {'E','F','G'},     //row 1
                                {'H','I','J','K'}, //row 2
                                {'L','M','N','O','P'}       }; //row 3
     //the length of 2D array == number of rows it has
     // rows may have different number of elements
     // thus different lengths
    public static void main(String[] args) {
        //we can get measurements
        System.out.println("Length of the arrays is "+Letters.length);
        //as well we can get length of the row that we need
        System.out.println("Length of the row#1 is "+Letters[1].length);

        //we can also try to print any element
            // with [row #] [column #]

        display();
    System.out.println(Letters[3][0]+""+Letters[2][1]+""+Letters[0][0]+""+Letters[3][1]);
    }//end of main

    //this method will display the content of the array
    //@param none
    //@return none
    private static void display() {
        
        //in order to display 2D grid array, we have to follow this:

        //first we make a for loop designated to go into revery row
        for(int row = 0; row < Letters.length; row++) {
            //inside ROW loops
            //we make another for loop (inner)
            //to access every element of that row(col) short for column
            for(int col = 0; col < Letters[row].length; col++) {
                System.out.print(Letters[row][col]+"\t");
            }
            //after ervery inner for loop we have to implement new line
            System.out.println();
        }

    }//end of display

}//end of class
