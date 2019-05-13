.. java:import:: java.util ArrayList

.. java:import:: java.util Collections

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util.stream IntStream

.. java:import:: it.unicam.cs.pa.mastermind.exceptions BreakerWinException

.. java:import:: it.unicam.cs.pa.mastermind.exceptions NoAttemptsLeftException

BoardCoordinator
================

.. java:package:: it.unicam.cs.pa.mastermind.core
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
checkEnd
^^^^^^^^

.. java:method:: public void checkEnd() throws BreakerWinException, NoAttemptsLeftException
   :outertype: BoardCoordinator

   Verifica se il giocatore che decodifica ha indovinato la sequenza inserita dal giocatore che codifica o se non ci sono tentativi rimanenti per indovinare per poter sollevare le relative eccezioni.

   :throws BreakerWinException:
   :throws NoAttemptsLeftException:

getAttemptAndClueList
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> getAttemptAndClueList()
   :outertype: BoardCoordinator

   Metodo che restituisce le entry di tentativi e relativi indizi all'interno di un'unica lista.

   :return: la lista contenente le sequenze relative a tentativi e indizi

getSequenceLength
^^^^^^^^^^^^^^^^^

.. java:method:: public int getSequenceLength()
   :outertype: BoardCoordinator

   Metodo pubblico che restituisce il valore della lunghezza della sequenza inserita.

   :return: un intero che stabilisce la lunghezza della sequenza inserita

getSequenceToGuess
^^^^^^^^^^^^^^^^^^

.. java:method:: public List<ColorPegs> getSequenceToGuess()
   :outertype: BoardCoordinator

   Metodo getter il quale restituisce una lista contenente la sequenza da indovinare.

   :return: l'ArrayList contenente la sequenza da indovinare

insertCodeToGuess
^^^^^^^^^^^^^^^^^

.. java:method:: public boolean insertCodeToGuess(List<ColorPegs> toGuess)
   :outertype: BoardCoordinator

   Riceve come argomento la sequenza da inserire nella plancia come sequenza da indovinare ed effettua la relativa operazione.

   :param toGuess: la lista da indovinare
   :return: un booleano che afferma il corretto inserimento della sequenza

insertNewAttempt
^^^^^^^^^^^^^^^^

.. java:method:: public boolean insertNewAttempt(List<ColorPegs> attempt)
   :outertype: BoardCoordinator

   Riceve come argomento una nuova sequenza da inserire nella plancia come nuovo tentativo. Inserisce nella plancia anche la sequenza di pioli indizio relativa.

   :param attempt: la lista di pioli tentativo che si vuole inserire
   :return: un booleano che controlla lo stato della operazione, \ **true**\  se l'operazione è stata effettuata con successo o \ **false**\  se l'operazione è fallita

