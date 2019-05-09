package it.unicam.cs.pa.mastermind.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.pegs.*;

/**
 * Interagisce continuamente con i giocatori aggiornando la plancia di gioco di
 * conseguenza.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BoardCoordinator {

	/**
	 * Variabile privata relativa alla plancia di gioco corrente.
	 */
	private Board currentBoard;

	/**
	 * Costruttore che va ad inizializzare la nuova plancia di gioco in cui verranno
	 * effettuate le operazioni descritte dai metodi presenti nella medesima classe.
	 * 
	 * @param newBoard la board su cui si vogliono effettuare le operazioni di
	 *                 coordinazione
	 */
	public BoardCoordinator(Board newBoard) {
		this.currentBoard = newBoard;
	}

	/**
	 * Riceve come argomento una nuova sequenza da inserire nella plancia come nuovo
	 * tentativo. Inserisce nella plancia anche la sequenza di pioli indizio
	 * relativa.
	 * 
	 * @param attempt la lista di pioli tentativo che si vuole inserire
	 * @return un booleano che controlla lo stato della operazione,
	 *         <strong>true</strong> se l'operazione è stata effettuata con
	 *         successo o <strong>false</strong> se l'operazione è fallita
	 */
	public boolean insertNewAttempt(List<ColorPegs> attempt) {
		try {
			currentBoard.addAttempt(attempt, getClueFromAttempt(attempt, currentBoard.getSequenceToGuess()));
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	/**
	 * Indica se la partita termina o meno. Puo terminare solo se i tentativi sono
	 * finiti, se il giocatore breaker ha indovinato la sequenza o se, infine, il
	 * giocatore breaker si è arreso.
	 * 
	 * @param breaker il player, che sia Bot o Human, il quale sta cercando di
	 *                decodificare la sequenza
	 * @return un booleano che afferma l'ending positivo o negativo della partita
	 *         corrente
	 */
	public boolean checkEnd(CodeBreaker breaker) {
		if (breaker.isGiveUp() || currentBoard.leftAttempts() == 0
				|| (currentBoard.lastAttemptAndClue().getValue().size() == this.getSequenceLength() && currentBoard
						.lastAttemptAndClue().getValue().stream().allMatch(peg -> peg == ColorPegs.BLACK))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Riceve come argomento la sequenza da inserire nella plancia come sequenza da
	 * indovinare ed effettua la relativa operazione.
	 * 
	 * @param toGuess la lista da indovinare
	 * @return un booleano che afferma il corretto inserimento della sequenza
	 */
	public boolean insertCodeToGuess(List<ColorPegs> toGuess) {
		try {
			currentBoard.setSequenceToGuess(toGuess);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	/**
	 * Metodo privato a cui passare una sequenza quale nuovo tentativo per ottenere
	 * la relativa sequenza indizio.
	 * 
	 * @param attempt la lista che si inserisce come tentativo di risoluzione
	 * @param toGuess la lista che contiene la sequenza da indovinare
	 * @return la lista di indizi generata automaticamente a partire dalla lista di
	 *         tentativi
	 */
	private List<ColorPegs> getClueFromAttempt(List<ColorPegs> attempt, List<ColorPegs> toGuess) {
		List<ColorPegs> attemptCopy = new ArrayList<ColorPegs>(attempt),
				toGuessCopy = new ArrayList<ColorPegs>(toGuess), clue = new ArrayList<ColorPegs>();
		IntStream.range(0, attemptCopy.size()).forEach(i -> {
			if (toGuessCopy.get(i) == attemptCopy.get(i)) {
				clue.add(ColorPegs.BLACK);
				attemptCopy.set(i, ColorPegs.NONE);
				toGuessCopy.set(i, ColorPegs.NONE);
			}
		});
		IntStream.range(0, attemptCopy.size()).forEach(i -> {
			if (attemptCopy.get(i) != ColorPegs.NONE && toGuessCopy.contains(attemptCopy.get(i))) {
				clue.add(ColorPegs.WHITE);
				toGuessCopy.set(toGuessCopy.indexOf(attemptCopy.get(i)), ColorPegs.NONE);
				attemptCopy.set(i, ColorPegs.NONE);
			}
		});
		Collections.shuffle(clue);
		return clue;
	}

	/**
	 * Metodo getter il quale restituisce una lista contenente la sequenza da
	 * indovinare.
	 *
	 * @return l'ArrayList contenente la sequenza da indovinare
	 */
	public List<ColorPegs> getSequenceToGuess() {
		return new ArrayList<ColorPegs>(currentBoard.getSequenceToGuess());
	}

	/**
	 * Metodo che restituisce le entry di tentativi e relativi indizi all'interno di
	 * un'unica lista.
	 * 
	 * @return la lista contenente le sequenze relative a tentativi e indizi
	 */
	public List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> getAttemptAndClueList() {
		ArrayList<Map.Entry<List<ColorPegs>, List<ColorPegs>>> newList = new ArrayList<>();
		this.currentBoard.getAttemptAndClueMap().forEach((key, value) -> newList.add(Map.entry(key, value)));
		return newList;
	}

	/**
	 * Metodo pubblico che restituisce il valore della lunghezza della sequenza
	 * inserita.
	 *
	 * @return un intero che stabilisce la lunghezza della sequenza inserita
	 */
	public int getSequenceLength() {
		return this.currentBoard.getSequenceLength();
	}

}
