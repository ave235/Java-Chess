package pieces;

import chess.Board;

public class Queen implements Piece {

	private int color;
	
	public Queen() {
		this.setColor(0);
	}
	
	public Queen(int color) {
		this.setColor(color);
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public String toString() {
		if (this.color == 0) {
			return "White Queen";
		}
		return "Black Queen";
	}

	@Override
	public int[][] listPossibleMoves(int[] currentPosition) {
		int[][] output = new int[50][];
		int i = 0;
		
		//N
		int posRow = currentPosition[0];
		int posCol = currentPosition[1];
		while (posCol < 7) {
			posCol++;
			int[] newPosition = {posRow, posCol};
			output[i] = newPosition;
			i++;
		}
		
		//S
		posRow = currentPosition[0];
		posCol = currentPosition[1];
		while (posCol > 0) {
			posCol--;
			int[] newPosition = {posRow, posCol};
			output[i] = newPosition;
			i++;
		}
		
		//E
		posRow = currentPosition[0];
		posCol = currentPosition[1];
		while (posRow < 7) {
			posRow++;
			int[] newPosition = {posRow, posCol};
			output[i] = newPosition;
			i++;
		}
		
		//W
		posRow = currentPosition[0];
		posCol = currentPosition[1];
		while (posRow > 0) {
			posRow--;
			int[] newPosition = {posRow, posCol};
			output[i] = newPosition;
			i++;
		}
		
		//NE
		posRow = currentPosition[0];
		posCol = currentPosition[1];
		while (posRow < 7 && posCol < 7) {
			posRow++;
			posCol++;
			int[] newPosition = new int[2];
			newPosition[0] = posRow;
			newPosition[1] = posCol;
			output[i] = newPosition;
			i++;

		}
				
		//SE
		posRow = currentPosition[0];
		posCol = currentPosition[1];
		while (posRow > 0 && posCol < 7) {
			posRow--;
			posCol++;
			int[] newPosition = new int[2];
			newPosition[0] = posRow;
			newPosition[1] = posCol;
			output[i] = newPosition;
			i++;
		}
				
		// SW
		posRow = currentPosition[0];
		posCol = currentPosition[1];
		while (posRow > 0 && posCol > 0) {
			posRow--;
			posCol--;
			int[] newPosition = new int[2];
			newPosition[0] = posRow;
			newPosition[1] = posCol;
			output[i] = newPosition;
			i++;
		}
				
		//NW
		posRow = currentPosition[0];
		posCol = currentPosition[1];
		while (posRow < 7 && posCol > 0) {
			posRow++;
			posCol--;
			int[] newPosition = new int[2];
			newPosition[0] = posRow;
			newPosition[1] = posCol;
			output[i] = newPosition;
			i++;
		}
		
		output = this.nullRemover(output);
		
		return output;
	}

	@Override
	public boolean possibleSquare(int[] origin, int[] destination, Board board) {
		int deltaRow = 0;
		int deltaColumn = 0;
		int initRow = origin[0];
		int initCol = origin[1];
		
		
		
		if (initRow < destination[0]) {
			deltaRow = 1;
		}
		else if (initRow > destination[0]) {
			deltaRow = -1;
		}
		
		if (initCol < destination[1]) {
			deltaColumn = 1;
		}
		else if (initCol > destination[1]){
			deltaColumn = -1;
		}
		
		if (deltaRow != 0 && deltaColumn != 0) {
			if ((origin[0] - destination[0]) - (origin[1] - destination[1]) != 0
				&& (origin[0] - destination[0]) + (origin[1] - destination[1]) != 0) {
				return false;
			}
		}
		
		while (initRow != destination[0] && initCol != destination[1]) {
			
			if(initRow != origin[0]) {
				if (board.getSituation()[initRow][initCol].getPiece() != null) {
					return false;
				}
				
			}
			
			initRow = initRow + deltaRow;
			initCol = initCol + deltaColumn;
		}
		
		if (deltaColumn == 0) {
			
			while (initRow != destination[0]) {
				
				if (initRow != origin[0]) {
					if (board.getSituation()[initRow][initCol].getPiece() != null) {
						return false;
					}
				}
				
				initRow = initRow + deltaRow;
			}
			
		}
		
		else if (deltaRow == 0) {
			
			while (initCol != destination[1]) {
				
				if (initCol != origin[1]) {
					if (board.getSituation()[initRow][initCol].getPiece() != null) {
						return false;
					}
				}
				
				initCol = initCol + deltaColumn;
			}
		}
		
		if (board.getSituation()[destination[0]][destination[1]].getPiece() == null) {
			return true;
		}
		
		if (board.getSituation()[destination[0]][destination[1]].getPiece().getColor() != this.getColor()) {
			return true;
		}
		
		return false;
	}
	
	public int[][] nullRemover(int[][] list){
		int i = 0;
		for (int[] item : list) {
			if (item != null) {
				i++;
			}
		}
		
		int[][] removed = new int[i][0];
		i = 0;
		for (int[] item : list) {
			if (item != null) {
				removed[i] = item;
				i++;
			}
		}
		
		return removed;
	}

}
