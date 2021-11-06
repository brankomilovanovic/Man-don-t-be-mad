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
	static Pawn pawnBlue1 = new Pawn(playerBlue1);
	static Pawn pawnBlue2 = new Pawn(playerBlue2);
	static Pawn pawnBlue3 = new Pawn(playerBlue3);
	static Pawn pawnBlue4 = new Pawn(playerBlue4);
	
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
					 playerRed.setPlayerRollsDiceNext(false);
					 playerBlue.setPlayerRollsDiceNext(true);
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
					 //playerBlue.setPlayerRollsDiceNext(false);
					 //playerRed.setPlayerRollsDiceNext(true);
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
								  String[] currentPosition = Gui.positionRed.get(nextPosition).split(",");
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
								  String[] currentPosition = Gui.positionRed.get(nextPosition).split(",");
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
								  String[] currentPosition = Gui.positionRed.get(nextPosition).split(",");
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
								  String[] currentPosition = Gui.positionRed.get(nextPosition).split(",");
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
	
		//Players BLUE 1
		public static void playerBlue1() throws HeadlessException {
			playerBlue1.addActionListener(new ActionListener(){  
				 @Override
				 public void actionPerformed(ActionEvent e){
					 //Check that it meets the conditions for start
					 if(pawnBlue1.getPawnPosition() == 0 && playerBlue.getPlayerRollsDiceNumber() == 6 ) {
						  pawnBlue1.setPawnStart(true);
						  pawnBlue1.setPawnPosition(1);
						  playerBlue.setPlayerRollsDiceNumber(0);
					 }
					 else if(pawnBlue1.isPawnStart() == false || pawnBlue1.getPawnPosition() == 0) {
						  System.out.println("You haven't got number 6 yet!");
					 }
					 
					 //Check empty position in the house
					 if((pawnBlue2.getPawnParkingPosition() == 44 && pawnBlue2.isPawnParking() == true) || (pawnBlue3.getPawnParkingPosition() == 44 && pawnBlue3.isPawnParking() == true) || (pawnBlue4.getPawnParkingPosition() == 44 && pawnBlue4.isPawnParking() == true)) {
						 if(pawnBlue1.isPawnParking() == false) {
							 pawnBlue1.setPawnParkingPosition(43); 
						 }	
					 }
					 
					 if((pawnBlue2.getPawnParkingPosition() == 43 && pawnBlue2.isPawnParking() == true) || (pawnBlue3.getPawnParkingPosition() == 43 && pawnBlue3.isPawnParking() == true) || (pawnBlue4.getPawnParkingPosition() == 43 && pawnBlue4.isPawnParking() == true)) {
						 if(pawnBlue1.isPawnParking() == false) {
							 pawnBlue1.setPawnParkingPosition(42); 
						 }
					 }
					 
					 if((pawnBlue2.getPawnParkingPosition() == 42 && pawnBlue2.isPawnParking() == true) || (pawnBlue3.getPawnParkingPosition() == 42 && pawnBlue3.isPawnParking() == true) || (pawnBlue4.getPawnParkingPosition() == 42 && pawnBlue4.isPawnParking() == true)) {
						 if(pawnBlue1.isPawnParking() == false) {
							 pawnBlue1.setPawnParkingPosition(41); 
						 }
					 }
					 
					 //Pawn set on next position
					 try {
						 if(pawnBlue1.isPawnStart() == true && pawnBlue1.getPawnPosition() > 0) {
							  if(pawnInHousePositionBlue1() == false) {
								  if(pawnBlue1.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() <= pawnBlue1.getPawnParkingPosition()) {
									  int nextPosition = pawnBlue1.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber();
									  System.out.println("Choice player blue 1! Position: " + nextPosition + ", house position: " + pawnBlue1.getPawnParkingPosition());
									  String[] currentPosition = Gui.positionBlue.get(nextPosition).split(",");
									  playerBlue1.setBounds(Integer.parseInt(currentPosition[0]), Integer.parseInt(currentPosition[1]) , 61 , 61);
									  playerBlue.setPlayerRollsDiceNumber(0);
									  pawnBlue1.setPawnPosition(nextPosition);
								  }
								  else if (pawnBlue1.getPawnPosition() == pawnBlue1.getPawnParkingPosition()) { //If the pawn is in the house not to throw out an error message for the fields
									  System.out.println("This pawn 1 is in the house, play with another!");
								  } 
								  else if (pawnBlue1.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() > pawnBlue1.getPawnParkingPosition()) {
									  System.out.println("You don't have enough fields for this pawn or there is someone in that house, play with another.");
								  }
								  
								  if(pawnBlue1.getPawnPosition() == pawnBlue1.getPawnParkingPosition() && pawnBlue1.isPawnParking() == false) {
									  pawnBlue1.setPawnParking(true);
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
					 positionInHouseCheckForBlue1();
				 }  
			});
		}
		
		//Players BLUE 2
		public static void playerBlue2() throws HeadlessException {
			playerBlue2.addActionListener(new ActionListener(){  
				 @Override
				 public void actionPerformed(ActionEvent e){
					 //Check that it meets the conditions for start
					 if(pawnBlue2.getPawnPosition() == 0 && playerBlue.getPlayerRollsDiceNumber() == 6 ) {
						  pawnBlue2.setPawnStart(true);
						  pawnBlue2.setPawnPosition(1);
						  playerBlue.setPlayerRollsDiceNumber(0);
					 }
					 else if(pawnBlue2.isPawnStart() == false || pawnBlue2.getPawnPosition() == 0) {
						  System.out.println("You haven't got number 6 yet!");
					 }
					 
					 //Check empty position in the house
					 if((pawnBlue1.getPawnParkingPosition() == 44 && pawnBlue1.isPawnParking() == true) || (pawnBlue3.getPawnParkingPosition() == 44 && pawnBlue3.isPawnParking() == true) || (pawnBlue4.getPawnParkingPosition() == 44 && pawnBlue4.isPawnParking() == true)) {
						 if(pawnBlue2.isPawnParking() == false) {
							 pawnBlue2.setPawnParkingPosition(43); 
						 }	
					 }
					 
					 if((pawnBlue1.getPawnParkingPosition() == 43 && pawnBlue1.isPawnParking() == true) || (pawnBlue3.getPawnParkingPosition() == 43 && pawnBlue3.isPawnParking() == true) || (pawnBlue4.getPawnParkingPosition() == 43 && pawnBlue4.isPawnParking() == true)) {
						 if(pawnBlue2.isPawnParking() == false) {
							 pawnBlue2.setPawnParkingPosition(42); 
						 }
					 }
					 
					 if((pawnBlue1.getPawnParkingPosition() == 42 && pawnBlue1.isPawnParking() == true) || (pawnBlue3.getPawnParkingPosition() == 42 && pawnBlue3.isPawnParking() == true) || (pawnBlue4.getPawnParkingPosition() == 42 && pawnBlue4.isPawnParking() == true)) {
						 if(pawnBlue2.isPawnParking() == false) {
							 pawnBlue2.setPawnParkingPosition(41); 
						 }
					 }
					 
					 //Pawn set on next position
					 try {
						 if(pawnBlue2.isPawnStart() == true && pawnBlue2.getPawnPosition() > 0) {
							  if(pawnInHousePositionBlue2() == false) {
								  if(pawnBlue2.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() <= pawnBlue2.getPawnParkingPosition()) {
									  int nextPosition = pawnBlue2.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber();
									  System.out.println("Choice player blue 2! Position: " + nextPosition + ", house position: " + pawnBlue2.getPawnParkingPosition());
									  String[] currentPosition = Gui.positionBlue.get(nextPosition).split(",");
									  playerBlue2.setBounds(Integer.parseInt(currentPosition[0]), Integer.parseInt(currentPosition[1]) , 61 , 61);
									  playerBlue.setPlayerRollsDiceNumber(0);
									  pawnBlue2.setPawnPosition(nextPosition);
								  }
								  else if (pawnBlue2.getPawnPosition() == pawnBlue2.getPawnParkingPosition()) { //If the pawn is in the house not to throw out an error message for the fields
									  System.out.println("This pawn 2 is in the house, play with another!");
								  } 
								  else if (pawnBlue2.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() > pawnBlue2.getPawnParkingPosition()) {
									  System.out.println("You don't have enough fields for this pawn or there is someone in that house, play with another.");
								  }
								  
								  if(pawnBlue2.getPawnPosition() == pawnBlue2.getPawnParkingPosition() && pawnBlue2.isPawnParking() == false) {
									  pawnBlue2.setPawnParking(true);
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
					 positionInHouseCheckForBlue2();
				 }  
			});
		}

		//Players BLUE 3
		public static void playerBlue3() throws HeadlessException {
			playerBlue3.addActionListener(new ActionListener(){  
				 @Override
				 public void actionPerformed(ActionEvent e){
					 //Check that it meets the conditions for start
					 if(pawnBlue3.getPawnPosition() == 0 && playerBlue.getPlayerRollsDiceNumber() == 6 ) {
						  pawnBlue3.setPawnStart(true);
						  pawnBlue3.setPawnPosition(1);
						  playerBlue.setPlayerRollsDiceNumber(0);
					 }
					 else if(pawnBlue3.isPawnStart() == false || pawnBlue3.getPawnPosition() == 0) {
						  System.out.println("You haven't got number 6 yet!");
					 }
							 
					 //Check empty position in the house
					 if((pawnBlue1.getPawnParkingPosition() == 44 && pawnBlue1.isPawnParking() == true) || (pawnBlue2.getPawnParkingPosition() == 44 && pawnBlue2.isPawnParking() == true) || (pawnBlue4.getPawnParkingPosition() == 44 && pawnBlue4.isPawnParking() == true)) {
						 if(pawnBlue3.isPawnParking() == false) {
							 pawnBlue3.setPawnParkingPosition(43); 
						 }	
					 }
					 
					 if((pawnBlue1.getPawnParkingPosition() == 43 && pawnBlue1.isPawnParking() == true) || (pawnBlue2.getPawnParkingPosition() == 43 && pawnBlue2.isPawnParking() == true) || (pawnBlue4.getPawnParkingPosition() == 43 && pawnBlue4.isPawnParking() == true)) {
						 if(pawnBlue3.isPawnParking() == false) {
							 pawnBlue3.setPawnParkingPosition(42); 
						 }
					 }
					 
					 if((pawnBlue1.getPawnParkingPosition() == 42 && pawnBlue1.isPawnParking() == true) || (pawnBlue2.getPawnParkingPosition() == 42 && pawnBlue2.isPawnParking() == true) || (pawnBlue4.getPawnParkingPosition() == 42 && pawnBlue4.isPawnParking() == true)) {
						 if(pawnBlue3.isPawnParking() == false) {
							 pawnBlue3.setPawnParkingPosition(41); 
						 }
					 }
					 
					 //Pawn set on next position
					 try {
						 if(pawnBlue3.isPawnStart() == true && pawnBlue3.getPawnPosition() > 0) {
							  if(pawnInHousePositionBlue3() == false) {
								  if(pawnBlue3.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() <= pawnBlue3.getPawnParkingPosition()) {
									  int nextPosition = pawnBlue3.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber();
									  System.out.println("Choice player blue 3! Position: " + nextPosition + ", house position: " + pawnBlue3.getPawnParkingPosition());
									  String[] currentPosition = Gui.positionBlue.get(nextPosition).split(",");
									  playerBlue3.setBounds(Integer.parseInt(currentPosition[0]), Integer.parseInt(currentPosition[1]) , 61 , 61);
									  playerBlue.setPlayerRollsDiceNumber(0);
									  pawnBlue3.setPawnPosition(nextPosition);
								  }
								  else if (pawnBlue3.getPawnPosition() == pawnBlue3.getPawnParkingPosition()) { //If the pawn is in the house not to throw out an error message for the fields
									  System.out.println("This pawn 3 is in the house, play with another!");
								  } 
								  else if (pawnBlue3.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() > pawnBlue3.getPawnParkingPosition()) {
									  System.out.println("You don't have enough fields for this pawn or there is someone in that house, play with another.");
								  }
								  
								  if(pawnBlue3.getPawnPosition() == pawnBlue3.getPawnParkingPosition() && pawnBlue3.isPawnParking() == false) {
									  pawnBlue3.setPawnParking(true);
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
				     positionInHouseCheckForBlue3();
				 } 
			});
		}
		
		//Players BLUE 4
		public static void playerBlue4() throws HeadlessException {
			playerBlue4.addActionListener(new ActionListener(){  
				 @Override
				 public void actionPerformed(ActionEvent e){
					 //Check that it meets the conditions for start
					 if(pawnBlue4.getPawnPosition() == 0 && playerBlue.getPlayerRollsDiceNumber() == 6 ) {
						  pawnBlue4.setPawnStart(true);
						  pawnBlue4.setPawnPosition(1);
						  playerBlue.setPlayerRollsDiceNumber(0);
					 }
					 else if(pawnBlue4.isPawnStart() == false || pawnBlue4.getPawnPosition() == 0) {
						  System.out.println("You haven't got number 6 yet!");
					 }
					 
					//Check empty position in the house
					 if((pawnBlue1.getPawnParkingPosition() == 44 && pawnBlue1.isPawnParking() == true) || (pawnBlue2.getPawnParkingPosition() == 44 && pawnBlue2.isPawnParking() == true) || (pawnBlue3.getPawnParkingPosition() == 44 && pawnBlue3.isPawnParking() == true)) {
						 if(pawnBlue4.isPawnParking() == false) {
							 pawnBlue4.setPawnParkingPosition(43); 
						 }	
					 }
					 
					 if((pawnBlue1.getPawnParkingPosition() == 43 && pawnBlue1.isPawnParking() == true) || (pawnBlue2.getPawnParkingPosition() == 43 && pawnBlue2.isPawnParking() == true) || (pawnBlue3.getPawnParkingPosition() == 43 && pawnBlue3.isPawnParking() == true)) {
						 if(pawnBlue4.isPawnParking() == false) {
							 pawnBlue4.setPawnParkingPosition(42); 
						 }
					 }
					 
					 if((pawnBlue1.getPawnParkingPosition() == 42 && pawnBlue1.isPawnParking() == true) || (pawnBlue2.getPawnParkingPosition() == 42 && pawnBlue2.isPawnParking() == true) || (pawnBlue3.getPawnParkingPosition() == 42 && pawnBlue3.isPawnParking() == true)) {
						 if(pawnBlue4.isPawnParking() == false) {
							 pawnBlue4.setPawnParkingPosition(41); 
						 }
					 }
					 
					//Pawn set on next position
					 try {
						 if(pawnBlue4.isPawnStart() == true && pawnBlue4.getPawnPosition() > 0) {
							  if(pawnInHousePositionBlue4() == false) {
								  if(pawnBlue4.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() <= pawnBlue4.getPawnParkingPosition()) {
									  int nextPosition = pawnBlue4.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber();
									  System.out.println("Choice player blue 4! Position: " + nextPosition + ", house position: " + pawnBlue4.getPawnParkingPosition());
									  String[] currentPosition = Gui.positionBlue.get(nextPosition).split(",");
									  playerBlue4.setBounds(Integer.parseInt(currentPosition[0]), Integer.parseInt(currentPosition[1]) , 61 , 61);
									  playerBlue.setPlayerRollsDiceNumber(0);
									  pawnBlue4.setPawnPosition(nextPosition);
								  }
								  else if (pawnBlue4.getPawnPosition() == pawnBlue4.getPawnParkingPosition()) { //If the pawn is in the house not to throw out an error message for the fields
									  System.out.println("This pawn 4 is in the house, play with another!");
								  } 
								  else if (pawnBlue4.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() > pawnBlue4.getPawnParkingPosition()) {
									  System.out.println("You don't have enough fields for this pawn or there is someone in that house, play with another.");
								  }
								  
								  if(pawnBlue4.getPawnPosition() == pawnBlue4.getPawnParkingPosition() && pawnBlue4.isPawnParking() == false) {
									  pawnBlue4.setPawnParking(true);
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
				     positionInHouseCheckForBlue4();
				 }  
			});
		}
	
	public static void positionInHouseCheckForBlue1() {
		//Position [4321] or [3421]
		if(pawnBlue2.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
			pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
			pawnBlue2.setPawnParking(true);
			 
			 //Position [4321]
			 if(pawnBlue3.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
				 pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
				 pawnBlue3.setPawnParking(true);  
				 if(pawnBlue4.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
					 pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
					 pawnBlue4.setPawnParking(true); 
				 }
			 }
			 
			 //Position [3421]
			 if(pawnBlue4.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
				pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
				pawnBlue4.setPawnParking(true);  
				if(pawnBlue3.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
					pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
					pawnBlue3.setPawnParking(true); 
				 }
			 }
		 }
		 
		 //Position [4231] or [2431]
		 if(pawnBlue3.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
			 pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
			 pawnBlue3.setPawnParking(true);
			 
			 //Position [2431]
			 if(pawnBlue4.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
				 pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
				 pawnBlue4.setPawnParking(true);  
				 if(pawnBlue2.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
					 pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
					 pawnBlue2.setPawnParking(true);  
				 }
			 }
			 
			 //Position [4231]
			 if(pawnBlue2.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
				 pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
				 pawnBlue2.setPawnParking(true);  
				 if(pawnBlue4.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
					 pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
					 pawnBlue4.setPawnParking(true);  
				 }
			 }
		 }
		 
		 //Position [2341] or [3241]
		 if(pawnBlue4.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
			 pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
			 pawnBlue4.setPawnParking(true);
			 
			 //Position [2341]
			 if(pawnBlue3.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
				 pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
				 pawnBlue3.setPawnParking(true);  
				 if(pawnBlue2.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
					 pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
					 pawnBlue2.setPawnParking(true);  
				 }
			 }
			 
			 //Position [3241]
			 if(pawnBlue2.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
				 pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
				 pawnBlue2.setPawnParking(true);  
				 if(pawnBlue3.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
					 pawnBlue3.setPawnParkingPosition(pawnBlue1.getPawnPosition());
					 pawnBlue3.setPawnParking(true);  
				 }
			 }
		 }
	}
	
	public static void positionInHouseCheckForBlue2() {
		//Position [4312] or [3412]
		if(pawnBlue1.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
			 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
			 pawnBlue1.setPawnParking(true);
			 
			 //Position [4312]
			 if(pawnBlue3.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
				 pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
				 pawnBlue3.setPawnParking(true);  
				 if(pawnBlue4.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
					 pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
					 pawnBlue4.setPawnParking(true); 
				 }
			 }
			 
			 //Position [3412]
			 if(pawnBlue4.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
				pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
				pawnBlue4.setPawnParking(true);  
				if(pawnBlue3.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
					pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
					pawnBlue3.setPawnParking(true); 
				 }
			 }
		 }
		 
		 //Position [4132] or [1432]
		 if(pawnBlue3.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
			 pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
			 pawnBlue3.setPawnParking(true);
			 
			 //Position [1432]
			 if(pawnBlue4.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
				 pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
				 pawnBlue4.setPawnParking(true);  
				 if(pawnBlue1.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
					 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
					 pawnBlue1.setPawnParking(true);  
				 }
			 }
			 
			 //Position [4132]
			 if(pawnBlue1.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
				 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
				 pawnBlue1.setPawnParking(true);  
				 if(pawnBlue4.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
					 pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
					 pawnBlue4.setPawnParking(true);  
				 }
			 }
		 }
		 
		 //Position [1342] or [3142]
		 if(pawnBlue4.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
			 pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
			 pawnBlue4.setPawnParking(true);
			 
			 //Position [1342]
			 if(pawnBlue3.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
				 pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
				 pawnBlue3.setPawnParking(true);  
				 if(pawnBlue1.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
					 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
					 pawnBlue1.setPawnParking(true);  
				 }
			 }
			 
			 //Position [3142]
			 if(pawnBlue1.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
				 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
				 pawnBlue1.setPawnParking(true);  
				 if(pawnBlue3.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
					 pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
					 pawnBlue3.setPawnParking(true);  
				 }
			 }
		 } 
	}
	
	public static void positionInHouseCheckForBlue3() {
		//Position [4213] or [2413]
		if(pawnBlue1.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
			 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
			 pawnBlue1.setPawnParking(true);
			 
			 //Position [4213]
			 if(pawnBlue2.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
				 pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
				 pawnBlue2.setPawnParking(true);  
				 if(pawnBlue4.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
					 pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
					 pawnBlue4.setPawnParking(true); 
				 }
			 }
			 
			 //Position [2413]
			 if(pawnBlue4.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
				pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
				pawnBlue4.setPawnParking(true);  
				if(pawnBlue2.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
					pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
					pawnBlue2.setPawnParking(true); 
				 }
			 }
		 }
		 
		 //Position [4123] or [1423]
		 if(pawnBlue2.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
			 pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
			 pawnBlue2.setPawnParking(true);
			 
			 //Position [1423]
			 if(pawnBlue4.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
				 pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
				 pawnBlue4.setPawnParking(true);  
				 if(pawnBlue1.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
					 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
					 pawnBlue1.setPawnParking(true);  
				 }
			 }
			 
			 //Position [4123]
			 if(pawnBlue1.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
				 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
				 pawnBlue1.setPawnParking(true);  
				 if(pawnBlue4.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
					 pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
					 pawnBlue4.setPawnParking(true);  
				 }
			 }
		 }
		 
		 //Position [1243] or [2143]
		 if(pawnBlue4.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
			 pawnBlue4.setPawnParkingPosition(pawnBlue4.getPawnPosition());
			 pawnBlue4.setPawnParking(true);
			 
			 //Position [1243]
			 if(pawnBlue2.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
				 pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
				 pawnBlue2.setPawnParking(true);  
				 if(pawnBlue1.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
					 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
					 pawnBlue1.setPawnParking(true);  
				 }
			 }
			 
			 //Position [2143]
			 if(pawnBlue1.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
				 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
				 pawnBlue1.setPawnParking(true);  
				 if(pawnBlue2.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
					 pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
					 pawnBlue2.setPawnParking(true);  
				 }
			 }
		 }
	}
	
	public static void positionInHouseCheckForBlue4() {
		//Position [2314] or [3214]
		if(pawnBlue1.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
			 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
			 pawnBlue1.setPawnParking(true);
			 
			 //Position [2314]
			 if(pawnBlue3.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
				 pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
				 pawnBlue3.setPawnParking(true);  
				 if(pawnBlue2.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
					 pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
					 pawnBlue2.setPawnParking(true); 
				 }
			 }
			 
			 //Position [3214]
			 if(pawnBlue2.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
				 pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
				 pawnBlue2.setPawnParking(true);  
				if(pawnBlue3.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
					pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
					pawnBlue3.setPawnParking(true); 
				 }
			 }
		 }
		 
		 //Position [1234] or [2134]
		 if(pawnBlue3.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
			 pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
			 pawnBlue3.setPawnParking(true);
			 
			 //Position [1234]
			 if(pawnBlue2.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
				 pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
				 pawnBlue2.setPawnParking(true);  
				 if(pawnBlue1.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
					 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
					 pawnBlue1.setPawnParking(true);  
				 }
			 }
			 
			 //Position [2134]
			 if(pawnBlue1.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
				 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
				 pawnBlue1.setPawnParking(true);  
				 if(pawnBlue2.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
					 pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
					 pawnBlue2.setPawnParking(true);  
				 }
			 }
		 }
		 
		 //Position [1324] or [3124]
		 if(pawnBlue2.getPawnPosition() == pawnBlue4.getPawnParkingPosition()-1 && pawnBlue4.isPawnParking() == true) {
			 pawnBlue2.setPawnParkingPosition(pawnBlue2.getPawnPosition());
			 pawnBlue2.setPawnParking(true);
			 
			 //Position [1324]
			 if(pawnBlue3.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
				 pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
				 pawnBlue3.setPawnParking(true);  
				 if(pawnBlue1.getPawnPosition() == pawnBlue3.getPawnParkingPosition()-1 && pawnBlue3.isPawnParking() == true) {
					 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
					 pawnBlue1.setPawnParking(true);  
				 }
			 }
			 
			 //Position [3124]
			 if(pawnBlue1.getPawnPosition() == pawnBlue2.getPawnParkingPosition()-1 && pawnBlue2.isPawnParking() == true) {
				 pawnBlue1.setPawnParkingPosition(pawnBlue1.getPawnPosition());
				 pawnBlue1.setPawnParking(true);  
				 if(pawnBlue3.getPawnPosition() == pawnBlue1.getPawnParkingPosition()-1 && pawnBlue1.isPawnParking() == true) {
					 pawnBlue3.setPawnParkingPosition(pawnBlue3.getPawnPosition());
					 pawnBlue3.setPawnParking(true);  
				 }
			 }
		 } 
	}
	
	public static boolean pawnInHousePositionBlue1() {
		 if((pawnBlue2.getPawnPosition() == 44) || (pawnBlue3.getPawnPosition() == 44) || (pawnBlue4.getPawnPosition() == 44)) {
			 if(pawnBlue1.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 44) {
				 return true;
			 }	
		 }
		 
		 if((pawnBlue2.getPawnPosition() == 43) || (pawnBlue3.getPawnPosition() == 43) || (pawnBlue4.getPawnPosition() == 43)) {
			 if(pawnBlue1.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 43) {
				 return true;
			 }	
		 }
		 
		 if((pawnBlue2.getPawnPosition() == 42) || (pawnBlue3.getPawnPosition() == 42) || (pawnBlue4.getPawnPosition() == 42)) {
			 if(pawnBlue1.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 42) {
				 return true;
			 }	
		 }
		 
		 if((pawnBlue2.getPawnPosition() == 41) || (pawnBlue3.getPawnPosition() == 41) || (pawnBlue4.getPawnPosition() == 41)) {
			 if(pawnBlue1.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 41) {
				 return true;
			 }	
		 }
		 return false;
	}
	
	public static boolean pawnInHousePositionBlue2() {
		 if((pawnBlue1.getPawnPosition() == 44) || (pawnBlue3.getPawnPosition() == 44) || (pawnBlue4.getPawnPosition() == 44)) {
			 if(pawnBlue2.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 44) {
				 return true;
			 }	
		 }
		 
		 if((pawnBlue1.getPawnPosition() == 43) || (pawnBlue3.getPawnPosition() == 43) || (pawnBlue4.getPawnPosition() == 43)) {
			 if(pawnBlue2.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 43) {
				 return true;
			 }	
		 }
		 
		 if((pawnBlue1.getPawnPosition() == 42) || (pawnBlue3.getPawnPosition() == 42) || (pawnBlue4.getPawnPosition() == 42)) {
			 if(pawnBlue2.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 42) {
				 return true;
			 }	
		 }
		 
		 if((pawnBlue1.getPawnPosition() == 41) || (pawnBlue3.getPawnPosition() == 41) || (pawnBlue4.getPawnPosition() == 41)) {
			 if(pawnBlue2.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 41) {
				 return true;
			 }	
		 }
		 return false;
	}
	
	public static boolean pawnInHousePositionBlue3() {
		 if((pawnBlue1.getPawnPosition() == 44) || (pawnBlue2.getPawnPosition() == 44) || (pawnBlue4.getPawnPosition() == 44)) {
			 if(pawnBlue3.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 44) {
				 return true;
			 }	
		 }
		 
		 if((pawnBlue1.getPawnPosition() == 43) || (pawnBlue2.getPawnPosition() == 43) || (pawnBlue4.getPawnPosition() == 43)) {
			 if(pawnBlue3.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 43) {
				 return true;
			 }	
		 }
		 
		 if((pawnBlue1.getPawnPosition() == 42) || (pawnBlue2.getPawnPosition() == 42) || (pawnBlue4.getPawnPosition() == 42)) {
			 if(pawnBlue3.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 42) {
				 return true;
			 }	
		 }
		 
		 if((pawnBlue1.getPawnPosition() == 41) || (pawnBlue2.getPawnPosition() == 41) || (pawnBlue4.getPawnPosition() == 41)) {
			 if(pawnBlue3.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 41) {
				 return true;
			 }	
		 }
		 return false;
	}
	
	public static boolean pawnInHousePositionBlue4() {
		 if((pawnBlue1.getPawnPosition() == 44) || (pawnBlue2.getPawnPosition() == 44) || (pawnBlue3.getPawnPosition() == 44)) {
			 if(pawnBlue4.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 44) {
				 return true;
			 }	
		 }
		 
		 if((pawnBlue1.getPawnPosition() == 43) || (pawnBlue2.getPawnPosition() == 43) || (pawnBlue3.getPawnPosition() == 43)) {
			 if(pawnBlue4.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 43) {
				 return true;
			 }	
		 }
		 
		 if((pawnBlue1.getPawnPosition() == 42) || (pawnBlue2.getPawnPosition() == 42) || (pawnBlue3.getPawnPosition() == 42)) {
			 if(pawnBlue4.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 42) {
				 return true;
			 }	
		 }
		 
		 if((pawnBlue1.getPawnPosition() == 41) || (pawnBlue2.getPawnPosition() == 41) || (pawnBlue3.getPawnPosition() == 41)) {
			 if(pawnBlue4.getPawnPosition() + playerBlue.getPlayerRollsDiceNumber() == 41) {
				 return true;
			 }	
		 }
		 return false;
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
