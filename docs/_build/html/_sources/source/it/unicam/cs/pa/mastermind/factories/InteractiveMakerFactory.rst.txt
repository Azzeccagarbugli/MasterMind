.. java:import:: it.unicam.cs.pa.mastermind.players CodeMaker

.. java:import:: it.unicam.cs.pa.mastermind.players InteractiveMaker

.. java:import:: it.unicam.cs.pa.mastermind.ui GameView

InteractiveMakerFactory
=======================

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public class InteractiveMakerFactory implements MakerFactory

   Classe factory implementazione di \ ``MakerFactory``\  impiegata per ottenere istanze di \ ``InteractiveMaker``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getDescription
^^^^^^^^^^^^^^

.. java:method:: @Override public String getDescription()
   :outertype: InteractiveMakerFactory

getMaker
^^^^^^^^

.. java:method:: @Override public CodeMaker getMaker(GameView view, int seqLength, int attempts)
   :outertype: InteractiveMakerFactory

getName
^^^^^^^

.. java:method:: @Override public String getName()
   :outertype: InteractiveMakerFactory

