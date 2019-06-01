package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.List;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * La classe definita di seguito consente al giocatore umano, di andare a creare
 * una sequenza che poi un altro player all'interno della piattaforma doverà
 * decodificare per ottenere la vittoria.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class InteractiveMaker extends CodeMaker {

	@Override
	public List<ColorPegs> getCodeToGuess(InteractionView intView) {
		List<ColorPegs> listToGuess = new ArrayList<ColorPegs>();
		intView.getIndexSequence(false).stream().map(index -> ColorPegs.values()[index - 1])
				.forEach(listToGuess::add);
		return listToGuess;
	}

}
