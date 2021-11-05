package players;

public class Player {

	private static String playerPawn;
	private static int playerPawnPosition = 0;
	private static boolean playerStart = false;
	private static boolean playerParking;
	private static int playerRollsDiceNumber = 0;
	
	public Player() {
		super();
	}

	public Player(String playerPawn, int playerPawnPosition, boolean playerStart, boolean playerParking, int playerRollsDiceNumber) {
		super();
		Player.playerPawn = playerPawn;
		Player.playerPawnPosition = playerPawnPosition;
		Player.playerStart = playerStart;
		Player.playerParking = playerParking;
		Player.playerRollsDiceNumber = playerRollsDiceNumber;
	}

	public String getPlayerPawn() {
		return playerPawn;
	}

	public void setPlayerPawn(String playerPawn) {
		Player.playerPawn = playerPawn;
	}

	public int getPlayerPawnPosition() {
		return playerPawnPosition;
	}

	public void setPlayerPawnPosition(int playerPawnPosition) {
		Player.playerPawnPosition = playerPawnPosition;
	}

	public boolean isPlayerStart() {
		return playerStart;
	}

	public void setPlayerStart(boolean playerStart) {
		Player.playerStart = playerStart;
	}

	public boolean isPlayerParking() {
		return playerParking;
	}

	public void setPlayerParking(boolean playerParking) {
		Player.playerParking = playerParking;
	}
	
	public int getPlayerRollsDiceNumber() {
		return playerRollsDiceNumber;
	}

	public void setPlayerRollsDiceNumber(int playerRollsDiceNumber) {
		Player.playerRollsDiceNumber = playerRollsDiceNumber;
	}
}
