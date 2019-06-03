.. java:import:: it.unicam.cs.pa.mastermind.players CodeBreaker

.. java:import:: it.unicam.cs.pa.mastermind.players CodeMaker

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionView

SingleGame
==========

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class SingleGame

   Rappresentazione concreta di una singola partita a due giocatori.

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
winStats
^^^^^^^^

.. java:field::  CurrentGameStats winStats
   :outertype: SingleGame

   Oggetto contenente informazioni relative al vincitore della partita in corso.

Constructors
------------
SingleGame
^^^^^^^^^^

.. java:constructor:: public SingleGame(int sequenceLength, int attempts, InteractionView view, CodeBreaker currentBreaker, CodeMaker currentMaker)
   :outertype: SingleGame

   Inizializza un nuovo gioco con un player che codifica e un player che decodifica.

   :param currentMaker: player addetto alla creazione della sequenza da indovinare
   :param currentBreaker: player addetto alla risoluzione della sequenza da indovinare
   :param sequenceLength: la lunghezza di tale sequenza
   :param attempts: il numero di tentativi concessi
   :param view: entità relativa alla gestione delle interazioni con gli utenti fisici

Methods
-------
start
^^^^^

.. java:method:: public void start()
   :outertype: SingleGame

   Avvio effettivo di una singola partita. Il metodo di natura void esegue il setup della partita e inizializza il tutto per permettere di eseguire la partita.

