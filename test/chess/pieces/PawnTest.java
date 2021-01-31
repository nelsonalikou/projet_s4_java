package chess.pieces;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;

public class PawnTest {

	private Position[] positions = new Position[6] ;
	private Pawn[] pawns = new Pawn[2] ;

	@Before
	public void setUp() throws Exception {
		//Position[] positions = {new Position("E5"),new Position(5,6),new Position(4,5),new Position(6,7)};
		positions[0] = new Position("E1");
		positions[1] = new Position(5,2);
		positions[2] = new Position(5,4);
		positions[3] = new Position(5,3);
		positions[4] = new Position(6,3);
		positions[5] = new Position(6,5);
		Chessboard board = new Chessboard();
		Color black = Color.BLACK;
		Color white = Color.WHITE;
		pawns[0] = new Pawn(board,positions[0],black);
		pawns[1] = new Pawn(board,positions[2],white);
		/*try {
			pawns[0].moveTo(positions[3]);
			}
		catch (IllegalArgumentException e) {}*/
	}

	@Test
	public void isValidMove_OneStepAtStart() {
		assertTrue(pawns[0].isValidMove(positions[1]));
	}

	@Test
	public void isValidMove_TwoStepAtStart() {
		assertTrue(pawns[0].isValidMove(positions[3]));
	}

	@Test
	public void isValidMove_invalidMove() {
		assertFalse(pawns[0].isValidMove(positions[2]));
	}


	@Test
	public void isValidMove_TwoStepAfterStartInvalidMove() {
		try {
		assertFalse(pawns[1].isValidMove(positions[5]));
		}
		catch (IllegalArgumentException e) {}
	}

}
