/**
 *
 */
package chess;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;
import chess.util.ChessMoveException;
import chess.util.Color;
import chess.util.Position;
import chess.util.Symbol;

/**
 * @author ALIKOU DONGMO NELSON
 *
 */
public class Game {

	/**
	 * Nom du joueur ayant les pi�ces blanches
	 */
	private String whitePlayerName;

	/**
	 * Nom du joueur ayant les pi�ces noires
	 */
	private String blackPayerName;

	/**
	 * Echiquier
	 */
	private Chessboard board;

	/**
	 * couleur des pi�ces du joueur courant Rappel : les blancs jouent en premier.
	 */
	private Color currentColor = Color.BLACK;

	/**
	 * Constructeur.
	 * @param whitePlayerName nom du joueur ayant les pi�ces blanches
	 * @param blackPayerName nom du joueur ayant les pi�ces noires
	 */
	public Game(String whitePlayerName, String blackPayerName){
		this.blackPayerName = blackPayerName;
		this.whitePlayerName = whitePlayerName;

		this.board = new Chessboard();

		Map<Position, Piece> initial_board = new HashMap<>();

		//Piece[] pieces = {};
		for(int colonnes=1; colonnes < 9; colonnes++){
			for(int lignes=1; lignes < 9; lignes++){
				if(lignes == 1) {

					Position pos = new Position(colonnes, lignes);
					switch(colonnes){

					case 1 : initial_board.put(pos, new Rook(this.board,pos,Color.BLACK));
					break;
					case 2 : initial_board.put(pos, new Knight(this.board,pos,Color.BLACK));
					break;
					case 3 : initial_board.put(pos, new Bishop(this.board,pos,Color.BLACK));
					break;
					case 4 : initial_board.put(pos, new King(this.board,pos,Color.BLACK));
					break;
					case 5 : initial_board.put(pos, new Queen(this.board,pos,Color.BLACK));
					break;
					case 6 : initial_board.put(pos, new Bishop(this.board,pos,Color.BLACK));
					break;
					case 7 : initial_board.put(pos, new Knight(this.board,pos,Color.BLACK));
					break;
					case 8 : initial_board.put(pos, new Rook(this.board,pos,Color.BLACK));
					break;
					}

				}else if(lignes == 2) {
					Position pos = new Position(colonnes, lignes);
					initial_board.put(pos, new Pawn(this.board,pos,Color.BLACK));
				}else if (lignes == 7) {
					Position pos = new Position(colonnes, lignes);
					initial_board.put(pos, new Pawn(this.board,pos,Color.WHITE));
				}else if (lignes == 8) {
					Position pos = new Position(colonnes, lignes);
					switch(colonnes){

					case 1 : initial_board.put(pos, new Rook(this.board,pos,Color.WHITE));
					break;
					case 2 : initial_board.put(pos, new Knight(this.board,pos,Color.WHITE));
					break;
					case 3 : initial_board.put(pos, new Bishop(this.board,pos,Color.WHITE));
					break;
					case 4 : initial_board.put(pos, new King(this.board,pos,Color.WHITE));
					break;
					case 5 : initial_board.put(pos, new Queen(this.board,pos,Color.WHITE));
					break;
					case 6 : initial_board.put(pos, new Bishop(this.board,pos,Color.WHITE));
					break;
					case 7 : initial_board.put(pos, new Knight(this.board,pos,Color.WHITE));
					break;
					case 8 : initial_board.put(pos, new Rook(this.board,pos,Color.WHITE));
					break;
					}
				}
			}
		}

		System.out.println(this.board.toString());

	}

	/**
	 * Retourne le nom du joueur ayant les pi�ces blanches
	 * @return whitePlayerName le nom du joueur ayant les pi�ces blanches
	 */
	public String getWhitePlayerName() {
		return whitePlayerName;
	}

	/**
	 * Retourne le nom du joueur ayant les pi�ces noires
	 * @return blackPayerName le nom du joueur ayant les pi�ces noires
	 */
	public String getBlackPayerName() {
		return blackPayerName;
	}

	/**
	 * Retourne la couleur des pi�ces du joueur dont c'est le tour
	 * @return currentColor la couleur des pi�ces du joueur dont c'est le tour
	 */
	public Color getCurrentColor() {
		return currentColor;
	}

	/**
	 * tour du joueur courant
	 * @param start position de la pi�ce � d�placer
	 * @param end destination du d�placement
	 * @throws ChessMoveException si la case de d�part est vide, si elle contient une pi�ce de l'adversaire, ou si le d�placement est invalide.
	 */
	public void turn(Position start ,Position end) throws ChessMoveException{
		System.out.println(start.toString() + " en" + end.toString());

		Piece piece_a_bouger = this.board.getPiece(start);
		if(piece_a_bouger == null)
		{
			throw new ChessMoveException("no chess piece here", start, end);
		}else if(!(getCurrentColor() == this.board.getPiece(start).getColor())){
			throw new ChessMoveException("It'is not your turn", start, end);
		}else if(!this.board.getPiece(start).isValidMove(end)){
			throw new ChessMoveException("start Position or end Position invalid", start, end);
		}
				/*
				this.board.isPiecePresentOnSameColumnBetween(start, end)
				||
				this.board.isPiecePresentOnSameDiagonalBetween(start, end)
				||
				this.board.isPiecePresentOnSameLineBetween(start, end)*/
		//Changement de joueur
		if (getCurrentColor() == Color.WHITE) {
			System.out.println(getBlackPayerName() + " joue ");
			this.currentColor = Color.BLACK;
		}else{
			System.out.println(getWhitePlayerName() + " joue ");
			this.currentColor = Color.WHITE;
		}




		System.out.println();
		this.board.getPiece(start).moveTo(end);

		System.out.println(this.board.toString());
	}

	/**
	 * Programme principal. Permet � deux joueurs de saisir leurs d�placements � tour de r�le, en affichant l'�chiquier apr�s chaque coup.
	 * @param args arguments de ligne de commande, pas utilis�s.
	 * @throws ChessMoveException
	 */
	public static void main(String[] args) throws ChessMoveException {

		Game chessgame = new Game("Nelson", "Alexandre");

		try ( Scanner scanner = new Scanner( System.in ) ) {
			//Scanner scanner = new Scanner( System.in ) ;
            System.out.print( "Veuillez saisir un premier entier : " );
            String move = scanner.next();


            System.out.printf( "La position est %s ", move);
            Position start = new Position(move.substring(0,2));
            Position end = new Position(move.substring(3));
            chessgame.turn(start, end);

        }catch(Exception e){
        	System.out.println(e);
        }

	}

}
