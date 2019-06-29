BoardObserver
=============

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public abstract class BoardObserver

   Classe astratta estendibile da tutte quelle classi coinvolte nel design pattern \ **Observer**\ , aventi quindi necessità di osservare e adattarsi in tempo reale ai cambiamenti di stato di oggetti di tipo BoardModel.

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
addSubject
^^^^^^^^^^

.. java:method:: public void addSubject(BoardModel subject)
   :outertype: BoardObserver

   Metodo per il quale viene aggiunto un altro elemento da osservare alla lista interna.

   :param subject: il soggetto che si vuole osservare

getSubject
^^^^^^^^^^

.. java:method:: protected BoardModel getSubject()
   :outertype: BoardObserver

   Restituito il riferimento alla \ ``BoardModel``\  osservata

   :return: BoardModel il riferimento richiesto

update
^^^^^^

.. java:method:: public abstract void update()
   :outertype: BoardObserver

   Aggiornamento dello stato interno dell'oggetto.

