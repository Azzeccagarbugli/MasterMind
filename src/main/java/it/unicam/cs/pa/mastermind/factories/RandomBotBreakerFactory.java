package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.RandomBotBreaker;
import it.unicam.cs.pa.mastermind.ui.GameView;

/**
 * Classe factory implementazione di <code>BreakerFactory</code> impiegata per ottenere istanze di <code>RandomBotBreaker</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class RandomBotBreakerFactory implements BreakerFactory {

	@Override
	public CodeBreaker getBreaker(GameView view, int seqLength, int attempts) {
		return new RandomBotBreaker(seqLength, attempts);
	}

	@Override
	public String getName() {
		return "Random Bot";
	}

	@Override
	public String getDescription() {
		return "A breaker defined by a random A.I.";
	}
}
