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
public class King extends Piece{

	public King(Chessboard chessboard, Position position, Color color) {
		super(chessboard, position, color, "KING", (color == Color.BLACK) ? Symbol.BLACK_KING : Symbol.WHITE_KING );
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean valid = false;
		if ((((this.getPosition().isOnSameColumnAs(destination) && !this.board.isPiecePresentOnSameColumnBetween(getPosition(), destination))
				|| (this.getPosition().isOnSameLineAs(destination) && !this.board.isPiecePresentOnSameLineBetween(getPosition(), destination))) // && !this.board.isPiecePresentOnSameLineBetween(getPosition(), destination)
					&& this.getPosition().getManhattanDistance(destination) == 1)
						||
						((this.getPosition().isOnSameDiagonalAs(destination) && !this.board.isPiecePresentOnSameDiagonalBetween(getPosition(), destination))
								&& this.getPosition().getManhattanDistance(destination) == 2)){
			valid = true;
		}
		return valid;
	}

}
