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
		positions[1] = new Position(3,1);
		positions[2] = new Position("F1");
		positions[3] = new Position("D3");
		positions[4] = new Position(4,0); //E1
		positions[5] = new Position("A1");

		board = new Chessboard();

		//pawn = new Pawn(board,positions[0],black);
		queen = new Queen(board,positions[1],Color.WHITE);
		pawn = new Pawn(board,positions[4],Color.BLACK);
		pawn = new Pawn(board,positions[5],Color.BLACK);
	}

	@Test
	public void isPiecePresentOnSameColumnBetween_test_Piece_presence() {
		assertTrue(board.isPiecePresentOnSameColumnBetween(positions[0], positions[3]));
	}

	@Test
	public void isPiecePresentOnSameDiagonalBetween_test_no_Piece_presence() {
		assertFalse(board.isPiecePresentOnSameDiagonalBetween(positions[3], positions[2]));
	}

	@Test
	public void isPiecePresentOnSameLineBetween_test_Piece_presence() {
		assertFalse(board.isPiecePresentOnSameLineBetween(positions[0], positions[5]));
	}

	/*
	@Test
	public void isPiecePresentOnSameDiagonalBetween_test_Piece_presence() {
		//test de presence d'une piece
		assertTrue(board.isPiecePresentOnSameDiagonalBetween(positions[2], positions[3]));
	}*/

}
