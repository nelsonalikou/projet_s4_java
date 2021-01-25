/**
 *
 */
package chess.pieces;

import chess.Chessboard;
import chess.util.Position;
import chess.util.ChessMoveException;
import chess.util.Color;

/**
 * @author ALIKOU DONGMO NELSON
 *
 * Classe de base représentant une pièce du jeu d'échecs
 */
public abstract class Piece {

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
	private String name;


	/**
	 * Echiquier auquel la pièce appartient
	 */
	protected Chessboard board;

	/**
	 * Constructeur
	 * @param chessboard échiquier auquel la pièce appartient
	 * @param position position initiale de la pièce
	 * @param color couleur de la pièce
	 * @param name nom de la pièce
	 * @param symbol symbole de la pièce
	 */
	public Piece(Chessboard chessboard, Position position, Color color, String name, char symbol){

		this.board = chessboard;
		this.position = position;
		this.color = color;
		this.name = name;
		this.symbol = symbol;

	}

		/**
		 * Retourne la position de la pièce sur l'échiquier.
		 * @return la position de la pièce sur l'échiquier
		 */
		public Position getPosition() {
			return position;
		}


		/**
		 * Retourne le symbole de la pièce
		 * @return le symbole de la pièce
		 */
		public char getSymbol() {
			return symbol;
		}


		/**
		 * Retourne la couleur de la pièce
		 * @return la couleur de la pièce
		 */
		public Color getColor() {
			return color;
		}


		/**
		 * Retourne le nom de la pièce.
		 * @return le nom de la pièce
		 */
		public String getName() {
			return name;
		}

		/**
		 * teste la couleur de la pièce.
		 * @return true si la pièce est noire, false sinon
		 */
		public boolean isBlack() {
			return this.color == Color.BLACK;
		}

		/**
		 * teste la couleur de la pièce.
		 * @return true si la pièce est blanche, false sinon
		 */
		public boolean isWhite() {
			return this.color == Color.WHITE;
		}

		/**
		 * deplace la pièce sur la case indiquée.
		 * @param destination position de la case de destination du déplacement.
		 * @throws ChessMoveException si le mouvement n'est pas possible
		 */
		public void moveTo(Position destination) throws ChessMoveException{
			try {
				this.board.setPiece(destination,this);
				}
			catch (IllegalArgumentException e) {
				throw new ChessMoveException("Déplacement impossible",getPosition(),destination);
			}
		}

		/**
		 * teste la validité d'un déplacement
		 * @param destination position de la case de destination du déplacement
		 * @return true si le mouvement est possible, false sinon
		 */
		public abstract boolean isValidMove(Position destination);



}
