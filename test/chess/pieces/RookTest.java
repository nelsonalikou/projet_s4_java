package chess.pieces;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;

public class RookTest {

	private Position[] positions = new Position[6] ;
	private Rook[] rooks = new Rook[2] ;

	@Before
	public void setUp() throws Exception {
		positions[0] = new Position("E5");
		positions[1] = new Position(7,4);
		positions[2] = new Position(0,4);
		positions[3] = new Position(4,0);
		positions[4] = new Position(4,6);
		positions[5] = new Position(5,5);
		Chessboard board = new Chessboard();
		rooks[0] = new Rook(board,positions[0],Color.BLACK);
		rooks[1] = new Rook(board,positions[1],Color.WHITE);
		rooks[0].moveTo(positions[3]);
	}

	@Test
	public void isValidMove_OneStepUp() {
		assertTrue(rooks[0].isValidMove(positions[1]));
	}

	@Test
	public void isValidMove_OneStepDown() {
		assertTrue(rooks[0].isValidMove(positions[2]));
	}

	@Test
	public void isValidMove_OneStepLeft() {
		assertTrue(rooks[0].isValidMove(positions[3]));
	}

	@Test
	public void isValidMove_OneStepRight() {
		assertTrue(rooks[0].isValidMove(positions[4]));
	}

	@Test
	public void isValidMove_InvalidMove() {
		assertFalse(rooks[1].isValidMove(positions[4]));
	}

}
