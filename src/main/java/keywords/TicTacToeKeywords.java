import edu.jsu.mcis.*;

import static java.lang.System.out;

import java.util.Scanner;

public class TicTacToeKeywords {
	private TicTacToeModel g;

	
	public void StartNewGame() {
		g = new TicTacToeModel();
		g.EraseGrid();
		g.turnsLeft = 0;
		g.whosTurn = 'X';
	}
	
	public void markLocation(int row, int col) {
		g.Mark(row, col);
	}
	
	public String getMark(int row, int col) {
		return g.GetMark(row,col);

	}
		
	public String getWinner() {
		g.GetWinner();
		return g.Winner();
	}
}