.. java:import:: java.util List

BoardController
===============

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class BoardController

   La seguente classe \ ``BoardController``\  fa parte del modello MVC realizzato ed ha la responsabilità di gestire le interazioni che si svlippuano all'interno della plancia di gioco.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
BoardController
^^^^^^^^^^^^^^^

.. java:constructor:: public BoardController(BoardModel newBoard)
   :outertype: BoardController

   Il costruttore permette di instanziare un nuovo BoardController.

   :param newBoard: la BoardModel che si desidera gestire

Methods
-------
getBoardReference
^^^^^^^^^^^^^^^^^

.. java:method:: public BoardModel getBoardReference()
   :outertype: BoardController

   Metodo che restituisce la reference della board sulla quale è stato instaziato il coordinator.

   :return: la \ ``BoardModel``\  utilizzata

insertCodeToGuess
^^^^^^^^^^^^^^^^^

.. java:method:: public boolean insertCodeToGuess(List<ColorPegs> toGuess)
   :outertype: BoardController

   Metodo che consente l'inserimento di una sequenza da indovinare all'interno della plancia di gioco.

   :param toGuess: la \ ``List``\  di \ ``ColorPegs``\  contenente i valori che si vogliono inserire come sequenza da indovinare.
   :return: un booleano che determina l'esito dell'inserimento

insertNewAttempt
^^^^^^^^^^^^^^^^

.. java:method:: public boolean insertNewAttempt(List<ColorPegs> attempt)
   :outertype: BoardController

   Metodo che consente l'inserimento di un nuovo tentativo all'interno della plancia di gioco.

   :param attempt: la \ ``List``\  di \ ``ColorPegs``\  contenente i valori che si vogliono inserire all'interno della plancia
   :return: un booleano che determina l'esito dell'inserimento

