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

	/**
	 * Constructeur.
	 * @param message
	 * @param startingPosition
	 * @param destination
	 */
	public ChessMoveException(String message, Position startingPosition, Position destination) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
