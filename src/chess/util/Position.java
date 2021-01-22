/**
 *
 */
package chess.util;

/**
 * @author ALIKOU DONGMO NELSON
 *
 * Représente la position d'une pièce lors d'une partie d'échecs
 */
public class Position {

	/**
	 * abscisse
	 */
	private int x;

	/**
	 * ordonnée
	 */
	private int y;

	/**
	 * Constructeur de la classe Position crée une position à partir des coordonnées x et y données en paramètre.
	 * @param x
	 * @param y
	 */
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	/**
	 * Accesseur à l'abscisse de la position
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Accesseur à l'ordonnée de la position
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Determine si la position actuelle est sur la même ligne qu'une autre passée en paramètre.
	 * @param otherPosition
	 * @return
	 */
	public boolean isOnSameLineAs(Position otherPosition){
		return this.y == otherPosition.y;
	}

	/**
	 * Determine si la position actuelle est sur la même colonne qu'une autre passée en paramètre.
	 * @param otherPosition
	 * @return
	 */
	public boolean isOnSameColumnAs(Position otherPosition){
		return this.x == otherPosition.x;
	}


	/**
	 * Determine si la position actuelle est sur la même diagonale qu'une autre passée en paramètre.
	 * @param otherPosition
	 * @return
	 */
	public boolean isOnSameDiagonalAs(Position otherPosition){
		return (this.x - otherPosition.x) == (this.y - otherPosition.y);
	}

	/**
	 * Retourne la distance de Manhattan entre la position courante et une autre position.
	 * @param otherPosition
	 * @return
	 */
	public int getManhattanDistance(Position otherPosition){
		return Math.abs(otherPosition.x - this.x) + Math.abs(otherPosition.y - this.y);
	}



}
