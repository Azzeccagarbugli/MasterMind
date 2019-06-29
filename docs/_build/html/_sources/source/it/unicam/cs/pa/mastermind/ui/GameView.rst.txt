.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.gamecore BoardObserver

GameView
========

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public abstract class GameView extends BoardObserver

   \ **Responsabilità**\ : fornire agli utenti fisici coinvolti in una singola partita operazioni di Input/Output. Rientra nel pattern \ **Observer**\  per poter fornire in output all'utente fisico una rappresentazione di quelle che sono le azioni effettuate dai giocatori nel gioco. Rientra nel pattern \ **MVC**\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
endingScreen
^^^^^^^^^^^^

.. java:method:: public abstract void endingScreen(String gameEndingMessage)
   :outertype: GameView

   Interazione finale con l'utente fisico relativa al termine di una partita

   :param gameEndingMessage: stringa con il messaggio finale da mostrare all'utente

getIndexSequence
^^^^^^^^^^^^^^^^

.. java:method:: public abstract List<Integer> getIndexSequence(boolean toGuess)
   :outertype: GameView

   Interazione con l'utente fisico per poter ottenere gli indici associati ai diversi valori di \ ``ColorPegs``\ . Se il valore restituito contiene l'\ ``Integer``\  0 è stata rappresentata la volontà di un giocatore \ ``CodeBreaker``\  di arrendersi.

   :param toGuess: flag che indica se la sequenza di indici interi da ottenere si riferisce alla sequenza da indovinare o meno
   :return: List contenente gli indici interi associati all'enum ColorPegs

showGame
^^^^^^^^

.. java:method:: public abstract void showGame()
   :outertype: GameView

   Interazione con l'utente fisico per mostrare la situazione di gioco.

