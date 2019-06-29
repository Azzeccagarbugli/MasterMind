.. java:import:: it.unicam.cs.pa.mastermind.players CodeBreaker

.. java:import:: it.unicam.cs.pa.mastermind.players DonaldKnuthBreaker

.. java:import:: it.unicam.cs.pa.mastermind.ui GameView

DonaldKnuthBreakerFactory
=========================

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public class DonaldKnuthBreakerFactory implements BreakerFactory

   Classe factory implementazione di \ ``BreakerFactory``\  impiegata per ottenere istanze di \ ``DonaldKnuthBreaker``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getBreaker
^^^^^^^^^^

.. java:method:: @Override public CodeBreaker getBreaker(GameView view, int seqLength, int attempts)
   :outertype: DonaldKnuthBreakerFactory

getDescription
^^^^^^^^^^^^^^

.. java:method:: @Override public String getDescription()
   :outertype: DonaldKnuthBreakerFactory

getName
^^^^^^^

.. java:method:: @Override public String getName()
   :outertype: DonaldKnuthBreakerFactory

