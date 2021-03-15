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
 * Classe de base repr�sentant une pi�ce du jeu d'�checs
 */
public abstract class Piece {

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
	private String name;


	/**
	 * Echiquier auquel la pi�ce appartient
	 */
	protected Chessboard board;

	/**
	 * Constructeur
	 * @param chessboard �chiquier auquel la pi�ce appartient
	 * @param position position initiale de la pi�ce
	 * @param color couleur de la pi�ce
	 * @param name nom de la pi�ce
	 * @param symbol symbole de la pi�ce
	 */
	public Piece(Chessboard chessboard, Position position, Color color, String name, char symbol){

		this.board = chessboard;
		this.position = position;
		this.color = color;
		this.name = name;
		this.symbol = symbol;

		this.board.setPiece(position, this);

	}

		/**
		 * Retourne la position de la pi�ce sur l'�chiquier.
		 * @return la position de la pi�ce sur l'�chiquier
		 */
		public Position getPosition() {
			return position;
		}


		/**
		 * Retourne le symbole de la pi�ce
		 * @return le symbole de la pi�ce
		 */
		public char getSymbol() {
			return symbol;
		}


		/**
		 * Retourne la couleur de la pi�ce
		 * @return la couleur de la pi�ce
		 */
		public Color getColor() {
			return color;
		}


		/**
		 * Retourne le nom de la pi�ce.
		 * @return le nom de la pi�ce
		 */
		public String getName() {
			return name;
		}

		/**
		 * teste la couleur de la pi�ce.
		 * @return true si la pi�ce est noire, false sinon
		 */
		public boolean isBlack() {
			return this.color == Color.BLACK;
		}

		/**
		 * teste la couleur de la pi�ce.
		 * @return true si la pi�ce est blanche, false sinon
		 */
		public boolean isWhite() {
			return this.color == Color.WHITE;
		}

		/**
		 * deplace la pi�ce sur la case indiqu�e.
		 * @param destination position de la case de destination du d�placement.
		 * @throws ChessMoveException si le mouvement n'est pas possible
		 */
		public void moveTo(Position destination) throws ChessMoveException{
			if (!isValidMove(destination))
				throw new ChessMoveException("D�placement impossible",getPosition(),destination);
			this.board.setPiece(destination,this);
			this.board.setPiece(getPosition(), null);
		}

		/**
		 * teste la validit� d'un d�placement
		 * @param destination position de la case de destination du d�placement
		 * @return true si le mouvement est possible, false sinon
		 */
		public abstract boolean isValidMove(Position destination);


		/**
		 * teste la couleur de la pièce suitée à la destination
		 * @param destination position de la case de destination du déplacement
		 * @return boolean true si la pièce est de meme couleur que celle situé à la position destination.
		 * @throws ChessMoveException
		 */
		public boolean isTheSameColor(Position destination){
			boolean same = true;
			System.out.println(this.board.getPiece(destination) == null);
			System.out.println(  "meme couleur ?" + !(this.board.getPiece(destination) == null || this.getColor() != this.board.getPiece(destination).getColor() && !this.isTheSameColor(destination)));
			if((this.board.getPiece(destination) == null || this.getColor() != this.board.getPiece(destination).getColor() && !this.isTheSameColor(destination))){
				same = false;
				/*try {
					throw new ChessMoveException("Déplacement impossible car on ne peut peut pas capturer sa propre pièce",getPosition(),destination);
				} catch (ChessMoveException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				//throw new ChessMoveException("Déplacement impossible car on ne peut peut pas capturer sa propre pièce",getPosition(),destination);
			}
			return same;
		}

}
