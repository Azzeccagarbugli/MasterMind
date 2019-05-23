package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;

/**
 * Classe astratta, la quale implementa l'interfaccia
 * <code>PlayerFacotry</code>, e consente la creazione di una factory di player
 * maker.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class MakerFactory implements PlayerFactory {
	public abstract CodeMaker getMaker();
}
