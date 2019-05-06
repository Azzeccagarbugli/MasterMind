/**
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

	public static final String ANSI_RESET = "\u001B[0m";

	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_WHITE = "\033[0;97m";
	public static final String ANSI_WHITE_BOLD = "\033[1;37m";
	public static final String ANSI_CYAN_BOLD = "\033[1;96m";
	public static final String ANSI_BLACK_BACKGROUND = "\033[40m";
	public static final String ANSI_RED_BACKGROUND = "\033[0;101m";
	public static final String ANSI_GREEN_BACKGROUND = "\033[0;102m";
	public static final String ANSI_YELLOW_BACKGROUND = "\033[0;103m";
	public static final String ANSI_BLUE_BACKGROUND = "\033[0;104m";
	public static final String ANSI_PURPLE_BACKGROUND = "\033[0;105m";
	public static final String ANSI_CYAN_BACKGROUND = "\033[0;106m";
	public static final String ANSI_WHITE_BACKGROUND = "\033[0;107m";
	public static final String ANSI_ORANGE_BACKGROUND = "\033[41m";

	@Override
	public List<Integer> getIndexSequence(int sequenceLength, boolean toGuess) {
		List<Integer> indexPegs = new ArrayList<Integer>();
		if (toGuess) {
			System.out.println("Defining the sequence to guess: ");
		} else {
			System.out.println("Defining an attempt: ");
		}

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

			System.out.print("Please define the color of each of the pegs knowing that: " + "\n");

			/*
			 * Di tutto ciò se ne assume la più piena responsabilità lo studente Francesco
			 * Pio Stelluti, colui con il quale lei ha discusso intensamente riguardo il
			 * film della Marvel Avengers: The End Game.
			 */
			IntStream.range(1, ColorPegs.values().length)
					.mapToObj(index -> String.format("[%s - %d]", ColorPegs.values()[index].toString(), index))
					.forEach(System.out::print);
			System.out.println("");
			for (int i = 1; i <= sequenceLength; i++) {
				int temp = 0;
				do {
					System.out.print("Insert value nr." + i + " > ");
					try {
						temp = Integer.parseInt(reader.readLine());
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
	public void showGame(Set<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues) {
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

	public void showGame(List<ColorPegs> toGuess, Set<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues) {
		System.out.println("The current secret sequence is this one: " + toGuess + "\n");
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

	/**
	 * Metodo privato che aggiunge una nota colorata per ogni sequenza di pedine
	 * tentativo inserita all'interno della tabella ASCII generata dal metodo
	 * <code>showGame</code>.
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
			case ORANGE:
				attemptCombination += ANSI_ORANGE_BACKGROUND + "      " + ANSI_RESET + " ";
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

		attemptCombination += "]";
		return attemptCombination;
	}

	/**
	 * Metodo privato che aggiunge una nota colorata per ogni sequenza di pedine
	 * indizio visualizzata all'interno della tabella ASCII generata dal metodo
	 * <code>showGame</code>.
	 * 
	 * @param cluesList
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
	 * Metodo privato che formatta in maniera corretta la visualizzazione della
	 * tabella in base alla lunghezza della sequenza delle pedine indizio.
	 * 
	 * @param size
	 * @return
	 */
	private int dynamicTableLenght(int size) {
		switch (size) {
		case 1:
			return 20;
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
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int intInput = 0;
			System.out.println("\nThe game has finished, what would you like to do now?");
			while (!((intInput >= 1) && (intInput <= 3))) {
				System.out.print("• Start a new game with the same settings [1]" + "\n"
						+ "• Start a new game with different settings [2]" + "\n• Exit from the game [3]" + "\n> ");
				try {
					intInput = Integer.parseInt(reader.readLine());
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

	public static void main(String[] args) {/*
		Board bb = new Board();
		BoardCoordinator cord = new BoardCoordinator(bb);
		CommandLineInteractionManager command = new CommandLineInteractionManager();
		bb.setSequenceToGuess(List.of(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.YELLOW, ColorPegs.PURPLE));
		cord.insertNewAttempt(List.of(ColorPegs.GREEN, ColorPegs.RED, ColorPegs.YELLOW, ColorPegs.PURPLE));
		cord.insertNewAttempt(List.of(ColorPegs.BLUE, ColorPegs.RED, ColorPegs.YELLOW, ColorPegs.PURPLE));
		cord.insertNewAttempt(List.of(ColorPegs.BLUE, ColorPegs.YELLOW, ColorPegs.ORANGE, ColorPegs.PURPLE));
		cord.insertNewAttempt(List.of(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.YELLOW, ColorPegs.PURPLE));

		command.showGame(bb.getSequenceToGuess(), bb.getAttemptAndClueSet());

		if (cord.checkEnd(new HumanBreaker(command))) {
			command.ending();
		}*/

	}

}
