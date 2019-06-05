package it.unicam.cs.pa.mastermind.ui;

import it.unicam.cs.pa.mastermind.gamecore.SingleMatch;
import it.unicam.cs.pa.mastermind.players.BadRegistryException;
import it.unicam.cs.pa.mastermind.players.BreakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.MakerFactoryRegistry;
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
	private InteractionView intView;
	int lowTresholdLength;
	int highTresholdLength;
	int lowTresholdAttempts;
	private SingleMatch currentGame;
	private MakerFactoryRegistry makers;
	private final String makersPath = "./Maker Factories.txt";
	private BreakerFactoryRegistry breakers;
	private final String breakersPath = "./Breaker Factories.txt";
	private CodeMaker currentMaker;
	private CodeBreaker currentBreaker;
	private NewGameStats newGame;

	public StartStats() throws BadRegistryException {
		toContinue = true;
		keepSettings = false;
		lowTresholdLength = 1;
		highTresholdLength = 10;
		lowTresholdAttempts = 1;
		makers = new MakerFactoryRegistry(makersPath);
		breakers = new BreakerFactoryRegistry(breakersPath);
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

	public InteractionView getIntView() {
		return intView;
	}

	public void setIntView(InteractionView intView) {
		this.intView = intView;
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

	public CodeMaker getCurrentMaker() {
		return currentMaker;
	}

	public void setCurrentMaker(CodeMaker currentMaker) {
		this.currentMaker = currentMaker;
	}

	public CodeBreaker getCurrentBreaker() {
		return currentBreaker;
	}

	public void setCurrentBreaker(CodeBreaker currentBreaker) {
		this.currentBreaker = currentBreaker;
	}

	/**
	 * Vengono impostati i valori standard del numero di tentativi e della lunghezza delle sequenze
	 */
	public void resetLengthAttempts() {
		this.attempts = 9;
		this.sequenceLength = 4;
	}

}