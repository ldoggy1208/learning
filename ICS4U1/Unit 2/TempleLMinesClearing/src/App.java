import becker.robots.*; //Robot library
import java.util.Random;

class ClearMinesBaseCase {
	public static void main(String[] args) {
//Create a city were the robot lives
		City newmarket = new City();

//Determine the length and width of the city		
		Random rand = new Random();
		int length = rand.nextInt(19)+1;
		int width = rand.nextInt(19)+1;
		//int length = 1;
		//int width = 1;
		int thingCount = rand.nextInt((length*width)) + 1;

//Call build walls method
		buildWalls(newmarket, length, width);

//Put the mines
		buildThings(newmarket, thingCount, length, width);

//create an object type Robot called karel
		Robot karel = new Robot(newmarket, 3, 1, Direction.EAST);
		int lengthF = findLength(karel);
		System.out.println(lengthF);
		int widthF = findWidth(karel);
		System.out.println(widthF);
		returnToStart(karel);
		long startTime = System.currentTimeMillis();
        spiral(karel, lengthF, widthF-1);
		System.out.println("The time it took to clear the mines is "+(System.currentTimeMillis() - startTime) + "ms");
		returnToStart(karel);
		karel.setLabel("Done");

	} // end main
/*This method builds Walls to form an enclosure for the robot
 * @param City - current city where robot works
 * @return N/A
 */
	public static void buildWalls(City newmarket, int length, int width) {
		Wall[] nWalls = new Wall[length];
		Wall[] sWalls = new Wall[length];
		Wall[] eWalls = new Wall[width+1];
		Wall[] wWalls = new Wall[width];
		for (int j = 0; j < nWalls.length; j++) {
			nWalls[j] = new Wall(newmarket, 3, j+2, Direction.NORTH);
			sWalls[j] = new Wall(newmarket, 3+width, j+2, Direction.SOUTH);
		}

		for (int j = 0; j < wWalls.length; j++) {
			wWalls[j] = new Wall(newmarket, j+4, 2, Direction.WEST);
		}
		for (int j = 0; j < eWalls.length; j++) {
			eWalls[j] = new Wall(newmarket, j+3, 1+length, Direction.EAST);
		}
		
	} // end buildWalls

	
	/*This method places Things to represent the mines in the City
	 * @param City - current city where robot works
	 * @return N/A
	 */
	public static void buildThings(City newmarket, int thingCount, int length , int width) {
		Thing[] things = new Thing[thingCount];
		Random rand = new Random();
		for(int i = 0; i < things.length; i++) {	
			int x = rand.nextInt(length) + 2;
			int y = rand.nextInt(width+1) + 3; 
			things[i] = new Thing(newmarket, y, x);
		}

	}// end buildThings

    public static void turnRight(Robot karel) {
        int turns = 0;
        while (turns < 3) {
            karel.turnLeft();
            turns++;
        }
    } // end of turnRight

    public static void spiral(Robot karel, int l, int w) {
        Boolean lw = false;
		int length = l;
		int width = w;
        while (length >= 0 && width >= 0) {
            if (lw == false) {
                int moves = length;
                while (moves > 0) {
                    karel.move();
					while(karel.canPickThing()) {
						karel.pickThing();
					}
                    moves--;
                }
                lw = true;
                length--;
                turnRight(karel);
            }
            else {
                int moves = width; 
                while (moves > 0) {
                    karel.move();
					while(karel.canPickThing()) {
						karel.pickThing();
					}
                    moves--;
                }
                lw = false;
                width--;
                turnRight(karel);
            }
        }
		karel.move();
		while(karel.canPickThing()) {
			karel.pickThing();
		}     
    }

	public static int findLength(Robot karel) {
		int length = 0;
		while(karel.frontIsClear()) {
			karel.move();
			length+=1;
		}
		return length;

	}  

	public static int findWidth(Robot karel) {
		int width = 1;
		turnRight(karel);
		while(karel.frontIsClear()) {
			karel.move();
			width+=1;
		}
		return width;
	}

	public static void returnToStart(Robot karel) {
		System.out.println(karel.getDirection());
		while (karel.getDirection() != Direction.NORTH) {
			karel.turnLeft();
		}
		while(karel.frontIsClear()) {
			karel.move();
		}
		karel.turnLeft();
		while (karel.getAvenue() != 1) {
			karel.move();
		}
		karel.turnLeft();
		karel.turnLeft();
	}
} // end class
