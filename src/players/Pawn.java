package players;

import javax.swing.JButton;

public class Pawn {
		
	private int pawnPosition = 0;
	private boolean pawnStart = false;
	private boolean pawnParking = false;
	
	public Pawn(JButton pawn) {
		super();
	}

	public Pawn(int pawnPosition, boolean pawnStart, boolean pawnParking) {
		super();
		this.pawnPosition = pawnPosition;
		this.pawnStart = pawnStart;
		this.pawnParking = pawnParking;
	}

	public int getPawnPosition() {
		return pawnPosition;
	}

	public void setPawnPosition(int pawnPosition) {
		this.pawnPosition = pawnPosition;
	}

	public boolean isPawnStart() {
		return pawnStart;
	}

	public void setPawnStart(boolean pawnStart) {
		this.pawnStart = pawnStart;
	}

	public boolean isPawnParking() {
		return pawnParking;
	}

	public void setPawnParking(boolean pawnParking) {
		this.pawnParking = pawnParking;
	}
}
