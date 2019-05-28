package it.unicam.cs.pa.mastermind.gamecore;

/**
 * Classe relativa alle impostazioni legate alla fine di una partita e
 * all'inizio di quella successiva.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class NewGameStats {

	private boolean toContinue;
	private boolean keepSettings;

	public NewGameStats(boolean toContinue, boolean keepSettings) {
		this.toContinue = toContinue;
		this.keepSettings = keepSettings;
	}

	public boolean getContinue() {
		return toContinue;
	}

	public boolean getKeepSettings() {
		return keepSettings;
	}

}
