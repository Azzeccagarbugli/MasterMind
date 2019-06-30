.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util List

.. java:import:: org.junit.jupiter.api BeforeEach

.. java:import:: org.junit.jupiter.api Test

.. java:import:: it.unicam.cs.pa.mastermind.gamecore BoardController

.. java:import:: it.unicam.cs.pa.mastermind.gamecore BoardModel

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.gamecore MatchState

GameCoreBoardControllerTest
===========================

.. java:package:: it.unicam.cs.pa.mastermind.test
   :noindex:

.. java:type::  class GameCoreBoardControllerTest

   Test di controllo utili alle meccaniche del coordinatore di gioco.

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
attempt
^^^^^^^

.. java:field::  List<ColorPegs> attempt
   :outertype: GameCoreBoardControllerTest

toGuess
^^^^^^^

.. java:field::  List<ColorPegs> toGuess
   :outertype: GameCoreBoardControllerTest

Methods
-------
setUp
^^^^^

.. java:method:: @BeforeEach  void setUp()
   :outertype: GameCoreBoardControllerTest

   Setup of the board runned before each other test.

testBoardController
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testBoardController()
   :outertype: GameCoreBoardControllerTest

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.gamecore.BoardController.BoardController(it.unicam.cs.pa.mastermind.gamecore.BoardModel)`\ .

testGetSequenceLength
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testGetSequenceLength()
   :outertype: GameCoreBoardControllerTest

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.gamecore.BoardController.getSequenceLength()`\ .

testGetSequenceToGuess
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testGetSequenceToGuess()
   :outertype: GameCoreBoardControllerTest

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.gamecore.BoardController.getSequenceToGuess()`\ .

testInsertCodeToGuess
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testInsertCodeToGuess()
   :outertype: GameCoreBoardControllerTest

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.gamecore.BoardController.insertCodeToGuess(java.util.List)`\ .

testInsertNewAttempt
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testInsertNewAttempt()
   :outertype: GameCoreBoardControllerTest

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.gamecore.BoardController.insertNewAttempt(java.util.List)`\ .

