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
public class Queen extends Piece{

	public Queen(Chessboard chessboard, Position position, Color color) {
		super(chessboard, position, color, "QUEEN", Symbol.BLACK_QUEEN);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean valid = false;
		if (this.getPosition().isOnSameColumnAs(destination) || this.getPosition().isOnSameLineAs(destination) || this.getPosition().isOnSameDiagonalAs(destination)){
			valid = true;
		}
		return valid;
	}

}
