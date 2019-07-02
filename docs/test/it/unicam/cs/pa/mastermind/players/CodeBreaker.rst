.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

CodeBreaker
===========

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public abstract class CodeBreaker

   \ **Responsabilità**\ : rappresentazione di un giocatore \ ``CodeBreaker``\ , il cui compito è quello di indovinare la sequenza di \ ``ColorPegs``\  decisa dal giocatore \ ``CodeMaker``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getAttempt
^^^^^^^^^^

.. java:method:: public abstract List<ColorPegs> getAttempt()
   :outertype: CodeBreaker

   :return: List contenente i \ ``ColorPegs``\  validi come sequenza tentativo.

getLastClue
^^^^^^^^^^^

.. java:method:: public List<ColorPegs> getLastClue()
   :outertype: CodeBreaker

   Ritorna il valore memorizzato dell'ultima sequenza indizio relativa all'ultimo tentativo generato.

hasGivenUp
^^^^^^^^^^

.. java:method:: public boolean hasGivenUp()
   :outertype: CodeBreaker

   :return: la volontà del giocatore \ ``CodeBreaker``\  di arrendersi o meno

setGiveUp
^^^^^^^^^

.. java:method:: public void setGiveUp(boolean giveUp)
   :outertype: CodeBreaker

   Imposta una volontà del giocatore di arrendersi o meno.

   :param giveUp:

setLastClue
^^^^^^^^^^^

.. java:method:: public void setLastClue(List<ColorPegs> lastClue)
   :outertype: CodeBreaker

   Imposta il valore memorizzato dell'ultima sequenza indizio relativa all'ultimo tentativo generato.

   :param lastClue:

toggleGiveUp
^^^^^^^^^^^^

.. java:method:: public void toggleGiveUp()
   :outertype: CodeBreaker

   Imposta la volontà del giocatore \ ``CodeBreaker``\  di arrendersi.

