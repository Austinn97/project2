package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
   
	@Test
	public void testStartingGridIsEmpty() {
		TicTacToeModel.EraseGrid();
		assertTrue(TicTacToeModel.IsGridEmpty());

	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToeModel.EraseGrid();
		TicTacToeModel.whosTurn = 'X';
		TicTacToeModel.Mark(0, 2);
		assertEquals('X',TicTacToeModel.grid[0][2]);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TicTacToeModel.EraseGrid();
		TicTacToeModel.whosTurn = 'O';
		TicTacToeModel.Mark(2, 0);
		assertEquals('O',TicTacToeModel.grid[2][0]);
	}
	
	@Test
	public void testUnableToMarkOverExisting() {
		TicTacToeModel.EraseGrid();
		TicTacToeModel.whosTurn = 'O';
		TicTacToeModel.Mark(0, 0);
		TicTacToeModel.whosTurn = 'X';
		TicTacToeModel.Mark(0, 0);
		assertEquals("This tile has already been taken.", TicTacToeModel.UnableToMark());
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		TicTacToeModel.EraseGrid();
		TicTacToeModel.turnsLeft = 1;
		assertTrue(TicTacToeModel.StillRunning());
	}
	
	@Test
	public void testIsGameOverHorizontalTopRow() {
		TicTacToeModel.EraseGrid();
		TicTacToeModel.whosTurn = 'X';
		TicTacToeModel.Mark(0, 0);
		TicTacToeModel.Mark(1, 1);
		TicTacToeModel.Mark(0, 1);
		TicTacToeModel.Mark(2, 2);
		TicTacToeModel.Mark(0, 2);
		TicTacToeModel.GetWinner();
		assertEquals("X",TicTacToeModel.Winner());
	}
	
	@Test
	public void testTieIfAllLocationsAreFilled() {
		TicTacToeModel.EraseGrid();

		TicTacToeModel.Mark(1,1);
		TicTacToeModel.Mark(0, 0);
		TicTacToeModel.Mark(2, 0);
		TicTacToeModel.Mark(0, 2);
		TicTacToeModel.Mark(0, 1);
		TicTacToeModel.Mark(2, 1);
		TicTacToeModel.Mark(1, 2);
		TicTacToeModel.Mark(1, 0);
		TicTacToeModel.Mark(2, 2);
		TicTacToeModel.GetWinner();
		assertEquals("TIE", TicTacToeModel.Winner());
	}	
}
