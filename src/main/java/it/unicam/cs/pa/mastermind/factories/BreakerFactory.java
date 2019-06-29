package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.ui.GameView;

/**
 * <b>Responsabilità</b>: fornire istanze di implementazioni di <code>CodeBreaker</code>.
 * Interfaccia finalizzata all'implementazione di classi factory per le particolari implementazioni dei giocatori <code>CodeBreaker</code>.
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public interface BreakerFactory extends PlayerFactory {
	
	/**
	 * Ottenimento di un'istanza di un giocatore <code>CodeBreaker</code>.
	 * @param view vista per l'interazione con l'utente fisico
	 * @param seqLength lunghezza della sequenza di <code>ColorPegs</code> da trattare
	 * @param attempts numero di tentativi per vincere il gioco
	 * @return CodeBreaker istanza di un giocatore <code>CodeBreaker</code>
	 */
	public CodeBreaker getBreaker(GameView view, int seqLength, int attempts);
}
