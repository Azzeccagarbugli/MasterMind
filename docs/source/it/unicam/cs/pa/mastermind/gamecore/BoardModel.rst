.. java:import:: java.util ArrayList

.. java:import:: java.util Collections

.. java:import:: java.util Iterator

.. java:import:: java.util LinkedHashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util.stream IntStream

.. java:import:: it.unicam.cs.pa.mastermind.ui BoardObserver

BoardModel
==========

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class BoardModel

   \ **Responsabilità**\ : gestire le informazioni relative ad una plancia di gioco.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
BoardModel
^^^^^^^^^^

.. java:constructor:: public BoardModel(int sequenceLength, int maxAttempts)
   :outertype: BoardModel

   Costruttore di una plancia

   :param sequenceLength: massima delle sequenze presenti in questa plancia
   :param maxAttempts: numero massimo di tentativi possibili per indovinare la \ ``sequenceToGuess``\

Methods
-------
addAttempt
^^^^^^^^^^

.. java:method:: public boolean addAttempt(List<ColorPegs> attempt) throws IllegalArgumentException
   :outertype: BoardModel

   Aggiunge alla plancia una nuova sequenza di pioli tentativo e la relativa sequenza di pioli indizio, calcolata all'interno del metodo

   :param attempt: la sequenza da inserire
   :throws IllegalArgumentException: in caso di inserimento illegale
   :return: boolean relativo alla riuscita dell'inserimento

addObserver
^^^^^^^^^^^

.. java:method:: public void addObserver(BoardObserver observer)
   :outertype: BoardModel

   Metodo il quale registra un nuovo \ ``BoardObserver``\  e notifica tutti i \ ``BoardObserver``\  attualmente associati all'istanza di \ ``BoardModel``\ .

   :param observer: nuova istanza di \ ``BoardObserver``\  da aggiungere

attemptsInserted
^^^^^^^^^^^^^^^^

.. java:method:: public int attemptsInserted()
   :outertype: BoardModel

   :return: int numero di tentativi inseriti fino ad ora

getAttemptAndClueList
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> getAttemptAndClueList()
   :outertype: BoardModel

   :return: List contenenti Map.Entry con le sequenze di \ ``ColorPegs``\  inserite come tentativo e le relative sequenze indizio

getClueFromAttempt
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ColorPegs> getClueFromAttempt(List<ColorPegs> attempt)
   :outertype: BoardModel

   Calcolo della sequenza di \ ``ColorPegs``\  indizio a fronte di una sequenza di \ ``ColorPegs``\  assicurata valida come tentativo.

   :param attempt: la lista che si inserisce come tentativo di risoluzione.
   :param toGuess: la lista che contiene la sequenza da indovinare.
   :return: List di indizi generata a partire dalla lista di tentativi.

getSequenceLength
^^^^^^^^^^^^^^^^^

.. java:method:: public int getSequenceLength()
   :outertype: BoardModel

   :return: int lunghezza massima delle sequenze presenti in questa plancia

getSequenceToGuess
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ColorPegs> getSequenceToGuess()
   :outertype: BoardModel

   :return: List di \ ``ColorPegs``\  da indovinare.

hasBreakerGuessed
^^^^^^^^^^^^^^^^^

.. java:method:: public boolean hasBreakerGuessed()
   :outertype: BoardModel

   :return: boolean che indica se il giocatore Breaker ha indovinato o meno la sequenza del Maker in base alle informazioni contenute nella plancia

isBoardEmpty
^^^^^^^^^^^^

.. java:method:: public boolean isBoardEmpty()
   :outertype: BoardModel

   :return: boolean che indica se sono stati inseriti o meno tentativi nella plancia

lastAttemptAndClue
^^^^^^^^^^^^^^^^^^

.. java:method:: public Map.Entry<List<ColorPegs>, List<ColorPegs>> lastAttemptAndClue()
   :outertype: BoardModel

   :return: Map.Entry contenente l'ultima sequenza di \ ``ColorPegs``\  inserita come tentativo e la relativa sequenza indizio.

leftAttempts
^^^^^^^^^^^^

.. java:method:: public int leftAttempts()
   :outertype: BoardModel

   :return: int numero di tentativi rimasti

setSequenceToGuess
^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean setSequenceToGuess(List<ColorPegs> toGuess) throws IllegalArgumentException
   :outertype: BoardModel

   Imposta la sequenza di pioli da indovinare.

   :param toGuess: lista di \ ``ColorPegs``\  della sequenza da indovinare
   :throws IllegalArgumentException: se la lunghezza della sequenza inserita non è valida
   :return: un booleano a seconda della riuscita o meno dell'inserimento nella plancia di gioco

