.. java:import:: java.util ArrayList

.. java:import:: java.util Collections

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util.stream IntStream

BoardCoordinator
================

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class BoardCoordinator

   Interagisce continuamente con i giocatori aggiornando la plancia di gioco di conseguenza.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
BoardCoordinator
^^^^^^^^^^^^^^^^

.. java:constructor:: public BoardCoordinator(Board newBoard)
   :outertype: BoardCoordinator

   Costruttore che va ad inizializzare la nuova plancia di gioco in cui verranno effettuate le operazioni descritte dai metodi presenti nella medesima classe.

   :param newBoard: la board su cui si vogliono effettuare le operazioni di coordinazione

Methods
-------
getAttemptAndClueList
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> getAttemptAndClueList()
   :outertype: BoardCoordinator

   Metodo che restituisce le entry di tentativi e relativi indizi all'interno di un'unica lista.

   :return: la lista contenente le sequenze relative a tentativi e indizi.

getSequenceLength
^^^^^^^^^^^^^^^^^

.. java:method:: public int getSequenceLength()
   :outertype: BoardCoordinator

   Metodo pubblico che restituisce il valore della lunghezza della sequenza inserita.

   :return: int che rappresenta la lunghezza delle sequenze da inserire.

getSequenceToGuess
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ColorPegs> getSequenceToGuess()
   :outertype: BoardCoordinator

   Metodo getter il quale restituisce una lista contenente la sequenza da indovinare.

   :return: l'ArrayList contenente la sequenza da indovinare.

hasBreakerGuessed
^^^^^^^^^^^^^^^^^

.. java:method:: public boolean hasBreakerGuessed()
   :outertype: BoardCoordinator

   :return: un booleano che indica se il giocatore Breaker ha indovinato o meno la sequenza del maker.

hasLeftAttempts
^^^^^^^^^^^^^^^

.. java:method:: public boolean hasLeftAttempts()
   :outertype: BoardCoordinator

   :return: un booleano rappresentante la possibilit� o meno di inserire nuovi tentativi.

insertCodeToGuess
^^^^^^^^^^^^^^^^^

.. java:method:: public boolean insertCodeToGuess(List<ColorPegs> toGuess)
   :outertype: BoardCoordinator

   Riceve come argomento la sequenza da inserire nella plancia come sequenza da indovinare ed effettua la relativa operazione.

   :param toGuess: la lista da indovinare.
   :return: boolean che afferma il corretto inserimento della sequenza.

insertNewAttempt
^^^^^^^^^^^^^^^^

.. java:method:: public boolean insertNewAttempt(List<ColorPegs> attempt)
   :outertype: BoardCoordinator

   Riceve come argomento una nuova sequenza da inserire nella plancia come nuovo tentativo. Inserisce nella plancia anche la sequenza di pioli indizio relativa.

   :param attempt: la lista di pioli tentativo che si vuole inserire
   :return: un booleano che controlla lo stato della operazione, \ **true**\  se l'operazione è stata effettuata con successo o \ **false**\  se l'operazione è fallita

numberOfAttemptsInserted
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int numberOfAttemptsInserted()
   :outertype: BoardCoordinator

   :return: il numero di sequenze tentativo inserite dal Breaker finora.

