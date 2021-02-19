package chess.pieces;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;

public class QueenTest {

	private Position[] positions = new Position[10] ;
	private Queen[] queens = new Queen[2] ;

	@Before
	public void setUp() throws Exception {
		positions[0] = new Position("E5");
		positions[1] = new Position(7,4);
		positions[2] = new Position(0,4);
		positions[3] = new Position(4,0);
		positions[4] = new Position(4,6);
		positions[5] = new Position(7,7);
		positions[6] = new Position(7,1);
		positions[7] = new Position(1,7);
		positions[8] = new Position(0,0);
		positions[9] = new Position("D7");
		Chessboard board = new Chessboard();
		Color black = Color.BLACK;
		Color white = Color.WHITE;
		queens[0] = new Queen(board,positions[0],black);
		queens[1] = new Queen(board,positions[1],white);
		queens[0].moveTo(positions[3]);
	}

	@Test
	public void isValidMove_OneStepUp() {
		assertTrue(queens[0].isValidMove(positions[1]));
	}

	@Test
	public void isValidMove_OneStepDown() {
		assertTrue(queens[0].isValidMove(positions[2]));
	}

	@Test
	public void isValidMove_OneStepLeft() {
		assertTrue(queens[0].isValidMove(positions[3]));
	}

	@Test
	public void isValidMove_OneStepRight() {
		assertTrue(queens[0].isValidMove(positions[4]));
	}

	@Test
	public void isValidMove_OneStepUpRight() {
		assertTrue(queens[0].isValidMove(positions[1]));
	}

	@Test
	public void isValidMove_OneStepDownRight() {
		assertTrue(queens[0].isValidMove(positions[4]));
	}

	@Test
	public void isValidMove_OneStepUpLeft() {
		assertTrue(queens[0].isValidMove(positions[3]));
	}

	@Test
	public void isValidMove_OneStepDownLeft() {
		assertTrue(queens[0].isValidMove(positions[4]));
	}

	@Test
	public void isValidMove_InvalidMove() {
		assertFalse(queens[0].isValidMove(positions[9]));
	}

}
