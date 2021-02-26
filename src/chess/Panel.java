package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;
import chess.util.Position;


public class Panel extends JPanel{

	private static final long serialVersionUID = 1L;

	private Game chessgame;

	public Panel(){

		//Création d'un jeu.
		chessgame = new Game("Nelson", "Alexandre");

		//initialiser les composants

		setLayout(null); //change jpanel layout to null

		int taille = 50;

		displayGame(chessgame,40,5,5);

		JLabel label = new JLabel("Veuillez saisir un déplacement : ");
		JTextField textField = new JTextField(5);

		//JTextArea textArea = new JTextArea(15,12);

		label.setBounds(500, taille, 200, 20);
		textField.setBounds(700, taille, 50, 20);

		JTextArea textArea = new JTextArea(1,10);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(500,100,500,350);
		textArea.setLineWrap(true);
		//retrait de la possibilité d'ecrire dans la zone de texte
		textArea.setEditable(false);

		JButton jouer = new JButton("Jouer");

		jouer.setBounds(800, taille, 100, 20);
		jouer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {



				//implémenté ainsi car recommandation d'utilisation de la classe Scanner
				try ( Scanner scanner = new Scanner( textField.getText() ) ) {

					//int nbTours = 0;
					//while(nbTours < 2)
					//{

						System.out.print( "Veuillez saisir un déplacement : " );
			            String move = scanner.next();


			            System.out.printf( "La position est %s ", move);
			            Position start = new Position(move.substring(0,2));
			            Position end = new Position(move.substring(3));
			            chessgame.turn(start, end);

			            chess.util.Color CurrentColor = chess.util.Color.BLACK;
			            String playerName = chessgame.getBlackPayerName();
			            if (chessgame.getCurrentColor() != CurrentColor) {
			            	playerName = chessgame.getWhitePlayerName();
			            }

			            //affichage du message de jeu dans le textArea
			            textArea.append(playerName + " joue " + start.toString() + " en " + end.toString() + "\n");

			            displayGame(chessgame,40,5,380);
			            Toolkit.getDefaultToolkit().sync();

			            //nbTours++;
					//}
			    }catch(Exception e){
			    	textArea.append(e.toString() + "\n");
			        System.out.println(e);

			    }

			}

		});





		add(jouer);

		add(textField);
		add(label);
		add(textArea);

	}

	/**
	 * Fonction d'affichage du jeu.
	 * @param chessgame
	 */
	public void displayGame(Game chessgame, int taille,int X, int Y) {

		//int taille = 50;
		//int X = 5;
		//int Y = 5;

		for(int colonnes=1; colonnes < 9; colonnes++){
			for(int lignes=1; lignes < 9; lignes++){
				//chessgame.getBoard().getPiece(colonnes, lignes).toString()
				String symbol = "";
				if (chessgame.getBoard().getPiece(colonnes, lignes) != null)
					symbol += chessgame.getBoard().getPiece(colonnes, lignes).getSymbol();
				JButton button = new JButton(symbol);

				//button.setFont(new Font("Arial", Font.BOLD, 18));
				//tonBouton.setBounds(int x, int y, int width, int height) définit la position du bouton. pemet de définir la taille et la position du boutton.
				button.setBounds((colonnes * taille) + X, (lignes * taille) + Y, taille, taille);
				add(button);
			}
		}
	}

	/*public void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.BLUE);

			//Font font = new Font("Arial",Font.ITALIC,40);

			int taille = 25;
			int X = 100;
			int Y = 100;
			for(int colonnes=1; colonnes < 9; colonnes++){
				for(int lignes=1; lignes < 9; lignes++){
					g.drawRect((colonnes * taille) + X, (lignes * taille) + Y, taille, taille);
				}
			}


			//g.fillRect(100, 150, taille, taille);


			//g.setFont(font);
			g.drawString("Bonjour", 50, 50);
		}*/


}
