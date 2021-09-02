package driver;

import chess.*;
import gui.Table;


public class Driver {
	
	
	// DRIVER METHOD
	
		public static void main (String [] args) {
			Board test = new Board();
			test.setStartingPositions();
			test.drawBoardInConsole();
			int[] selection = {0,3};
			int[] destination = {3,0};
			test.move(selection, destination);
			test.drawBoardInConsole();
			
			Table guiTest = new Table();
			
		}
}
