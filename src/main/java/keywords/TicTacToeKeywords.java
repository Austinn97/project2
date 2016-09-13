import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToe g;
	
	public void StartNewGame() {
		g = new TicTacToe();
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
