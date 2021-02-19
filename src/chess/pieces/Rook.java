/**
 *
 */
package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

/**
 * @author ALIKOU DONGMO NELSON
 *
 */
public class Rook extends Piece{

	public Rook(Chessboard chessboard, Position position, Color color) {
		super(chessboard, position, color, "ROOK", (color == Color.BLACK) ? Symbol.BLACK_ROOK : Symbol.WHITE_ROOK);
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean valid = false;
		if ((this.getPosition().isOnSameColumnAs(destination)
				&& !this.board.isPiecePresentOnSameColumnBetween(getPosition(), destination))
				||
				(this.getPosition().isOnSameLineAs(destination)
						&& !this.board.isPiecePresentOnSameLineBetween(getPosition(), destination))) {
			valid = true;
		}

		return valid;
	}

}
