package it.unicam.cs.pa.mastermind.ui;

import it.unicam.cs.pa.mastermind.gamecore.SingleGame;
import it.unicam.cs.pa.mastermind.players.BreakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.MakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.gamecore.NewGameStats;

/**
 * La classe StartStats consente di inizializzare dei settaggi per l'inizio di
 * un nuovo game. La modularità di questa classe rende il progetto altamente
 * flessibile, in quanto i parametri di gioco possono essere facilmente
 * modificati mediante dei metodi setters e getters che elogiano il concetto di
 * incapsulamento dell'intero parco software.
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
	private SingleGame currentGame;
	private MakerFactoryRegistry makers;
	private BreakerFactoryRegistry breakers;
	private CodeMaker currentMaker;
	private CodeBreaker currentBreaker;
	private NewGameStats newGame;

	public StartStats() {
		toContinue = true;
		keepSettings = false;
		lowTresholdLength = 1;
		highTresholdLength = 10;
		lowTresholdAttempts = 1;
		makers = new MakerFactoryRegistry();
		breakers = new BreakerFactoryRegistry();
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

	public SingleGame getCurrentGame() {
		return currentGame;
	}

	public void setCurrentGame(SingleGame currentGame) {
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

	public void resetLengthAttempts() {
		this.attempts = 9;
		this.sequenceLength = 4;
	}

}
