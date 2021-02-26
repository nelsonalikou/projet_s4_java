/**
 *
 */
package chess.pieces;

import chess.Chessboard;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

/**
 * @author ALIKOU DONGMO NELSON
 *
 */
public class Queen extends Piece{

	public Queen(Chessboard chessboard, Position position, Color color) {
		super(chessboard, position, color, "QUEEN", (color == Color.BLACK) ? Symbol.BLACK_QUEEN : Symbol.WHITE_QUEEN);
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean valid = false;
		if (((this.getPosition().isOnSameColumnAs(destination) && !this.board.isPiecePresentOnSameColumnBetween(getPosition(), destination))
				||
				(this.getPosition().isOnSameLineAs(destination) && !this.board.isPiecePresentOnSameLineBetween(getPosition(), destination))
				||
				(this.getPosition().isOnSameDiagonalAs(destination) && !this.board.isPiecePresentOnSameDiagonalBetween(getPosition(), destination)))
				&& !this.isTheSameColor(destination)){
			valid = true;
		}
		return valid;
	}

}