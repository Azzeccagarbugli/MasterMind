.. java:import:: it.unicam.cs.pa.mastermind.factories ConsoleGameViewFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories ConsoleStartViewFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories GameViewFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories StartViewFactory

ConsoleMainManager
==================

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class ConsoleMainManager extends MainManager

   Implementazione di \ ``MainManager``\  correlata ad implementazioni di \ ``GameView``\  e \ ``StartView``\  basate su interazione via console.

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getGameViewFactory
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected GameViewFactory getGameViewFactory()
   :outertype: ConsoleMainManager

getStartViewFactory
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected StartViewFactory getStartViewFactory()
   :outertype: ConsoleMainManager

main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: ConsoleMainManager

   Metodo main fondamentale per l'avvio, richiesto dal contratto di \ ``MainManager``\ .

   :param args:

