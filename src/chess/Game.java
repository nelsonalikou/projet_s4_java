/**
 *
 */
package chess;

import chess.util.Color;

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
	private Color currentColor;

	/**
	 * Constructeur.
	 * @param whitePlayerName nom du joueur ayant les pi�ces blanches
	 * @param blackPayerName nom du joueur ayant les pi�ces noires
	 */
	public Game(String whitePlayerName, String blackPayerName){
		this.blackPayerName = blackPayerName;
		this.whitePlayerName = whitePlayerName;
		this.board = new Chessboard();
	}

}
