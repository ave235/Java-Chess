package driver;

import chess.*;
import gui.Table;


public class Driver {
	
	
	// DRIVER METHOD
	
		public static void main (String [] args) {
			Board test = new Board();
			test.setStartingPositions();
			test.drawBoardInConsole();
			int[] selection = {0,1};
			int[] destination = {1,3};
			test.move(selection, destination);
			Table guiTest = new Table(test);
		}
}
