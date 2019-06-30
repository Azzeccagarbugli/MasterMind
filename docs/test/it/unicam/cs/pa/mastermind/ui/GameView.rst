.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.gamecore BoardModel

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.gamecore Observer

GameView
========

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public abstract class GameView implements Observer

   \ **Responsabilità**\ : fornire agli utenti fisici coinvolti in una singola partita operazioni di Input/Output. Rientra nel pattern \ **Observer**\  per poter fornire in output all'utente fisico una rappresentazione di quelle che sono le azioni effettuate dai giocatori nel gioco. Rientra nel pattern \ **MVC**\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
endingScreen
^^^^^^^^^^^^

.. java:method:: public abstract void endingScreen(String gameEndingMessage, List<ColorPegs> seqToGuess)
   :outertype: GameView

   Interazione con l'utente fisico per la terminazione di una partita

   :param gameEndingMessage: messaggio che comunica all'utente fisico l'esito
   :param seqToGuess: sequenza da indovinare dal gioco, da mostrare all'utente fisico

getIndexSequence
^^^^^^^^^^^^^^^^

.. java:method:: public abstract List<Integer> getIndexSequence(int seqLength, boolean toGuess)
   :outertype: GameView

   Interazione con l'utente fisico per poter ottenere gli indici associati ai diversi valori di \ ``ColorPegs``\ . Se il valore restituito contiene l'\ ``Integer``\  0 è stata rappresentata la volontà di un giocatore \ ``CodeBreaker``\  di arrendersi.

   :param seqLength: la lunghezza della sequenza di cui si vogliono ottenere indici
   :param toGuess: flag che indica se la sequenza di indici interi da ottenere si riferisce alla sequenza da indovinare o meno
   :return: List contenente gli indici interi associati all'enum ColorPegs

showGame
^^^^^^^^

.. java:method:: public abstract void showGame(BoardModel o)
   :outertype: GameView

   Interazione con l'utente fisico per mostrare la situazione di gioco.

   :param o: plancia di gioco da mostrare

