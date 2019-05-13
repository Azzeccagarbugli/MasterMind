package it.unicam.cs.pa.mastermind.exceptions;

/**
 * Eccezione da sollevare quando non è possibile inserire ulteriori tentativi
 * all'interno del gioco.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class NoAttemptsLeftException extends EndingException {
	
	private static final long serialVersionUID = 1L;

	public NoAttemptsLeftException() {
		super("\nThere are no attempts left.\nTHE MAKER WINS");
	}
}
