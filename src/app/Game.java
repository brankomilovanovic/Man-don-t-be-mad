package app;

import javax.swing.JButton;
import javax.swing.JLabel;

import characters.Pawn;
import characters.Player;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends Gui {
	
	static Gui gui = new Gui();
	
	//Get dice
	static JButton buttonDice = gui.getButtonDice();
	//Text under dice
	static JLabel currentPlayerRollsDice = gui.getCurrentPlayerRollsDice();
	
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
				 if(playerRed.getPlayerRollsDiceNext() == true) {
					 int randomNumber = random.nextInt(6) + 1;
					 System.out.println("Red player rolls dice! Number: " + randomNumber);
					 if(randomNumber == 1) {
						 buttonDice.setText("<html>•");
					 }
					 else if(randomNumber == 2) {
						 buttonDice.setText("<html>•<br><br>⠀⠀⠀•<br>");
					 }
					 else if(randomNumber == 3) {
						 buttonDice.setText("<html>•⠀⠀<br>  •<br>⠀⠀⠀•<br>");
					 }
					 else if(randomNumber == 4) {
						 buttonDice.setText("<html>•⠀⠀•<br><br>•⠀⠀•<br>");
					 }
					 else if(randomNumber == 5) {
						 buttonDice.setText("<html>•⠀⠀•<br>  •<br>•⠀⠀•<br>");
					 }
					 else if(randomNumber == 6) {
						 buttonDice.setText("<html>• • •<br>• • •<br>• • •<br>");
					 }
					 playerRed.setPlayerRollsDiceNumber(randomNumber);
					 playerRed.setPlayerRollsDiceNext(true);
					 //playerBlue.setPlayerRollsDiceNext(true); remove for testing
					 currentPlayerRollsDice.setText("<html>RED player got the number: "+randomNumber+"<br><br>The player is currently playing:<br>- Player BLUE -<br>PRESS THE DICE!!!");
				 }
				 else if(playerBlue.getPlayerRollsDiceNext() == true) {
					 int randomNumber = random.nextInt(6) + 1;
					 System.out.println("Blue player rolls dice! Number: " + randomNumber);
					 if(randomNumber == 1) {
						 buttonDice.setText("<html>•");
					 }
					 else if(randomNumber == 2) {
						 buttonDice.setText("<html>•<br><br>⠀⠀⠀•<br>");
					 }
					 else if(randomNumber == 3) {
						 buttonDice.setText("<html>•⠀⠀<br>  •<br>⠀⠀⠀•<br>");
					 }
					 else if(randomNumber == 4) {
						 buttonDice.setText("<html>•⠀⠀•<br><br>•⠀⠀•<br>");
					 }
					 else if(randomNumber == 5) {
						 buttonDice.setText("<html>•⠀⠀•<br>  •<br>•⠀⠀•<br>");
					 }
					 else if(randomNumber == 6) {
						 buttonDice.setText("<html>• • •<br>• • •<br>• • •<br>");
					 }
					 playerBlue.setPlayerRollsDiceNumber(randomNumber);
					 playerBlue.setPlayerRollsDiceNext(false);
					 playerRed.setPlayerRollsDiceNext(true);
					 currentPlayerRollsDice.setText("<html>BLUE player got the number: "+randomNumber+"<br><br>The player is currently playing:<br>- Player RED -<br>PRESS THE DICE!!!");
				 }
			 }  
		});
	}
	
	//Players RED 1
	public static void playerRed1() throws HeadlessException {
		playerRed1.addActionListener(new ActionListener(){  
			 @Override
			 public void actionPerformed(ActionEvent e){
				 //Check that it meets the conditions for start
				 if(pawnRed1.getPawnPosition() == 0 && playerRed.getPlayerRollsDiceNumber() == 6 ) {
					  String[] position = Gui.position.get(1).split(",");
					  playerRed1.setBounds(Integer.parseInt(position[0]), Integer.parseInt(position[1]) , 61 , 61);
					  pawnRed1.setPawnStart(true);
					  pawnRed1.setPawnPosition(1);
					  playerRed.setPlayerRollsDiceNumber(0);
				 }
				 else if(pawnRed1.isPawnStart() == false || pawnRed1.getPawnPosition() == 0) {
					  System.out.println("You haven't got number 6 yet!");
				 }
				 
				 //Check empty position in the house
				 if((pawnRed2.getPawnParkingPosition() == 44 && pawnRed2.isPawnParking() == true) || (pawnRed3.getPawnParkingPosition() == 44 && pawnRed3.isPawnParking() == true) || (pawnRed4.getPawnParkingPosition() == 44 && pawnRed4.isPawnParking() == true)) {
					 if(pawnRed1.isPawnParking() == false) {
						 pawnRed1.setPawnParkingPosition(43); 
					 }	
				 }
				 
				 if((pawnRed2.getPawnParkingPosition() == 43 && pawnRed2.isPawnParking() == true) || (pawnRed3.getPawnParkingPosition() == 43 && pawnRed3.isPawnParking() == true) || (pawnRed4.getPawnParkingPosition() == 43 && pawnRed4.isPawnParking() == true)) {
					 if(pawnRed1.isPawnParking() == false) {
						 pawnRed1.setPawnParkingPosition(42); 
					 }
				 }
				 
				 if((pawnRed2.getPawnParkingPosition() == 42 && pawnRed2.isPawnParking() == true) || (pawnRed3.getPawnParkingPosition() == 42 && pawnRed3.isPawnParking() == true) || (pawnRed4.getPawnParkingPosition() == 42 && pawnRed4.isPawnParking() == true)) {
					 if(pawnRed1.isPawnParking() == false) {
						 pawnRed1.setPawnParkingPosition(41); 
					 }
				 }
				 
				 //Pawn set on next position
				 try {
					 if(pawnRed1.isPawnStart() == true && pawnRed1.getPawnPosition() > 0) {
						  if(pawnInHousePositionRed1() == false) {
							  if(pawnRed1.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() <= pawnRed1.getPawnParkingPosition()) {
								  int nextPosition = pawnRed1.getPawnPosition() + playerRed.getPlayerRollsDiceNumber();
								  System.out.println("Choice player red 1! Position: " + nextPosition + ", house position: " + pawnRed1.getPawnParkingPosition());
								  String[] currentPosition = Gui.position.get(nextPosition).split(",");
								  playerRed1.setBounds(Integer.parseInt(currentPosition[0]), Integer.parseInt(currentPosition[1]) , 61 , 61);
								  playerRed.setPlayerRollsDiceNumber(0);
								  pawnRed1.setPawnPosition(nextPosition);
							  }
							  else if (pawnRed1.getPawnPosition() == pawnRed1.getPawnParkingPosition()) { //If the pawn is in the house not to throw out an error message for the fields
								  System.out.println("This pawn 1 is in the house, play with another!");
							  } 
							  else if (pawnRed1.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() > pawnRed1.getPawnParkingPosition()) {
								  System.out.println("You don't have enough fields for this pawn or there is someone in that house, play with another.");
							  }
							  
							  if(pawnRed1.getPawnPosition() == pawnRed1.getPawnParkingPosition() && pawnRed1.isPawnParking() == false) {
								  pawnRed1.setPawnParking(true);
								  System.out.println("This pawn 1 is in the house, play with another!");
							  }
						  } else {
							  System.out.println("You don't have enough fields for this pawn or there is someone in that house, play with another.");
						  }
					 }
				 }
				 
				 catch(Exception error) {
					 System.out.println("You don't have enough fields for this pawn, play with another. ERROR!");
				 }
				 //Check if there is already a pawn in the house and fill in the first place to check other positions
				 positionInHouseCheckForRed1();
			 }  
		});
	}
	
	//Players RED 2
	public static void playerRed2() throws HeadlessException {
		playerRed2.addActionListener(new ActionListener(){  
			 @Override
			 public void actionPerformed(ActionEvent e){
				 //Check that it meets the conditions for start
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
				 
				 //Check empty position in the house
				 if((pawnRed1.getPawnParkingPosition() == 44 && pawnRed1.isPawnParking() == true) || (pawnRed3.getPawnParkingPosition() == 44 && pawnRed3.isPawnParking() == true) || (pawnRed4.getPawnParkingPosition() == 44 && pawnRed4.isPawnParking() == true)) {
					 if(pawnRed2.isPawnParking() == false) {
						 pawnRed2.setPawnParkingPosition(43); 
					 }	
				 }
				 
				 if((pawnRed1.getPawnParkingPosition() == 43 && pawnRed1.isPawnParking() == true) || (pawnRed3.getPawnParkingPosition() == 43 && pawnRed3.isPawnParking() == true) || (pawnRed4.getPawnParkingPosition() == 43 && pawnRed4.isPawnParking() == true)) {
					 if(pawnRed2.isPawnParking() == false) {
						 pawnRed2.setPawnParkingPosition(42); 
					 }
				 }
				 
				 if((pawnRed1.getPawnParkingPosition() == 42 && pawnRed1.isPawnParking() == true) || (pawnRed3.getPawnParkingPosition() == 42 && pawnRed3.isPawnParking() == true) || (pawnRed4.getPawnParkingPosition() == 42 && pawnRed4.isPawnParking() == true)) {
					 if(pawnRed2.isPawnParking() == false) {
						 pawnRed2.setPawnParkingPosition(41); 
					 }
				 }
				 
				 //Pawn set on next position
				 try {
					 if(pawnRed2.isPawnStart() == true && pawnRed2.getPawnPosition() > 0) {
						  if(pawnInHousePositionRed2() == false) {
							  if(pawnRed2.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() <= pawnRed2.getPawnParkingPosition()) {
								  int nextPosition = pawnRed2.getPawnPosition() + playerRed.getPlayerRollsDiceNumber();
								  System.out.println("Choice player red 2! Position: " + nextPosition + ", house position: " + pawnRed2.getPawnParkingPosition());
								  String[] currentPosition = Gui.position.get(nextPosition).split(",");
								  playerRed2.setBounds(Integer.parseInt(currentPosition[0]), Integer.parseInt(currentPosition[1]) , 61 , 61);
								  playerRed.setPlayerRollsDiceNumber(0);
								  pawnRed2.setPawnPosition(nextPosition);
							  }
							  else if (pawnRed2.getPawnPosition() == pawnRed2.getPawnParkingPosition()) { //If the pawn is in the house not to throw out an error message for the fields
								  System.out.println("This pawn 2 is in the house, play with another!");
							  } 
							  else if (pawnRed2.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() > pawnRed2.getPawnParkingPosition()) {
								  System.out.println("You don't have enough fields for this pawn or there is someone in that house, play with another.");
							  }
							  
							  if(pawnRed2.getPawnPosition() == pawnRed2.getPawnParkingPosition() && pawnRed2.isPawnParking() == false) {
								  pawnRed2.setPawnParking(true);
								  //pawnRed2.setPawnParkingPosition(pawnRed2.getPawnParkingPosition());
								  System.out.println("This pawn 2 is in the house, play with another!");
							  }
						  } else {
							  System.out.println("You don't have enough fields for this pawn or there is someone in that house, play with another.");
						  }
					 }
				 }
				 catch(Exception error) {
					 System.out.println("You don't have enough fields for this pawn, play with another. ERROR!");
				 }
				//Check if there is already a pawn in the house and fill in the first place to check other positions
				 positionInHouseCheckForRed2();
			 }  
		});
	}

	//Players RED 3
	public static void playerRed3() throws HeadlessException {
		playerRed3.addActionListener(new ActionListener(){  
			 @Override
			 public void actionPerformed(ActionEvent e){
				 //Check that it meets the conditions for start
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
						 
				 //Check empty position in the house
				 if((pawnRed1.getPawnParkingPosition() == 44 && pawnRed1.isPawnParking() == true) || (pawnRed2.getPawnParkingPosition() == 44 && pawnRed2.isPawnParking() == true) || (pawnRed4.getPawnParkingPosition() == 44 && pawnRed4.isPawnParking() == true)) {
					 if(pawnRed3.isPawnParking() == false) {
						 pawnRed3.setPawnParkingPosition(43); 
					 }	
				 }
				 
				 if((pawnRed1.getPawnParkingPosition() == 43 && pawnRed1.isPawnParking() == true) || (pawnRed2.getPawnParkingPosition() == 43 && pawnRed2.isPawnParking() == true) || (pawnRed4.getPawnParkingPosition() == 43 && pawnRed4.isPawnParking() == true)) {
					 if(pawnRed3.isPawnParking() == false) {
						 pawnRed3.setPawnParkingPosition(42); 
					 }
				 }
				 
				 if((pawnRed1.getPawnParkingPosition() == 42 && pawnRed1.isPawnParking() == true) || (pawnRed2.getPawnParkingPosition() == 42 && pawnRed2.isPawnParking() == true) || (pawnRed4.getPawnParkingPosition() == 42 && pawnRed4.isPawnParking() == true)) {
					 if(pawnRed3.isPawnParking() == false) {
						 pawnRed3.setPawnParkingPosition(41); 
					 }
				 }
				 
				 //Pawn set on next position
				 try {
					 if(pawnRed3.isPawnStart() == true && pawnRed3.getPawnPosition() > 0) {
						  if(pawnInHousePositionRed3() == false) {
							  if(pawnRed3.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() <= pawnRed3.getPawnParkingPosition()) {
								  int nextPosition = pawnRed3.getPawnPosition() + playerRed.getPlayerRollsDiceNumber();
								  System.out.println("Choice player red 3! Position: " + nextPosition + ", house position: " + pawnRed3.getPawnParkingPosition());
								  String[] currentPosition = Gui.position.get(nextPosition).split(",");
								  playerRed3.setBounds(Integer.parseInt(currentPosition[0]), Integer.parseInt(currentPosition[1]) , 61 , 61);
								  playerRed.setPlayerRollsDiceNumber(0);
								  pawnRed3.setPawnPosition(nextPosition);
							  }
							  else if (pawnRed3.getPawnPosition() == pawnRed3.getPawnParkingPosition()) { //If the pawn is in the house not to throw out an error message for the fields
								  System.out.println("This pawn 3 is in the house, play with another!");
							  } 
							  else if (pawnRed3.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() > pawnRed3.getPawnParkingPosition()) {
								  System.out.println("You don't have enough fields for this pawn or there is someone in that house, play with another.");
							  }
							  
							  if(pawnRed3.getPawnPosition() == pawnRed3.getPawnParkingPosition() && pawnRed3.isPawnParking() == false) {
								  pawnRed3.setPawnParking(true);
								  //pawnRed3.setPawnParkingPosition(pawnRed3.getPawnParkingPosition());
								  System.out.println("This pawn 3 is in the house, play with another!");
							  }
						  } else {
							  System.out.println("You don't have enough fields for this pawn or there is someone in that house, play with another.");
						  }
					 }
				 }
				 catch(Exception error) {
					 System.out.println("You don't have enough fields for this pawn, play with another. ERROR!");
				 }
				 
			     //Check if there is already a pawn in the house and fill in the first place to check other positions
			     positionInHouseCheckForRed3();
			 } 
		});
	}
	
	//Players RED 4
	public static void playerRed4() throws HeadlessException {
		playerRed4.addActionListener(new ActionListener(){  
			 @Override
			 public void actionPerformed(ActionEvent e){
				 //Check that it meets the conditions for start
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
				 
				//Check empty position in the house
				 if((pawnRed1.getPawnParkingPosition() == 44 && pawnRed1.isPawnParking() == true) || (pawnRed2.getPawnParkingPosition() == 44 && pawnRed2.isPawnParking() == true) || (pawnRed3.getPawnParkingPosition() == 44 && pawnRed3.isPawnParking() == true)) {
					 if(pawnRed4.isPawnParking() == false) {
						 pawnRed4.setPawnParkingPosition(43); 
					 }	
				 }
				 
				 if((pawnRed1.getPawnParkingPosition() == 43 && pawnRed1.isPawnParking() == true) || (pawnRed2.getPawnParkingPosition() == 43 && pawnRed2.isPawnParking() == true) || (pawnRed3.getPawnParkingPosition() == 43 && pawnRed3.isPawnParking() == true)) {
					 if(pawnRed4.isPawnParking() == false) {
						 pawnRed4.setPawnParkingPosition(42); 
					 }
				 }
				 
				 if((pawnRed1.getPawnParkingPosition() == 42 && pawnRed1.isPawnParking() == true) || (pawnRed2.getPawnParkingPosition() == 42 && pawnRed2.isPawnParking() == true) || (pawnRed3.getPawnParkingPosition() == 42 && pawnRed3.isPawnParking() == true)) {
					 if(pawnRed4.isPawnParking() == false) {
						 pawnRed4.setPawnParkingPosition(41); 
					 }
				 }
				 
				//Pawn set on next position
				 try {
					 if(pawnRed4.isPawnStart() == true && pawnRed4.getPawnPosition() > 0) {
						  if(pawnInHousePositionRed4() == false) {
							  if(pawnRed4.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() <= pawnRed4.getPawnParkingPosition()) {
								  int nextPosition = pawnRed4.getPawnPosition() + playerRed.getPlayerRollsDiceNumber();
								  System.out.println("Choice player red 4! Position: " + nextPosition + ", house position: " + pawnRed4.getPawnParkingPosition());
								  String[] currentPosition = Gui.position.get(nextPosition).split(",");
								  playerRed4.setBounds(Integer.parseInt(currentPosition[0]), Integer.parseInt(currentPosition[1]) , 61 , 61);
								  playerRed.setPlayerRollsDiceNumber(0);
								  pawnRed4.setPawnPosition(nextPosition);
							  }
							  else if (pawnRed4.getPawnPosition() == pawnRed4.getPawnParkingPosition()) { //If the pawn is in the house not to throw out an error message for the fields
								  System.out.println("This pawn 4 is in the house, play with another!");
							  } 
							  else if (pawnRed4.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() > pawnRed4.getPawnParkingPosition()) {
								  System.out.println("You don't have enough fields for this pawn or there is someone in that house, play with another.");
							  }
							  
							  if(pawnRed4.getPawnPosition() == pawnRed4.getPawnParkingPosition() && pawnRed4.isPawnParking() == false) {
								  pawnRed4.setPawnParking(true);
						          System.out.println("This pawn 4 is in the house, play with another!");
							  }
						  } else {
							  System.out.println("You don't have enough fields for this pawn or there is someone in that house, play with another.");
						  }
					 }
				 }
				 catch(Exception error) {
					 System.out.println("You don't have enough fields for this pawn, play with another. ERROR!");
				 }
				 
				 //Check if there is already a pawn in the house and fill in the first place to check other positions
			     positionInHouseCheckForRed4();
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
	
	public static void positionInHouseCheckForRed1() {
		//Position [4321] or [3421]
		if(pawnRed2.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
			pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
			pawnRed2.setPawnParking(true);
			 
			 //Position [4321]
			 if(pawnRed3.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
				 pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
				 pawnRed3.setPawnParking(true);  
				 if(pawnRed4.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
					 pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
					 pawnRed4.setPawnParking(true); 
				 }
			 }
			 
			 //Position [3421]
			 if(pawnRed4.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
				pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
				pawnRed4.setPawnParking(true);  
				if(pawnRed3.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
					pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
					pawnRed3.setPawnParking(true); 
				 }
			 }
		 }
		 
		 //Position [4231] or [2431]
		 if(pawnRed3.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
			 pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
			 pawnRed3.setPawnParking(true);
			 
			 //Position [2431]
			 if(pawnRed4.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
				 pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
				 pawnRed4.setPawnParking(true);  
				 if(pawnRed2.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
					 pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
					 pawnRed2.setPawnParking(true);  
				 }
			 }
			 
			 //Position [4231]
			 if(pawnRed2.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
				 pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
				 pawnRed2.setPawnParking(true);  
				 if(pawnRed4.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
					 pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
					 pawnRed4.setPawnParking(true);  
				 }
			 }
		 }
		 
		 //Position [2341] or [3241]
		 if(pawnRed4.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
			 pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
			 pawnRed4.setPawnParking(true);
			 
			 //Position [2341]
			 if(pawnRed3.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
				 pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
				 pawnRed3.setPawnParking(true);  
				 if(pawnRed2.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
					 pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
					 pawnRed2.setPawnParking(true);  
				 }
			 }
			 
			 //Position [3241]
			 if(pawnRed2.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
				 pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
				 pawnRed2.setPawnParking(true);  
				 if(pawnRed3.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
					 pawnRed3.setPawnParkingPosition(pawnRed1.getPawnPosition());
					 pawnRed3.setPawnParking(true);  
				 }
			 }
		 }
	}
	
	public static void positionInHouseCheckForRed2() {
		//Position [4312] or [3412]
		if(pawnRed1.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
			 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
			 pawnRed1.setPawnParking(true);
			 
			 //Position [4312]
			 if(pawnRed3.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
				 pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
				 pawnRed3.setPawnParking(true);  
				 if(pawnRed4.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
					 pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
					 pawnRed4.setPawnParking(true); 
				 }
			 }
			 
			 //Position [3412]
			 if(pawnRed4.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
				pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
				pawnRed4.setPawnParking(true);  
				if(pawnRed3.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
					pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
					pawnRed3.setPawnParking(true); 
				 }
			 }
		 }
		 
		 //Position [4132] or [1432]
		 if(pawnRed3.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
			 pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
			 pawnRed3.setPawnParking(true);
			 
			 //Position [1432]
			 if(pawnRed4.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
				 pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
				 pawnRed4.setPawnParking(true);  
				 if(pawnRed1.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
					 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
					 pawnRed1.setPawnParking(true);  
				 }
			 }
			 
			 //Position [4132]
			 if(pawnRed1.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
				 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
				 pawnRed1.setPawnParking(true);  
				 if(pawnRed4.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
					 pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
					 pawnRed4.setPawnParking(true);  
				 }
			 }
		 }
		 
		 //Position [1342] or [3142]
		 if(pawnRed4.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
			 pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
			 pawnRed4.setPawnParking(true);
			 
			 //Position [1342]
			 if(pawnRed3.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
				 pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
				 pawnRed3.setPawnParking(true);  
				 if(pawnRed1.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
					 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
					 pawnRed1.setPawnParking(true);  
				 }
			 }
			 
			 //Position [3142]
			 if(pawnRed1.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
				 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
				 pawnRed1.setPawnParking(true);  
				 if(pawnRed3.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
					 pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
					 pawnRed3.setPawnParking(true);  
				 }
			 }
		 } 
	}
	
	public static void positionInHouseCheckForRed3() {
		//Position [4213] or [2413]
		if(pawnRed1.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
			 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
			 pawnRed1.setPawnParking(true);
			 
			 //Position [4213]
			 if(pawnRed2.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
				 pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
				 pawnRed2.setPawnParking(true);  
				 if(pawnRed4.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
					 pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
					 pawnRed4.setPawnParking(true); 
				 }
			 }
			 
			 //Position [2413]
			 if(pawnRed4.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
				pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
				pawnRed4.setPawnParking(true);  
				if(pawnRed2.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
					pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
					pawnRed2.setPawnParking(true); 
				 }
			 }
		 }
		 
		 //Position [4123] or [1423]
		 if(pawnRed2.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
			 pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
			 pawnRed2.setPawnParking(true);
			 
			 //Position [1423]
			 if(pawnRed4.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
				 pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
				 pawnRed4.setPawnParking(true);  
				 if(pawnRed1.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
					 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
					 pawnRed1.setPawnParking(true);  
				 }
			 }
			 
			 //Position [4123]
			 if(pawnRed1.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
				 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
				 pawnRed1.setPawnParking(true);  
				 if(pawnRed4.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
					 pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
					 pawnRed4.setPawnParking(true);  
				 }
			 }
		 }
		 
		 //Position [1243] or [2143]
		 if(pawnRed4.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
			 pawnRed4.setPawnParkingPosition(pawnRed4.getPawnPosition());
			 pawnRed4.setPawnParking(true);
			 
			 //Position [1243]
			 if(pawnRed2.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
				 pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
				 pawnRed2.setPawnParking(true);  
				 if(pawnRed1.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
					 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
					 pawnRed1.setPawnParking(true);  
				 }
			 }
			 
			 //Position [2143]
			 if(pawnRed1.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
				 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
				 pawnRed1.setPawnParking(true);  
				 if(pawnRed2.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
					 pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
					 pawnRed2.setPawnParking(true);  
				 }
			 }
		 }
	}
	
	public static void positionInHouseCheckForRed4() {
		//Position [2314] or [3214]
		if(pawnRed1.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
			 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
			 pawnRed1.setPawnParking(true);
			 
			 //Position [2314]
			 if(pawnRed3.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
				 pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
				 pawnRed3.setPawnParking(true);  
				 if(pawnRed2.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
					 pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
					 pawnRed2.setPawnParking(true); 
				 }
			 }
			 
			 //Position [3214]
			 if(pawnRed2.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
				 pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
				 pawnRed2.setPawnParking(true);  
				if(pawnRed3.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
					pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
					pawnRed3.setPawnParking(true); 
				 }
			 }
		 }
		 
		 //Position [1234] or [2134]
		 if(pawnRed3.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
			 pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
			 pawnRed3.setPawnParking(true);
			 
			 //Position [1234]
			 if(pawnRed2.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
				 pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
				 pawnRed2.setPawnParking(true);  
				 if(pawnRed1.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
					 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
					 pawnRed1.setPawnParking(true);  
				 }
			 }
			 
			 //Position [2134]
			 if(pawnRed1.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
				 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
				 pawnRed1.setPawnParking(true);  
				 if(pawnRed2.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
					 pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
					 pawnRed2.setPawnParking(true);  
				 }
			 }
		 }
		 
		 //Position [1324] or [3124]
		 if(pawnRed2.getPawnPosition() == pawnRed4.getPawnParkingPosition()-1 && pawnRed4.isPawnParking() == true) {
			 pawnRed2.setPawnParkingPosition(pawnRed2.getPawnPosition());
			 pawnRed2.setPawnParking(true);
			 
			 //Position [1324]
			 if(pawnRed3.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
				 pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
				 pawnRed3.setPawnParking(true);  
				 if(pawnRed1.getPawnPosition() == pawnRed3.getPawnParkingPosition()-1 && pawnRed3.isPawnParking() == true) {
					 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
					 pawnRed1.setPawnParking(true);  
				 }
			 }
			 
			 //Position [3124]
			 if(pawnRed1.getPawnPosition() == pawnRed2.getPawnParkingPosition()-1 && pawnRed2.isPawnParking() == true) {
				 pawnRed1.setPawnParkingPosition(pawnRed1.getPawnPosition());
				 pawnRed1.setPawnParking(true);  
				 if(pawnRed3.getPawnPosition() == pawnRed1.getPawnParkingPosition()-1 && pawnRed1.isPawnParking() == true) {
					 pawnRed3.setPawnParkingPosition(pawnRed3.getPawnPosition());
					 pawnRed3.setPawnParking(true);  
				 }
			 }
		 } 
	}
	
	public static boolean pawnInHousePositionRed1() {
		 if((pawnRed2.getPawnPosition() == 44) || (pawnRed3.getPawnPosition() == 44) || (pawnRed4.getPawnPosition() == 44)) {
			 if(pawnRed1.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 44) {
				 return true;
			 }	
		 }
		 
		 if((pawnRed2.getPawnPosition() == 43) || (pawnRed3.getPawnPosition() == 43) || (pawnRed4.getPawnPosition() == 43)) {
			 if(pawnRed1.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 43) {
				 return true;
			 }	
		 }
		 
		 if((pawnRed2.getPawnPosition() == 42) || (pawnRed3.getPawnPosition() == 42) || (pawnRed4.getPawnPosition() == 42)) {
			 if(pawnRed1.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 42) {
				 return true;
			 }	
		 }
		 
		 if((pawnRed2.getPawnPosition() == 41) || (pawnRed3.getPawnPosition() == 41) || (pawnRed4.getPawnPosition() == 41)) {
			 if(pawnRed1.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 41) {
				 return true;
			 }	
		 }
		 return false;
	}
	
	public static boolean pawnInHousePositionRed2() {
		 if((pawnRed1.getPawnPosition() == 44) || (pawnRed3.getPawnPosition() == 44) || (pawnRed4.getPawnPosition() == 44)) {
			 if(pawnRed2.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 44) {
				 return true;
			 }	
		 }
		 
		 if((pawnRed1.getPawnPosition() == 43) || (pawnRed3.getPawnPosition() == 43) || (pawnRed4.getPawnPosition() == 43)) {
			 if(pawnRed2.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 43) {
				 return true;
			 }	
		 }
		 
		 if((pawnRed1.getPawnPosition() == 42) || (pawnRed3.getPawnPosition() == 42) || (pawnRed4.getPawnPosition() == 42)) {
			 if(pawnRed2.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 42) {
				 return true;
			 }	
		 }
		 
		 if((pawnRed1.getPawnPosition() == 41) || (pawnRed3.getPawnPosition() == 41) || (pawnRed4.getPawnPosition() == 41)) {
			 if(pawnRed2.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 41) {
				 return true;
			 }	
		 }
		 return false;
	}
	
	public static boolean pawnInHousePositionRed3() {
		 if((pawnRed1.getPawnPosition() == 44) || (pawnRed2.getPawnPosition() == 44) || (pawnRed4.getPawnPosition() == 44)) {
			 if(pawnRed3.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 44) {
				 return true;
			 }	
		 }
		 
		 if((pawnRed1.getPawnPosition() == 43) || (pawnRed2.getPawnPosition() == 43) || (pawnRed4.getPawnPosition() == 43)) {
			 if(pawnRed3.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 43) {
				 return true;
			 }	
		 }
		 
		 if((pawnRed1.getPawnPosition() == 42) || (pawnRed2.getPawnPosition() == 42) || (pawnRed4.getPawnPosition() == 42)) {
			 if(pawnRed3.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 42) {
				 return true;
			 }	
		 }
		 
		 if((pawnRed1.getPawnPosition() == 41) || (pawnRed2.getPawnPosition() == 41) || (pawnRed4.getPawnPosition() == 41)) {
			 if(pawnRed3.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 41) {
				 return true;
			 }	
		 }
		 return false;
	}
	
	public static boolean pawnInHousePositionRed4() {
		 if((pawnRed1.getPawnPosition() == 44) || (pawnRed2.getPawnPosition() == 44) || (pawnRed3.getPawnPosition() == 44)) {
			 if(pawnRed4.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 44) {
				 return true;
			 }	
		 }
		 
		 if((pawnRed1.getPawnPosition() == 43) || (pawnRed2.getPawnPosition() == 43) || (pawnRed3.getPawnPosition() == 43)) {
			 if(pawnRed4.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 43) {
				 return true;
			 }	
		 }
		 
		 if((pawnRed1.getPawnPosition() == 42) || (pawnRed2.getPawnPosition() == 42) || (pawnRed3.getPawnPosition() == 42)) {
			 if(pawnRed4.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 42) {
				 return true;
			 }	
		 }
		 
		 if((pawnRed1.getPawnPosition() == 41) || (pawnRed2.getPawnPosition() == 41) || (pawnRed3.getPawnPosition() == 41)) {
			 if(pawnRed4.getPawnPosition() + playerRed.getPlayerRollsDiceNumber() == 41) {
				 return true;
			 }	
		 }
		 return false;
	}
}
