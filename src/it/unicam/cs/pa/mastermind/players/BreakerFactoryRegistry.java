package it.unicam.cs.pa.mastermind.players;

/**
 * La seguente classe <code>BreakerFactoryRegistry</code> permette di leggere un
 * file testuale, nella quale sono definite le specifiche da attuare, per poi
 * renderle concrete e instanziare quindi i player di natura breaker. Quest'ultimi
 * potranno essere sia bot sia interactive.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BreakerFactoryRegistry extends PlayerFactoryRegistry {
	
	public BreakerFactoryRegistry() {
		super("./Breaker Factories.txt");
	}
	
}
