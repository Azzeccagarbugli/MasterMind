.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

CodeMaker
=========

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public abstract class CodeMaker

   Classe astratta relativa ai giocatori che forniscono la sequenza da codificare

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getCodeToGuess
^^^^^^^^^^^^^^

.. java:method:: public abstract List<ColorPegs> getCodeToGuess(int sequenceLength)
   :outertype: CodeMaker

   Restituisce la sequenza di pioli da indovinare.

   :param sequenceLength: la lunghezza della sequenza da indovinare
   :return: la lista contenente la sequenza corretta di colori da indovinare

