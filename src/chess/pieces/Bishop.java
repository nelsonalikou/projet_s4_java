/**
 *
 */
package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

/**
 * Classe repr�sentant le fou.
 * @author ALIKOU DONGMO NELSON
 *
 */
public class Bishop extends Piece{

	public Bishop(Chessboard chessboard, Position position, Color color) {
		super(chessboard, position, color, "BISHOP", (color == Color.BLACK) ? Symbol.BLACK_BISHOP : Symbol.WHITE_BISHOP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean valid = false;
		//getPosition().isOnSameDiagonalAs(destination)
		if (!this.board.isPiecePresentOnSameDiagonalBetween(getPosition(), destination)){
			valid = true;
		}
		return valid;
	}

}
