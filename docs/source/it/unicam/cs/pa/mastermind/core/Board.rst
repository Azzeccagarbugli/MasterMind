.. java:import:: java.util Iterator

.. java:import:: java.util LinkedHashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: it.unicam.cs.pa.mastermind.pegs ColorPegs

Board
=====

.. java:package:: it.unicam.cs.pa.mastermind.core
   :noindex:

.. java:type:: public class Board

   Immagazzina i dati relativi alla plancia di gioco, quali posizione e natura dei pioli codice e dei pioli chiave. Fornisce informazioni sullo stato di gioco alle classi che lo gestiscono (Coordinator, Starter e InteractionManager).

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
Board
^^^^^

.. java:constructor:: public Board(int sequenceLength, int maxAttempts)
   :outertype: Board

   Costruttore che riceve come parametri la lunghezza delle sequenze di pioli e il numero massimo di tentativi disponibili.

   :param sequenceLength: lunghezza della sequenza inserita
   :param maxAttempts: numero di tentativi possibii per indovindare la sequenza

Methods
-------
addAttempt
^^^^^^^^^^

.. java:method:: public boolean addAttempt(List<ColorPegs> attempt, List<ColorPegs> clue) throws IllegalArgumentException
   :outertype: Board

   Aggiunge alla plancia una nuova sequenza di pioli tentativo e la relativa sequenza di pioli indizio.

   :param attempt: la lista della sequnza tentativo
   :param clue: la lista degli indizi forniti
   :throws IllegalArgumentException: se il tentativo di inserimento fallisce
   :return: un booleano che conferma la riuscita o meno dell'inserimento della sequenza nella plancia

getAttemptAndClueMap
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Map<List<ColorPegs>, List<ColorPegs>> getAttemptAndClueMap()
   :outertype: Board

   Restituisce la board contenente i tentativi inseriti e i corrispetivi indizi.

   :return: la board con i relativi attempt e clue

getSequenceLength
^^^^^^^^^^^^^^^^^

.. java:method:: public int getSequenceLength()
   :outertype: Board

   Restituisce la lunghezza della sequenza da inserire.

   :return: la lunghezza della sequenza

getSequenceToGuess
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ColorPegs> getSequenceToGuess()
   :outertype: Board

   Restituisce la sequenza di pioli da indovinare.

   :return: la lista composta da ColorPegs contente la sequenza da indovinare

isEmpty
^^^^^^^

.. java:method:: public boolean isEmpty()
   :outertype: Board

   Metodo che stabilisce se la plancia di gioco è completamente vuota o meno.

   :return: un booleano a seconda dello stato vuoto o meno della plancia

lastAttemptAndClue
^^^^^^^^^^^^^^^^^^

.. java:method:: public Map.Entry<List<ColorPegs>, List<ColorPegs>> lastAttemptAndClue()
   :outertype: Board

   Restituisce l'ultima sequenza di pioli tentativo inseriti e la relativa sequenza di pioli indizio.

   :return: l'utlima sequenza di pioli tentativo inseriti e la lista di indizi relativi a quest'ultima

leftAttempts
^^^^^^^^^^^^

.. java:method:: public int leftAttempts()
   :outertype: Board

   Restituisce il numero di tentativi rimanenti.

   :return: il numero di tentativi rimasti

setSequenceToGuess
^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean setSequenceToGuess(List<ColorPegs> toGuess) throws IllegalArgumentException
   :outertype: Board

   Imposta la sequenza di pioli da indovinare.

   :param toGuess: lista di ColorPegs della sequenza da indovinare
   :throws IllegalArgumentException: se la lunghezza della sequenza inserita non è valida
   :return: un booleano a seconda della riuscita o meno dell'inserimento nella plancia di gioco

