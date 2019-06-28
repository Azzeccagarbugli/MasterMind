package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.RandomBotMaker;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * Classe factory estensione di <code>MakerFactory</code> impiegata per ottenere istanze di <code>RandomBotMaker</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class RandomBotMakerFactory implements MakerFactory {

	@Override
	public CodeMaker getMaker(InteractionView view, int seqLength, int attempts) {
		return new RandomBotMaker(seqLength, attempts);
	}

	@Override
	public String getName() {
		return "Random Maker";
	}

	@Override
	public String getDescription() {
		return "A maker defined by a random A.I.";
	}
}
