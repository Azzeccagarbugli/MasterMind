package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.List;

import it.unicam.cs.pa.mastermind.exceptions.BreakerGiveUpException;
import it.unicam.cs.pa.mastermind.gui.InteractionManager;
import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

/**
 * La classe definita di seguito consente al giocatore umano, di andare a creare
 * una sequenza che poi un altro player all'interno della piattaforma doverà
 * decodificare per ottenere la vittoria.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class InteractiveMaker implements CodeMaker {

	/*
	 * Instanzio la variabile manager con la quale andrò ad eseguire le varie
	 * interazioni.
	 */
	private InteractionManager manager;

	/**
	 * Costruisco il seguente oggetto HumanMaker utilizzando
	 * un'<code>InteractionManager</code> per eseguire delle operazioni con
	 * quest'ultimo.
	 * 
	 * @param intManager il mangager con la quale effetuerò le interazioni
	 */
	public InteractiveMaker(InteractionManager intManager) {
		this.manager = intManager;
	}

	@Override
	public List<ColorPegs> getCodeToGuess(int sequenceLength) {
		List<ColorPegs> listToGuess = new ArrayList<ColorPegs>();
		try {
			manager.getIndexSequence(sequenceLength, false).stream().map(index -> ColorPegs.values()[index])
					.forEach(listToGuess::add);
		} catch (BreakerGiveUpException e) {
			System.out.println(e.getMessage());
		}
		return listToGuess;
	}

}