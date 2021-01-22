/**
 *
 */
package chess.pieces;

import chess.Chessboard;
import chess.util.Position;
import chess.util.Color;

/**
 * @author ALIKOU DONGMO NELSON
 *
 * Classe de base repr�sentant une pi�ce du jeu d'�checs
 */
public class Piece {

	/**
	 * Position de la pi�ce sur l'�chiquier
	 */
	private Position position;

	/**
	 * Symbole devant representer la pi�ce sur le plateau de jeu.
	 */
	private char symbol;

	/**
	 * Couleur de la pi�ce (Color.WHITE ou Color.BLACK)
	 */
	private Color color;

	/**
	 * Nom de la pi�ce (Roi, Reine, ...)
	 */
	private String Name;


	/**
	 * Echiquier auquel la pi�ce appartient
	 */
	protected Chessboard board;


		/**
		 * @return the position
		 */
		public Position getPosition() {
			return position;
		}


		/**
		 * @return the symbol
		 */
		public char getSymbol() {
			return symbol;
		}


		/**
		 * @return the color
		 */
		public Color getColor() {
			return color;
		}


		/**
		 * @return the name
		 */
		public String getName() {
			return Name;
		}

}
