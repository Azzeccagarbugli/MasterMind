.. java:import:: it.unicam.cs.pa.mastermind.gamecore BoardModel

BoardObserver
=============

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public abstract class BoardObserver

   Classe astratta estendibile da tutte quelle classi coinvolte nel design pattern \ **Observer**\ , aventi quindi necessità di osservare e adattarsi in tempo reale ai cambiamenti di stato di oggetti di tipo BoardModel.

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
subject
^^^^^^^

.. java:field:: protected BoardModel subject
   :outertype: BoardObserver

   L'oggetto che viene osservato.

Methods
-------
addSubject
^^^^^^^^^^

.. java:method:: public void addSubject(BoardModel subject)
   :outertype: BoardObserver

   Metodo per il quale viene aggiunto un altro elemento da osservare alla lista interna.

   :param subject: il soggetto che si vuole osservare

update
^^^^^^

.. java:method:: public abstract void update()
   :outertype: BoardObserver

   Aggiornamento dello stato interno dell'oggetto.

