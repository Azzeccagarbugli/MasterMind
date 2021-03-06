package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.InteractiveMaker;
import it.unicam.cs.pa.mastermind.ui.GameView;

/**
 * Classe factory implementazione di <code>MakerFactory</code> impiegata per
 * ottenere istanze di <code>InteractiveMaker</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class InteractiveMakerFactory implements MakerFactory {

	@Override
	public CodeMaker getMaker(GameView view, int seqLength, int attempts) {
		return new InteractiveMaker(view, seqLength);
	}

	@Override
	public String getName() {
		return "Interactive";
	}

	@Override
	public String getDescription() {
		return "Human interactions for a maker";
	}
}
