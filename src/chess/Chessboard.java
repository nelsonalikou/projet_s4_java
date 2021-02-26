package chess;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

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
	 * Fonction de crétion de spièces à inserer dans le plateau
	 */
	public Piece[][] createPieces(){
		for(int colonnes = 0; colonnes < pieces.length; colonnes++){
			for(int lignes = 0; lignes < pieces.length; lignes++){

				//Condition de mise en place d'un pion
				if(colonnes == 1 || colonnes == 6)
					new Pawn(this,new Position(lignes,colonnes),(colonnes == 1) ? Color.WHITE : Color.BLACK);

				//Condition de mise en place des autres pièces
				if(colonnes == 0 || colonnes == 7){
					Position pos = new Position(lignes,colonnes);

					switch(lignes){

					case 0 : new Rook(this,pos,(colonnes == 0) ? Color.WHITE : Color.BLACK);
					break;
					case 1 : new Knight(this,pos,(colonnes == 0) ? Color.WHITE : Color.BLACK);
					break;
					case 2 : new Bishop(this,pos,(colonnes == 0) ? Color.WHITE : Color.BLACK);
					break;
					case 3 : new King(this,pos,(colonnes == 0) ? Color.WHITE : Color.BLACK);
					break;
					case 4 : new Queen(this,pos,(colonnes == 0) ? Color.WHITE : Color.BLACK);
					break;
					case 5 : new Bishop(this,pos,(colonnes == 0) ? Color.WHITE : Color.BLACK);
					break;
					case 6 : new Knight(this,pos,(colonnes == 0) ? Color.WHITE : Color.BLACK);
					break;
					case 7 : new Rook(this,pos,(colonnes == 0) ? Color.WHITE : Color.BLACK);
					break;
					}
				}
			}
		}
		return this.pieces;
	}

	/**
	 * Retourne la pièce de la case (x,y) de l'échiquier ou null si la case est vide
	 * @param x abscisse de la case
	 * @param y ordonnée de la case
	 * @return pièce de la case (x,y) de l'echequier
	 */
	public Piece getPiece(int x, int y){
		return this.pieces[y][x];
	}

	/**
	 * Retourne la pièce de la case indiquée par pos ou null si la case est vide
	 * @param pos position d'une des cases
	 * @return pièce de la case indiquée par pos
	 */
	public Piece getPiece(Position pos){
		return this.pieces[pos.getY()][pos.getX()];
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
		//je calcule la distance entre les deux positions
		int dis = Math.abs(start.getY() - end.getY());

		if(start.getY() - end.getY() > 0){
			 cpt = end.getY();
		}else{
			 cpt = start.getY();
		}

		 //System.out.println("les Y col" + "start y = " + start.getY() + " end y = " + end.getY());

		int newy = cpt;

		newy++;
		cpt = newy;

	    while (newy < (cpt + dis - 2) && present == false) {
	    	System.out.println("entree boucle col" + newy + " " + start.getX());
	    	if(this.pieces[newy][start.getX()] != null){
				present = true;
				 System.out.println(this.pieces[newy][start.getX()].getSymbol());
			}
	      newy++;
	      System.out.println("sortie boucle col" + newy + " " + start.getX());
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

		//comparaison des ordonnées des points
		if(start.getY() - end.getY() < 0){
			//sauvegarde de la plus petite odonnée selon le cas
			 cptY = start.getY();
			 cptX = start.getX();
			 cptx = end.getX();
		}else{
			 cptY = end.getY();
			 cptX = end.getX();
			 cptx = start.getX();
		}

		//System.out.println("les Y col" + "start y = " + start.getY() + " end y = " + end.getY());
		//System.out.println("les X lig" + "start x = " + start.getX() + " end x = " + end.getX());


		int newy = cptY;

		newy++;
		cptY = newy;
		System.out.println("entree boucle dia" + newy + " " + cptX);
	    while (newy < (cptY + dis - 2) && present == false) {
	    	//System.out.println("entree boucle dia " + newy + " " + cptX);
	    	if(this.pieces[newy][cptX] != null){
				present = true;
				 //System.out.println(this.pieces[newy][cptX].getSymbol());
			}

	    	if(cptX > cptx){
	    		cptX--;
	    	}
	    	else{
	    		cptX++;
	    	}
	      newy++;
	      //System.out.println("sortie boucle dia " + newy + " " + cptX + " " + present);

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

		//compteur sur X : l'abscisse de position
		int cptX;
		//distance entre les abscisses des deux positions.
		int dis = Math.abs(start.getX() - end.getX());

		if(start.getX() - end.getX() < 0){
			 cptX = start.getX() ;
		}else{
			 cptX = end.getX();
		}

		//System.out.println("les X lig" + "start x = " + start.getX() + " end x = " + end.getX());

		cptX++;
		int cpt0 = cptX;
	    while (cptX < (cpt0 + dis - 2) && present == false) {
	    	//System.out.println("entree boucle col" + start.getY() + " " + cptX);
	    	if(this.pieces[start.getY()][cptX] != null){
				present = true;
				 //System.out.println(this.pieces[start.getY()][cptX].getSymbol());
			}
	    	cptX++;
	    	//System.out.println("sortie boucle lig" + start.getY() + " " + cptX);
	    }

		return present;

	}


	/**
	 * Remplace la pièce située sur la case indiquée
	 * @param pos pos de la case de destination
	 * @param newPiece nouvelle pièce de la case
	 */
	public void setPiece(Position pos, Piece newPiece){
		this.pieces[pos.getY()][pos.getX()] = newPiece;
	}

	/**
	 * Retourne une chaîne de caractères représentant l'échiquier.
	 */
	public String toString(){
		//Retour à la ligne
		char L = '\n';

		//Tableau des lettres devant apparaitre sur l'echiquier
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
					board.append(" " + String.format("%2s",this.pieces[lignes][colonnes].getSymbol()));
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
