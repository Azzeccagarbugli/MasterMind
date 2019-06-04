.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

InteractionView
===============

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public abstract class InteractionView extends BoardObserver

   \ **Responsabilità**\ : fornire ai giocatori coinvolti in una singola partita interazioni con quest'ultima.

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
currentSequenceLength
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected int currentSequenceLength
   :outertype: InteractionView

   La lunghezza della sequenza da indovinare.

currentSequenceToGuess
^^^^^^^^^^^^^^^^^^^^^^

.. java:field:: protected List<ColorPegs> currentSequenceToGuess
   :outertype: InteractionView

   La sequenza da indovinare.

lastAttemptAndClue
^^^^^^^^^^^^^^^^^^

.. java:field:: protected Map.Entry<List<ColorPegs>, List<ColorPegs>> lastAttemptAndClue
   :outertype: InteractionView

   Singola entry di una mappa, contenente l'ultima lista di ColorPegs inseriti e la relativa sequenza indizio.

Methods
-------
endingScreen
^^^^^^^^^^^^

.. java:method:: public abstract void endingScreen(String gameEndingMessage)
   :outertype: InteractionView

   Interazione finale con il giocatore relativa al termine di una partita

   :param gameEndingMessage: stringa con il messaggio finale da mostrare al giocatore

getCurrentSequenceLength
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getCurrentSequenceLength()
   :outertype: InteractionView

   Metodo getter che restituisce la lunghezza della sequenza da indovinare.

   :return: int il valore intero di tale lunghezza

getCurrentSequenceToGuess
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ColorPegs> getCurrentSequenceToGuess()
   :outertype: InteractionView

   Metodo getter che restituisce la sequenza da indovinare.

   :return: List la lista di ColorPegs da indovinare

getIndexSequence
^^^^^^^^^^^^^^^^

.. java:method:: public abstract List<Integer> getIndexSequence(boolean toGuess)
   :outertype: InteractionView

   Interazione con l'utente fisico o altra entità per poter ottenere gli indici associati ai diversi valori di \ ``ColorPegs``\ . Se il valore restituito contiene l'\ ``Integer``\  0 è stata rappresentata la volontà di un giocatore \ ``CodeBreaker``\  di arrendersi.

   :param toGuess: flag che indica se la sequenza di interi da ottenere si riferisce alla sequenza da indovinare o meno
   :return: List contenente gli indici da 1 a currentSequenceLength, associati all'enum ColorPegs

getLastAttemptAndClue
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map.Entry<List<ColorPegs>, List<ColorPegs>> getLastAttemptAndClue()
   :outertype: InteractionView

   Metodo getter che restituisce la entry di mappa contenente l'ultima lista di ColorPegs inseriti e la relativa sequenza indizio.

   :return: Map.Entry contenente l'ultima lista di ColorPegs inseriti e la relativa sequenza indizio.

