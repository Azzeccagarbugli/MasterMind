package it.unicam.cs.pa.mastermind.gamecore;

/**
 * <b>Responsabilità</b>: tenere traccia delle informazioni necessarie per poter
 * iniziare una nuova partita dopo che ne è stata conclusa una.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class NewGameStats {

	/**
	 * Volontà dell'utente umano di continuare a giocare o meno.
	 */
	private boolean toContinue;

	/**
	 * Volontà dell'utente umano di continuare a giocare con le medesime impostazioni o meno.
	 */
	private boolean keepSettings;

	/**
	 * Costruttore
	 * @param toContinue volontà dell'utente umano di continuare a giocare o meno.
	 * @param keepSettings volontà dell'utente umano di continuare a giocare con le medesime impostazioni o meno.
	 */
	public NewGameStats(boolean toContinue, boolean keepSettings) {
		this.toContinue = toContinue;
		this.keepSettings = keepSettings;
	}

	/**
	 * @return boolean volontà dell'utente umano di continuare a giocare o meno.
	 */
	public boolean getContinue() {
		return toContinue;
	}

	/**
	 * @return boolean volontà dell'utente umano di continuare a giocare con le medesime impostazioni o meno.
 	 */
	public boolean getKeepSettings() {
		return keepSettings;
	}

}
