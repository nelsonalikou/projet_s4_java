package chess.pieces;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;

public class KingTest {

	private Position[] positions = new Position[6] ;
	private King[] kings = new King[2] ;

	@Before
	public void setUp() throws Exception {
		positions[0] = new Position("E2");
		positions[1] = new Position(4,2);
		positions[2] = new Position(4,0);
		positions[3] = new Position(3,1);
		positions[4] = new Position(5,1);
		positions[5] = new Position(3,0);
		Chessboard board = new Chessboard();
		Color black = Color.BLACK;
		Color white = Color.WHITE;
		kings[0] = new King(board,positions[0],black);
		kings[1] = new King(board,positions[1],white);
		//kings[0].moveTo(positions[3]);
	}

	@Test
	public void isValidMove_OneStepUp() {
		assertTrue(kings[0].isValidMove(positions[1]));
	}

	@Test
	public void isValidMove_OneStepDown() {
		assertTrue(kings[0].isValidMove(positions[2]));
	}

	@Test
	public void isValidMove_OneStepLeft() {
		assertTrue(kings[0].isValidMove(positions[3]));
	}

	@Test
	public void isValidMove_OneStepRight() {
		assertTrue(kings[0].isValidMove(positions[4]));
	}

	@Test
	public void isValidMove_OneStepDiagonal() {
		assertTrue(kings[0].isValidMove(positions[5]));
	}

	@Test
	public void isValidMove_InvalidMove() {
		assertFalse(kings[1].isValidMove(positions[5]));
	}

}
