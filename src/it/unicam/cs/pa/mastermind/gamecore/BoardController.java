package it.unicam.cs.pa.mastermind.gamecore;

import java.util.List;


public class BoardController {


	private BoardModel board;


	public BoardController(BoardModel newBoard) {
		this.board = newBoard;
	}


	public boolean insertNewAttempt(List<ColorPegs> attempt) {
		try {
			board.addAttempt(attempt);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	public boolean insertCodeToGuess(List<ColorPegs> toGuess) {
		try {
			board.setSequenceToGuess(toGuess);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}


	public BoardModel getBoardReference() {
		return this.board;
	}

}
