package driver;

import chess.*;
import gui.Table;


public class Driver {
	
	
	// DRIVER METHOD
	
		public static void main (String [] args) {
			Board test = new Board();
			test.setStartingPositions();
			test.drawBoardInConsole();

			Table guiTest = new Table(test);
			
		}
}
