package it.unicam.cs.pa.mastermind.exceptions;

/**
 * Eccezione da sollevare quando è stato verificato che il giocatore che decodifica ha intenzione di arrendersi
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BreakerGiveUpException extends EndingException {
	public BreakerGiveUpException() {
		super("The breaker just gave up. \nTHE MAKER WINS");
	}
}
