package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.ui.GameView;

/**
 * <b>Responsabilità</b>: fornire istanze di implementazioni di <code>CodeMaker</code>.
 * Interfaccia finalizzata all'implementazione di classi factory per le particolari implementazioni dei giocatori <code>CodeMaker</code>.
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public interface MakerFactory extends PlayerFactory {
	
	/**
	 * Ottenimento di un'istanza di un giocatore <code>CodeMaker</code>.
	 * @param view vista per l'interazione con l'utente fisico
	 * @param seqLength lunghezza della sequenza di <code>ColorPegs</code> da trattare
	 * @param attempts numero di tentativi per vincere il gioco
	 * @return CodeMaker istanza di un giocatore <code>CodeMaker</code>
	 */
	public CodeMaker getMaker(GameView view, int seqLength, int attempts);
}
