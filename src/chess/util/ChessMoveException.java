/**
 *
 */
package chess.util;

/**
 * @author ALIKOU DONGMO NELSON
 *
 * Lancée lorsqu'un déplacement est invalide.
 */
public class ChessMoveException extends Exception{

	public ChessMoveException(String message, Position position1, Position Position2) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
