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
		return this.pieces[x-1][y-1];
	}

	/**
	 * Retourne la pièce de la case indiquée par pos ou null si la case est vide
	 * @param pos position d'une des cases
	 * @return pièce de la case indiquée par pos
	 */
	public Piece getPiece(Position pos){
		return this.pieces[pos.getX()-1][pos.getY()-1];
	}

	/**
	 * teste la présence d'une pièce sur la colonne comprise entre les positions start et end (exclues)
	 * @param start Position de départ
	 * @param end Position de fin
	 * @return vraie si la pièce est effectivement présente sur cette colonne
	 */
	public boolean isPiecePresentOnSameColumnBetween(Position start, Position end){
		if(!start.isOnSameColumnAs(end))
			throw new IllegalArgumentException("start Position or end Position invalide");

		return start.isOnSameColumnAs(end);
	}

	/**
	 * teste la présence d'une pièce sur la diagonale comprise entre les positions start et end (exclues)
	 * @param start Position de départ
	 * @param end Position de fin
	 * @return vraie si la pièce est effectivement présente sur cette diagonale
	 */
	public boolean isPiecePresentOnSameDiagonalBetween(Position start, Position end){
		if(!start.isOnSameDiagonalAs(end))
			throw new IllegalArgumentException("start Position or end Position invalide");

		return start.isOnSameDiagonalAs(end);
	}

	/**
	 * teste la présence d'une pièce sur la ligne comprise entre les positions start et end (exclues)
	 * @param start Position de départ
	 * @param end Position de fin
	 * @return vraie si la pièce est effectivement présente sur cette ligne
	 */
	public boolean isPiecePresentOnSameLineBetween(Position start, Position end){
		if(!start.isOnSameLineAs(end))
			throw new IllegalArgumentException("start Position or end Position invalide");

		return start.isOnSameLineAs(end);
	}

	/**
	 * Remplace la pièce située sur la case indiquée
	 * @param pos pos de la case de destination
	 * @param newPiece nouvelle pièce de la case
	 */
	public void setPiece(Position pos, Piece newPiece){
		this.pieces[pos.getX()][pos.getY()] = newPiece;
	}

	/**
	 * Retourne une chaîne de caractères représentant l'échiquier.
	 */
	public String toString(){
		char[] lettres = {'A','B','C','D','E','F','G','H'};
		String board="";

		//Affichage des lettres
		for (char c : lettres) {
			board += " " + c;
		}

		for(int n=0; n < this.pieces.length; n++){
			board += "┏━━━";
			if (n == this.pieces.length)
			{
				board += "┳━━━┓";
			}
		}

		for(int lignes=0; lignes < this.pieces.length; lignes++){
			for(int colonnes=0; colonnes < this.pieces[lignes].length; colonnes++){
				board += this.pieces[lignes].length - colonnes;
				board += "┃" + this.pieces[lignes][lignes].toString();
				if (colonnes == this.pieces[lignes].length)
				{
					board += "┃" + this.pieces[lignes][colonnes].toString() + "┃" + (this.pieces[lignes].length - colonnes);
				}
			}
		}

		for(int m=0; m < this.pieces.length; m++){
			board += "┗━━━";
			if (m == this.pieces.length)
			{
				board += "┻━━━┛";
			}
		}

		for (char c : lettres) {
			board += " " + c;
		}
		return board;
	}

}
