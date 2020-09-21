package iDtechPractice;

import java.util.Scanner; 

public class DungeonQuest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] locations;
		locations = new String[3][2];
		
		locations[0][0] = "You are at the entrance of the cave.";
		locations[0][1] = "You are in a narrow corridor that curves to the south.";
		locations[1][0] = "You are in a large hallway that extends to the east.";
		locations[1][1] = "You are in a large hallway that extends to the west.";
		locations[2][0] = "You have entered a small room.";
		locations[2][1] = "A chest is in this room.";
		
		int row = 0, col = 0;
		Scanner userInput = new Scanner(System.in);
		int response;
		
		while(true){
			System.out.println(locations[row][col]);
			System.out.println("1. Go North");
			System.out.println("2. Go East");
			System.out.println("3. Go South");
			System.out.println("4. Go West");
			response = userInput.nextInt();
			if(response == 1){
				row--;
			}
			else if(response == 2){
				col++;
			}
			else if(response == 3){
				row++;
			}
			else if(response == 4){
				col--;
			}
			
			if (row<0) row = 4;
			if (col<0) col = 0;
			if (row>2) row = 2;
			if (col>1) col = 1;
		}

	}

}
