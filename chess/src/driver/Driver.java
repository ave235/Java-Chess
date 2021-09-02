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
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int[] selection = {0,1};
			int[] destination = {2,2};
			test.move(selection, destination);
			
			guiTest.refreshBoard();
			
		}
		
		
}
