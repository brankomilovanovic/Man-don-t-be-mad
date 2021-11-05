package app;

import javax.swing.JButton;

import players.Player;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends Gui {
	
	static Gui gui = new Gui();
	
	//Get dice
	static JButton buttonDice = gui.getButtonDice();
	
	//Get players pawn RED
	static JButton playerRed1 = gui.getPlayerRed1();
	static JButton playerRed2 = gui.getPlayerRed2();
	static JButton playerRed3 = gui.getPlayerRed3();
	static JButton playerRed4 = gui.getPlayerRed4();
	
	//Get players pawn BLUE
	static JButton playerBlue1 = gui.getPlayerBlue1();
	static JButton playerBlue2 = gui.getPlayerBlue2();
	static JButton playerBlue3 = gui.getPlayerBlue3();
	static JButton playerBlue4 = gui.getPlayerBlue4();
	
	//Player RED
	static Player playerRed = new Player();
	
	//Player BLUE
	static Player playerBlue = new Player();
	
	public static void rollsDice() throws HeadlessException {
		buttonDice.addActionListener(new ActionListener(){  
			 @Override
			 public void actionPerformed(ActionEvent e){  
				 Random random = new Random();
				 int randomNumber = random.nextInt(6) + 1;
				 System.out.println("Rolls dice! Number: " + randomNumber);
				 playerRed.setPlayerRollsDiceNumber(randomNumber);
			 }  
		});
	}
	
	//Players RED 1
	public static void playerRed1() throws HeadlessException {
		playerRed1.addActionListener(new ActionListener(){  
			 @Override
			 public void actionPerformed(ActionEvent e){  
				 if(playerRed.getPlayerRollsDiceNumber() == 6) {
					  System.out.println("Choice player red 1!");
					  String[] position = Gui.position.get(1).split(",");
					  playerRed1.setBounds(Integer.parseInt(position[0]), Integer.parseInt(position[1]) , 61 , 61);
					  playerRed.setPlayerStart(true);
					  playerRed.setPlayerRollsDiceNumber(0);
				 }
				 else if(playerRed.isPlayerStart() == false || playerRed.getPlayerRollsDiceNumber() != 6) {
					 System.out.println("You haven't got number 6 yet!");
				 }
			 }  
		});
	}
	
	//Players RED 2
	public static void playerRed2() throws HeadlessException {
		playerRed2.addActionListener(new ActionListener(){  
			 @Override
			 public void actionPerformed(ActionEvent e){  
				 if(playerRed.getPlayerRollsDiceNumber() == 6) {
					  System.out.println("Choice player red 2!");
					  String[] position = Gui.position.get(1).split(",");
					  playerRed2.setBounds(Integer.parseInt(position[0]), Integer.parseInt(position[1]) , 61 , 61);
					  playerRed.setPlayerStart(true);
					  playerRed.setPlayerRollsDiceNumber(0);
				 }
				 else if(playerRed.isPlayerStart() == false || playerRed.getPlayerRollsDiceNumber() != 6) {
					 System.out.println("You haven't got number 6 yet!");
				 }
				 
			 }  
		});
	}
	
	//Players RED 3
	public static void playerRed3() throws HeadlessException {
		playerRed3.addActionListener(new ActionListener(){  
			 @Override
			 public void actionPerformed(ActionEvent e){  
				 if(playerRed.getPlayerRollsDiceNumber() == 6) {
					  System.out.println("Choice player red 3!");
					  String[] position = Gui.position.get(1).split(",");
					  playerRed3.setBounds(Integer.parseInt(position[0]), Integer.parseInt(position[1]) , 61 , 61);
					  playerRed.setPlayerStart(true);
					  playerRed.setPlayerRollsDiceNumber(0);
				 }
				 else if(playerRed.isPlayerStart() == false || playerRed.getPlayerRollsDiceNumber() != 6) {
					 System.out.println("You haven't got number 6 yet!");
				 }
			 }  
		});
	}
	
	//Players RED 4
	public static void playerRed4() throws HeadlessException {
		playerRed4.addActionListener(new ActionListener(){  
			 @Override
			 public void actionPerformed(ActionEvent e){
				 if(playerRed.getPlayerRollsDiceNumber() == 6) {
					 System.out.println("Choice player red 4!");
					 String[] position = Gui.position.get(1).split(",");
					 playerRed4.setBounds(Integer.parseInt(position[0]), Integer.parseInt(position[1]) , 61 , 61);
					 playerRed.setPlayerStart(true);
					 playerRed.setPlayerRollsDiceNumber(0);
				 }
				 else if(playerRed.isPlayerStart() == false  || playerRed.getPlayerRollsDiceNumber() != 6) {
					 System.out.println("You haven't got number 6 yet!");
				 } 
			 }  
		});
	}
	
	//Players BLUE
	public static void playerBlue1() throws HeadlessException {
		playerBlue1.addActionListener(new ActionListener(){  
			@Override
			 public void actionPerformed(ActionEvent e){  
				 System.out.println("Choice player blue 1!");
			 }  
		});
	}
	
	public static void playerBlue2() throws HeadlessException {
		playerBlue2.addActionListener(new ActionListener(){  
			@Override
			 public void actionPerformed(ActionEvent e){  
				 System.out.println("Choice player blue 2!");
			 }  
		});
	}
	
	public static void playerBlue3() throws HeadlessException {
		playerBlue3.addActionListener(new ActionListener(){  
			@Override
			 public void actionPerformed(ActionEvent e){  
				 System.out.println("Choice player blue 3!");
			 }  
		});
	}
	
	public static void playerBlue4() throws HeadlessException {
		playerBlue4.addActionListener(new ActionListener(){  
			@Override
			 public void actionPerformed(ActionEvent e){  
				 System.out.println("Choice player blue 4!");
			 }  
		});
	}
}
