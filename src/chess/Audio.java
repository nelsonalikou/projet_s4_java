package chess;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Audio extends Thread{

    public static void main(String[] args){
    	new Audio("sound\\\\chess_move_sound.wav");
    }



    public Audio(String filePath){
    	InputStream music;
    	try{
    		music =  new FileInputStream(new File(filePath));
    		AudioStream sound = new AudioStream(music);
    		AudioPlayer.player.start(sound);
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null,"error");
    	}

    }

}
