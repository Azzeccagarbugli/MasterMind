.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionView

CodeBreaker
===========

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public abstract class CodeBreaker

   \ **Responsabilità**\ : gestire le interazioni del giocatore Breaker

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getAttempt
^^^^^^^^^^

.. java:method:: public abstract List<ColorPegs> getAttempt(InteractionView intView)
   :outertype: CodeBreaker

   Restituisce la sequenza di \ ``ColorPegs``\  valida come singolo tentativo.

   :param intView: necessario per ottenere informazioni riguardo il gioco
   :return: List di \ ``ColorPegs``\  valida come singolo tentativo

hasGivenUp
^^^^^^^^^^

.. java:method:: public boolean hasGivenUp()
   :outertype: CodeBreaker

   :return: la volontà del giocatore \ ``CodeBreaker``\  di arrendersi

toggleGiveUp
^^^^^^^^^^^^

.. java:method:: public void toggleGiveUp()
   :outertype: CodeBreaker

   Imposta la volontà del giocatore \ ``CodeBreaker``\  di arrendersi.

