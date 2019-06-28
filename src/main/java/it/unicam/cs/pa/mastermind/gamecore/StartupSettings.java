package it.unicam.cs.pa.mastermind.gamecore;

/**
 * <b>Responsabilità</b>: tenere traccia delle informazioni necessarie per
 * decidere se iniziare una nuova partita e se impostare nuove impostazioni di
 * avvio.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class StartupSettings {

	/**
	 * Volontà dell'utente umano di continuare a giocare o meno.
	 */
	private boolean toContinue;

	/**
	 * Volontà dell'utente umano di continuare a giocare con le medesime
	 * impostazioni o meno.
	 */
	private boolean keepSettings;

	// TODO Javadoc
	public StartupSettings() {
		this.toContinue = true;
		this.keepSettings = false;
	}

	public StartupSettings(boolean toContinue, boolean keepSettings) {
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
	 * @return boolean volontà dell'utente umano di continuare a giocare con le
	 *         medesime impostazioni o meno.
	 */
	public boolean getKeepSettings() {
		return keepSettings;
	}

	public void setToContinue(boolean toContinue) {
		this.toContinue = toContinue;
	}

	public void setKeepSettings(boolean keepSettings) {
		this.keepSettings = keepSettings;
	}

}
