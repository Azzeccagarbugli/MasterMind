.. java:import:: it.unicam.cs.pa.mastermind.exceptions EndingException

.. java:import:: it.unicam.cs.pa.mastermind.gui InteractionManager

.. java:import:: it.unicam.cs.pa.mastermind.players CodeBreaker

.. java:import:: it.unicam.cs.pa.mastermind.players CodeMaker

SingleGame
==========

.. java:package:: it.unicam.cs.pa.mastermind.core
   :noindex:

.. java:type:: public class SingleGame

   Rappresentazione concreta di una singola partita a due giocatori

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
SingleGame
^^^^^^^^^^

.. java:constructor:: public SingleGame(CodeMaker maker, CodeBreaker breaker, int sequenceLength, int attempts, InteractionManager manager)
   :outertype: SingleGame

   Inizializza un nuovo gioco con un giocatore che codifica e un giocatore che decodifica.

   :param maker: player addetto alla creazione della sequenza da indovinare
   :param breaker: player addetto alla risoluzione della sequenza da indovinare
   :param sequenceLength: la lunghezza di tale sequenza
   :param attempts: il numero di tentativi concessi
   :param manager: entit� relativa alla gestione delle interazioni con gli utenti fisici

Methods
-------
start
^^^^^

.. java:method:: public boolean[] start()
   :outertype: SingleGame

   Avvio effettivo di una singola partita. Il metodo restituisce un array con due valori booleani, che indicano la volontà di iniziare o meno una nuova partita e la volontà di iniziarla con altre impostazioni.

   :return: un Array di booleani che stabiliranno le condizioni di ending del gioco, come ad esempio inziare una nuova partita o ricominciare il gioco con le precendenti impostazioni

