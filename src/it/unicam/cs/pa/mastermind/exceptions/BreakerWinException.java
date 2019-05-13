package it.unicam.cs.pa.mastermind.exceptions;

/**
 * Eccezione da sollevare quando è stato verificato che il giocatore che
 * decodifica ha indovinato la sequenza scelta dal giocatore che codifica
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BreakerWinException extends EndingException {
	
	private static final long serialVersionUID = 1L;

	public BreakerWinException(int attempts) {
		super("\nThe breaker guessed the combination after " + attempts + " attempts. \nTHE BREAKER WINS");
	}

}
