package characters;

import javax.swing.JButton;

public class Player {

	private JButton playerPawn = new JButton(); 
	private int playerRollsDiceNumber = 0;
	private boolean playerRollsDiceNext = true;
	
	public Player() {
		super();
	}

	public Player(JButton playerPawn, int playerRollsDiceNumber, boolean playerRollsDiceNext) {
		super();
		this.playerPawn = playerPawn;
		this.playerRollsDiceNumber = playerRollsDiceNumber;
	}
	
	public JButton getPlayerPawn() {
		return playerPawn;
	}

	public void setPlayerPawn(JButton playerPawn) {
		this.playerPawn = playerPawn;
	}
	
	public int getPlayerRollsDiceNumber() {
		return playerRollsDiceNumber;
	}

	public void setPlayerRollsDiceNumber(int playerRollsDiceNumber) {
		this.playerRollsDiceNumber = playerRollsDiceNumber;
	}
	
	public boolean getPlayerRollsDiceNext() {
		return playerRollsDiceNext;
	}

	public void setPlayerRollsDiceNext(boolean playerRollsDiceNext) {
		this.playerRollsDiceNext = playerRollsDiceNext;
	}
}
