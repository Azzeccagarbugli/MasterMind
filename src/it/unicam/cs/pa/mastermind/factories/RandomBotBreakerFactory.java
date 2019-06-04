package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.RandomBotBreaker;

/**
 * Classe factory estensione di <code>BreakerFactory</code> impiegata per ottenere istanze di <code>RandomBotBreaker</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class RandomBotBreakerFactory extends BreakerFactory {

	@Override
	public CodeBreaker getBreaker() {
		return new RandomBotBreaker();
	}

}
