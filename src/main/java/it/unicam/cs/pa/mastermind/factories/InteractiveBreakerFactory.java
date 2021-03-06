package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.InteractiveBreaker;
import it.unicam.cs.pa.mastermind.ui.GameView;

/**
 * Classe factory implementazione di <code>BreakerFactory</code> impiegata per
 * ottenere istanze di <code>InteractiveBreaker</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class InteractiveBreakerFactory implements BreakerFactory {

	@Override
	public CodeBreaker getBreaker(GameView view, int seqLength, int attempts) {
		return new InteractiveBreaker(view, seqLength);
	}

	@Override
	public String getName() {
		return "Interactive";
	}

	@Override
	public String getDescription() {
		return "Human interactions for a breaker";
	}

}
