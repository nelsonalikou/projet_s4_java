/**
 *
 */
package chess.pieces;

import chess.Chessboard;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

/**
 * Classe représentant le fou.
 * @author ALIKOU DONGMO NELSON
 *
 */
public class Bishop extends Piece{

	public Bishop(Chessboard chessboard, Position position, Color color) {
		super(chessboard, position, color, "BISHOP", Symbol.BLACK_BISHOP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean valid = false;
		if (this.getPosition().isOnSameDiagonalAs(destination)){
			valid = true;
		}
		return valid;
	}

}
