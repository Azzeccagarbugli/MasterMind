.. java:import:: it.unicam.cs.pa.mastermind.ui GameMode

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionManager

BreakerFactory
==============

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class BreakerFactory

   La classe BreakerFactory genera dei player decodificatori all'interno della piattaforma di gioco.

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getBreaker
^^^^^^^^^^

.. java:method:: public CodeBreaker getBreaker(GameMode mode, InteractionManager intManager)
   :outertype: BreakerFactory

   Il seguente metodo consente di effettuare il get di un player breaker.

   :param mode: la gamemode con la quale si vuole effettuare la partita
   :param intManager: l'InteractionManager con il quale effettuare le interazioni di gioco
   :return: il tipo di player corrente

