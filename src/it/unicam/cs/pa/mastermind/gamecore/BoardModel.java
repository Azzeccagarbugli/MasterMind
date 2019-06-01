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
 * Immagazzina i dati relativi alla plancia di gioco, quali posizione e natura
 * dei pioli codice e dei pioli chiave. Fornisce informazioni sullo stato di
 * gioco alle classi che lo gestiscono (Coordinator, Starter e
 * InteractionManager).
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BoardModel {

	private List<BoardObserver> observers;
	/**
	 * Lista di ColorPegs contenente la sequenza da indovinare.
	 */
	private List<ColorPegs> sequenceToGuess;

	/**
	 * Mappa composta da entry aventi due liste di ColorPegs e rappresentante la
	 * board di gioco.
	 */
	private Map<List<ColorPegs>, List<ColorPegs>> board;

	/**
	 * Numero massimo di tentativi possibili per indovinare la sequenza.
	 */
	private final int maxAttempts;

	/**
	 * Lunghezza massima della sequenza da inserire.
	 */
	private final int sequenceLength;

	/**
	 * Costruttore che riceve come parametri la lunghezza delle sequenze di pioli e
	 * il numero massimo di tentativi disponibili.
	 * 
	 * @param sequenceLength lunghezza della sequenza inserita
	 * @param maxAttempts    numero di tentativi possibii per indovindare la
	 *                       sequenza
	 */
	public BoardModel(int sequenceLength, int maxAttempts) {
		this.board = new LinkedHashMap<List<ColorPegs>, List<ColorPegs>>();
		this.sequenceToGuess = new ArrayList<ColorPegs>();
		this.sequenceLength = sequenceLength;
		this.maxAttempts = maxAttempts;
		observers = new ArrayList<BoardObserver>();
	}

	/**
	 * Restituisce la lunghezza della sequenza da inserire.
	 * 
	 * @return la lunghezza della sequenza
	 */
	public int getSequenceLength() {
		return this.sequenceLength;
	}

	/**
	 * Restituisce la sequenza di pioli da indovinare.
	 * 
	 * @return la lista composta da ColorPegs contente la sequenza da indovinare
	 */
	public List<ColorPegs> getSequenceToGuess() {
		return new ArrayList<ColorPegs>(this.sequenceToGuess);
	}



	/**
	 * Imposta la sequenza di pioli da indovinare.
	 * 
	 * @param toGuess lista di ColorPegs della sequenza da indovinare
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
	 * Restituisce il numero di tentativi rimanenti.
	 * 
	 * @return il numero di tentativi rimasti
	 */
	public int leftAttempts() {
		return maxAttempts - board.size();
	}

	/**
	 * Restituisce il numero di tentativi inseriti fino ad ora.
	 * 
	 * @return il numero di tentativi inseriti fino ad ora
	 */
	public int attemptsInserted() {
		return board.size();
	}

	/**
	 * Metodo che stabilisce se la plancia di gioco è completamente vuota o meno.
	 * 
	 * @return un booleano a seconda dello stato vuoto o meno della plancia
	 */
	public boolean isBoardEmpty() {
		return board.isEmpty();
	}

	/**
	 * Aggiunge alla plancia una nuova sequenza di pioli tentativo e la relativa
	 * sequenza di pioli indizio, calcolata all'interno del metodo
	 * 
	 * @param attempt la sequenza da inserire
	 * @return booleano relativo alla riuscita dell'inserimento
	 * @throws IllegalArgumentException in caso di inserimento illegale
	 */
	public boolean addAttempt(List<ColorPegs> attempt) throws IllegalArgumentException {
		if (attempt.size() != this.sequenceLength) {
			throw new IllegalArgumentException("The insertion attempt is not valid");
		} else {
			board.put(attempt, getClueFromAttempt(attempt, this.sequenceToGuess));
			this.notifyObservers();
			return true;
		}
	}

	/**
	 * Metodo privato a cui passare una sequenza quale nuovo tentativo per ottenere
	 * la relativa sequenza indizio.
	 * 
	 * @param attempt la lista che si inserisce come tentativo di risoluzione.
	 * @param toGuess la lista che contiene la sequenza da indovinare.
	 * @return List<ColorPegs> di indizi generata automaticamente a partire dalla
	 *         lista di tentativi.
	 */
	public List<ColorPegs> getClueFromAttempt(List<ColorPegs> attempt, List<ColorPegs> toGuess) {
		List<ColorPegs> attemptCopy = new ArrayList<ColorPegs>(attempt),
				toGuessCopy = new ArrayList<ColorPegs>(toGuess), clue = new ArrayList<ColorPegs>();
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
	 * Restituisce l'ultima sequenza di pioli tentativo inseriti e la relativa
	 * sequenza di pioli indizio.
	 * 
	 * @return l'utlima sequenza di pioli tentativo inseriti e la lista di indizi
	 *         relativi a quest'ultima
	 */
	public Map.Entry<List<ColorPegs>, List<ColorPegs>> lastAttemptAndClue() {
		Map.Entry<List<ColorPegs>, List<ColorPegs>> temp = null;
		Iterator<Map.Entry<List<ColorPegs>, List<ColorPegs>>> it = this.board.entrySet().iterator();
		while (it.hasNext()) {
			temp = it.next();
		}
		return temp;
	}

	public void addObserver(BoardObserver observer) {
		observers.add(observer);
		this.notifyObservers();
	}

	private void notifyObservers() {
		for (BoardObserver obs : observers) {
			obs.update();
		}
	}
	
	/**
	 * Metodo che restituisce le entry di tentativi e relativi indizi all'interno di
	 * un'unica lista.
	 * 
	 * @return la lista contenente le sequenze relative a tentativi e indizi.
	 */
	public List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> getAttemptAndClueList() {
		ArrayList<Map.Entry<List<ColorPegs>, List<ColorPegs>>> newList = new ArrayList<>();
		board.forEach((key, value) -> newList.add(Map.entry(key, value)));
		return newList;
	}
	
	/**
	 * Indica la vittoria o meno del breaker.
	 * 
	 * @return un booleano che indica se il giocatore Breaker ha indovinato o meno
	 *         la sequenza del maker
	 */
	public boolean hasBreakerGuessed() {
		if (!isBoardEmpty() && lastAttemptAndClue().getValue().size() == sequenceLength
				&& lastAttemptAndClue().getValue().stream().allMatch(peg -> peg == ColorPegs.BLACK))
			return true;
		else
			return false;
	}
	


}
