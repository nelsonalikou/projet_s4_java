/**
 *
 */
package chess.util;

/**
 * @author ALIKOU DONGMO NELSON
 *
 * Lanc�e lorsqu'un d�placement est invalide.
 */
public class ChessMoveException extends Exception{

	public ChessMoveException(String message, Position position1, Position Position2) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
