/**
 *
 */
package chess.util;

/**
 * @author ALIKOU DONGMO NELSON
 *
 * Repr�sente la position d'une pi�ce lors d'une partie d'�checs
 */
public class Position {

	/**
	 * abscisse
	 */
	private int x;

	/**
	 * ordonn�e
	 */
	private int y;

	/**
	 * Constructeur de la classe Position cr�e une position � partir des coordonn�es x et y donn�es en param�tre.
	 * @param x
	 * @param y
	 */
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	/**
	 * Accesseur � l'abscisse de la position
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Accesseur � l'ordonn�e de la position
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Determine si la position actuelle est sur la m�me ligne qu'une autre pass�e en param�tre.
	 * @param otherPosition
	 * @return
	 */
	public boolean isOnSameLineAs(Position otherPosition){
		return this.y == otherPosition.y;
	}

	/**
	 * Determine si la position actuelle est sur la m�me colonne qu'une autre pass�e en param�tre.
	 * @param otherPosition
	 * @return
	 */
	public boolean isOnSameColumnAs(Position otherPosition){
		return this.x == otherPosition.x;
	}


	/**
	 * Determine si la position actuelle est sur la m�me diagonale qu'une autre pass�e en param�tre.
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
