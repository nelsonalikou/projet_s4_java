package chess;

import chess.pieces.Piece;
import chess.util.Position;

/**
 *
 * @author ALIKOU DONGMO NELSON
 *
 * Classe représentant un échiquier lors d'une partie d'échecs
 */
public class Chessboard {

	/**
	 * tableau de pièces représentant les cases de l'échiquier (une case vide vaut null).
	 */
	private Piece[][] pieces;

	/**
	 * Constructeur par défaut de la classe Chessboard.
	 */
	public Chessboard(){
		this.pieces = new Piece[8][8];
	}

	/**
	 * Retourne la pièce de la case (x,y) de l'échiquier ou null si la case est vide
	 * @param x abscisse de la case
	 * @param y ordonnée de la case
	 * @return pièce de la case (x,y) de l'echequier
	 */
	public Piece getPiece(int x, int y){
		int newy = y;

		switch(y){

		case 1 : newy +=  7;
		break;
		case 2 : newy +=  5;
		break;
		case 3 : newy +=  3;
		break;
		case 4 : newy +=  1;
		break;
		case 5 : newy +=  -1;
		break;
		case 6 : newy +=  -3;
		break;
		case 7 : newy +=  -5;
		break;
		case 8 : newy +=  -7;
		break;
		}

		return this.pieces[newy-1][x-1];
	}

	/**
	 * Retourne la pièce de la case indiquée par pos ou null si la case est vide
	 * @param pos position d'une des cases
	 * @return pièce de la case indiquée par pos
	 */
	public Piece getPiece(Position pos){
		int newy = pos.getY();

		switch(pos.getY() + 1){

		case 1 : newy +=  7;
		break;
		case 2 : newy +=  5;
		break;
		case 3 : newy +=  3;
		break;
		case 4 : newy +=  1;
		break;
		case 5 : newy +=  -1;
		break;
		case 6 : newy +=  -3;
		break;
		case 7 : newy +=  -5;
		break;
		case 8 : newy +=  -7;
		break;
		}

		return this.pieces[newy][pos.getX()];
	}

	/**
	 * teste la présence d'une pièce sur la colonne comprise entre les positions start et end (exclues)
	 * @param start Position de départ
	 * @param end Position de fin
	 * @return vraie si la pièce est effectivement présente sur cette colonne
	 * @throws
	 */
	public boolean isPiecePresentOnSameColumnBetween (Position start, Position end) throws IllegalArgumentException{
		boolean present = false;
		if(!start.isOnSameColumnAs(end))
			throw new IllegalArgumentException("start Position or end Position invalid : column move");

		int cpt;
		int dis = Math.abs(start.getY() - end.getY());

		if(start.getY() - end.getY() < 0){
			 cpt = end.getY();
		}else{
			 cpt = start.getY();
		}


		int newy = cpt;

		switch(cpt + 1){

		case 1 : newy +=  7;
		break;
		case 2 : newy +=  5;
		break;
		case 3 : newy +=  3;
		break;
		case 4 : newy +=  1;
		break;
		case 5 : newy +=  -1;
		break;
		case 6 : newy +=  -3;
		break;
		case 7 : newy +=  -5;
		break;
		case 8 : newy +=  -7;
		break;
		}

		newy++;
		cpt = newy;

	    while (newy < (cpt + dis -1) && present == false) {
	    	if(this.pieces[newy][start.getX()] != null){
				present = true;
			}
	      newy++;
	    }

		return present;
		//return this.pieces[newy][start.getX()] != null;
	}

	/**
	 * teste la présence d'une pièce sur la diagonale comprise entre les positions start et end (exclues)
	 * @param start Position de départ
	 * @param end Position de fin
	 * @return vraie si la pièce est effectivement présente sur cette diagonale
	 */
	public boolean isPiecePresentOnSameDiagonalBetween(Position start, Position end) throws IllegalArgumentException{
		boolean present = false;
		if(!start.isOnSameDiagonalAs(end))
			throw new IllegalArgumentException("start Position or end Position invalid : diagonal move");

		int cptY,cptX, cptx; //respectivement l'ordonnée la plus basse, l'abscisse liée à cette ordonnée, l'abscisse de l'autre position.

		int dis = Math.abs(start.getY() - end.getY());

		if(start.getY() - end.getY() < 0){
			 cptY = end.getY();
			 cptX = end.getX();
			 cptx = start.getX();
		}else{
			 cptY = start.getY();
			 cptX = start.getX();
			 cptx = end.getX();
		}

		int newy = cptY;

		switch(cptY + 1){

		case 1 : newy +=  7;
		break;
		case 2 : newy +=  5;
		break;
		case 3 : newy +=  3;
		break;
		case 4 : newy +=  1;
		break;
		case 5 : newy +=  -1;
		break;
		case 6 : newy +=  -3;
		break;
		case 7 : newy +=  -5;
		break;
		case 8 : newy +=  -7;
		break;
		}

		newy++;
		cptY = newy;

	    while (newy < (cptY + dis) && present == false) {
	    	if(this.pieces[newy][cptX] != null){
				present = true;
			}

	    	if(cptX > cptx){
	    		cptX--;
	    	}
	    	else{
	    		cptX++;
	    	}
	      newy++;
	    }


		return present;
		//return this.pieces[6][4] != null;
	}

	/**
	 * teste la présence d'une pièce sur la ligne comprise entre les positions start et end (exclues)
	 * @param start Position de départ
	 * @param end Position de fin
	 * @return vraie si la pièce est effectivement présente sur cette ligne
	 */
	public boolean isPiecePresentOnSameLineBetween(Position start, Position end) throws IllegalArgumentException{
		boolean present = false;
		if(!start.isOnSameLineAs(end))
			throw new IllegalArgumentException("start Position or end Position invalid : line move");

		int cpt;
		//distance entre les abscisses des deux positions.
		int dis = Math.abs(start.getX() - end.getX());

		if(start.getX() - end.getX() < 0){
			 cpt = start.getX() ;
		}else{
			 cpt = end.getX();
		}


		int newy = start.getY();

		switch(start.getY() + 1){

		case 1 : newy +=  7;
		break;
		case 2 : newy +=  5;
		break;
		case 3 : newy +=  3;
		break;
		case 4 : newy +=  1;
		break;
		case 5 : newy +=  -1;
		break;
		case 6 : newy +=  -3;
		break;
		case 7 : newy +=  -5;
		break;
		case 8 : newy +=  -7;
		break;
		}

		int cpt0 = cpt;
	    while (cpt < (cpt0 + dis) && present == false) {
	    	if(this.pieces[newy][cpt] != null){
				present = true;
			}
	    	cpt++;
	    }

		return present;

	}

	/**
	 * Remplace la pièce située sur la case indiquée
	 * @param pos pos de la case de destination
	 * @param newPiece nouvelle pièce de la case
	 */
	public void setPiece(Position pos, Piece newPiece){
		int newy = pos.getY();

		switch(pos.getY() + 1){

		case 1 : newy +=  7;
		break;
		case 2 : newy +=  5;
		break;
		case 3 : newy +=  3;
		break;
		case 4 : newy +=  1;
		break;
		case 5 : newy +=  -1;
		break;
		case 6 : newy +=  -3;
		break;
		case 7 : newy +=  -5;
		break;
		case 8 : newy +=  -7;
		break;
		}

		this.pieces[newy][pos.getX()] = newPiece;
	}

	/**
	 * Retourne une chaîne de caractères représentant l'échiquier.
	 */
	public String toString(){
		//Retour à la ligne
		char L = '\n';

		char[] lettres = {'A','B','C','D','E','F','G','H'};
		StringBuilder board = new StringBuilder(5000);

		//Affichage des lettres
		for (char c : lettres) {
			board.append("   " + c);
		}

		board.append(L);
		for(int n=0; n < this.pieces.length; n++){

			if (n == 0)
			{
				board.append("  ┏━━━");
			}else if(n == this.pieces.length - 1){
				board.append("┳━━━┓");

			}else{
				board.append("┳━━━");

			}
		}

		board.append(L);
		for(int lignes=0; lignes < this.pieces.length; lignes++){
			board.append(this.pieces[lignes].length - lignes);
			for(int colonnes=0; colonnes < this.pieces[lignes].length; colonnes++){
				board.append(" ┃" );

				if (this.pieces[lignes][colonnes] == null) {
					board.append("  ");
				}else{
					board.append(" " + this.pieces[lignes][colonnes].getSymbol());
				}
				if(colonnes == this.pieces[lignes].length - 1){
					board.append("┃");
				}

			}
			board.append(this.pieces[lignes].length - lignes);
			board.append(L);

			if(lignes != this.pieces[lignes].length - 1)
			for(int m=0; m < this.pieces.length; m++){
				if (m == 0)
				{
					board.append("  ┣━━━");
				}else if(m == this.pieces.length - 1){
					board.append("╋━━━┫");

				}else{
					board.append("╋━━━");

				}
			}else{
				for(int m=0; m < this.pieces.length; m++){
					if (m == 0)
					{
						board.append("  ┗━━━");
					}else if(m == this.pieces.length - 1){
						board.append("┻━━━┛");

					}else{
						board.append("┻━━━");

					}
				}
			}

			board.append(L);
		}

		for (char c : lettres) {
			board.append("   " + c);
		}
		return board.toString();
	}

}
