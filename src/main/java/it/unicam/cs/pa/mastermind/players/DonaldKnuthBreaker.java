package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * Estensione di <code>CodeBreaker</code> mirata ad una gestione del
 * comportamento è basato sull'algoritmo di risoluzione teorizzato dal
 * matematico Donald Knuth, il quale attesta di risolvere il gioco del
 * Mastermind in cinque mosse al massimo mediante una precisa serie di passaggi.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class DonaldKnuthBreaker extends CodeBreaker {

	private int seqLength;
	private int attempts;
	private BoardModel reference;
	private ArrayList<List<ColorPegs>> combinationSet;
	private ArrayList<List<ColorPegs>> possibleSolutions; // S
	private List<ColorPegs> currentAttempt;
	private boolean firstTry;

	/**
	 * Viene inizializzato il player <code>DonaldKnuthBreaker</code> mediante il suo
	 * costruttore.
	 * 
	 * @param seqLength la lunghezza della sequenza segreto
	 * @param attempts  il numero di tentativi disponibili
	 */
	public DonaldKnuthBreaker(int seqLength, int attempts) {
		this.seqLength = seqLength;
		this.attempts = attempts;
		firstTry = true;
		if (this.seqLength == 4 && this.attempts >= 5) {
			this.attempts = attempts;
			reference = new BoardModel(seqLength, attempts);
			this.generateSet();
			currentAttempt = List.of(ColorPegs.values()[0], ColorPegs.values()[0], ColorPegs.values()[1],
					ColorPegs.values()[1]);
		} else {
			this.toggleGiveUp();
		}
	}

	@Override
	public List<ColorPegs> getAttempt() {
		if (firstTry) {
			currentAttempt = List.of(ColorPegs.values()[0], ColorPegs.values()[0], ColorPegs.values()[1],
					ColorPegs.values()[1]);
			firstTry = false;
			combinationSet.remove(currentAttempt);
			return currentAttempt;
		} else {
			this.solutionsFilter();
			if (!this.hasGivenUp()) {
				currentAttempt = this.minmax();
				combinationSet.remove(currentAttempt);
			}
			return currentAttempt;
		}
	}

	/**
	 * Viene generato il set contenente le 1296 combinazioni possibili.
	 */
	public void generateSet() {
		combinationSet = new ArrayList<List<ColorPegs>>();
		possibleSolutions = new ArrayList<List<ColorPegs>>();
		List<Integer> base = new ArrayList<Integer>();
		for (int i = 1; i <= seqLength; i++) {
			base.add(0);
		}
		combinationGenerator(0, base);
	}

	private void combinationGenerator(int position, List<Integer> indexes) {
		if (position >= seqLength) {
			List<ColorPegs> combo = new ArrayList<ColorPegs>();
			indexes.stream().map(index -> ColorPegs.values()[index]).forEach(peg -> combo.add(peg));

			this.combinationSet.add(combo);
			this.possibleSolutions.add(combo);
			return;
		}

		for (int i = 0; i < ColorPegs.values().length; i++) {
			indexes.set(position, i);
			combinationGenerator(position + 1, indexes);
		}
	}

	/**
	 * Metodo privato che garantisce l'incremento di un valore intero se una
	 * specifica lista di soluzioni è già stata trovata.
	 * 
	 * @param clueCounter la mappa che racchiude l'insieme di liste di indizi
	 *                    associate ad un proprio counter
	 * @param clue        la lista di indizi che si vuole reperire
	 */
	private void addClueCounter(Map<List<ColorPegs>, Integer> clueCounter, List<ColorPegs> clue) {
		if (clueCounter.containsKey(clue)) {
			clueCounter.replace(clue, clueCounter.get(clue) + 1);
		} else {
			clueCounter.put(clue, 1);
		}
	}

	/**
	 * Reset effettivo della mappa passata come parametro locale.
	 * 
	 * @param clueCounter la mappa sulla quale si vuole effettuare il
	 *                    <code>clear</code>.
	 */
	private void resetClueCounter(Map<List<ColorPegs>, Integer> clueCounter) {
		clueCounter.clear();
	}

	/**
	 * Il minimax, nella teoria delle decisioni, è un metodo per minimizzare la
	 * massima perdita possibile.
	 * 
	 * Nel caso qui riportato ha il compito di trovare la migliore lista tentativo
	 * possibile per il prossimo turno.
	 * 
	 * @return la migliore lista di <code>ColorPegs</code> per il prossimo turno
	 */
	private List<ColorPegs> minmax() {

		Map<List<ColorPegs>, Integer> clueCounter = new LinkedHashMap<>();
		Map<List<ColorPegs>, Integer> guessScores = new LinkedHashMap<>();
		List<List<ColorPegs>> nextAttempts = new ArrayList<List<ColorPegs>>();

		for (List<ColorPegs> guess : this.combinationSet) {
			for (List<ColorPegs> possibleSolution : this.possibleSolutions) {
				reference = new BoardModel(this.seqLength, 10);
				reference.setSequenceToGuess(possibleSolution);
				reference.addAttempt(guess);
				addClueCounter(clueCounter, reference.getLastClue());
			}

			int maxCount = Collections.max(clueCounter.values());
			guessScores.put(guess, possibleSolutions.size() - maxCount);

			this.resetClueCounter(clueCounter);
		}

		int maxCount = Collections.max(guessScores.values());
		guessScores.entrySet().stream().filter(entry -> entry.getValue() == maxCount)
				.forEach(entry -> nextAttempts.add(entry.getKey()));

		for (List<ColorPegs> newAttempt : nextAttempts) {
			if (possibleSolutions.contains(newAttempt)) {
				return newAttempt;
			}
		}

		for (List<ColorPegs> newAttempt : nextAttempts) {
			if (combinationSet.contains(newAttempt)) {
				return newAttempt;
			}
		}

		return currentAttempt;
	}


	/**
	 * Operazione di filtro della struttura <code>possibleSolutions</code>
	 * necessaria secondo l'algoritmo.
	 */
	private void solutionsFilter() {
		Iterator<List<ColorPegs>> it = this.possibleSolutions.iterator();
		while (it.hasNext()) {
			List<ColorPegs> seq = it.next();
			BoardModel reference = new BoardModel(seqLength, 10);
			reference.setSequenceToGuess(seq);
			reference.addAttempt(currentAttempt);
			if (!reference.getLastClue().equals(this.getLastClue())) {
				it.remove();

				if (possibleSolutions.size() == 0) {
					this.toggleGiveUp();
					break;
				}
			}

		}
	}
}
