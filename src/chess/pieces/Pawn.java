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
public class Pawn extends Piece{

	/**
	 * vrai si le pion n'a pas encore �t� d�plac�.
	 */
	boolean notMovedYet = true;

	/**
	 * Constructeur.
	 */
	public Pawn(Chessboard chessboard, Position position, Color color) {
			super(chessboard, position, color, "PAWN", (color == Color.BLACK) ? Symbol.BLACK_PAWN : Symbol.WHITE_PAWN);
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean valid = false;
		if (this.getPosition().isOnSameColumnAs(destination) && !this.board.isPiecePresentOnSameColumnBetween(getPosition(), destination) && !this.isTheSameColor(destination) && this.board.getPiece(destination) == null){
			if(this.notMovedYet && this.getPosition().getManhattanDistance(destination) == 2){
				valid = true;
			}
			else if(this.getPosition().getManhattanDistance(destination) == 1 && this.board.getPiece(destination) == null){
				valid = true;
			}
		}else if(this.getPosition().isOnSameDiagonalAs(destination) && !this.board.isPiecePresentOnSameDiagonalBetween(getPosition(), destination) && this.getPosition().getManhattanDistance(destination) == 2 /*&& !this.isTheSameColor(destination)*/ && this.board.getPiece(destination) != null){
			valid = true;
		}
		return valid;
	}

	@Override
	public void moveTo(Position destination) throws ChessMoveException{
		if(isValidMove(destination)){
			super.moveTo(destination);
			this.notMovedYet = false;
		}
	}

}
