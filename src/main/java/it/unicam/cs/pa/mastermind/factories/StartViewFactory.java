package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.ui.StartView;

/**
 * Interfaccia finalizzata all'implementazione di classi factory per le
 * particolari implementazioni della vista <code>StartView</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public interface StartViewFactory {

	/**
	 * Ottenimento di un'istanza di una vista <code>StartView</code>.
	 * 
	 */
	public StartView getStartView();
}
