import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bingo {

	public static int ROUNDCOUNT = 0;
	public static int[][]randNumsUsed = new int [13][9];
	
	public static void main(String[] args) throws FileNotFoundException {

		int[][] bingoCard = new int[5][5];
		playGame(bingoCard, randNumsUsed);
	}
	public static boolean checkIfDuplicate (int newNum, int[][] array) {
		
		boolean duplicate = false; 
		int num = newNum;
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				if (num == array[row][column]) {
					duplicate = true;
				}
			}
		}
		return duplicate;
	}
	public static void fillUp (int[][] card) throws FileNotFoundException {
		
		Scanner input = new Scanner (new File("bingo.in"));
		
		while (input.hasNext()) {
			
			for (int row = 0; row < card.length; row++) {
				
				for (int column = 0; column < card[row].length; column++) {
					card[row][column] = input.nextInt();
				}
			}
		}
		input.close();
	}
	public static void printCard (int[][] card) {
		System.out.println("YOUR BINGO CARD :\n");
		System.out.println("   B    I    N    G    O");
		String line = ("--------------------------");
		for (int row = 0; row < card.length; row++) {
			System.out.println(line);
			
			for (int column = 0; column < card[row].length; column++) {
				
				if (card[row][column] < 10) {
					System.out.print("|  " + card[row][column] + " ");
				}
				else {
					System.out.print("| " + card[row][column] + " ");
				}
			}
			System.out.print("|");
			System.out.println();
		}	
		System.out.print(line + "\n\n");
	}
	public static void playOneRound (int[][] card, int[][] array) {
		
		ROUNDCOUNT++;
		int newNum = generateNewNum();
		boolean duplicate = checkIfDuplicate(newNum, array);
		
		while (duplicate == true) {
			newNum = generateNewNum();
			duplicate = checkIfDuplicate(newNum, array);
		}
		for (int row = 0; row < card.length; row++) {
				
			for (int column = 0; column < card[row].length; column++) {
				
				if (newNum == card[row][column]) {
						card[row][column] = 0;
				}	
			}
		}
		boolean assigned = false;
		
		for (int row = 0; row < array.length && !assigned; row++) {
			
			for (int column = 0; column < array[row].length; column++) {
				
				if (array[row][column] == 0) {
					array[row][column] = newNum;
					assigned = true;
					break;
				}
			}
		}
	}
	public static int generateNewNum () {
		
		int randomNum = (int)(1 + Math.random() * 75);
		return randomNum;
	}
	public static int rowOneSum (int[][] card) {
		
		int sum = 0;
		for (int row = 0; row < card.length; row++) {
			
			for (int column = 0; column < card[row].length; column++) {
				sum += card[0][column];
				
			}
		}
		return sum;
	}
	public static int rowTwoSum (int[][] card) {
		
		int sum = 0;
		for (int row = 0; row < card.length; row++) {
			
			for (int column = 0; column < card[row].length; column++) {
				sum += card[1][column];
				
			}
		}
		return sum;
	}
	public static int rowThreeSum (int[][] card) {
		
		int sum = 0;
		for (int row = 0; row < card.length; row++) {
			
			for (int column = 0; column < card[row].length; column++) {
				sum += card[2][column];
				
			}
		}
		return sum;
	}
	public static int rowFourSum (int[][] card) {
		
		int sum = 0;
		for (int row = 0; row < card.length; row++) {
			
			for (int column = 0; column < card[row].length; column++) {
				sum += card[3][column];
				
			}
		}
		return sum;
	}
	public static int rowFiveSum (int[][] card) {
	
	int sum = 0;
	for (int row = 0; row < card.length; row++) {
		
		for (int column = 0; column < card[row].length; column++) {
			sum += card[4][column];
			
			}
		}
		return sum;
	}
	public static int columnOneSum (int[][] card) {
		
		int sum = 0;
		for (int row = 0; row < card.length; row++) {
			
			for (int column = 0; column < card[row].length; column++) {
				sum += card[row][0];
				
				}
			}
			return sum;
	}
	public static int columnTwoSum (int[][] card) {
		
		int sum = 0;
		for (int row = 0; row < card.length; row++) {
			
			for (int column = 0; column < card[row].length; column++) {
				sum += card[row][1];
				
				}
			}
			return sum;
	}
	public static int columnThreeSum (int[][] card) {
	
		int sum = 0;
		for (int row = 0; row < card.length; row++) {
		
			for (int column = 0; column < card[row].length; column++) {
					sum += card[row][2];
			
			}
		}
		return sum;
}
	public static int columnFourSum (int[][] card) {
	
		int sum = 0;
		for (int row = 0; row < card.length; row++) {
		
			for (int column = 0; column < card[row].length; column++) {
				sum += card[row][3];
			
			}
		}
		return sum;
}
	public static int columnFiveSum (int[][] card) {
	
		int sum = 0;
		for (int row = 0; row < card.length; row++) {
		
			for (int column = 0; column < card[row].length; column++) {
				sum += card[row][4];
			
			}
		}
		return sum;
	}
	public static int positiveDiagonalSum (int[][] card) {
		
		int sum = 0;
		for (int row = 4; row >= 0; row--) {
			for (int column = 0; column < card[row].length; column++) {
				sum += card[row][column];
			}
		}
		return sum;
	}
	public static int negativeDiagonalSum (int[][] card) {
		
		int sum = 0;
		for (int row = 0; row < 5; row++) {
			for (int column = 4; column >= 0; column--) {
				sum += card[row][column];
			}
		}
		return sum;
	}
	public static void printCompletedCard (int[][] card) {

		System.out.println("YOUR BINGO CARD :\n");
		System.out.println("   B    I    N    G    O");
		String line = ("--------------------------");
		for (int row = 0; row < card.length; row++) {
			System.out.println(line);
			
			for (int column = 0; column < card[row].length; column++) {
				
				if (card[row][column] < 10) {
					if (card[row][column] > 0) {
						System.out.print("|  " + card[row][column] + " ");
					}
					else {
						System.out.print("|  X "); 
						}
				}
				else {
					System.out.print("| " + card[row][column] + " ");
				}
			}
			System.out.print("|");
			System.out.println();
		}	
		System.out.println(line);
	}
	public static void printRandNums (int[][] array) {
		
		System.out.println("BINGO NUMBERS PICKED AT RANDOM FROM BIN :");
		for (int row = 0; row < array.length; row++) {
		
			for (int column = 0; column < array[row].length; column++) {
					
				if (array[row][column] != 0) {
					System.out.print(array[row][column] + "\t");
				}	
			}
			if (array[row][0] == 0) {
				break;
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void playGame (int[][] card, int[][] array) throws FileNotFoundException {
		
		fillUp (card);
		printCard (card);
		boolean bingo = false;
		
		while (bingo == false) {
			
			playOneRound(card, array);
			int row1 = rowOneSum(card);
			int row2 = rowTwoSum(card);
			int row3 = rowThreeSum(card);
			int row4 = rowFourSum(card);
			int row5 = rowFiveSum(card);
			int col1 = columnOneSum(card);
			int col2 = columnTwoSum(card);
			int col3 = columnThreeSum(card);
			int col4 = columnFourSum(card);
			int col5 = columnFiveSum(card);
			int posDiag = positiveDiagonalSum(card);
			int negDiag = negativeDiagonalSum(card);
		
			if (row1 == 0 || row2 == 0 || row3 == 0 || row4 == 0 || row5 == 0) {
				printRandNums(randNumsUsed);
				System.out.println("YOU WIN WITH A HORIZONTAL BINGO AFTER " + ROUNDCOUNT + " PICKS!\n");
				printCompletedCard(card);
				bingo = true;
				
			}
			if (col1 == 0 || col2 == 0 || col3 == 0 || col4 == 0 || col5 == 0) {
				printRandNums(randNumsUsed);
				System.out.println("YOU WIN WITH A VERTICAL BINGO AFTER " + ROUNDCOUNT + " PICKS!\n");
				printCompletedCard(card);
				bingo = true;
				
			}
			if (posDiag == 0 || negDiag == 0) {
				printRandNums(randNumsUsed);
				System.out.println("YOU WIN WITH A DIAGONAL BINGO AFTER " + ROUNDCOUNT + " PICKS!\n");
				printCompletedCard(card);
				bingo = true;
				
			}
		}
		
	}
}
