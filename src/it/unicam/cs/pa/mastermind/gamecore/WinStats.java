package it.unicam.cs.pa.mastermind.gamecore;

/**
 * Classe che tiene conto del vincitore di una singola partita e del numero di
 * tentativi relativi ad un'eventuale vittoria del breaker
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class WinStats {

	private boolean hasMakerWon;
	private boolean hasBreakerWon;
	private int attempts;

	public WinStats() {
		hasMakerWon = false;
		hasBreakerWon = false;
		attempts = 0;
	}

	public int getAttempts() {
		return attempts;
	}

	public void toggleMakerWin() {
		hasMakerWon = true;
		hasBreakerWon = false;
	}

	public void toggleBreakerWin(int attempts) {
		hasMakerWon = false;
		hasBreakerWon = true;
		this.attempts = attempts;
	}

	public boolean getHasMakerWon() {
		return hasMakerWon;
	}

	public boolean getHasBreakerWon() {
		return hasBreakerWon;
	}

	public String getMessage() {
		if (this.getHasBreakerWon()) {
			return "The breaker guessed the combination after " + attempts + " attempts. The breaker wins";
		} else if (this.hasMakerWon) {
			return "The breaker didn't guess the combination. The maker wins";
		} else
			return "";
	}
}
