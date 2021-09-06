package chess;

import java.util.Random;
import gui.Table;

public class RandomAI {
	
	private Board board;
	private Table guiInterface;
	
	public RandomAI(Board board, Table guiInterface) {
		this.board = board;
		this.guiInterface = guiInterface;
	}
	
	
	public void makeMove() {
		if (board.getWinner() == 2) {
			Square[][] situation = board.getSituation();
			Square[] possiblePieces = new Square[100];
			int i = 0;
			for (Square[] row : situation) {
				for (Square square : row) {
					if (square.getPiece() != null) {
						if (board.findAllLegalMoves(square.getPiece()).length > 0) {
							possiblePieces[i] = square;
							i++;
						}
					}
				}
			}
		
			possiblePieces = nullRemover(possiblePieces);
			Random rand = new Random();
			Square piecePick = possiblePieces[rand.nextInt(possiblePieces.length)];
			
			Square[] possibleMoves = board.findAllLegalMoves(piecePick.getPiece());
			
			Square movePick = possibleMoves[rand.nextInt(possibleMoves.length)];
			
			int[] origin = {piecePick.getRow(), piecePick.getCol()};
			int[] destination = {movePick.getRow(), movePick.getCol()};
			
			board.move(origin, destination);
			
			this.guiInterface.refreshBoard();
		}
	}
	
	public static Square[] nullRemover(Square[] input) {
		int amount = 0;
		for (Square square : input) {
			if (square != null) {
				amount ++;
			}
		}
		
		Square[] output = new Square[amount];
		
		int i = 0;
		for (Square square : input) {
			if (square != null) {
				output[i] = square; 
				i++;
			}
		}
		
		return output;
	}

	public Board getBoard() {
		return board;
	}


	public void setBoard(Board board) {
		this.board = board;
	}
	
}
