package it.unicam.cs.pa.mastermind.gamecore;

/**
 * Classe relativa alle impostazioni legate alla fine di una partita e
 * all'inizio di quella successiva.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class NewGameStats {

	/**
	 * Variabile booleana che attesta la scelta dell'utente sul continuare a giocare
	 * o meno.
	 */
	private boolean toContinue;

	/**
	 * Variabile booleana che attesta la scelta dell'utente sul continuare a giocare
	 * o meno con le medesime impostazioni.
	 */
	private boolean keepSettings;

	/**
	 * Costruttore che instazia la seguente classe.
	 * 
	 * @param toContinue   booleano che determina se continuare a giocare o meno
	 * @param keepSettings booleano che determina se continuare a giocare o meno con
	 *                     le stesse impostazioni
	 */
	public NewGameStats(boolean toContinue, boolean keepSettings) {
		this.toContinue = toContinue;
		this.keepSettings = keepSettings;
	}

	/**
	 * Getter della variabile <code>toContinue</code>.
	 * 
	 * @return la variabile <code>toContinue</code>
 	 */
	public boolean getContinue() {
		return toContinue;
	}

	/**
	 * Getter della variabile <code>keepSettings</code>.
	 * 
	 * @return la variabile <code>keepSettings</code>
 	 */
	public boolean getKeepSettings() {
		return keepSettings;
	}

}
