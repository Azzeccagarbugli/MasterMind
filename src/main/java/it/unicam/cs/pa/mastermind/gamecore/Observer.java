package it.unicam.cs.pa.mastermind.gamecore;

/**
 * Interfaccia impiegata per la definizione di oggetti <code>Observer</code>
 * all'interno del pattern <b>Observer</b>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public interface Observer {

	/**
	 * Aggiornamento dello stato dell'oggetto.
	 */
	public void update(Observable o);

}
