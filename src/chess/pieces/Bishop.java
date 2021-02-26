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
 * Classe repr�sentant le fou.
 * @author ALIKOU DONGMO NELSON
 *
 */
public class Bishop extends Piece{

	public Bishop(Chessboard chessboard, Position position, Color color) {
		super(chessboard, position, color, "BISHOP", (color == Color.BLACK) ? Symbol.BLACK_BISHOP : Symbol.WHITE_BISHOP);
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean valid = false;
		//getPosition().isOnSameDiagonalAs(destination)
		if ((this.getPosition().isOnSameDiagonalAs(destination) && !this.board.isPiecePresentOnSameDiagonalBetween(getPosition(), destination))
				&& !this.isTheSameColor(destination)){
			valid = true;

			/*if(this.board.getPiece(destination) == null || this.board.getPiece(destination).getColor() == this.board.getPiece(destination).getColor()){
				valid = false;
			}*/

		}
		return valid;
	}

}
