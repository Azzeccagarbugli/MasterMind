.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util List

.. java:import:: org.junit.jupiter.api Assertions

.. java:import:: org.junit.jupiter.api BeforeEach

.. java:import:: org.junit.jupiter.api Test

.. java:import:: it.unicam.cs.pa.mastermind.gamecore BoardController

.. java:import:: it.unicam.cs.pa.mastermind.gamecore BoardModel

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

GameCoreBoardModelTest
======================

.. java:package:: it.unicam.cs.pa.mastermind.test
   :noindex:

.. java:type::  class GameCoreBoardModelTest

   Test di controllo all'interno della board.

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
attempt
^^^^^^^

.. java:field::  List<ColorPegs> attempt
   :outertype: GameCoreBoardModelTest

toGuess
^^^^^^^

.. java:field::  List<ColorPegs> toGuess
   :outertype: GameCoreBoardModelTest

Methods
-------
setUp
^^^^^

.. java:method:: @BeforeEach  void setUp()
   :outertype: GameCoreBoardModelTest

   Setup of the board runned before each other test.

testAddAttempt
^^^^^^^^^^^^^^

.. java:method:: @Test  void testAddAttempt()
   :outertype: GameCoreBoardModelTest

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.gamecore.BoardModel.addAttempt(java.util.List,java.util.List)`\ .

testAttemptsInserted
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testAttemptsInserted()
   :outertype: GameCoreBoardModelTest

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.gamecore.BoardModel.attemptsInserted()`\ .

testBoard
^^^^^^^^^

.. java:method:: @Test  void testBoard()
   :outertype: GameCoreBoardModelTest

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.gamecore.BoardModel.Board(int,int)`\ .

testIsEmpty
^^^^^^^^^^^

.. java:method:: @Test  void testIsEmpty()
   :outertype: GameCoreBoardModelTest

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.gamecore.BoardModel.isEmpty()`\ .

testLastAttemptAndClue
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testLastAttemptAndClue()
   :outertype: GameCoreBoardModelTest

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.gamecore.BoardModel.lastAttemptAndClue()`\ .

testLeftAttempts
^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testLeftAttempts()
   :outertype: GameCoreBoardModelTest

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.gamecore.BoardModel.leftAttempts()`\ .

testSetSequenceToGuess
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testSetSequenceToGuess()
   :outertype: GameCoreBoardModelTest

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.gamecore.BoardModel.setSequenceToGuess(java.util.List)`\ .

