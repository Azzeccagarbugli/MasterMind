.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: it.unicam.cs.pa.mastermind.exceptions BreakerGiveUpException

.. java:import:: it.unicam.cs.pa.mastermind.exceptions EndingException

.. java:import:: it.unicam.cs.pa.mastermind.pegs ColorPegs

InteractionManager
==================

.. java:package:: it.unicam.cs.pa.mastermind.gui
   :noindex:

.. java:type:: public interface InteractionManager

   Interfaccia relativa alla gestione dell'interazione con l'utente.

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
ending
^^^^^^

.. java:method:: public boolean[] ending(EndingException exe, List<ColorPegs> toGuess)
   :outertype: InteractionManager

   Gestisce la fine di una singola partita. Metodo da richiamare dopo che è stato garantinto che la partita in atto è da definirsi conclusa.

   :param exe: eccezione personalizzata
   :param toGuess: i valori della sequenza da indovinare
   :return: un array di boolean contenente i settaggi di ending della partita

getIndexSequence
^^^^^^^^^^^^^^^^

.. java:method:: public List<Integer> getIndexSequence(int sequenceLength, boolean toGuess) throws BreakerGiveUpException
   :outertype: InteractionManager

   Richiede all'utente umano la sequenza tentativo.

   :param sequenceLength: la lunghezza della sequenza inserita
   :param toGuess: se la sequenza da inserire è la sequenza da indovinare o meno
   :throws BreakerGiveUpException: la resa condizionata del player
   :return: la lista di interi che andranno a definire la sequenza

showGame
^^^^^^^^

.. java:method:: public void showGame(List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues)
   :outertype: InteractionManager

   Mostra all'utente la situazione corrente del gioco.

   :param attemptsAndClues: la lista di indizi e tentativi da visualizzare

showGame
^^^^^^^^

.. java:method:: public void showGame(List<ColorPegs> toGuess, List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues)
   :outertype: InteractionManager

   Mostra all'utente la situazione corrente del gioco e inoltre visualizza la sequenza da indovinare. Fondamentalmente il seguente metodo può essere utilizzato durante la fase di debugging.

   :param toGuess: la lista da indovinare
   :param attemptsAndClues: la lista di indizi e tentativi da visualizzare

