package players;

public class Player {

	private static String playerPawn;
	private static String playerPawnPosition;
	private static boolean playerStart;
	private static boolean playerParking;
	
	public Player() {
		super();
	}

	public Player(String playerPawn, String playerPawnPosition, boolean playerStart, boolean playerParking) {
		super();
		Player.playerPawn = playerPawn;
		Player.playerPawnPosition = playerPawnPosition;
		Player.playerStart = playerStart;
		Player.playerParking = playerParking;
	}

	public static String getPlayerPawn() {
		return playerPawn;
	}

	public static void setPlayerPawn(String playerPawn) {
		Player.playerPawn = playerPawn;
	}

	public static String getPlayerPawnPosition() {
		return playerPawnPosition;
	}

	public static void setPlayerPawnPosition(String playerPawnPosition) {
		Player.playerPawnPosition = playerPawnPosition;
	}

	public static boolean isPlayerStart() {
		return playerStart;
	}

	public static void setPlayerStart(boolean playerStart) {
		Player.playerStart = playerStart;
	}

	public static boolean isPlayerParking() {
		return playerParking;
	}

	public static void setPlayerParking(boolean playerParking) {
		Player.playerParking = playerParking;
	}
}
