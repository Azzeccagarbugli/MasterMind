/*
 * 
 */
package it.unicam.cs.pa.mastermind.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import it.unicam.cs.pa.mastermind.core.Board;
import it.unicam.cs.pa.mastermind.core.BoardCoordinator;
import it.unicam.cs.pa.mastermind.pegs.*;
import it.unicam.cs.pa.mastermind.players.HumanBreaker;

/**
 * Interazione con l'utente durante il gioco via linea di comando
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class CommandLineInteractionManager implements InteractionManager {

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

	private BufferedReader reader;

	public CommandLineInteractionManager(BufferedReader newReader) {
		this.reader = newReader;
	}

	@Override
	public List<Integer> getIndexSequence(int sequenceLength, boolean toGuess) {
		List<Integer> indexPegs = new ArrayList<Integer>();
		if (toGuess) {
			System.out.println("\nDefining the sequence to guess");
		} else {
			System.out.println("\nDefining an attempt");
		}

		try {

			System.out.print("Please define the color of each of the pegs knowing that: " + "\n");

			IntStream.range(1, ColorPegs.values().length).mapToObj(
					index -> String.format("[%s - %d] ", beautifyColor(ColorPegs.values()[index].toString()), index))
					.forEach(System.out::print);
			System.out.println("");

			for (int i = 1; i <= sequenceLength; i++) {
				int temp = 0;
				do {
					System.out.print("Insert value nr." + i + " > ");
					try {
						temp = Integer.parseInt(this.reader.readLine());
					} catch (NumberFormatException e) {
						System.out.println("Please insert a numeric value");
					}
				} while (temp < 1 || temp >= ColorPegs.values().length);
				indexPegs.add(temp);
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

	public void showGame(List<ColorPegs> toGuess, List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues) {
		int dynamicTable = toGuess.size();
		System.out.println("\nThe current secret sequence is this one: " + toGuess + "\n");
		
		String attemptWhiteBold = ANSI_WHITE_BOLD + "Attempt" + ANSI_RESET;
		String clueWhiteBold = ANSI_WHITE_BOLD + "Clue" + ANSI_RESET;

		showGameBasingOnLenght(dynamicTable, attemptWhiteBold, clueWhiteBold);

		attemptsAndClues.stream().forEach(entry -> System.out.format("| %-34s %-80s", beautifyAttempts(entry.getKey()),
				beautifyClues(entry.getValue())));
	}

	public void showGameBasingOnLenght(int size, String attemptLabel, String clueLabel) {
		if (size > 0 && size < 5) {
			System.out.format(String.format("\n+%69s+\n", " ").replace(' ', '-'));
			System.out.format("%s %57s %22s \n", "|", ANSI_CYAN_BOLD + "Your current combination" + ANSI_RESET, "|");
			System.out.format(String.format("+%69s+\n", " ").replace(' ', '-'));
			System.out.format("|%31s %14s %30s %14s\n", attemptLabel, "|", clueLabel, "|");
			System.out.format(String.format("+%69s+\n", " ").replace(' ', '-'));
		} else if (size > 4 && size < 9) {
			System.out.format(String.format("\n+%130s+\n", " ").replace(' ', '-'));
			System.out.format("%s %114s %44s \n", "|", ANSI_CYAN_BOLD + "Your current combination" + ANSI_RESET, "|");
			System.out.format(String.format("+%138s+\n", " ").replace(' ', '-'));
			System.out.format("|%62s %28s %60s %28s\n", attemptLabel, "|", clueLabel, "|");
			System.out.format(String.format("+%130s+\n", " ").replace(' ', '-'));
		}

	}

	/*
	 * 
	 * Metodo privato che aggiunge una nota colorata per ogni sequenza di pedine*
	 * tentativo inserita all'interno della tabella ASCII generata dal
	 * metodo*<code>showGame</code>.**
	 * 
	 * @param attemptsList
	 */
	private String beautifyAttempts(List<ColorPegs> attemptsList) {
		System.out.format("%s %34s %34s\n", "|", "|", "|");
		String attemptCombination = "[ ";

		for (ColorPegs attempt : attemptsList) {
			switch (attempt) {
			case RED:
				attemptCombination += ANSI_RED_BACKGROUND + "      " + ANSI_RESET + " ";
				break;
			case YELLOW:
				attemptCombination += ANSI_YELLOW_BACKGROUND + "      " + ANSI_RESET + " ";
				break;
			case BLUE:
				attemptCombination += ANSI_BLUE_BACKGROUND + "      " + ANSI_RESET + " ";
				break;
			case GREEN:
				attemptCombination += ANSI_GREEN_BACKGROUND + "      " + ANSI_RESET + " ";
				break;
			case PURPLE:
				attemptCombination += ANSI_PURPLE_BACKGROUND + "      " + ANSI_RESET + " ";
				break;
			case CYAN:
				attemptCombination += ANSI_CYAN_BACKGROUND + "      " + ANSI_RESET + " ";
				break;
			case WHITE:
				attemptCombination += ANSI_WHITE_BACKGROUND + "      " + ANSI_RESET + " ";
				break;
			case BLACK:
				attemptCombination += ANSI_BLACK_BACKGROUND + "      " + ANSI_RESET + " ";
				break;
			default:
				break;
			}
		}

		attemptCombination += String.format("] %" + dynamicTableLenght(attemptsList.size()) + "s", "|");
		;
		return attemptCombination;
	}

	/*
	 * 
	 * Metodo privato che aggiunge una nota colorata per ogni sequenza di pedine*
	 * indizio visualizzata all'interno della tabella ASCII generata dal
	 * metodo*<code>showGame</code>.**
	 * 
	 * @param cluesList
	 * 
	 * @return
	 */
	private String beautifyClues(List<ColorPegs> cluesList) {
		String clueCombination = "[ ";

		for (ColorPegs clue : cluesList) {
			switch (clue) {
			case WHITE:
				clueCombination += ANSI_WHITE_BACKGROUND + "      " + ANSI_RESET + " ";
				break;
			case BLACK:
				clueCombination += ANSI_BLACK_BACKGROUND + "      " + ANSI_RESET + " ";
				break;
			default:
				break;
			}
		}
		clueCombination += String.format("] %" + dynamicTableLenght(cluesList.size()) + "s \n", "|");
		clueCombination += String.format("%s %34s %34s \n", "|", "|", "|");
		clueCombination += "+----------------------------------+----------------------------------+\n";

		return clueCombination;
	}

	/**
	 * Dato un colore sottoforma di stringa viene restituito il suo corrispetivo
	 * secondo i canoni della decodifica ANSI.
	 * 
	 * @param color
	 * @return
	 */
	private String beautifyColor(String color) {
		switch (color) {
		case "RED":
			return ANSI_RED_BACKGROUND + "      " + ANSI_RESET;
		case "YELLOW":
			return ANSI_YELLOW_BACKGROUND + "      " + ANSI_RESET;
		case "BLUE":
			return ANSI_BLUE_BACKGROUND + "      " + ANSI_RESET;
		case "GREEN":
			return ANSI_GREEN_BACKGROUND + "      " + ANSI_RESET;
		case "PURPLE":
			return ANSI_PURPLE_BACKGROUND + "      " + ANSI_RESET;
		case "CYAN":
			return ANSI_CYAN_BACKGROUND + "      " + ANSI_RESET;
		case "WHITE":
			return ANSI_WHITE_BACKGROUND + "      " + ANSI_RESET;
		case "BLACK":
			return ANSI_BLACK_BACKGROUND + "      " + ANSI_RESET;
		default:
			return new String();
		}
	}

	/**
	 * Metodo privato che formatta in maniera corretta la visualizzazione della
	 * tabella in base alla lunghezza della sequenza delle pedine indizio.
	 * 
	 * @param size
	 * @return
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

	@Override
	public boolean[] ending() {
		boolean[] endingSettings = new boolean[2];
		try {
			int intInput = 0;
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
			switch (intInput) {
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
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return endingSettings;
	}

}