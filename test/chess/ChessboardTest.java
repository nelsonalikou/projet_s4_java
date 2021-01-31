package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.util.Color;
import chess.util.Position;

public class ChessboardTest {

	private Position[] positions = new Position[6] ;
	private Pawn pawn;
	private Queen queen;
	private Chessboard board;

	@Before
	public void setUp() throws Exception {
		positions[0] = new Position("D1");
		positions[1] = new Position(4,2);
		positions[2] = new Position("F1");
		positions[3] = new Position(4,3);
		positions[4] = new Position(5,1);
		positions[5] = new Position("A1");

		board = new Chessboard();

		Color black = Color.BLACK;
		Color white = Color.WHITE;
		//pawn = new Pawn(board,positions[0],black);
		queen = new Queen(board,positions[1],white);
		pawn = new Pawn(board,positions[4],black);
		pawn = new Pawn(board,positions[5],black);
	}

	@Test
	public void isPiecePresentOnSameColumnBetween_test() {
		assertTrue(board.isPiecePresentOnSameColumnBetween(positions[0], positions[3]));
	}

	@Test
	public void isPiecePresentOnSameDiagonalBetween_test() {
		assertTrue(board.isPiecePresentOnSameDiagonalBetween(positions[2], positions[3]));
	}

	@Test
	public void isPiecePresentOnSameLineBetween_test() {
		assertTrue(board.isPiecePresentOnSameLineBetween(positions[0], positions[5]));
	}

	/*@Test
	public void isPiecePresentOnSameLineBetween_invalidMove() {
		assertFalse(board.isPiecePresentOnSameLineBetween(positions[0], positions[5]));
	}*/

}
