package it.unicam.cs.pa.mastermind.gamecore;

import it.unicam.cs.pa.mastermind.ui.BoardObserver;

/**
 * <b>Responsabilità</b>: tenere traccia delle informazioni necessarie per poter
 * decretare se una partita è terminata o meno.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class CurrentGameStats extends BoardObserver {

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
	public CurrentGameStats(BoardModel board) {
		this.addSubject(board);
		hasMakerWon = false;
		hasBreakerWon = false;
		attempts = 0;
	}

	/**
	 * Metodo attraverso il quale vengono restituiti i tentativi rimanenti al player
	 * per vincere il game corrente.
	 * 
	 * @return int numero di tentativi che sono stati necessari al Breaker per
	 *         vincere.
	 */
	public int getAttempts() {
		return (hasBreakerWon) ? attempts : 0;
	}

	/**
	 * Toggle sulle variabili private per indicare la vittoria del
	 * Maker.
	 */
	public void toggleMakerWin() {
		hasMakerWon = true;
		hasBreakerWon = false;
	}

	/**
	 * Toggle sulle variabili private per indicare la vittoria del
	 * Breaker.
	 * 
	 * @param attempts il numero di tentativi impiegati dal Breaker per vincere
	 */
	public void toggleBreakerWin(int attempts) {
		hasMakerWon = false;
		hasBreakerWon = true;
		this.attempts = attempts;
	}

	/**
	 * Metodo che stabilisce la vittoria del giocatore Maker o meno.
	 * 
	 * @return boolean che indica se il Maker ha vinto o meno.
	 */
	public boolean getHasMakerWon() {
		return hasMakerWon;
	}

	/**
	 * Metodo che stabilisce la vittoria del giocatore Breaker o meno.
	 * 
	 * @return boolean che indica se il Breaker ha vinto o meno.
	 */
	public boolean getHasBreakerWon() {
		return hasBreakerWon;
	}

	/**
	 * Metodo che comunica l'esito finale della partita corrente.
	 * 
	 * @return String che comunica il vincitore attuale della partita
	 */
	public String getMessage() {
		if (this.getHasBreakerWon()) {
			return "The breaker guessed the combination after " + attempts + " attempts. The breaker wins";
		} else if (this.hasMakerWon) {
			return "The breaker didn't guess the combination. The maker wins";
		} else
			return "There are no losers and no winners";
	}

	@Override
	public void update() {
		if (getSubject().hasBreakerGuessed()) {
			toggleBreakerWin(getSubject().attemptsInserted());
			return;
		} else if (getSubject().leftAttempts() <= 0) {
			toggleMakerWin();
			return;
		}
	}
}
