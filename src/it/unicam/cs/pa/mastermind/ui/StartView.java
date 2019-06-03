package it.unicam.cs.pa.mastermind.ui;

import it.unicam.cs.pa.mastermind.factories.BreakerFactory;
import it.unicam.cs.pa.mastermind.factories.MakerFactory;
import it.unicam.cs.pa.mastermind.gamecore.NewGameStats;
import it.unicam.cs.pa.mastermind.gamecore.SingleGame;
import it.unicam.cs.pa.mastermind.players.PlayerFactoryRegistry;

/**
 * La classe astratta StartView elenca una serie di caratteristiche fondamentali
 * che verranno poi estese a più alto livello all'interno della classe
 * <code>ConsoleStartView</code> e tale aggiunta rende il software più elegante
 * e pulito.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class StartView {

	/**
	 * Instanza della classe <code>StartStats</code>.
	 */
	protected StartStats startStats;

	/**
	 * Costruttore dello StartView.
	 */
	public StartView() {
		startStats = new StartStats();
	}

	/**
	 * Metodo <code>startUp</code>o che esegue il set-up di un game completo.
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
			startStats.setCurrentGame(new SingleGame(startStats.getSequenceLength(), startStats.getAttempts(),
					startStats.getIntView(), startStats.getCurrentBreaker(), startStats.getCurrentMaker()));
			startStats.getCurrentGame().start();
			startStats.setNewGame(this.askNewGameSettings());
			startStats.setToContinue(startStats.getNewGame().getContinue());
			startStats.setKeepSettings(startStats.getNewGame().getKeepSettings());
		}
		this.ending();
	}

	/**
	 * Equivalentemente al metodo <i>startUp</i> il metodo
	 * <code>setupNewPlayers</code> esegue il set-up dei player all'interno della
	 * piattaforma di gioco.
	 */
	private void setupNewPlayers() {
		MakerFactory mFactory = (MakerFactory) startStats.getMakers()
				.getFactoryByName(getPlayerName(startStats.getMakers(), false));
		BreakerFactory bFactory = (BreakerFactory) startStats.getBreakers()
				.getFactoryByName(getPlayerName(startStats.getBreakers(), true));
		startStats.setCurrentMaker(mFactory.getMaker());
		startStats.setCurrentBreaker(bFactory.getBreaker());
	}

	/**
	 * Metodo necessario all'ending del gioco.
	 */
	protected abstract void ending();

	/**
	 * Metodo che chiede le nuove impostazioni di gioco a fine partita.
	 * 
	 * @return vengono restituite tali informazioni sotto forma di
	 *         <code>NewGameStats</code>
	 */
	protected abstract NewGameStats askNewGameSettings();

	/**
	 * Mostra il primo avvio del gioco.
	 */
	protected abstract void showNewGameStarting();

	/**
	 * Viene richiesta la nuova lunghezza della sequenza.
	 * 
	 * @return il valore intero che rappresenta tale valore
	 */
	protected abstract int askNewLength();

	/**
	 * Vengono richiesti quanti nuovi tentativi si vogliono inserire.
	 * 
	 * @return il valore intero che rappresenta tale valore
	 */
	protected abstract int askNewAttempts();

	/**
	 * Metodo getter necessario al get del nome del player.
	 * 
	 * @param registry  il registro sul quale si sta cercando tale informazione
	 * @param isBreaker valore booleano che rappresenta la veridicità del player
	 *                  breaker o meno
	 * @return il nome del giocatore
	 */
	protected abstract String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker);

	/**
	 * Metodo che chiede le nuove impostazioni al player alla fine del game.
	 * 
	 * @return il valore booleano con tale informazione al suo interno
	 */
	protected abstract boolean askNewSettings();

	/**
	 * Metodo puramente artistico che visualizza il logo del progetto.
	 */
	protected abstract void showLogo();

	/**
	 * Metodo che restitusce l'InteractionView richiesta.
	 * 
	 * @return l'InteractionView desiderata
	 */
	protected abstract InteractionView getInteractionView();
}
