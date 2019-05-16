package it.unicam.cs.pa.mastermind.gamecore;

/**
 * Classe che tiene conto del vincitore di una singola partita e del numero di
 * tentativi relativi ad un'eventuale vittoria del breaker.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class WinStats {

	/**
	 * Booleano relativo alla condizione di vittoria del Maker.
	 */
	private boolean hasMakerWon;
	/**
	 * Booleano relativo alla condizione di vittoria del Breaker.
	 */
	private boolean hasBreakerWon;
	/**
	 * Numero di tentativi relativi alla condizione di vittoria del Breaker.
	 */
	private int attempts;

	/**
	 * Costruttore.
	 */
	public WinStats() {
		hasMakerWon = false;
		hasBreakerWon = false;
		attempts = 0;
	}

	/**
	 * 
	 * @return int il numero di tentativi che sono stati necessari al Breaker per vincere.
	 */
	public int getAttempts() {
		return (hasBreakerWon) ? attempts : 0;
	}

	/**
	 * Operazione di toggle sulle variabili private per indicare la vittoria del Maker.
	 */
	public void toggleMakerWin() {
		hasMakerWon = true;
		hasBreakerWon = false;
	}

	/**
	 * Operazione di toggle sulle variabili private per indicare la vittoria del Breaker.
	 */
	public void toggleBreakerWin(int attempts) {
		hasMakerWon = false;
		hasBreakerWon = true;
		this.attempts = attempts;
	}

	/**
	 * 
	 * @return boolean che indica se il Maker ha vinto o meno.
	 */
	public boolean getHasMakerWon() {
		return hasMakerWon;
	}

	/**
	 * 
	 * @return boolean che indica se il Breaker ha vinto o meno.
	 */
	public boolean getHasBreakerWon() {
		return hasBreakerWon;
	}

	/**
	 * 
	 * @return String che comunica il vincitore attuale della partita. In caso non ci siano vincitori non viene comunicato nulla.
	 */
	public String getMessage() {
		if (this.getHasBreakerWon()) {
			return "The breaker guessed the combination after " + attempts + " attempts. The breaker wins";
		} else if (this.hasMakerWon) {
			return "The breaker didn't guess the combination. The maker wins";
		} else
			return "";
	}
}
