package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.RandomBotBreaker;

/**
 * Classe concreta, la quale estende la classe astratta
 * <code>PlayerFacotry</code>, e consente la creazione di una factory di player
 * random bot breaker.
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
