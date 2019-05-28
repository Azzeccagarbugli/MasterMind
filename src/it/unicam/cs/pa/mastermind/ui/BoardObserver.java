package it.unicam.cs.pa.mastermind.ui;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;

public abstract class BoardObserver {

	   protected BoardModel subject;
	   public abstract void update();
	   
	   public void addSubject(BoardModel subject) {
		   this.subject = subject;
		   subject.addObserver(this);
	   }
	   
}
