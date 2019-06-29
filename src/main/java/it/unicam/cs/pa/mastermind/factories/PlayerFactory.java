package it.unicam.cs.pa.mastermind.factories;

/**
 * Interfaccia finalizzata all'implementazione di classi factory per le particolari implementazioni dei giocatori.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public interface PlayerFactory {
	
	/**
	 * @return String nome della particolare implementazione di un giocatore
	 */
	String getName();
	
	/**
	 * @return String descrizione della particolare implementazione di un giocatore
	 */
	String getDescription();
}
