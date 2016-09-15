package edu.jsu.mcis;

import static java.lang.System.out;

import java.util.Scanner;

public class TicTacToeModel {
	public static Scanner scan = new Scanner(System.in);
	public static int row, col;
	public static char[][] grid = new char[3][3];
	public static char whosTurn = 'X';
	public static int turnsLeft = 0;
	public static String wonHow = "  ";

	
	public static void NewGame(){
		EraseGrid();
		PrintGrid();
		while (StillRunning()){
		Winner();
		out.println();
		out.print("Player " + whosTurn + ",enter a row: ");
		row = scan.nextInt()-1;
		out.print("Player " + whosTurn + ",enter a col: ");
		col = scan.nextInt()-1;
		Mark(row, col);
		PrintGrid();
		GetWinner();
		Winner();
		}


	}
	
	public static void EraseGrid(){
		turnsLeft = 0;
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid.length; j++){
				grid[i][j] = '_';
			}
		}
	}
	
	public static void PrintGrid(){
		for (int i = 0; i < 3; i++){
			out.println();
			for (int j = 0; j < 3; j++){
				{if (grid[i][j] == '_')
						out.print('_');
				else 
					out.print(grid[i][j]);
				}
			}
		}
	}	
	
	public static boolean IsGridEmpty(){
		boolean empty = true;
		if (grid[0][0] == grid[0][1] 
				&& grid[0][0] == grid[0][2]
						&& grid[0][2] == grid[1][0] 
								&&	grid[1][0] == grid[1][1]
										& grid[1][0] == grid[1][2]
												&& grid[1][2] == grid[2][0]
														&& grid[2][0] == grid[2][1]
																&& grid[2][0] == grid[2][2]
																		&& grid[2][2] == '_'){
			empty = true;
		}else {
				empty = false;
		}
		return empty;
		}
	
	public static void Mark( int moveRow, int moveColumn){
		if (grid[moveRow][moveColumn] == '_'){
			grid[moveRow][moveColumn] = whosTurn;
			 if (whosTurn == 'X'){
					whosTurn = 'O';
			 }
			 else {
					whosTurn = 'X';}
			 turnsLeft++;
		}

		else {
			UnableToMark();
			out.println("\n\n" + UnableToMark());
		}

	}

	public static String GetMark(int moveRow, int moveColumn){
		String character = Character.toString(grid[moveRow][moveColumn]);
		String location = character;
		return location;
	}
	public static String CheckLocation(int moveRow, int moveColumn){
		String character = Character.toString(grid[moveRow][moveColumn]);
		String location =  character;
		return location;
	}
	
	public static String UnableToMark(){
		return "This tile has already been taken.";		
	}
	
	public static boolean StillRunning(){
		if(turnsLeft == 9)
			return false;
		 else 
			 return true;
		}
	
	public static boolean HorizontalWin(){
		if (grid[0][0] == grid[0][1] && 
				grid[0][0] == grid[0][2] &&
				grid[0][0] != '_')
			return true;
		if (grid[1][0] == grid[1][1] && 
				grid[1][0] == grid[1][2] &&
				grid[1][0] != '_')
			return true;
		if (grid[2][0] == grid[2][1] && 
				grid[2][0] == grid[2][2] &&
				grid[2][0] != '_'){
			return true;
		}
		else 
			return false;
	}
	
	public static boolean VerticalWin(){
		if (grid[0][0] == grid[1][0] && 
				grid[0][0] == grid[2][0] &&
				grid[0][0] != '_' )
			return true;
		if (grid[0][1] == grid[1][1] && 
				grid[0][1] == grid[2][1] &&
				grid[0][1] != '_')
			return true;
		if (grid[0][2] == grid[1][2] && 
				grid[0][2] == grid[2][2] &&
				grid[0][2] != '_')
			return true;
		else 
			return false;
	}
	
	public static boolean DiagonalWin(){
		if (grid[0][0] == grid[1][1] && 
				grid[0][0] == grid[2][2] &&
				grid[0][0] != '_')
			return true;
		if (grid[0][2] == grid[1][1] && 
				grid[0][2] == grid[2][0] &&
				grid[0][2] != '_')
			return true;
		else 
			return false;
	}
	
	public static void GetWinner(){
		if (turnsLeft != 9){
				if (DiagonalWin()){
					wonHow = "Diagonal";
					turnsLeft = 9;
				}
				else if (HorizontalWin()){
					wonHow = "Horizontal";
					turnsLeft = 9;
				}
				else if (VerticalWin()){
					wonHow = "Vertical";
					turnsLeft = 9;
				}	
				
		}
		else if (turnsLeft == 9){
			wonHow = "Tie";
		}
		
		}
	
	public static String Winner(){
		String winner = "";
		if (wonHow == "Diagonal"){
		 if (whosTurn == 'X'){
				whosTurn = 'O';
		 }
		 else {
				whosTurn = 'X';}
			if (whosTurn == 'X'){
				winner = "X";
			}else {
				winner = "O";
			}
		 out.println("\nPlayer " + whosTurn + " won diagonally.");
		}
		else if (wonHow == "Horizontal"){
			 if (whosTurn == 'X'){
					whosTurn = 'O';
			 }
			 else {
					whosTurn = 'X';}
				if (whosTurn == 'X'){
					winner = "X";
				}else {
					winner = "O";
				}
			 out.println("\nPlayer " + whosTurn + " won horizontally.");
			}
		else if (wonHow == "Vertical"){
			 if (whosTurn == 'X'){
					whosTurn = 'O';
			 }
			 else {
					whosTurn = 'X';}
				if (whosTurn == 'X'){
					winner = "X";
				}else {
					winner = "O";
				}
			 out.println("\nPlayer " + whosTurn + " won vertically.");
			}else if (wonHow == "Tie"){
				 if (whosTurn == 'X'){
						whosTurn = 'O';
				 }
				 else {
				out.println();
				out.println("It is a Tie.");
				winner = "TIE";
		}
		

		
	
	}
		return winner;
}
}

		
