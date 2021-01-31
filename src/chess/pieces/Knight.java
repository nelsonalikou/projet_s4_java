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
public class Knight extends Piece{

	public Knight(Chessboard chessboard, Position position, Color color) {
		super(chessboard, position, color, "KNIGHT", (color == Color.BLACK) ? Symbol.BLACK_KNIGHT : Symbol.WHITE_KNIGHT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean valid = false;
		if (this.getPosition().getManhattanDistance(destination) == 3
				&&
				!this.getPosition().isOnSameColumnAs(destination)
				&&
				!this.getPosition().isOnSameLineAs(destination)
				&&
				!this.getPosition().isOnSameDiagonalAs(destination)){
			valid = true;
		}
		return valid;
	}

}
