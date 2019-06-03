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

   Immagazzina i dati relativi alla plancia di gioco, quali posizione e natura dei pioli codice e dei pioli chiave. Fornisce informazioni sullo stato di gioco alle classi che lo gestiscono ed è l'elemento fondamentale sulla quale si base il nostro modello MVC. Questo determinato pattern di sviluppo infatti ci consente un intergrazione ottimale tra le classi del progetto stesso e un efficenza davvero molto elevata.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
BoardModel
^^^^^^^^^^

.. java:constructor:: public BoardModel(int sequenceLength, int maxAttempts)
   :outertype: BoardModel

   Costruttore che riceve come parametri la lunghezza delle sequenze di pioli e il numero massimo di tentativi disponibili.

   :param sequenceLength: lunghezza della sequenza inserita
   :param maxAttempts: numero di tentativi possibii per indovindare la sequenza

Methods
-------
addAttempt
^^^^^^^^^^

.. java:method:: public boolean addAttempt(List<ColorPegs> attempt) throws IllegalArgumentException
   :outertype: BoardModel

   Aggiunge alla plancia una nuova sequenza di pioli tentativo e la relativa sequenza di pioli indizio, calcolata all'interno del metodo

   :param attempt: la sequenza da inserire
   :throws IllegalArgumentException: in caso di inserimento illegale
   :return: booleano relativo alla riuscita dell'inserimento

addObserver
^^^^^^^^^^^

.. java:method:: public void addObserver(BoardObserver observer)
   :outertype: BoardModel

   Metodo il quale registra un nuovo observer. All’interno di tale metodo invochiamo il metodo update per far ricevere all'observer le informazioni a lui necessarie.

   :param observer: l'observer attuale

attemptsInserted
^^^^^^^^^^^^^^^^

.. java:method:: public int attemptsInserted()
   :outertype: BoardModel

   Restituisce il numero di tentativi inseriti fino ad ora.

   :return: il numero di tentativi inseriti fino ad ora

getAttemptAndClueList
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> getAttemptAndClueList()
   :outertype: BoardModel

   Metodo che restituisce le entry di tentativi e relativi indizi all'interno di un'unica lista.

   :return: la lista contenente le sequenze relative a tentativi e indizi.

getClueFromAttempt
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ColorPegs> getClueFromAttempt(List<ColorPegs> attempt, List<ColorPegs> toGuess)
   :outertype: BoardModel

   Metodo privato a cui passare una sequenza quale nuovo tentativo per ottenere la relativa sequenza indizio.

   :param attempt: la lista che si inserisce come tentativo di risoluzione.
   :param toGuess: la lista che contiene la sequenza da indovinare.
   :return: List di indizi generata automaticamente a partire dalla lista di tentativi.

getSequenceLength
^^^^^^^^^^^^^^^^^

.. java:method:: public int getSequenceLength()
   :outertype: BoardModel

   Restituisce la lunghezza della sequenza da inserire.

   :return: la lunghezza della sequenza

getSequenceToGuess
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ColorPegs> getSequenceToGuess()
   :outertype: BoardModel

   Restituisce la sequenza di pioli da indovinare.

   :return: la lista composta da ColorPegs contente la sequenza da indovinare

hasBreakerGuessed
^^^^^^^^^^^^^^^^^

.. java:method:: public boolean hasBreakerGuessed()
   :outertype: BoardModel

   Indica la vittoria o meno del breaker.

   :return: un booleano che indica se il giocatore Breaker ha indovinato o meno la sequenza del maker

isBoardEmpty
^^^^^^^^^^^^

.. java:method:: public boolean isBoardEmpty()
   :outertype: BoardModel

   Metodo che stabilisce se la plancia di gioco è completamente vuota o meno.

   :return: un booleano a seconda dello stato vuoto o meno della plancia

lastAttemptAndClue
^^^^^^^^^^^^^^^^^^

.. java:method:: public Map.Entry<List<ColorPegs>, List<ColorPegs>> lastAttemptAndClue()
   :outertype: BoardModel

   Restituisce l'ultima sequenza di pioli tentativo inseriti e la relativa sequenza di pioli indizio.

   :return: l'utlima sequenza di pioli tentativo inseriti e la lista di indizi relativi a quest'ultima

leftAttempts
^^^^^^^^^^^^

.. java:method:: public int leftAttempts()
   :outertype: BoardModel

   Restituisce il numero di tentativi rimanenti.

   :return: il numero di tentativi rimasti

setSequenceToGuess
^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean setSequenceToGuess(List<ColorPegs> toGuess) throws IllegalArgumentException
   :outertype: BoardModel

   Imposta la sequenza di pioli da indovinare.

   :param toGuess: lista di ColorPegs della sequenza da indovinare
   :throws IllegalArgumentException: se la lunghezza della sequenza inserita non è valida
   :return: un booleano a seconda della riuscita o meno dell'inserimento nella plancia di gioco

