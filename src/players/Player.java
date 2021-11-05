package players;

import javax.swing.JButton;

public class Player {

	private static JButton playerPawn = new JButton(); 
	private static int playerRollsDiceNumber = 0;
	
	public Player() {
		super();
	}

	public Player(JButton playerPawn, int playerRollsDiceNumber) {
		super();
		Player.playerPawn = playerPawn;
		Player.playerRollsDiceNumber = playerRollsDiceNumber;
	}
	
	public JButton getPlayerPawn() {
		return playerPawn;
	}

	public void setPlayerPawn(JButton playerPawn) {
		Player.playerPawn = playerPawn;
	}
	
	public int getPlayerRollsDiceNumber() {
		return playerRollsDiceNumber;
	}

	public void setPlayerRollsDiceNumber(int playerRollsDiceNumber) {
		Player.playerRollsDiceNumber = playerRollsDiceNumber;
	}
}
