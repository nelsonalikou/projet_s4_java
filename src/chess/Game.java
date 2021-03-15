/**
 *
 */
package chess;

import java.util.HashMap;

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
	private Color currentColor = Color.WHITE;

	/**
	 * Historique des dépalcements.
	 */
	private HashMap<Piece,Chessboard> historique;

	/**
	 * Constructeur.
	 * @param whitePlayerName nom du joueur ayant les pi�ces blanches
	 * @param blackPayerName nom du joueur ayant les pi�ces noires
	 */
	public Game(String whitePlayerName, String blackPayerName){
		this.blackPayerName = blackPayerName;
		this.whitePlayerName = whitePlayerName;

		this.board = new Chessboard();
		this.board.createPieces();

		historique = new HashMap<>();

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

		Piece piece_a_bouger = this.board.getPiece(start);
		if(piece_a_bouger == null)
		{
			throw new ChessMoveException("no chess piece here", start, end);
		}else if(!(getCurrentColor() == this.board.getPiece(start).getColor())){
			System.out.println(this.board.getPiece(start).getColor());
			throw new ChessMoveException("It'is not your turn", start, end);
		}else if(!this.board.getPiece(start).isValidMove(end)){
			throw new ChessMoveException("start Position or end Position invalid", start, end);
		}

		// Intégration du mouvement dans l'historique
		historique.put(piece_a_bouger, this.board);

		//Changement de joueur
		if (getCurrentColor() == Color.WHITE) {
			System.out.print(getBlackPayerName() + " joue ");
			this.currentColor = Color.BLACK;
		}else{
			System.out.print(getWhitePlayerName() + " joue ");
			this.currentColor = Color.WHITE;
		}

		System.out.println(start.toString() + " en" + end.toString());

		System.out.println("Historique des déplacements");
		for (Piece key : historique.keySet())
			System.out.println(key.toString());
		/*for (Chessboard color : historique.values())
			System.out.println("Valeur : " + color);*/




		System.out.println();
		this.board.getPiece(start).moveTo(end);

		System.out.println(this.board.toString());
	}

	public Chessboard getBoard(){
		return this.board;
	}

	/**
	 * Programme principal. Permet � deux joueurs de saisir leurs d�placements � tour de r�le, en affichant l'�chiquier apr�s chaque coup.
	 * @param args arguments de ligne de commande, pas utilis�s.
	 * @throws ChessMoveException
	 */
	/*public static void main(String[] args) throws ChessMoveException {

		Game chessgame = new Game("Nelson", "Alexandre");

		try ( Scanner scanner = new Scanner( System.in ) ) {
			//Scanner scanner = new Scanner( System.in ) ;
			int nbTours = 0;
			while(nbTours < 5)
			{

				System.out.print( "Veuillez saisir un déplacement : " );
	            String move = scanner.next();


	            System.out.printf( "La position est %s ", move);
	            Position start = new Position(move.substring(0,2));
	            Position end = new Position(move.substring(3));
	            chessgame.turn(start, end);

	            nbTours++;
			}
	    }catch(Exception e){
	        System.out.println(e);

	    }


	}*/

}
