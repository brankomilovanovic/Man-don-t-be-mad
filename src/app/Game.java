package app;

import javax.swing.JButton;

import players.Pawn;
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
	static Pawn pawnRed1 = new Pawn(playerRed1);
	static Pawn pawnRed2 = new Pawn(playerRed2);
	static Pawn pawnRed3 = new Pawn(playerRed3);
	static Pawn pawnRed4 = new Pawn(playerRed4);
	
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
				 if(pawnRed1.isPawnStart() == false && playerRed.getPlayerRollsDiceNumber() == 6 ) {
					  String[] position = Gui.position.get(1).split(",");
					  playerRed1.setBounds(Integer.parseInt(position[0]), Integer.parseInt(position[1]) , 61 , 61);
					  pawnRed1.setPawnStart(true);
					  pawnRed1.setPawnPosition(1);
					  playerRed.setPlayerRollsDiceNumber(0);
				 }
				 else if(pawnRed1.isPawnStart() == false || pawnRed1.getPawnPosition() == 0) {
					  System.out.println("You haven't got number 6 yet!");
				 }
				 
				 try {
					 if(pawnRed1.isPawnParking() == true) {
						 System.out.println("This pawn is in the house, play with another!");
					 }
					 else if(pawnRed1.isPawnStart() == true && pawnRed1.getPawnPosition() > 0) {
						  if(pawnRed1.getPawnPosition() == 44) {
							  pawnRed1.setPawnParking(true);
							  System.out.println("This pawn is in the house, play with another!");
						  }
						  else if(pawnRed1.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() > 44) {
							  System.out.println("You don't have enough fields for this pawn, play with another.");
						  }
						  else if(pawnRed1.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() < 45) {
							  int nextPosition = pawnRed1.getPawnPosition() + playerRed.getPlayerRollsDiceNumber();
							  System.out.println("Choice player red 1! Position: " + nextPosition);
							  String[] currentPosition = Gui.position.get(nextPosition).split(",");
						      playerRed1.setBounds(Integer.parseInt(currentPosition[0]), Integer.parseInt(currentPosition[1]) , 61 , 61);
							  playerRed.setPlayerRollsDiceNumber(0);
							  pawnRed1.setPawnPosition(nextPosition);
						  }  
					 }
				 } 
				 catch(Exception error) {
					 System.out.println("You don't have enough fields for this pawn, play with another.");
				 }
			 }  
		});
	}
	
	//Players RED 2
	public static void playerRed2() throws HeadlessException {
		playerRed2.addActionListener(new ActionListener(){  
			 @Override
			 public void actionPerformed(ActionEvent e){  
				 if(pawnRed2.getPawnPosition() == 0 && playerRed.getPlayerRollsDiceNumber() == 6 ) {
					  String[] position = Gui.position.get(1).split(",");
					  playerRed2.setBounds(Integer.parseInt(position[0]), Integer.parseInt(position[1]) , 61 , 61);
					  pawnRed2.setPawnStart(true);
					  pawnRed2.setPawnPosition(1);
					  playerRed.setPlayerRollsDiceNumber(0);
				 }
				 else if(pawnRed2.isPawnStart() == false || pawnRed2.getPawnPosition() == 0) {
					  System.out.println("You haven't got number 6 yet!");
				 }
				 try {
					 if(pawnRed2.isPawnParking() == true) {
						 System.out.println("This pawn is in the house, play with another!");
					 }
					 else if(pawnRed2.isPawnStart() == true && pawnRed2.getPawnPosition() > 0) {
						  if(pawnRed2.getPawnPosition() == 44) {
							  pawnRed2.setPawnParking(true);
							  System.out.println("This pawn is in the house, play with another!");
						  }
						  else if(pawnRed2.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() > 44) {
							  System.out.println("You don't have enough fields for this pawn, play with another.");
						  }
						  else if(pawnRed2.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() < 45) {
							  int nextPosition = pawnRed2.getPawnPosition() + playerRed.getPlayerRollsDiceNumber();
							  System.out.println("Choice player red 2! Position: " + nextPosition);
							  String[] currentPosition = Gui.position.get(nextPosition).split(",");
						      playerRed2.setBounds(Integer.parseInt(currentPosition[0]), Integer.parseInt(currentPosition[1]) , 61 , 61);
							  playerRed.setPlayerRollsDiceNumber(0);
							  pawnRed2.setPawnPosition(nextPosition);
						  }  
					 }
				 } 
				 catch(Exception error) {
					 System.out.println("You don't have enough fields for this pawn, play with another.");
				 }
			 }  
		});
	}

	//Players RED 3
	public static void playerRed3() throws HeadlessException {
		playerRed3.addActionListener(new ActionListener(){  
			 @Override
			 public void actionPerformed(ActionEvent e){  
				 if(pawnRed3.getPawnPosition() == 0 && playerRed.getPlayerRollsDiceNumber() == 6 ) {
					  String[] position = Gui.position.get(1).split(",");
					  playerRed3.setBounds(Integer.parseInt(position[0]), Integer.parseInt(position[1]) , 61 , 61);
					  pawnRed3.setPawnStart(true);
					  pawnRed3.setPawnPosition(1);
					  playerRed.setPlayerRollsDiceNumber(0);
				 }
				 else if(pawnRed3.isPawnStart() == false || pawnRed3.getPawnPosition() == 0) {
					  System.out.println("You haven't got number 6 yet!");
				 }
				 try {
					 if(pawnRed3.isPawnParking() == true) {
						 System.out.println("This pawn is in the house, play with another!");
					 }
					 else if(pawnRed3.isPawnStart() == true && pawnRed3.getPawnPosition() > 0) {
						  if(pawnRed3.getPawnPosition() == 44) {
							  pawnRed3.setPawnParking(true);
							  System.out.println("This pawn is in the house, play with another!");
						  }
						  else if(pawnRed3.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() > 44) {
							  System.out.println("You don't have enough fields for this pawn, play with another.");
						  }
						  else if(pawnRed3.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() < 45) {
							  int nextPosition = pawnRed3.getPawnPosition() + playerRed.getPlayerRollsDiceNumber();
							  System.out.println("Choice player red 3! Position: " + nextPosition);
							  String[] currentPosition = Gui.position.get(nextPosition).split(",");
							  playerRed3.setBounds(Integer.parseInt(currentPosition[0]), Integer.parseInt(currentPosition[1]) , 61 , 61);
							  playerRed.setPlayerRollsDiceNumber(0);
							  pawnRed3.setPawnPosition(nextPosition);
						  }  
					 }
				 } 
				 catch(Exception error) {
					 System.out.println("You don't have enough fields for this pawn, play with another.");
				 }
			 }  
		});
	}
	
	//Players RED 4
	public static void playerRed4() throws HeadlessException {
		playerRed4.addActionListener(new ActionListener(){  
			 @Override
			 public void actionPerformed(ActionEvent e){  
				 if(pawnRed4.getPawnPosition() == 0 && playerRed.getPlayerRollsDiceNumber() == 6 ) {
					  String[] position = Gui.position.get(1).split(",");
					  playerRed4.setBounds(Integer.parseInt(position[0]), Integer.parseInt(position[1]) , 61 , 61);
					  pawnRed4.setPawnStart(true);
					  pawnRed4.setPawnPosition(1);
					  playerRed.setPlayerRollsDiceNumber(0);
				 }
				 else if(pawnRed4.isPawnStart() == false || pawnRed4.getPawnPosition() == 0) {
					  System.out.println("You haven't got number 6 yet!");
				 }
				 try {
					 if(pawnRed4.isPawnParking() == true) {
						 System.out.println("This pawn is in the house, play with another!");
					 }
					 else if(pawnRed4.isPawnStart() == true && pawnRed4.getPawnPosition() > 0) {
						  if(pawnRed4.getPawnPosition() == 44) {
							  pawnRed4.setPawnParking(true);
							  System.out.println("This pawn is in the house, play with another!");
						  }
						  else if(pawnRed4.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() > 44) {
							  System.out.println("You don't have enough fields for this pawn, play with another.");
						  }
						  else if(pawnRed4.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() < 45) {
							  int nextPosition = pawnRed4.getPawnPosition() + playerRed.getPlayerRollsDiceNumber();
							  System.out.println("Choice player red 4! Position: " + nextPosition);
							  String[] currentPosition = Gui.position.get(nextPosition).split(",");
							  playerRed4.setBounds(Integer.parseInt(currentPosition[0]), Integer.parseInt(currentPosition[1]) , 61 , 61);
							  playerRed.setPlayerRollsDiceNumber(0);
							  pawnRed4.setPawnPosition(nextPosition);
						  }  
					 }
				 } 
				 catch(Exception error) {
					 System.out.println("You don't have enough fields for this pawn, play with another.");
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
