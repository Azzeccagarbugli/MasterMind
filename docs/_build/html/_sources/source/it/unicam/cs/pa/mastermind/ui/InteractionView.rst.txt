.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

InteractionView
===============

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public abstract class InteractionView extends BoardObserver

   Interfaccia relativa alla gestione dell'interazione con l'utente.

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

   La mappa composta da due liste di ColorPegs la quale contiene l'utlimo tentativo inserito dall'utente e la relativa sequenza indizio che è stata generata basandosi du quest'ultima.

Methods
-------
endingScreen
^^^^^^^^^^^^

.. java:method:: public abstract void endingScreen(String gameEndingMessage, List<ColorPegs> toGuess)
   :outertype: InteractionView

   Gestisce la fine di una singola partita. Metodo da richiamare dopo che è stato garantinto che la partita in atto è da definirsi conclusa.

   :param exe: eccezione personalizzata
   :param toGuess: i valori della sequenza da indovinare
   :return: un array di boolean contenente i settaggi di ending della partita

getCurrentSequenceLength
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getCurrentSequenceLength()
   :outertype: InteractionView

   Metodo getter che restituisce la lunghezza della sequenza da indovinare.

   :return: il valore intero di tale lunghezza

getCurrentSequenceToGuess
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ColorPegs> getCurrentSequenceToGuess()
   :outertype: InteractionView

   Metodo getter che restituisce la sequenza da indovinare.

   :return: la lista di ColorPegs da indovinare

getIndexSequence
^^^^^^^^^^^^^^^^

.. java:method:: public abstract List<Integer> getIndexSequence(boolean toGuess)
   :outertype: InteractionView

   Richiede all'utente umano la sequenza tentativo.

   :param sequenceLength: la lunghezza della sequenza inserita
   :param toGuess: se la sequenza da inserire è la sequenza da indovinare o meno
   :throws BreakerGiveUpException: la resa condizionata del player
   :return: la lista di interi che andranno a definire la sequenza. Posti n colori, gli elementi all'interno della lista avranno valore compreso tra 1 e n

getLastAttemptAndClue
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map.Entry<List<ColorPegs>, List<ColorPegs>> getLastAttemptAndClue()
   :outertype: InteractionView

   Metodo getter che restituisce la mappa composta da due liste di ColorPegs la quale contiene l'utlimo tentativo inserito dall'utente e la relativa sequenza indizio che è stata generata basandosi du quest'ultima.

   :return: la mappa con l'ultima sequenza inserita dall'utente e l'ultima sequenza di indizi generata automaticamente

