package it.unicam.cs.pa.mastermind.gamecore;

import it.unicam.cs.pa.mastermind.factories.BadRegistryException;
import it.unicam.cs.pa.mastermind.factories.GameViewFactory;
import it.unicam.cs.pa.mastermind.factories.StartViewFactory;
import it.unicam.cs.pa.mastermind.ui.StartView;

/**
 * <b>Responsabilità</b>: permettere il corretto svolgimento del gioco,
 * monitorando e tenendo traccia di una partita di MasterMind alla volta.
 * <b>Contratto</b>: le classi che estendono <code>MainManager</code> devono
 * includere al loro interno il metodo di avvio <code>main</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class MainManager {

	/**
	 * Riferimento al singolo match in esecuzione al momento.
	 */
	private SingleMatch currentMatch;

	/**
	 * Riferimento all'oggetto contenente le impostazioni comuni a tutti i match.
	 */
	private GlobalSettings globalSettings;

	/**
	 * Riferimento all'oggetto contenente le impostazioni per l'avvio di nuove
	 * partite.
	 */
	private StartupSettings startupSettings;

	/**
	 * Riferimento all'oggetto contenente le impostazioni relative allo svolgimento
	 * interno dei singoli match.
	 */
	private MatchStartSettings currentMatchSettings;

	/**
	 * Riferimento alla vista finalizzata all'interazione con l'utente fisico.
	 */
	private StartView startView;

	public MainManager() {
		startView = this.getStartViewFactory().getStartView();
		startupSettings = new StartupSettings();
		currentMatchSettings = new MatchStartSettings(this.getGameViewFactory());
		try {
			globalSettings = new GlobalSettings();
		} catch (BadRegistryException e) {
			startView.badEnding(e.getMessage());
			this.ending();
		}
	}

	/**
	 * Definizione completa delle impostazioni per creare un nuovo match.
	 */
	private void setupNewMatch() {
		if (!startupSettings.getKeepMatchStartSettings()) {
			currentMatchSettings.setMakerFactory(startView.setupMaker(globalSettings.getMakers()));
			currentMatchSettings.setBreakerFactory(startView.setupBreaker(globalSettings.getBreakers()));
			currentMatchSettings.resetLengthAttempts();
			if (startView.askNewLengthsAndAttempts()) {
				currentMatchSettings
						.setAttempts(startView.askNewAttempts(currentMatchSettings.getLowTresholdAttempts()));
				currentMatchSettings.setSequenceLength(startView.askNewLength(
						currentMatchSettings.getLowTresholdLength(), currentMatchSettings.getHighTresholdLength()));
			}
		}
		setCurrentMatch(this.matchBuilder());
	}

	/**
	 * Ottenimento di un'istanza di un nuovo match di MasterMind in base alle
	 * impostazioni definite nel metodo <code>setupNewMatch()</code>.
	 * 
	 * @return SingleMatch da avviare
	 */
	private SingleMatch matchBuilder() {
		return new SingleMatch(currentMatchSettings.getSequenceLength(), currentMatchSettings.getAttempts(),
				currentMatchSettings.getGameViewFactory(), currentMatchSettings.getBreakerFactory(),
				currentMatchSettings.getMakerFactory());
	}

	/**
	 * Impostazione del riferimento del match correntemente in esecuzione.
	 * 
	 * @param newMatch da impostare come quello correntemente in esecuzione
	 */
	private void setCurrentMatch(SingleMatch newMatch) {
		currentMatch = newMatch;
	}

	/**
	 * Gestione continua di nuovi match, creati, gestiti ed avviati uno alla volta.
	 */
	public void startUp() {
		while (startupSettings.getContinue()) {
			startView.showLogo();
			this.setupNewMatch();
			startView.showNewMatchStarting();
			currentMatch.start();
			startupSettings = startView.askNewStartupSettings();
		}
		this.ending();
	}

	/**
	 * Gestione della fase finale dell'intero programma.
	 */
	private void ending() {
		startView.ending();
		System.exit(-1);
	}

	/**
	 * Ottenimento dell'istanza di <code>StartViewFactory</code> che si desidera
	 * impiegare all'interno di <code>MainManager</code> per poter generare istanze
	 * di <code>StartView</code> utili per l'interazione con l'utente fisico.
	 * <b>Contratto</b>: il metodo deve risultare coerente con la particolare
	 * estensione di <code>MainManager</code> in cui viene definito.
	 * 
	 * @return StartViewFactory da impiegare in <code>MainManager</code>
	 */
	protected abstract StartViewFactory getStartViewFactory();

	/**
	 * Ottenimento dell'istanza di <code>GameViewFactory</code> che si desidera
	 * impiegare all'interno di tutti i match per poter generare istanze di
	 * <code>GameView</code> utili per l'interazione con l'utente fisico durante il
	 * loro svolgimento. <b>Contratto</b>: il metodo deve risultare coerente con la
	 * particolare estensione di <code>MainManager</code> in cui viene definito.
	 * 
	 * @return GameViewFactory da impiegare in <code>SingleMatch</code>
	 */
	protected abstract GameViewFactory getGameViewFactory();
}
