.. java:import:: it.unicam.cs.pa.mastermind.ui GameMode

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionManager

MakerFactory
============

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class MakerFactory

   La classe MakerFactory genera dei player codificatori all'interno della piattaforma di gioco.

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getMaker
^^^^^^^^

.. java:method:: public CodeMaker getMaker(GameMode mode, InteractionManager intManager)
   :outertype: MakerFactory

   Il seguente metodo consente di effettuare il get di un player maker.

   :param mode: la gamemode con la quale si vuole effettuare la partita
   :param intManager: l'InteractionManager con il quale effettuare le interazioni di gioco
   :return: il tipo di player corrente

