package it.unicam.cs.pa.mastermind.ui;

import it.unicam.cs.pa.mastermind.factories.BreakerFactory;
import it.unicam.cs.pa.mastermind.factories.MakerFactory;
import it.unicam.cs.pa.mastermind.gamecore.NewGameStats;
import it.unicam.cs.pa.mastermind.gamecore.SingleMatch;
import it.unicam.cs.pa.mastermind.players.BadRegistryException;
import it.unicam.cs.pa.mastermind.players.PlayerFactoryRegistry;

/**
 * <b>Responsabilità</b>: fornire agli utenti fisici coinvolti nel gioco
 * l'interazione per poter iniziare nuove partite.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class StartView {

	/**
	 * Istanza della classe <code>StartStats</code>.
	 */
	private StartStats startStats;

	public StartView() {
		try {
			startStats = new StartStats();
		} catch (BadRegistryException e) {
			this.badEnding(e.getMessage());
		}
	}

	/**
	 * Gestione completa dell'interazione con l'utente fisico per poter iniziare una
	 * nuova partita.
	 */
	public void startUp() {
		while (startStats.isToContinue()) {
			startStats.setIntView(this.getInteractionView());
			this.showLogo();
			if (!startStats.isKeepSettings()) {
				startStats.resetLengthAttempts();
				setupNewPlayers();
				if (this.askNewSettings()) {
					startStats.setAttempts(askNewAttempts());
					startStats.setSequenceLength(askNewLength());
				}
			}
			this.showNewGameStarting();
			startStats.setCurrentGame(new SingleMatch(startStats.getSequenceLength(), startStats.getAttempts(),
					startStats.getIntView(), startStats.getCurBreakerFactory(), startStats.getCurMakerFactory()));
			startStats.getCurrentGame().start();
			startStats.setNewGame(this.askNewGameSettings());
			startStats.setToContinue(startStats.getNewGame().getContinue());
			startStats.setKeepSettings(startStats.getNewGame().getKeepSettings());
		}
		this.ending();
	}

	/**
	 * Creazione delle istanze relative alle factory di giocatori necessarie per la nuova partita.
	 */
	private void setupNewPlayers() {
		startStats.setCurMakerFactory(
				(MakerFactory) startStats.getMakers().getFactoryByName(getPlayerName(startStats.getMakers(), false)));
		startStats.setCurBreakerFactory(
				(BreakerFactory) startStats.getBreakers()
				.getFactoryByName(getPlayerName(startStats.getBreakers(), true)));
	}

	/**
	 * Gestione della conclusione dell'intero gioco dopo la fine di ogni singola
	 * partita.
	 */
	protected abstract void ending();

	/**
	 * Gestione anticipata della conclusione dell'intero gioco, richiamata ad
	 * esempio per il sollevamento di errori importanti.
	 * 
	 * @param reason
	 */
	protected abstract void badEnding(String reason);

	/**
	 * Interazione con l'utente fisico a fronte della conclusione di una singola
	 * partita.
	 * 
	 * @return NewGameStats contenente informazioni relative all'inizio di una nuova
	 *         partita e alle impostazioni correlate.
	 */
	protected abstract NewGameStats askNewGameSettings();

	/**
	 * Gestione del messaggio di avvio di una singola partita.
	 */
	protected abstract void showNewGameStarting();

	/**
	 * Gestione dell'interazione con l'utente fisico per l'impostazione di un nuovo
	 * valore della lunghezza delle sequenze di elementi presenti nella nuova
	 * partita.
	 * 
	 * @return int valore della lunghezza delle sequenze di elementi presenti nella
	 *         nuova partita.
	 */
	protected abstract int askNewLength();

	/**
	 * Gestione dell'interazione con l'utente fisico per l'impostazione di un nuovo
	 * valore di numero di tentativi massimi richiesti al <code>CodeBreaker</code>
	 * all'interno della nuova partita.
	 * 
	 * @return int numero di tentativi massimi richiesti al <code>CodeBreaker</code>
	 *         all'interno della nuova partita.
	 */
	protected abstract int askNewAttempts();

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
	protected abstract String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker);

	/**
	 * Gestione dell'interazione con l'utente fisico per l'impostazione o meno di
	 * nuove impostazioni relative alla nuova partita.
	 * 
	 * @return boolean volontà dell'utente fisico di decidere nuove impostazioni per
	 *         la nuova partita.
	 */
	protected abstract boolean askNewSettings();

	/**
	 * Gestione del logo di avvio del gioco.
	 */
	protected abstract void showLogo();

	/**
	 * Ottenimento dell'oggetto <code>InteractionView</code> associato alla
	 * particolare implementazione di <code>StartView</code>.
	 * 
	 * @return InteractionView associata all'oggetto <code>StartView</code>.
	 */
	protected abstract InteractionView getInteractionView();

	/**
	 * Restituito il riferimento all'oggetto <code>StartStats</code> presente nella
	 * classe
	 * 
	 * @return StartStats il riferimento richiesto
	 */
	protected StartStats getStartStats() {
		return this.startStats;
	}
}
