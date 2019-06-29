.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

CodeMaker
=========

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public abstract class CodeMaker

   \ **Responsabilità**\ : rappresentazione di un giocatore \ ``CodeMaker``\ , il cui compito è quello di decretare una sequenza di \ ``ColorPegs``\  che il giocatore \ ``CodeBreaker``\  deve indovinare.

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getCodeToGuess
^^^^^^^^^^^^^^

.. java:method:: public abstract List<ColorPegs> getCodeToGuess()
   :outertype: CodeMaker

   :return: List contenente i \ ``ColorPegs``\  validi come sequenza da indovinare

