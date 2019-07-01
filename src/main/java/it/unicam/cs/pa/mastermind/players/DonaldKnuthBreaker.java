package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	private Set<List<ColorPegs>> combinationSet;
	private Set<List<ColorPegs>> possibleSolutions; // S
	private List<ColorPegs> currentAttempt;
	private boolean firstTry;

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
			return currentAttempt;
		} else {
			currentAttempt = this.minmax();
			return currentAttempt;
		}
	}

	public void generateSet() {
		combinationSet = new HashSet<List<ColorPegs>>();
		possibleSolutions = new HashSet<List<ColorPegs>>();
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

	private void addClueCounter(Map<List<ColorPegs>, Integer> clueCounter, List<ColorPegs> clue) {
		if (clueCounter.containsKey(clue)) {
			clueCounter.replace(clue, clueCounter.get(clue) + 1);
		} else {
			clueCounter.put(clue, 1);
		}
	}

	private void resetClueCounter(Map<List<ColorPegs>, Integer> clueCounter) {
		clueCounter.clear();
	}

	private List<ColorPegs> minmax() {

		Map<List<ColorPegs>, Integer> clueCounter = new LinkedHashMap<>();

		// Per ogni possibile combinazione riporta il numero minimo di eliminati dalle
		// possibili soluzioni
		Map<List<ColorPegs>, Integer> guessScores = new LinkedHashMap<>();
		List<List<ColorPegs>> nextAttempts = new ArrayList<List<ColorPegs>>();

		for (List<ColorPegs> guess : this.combinationSet) {
			for (List<ColorPegs> possibleSolution : this.possibleSolutions) {
				reference = new BoardModel(this.seqLength, 10);
				reference.setSequenceToGuess(possibleSolution);
				reference.addAttempt(guess);
				addClueCounter(clueCounter, reference.getLastClue());
			}
			
			clueCounter.entrySet().stream()
					.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
			System.out.println("FINE clueCounter di " + guess);
			int maxCount = Collections.max(clueCounter.values());
			guessScores.put(guess, (possibleSolutions.size() - maxCount));

			this.resetClueCounter(clueCounter);
		}

		// Colleziono i possibili tentativi con il numero maggiore di tutti di punti
		int maxCount = Collections.max(guessScores.values());
		guessScores.entrySet().stream().filter(entry -> entry.getValue() == maxCount)
				.forEach(entry -> nextAttempts.add(entry.getKey()));

		for (List<ColorPegs> possibleSolution : nextAttempts) {
			for (List<ColorPegs> compatibleSolution : this.possibleSolutions) {
				if (compatibleSolution.equals(possibleSolution)) {
					return possibleSolution;
				}
			}
		}

		for (List<ColorPegs> possibleSolution : nextAttempts) {
			for (List<ColorPegs> compatibleSolution : this.combinationSet) {
				if (compatibleSolution.equals(possibleSolution)) {
					return possibleSolution;
				}
			}
		}

		return currentAttempt;
	}

	@Override
	public void setLastClue(List<ColorPegs> lastClue) {
		super.setLastClue(lastClue);
		reference = new BoardModel(this.seqLength, 10);
		reference.setSequenceToGuess(currentAttempt);
		Iterator<List<ColorPegs>> it = this.possibleSolutions.iterator();
		while (it.hasNext()) {
			List<ColorPegs> seq = it.next();
			reference.addAttempt(seq);
			System.out.println("Last Clue corrente: " + this.getLastClue());
			System.out.println("Ultimo tentativo: " + this.currentAttempt);
			System.out.println("Sequenza tentativo corrente: " + seq);
			System.out.println("Indizio correlato: " + reference.getLastClue());
			if (!reference.getLastClue().equals(this.getLastClue())) {
				this.possibleSolutions.remove(seq);
				it = this.possibleSolutions.iterator();
			}
			System.out.println("PossibleSolutions: " + possibleSolutions.size());
			reference.removeLastAttemptAndClue();
		}
	}
}
