package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.BoardController;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.players.RandomBotMaker;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * Test di controllo utili alla generazione di un player codficatore di natura
 * bot.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class PlayersRandomBotMakerTest {

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.RandomBotMaker#getCodeToGuess(int, it.unicam.cs.pa.mastermind.ui.InteractionManager)}.
	 */
	@Test
	void testGetCodeToGuess() {
		RandomBotMaker newBotMaker = new RandomBotMaker();
		BoardModel boardTemp = new BoardModel(4, 9);
		BoardController boardController = new BoardController(boardTemp);
		List<ColorPegs> listToGuess = newBotMaker.getCodeToGuess(new InteractionView() {
			
			@Override
			public void update() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public List<Integer> getIndexSequence(boolean toGuess) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void endingScreen(String gameEndingMessage, List<ColorPegs> toGuess) {
				// TODO Auto-generated method stub
				
			}
		});
		boardController.insertCodeToGuess(listToGuess);
		assertEquals(listToGuess, boardTemp.getSequenceToGuess());
	}
}
