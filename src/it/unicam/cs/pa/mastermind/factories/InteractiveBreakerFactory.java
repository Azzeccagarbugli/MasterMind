package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.InteractiveBreaker;

/**
 * Classe concreta, la quale estende la classe astratta
 * <code>BreakerFacotry</code>, e consente la creazione di una factory di player
 * interactive.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class InteractiveBreakerFactory extends BreakerFactory {

	@Override
	public CodeBreaker getBreaker() {
		return new InteractiveBreaker();
	}

}
