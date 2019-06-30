.. java:import:: it.unicam.cs.pa.mastermind.players CodeBreaker

.. java:import:: it.unicam.cs.pa.mastermind.players InteractiveBreaker

.. java:import:: it.unicam.cs.pa.mastermind.ui GameView

InteractiveBreakerFactory
=========================

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public class InteractiveBreakerFactory implements BreakerFactory

   Classe factory implementazione di \ ``BreakerFactory``\  impiegata per ottenere istanze di \ ``InteractiveBreaker``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getBreaker
^^^^^^^^^^

.. java:method:: @Override public CodeBreaker getBreaker(GameView view, int seqLength, int attempts)
   :outertype: InteractiveBreakerFactory

getDescription
^^^^^^^^^^^^^^

.. java:method:: @Override public String getDescription()
   :outertype: InteractiveBreakerFactory

getName
^^^^^^^

.. java:method:: @Override public String getName()
   :outertype: InteractiveBreakerFactory

