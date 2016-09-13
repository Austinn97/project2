package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
   
	@Test
	public void testStartingGridIsEmpty() {
		TicTacToe.EraseGrid();
		assertTrue(TicTacToe.IsGridEmpty());

	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToe.EraseGrid();
		TicTacToe.whosTurn = 'X';
		TicTacToe.Mark(0, 2);
		assertEquals('X',TicTacToe.grid[0][2]);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TicTacToe.EraseGrid();
		TicTacToe.whosTurn = 'O';
		TicTacToe.Mark(2, 0);
		assertEquals('O',TicTacToe.grid[2][0]);
	}
	
	@Test
	public void testUnableToMarkOverExisting() {
		TicTacToe.EraseGrid();
		TicTacToe.whosTurn = 'O';
		TicTacToe.Mark(0, 0);
		TicTacToe.whosTurn = 'X';
		TicTacToe.Mark(0, 0);
		assertEquals("This tile has already been taken.", TicTacToe.UnableToMark());
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		TicTacToe.EraseGrid();
		TicTacToe.turnsLeft = 1;
		assertTrue(TicTacToe.StillRunning());
	}
	
	@Test
	public void testIsGameOverHorizontalTopRow() {
		TicTacToe.EraseGrid();
		TicTacToe.whosTurn = 'X';
		TicTacToe.Mark(0, 0);
		TicTacToe.Mark(1, 1);
		TicTacToe.Mark(0, 1);
		TicTacToe.Mark(2, 2);
		TicTacToe.Mark(0, 2);
		TicTacToe.GetWinner();
		assertEquals("X",TicTacToe.Winner());
	}
	
	@Test
	public void testTieIfAllLocationsAreFilled() {
		TicTacToe.EraseGrid();

		TicTacToe.Mark(1,1);
		TicTacToe.Mark(0, 0);
		TicTacToe.Mark(2, 0);
		TicTacToe.Mark(0, 2);
		TicTacToe.Mark(0, 1);
		TicTacToe.Mark(2, 1);
		TicTacToe.Mark(1, 2);
		TicTacToe.Mark(1, 0);
		TicTacToe.Mark(2, 2);
		TicTacToe.GetWinner();
		assertEquals("TIE", TicTacToe.Winner());
	}	
}
