package it.unicam.cs.pa.mastermind.ui;

import it.unicam.cs.pa.mastermind.gamecore.SingleMatch;
import it.unicam.cs.pa.mastermind.players.BadRegistryException;
import it.unicam.cs.pa.mastermind.players.BreakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.players.MakerFactoryRegistry;

import java.io.File;

import it.unicam.cs.pa.mastermind.factories.BreakerFactory;
import it.unicam.cs.pa.mastermind.factories.InteractionViewFactory;
import it.unicam.cs.pa.mastermind.factories.MakerFactory;
import it.unicam.cs.pa.mastermind.gamecore.NewGameStats;

/**
 * <b>Responsabilità</b>: tenere traccia delle informazioni necessarie per poter
 * iniziare una nuova partita.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class StartStats {

	private int attempts;
	private int sequenceLength;
	private boolean toContinue = true;
	private boolean keepSettings = false;
	private InteractionViewFactory intViewFactory;
	int lowTresholdLength;
	int highTresholdLength;
	int lowTresholdAttempts;
	private SingleMatch currentGame;
	private MakerFactoryRegistry makers;
	private final String makersPath = "MasterMindSrc//MakerFactories.txt";
	private BreakerFactoryRegistry breakers;
	private final String breakersPath = "MasterMindSrc//BreakerFactories.txt";
	private MakerFactory curMakerFactory;
	private BreakerFactory curBreakerFactory;
	private NewGameStats newGame;

	
	public StartStats() throws BadRegistryException {
		toContinue = true;
		keepSettings = false;
		lowTresholdLength = 1;
		highTresholdLength = 10;
		lowTresholdAttempts = 1;
		this.setupDefaultSrcFolder();
		makers = new MakerFactoryRegistry(makersPath);
		breakers = new BreakerFactoryRegistry(breakersPath);
	}

	private void setupDefaultSrcFolder() {
		File dir = new File("./MasterMindSrc");
		if(!dir.exists()) {
			dir.mkdir();
		}
	}
	public NewGameStats getNewGame() {
		return newGame;
	}

	public void setNewGame(NewGameStats newGame) {
		this.newGame = newGame;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public int getSequenceLength() {
		return sequenceLength;
	}

	public void setSequenceLength(int sequenceLength) {
		this.sequenceLength = sequenceLength;
	}

	public boolean isToContinue() {
		return toContinue;
	}

	public void setToContinue(boolean toContinue) {
		this.toContinue = toContinue;
	}

	public boolean isKeepSettings() {
		return keepSettings;
	}

	public void setKeepSettings(boolean keepSettings) {
		this.keepSettings = keepSettings;
	}

	public InteractionViewFactory getIntViewFactory() {
		return intViewFactory;
	}

	public void setIntView(InteractionViewFactory intViewFactory) {
		this.intViewFactory = intViewFactory;
	}

	public int getLowTresholdLength() {
		return lowTresholdLength;
	}

	public void setLowTresholdLength(int lowTresholdLength) {
		this.lowTresholdLength = lowTresholdLength;
	}

	public int getHighTresholdLength() {
		return highTresholdLength;
	}

	public void setHighTresholdLength(int highTresholdLength) {
		this.highTresholdLength = highTresholdLength;
	}

	public int getLowTresholdAttempts() {
		return lowTresholdAttempts;
	}

	public void setLowTresholdAttempts(int lowTresholdAttempts) {
		this.lowTresholdAttempts = lowTresholdAttempts;
	}

	public SingleMatch getCurrentGame() {
		return currentGame;
	}

	public void setCurrentGame(SingleMatch currentGame) {
		this.currentGame = currentGame;
	}

	public MakerFactoryRegistry getMakers() {
		return makers;
	}

	public void setMakers(MakerFactoryRegistry makers) {
		this.makers = makers;
	}

	public BreakerFactoryRegistry getBreakers() {
		return breakers;
	}

	public void setBreakers(BreakerFactoryRegistry breakers) {
		this.breakers = breakers;
	}

	public MakerFactory getCurMakerFactory() {
		return curMakerFactory;
	}

	public void setCurMakerFactory(MakerFactory curMakerFactory) {
		this.curMakerFactory = curMakerFactory;
	}

	public BreakerFactory getCurBreakerFactory() {
		return curBreakerFactory;
	}

	public void setCurBreakerFactory(BreakerFactory curBreakerFactory) {
		this.curBreakerFactory = curBreakerFactory;
	}
	
	/**
	 * Vengono impostati i valori standard del numero di tentativi e della lunghezza delle sequenze
	 */
	public void resetLengthAttempts() {
		this.attempts = 9;
		this.sequenceLength = 4;
	}

}
