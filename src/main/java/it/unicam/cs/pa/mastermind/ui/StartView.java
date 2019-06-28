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

	// TODO Javadoc
	public default MakerFactory setupMaker(MakerFactoryRegistry registry) {
		try {
			return (MakerFactory) registry.getFactoryByName(getPlayerName(registry, false));
		} catch (BadRegistryException e) {
			this.badEnding(e.getMessage());
			return null;
		}
	}

	// TODO Javadoc
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
	 * @param reason
	 */
	public void badEnding(String reason);

	// TODO Javadoc
	public StartupSettings askNewStartupSettings();

	/**
	 * Gestione del messaggio di avvio di una singola partita.
	 */
	public void showNewMatchStarting();

	// TODO Javadoc
	public int askNewLength(int lowTres, int highTres);

	// TODO Javadoc
	public int askNewAttempts(int lowTres);

	/**
	 * Gestione dell'interazione dell'utente fisico per la scelta della particolare
	 * implementazione dei giocatori che verranno coinvolti nella nuova partita.
	 * 
	 * @param registry  registro contenente le informazioni sulle classi
	 *                  <code>PlayerFactory</code> relative alle implementazioni dei
	 *                  giocatori.
	 * @param isBreaker flag che indica se la scelta è relativa ad un giocatore
	 *                  <code>CodeBreaker</code> o meno.
	 * @return String rappresentante l'implementazione del giocatore scelta per la
	 *         nuova partita.
	 */
	public String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker);

	/**
	 * Gestione dell'interazione con l'utente fisico per l'impostazione o meno di
	 * nuove impostazioni relative alla nuova partita.
	 * 
	 * @return boolean volontà dell'utente fisico di decidere nuove impostazioni per
	 *         la nuova partita.
	 */
	public boolean askNewLengthsAndAttempts();

	/**
	 * Gestione del logo di avvio del gioco.
	 */
	public void showLogo();

}
