package it.unicam.cs.pa.mastermind.gamecore;

import it.unicam.cs.pa.mastermind.factories.BadRegistryException;
import it.unicam.cs.pa.mastermind.factories.GameViewFactory;
import it.unicam.cs.pa.mastermind.ui.StartView;

/**
 * <b>Responsabilità</b>: monitorare e tenere traccia di una partita di
 * MasterMind alla volta.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class MainManager {

	private SingleMatch currentMatch;
	private GlobalSettings globalSettings;
	private StartupSettings startupSettings;
	private MatchStartSettings currentMatchSettings;
	private StartView startView;

	public MainManager() {
		startView = this.getStartViewInstance();
		startupSettings = new StartupSettings();
		currentMatchSettings = new MatchStartSettings(this.getGameViewFactory());
		try {
			globalSettings = new GlobalSettings();
		} catch (BadRegistryException e) {
			startView.badEnding(e.getMessage());
			this.ending();
		}
	}

	private void setupNewMatch() {
		if (!startupSettings.getKeepSettings()) {
			currentMatchSettings.setMakerFactory(startView.setupMaker(globalSettings.getMakers()));
			currentMatchSettings.setBreakerFactory(startView.setupBreaker(globalSettings.getBreakers()));
			if (startView.askNewLengthsAndAttempts()) {
				currentMatchSettings
						.setAttempts(startView.askNewAttempts(currentMatchSettings.getLowTresholdAttempts()));
				currentMatchSettings.setSequenceLength(startView.askNewLength(
						currentMatchSettings.getLowTresholdLength(), currentMatchSettings.getHighTresholdLength()));
			}
		}
		setCurrentMatch(this.matchBuilder());
	}

	private SingleMatch matchBuilder() {
		return new SingleMatch(currentMatchSettings.getSequenceLength(), currentMatchSettings.getAttempts(),
				currentMatchSettings.getGameViewFactory(), currentMatchSettings.getBreakerFactory(),
				currentMatchSettings.getMakerFactory());
	}

	private void setCurrentMatch(SingleMatch newMatch) {
		currentMatch = newMatch;
	}

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
	
	public void ending() {
		startView.ending();
		System.exit(-1);
	}
	public abstract StartView getStartViewInstance();

	public abstract GameViewFactory getGameViewFactory();
}
