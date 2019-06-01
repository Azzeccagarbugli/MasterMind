package it.unicam.cs.pa.mastermind.ui;

import it.unicam.cs.pa.mastermind.factories.BreakerFactory;
import it.unicam.cs.pa.mastermind.factories.MakerFactory;
import it.unicam.cs.pa.mastermind.gamecore.NewGameStats;
import it.unicam.cs.pa.mastermind.gamecore.SingleGame;
import it.unicam.cs.pa.mastermind.players.PlayerFactoryRegistry;

public abstract class StartView {

	protected StartStats startStats;

	public StartView() {
		startStats = new StartStats();
	}
	
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

	private void setupNewPlayers() {
		MakerFactory mFactory = (MakerFactory) startStats.getMakers()
				.getFactoryByName(getPlayerName(startStats.getMakers(), false));
		BreakerFactory bFactory = (BreakerFactory) startStats.getBreakers()
				.getFactoryByName(getPlayerName(startStats.getBreakers(), true));
		startStats.setCurrentMaker(mFactory.getMaker());
		startStats.setCurrentBreaker(bFactory.getBreaker());
	}

	protected abstract void ending();

	protected abstract NewGameStats askNewGameSettings();

	protected abstract void showNewGameStarting();

	protected abstract int askNewLength();

	protected abstract int askNewAttempts(); 

	protected abstract String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker);

	protected abstract boolean askNewSettings();

	protected abstract void showLogo();

	protected abstract InteractionView getInteractionView();
}
