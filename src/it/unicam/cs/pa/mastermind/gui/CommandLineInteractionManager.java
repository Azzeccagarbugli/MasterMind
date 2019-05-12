package it.unicam.cs.pa.mastermind.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import it.unicam.cs.pa.mastermind.exceptions.BreakerGiveUpException;
import it.unicam.cs.pa.mastermind.exceptions.EndingException;
import it.unicam.cs.pa.mastermind.pegs.*;

/**
 * Interazione con l'utente durante il gioco via linea di comando
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class CommandLineInteractionManager implements InteractionManager {

	/**
	 * Di seguito i vari colori disponibili per la codifica ANSI.
	 */
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_WHITE_BOLD = "\033[1;37m";
	private static final String ANSI_CYAN_BOLD = "\033[1;96m";
	private static final String ANSI_BLACK_BACKGROUND = "\033[40m";
	private static final String ANSI_RED_BACKGROUND = "\033[0;101m";
	private static final String ANSI_GREEN_BACKGROUND = "\033[0;102m";
	private static final String ANSI_YELLOW_BACKGROUND = "\033[0;103m";
	private static final String ANSI_BLUE_BACKGROUND = "\033[0;104m";
	private static final String ANSI_PURPLE_BACKGROUND = "\033[0;105m";
	private static final String ANSI_WHITE_BACKGROUND = "\033[0;107m";
	private static final String ANSI_CYAN_BACKGROUND = "\033[0;106m";

	/**
	 * Inizializzazione di un nuovo BufferReader.
	 */
	private BufferedReader reader;

	/**
	 * Costruisco l'elemento <code>CommandLineInteractionManager</code>, il quale
	 * permette l'interazione tra il gioco e i vari player disponibili.
	 * 
	 * @param newReader il BufferReader necessario alla generazione della classe
	 */
	public CommandLineInteractionManager(BufferedReader newReader) {
		this.reader = newReader;
	}

	@Override
	public List<Integer> getIndexSequence(int sequenceLength, boolean toGuess) {
		List<Integer> indexPegs = new ArrayList<Integer>();
		System.out.println(toGuess ? "\nDefining the sequence to guess" : "\nDefining an attempt");
		try {
			System.out.print("Please define the color of each of the pegs knowing that: " + "\n");
			IntStream.range(0, ColorPegs.values().length)
					.mapToObj(
							index -> String.format("[%s - %d] ", beautifyGeneral(ColorPegs.values()[index]), index + 1))
					.forEach(System.out::print);
			System.out.println();
			for (int i = 1; i <= sequenceLength; i++) {
				this.askIndexOfPegs(indexPegs, i);
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return indexPegs;
	}

	@Override
	public void showGame(List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues) {
		System.out.println("+---------------------------------------------------------------------+");
		System.out.format("%s %57s %22s \n", "|", ANSI_CYAN_BOLD + "Your current combination" + ANSI_RESET, "|");
		String attemptWhiteBold = ANSI_WHITE_BOLD + "Attempt" + ANSI_RESET;
		String clueWhiteBold = ANSI_WHITE_BOLD + "Clue" + ANSI_RESET;
		System.out.println("+----------------------------------+----------------------------------+");
		System.out.format("|%31s %14s %30s %14s\n", attemptWhiteBold, "|", clueWhiteBold, "|");
		System.out.println("+----------------------------------+----------------------------------+");
		attemptsAndClues.stream().forEach(entry -> System.out.format("| %-34s %2s %-80s",
				beautifyAttempts(entry.getKey()), "|", beautifyClues(entry.getValue())));
	}

	@Override
	public void showGame(List<ColorPegs> toGuess, List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues) {
		int dynamicTable = toGuess.size();
		System.out.println("\nThe current secret sequence is this one: " + toGuess + "\n");
		showGameBasingOnLenght(dynamicTable, ANSI_WHITE_BOLD + "Attempt" + ANSI_RESET,
				ANSI_WHITE_BOLD + "Clue" + ANSI_RESET);
		attemptsAndClues.stream().forEach(entry -> System.out.format("| %-34s %-80s", beautifyAttempts(entry.getKey()),
				beautifyClues(entry.getValue())));
	}

	/**
	 * Metodo necessario alla creazione del disegno tabulare che contiene le
	 * informazioni di gioco.
	 * 
	 * @param size         la launghezza dell'array che viene inserito come
	 *                     parametro locale
	 * @param attemptLabel il nome dell'etichetta che si vuole dare al titolo dei
	 *                     tentativi inseriti
	 * @param clueLabel    il nome dell'etichetta che si vuole dare al titolo degli
	 *                     indizi generati
	 */
	public void showGameBasingOnLenght(int size, String attemptLabel, String clueLabel) {
		if (size < 5) {
			System.out.format(String.format("\n+%69s+\n", " ").replace(' ', '-'));
			System.out.format("%s %57s %22s \n", "|", ANSI_CYAN_BOLD + "Your current combination" + ANSI_RESET, "|");
			System.out.format(String.format("+%69s+\n", " ").replace(' ', '-'));
			System.out.format("|%31s %14s %30s %14s\n", attemptLabel, "|", clueLabel, "|");
			System.out.format(String.format("+%69s+\n", " ").replace(' ', '-'));
		} else {
			System.out.format(String.format("\n+%130s+\n", " ").replace(' ', '-'));
			System.out.format("%s %114s %44s \n", "|", ANSI_CYAN_BOLD + "Your current combination" + ANSI_RESET, "|");
			System.out.format(String.format("+%138s+\n", " ").replace(' ', '-'));
			System.out.format("|%62s %28s %60s %28s\n", attemptLabel, "|", clueLabel, "|");
			System.out.format(String.format("+%130s+\n", " ").replace(' ', '-'));
		}
	}

	/**
	 * Dato un colore sottoforma di ColorPegs viene restituito il suo corrispetivo
	 * secondo i canoni della decodifica ANSI.
	 * 
	 * @param color il colore che si vuole codificare in una stringa colorata
	 * @return la stringa contenente i valori della stringa visualizzati in
	 *         modalità colorata
	 */
	public String beautifyGeneral(ColorPegs color) {
		String colorfulPeg = new String();
		switch (color) {
		case RED:
			colorfulPeg += ANSI_RED_BACKGROUND + "      " + ANSI_RESET + " ";
			break;
		case YELLOW:
			colorfulPeg += ANSI_YELLOW_BACKGROUND + "      " + ANSI_RESET + " ";
			break;
		case BLUE:
			colorfulPeg += ANSI_BLUE_BACKGROUND + "      " + ANSI_RESET + " ";
			break;
		case GREEN:
			colorfulPeg += ANSI_GREEN_BACKGROUND + "      " + ANSI_RESET + " ";
			break;
		case PURPLE:
			colorfulPeg += ANSI_PURPLE_BACKGROUND + "      " + ANSI_RESET + " ";
			break;
		case CYAN:
			colorfulPeg += ANSI_CYAN_BACKGROUND + "      " + ANSI_RESET + " ";
			break;
		case WHITE:
			colorfulPeg += ANSI_WHITE_BACKGROUND + "      " + ANSI_RESET + " ";
			break;
		case BLACK:
			colorfulPeg += ANSI_BLACK_BACKGROUND + "      " + ANSI_RESET + " ";
			break;
		default:
			break;
		}
		return colorfulPeg;
	}

	@Override
	public boolean[] ending(EndingException exe) {
		System.out.println(exe.getMessage());
		int intInput = 0;
		try {
			System.out.println("\nThe game has finished, what would you like to do now?");
			while (!((intInput >= 1) && (intInput <= 3))) {
				System.out.print("- Start a new game with the same settings [1]" + "\n"
						+ "- Start a new game with different settings [2]" + "\n" + "- Exit from the game [3]"
						+ "\n> ");
				try {
					intInput = Integer.parseInt(this.reader.readLine());
				} catch (NumberFormatException e) {
					System.out.println("Please insert a numeric value");
				}
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		boolean[] endingSettings = settingEnd(intInput);
		return endingSettings;
	}

	public boolean askGiveUp(){
		String strInput = "";
		try {
			while (!(strInput.toLowerCase().equals("y") ^ strInput.toLowerCase().equals("n"))) {
				System.out.print("\nWould you like to give up the match? [Y/N]" + "\n" + "> ");
				strInput = reader.readLine();
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return (strInput.toLowerCase().equals("y") ? true : false);
	}

	private void askIndexOfPegs(List<Integer> list, int index) throws IOException {
		int temp = 0;
		do {
			System.out.print("Insert value nr." + index + " > ");
			try {
				temp = Integer.parseInt(this.reader.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Please insert a numeric value");
			}
		} while (temp < 1 || temp > ColorPegs.values().length);
		list.add(temp - 1);
	}

	/**
	 * Metodo privato che formatta in maniera corretta la visualizzazione della
	 * tabella in base alla lunghezza della sequenza delle pedine indizio.
	 * 
	 * @param size la dimensione dell'array passato come paramentro locale
	 * @return la distanza dall'ultimo carattere in maniera dinamica per permettere
	 *         una migliore visualizzazione
	 */
	private int dynamicTableLenght(int size) {
		switch (size) {
		case 0:
			return 30;
		case 1:
			return 23;
		case 2:
			return 16;
		case 3:
			return 9;
		case 4:
			return 2;
		default:
			return 45;
		}
	}

	/**
	 * Metodo privato che aggiunge una nota colorata per ogni sequenza di pedine
	 * indizio visualizzata all'interno della tabella ASCII generata dal metodo
	 * <code>showGame</code>.
	 * 
	 * @param cluesList la lista di pedine indizio
	 * @return la stringa contenente la corriespetiva sequenza colorata
	 */
	private String beautifyClues(List<ColorPegs> cluesList) {
		String clueCombination = "[ ";
		for (ColorPegs clue : cluesList) {
			clueCombination += beautifyGeneral(clue);
		}
		clueCombination += String.format("] %" + dynamicTableLenght(cluesList.size()) + "s \n", "|");
		clueCombination += String.format("%s %34s %34s \n", "|", "|", "|");
		clueCombination += "+----------------------------------+----------------------------------+\n";

		return clueCombination;
	}

	/**
	 * 
	 * Metodo privato che aggiunge una nota colorata per ogni sequenza di pedine
	 * tentativo inserite all'interno della tabella ASCII generata dal metodo
	 * <code>showGame</code>.
	 * 
	 * @param attemptsList la lista di pedine tentativo inserite
	 * @return la stringa contenente la corriespetiva sequenza colorata
	 */
	private String beautifyAttempts(List<ColorPegs> attemptsList) {
		System.out.format("%s %34s %34s\n", "|", "|", "|");
		String attemptCombination = "[ ";

		for (ColorPegs attempt : attemptsList) {
			attemptCombination += beautifyGeneral(attempt);
		}
		attemptCombination += String.format("] %" + dynamicTableLenght(attemptsList.size()) + "s", "|");
		return attemptCombination;
	}

	/**
	 * Restituisce le informazioni sull'esito finale della partita, andando a
	 * chiedere all'utente quale settaggi impostare per la prossima.
	 * 
	 * @param input il valore in input selezionato dall'utente
	 * @return l'Array di booleani contenente i settaggi
	 */
	private boolean[] settingEnd(int input) {
		boolean[] endingSettings = new boolean[2];
		switch (input) {
		case 1:
			endingSettings[0] = true;
			endingSettings[1] = true;
			break;
		case 2:
			endingSettings[0] = true;
			endingSettings[1] = false;
			break;
		case 3:
			endingSettings[0] = false;
			endingSettings[1] = false;
			break;
		}
		return endingSettings;
	}
}