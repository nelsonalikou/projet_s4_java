package chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Scanner;

import chess.util.*;
import chess.pieces.*;
import javax.swing.*;

public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;

	private Game chessgame;

	public Frame(String title){
		setTitle(title);


		final JPanel panel = new JPanel();


		chessgame = new Game("Nelson", "Alexandre");

		//initialiser les composants


		panel.setLayout(null); //change jpanel layout to null : TRES IMPORTATNT

		int taille = 50;

		displayGame(panel,chessgame,taille,5,50);


		JTextField textField = new JTextField(5);
		textField.setBounds(700, taille, 50, 20);


		JTextArea textArea = new JTextArea(1,10);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(500,125,500,350);
		textArea.setLineWrap(true);
		//retrait de la possibilité d'ecrire dans la zone de texte
		textArea.setEditable(false);

		JButton jouer = new JButton("Jouer");
		//JComboBox<String> historique = new JComboBox<String>();
		final JPanel entete = new JPanel();
		final JButton startGame = new JButton("Start");
		entete.add(startGame);
		JComboBox<String> historique = new JComboBox<String>();


		jouer.setBounds(800, taille + 35, 100, 20);
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

			            //Supprimer tout le contenu du panel
			            panel.removeAll();

			            //jouer le son
						new Audio("sound\\\\chess_move_sound.wav");
						//historique.removeAllItems();
						/*for (Piece piece : chessgame.historique.keySet()){

			    			historique.addItem(piece.getPosition().toAlgebraicNotation() + " " + end.toString());
			    		}*/
						if(chessgame.historique.get(chessgame.getBoard().getPiece(new Position(end.toAlgebraicNotation()))) != null){
							historique.addItem(start.toString() + end.toString());
						}
			            /*historique.addItemListener(new ItemListener(){
							@Override
							public void itemStateChanged(ItemEvent arg0) {
								if(arg0.getStateChange() == ItemEvent.SELECTED){
									String val = historique.getSelectedItem().toString();
									chessgame.setBoard(chessgame.historique.get(chessgame.getBoard().getPiece(new Position(val)))) ;
								}

							}
			            });*/
			            historique.addActionListener(new ActionListener(){

							@Override
							public void actionPerformed(ActionEvent arg0) {
								String val = historique.getSelectedItem().toString().substring(4);
								System.out.println(val);

								chessgame.setBoard(chessgame.historique.get(chessgame.getBoard().getPiece(new Position(val)))) ;
								System.out.println(chessgame.getBoard().toString());
							}

			            });
			    		entete.add(historique);



			            //afficher le nouveau plateau
			            displayGame(panel,chessgame,50,5,50);


			            /*JTextField textField = new JTextField(5);
			    		textField.setBounds(700, taille, 50, 20);*/

			            //Vider le contenu de la zone de texte
			    		textField.setText("");
			    		panel.add(textField);

			    		panel.add(textArea);

						panel.repaint();
						panel.revalidate();

			            //nbTours++;
					//}
			    }catch(Exception e){
			    	textArea.append(e.toString() + "\n");
			        System.out.println(e);

			    }

			}

		});


		//Redémarrage du jeu erreur de rafraichissement, mais redevient normal apres le premier coup
		startGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//new Audio("sound\\\\chess_move_sound.wav");
				chessgame = new Game("Nelson", "Alexandre");
	            displayGame(panel,chessgame,50,5,50);
	            panel.repaint();
				panel.revalidate();
			}
		});


		this.add(jouer);
		panel.add(textField);


		this.add(textArea);




		//AudioClip click;

		final JLabel histo = new JLabel("Historique");

		entete.add(histo);

		this.add(panel);
		this.add(entete,BorderLayout.NORTH);

		this.setSize(1200,700);
		//this.pack();
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//setLocationRelativeTo(null);
		//setVisible(true);

		//this.add(new Panel());
	}







	/**
	 * Fonction d'affichage du jeu.
	 * @param chessgame
	 * @param taille
	 * @param X
	 * @param Y
	 */
	public void displayGame(JPanel panel, Game chessgame, int taille,int X, int Y) {

		//int taille = 50;
		//int X = 5;
		//int Y = 5;
		int max = taille * 8;
		int nb_lignes_colonnes = 9;
		int recadrage = 10;
		//Taille des différents lables autour du chessboard.
		int chessLabel = 20;

		//Tableau des lettres devant apparaitre sur l'echiquier
		char[] lettres = {'A','B','C','D','E','F','G','H'};

		for(int colonnes=0; colonnes < nb_lignes_colonnes-1; colonnes++){
			JLabel monLabel = new JLabel("" + lettres[colonnes]);
			monLabel.setBounds(taille * colonnes + taille + (recadrage*2), taille /2, chessLabel, chessLabel);
			panel.add(monLabel);
		}


		for(int colonnes=1; colonnes < nb_lignes_colonnes; colonnes++){

			String lab = "" + (nb_lignes_colonnes - colonnes);
			JLabel monLabel = new JLabel(lab);
			monLabel.setBounds(taille - recadrage, taille * colonnes + recadrage , chessLabel, chessLabel);
			panel.add(monLabel);

			for(int lignes=1; lignes < nb_lignes_colonnes; lignes++){
				//chessgame.getBoard().getPiece(colonnes, lignes).toString()
				String symbol = "";
				if (chessgame.getBoard().getPiece(colonnes-1, lignes-1) != null){
					symbol += chessgame.getBoard().getPiece(colonnes-1, lignes-1).getSymbol();
				}
				JButton button = new JButton(symbol);
				if ((lignes % 2 == 0 && colonnes % 2 == 0) || (lignes % 2 != 0 && colonnes % 2 != 0)){
					button.setBackground(Color.LIGHT_GRAY);
				}else{
					button.setBackground(Color.WHITE);
				}

				//button.setFont(new Font("Arial", Font.BOLD, 18));
				//tonBouton.setBounds(int x, int y, int width, int height) définit la position du bouton. pemet de définir la taille et la position du boutton.
				button.setBounds((colonnes * taille) + X, max - (lignes * taille) + Y, taille, taille);
				panel.add(button);
			}
			JLabel monLabel2 = new JLabel(lab);
			monLabel2.setBounds((taille * nb_lignes_colonnes) + recadrage, taille * colonnes + recadrage, chessLabel, chessLabel);
			panel.add(monLabel2);
		}


		for(int colonnes=0; colonnes < nb_lignes_colonnes-1; colonnes++){
			JLabel monLabel = new JLabel("" + lettres[colonnes]);
			monLabel.setBounds(taille * colonnes + taille + (recadrage*2),(taille * nb_lignes_colonnes) + recadrage, chessLabel, chessLabel);
			panel.add(monLabel);
		}




		JLabel label = new JLabel("Veuillez saisir un déplacement : ");

		//JTextArea textArea = new JTextArea(15,12);

		label.setBounds(500, taille, 200, 20);

		panel.add(label);

	}

	//public JTextField createTextField(){}


	/*final JPanel panel = new JPanel();
	panel.add(new JTextField("Je suis vivant",JLabel.CENTER));
	panel.add(new JTextField("Moi aussi",JLabel.CENTER));
	this.add(panel,BorderLayout.NORTH);

	final JButton button = new JButton("Tuer");
	this.add(button,BorderLayout.SOUTH);

	button.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			panel.removeAll();
			panel.repaint();
			panel.add(new JTextField("Moi aussi",JLabel.CENTER));
			panel.revalidate();
			panel.repaint();


		}
	});
	*/

}
