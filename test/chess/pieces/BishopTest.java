package chess.pieces;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;

public class BishopTest {

	private Position[] positions = new Position[6] ;
	private Bishop[] bishops = new Bishop[2] ;

	@Before
	public void setUp() throws Exception {
		//Position[] positions = {new Position("E5"),new Position(5,6),new Position(4,5),new Position(6,7)};
		positions[0] = new Position("E5");
		positions[1] = new Position(8,8);
		positions[2] = new Position(8,2);
		positions[3] = new Position(2,8);
		positions[4] = new Position(1,1);
		positions[5] = new Position("F5");
		Chessboard board = new Chessboard();
		Color black = Color.BLACK;
		Color white = Color.WHITE;
		bishops[0] = new Bishop(board,positions[0],black);
		bishops[1] = new Bishop(board,positions[1],white);
		bishops[0].moveTo(positions[3]);
	}

	@Test
	public void isValidMove_OneStepUpRight() {
		assertTrue(bishops[0].isValidMove(positions[1]));
	}

	@Test
	public void isValidMove_OneStepDownRight() {
		assertTrue(bishops[0].isValidMove(positions[4]));
	}

	@Test
	public void isValidMove_OneStepUpLeft() {
		assertTrue(bishops[0].isValidMove(positions[3]));
	}

	@Test
	public void isValidMove_OneStepDownLeft() {
		assertTrue(bishops[0].isValidMove(positions[4]));
	}

	@Test
	public void isValidMove_InvalidMove() {
		assertFalse(bishops[1].isValidMove(positions[5]));
	}

}
