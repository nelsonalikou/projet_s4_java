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
public class Pawn extends Piece{

	/**
	 * vrai si le pion n'a pas encore été déplacé.
	 */
	boolean notMovedYet = true;

	/**
	 * Constructeur.
	 */
	public Pawn(Chessboard chessboard, Position position, Color color) {
		super(chessboard, position, color, "PAWN", Symbol.BLACK_PAWN);
	}

	@Override
	public boolean isValidMove(Position destination) {
		boolean valid = false;
		if (this.getPosition().isOnSameColumnAs(destination)){
			if(this.notMovedYet && this.getPosition().getManhattanDistance(destination) == 2){
				valid = true;
			}
			else if(this.getPosition().getManhattanDistance(destination) == 1){
				valid = true;
			}
		}
		return valid;
	}

	@Override
	public void moveTo(Position destination){
		if(isValidMove(destination)){
			this.moveTo(destination);
			this.notMovedYet = false;
		}
	}

}
