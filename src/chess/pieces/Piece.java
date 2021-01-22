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
 */
public class Piece {

		private Position position;
		private char symbol;
		private Color color;
		private String Name;
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
