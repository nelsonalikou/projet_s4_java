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
	 * abscisse (comprise entre 0 et 7)
	 */
	private int x;

	/**
	 * ordonn�e (comprise entre 0 et 7)
	 */
	private int y;

	/**
	 * Constructeur de la classe Position cr�e une position � partir des coordonn�es x et y donn�es en param�tre.
	 * @param x abscisse
	 * @param y ordonn�e
	 */
	public Position(int x, int y){
		if (x < 0 || y < 0 || x > 7 || y > 7){
			throw new IllegalArgumentException("Position invalide" + x + " " + y);
		}
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructeur de la classe Position cr�e une position � partir des coordonn�es x et y donn�es en param�tre.
	 * @param algebraicNotation cha�ne de 2 caract�res repr�sentant une case de l'�chiquier en notation alg�brique
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
				throw new IllegalArgumentException("Premi�re lettre de la position invalide");

		}

		char secondCharacter = algebraicNotation.charAt(1);
		if ( Character.getNumericValue(secondCharacter) < 1 || Character.getNumericValue(secondCharacter) > 8 ){
			throw new IllegalArgumentException("Seconde lettre de la position invalide");
		}
		this.y = Character.getNumericValue(algebraicNotation.charAt(1)) - 1;
	}

	/**
	 * Accesseur � l'abscisse de la position
	 * @return l'abscisse de la position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Accesseur � l'ordonn�e de la position
	 * @return l'ordonn�e de la position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Determine si la position actuelle est sur la m�me ligne qu'une autre pass�e en param�tre.
	 * @param otherPosition l'autre position
	 * @return true si laposition courante est sur la m�me ligne que otherPosition
	 */
	public boolean isOnSameLineAs(Position otherPosition){
		return this.y == otherPosition.y;
	}

	/**
	 * Determine si la position actuelle est sur la m�me colonne qu'une autre pass�e en param�tre.
	 * @param otherPosition l'autre position
	 * @return true si laposition courante est sur la m�me colonne que otherPosition
	 */
	public boolean isOnSameColumnAs(Position otherPosition){
		return this.x == otherPosition.x;
	}


	/**
	 * Determine si la position actuelle est sur la m�me diagonale qu'une autre pass�e en param�tre.
	 * @param otherPosition l'autre position
	 * @return true si laposition courante est sur la m�me diagonale que otherPosition
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
        //Je verifie si mon objet est null auquel cas je retourne false
		if (obj == null) return false;

        //Je verifie si mon objet est bien de type position, dans le cas contraire je retourne false.
		if( ! (obj instanceof Position) ) return false;

        Position otherPosition = (Position) obj;

        return (this.x != 0 && this.y != 0) ? (this.x == otherPosition.x && this.y == otherPosition.y) : (otherPosition.x == 0 && otherPosition.y == 0);
    }

	public int hashCode() {
        return (x == 0 && y == 0) ? 0 : 1;
    }

	/**
	 * Retourne une cha�ne contenant la repr�sentation de la position courante en notation alg�brique
	 * @return repr�sentation de la position courante en notation alg�brique
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

		//J'ajoute à la chaine la valeur de l'ordonnée et convertie en base décimale.
		algebraicNotation += Character.forDigit(this.y + 1,10);

		return algebraicNotation;

	}

}
