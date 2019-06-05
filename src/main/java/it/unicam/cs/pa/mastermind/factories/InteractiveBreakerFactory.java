package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.InteractiveBreaker;

/**
 * Classe factory estensione di <code>BreakerFactory</code> impiegata per ottenere istanze di <code>InteractiveBreaker</code>.
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