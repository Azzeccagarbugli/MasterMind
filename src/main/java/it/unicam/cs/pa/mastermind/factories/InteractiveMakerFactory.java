package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.InteractiveMaker;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * Classe factory estensione di <code>MakerFactory</code> impiegata per ottenere istanze di <code>InteractiveMaker</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class InteractiveMakerFactory implements MakerFactory {

	@Override
	public CodeMaker getMaker(InteractionView view, int seqLength, int attempts) {
		return new InteractiveMaker(view);
	}

	@Override
	public String getName() {
		return "Interactive Maker";
	}

	@Override
	public String getDescription() {
		return "Gestione del comportamento del giocatore tramite interazioni con l'utente umano";
	}
}
