package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.InteractiveBreaker;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * Classe factory estensione di <code>BreakerFactory</code> impiegata per ottenere istanze di <code>InteractiveBreaker</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class InteractiveBreakerFactory implements BreakerFactory {

	@Override
	public CodeBreaker getBreaker(InteractionView view, int seqLength, int attempts) {
		return new InteractiveBreaker(view);
	}

	@Override
	public String getName() {
		return "Interactive Breaker";
	}

	@Override
	public String getDescription() {
		return "Gestione del comportamento del giocatore tramite interazioni con l'utente umano";
	}

}
