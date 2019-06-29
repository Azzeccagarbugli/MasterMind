package it.unicam.cs.pa.mastermind.gamecore;

/**
 * <b>Responsabilità</b>: tenere traccia delle informazioni necessarie per poter
 * decretare se una partita è ancora in corso o meno. Rientra nel pattern
 * <b>Observer</b>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class MatchState extends BoardObserver {

	/**
	 * Booleano relativo alla condizione di vittoria del Maker.
	 */
	private boolean makerVictory;

	/**
	 * Booleano relativo alla condizione di vittoria del Breaker.
	 */
	private boolean breakerVictory;

	/**
	 * Booleano relativo alla condizione di resa del Breaker.
	 */
	private boolean breakerSurrender;
	/**
	 * Numero di tentativi relativi alla condizione di vittoria del Breaker.
	 */
	private int usedAttempts;

	/**
	 * Inizializzazione con valori di default.
	 * 
	 * @param subject BoardModel coinvolta nel pattern <b>Observer</b>
	 */
	public MatchState(BoardModel subject) {
		this.addSubject(subject);
		makerVictory = false;
		breakerVictory = false;
		breakerSurrender = false;
		usedAttempts = 0;
	}

	/**
	 * Metodo attraverso il quale vengono restituiti i tentativi usati fino ad ora
	 * dal <code>CodeBreaker</code> in caso abbia vinto.
	 * 
	 * @return int numero di tentativi che sono stati necessari al Breaker per
	 *         vincere.
	 */
	public int getBreakerVictoryAttempts() {
		return (breakerVictory) ? usedAttempts : 0;
	}

	/**
	 * Toggle sulle variabili private per indicare la vittoria del Maker.
	 */
	public void toggleMakerWin() {
		makerVictory = true;
		breakerVictory = false;
	}

	/**
	 * Toggle sulle variabili private per indicare la vittoria del Breaker.
	 * 
	 * @param attempts il numero di tentativi impiegati dal Breaker per vincere
	 */
	public void toggleBreakerWin(int attempts) {
		makerVictory = false;
		breakerVictory = true;
		this.usedAttempts = attempts;
	}

	/**
	 * Toggle sulle variabili private per indicare la resa del Breaker.
	 */
	public void toggleBreakerGiveUp() {
		this.breakerSurrender = true;
	}

	/**
	 * Metodo che stabilisce la vittoria del giocatore Maker o meno.
	 * 
	 * @return boolean che indica se il Maker ha vinto o meno.
	 */
	public boolean getHasMakerWon() {
		return makerVictory;
	}

	/**
	 * Metodo che stabilisce la vittoria del giocatore Breaker o meno.
	 * 
	 * @return boolean che indica se il Breaker ha vinto o meno.
	 */
	public boolean getHasBreakerWon() {
		return breakerVictory;
	}

	/**
	 * Metodo che comunica l'esito finale della partita corrente.
	 * 
	 * @return String che comunica il vincitore attuale della partita
	 */
	public String getMessage() {
		if (this.breakerVictory) {
			return "\nThe breaker guessed the combination after " + usedAttempts + " attempts. The breaker wins";
		} else if (this.breakerSurrender) {
			return "\nThe breaker gave up. The maker wins";
		} else if (this.makerVictory) {
			return "\nThe breaker didn't guess the combination. The maker wins";
		} else
			return "\nThere are no losers and no winners";
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
