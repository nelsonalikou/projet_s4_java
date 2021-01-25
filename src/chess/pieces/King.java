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
		super(chessboard, position, color, "KING", Symbol.BLACK_KING);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean valid = false;
		if ((this.getPosition().isOnSameColumnAs(destination) || this.getPosition().isOnSameLineAs(destination) && this.getPosition().getManhattanDistance(destination) == 1)
				||
				(this.getPosition().isOnSameDiagonalAs(destination) && this.getPosition().getManhattanDistance(destination) == 2)){
			valid = true;
		}
		return valid;
	}

}
