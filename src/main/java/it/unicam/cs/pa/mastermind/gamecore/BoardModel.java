package it.unicam.cs.pa.mastermind.gamecore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import it.unicam.cs.pa.mastermind.ui.BoardObserver;

/**
 * <b>Responsabilità</b>: gestire le informazioni relative ad una plancia di
 * gioco.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BoardModel {

	/**
	 * Una lista di <code>BoardObserver</code> in cui verranno immagazinati gli
	 * observer dell'istanza attiva.
	 */
	private List<BoardObserver> observers;

	/**
	 * Sequenza di <code>ColorPegs</code> da indovinare.
	 */
	private List<ColorPegs> sequenceToGuess;

	/**
	 * Map contenente le sequenze di <code>ColorPegs</code> tentativo e le relative
	 * sequenze di <code>ColorPegs</code> indizio.
	 */
	private Map<List<ColorPegs>, List<ColorPegs>> board;

	/**
	 * Numero massimo di tentativi possibili per indovinare la
	 * <code>sequenceToGuess</code>.
	 */
	private final int maxAttempts;

	/**
	 * Lunghezza massima delle sequenze presenti in questa plancia.
	 */
	private final int sequenceLength;

	/**
	 * Costruttore di una plancia
	 * 
	 * @param sequenceLength massima delle sequenze presenti in questa plancia
	 * @param maxAttempts    numero massimo di tentativi possibili per indovinare la
	 *                       <code>sequenceToGuess</code>
	 */
	public BoardModel(int sequenceLength, int maxAttempts) {
		this.board = new LinkedHashMap<List<ColorPegs>, List<ColorPegs>>();
		this.sequenceToGuess = new ArrayList<ColorPegs>();
		this.sequenceLength = sequenceLength;
		this.maxAttempts = maxAttempts;
		observers = new ArrayList<BoardObserver>();
	}

	/**
	 * @return int lunghezza massima delle sequenze presenti in questa plancia
	 */
	public int getSequenceLength() {
		return this.sequenceLength;
	}

	/**
	 * 
	 * @return List di <code>ColorPegs</code> da indovinare.
	 */
	public List<ColorPegs> getSequenceToGuess() {
		return new ArrayList<ColorPegs>(this.sequenceToGuess);
	}

	/**
	 * Imposta la sequenza di pioli da indovinare.
	 * 
	 * @param toGuess lista di <code>ColorPegs</code> della sequenza da indovinare
	 * @throws IllegalArgumentException se la lunghezza della sequenza inserita non
	 *                                  è valida
	 * @return un booleano a seconda della riuscita o meno dell'inserimento nella
	 *         plancia di gioco
	 */
	public boolean setSequenceToGuess(List<ColorPegs> toGuess) throws IllegalArgumentException {
		if (toGuess.size() != this.sequenceLength) {
			throw new IllegalArgumentException("The lenght of the sequence is not valid");
		} else {
			this.sequenceToGuess = toGuess;
			this.notifyObservers();
			return true;
		}
	}

	/**
	 * @return int numero di tentativi rimasti
	 */
	public int leftAttempts() {
		return maxAttempts - board.size();
	}

	/**
	 * @return int numero di tentativi inseriti fino ad ora
	 */
	public int attemptsInserted() {
		return board.size();
	}

	/**
	 * 
	 * @return boolean che indica se sono stati inseriti o meno tentativi nella
	 *         plancia
	 */
	public boolean isBoardEmpty() {
		return board.isEmpty();
	}

	/**
	 * Aggiunge alla plancia una nuova sequenza di pioli tentativo e la relativa
	 * sequenza di pioli indizio, calcolata all'interno del metodo
	 * 
	 * @param attempt la sequenza da inserire
	 * @return boolean relativo alla riuscita dell'inserimento
	 * @throws IllegalArgumentException in caso di inserimento illegale
	 */
	public boolean addAttempt(List<ColorPegs> attempt) throws IllegalArgumentException {
		if (attempt.size() != this.sequenceLength) {
			throw new IllegalArgumentException("The insertion attempt is not valid");
		} else {
			board.put(attempt, getClueFromAttempt(attempt));
			this.notifyObservers();
			return true;
		}
	}

	/**
	 * Calcolo della sequenza di <code>ColorPegs</code> indizio a fronte di una
	 * sequenza di <code>ColorPegs</code> assicurata valida come tentativo.
	 * 
	 * @param attempt la lista che si inserisce come tentativo di risoluzione.
	 * @param toGuess la lista che contiene la sequenza da indovinare.
	 * @return List di indizi generata a partire dalla lista di tentativi.
	 */
	public List<ColorPegs> getClueFromAttempt(List<ColorPegs> attempt) {
		List<ColorPegs> attemptCopy = new ArrayList<ColorPegs>(attempt),
				toGuessCopy = new ArrayList<ColorPegs>(this.sequenceToGuess), clue = new ArrayList<ColorPegs>();
		IntStream.range(0, attemptCopy.size()).forEach(i -> {
			if (toGuessCopy.get(i) == attemptCopy.get(i)) {
				clue.add(ColorPegs.BLACK);
				attemptCopy.set(i, null);
				toGuessCopy.set(i, null);
			}
		});
		IntStream.range(0, attemptCopy.size()).forEach(i -> {
			if (attemptCopy.get(i) != null && toGuessCopy.contains(attemptCopy.get(i))) {
				clue.add(ColorPegs.WHITE);
				toGuessCopy.set(toGuessCopy.indexOf(attemptCopy.get(i)), null);
				attemptCopy.set(i, null);
			}
		});
		Collections.shuffle(clue);
		return clue;
	}

	/**
	 * 
	 * @return Map.Entry contenente l'ultima sequenza di <code>ColorPegs</code>
	 *         inserita come tentativo e la relativa sequenza indizio.
	 */
	public Map.Entry<List<ColorPegs>, List<ColorPegs>> lastAttemptAndClue() {
		Map.Entry<List<ColorPegs>, List<ColorPegs>> temp = null;
		Iterator<Map.Entry<List<ColorPegs>, List<ColorPegs>>> it = this.board.entrySet().iterator();
		while (it.hasNext()) {
			temp = it.next();
		}
		return temp;
	}

	/**
	 * @return List contenenti Map.Entry con le sequenze di <code>ColorPegs</code>
	 *         inserite come tentativo e le relative sequenze indizio
	 */
	public List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> getAttemptAndClueList() {
		ArrayList<Map.Entry<List<ColorPegs>, List<ColorPegs>>> newList = new ArrayList<>();
		board.forEach((key, value) -> newList.add(Map.entry(key, value)));
		return newList;
	}

	/**
	 * @return boolean che indica se il giocatore Breaker ha indovinato o meno la
	 *         sequenza del Maker in base alle informazioni contenute nella plancia
	 */
	public boolean hasBreakerGuessed() {
		if (!isBoardEmpty() && lastAttemptAndClue().getValue().size() == sequenceLength
				&& lastAttemptAndClue().getValue().stream().allMatch(peg -> peg == ColorPegs.BLACK))
			return true;
		else
			return false;
	}

	/**
	 * Metodo il quale registra un nuovo <code>BoardObserver</code> e notifica tutti
	 * i <code>BoardObserver</code> attualmente associati all'istanza di
	 * <code>BoardModel</code>.
	 * 
	 * @param observer nuova istanza di <code>BoardObserver</code> da aggiungere
	 */
	public void addObserver(BoardObserver observer) {
		observers.add(observer);
		this.notifyObservers();
	}

	/**
	 * Metodo che notifica ogni observer iscritto al registro <code>observers</code> del cambio di stato dell'istanza di <code>BoardModel</code> su cui è chiamato.
	 */
	private void notifyObservers() {
		for (BoardObserver obs : observers) {
			obs.update();
		}
	}
}
