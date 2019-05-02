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
import java.util.stream.IntStream;

import it.unicam.cs.pa.mastermind.pegs.*;

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
			 * Di tutto ciò se ne assume la più piena responsabilità lo studente
			 * Francesco Pio Stelluti, colui con il quale lei ha discusso intensamente
			 * riguardo il film della Marvel Avengers: The End Game.
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
	public void showGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean[] ending() {
		// TODO
		return null;
	}

	public static void main(String[] args) {
		CommandLineInteractionManager sassi = new CommandLineInteractionManager();
		System.out.println(sassi.getSequence(10, false));
	}
}
