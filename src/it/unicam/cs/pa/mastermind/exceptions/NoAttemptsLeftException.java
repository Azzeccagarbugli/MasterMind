package it.unicam.cs.pa.mastermind.exceptions;

/**
 * Eccezione da sollevare quando non è possibile inserire ulteriori tentativi all'interno del gioco
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class NoAttemptsLeftException extends EndingException {
	public NoAttemptsLeftException() {
		super("There are no attempts left.\nTHE MAKER WINS");
	}
}
