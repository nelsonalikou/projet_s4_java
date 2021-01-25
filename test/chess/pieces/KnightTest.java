package chess.pieces;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;

public class KnightTest {

	private Position[] positions = new Position[9] ;
	private Knight[] knights = new Knight[2] ;

	@Before
	public void setUp() throws Exception {
		//Position[] positions = {new Position("E5"),new Position(5,6),new Position(4,5),new Position(6,7)};
		positions[0] = new Position("D4");
		positions[1] = new Position("E6");
		positions[2] = new Position("F5");
		positions[3] = new Position("F3");
		positions[4] = new Position("E2");
		positions[5] = new Position("C2");
		positions[6] = new Position("B3");
		positions[7] = new Position("B5");
		positions[8] = new Position("C6");

		Chessboard board = new Chessboard();
		Color black = Color.BLACK;
		Color white = Color.WHITE;
		knights[0] = new Knight(board,positions[0],black);
		knights[1] = new Knight(board,positions[1],white);
		knights[0].moveTo(positions[3]);
	}

	@Test
	public void isValidMove_OneStepUpRight1() {
		assertTrue(knights[0].isValidMove(positions[1]));
	}

	@Test
	public void isValidMove_OneStepUpRight2() {
		assertTrue(knights[0].isValidMove(positions[2]));
	}

	@Test
	public void isValidMove_OneStepDownRight1() {
		assertTrue(knights[0].isValidMove(positions[3]));
	}

	@Test
	public void isValidMove_OneStepDownRight2() {
		assertTrue(knights[0].isValidMove(positions[4]));
	}

	@Test
	public void isValidMove_OneStepDownLeft2() {
		assertTrue(knights[0].isValidMove(positions[5]));
	}

	@Test
	public void isValidMove_OneStepDownLeft1() {
		assertTrue(knights[0].isValidMove(positions[6]));
	}

	@Test
	public void isValidMove_OneStepUpLeft2() {
		assertTrue(knights[0].isValidMove(positions[7]));
	}

	@Test
	public void isValidMove_OneStepUpLeft1() {
		assertTrue(knights[0].isValidMove(positions[8]));
	}

	@Test
	public void isValidMove_InvalidMove() {
		assertFalse(knights[1].isValidMove(positions[4]));
	}

}
