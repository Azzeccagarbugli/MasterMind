.. java:import:: java.util List

BoardController
===============

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class BoardController

   \ **Responsabilità**\ : gestire le interazioni dall'esterno e dirette alla modifica di un'istanza \ ``BoardModel``\ . Rientra nel pattern \ **MVC**\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
BoardController
^^^^^^^^^^^^^^^

.. java:constructor:: public BoardController(BoardModel newBoard)
   :outertype: BoardController

   Costruttore

   :param newBoard: la \ ``BoardModel``\  che si desidera gestire

Methods
-------
insertCodeToGuess
^^^^^^^^^^^^^^^^^

.. java:method:: public boolean insertCodeToGuess(List<ColorPegs> toGuess)
   :outertype: BoardController

   Metodo che consente l'inserimento di una sequenza da indovinare all'interno della \ ``BoardModel``\ .

   :param toGuess: la \ ``List``\  di \ ``ColorPegs``\  contenente i valori che si vogliono inserire come sequenza da indovinare.
   :return: boolean a rappresentazione dell'esito dell'inserimento

insertNewAttempt
^^^^^^^^^^^^^^^^

.. java:method:: public List<ColorPegs> insertNewAttempt(List<ColorPegs> attempt)
   :outertype: BoardController

   Metodo che consente l'inserimento di un nuovo tentativo all'interno della \ ``BoardModel``\ .

   :param attempt: la \ ``List``\  di \ ``ColorPegs``\  contenente i valori che si vogliono inserire all'interno della \ ``BoardModel``\
   :return: List contenente la sequenza di \ ``ColorPegs``\  indizio generata dalla plancia

