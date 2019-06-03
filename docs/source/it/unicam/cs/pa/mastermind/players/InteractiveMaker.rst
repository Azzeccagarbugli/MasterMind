.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionView

InteractiveMaker
================

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class InteractiveMaker extends CodeMaker

   La classe definita di seguito consente al giocatore umano, di andare a creare una sequenza che poi un altro player all'interno della piattaforma doverà decodificare per ottenere la vittoria.

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getCodeToGuess
^^^^^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getCodeToGuess(InteractionView intView)
   :outertype: InteractiveMaker

