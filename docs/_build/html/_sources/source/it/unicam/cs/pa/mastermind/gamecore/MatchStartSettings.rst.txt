.. java:import:: it.unicam.cs.pa.mastermind.factories BreakerFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories GameViewFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories MakerFactory

MatchStartSettings
==================

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class MatchStartSettings

   \ **Responsabilità**\ : tenere traccia delle informazioni necessarie per poter iniziare una nuova partita e da impiegare all'interno di essa. \ **Contratto**\ : le istanze vengono gestite all'interno di \ ``MainManager``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
highTresholdLength
^^^^^^^^^^^^^^^^^^

.. java:field::  int highTresholdLength
   :outertype: MatchStartSettings

lowTresholdAttempts
^^^^^^^^^^^^^^^^^^^

.. java:field::  int lowTresholdAttempts
   :outertype: MatchStartSettings

lowTresholdLength
^^^^^^^^^^^^^^^^^

.. java:field::  int lowTresholdLength
   :outertype: MatchStartSettings

Constructors
------------
MatchStartSettings
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MatchStartSettings(GameViewFactory gameViewFactory)
   :outertype: MatchStartSettings

Methods
-------
getAttempts
^^^^^^^^^^^

.. java:method:: public int getAttempts()
   :outertype: MatchStartSettings

getBreakerFactory
^^^^^^^^^^^^^^^^^

.. java:method:: public BreakerFactory getBreakerFactory()
   :outertype: MatchStartSettings

getGameViewFactory
^^^^^^^^^^^^^^^^^^

.. java:method:: public GameViewFactory getGameViewFactory()
   :outertype: MatchStartSettings

getHighTresholdLength
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getHighTresholdLength()
   :outertype: MatchStartSettings

getLowTresholdAttempts
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getLowTresholdAttempts()
   :outertype: MatchStartSettings

getLowTresholdLength
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getLowTresholdLength()
   :outertype: MatchStartSettings

getMakerFactory
^^^^^^^^^^^^^^^

.. java:method:: public MakerFactory getMakerFactory()
   :outertype: MatchStartSettings

getSequenceLength
^^^^^^^^^^^^^^^^^

.. java:method:: public int getSequenceLength()
   :outertype: MatchStartSettings

resetLengthAttempts
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void resetLengthAttempts()
   :outertype: MatchStartSettings

setAttempts
^^^^^^^^^^^

.. java:method:: public void setAttempts(int attempts)
   :outertype: MatchStartSettings

setBreakerFactory
^^^^^^^^^^^^^^^^^

.. java:method:: public void setBreakerFactory(BreakerFactory breakerFactory)
   :outertype: MatchStartSettings

setHighTresholdLength
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHighTresholdLength(int highTresholdLength)
   :outertype: MatchStartSettings

setLowTresholdAttempts
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setLowTresholdAttempts(int lowTresholdAttempts)
   :outertype: MatchStartSettings

setLowTresholdLength
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setLowTresholdLength(int lowTresholdLength)
   :outertype: MatchStartSettings

setMakerFactory
^^^^^^^^^^^^^^^

.. java:method:: public void setMakerFactory(MakerFactory makerFactory)
   :outertype: MatchStartSettings

setSequenceLength
^^^^^^^^^^^^^^^^^

.. java:method:: public void setSequenceLength(int sequenceLength)
   :outertype: MatchStartSettings

