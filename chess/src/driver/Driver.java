package driver;

import chess.*;
import gui.BlackSquare;
import gui.Table;
import gui.WhiteSquare;
import java.lang.Thread;

import javax.swing.JLabel;


public class Driver {
	
	
	// DRIVER METHOD
	
		public static void main (String [] args) {
			Board test = new Board();
			test.setStartingPositions();
			test.drawBoardInConsole();
			Table guiTest = new Table(test);
			guiTest.tableAssignment();
			test.findAllPseudoLegalMoves(test.getSituation()[0][0].getPiece());
		}
		
		
}
