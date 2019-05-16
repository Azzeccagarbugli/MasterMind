.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionManager

InteractiveMaker
================

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class InteractiveMaker extends CodeMaker

   La classe definita di seguito consente al giocatore umano, di andare a creare una sequenza che poi un altro player all'interno della piattaforma doverà decodificare per ottenere la vittoria.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
InteractiveMaker
^^^^^^^^^^^^^^^^

.. java:constructor:: public InteractiveMaker(InteractionManager intManager)
   :outertype: InteractiveMaker

   Costruisco il seguente oggetto HumanMaker utilizzando un'\ ``InteractionManager``\  per eseguire delle operazioni con quest'ultimo.

   :param intManager: il mangager con la quale effetuerò le interazioni

Methods
-------
getCodeToGuess
^^^^^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getCodeToGuess(int sequenceLength)
   :outertype: InteractiveMaker

