NewGameStats
============

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class NewGameStats

   Classe relativa alle impostazioni legate alla fine di una partita e all'inizio di quella successiva.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
NewGameStats
^^^^^^^^^^^^

.. java:constructor:: public NewGameStats(boolean toContinue, boolean keepSettings)
   :outertype: NewGameStats

   Costruttore che instazia la seguente classe.

   :param toContinue: booleano che determina se continuare a giocare o meno
   :param keepSettings: booleano che determina se continuare a giocare o meno con le stesse impostazioni

Methods
-------
getContinue
^^^^^^^^^^^

.. java:method:: public boolean getContinue()
   :outertype: NewGameStats

   Getter della variabile \ ``toContinue``\ .

   :return: la variabile \ ``toContinue``\

getKeepSettings
^^^^^^^^^^^^^^^

.. java:method:: public boolean getKeepSettings()
   :outertype: NewGameStats

   Getter della variabile \ ``keepSettings``\ .

   :return: la variabile \ ``keepSettings``\

