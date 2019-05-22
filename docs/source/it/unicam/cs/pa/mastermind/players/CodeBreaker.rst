.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionManager

CodeBreaker
===========

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public abstract class CodeBreaker

   Classe astratta relativa ai giocatori che cercano di indovinare la sequenza.

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getAttempt
^^^^^^^^^^

.. java:method:: public abstract List<ColorPegs> getAttempt(int sequenceLength, InteractionManager intManager)
   :outertype: CodeBreaker

   Restituisce la sequenza di pioli valida come singolo tentativo.

   :param sequenceLength: la lunghezza della sequenza
   :throws BreakerGiveUpException: eccezione lanciata quando il player decide di effettuare la resa
   :return: la lista dei valori ottenuta

hasGivenUp
^^^^^^^^^^

.. java:method:: public boolean hasGivenUp()
   :outertype: CodeBreaker

   Metodo che restituisce la volont� del giocatore di arrendersi o meno

toggleGiveUp
^^^^^^^^^^^^

.. java:method:: public void toggleGiveUp()
   :outertype: CodeBreaker

   Metodo invocabile dal giocatore per segnalare la volont� di arrendersi

