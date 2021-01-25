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
	 * abscisse (comprise entre 0 et 7)
	 */
	private int x;

	/**
	 * ordonnée (comprise entre 0 et 7)
	 */
	private int y;

	/**
	 * Constructeur de la classe Position crée une position à partir des coordonnées x et y données en paramètre.
	 * @param x abscisse
	 * @param y ordonnée
	 */
	public Position(int x, int y){
		if (x < 1 || y < 1 || x > 8 || y > 8){
			throw new IllegalArgumentException("Position invalide" + x + " " + y);
		}
		this.x = x - 1;
		this.y = y - 1;
	}

	/**
	 * Constructeur de la classe Position crée une position à partir des coordonnées x et y données en paramètre.
	 * @param algebraicNotation chaîne de 2 caractères représentant une case de l'échiquier en notation algébrique
	 */
	public Position(String algebraicNotation){

		char firstCharacter = algebraicNotation.charAt(0);
		switch(firstCharacter){

			case 'A' : this.x =  0;
			break;
			case 'B' : this.x =  1;
			break;
			case 'C' : this.x =  2;
			break;
			case 'D' : this.x =  3;
			break;
			case 'E' : this.x =  4;
			break;
			case 'F' : this.x =  5;
			break;
			case 'G' : this.x =  6;
			break;
			case 'H' : this.x =  7;
			break;

			default :
				throw new IllegalArgumentException("Première lettre de la position invalide");

		}

		char secondCharacter = algebraicNotation.charAt(1);
		if ( Character.getNumericValue(secondCharacter) < 1 || Character.getNumericValue(secondCharacter) > 8 ){
			throw new IllegalArgumentException("Seconde lettre de la position invalide");
		}
		this.y = Character.getNumericValue(algebraicNotation.charAt(1)) - 1;
	}

	/**
	 * Accesseur à l'abscisse de la position
	 * @return l'abscisse de la position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Accesseur à l'ordonnée de la position
	 * @return l'ordonnée de la position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Determine si la position actuelle est sur la même ligne qu'une autre passée en paramètre.
	 * @param otherPosition l'autre position
	 * @return true si laposition courante est sur la même ligne que otherPosition
	 */
	public boolean isOnSameLineAs(Position otherPosition){
		return this.y == otherPosition.y;
	}

	/**
	 * Determine si la position actuelle est sur la même colonne qu'une autre passée en paramètre.
	 * @param otherPosition l'autre position
	 * @return true si laposition courante est sur la même colonne que otherPosition
	 */
	public boolean isOnSameColumnAs(Position otherPosition){
		return this.x == otherPosition.x;
	}


	/**
	 * Determine si la position actuelle est sur la même diagonale qu'une autre passée en paramètre.
	 * @param otherPosition l'autre position
	 * @return true si laposition courante est sur la même diagonale que otherPosition
	 */
	public boolean isOnSameDiagonalAs(Position otherPosition){
		return Math.abs(otherPosition.x - this.x) == Math.abs(otherPosition.y - this.y);
	}

	/**
	 * Retourne la distance de Manhattan entre la position courante et une autre position.
	 * @param otherPosition l'autre position
	 * @return
	 */
	public int getManhattanDistance(Position otherPosition){
		return Math.abs(otherPosition.x - this.x) + Math.abs(otherPosition.y - this.y);
	}


	public String toString() {
		   return " " + toAlgebraicNotation();
	}

	public boolean equals(Object obj) {
        if (obj == null) return false;

        if( ! (obj instanceof Position) ) return false;

        Position otherPosition = (Position) obj;

        return (this.x != 0 && this.y != 0) ? (this.x == otherPosition.x && this.y == otherPosition.y) : (otherPosition.x == 0 && otherPosition.y == 0);
    }

	public int hashCode() {
        return (x == 0 && y == 0) ? 0 : 1;
    }

	/**
	 * Retourne une chaîne contenant la représentation de la position courante en notation algébrique
	 * @return représentation de la position courante en notation algébrique
	 */
	public String toAlgebraicNotation(){

		String algebraicNotation = "";

		switch(this.x){

			case 0 : algebraicNotation +=  'A';
			break;
			case 1 : algebraicNotation +=  'B';
			break;
			case 2 : algebraicNotation +=  'C';
			break;
			case 3 : algebraicNotation +=  'D';
			break;
			case 4 : algebraicNotation +=  'E';
			break;
			case 5 : algebraicNotation +=  'F';
			break;
			case 6 : algebraicNotation +=  'G';
			break;
			case 7 : algebraicNotation +=  'H';
			break;
		}

		algebraicNotation += Character.forDigit(this.y + 1 ,10);

		return algebraicNotation;

	}

}
