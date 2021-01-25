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
		super(chessboard, position, color, "ROOK", Symbol.BLACK_ROOK);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean valid = false;
		if (this.getPosition().isOnSameColumnAs(destination) || this.getPosition().isOnSameLineAs(destination)){
			valid = true;
		}
		return valid;
	}

}
