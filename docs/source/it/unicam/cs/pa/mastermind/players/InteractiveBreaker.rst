.. java:import:: java.util ArrayList

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.ui GameView

InteractiveBreaker
==================

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class InteractiveBreaker extends CodeBreaker

   Particolare estensione di \ ``CodeBreaker``\ , rappresentante un utente fisico. Nello specifico l'utente umano può effettuare decisioni ed impartire comandi passando da un'istanza di \ ``GameView``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
InteractiveBreaker
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public InteractiveBreaker(GameView newView)
   :outertype: InteractiveBreaker

Methods
-------
getAttempt
^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getAttempt()
   :outertype: InteractiveBreaker

   L'utente fisico può decidere di voler reinserire una sequenza di \ ``ColorPegs``\  già inserita precedentemente. In tal caso ripeterà l'azione di definizione di una nuova sequenza. \ **Contratto**\ : se dalla vista \ ``GameView``\  viene restuito il valore 0 allora tale valore viene interpretato come la volontà dell'utente fisico di arrendersi.

