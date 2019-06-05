.. java:import:: it.unicam.cs.pa.mastermind.gamecore SingleMatch

.. java:import:: it.unicam.cs.pa.mastermind.players BadRegistryException

.. java:import:: it.unicam.cs.pa.mastermind.players BreakerFactoryRegistry

.. java:import:: it.unicam.cs.pa.mastermind.players CodeBreaker

.. java:import:: it.unicam.cs.pa.mastermind.players CodeMaker

.. java:import:: it.unicam.cs.pa.mastermind.players MakerFactoryRegistry

.. java:import:: it.unicam.cs.pa.mastermind.gamecore NewGameStats

StartStats
==========

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public class StartStats

   \ **Responsabilità**\ : tenere traccia delle informazioni necessarie per poter iniziare una nuova partita.

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
highTresholdLength
^^^^^^^^^^^^^^^^^^

.. java:field::  int highTresholdLength
   :outertype: StartStats

lowTresholdAttempts
^^^^^^^^^^^^^^^^^^^

.. java:field::  int lowTresholdAttempts
   :outertype: StartStats

lowTresholdLength
^^^^^^^^^^^^^^^^^

.. java:field::  int lowTresholdLength
   :outertype: StartStats

Constructors
------------
StartStats
^^^^^^^^^^

.. java:constructor:: public StartStats() throws BadRegistryException
   :outertype: StartStats

Methods
-------
getAttempts
^^^^^^^^^^^

.. java:method:: public int getAttempts()
   :outertype: StartStats

getBreakers
^^^^^^^^^^^

.. java:method:: public BreakerFactoryRegistry getBreakers()
   :outertype: StartStats

getCurrentBreaker
^^^^^^^^^^^^^^^^^

.. java:method:: public CodeBreaker getCurrentBreaker()
   :outertype: StartStats

getCurrentGame
^^^^^^^^^^^^^^

.. java:method:: public SingleMatch getCurrentGame()
   :outertype: StartStats

getCurrentMaker
^^^^^^^^^^^^^^^

.. java:method:: public CodeMaker getCurrentMaker()
   :outertype: StartStats

getHighTresholdLength
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getHighTresholdLength()
   :outertype: StartStats

getIntView
^^^^^^^^^^

.. java:method:: public InteractionView getIntView()
   :outertype: StartStats

getLowTresholdAttempts
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getLowTresholdAttempts()
   :outertype: StartStats

getLowTresholdLength
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getLowTresholdLength()
   :outertype: StartStats

getMakers
^^^^^^^^^

.. java:method:: public MakerFactoryRegistry getMakers()
   :outertype: StartStats

getNewGame
^^^^^^^^^^

.. java:method:: public NewGameStats getNewGame()
   :outertype: StartStats

getSequenceLength
^^^^^^^^^^^^^^^^^

.. java:method:: public int getSequenceLength()
   :outertype: StartStats

isKeepSettings
^^^^^^^^^^^^^^

.. java:method:: public boolean isKeepSettings()
   :outertype: StartStats

isToContinue
^^^^^^^^^^^^

.. java:method:: public boolean isToContinue()
   :outertype: StartStats

resetLengthAttempts
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void resetLengthAttempts()
   :outertype: StartStats

   Vengono impostati i valori standard del numero di tentativi e della lunghezza delle sequenze

setAttempts
^^^^^^^^^^^

.. java:method:: public void setAttempts(int attempts)
   :outertype: StartStats

setBreakers
^^^^^^^^^^^

.. java:method:: public void setBreakers(BreakerFactoryRegistry breakers)
   :outertype: StartStats

setCurrentBreaker
^^^^^^^^^^^^^^^^^

.. java:method:: public void setCurrentBreaker(CodeBreaker currentBreaker)
   :outertype: StartStats

setCurrentGame
^^^^^^^^^^^^^^

.. java:method:: public void setCurrentGame(SingleMatch currentGame)
   :outertype: StartStats

setCurrentMaker
^^^^^^^^^^^^^^^

.. java:method:: public void setCurrentMaker(CodeMaker currentMaker)
   :outertype: StartStats

setHighTresholdLength
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setHighTresholdLength(int highTresholdLength)
   :outertype: StartStats

setIntView
^^^^^^^^^^

.. java:method:: public void setIntView(InteractionView intView)
   :outertype: StartStats

setKeepSettings
^^^^^^^^^^^^^^^

.. java:method:: public void setKeepSettings(boolean keepSettings)
   :outertype: StartStats

setLowTresholdAttempts
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setLowTresholdAttempts(int lowTresholdAttempts)
   :outertype: StartStats

setLowTresholdLength
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setLowTresholdLength(int lowTresholdLength)
   :outertype: StartStats

setMakers
^^^^^^^^^

.. java:method:: public void setMakers(MakerFactoryRegistry makers)
   :outertype: StartStats

setNewGame
^^^^^^^^^^

.. java:method:: public void setNewGame(NewGameStats newGame)
   :outertype: StartStats

setSequenceLength
^^^^^^^^^^^^^^^^^

.. java:method:: public void setSequenceLength(int sequenceLength)
   :outertype: StartStats

setToContinue
^^^^^^^^^^^^^

.. java:method:: public void setToContinue(boolean toContinue)
   :outertype: StartStats

