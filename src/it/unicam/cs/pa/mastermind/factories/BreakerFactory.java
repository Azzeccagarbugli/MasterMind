package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;

/**
 * Classe astratta, la quale implementa l'interfaccia
 * <code>PlayerFacotry</code>, e consente la creazione di una factory di player
 * breaker.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class BreakerFactory implements PlayerFactory {
	public abstract CodeBreaker getBreaker();
}
