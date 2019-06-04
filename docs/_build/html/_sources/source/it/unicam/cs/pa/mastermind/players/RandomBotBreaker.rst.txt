.. java:import:: java.util ArrayList

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Random

.. java:import:: java.util Set

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionView

RandomBotBreaker
================

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class RandomBotBreaker extends CodeBreaker

   Estensione di \ ``CodeBreaker``\  mirata ad una gestione del comportamento del giocatore parzialmente random.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
RandomBotBreaker
^^^^^^^^^^^^^^^^

.. java:constructor:: public RandomBotBreaker()
   :outertype: RandomBotBreaker

Methods
-------
getAttempt
^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getAttempt(InteractionView intView)
   :outertype: RandomBotBreaker

