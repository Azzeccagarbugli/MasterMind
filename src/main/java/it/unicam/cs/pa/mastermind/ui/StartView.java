package it.unicam.cs.pa.mastermind.ui;

import it.unicam.cs.pa.mastermind.factories.BadRegistryException;
import it.unicam.cs.pa.mastermind.factories.BreakerFactory;
import it.unicam.cs.pa.mastermind.factories.BreakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.factories.MakerFactory;
import it.unicam.cs.pa.mastermind.factories.MakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.factories.PlayerFactoryRegistry;
import it.unicam.cs.pa.mastermind.gamecore.StartupSettings;

/**
 * <b>Responsabilità</b>: fornire agli utenti fisici coinvolti nel gioco
 * l'interazione per poter iniziare nuove partite.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public interface StartView {

	/**
	 * Gestione dell'interazione con l'utente fisico circa la particolare
	 * implementazione di <code>CodeMaker</code> da impiegare nel gioco.
	 * 
	 * @param registry da cui recuperare le informazioni
	 * @return MakerFactory per la generazione di nuovi giocatori
	 *         <code>CodeMaker</code>
	 */
	public default MakerFactory setupMaker(MakerFactoryRegistry registry) {
		try {
			return (MakerFactory) registry.getFactoryByName(getPlayerName(registry, false));
		} catch (BadRegistryException e) {
			this.badEnding(e.getMessage());
			return null;
		}
	}

	/**
	 * Gestione dell'interazione con l'utente fisico circa la particolare
	 * implementazione di <code>CodeBreaker</code> da impiegare nel gioco.
	 * 
	 * @param registry da cui recuperare le informazioni
	 * @return BreakerFactory per la generazione di nuovi giocatori
	 *         <code>CodeBreaker</code>
	 */
	public default BreakerFactory setupBreaker(BreakerFactoryRegistry registry) {
		try {
			return (BreakerFactory) registry.getFactoryByName(getPlayerName(registry, true));
		} catch (BadRegistryException e) {
			this.badEnding(e.getMessage());
			return null;
		}
	}

	/**
	 * Gestione della conclusione dell'intero gioco dopo la fine di ogni singola
	 * partita.
	 */
	public void ending();

	/**
	 * Gestione anticipata della conclusione dell'intero gioco, richiamata ad
	 * esempio per il sollevamento di errori importanti.
	 * 
	 * @param reason da presentare all'utente fisico
	 */
	public void badEnding(String reason);

	/**
	 * Gestione dell'interazione con l'utente fisico circa le decisioni per l'inizio
	 * di un nuovo match o meno dopo che uno è stato concluso.
	 * 
	 * @return StartupSettings contenente informazioni utili per iniziare o meno
	 *         nuovi match
	 */
	public StartupSettings askNewStartupSettings();

	/**
	 * Gestione dell'interazione con l'utente fisico circa l'inizio di un nuovo
	 * match
	 */
	public void showNewMatchStarting();

	/**
	 * Gestione dell'interazione con l'utente fisico per ottenere un nuovo valore
	 * relativo alla lunghezza delle sequenze impiegate nel gioco.
	 * 
	 * @param lowTres  limite inferiore al valore da scegliere
	 * @param highTres limite superiore al valore da scegliere
	 * @return int valore scelto
	 */
	public int askNewLength(int lowTres, int highTres);

	/**
	 * Gestione dell'interazione con l'utente fisico per ottenere un nuovo valore
	 * relativo al numero di tentativi utili all'interno del gioco.
	 * 
	 * @param lowTres limite inferiore al valore da scegliere
	 * @return int valore scelto
	 */
	public int askNewAttempts(int lowTres);

	/**
	 * Gestione dell'interazione dell'utente fisico per la scelta della particolare
	 * implementazione dei giocatori che verranno coinvolti nella nuova partita.
	 * 
	 * @param registry  registro contenente le informazioni sulle classi
	 *                  <code>PlayerFactory</code> relative alle implementazioni dei
	 *                  giocatori.
	 * @param isBreaker flag che indica se la scelta è relativa ad una factory
	 *                  finalizzata alla generazione di un giocatore
	 *                  <code>CodeBreaker</code> o meno.
	 * @return String rappresentante l'implementazione del giocatore scelta per la
	 *         nuova partita.
	 */
	public String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker);

	/**
	 * Gestione dell'interazione con l'utente fisico circa le decisioni per
	 * l'impostazione di nuovi valori di lunghezza delle sequenze e di numero di
	 * tentativi per un nuovo match.
	 * 
	 * @return boolean volontà dell'utente fisico di decidere nuove impostazioni per
	 *         un nuovo match.
	 */
	public boolean askNewLengthsAndAttempts();

	/**
	 * Gestione di interazione con l'utente fisico per mostrare il logo di gioco.
	 */
	public void showLogo();

}
