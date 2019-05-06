package it.unicam.cs.pa.mastermind.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.pegs.*;

/**
 * Interagisce continuamente con i giocatori aggiornando la plancia di gioco di
 * conseguenza
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BoardCoordinator {

	private Board currentBoard;
	
	public BoardCoordinator(Board newBoard) {
		this.currentBoard = newBoard;
	}
	/**
	 * Riceve come argomento una nuova sequenza da inserire nella plancia come nuovo
	 * tentativo. Inserisce nella plancia anche la sequenza di pioli indizio
	 * relativa.
	 * 
	 * @param attempt
	 * @param boardToUpdate
	 * @return
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
	 * giocatore breaker si e arreso
	 * 
	 * @param breaker
	 * @param boardToUpdate
	 * @return
	 */
	public boolean checkEnd(CodeBreaker breaker) {
		if (breaker.isGiveUp() || currentBoard.leftAttempts() == 0
				|| currentBoard.lastAttemptAndClue().getValue().stream().allMatch(peg -> peg == ColorPegs.BLACK)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Riceve come argomento la sequenza da inserire nella plancia come sequenza da
	 * indovinare ed effettua la relativa operazione
	 * 
	 * @param toGuess
	 * @param boardToUpdate
	 * @return
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
	 * la relativa sequenza indizio
	 * 
	 * @param attempt
	 * @param toGuess
	 * @return
	 */
	private List<ColorPegs> getClueFromAttempt(List<ColorPegs> attempt, List<ColorPegs> toGuess) {
		List<ColorPegs> attemptCopy = new ArrayList<ColorPegs>(attempt);
		List<ColorPegs> toGuessCopy = new ArrayList<ColorPegs>(toGuess);
		List<ColorPegs> clue = new ArrayList<ColorPegs>();
		Iterator<ColorPegs> itTG = toGuessCopy.iterator();
		Iterator<ColorPegs> itAC;
		ColorPegs pegTG;
		ColorPegs pegAC;
		while (itTG.hasNext()) {
			pegTG = itTG.next();
			itAC = attemptCopy.iterator();
			while (itAC.hasNext()) {
				pegAC = itAC.next();
				if (pegTG == pegAC) {
					if (toGuessCopy.indexOf(pegTG) == attemptCopy.indexOf(pegAC)) {
						clue.add(ColorPegs.BLACK);
					} else {
						clue.add(ColorPegs.WHITE);
					}
					/*
					 * Per ogni posizione confermata inseriamo null all'interno della struttura
					 * AttemptCopy, in questo modo avremo delle occorrenze non nulle per ogni coppia
					 * ancora non identificata come corretta
					 */

					/*System.out.println("Prima di modifica TG: " + toGuessCopy);
					System.out.println("PegAC: " + pegAC +" "+attemptCopy.indexOf(pegAC)+ " - PegTG: " + pegTG+" "+toGuessCopy.indexOf(pegTG));*/
					attemptCopy.set(attemptCopy.indexOf(pegAC), ColorPegs.NONE);
					toGuessCopy.set(toGuessCopy.indexOf(pegTG), ColorPegs.NONE);

					/*System.out.println("Dopo modifica TG: " + toGuessCopy+"\n");*/
					break;
				}
			}
		}
		Collections.shuffle(clue);
		return clue;
	}
	
	public List<ColorPegs> getSequenceToGuess() {
		return new ArrayList<ColorPegs>(currentBoard.getSequenceToGuess());
	}
	
	public Set<Map.Entry<List<ColorPegs>, List<ColorPegs>>> getAttemptAndClueSet() {
		return new HashSet<Map.Entry<List<ColorPegs>, List<ColorPegs>>>(currentBoard.getAttemptAndClueSet());
	}
	
	public int getSequenceLength() {
		return this.currentBoard.getSequenceLength();
	}
}
