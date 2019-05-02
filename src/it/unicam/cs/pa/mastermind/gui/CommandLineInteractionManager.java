/**
 * 
 */
package it.unicam.cs.pa.mastermind.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.IntStream;

import it.unicam.cs.pa.mastermind.core.Board;
import it.unicam.cs.pa.mastermind.core.Coordinator;
import it.unicam.cs.pa.mastermind.pegs.*;
import it.unicam.cs.pa.mastermind.players.HumanBreaker;

/**
 * Interazione con l'utente durante il gioco via linea di comando
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class CommandLineInteractionManager implements InteractionManager {

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
			IntStream.range(0, ColorPegs.values().length)
					.mapToObj(index -> String.format("[%s - %d]", ColorPegs.values()[index].toString(), index + 1))
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
				} while (temp <= 0 || temp > sequenceLength);
				indexPegs.add(temp - 1);
			}

		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return indexPegs;
	}

	@Override
	public void showGame(Board board) {
		System.out.println("The current secret sequence is this one: " + board.getSequenceToGuess());
		System.out.println("\n+-------------------------------------------------------------+");
		System.out.format("%s %42s %18s \n", "|", "Your current combination", "|");
		System.out.println("+------------------------------+------------------------------+");
		System.out.format("|%20s %10s %15s %14s\n", "Attempt", "|", "Clue", "|");
		System.out.println("+------------------------------+------------------------------+");
		System.out.format("%s %30s %30s \n", "|", "|", "|");
		board.getAttemptAndClueSet().stream()
				.forEach(entry -> System.out.format("| %s | %s %" + dynamicSpace(entry.getValue().size()) + "s \n",
						entry.getKey(), entry.getValue(), "|"));
		System.out.format("%s %30s %30s \n", "|", "|", "|");
		System.out.println("+------------------------------+------------------------------+");
	}

	/**
	 * Metodo privato che garantisce la giusta formattazione della tabella
	 * 
	 * @param lenght
	 * @return
	 */
	private int dynamicSpace(int lenght) {
		switch (lenght) {
		case 0:
			return 32;
		case 1:
			return 24;
		case 2:
			return 16;
		case 3:
			return 8;
		case 4:
			return 1;
		default:
			System.out.println("Error!");
			return 0;
		}
	}

	@Override
	public boolean[] ending() {
		// TODO
		return null;
	}

	public static void main(String[] args) {
		Board bb = new Board();
		Coordinator cord = new Coordinator();
		CommandLineInteractionManager command = new CommandLineInteractionManager();
		bb.setSequenceToGuess(List.of(ColorPegs.PURPLE, ColorPegs.YELLOW, ColorPegs.BLACK, ColorPegs.RED));
		cord.insertNewAttempt(List.of(ColorPegs.PURPLE, ColorPegs.YELLOW, ColorPegs.BLACK, ColorPegs.RED), bb);
		command.showGame(bb);
	}

}
