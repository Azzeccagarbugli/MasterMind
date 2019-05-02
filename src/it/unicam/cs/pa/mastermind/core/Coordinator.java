package it.unicam.cs.pa.mastermind.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
public class Coordinator {

	/**
	 * Riceve come argomento una nuova sequenza da inserire nella plancia come nuovo
	 * tentativo. Inserisce nella plancia anche la sequenza di pioli indizio
	 * relativa.
	 * 
	 * @param attempt
	 * @param boardToUpdate
	 * @return
	 */
	public boolean insertNewAttempt(List<ColorPegs> attempt, Board boardToUpdate) {
		try {
			boardToUpdate.addAttempt(attempt, getClueFromAttempt(attempt, boardToUpdate.getSequenceToGuess()));
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
	public boolean checkEnd(CodeBreaker breaker, Board boardToUpdate) {
		if (breaker.isGiveUp() || boardToUpdate.leftAttempts() == 0
				|| boardToUpdate.lastAttemptAndClue().getValue().stream().allMatch(peg -> peg == ColorPegs.BLACK)) {
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
	public boolean insertCodeToGuess(List<ColorPegs> toGuess, Board boardToUpdate) {
		try {
			boardToUpdate.setSequenceToGuess(toGuess);
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
		List<ColorPegs> clue = new ArrayList<ColorPegs>();
		Iterator<ColorPegs> itTG = toGuess.iterator();
		Iterator<ColorPegs> itAC;
		ColorPegs pegTG;
		ColorPegs pegAC;
		while (itTG.hasNext()) {
			pegTG = itTG.next();
			itAC = attemptCopy.iterator();
			while (itAC.hasNext()) {
				pegAC = itAC.next();
				if (pegTG == pegAC) {
					if (toGuess.indexOf(pegTG) == attemptCopy.indexOf(pegAC)) {
						clue.add(ColorPegs.BLACK);
					} else {
						clue.add(ColorPegs.WHITE);
					}
					/*
					 * Per ogni posizione confermata inseriamo null all'interno della struttura
					 * AttemptCopy, in questo modo avremo delle occorrenze non nulle per ogni coppia
					 * ancora non identificata come corretta
					 */
					
					System.out.println("Prima di modifica: " + attemptCopy);
					System.out.println("PegAC: " + pegAC + " - PegTG: " + pegTG);
					attemptCopy.set(attemptCopy.indexOf(pegAC), null);
					
					System.out.println("Dopo modifica: " + attemptCopy + "\n");
					
					break;
				}
			}
		}
		Collections.shuffle(clue);
		return clue;
	}
}
