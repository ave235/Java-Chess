package pieces;

import chess.Board;

public class Pawn implements Piece {
	
	private int color; //0 is white, 1 is black
	
	public Pawn() {
		this.setColor(0);
	}
	
	public Pawn(int color) {
		this.setColor(color);
	}
	
	
	public String toString() {
		if (this.color == 0) {
			return "White Pawn";
		}
		return "Black Pawn";
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public int[][] listPossibleMoves(int[] currentPosition) {
		int[][] output = new int[50][0];
		
		int i = 0;
		int row = currentPosition[0];
		int col = currentPosition[1];
		
		if (this.color == 0) { //if pawn is white
			
			
			
		}
		else if (this.color == 1){ //if pawn is black
			
		}
		
		return output;
	}

	@Override
	public boolean possibleSquare(int[] origin, int[] destination, Board board) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
