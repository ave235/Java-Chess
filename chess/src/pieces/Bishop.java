package pieces;

import chess.Board;

public class Bishop implements Piece{
	
	private int color;
	private int row;
	private int col;

	public Bishop() {
		this.setColor(0);
	}
	
	public Bishop(int color, int row, int col) {
		this.setColor(color);
		this.row = row;
		this.col = col;
	}
	
	public Bishop copy(Bishop bishop) {
		Bishop output = new Bishop(bishop.getColor(), bishop.getRow(), bishop.getCol());
		
		return output;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public String toString() {
		if (this.color == 0) {
			return "White Bishop";
		}
		return "Black Bishop";
	}

	@Override
	public int[][] listPossibleMoves(int[] currentPosition) {
		int[][] output = new int[50][];
		int i = 0;
		
		
		
		//NE
		int posRow = currentPosition[0];
		int posCol = currentPosition[1];
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
		
		if (board.getTurn() != this.color) { //Prevents from moving a piece who's turn it isn't!
			return false;
		}
		
		if(origin[0] == destination[0] || origin[1] == destination[1]) {
			return false;
		}
		
		int deltaRow = 0;
		int deltaColumn = 0;
		int initRow = origin[0];
		int initCol = origin[1];
		
		
		
		if (initRow < destination[0]) {
			deltaRow = 1;
		}
		else {
			deltaRow = -1;
		}
		
		if (initCol < destination[1]) {
			deltaColumn = 1;
		}
		else {
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
		
		if (board.getSituation()[destination[0]][destination[1]].getPiece() == null) {
			if (!board.resultsInCheckToOwnKing(origin, destination)) {
				return true;
			} else {
				return false;
			}
		}
		
		if (board.getSituation()[destination[0]][destination[1]].getPiece().getColor() != this.getColor()) {
			if (!board.resultsInCheckToOwnKing(origin, destination)) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean possibleSquareWithoutLookingForCheckToOwnKing(int[] origin, int[] destination, Board board) {
		
		if (board.getTurn() != this.color) { //Prevents from moving a piece who's turn it isn't!
			return false;
		}
		
		if(origin[0] == destination[0] || origin[1] == destination[1]) {
			return false;
		}
		
		int deltaRow = 0;
		int deltaColumn = 0;
		int initRow = origin[0];
		int initCol = origin[1];
		
		
		
		if (initRow < destination[0]) {
			deltaRow = 1;
		}
		else {
			deltaRow = -1;
		}
		
		if (initCol < destination[1]) {
			deltaColumn = 1;
		}
		else {
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
			if (item == null) {
				
			}
			else if (item.length != 0) {
				i++;
			}
		}
		
		int[][] removed = new int[i][0];
		i = 0;
		for (int[] item : list) {
			if (item == null) {
				
			}
			else if (item.length != 0) {
				removed[i] = item;
				i++;
			}
		}
		
		return removed;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}


}
