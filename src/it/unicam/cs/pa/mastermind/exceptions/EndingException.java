package it.unicam.cs.pa.mastermind.exceptions;

/**
 * Superclasse estendibile dalle classi rappresentanti le eccezioni che si possono sollevare relative alla fine di una partita di MasterMind
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class EndingException extends Exception {
	public EndingException(String ex) {
		super(ex);
	}
}
