package it.unicam.cs.pa.mastermind.gamecore;

/**
 * <b>Responsabilità</b>: tenere traccia delle informazioni necessarie per
 * decidere se iniziare una nuova partita e se impostare nuove impostazioni di
 * avvio.
 * <b>Contratto</b>: le istanze vengono gestite all'interno di <code>MainManager</code>.
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
	 * impostazioni di avvio o meno.
	 */
	private boolean keepMatchStartSettings;

	/**
	 * Nel costruttore senza parametri si manifesta la volontà di continuare a
	 * giocare sin dall'inizio e di non voler mantenere impostazioni. Il costruttore
	 * è nello specifico finalizzato ad un utilizzo dell'istanza di
	 * <code>StartupSettings</code> sin dall'avvio del gioco, dove si presume si
	 * voglia avviare un nuovo match e di fatto non esistono impostazioni passate.
	 */
	public StartupSettings() {
		this.toContinue = true;
		this.keepMatchStartSettings = false;
	}

	/**
	 * Costruttore in cui è possibile specificare la volontà di effettuare nuove
	 * partite e di mantenere o meno le impostazioni per il loro avvio.
	 * 
	 * @param toContinue
	 * @param keepSettings
	 */
	public StartupSettings(boolean toContinue, boolean keepSettings) {
		this.toContinue = toContinue;
		this.keepMatchStartSettings = keepSettings;
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
	public boolean getKeepMatchStartSettings() {
		return keepMatchStartSettings;
	}

	/**
	 * Impostazione valore personalizzato della volontà di continuare a giocare.
	 * @param toContinue volontà
	 */
	public void setToContinue(boolean toContinue) {
		this.toContinue = toContinue;
	}

	/**
	 * Impostazione valore personalizzato della volontà di mantenere le impostazioni per l'avvio di nuove partite.
	 * @param keepSettings volontà
	 */
	public void setKeepMatchStartSettings(boolean keepSettings) {
		this.keepMatchStartSettings = keepSettings;
	}

}
