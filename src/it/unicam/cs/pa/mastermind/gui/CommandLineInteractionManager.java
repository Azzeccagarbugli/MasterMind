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
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_CYAN = "\033[0;36m";

	@Override
	public List<Integer> getSequence(int sequenceLength, boolean toGuess) {
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
				} while (temp < 1 || temp > sequenceLength);
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
		System.out.format("%s %57s %22s \n", "|", ANSI_CYAN + "Your current combination" + ANSI_RESET, "|");
		System.out.println("+----------------------------------+----------------------------------+");
		System.out.format("|%20s %14s %19s %14s\n", "Attempt", "|", "Clue", "|");
		System.out.println("+----------------------------------+----------------------------------+");
		System.out.format("%s %34s %34s \n", "|", "|", "|");
		attemptsAndClues.stream().forEach(entry -> System.out.format("| %-68s | %-68s |\n",
				beautifyTable(entry.getKey()), beautifyTable(entry.getValue())));
		System.out.format("%s %34s %34s \n", "|", "|", "|");
		System.out.println("+----------------------------------+----------------------------------+");
	}

	public void showGame(List<ColorPegs> toGuess, Set<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues) {
		System.out.println("The current secret sequence is this one: " + toGuess + "\n");
		System.out.println("+---------------------------------------------------------------------+");
		System.out.format("%s %57s %22s \n", "|", ANSI_CYAN + "Your current combination" + ANSI_RESET, "|");
		System.out.println("+----------------------------------+----------------------------------+");
		System.out.format("|%20s %14s %19s %14s\n", "Attempt", "|", "Clue", "|");
		System.out.println("+----------------------------------+----------------------------------+");
		System.out.format("%s %34s %34s \n", "|", "|", "|");
		attemptsAndClues.stream().forEach(entry -> System.out.format("| %-68s | %-68s |\n",
				beautifyTable(entry.getKey()), beautifyTable(entry.getValue())));
		System.out.format("%s %34s %34s \n", "|", "|", "|");
		System.out.println("+----------------------------------+----------------------------------+");
	}

	/**
	 * Metodo privato che aggiunge una nota colorata per ogni pedina inserita
	 * all'interno della tabella ASCII generata dal metodo <code>showGame</code>.
	 * 
	 * @param list
	 */
	private String beautifyTable(List<ColorPegs> list) {
		String combination = "[ ";

		for (ColorPegs entry : list) {
			switch (entry) {
			case RED:
				combination += ANSI_RED + entry + ANSI_RESET + " ";
				break;
			case YELLOW:
				combination += ANSI_YELLOW + entry + ANSI_RESET + " ";
				break;
			case BLUE:
				combination += ANSI_BLUE + entry + ANSI_RESET + " ";
				break;
			case BLACK:
				combination += ANSI_BLACK + entry + ANSI_RESET + " ";
				break;
			case GREEN:
				combination += ANSI_GREEN + entry + ANSI_RESET + " ";
				break;
			case WHITE:
				combination += ANSI_WHITE + entry + ANSI_RESET + " ";
				break;
			case PURPLE:
				combination += ANSI_PURPLE + entry + ANSI_RESET + " ";
				break;
			case ORANGE:
				combination += ANSI_RED + entry + ANSI_RESET + " ";
				break;
			default:
				break;
			}
		}
		combination += "]";
		return combination;
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

	public static void main(String[] args) {
		Board bb = new Board();
		BoardCoordinator cord = new BoardCoordinator(bb);
		CommandLineInteractionManager command = new CommandLineInteractionManager();
		bb.setSequenceToGuess(List.of(ColorPegs.RED, ColorPegs.PURPLE, ColorPegs.YELLOW, ColorPegs.WHITE));
		cord.insertNewAttempt(List.of(ColorPegs.PURPLE, ColorPegs.RED, ColorPegs.YELLOW, ColorPegs.WHITE));

		command.showGame(bb.getSequenceToGuess(), bb.getAttemptAndClueSet());

		if (cord.checkEnd(new HumanBreaker(command))) {
			command.ending();
		}

	}

}
