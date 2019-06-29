package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.DonaldKnuthBreaker;
import it.unicam.cs.pa.mastermind.ui.GameView;


/**
 * Classe factory implementazione di <code>BreakerFactory</code> impiegata per ottenere istanze di <code>DonaldKnuthBreaker</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class DonaldKnuthBreakerFactory implements BreakerFactory {

	@Override
	public String getName() {
		return "Knuth";
	}

	@Override
	public String getDescription() {
		return "An implementation of the Knuth algorithm";
	}

	@Override
	public CodeBreaker getBreaker(GameView view, int seqLength, int attempts) {
		return new DonaldKnuthBreaker(seqLength, attempts);
	}

}
