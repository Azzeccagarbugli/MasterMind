.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionView

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

.. java:method:: public abstract List<ColorPegs> getAttempt(InteractionView intManager)
   :outertype: CodeBreaker

   Restituisce la sequenza di pioli valida come singolo tentativo.

   :param intManager: l'InteractionView che si occupa della gestione delle scelte del player
   :return: la lista dei valori ottenuta

hasGivenUp
^^^^^^^^^^

.. java:method:: public boolean hasGivenUp()
   :outertype: CodeBreaker

   Metodo che restituisce la volontà del giocatore di arrendersi o meno

toggleGiveUp
^^^^^^^^^^^^

.. java:method:: public void toggleGiveUp()
   :outertype: CodeBreaker

   Metodo invocabile dal giocatore per segnalare la volontà di arrendersi

