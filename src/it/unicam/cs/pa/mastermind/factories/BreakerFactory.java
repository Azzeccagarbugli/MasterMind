package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;

/**
 * Classe factory astratta estensione di <code>PlayerFactory</code> da estendere
 * con classi factory concrete finalizzate all'ottenimento di istanze di
 * <code>CodeBreaker</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class BreakerFactory implements PlayerFactory {
	public abstract CodeBreaker getBreaker();
}
