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
 * Classe de base représentant une pièce du jeu d'échecs
 */
public class Piece {

	/**
	 * Position de la pièce sur l'échiquier
	 */
	private Position position;

	/**
	 * Symbole devant representer la pièce sur le plateau de jeu.
	 */
	private char symbol;

	/**
	 * Couleur de la pièce (Color.WHITE ou Color.BLACK)
	 */
	private Color color;

	/**
	 * Nom de la pièce (Roi, Reine, ...)
	 */
	private String Name;


	/**
	 * Echiquier auquel la pièce appartient
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
