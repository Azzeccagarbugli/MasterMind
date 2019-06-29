package it.unicam.cs.pa.mastermind.gamecore;

import it.unicam.cs.pa.mastermind.factories.BreakerFactory;
import it.unicam.cs.pa.mastermind.factories.GameViewFactory;
import it.unicam.cs.pa.mastermind.factories.MakerFactory;

/**
 * <b>Responsabilità</b>: tenere traccia delle informazioni necessarie per poter
 * iniziare una nuova partita e da impiegare all'interno di essa.
 * <b>Contratto</b>: le istanze vengono gestite all'interno di
 * <code>MainManager</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class MatchStartSettings {

	private MakerFactory makerFactory;
	private BreakerFactory breakerFactory;
	private GameViewFactory gameViewFactory;
	private int attempts;
	private int sequenceLength;
	int lowTresholdLength;
	int highTresholdLength;
	int lowTresholdAttempts;

	public MatchStartSettings(GameViewFactory gameViewFactory) {
		this.gameViewFactory = gameViewFactory;
		lowTresholdLength = 1;
		highTresholdLength = 10;
		lowTresholdAttempts = 1;
		this.resetLengthAttempts();

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

	public GameViewFactory getGameViewFactory() {
		return gameViewFactory;
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

	public MakerFactory getMakerFactory() {
		return makerFactory;
	}

	public void setMakerFactory(MakerFactory makerFactory) {
		this.makerFactory = makerFactory;
	}

	public BreakerFactory getBreakerFactory() {
		return breakerFactory;
	}

	public void setBreakerFactory(BreakerFactory breakerFactory) {
		this.breakerFactory = breakerFactory;
	}

	public void resetLengthAttempts() {
		this.attempts = 9;
		this.sequenceLength = 4;
	}

}
