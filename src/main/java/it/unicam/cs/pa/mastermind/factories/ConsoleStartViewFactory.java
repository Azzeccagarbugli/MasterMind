package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.ui.ConsoleStartView;
import it.unicam.cs.pa.mastermind.ui.StartView;

/**
 * Classe factory estensione di <code>StartViewFactory</code> impiegata per
 * ottenere istanze di <code>ConsoleStartView</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class ConsoleStartViewFactory implements StartViewFactory {

	@Override
	public StartView getStartView() {
		return new ConsoleStartView();
	}

}
