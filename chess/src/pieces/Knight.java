package pieces;

import chess.Board;

public class Knight implements Piece {

	private int color;
	private int row;
	private int col;
	
	public Knight () {
		this.setColor(0);
	}
	
	public Knight(int color, int row, int col) {
		this.setColor(color);
		this.setRow(row);
		this.setCol(col);
	}
	
	public Knight copy(Knight knight) {
		Knight output = new Knight(knight.getColor(), knight.getRow(), knight.getCol());
		
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
			return "White Knight";
		}
		return "Black Knight";
	}

	@Override
	public int[][] listPossibleMoves(int[] currentPosition) {
		int[][] output = new int[8][0];
		
		int i = 0;
		int posRow = currentPosition[0];
		int posCol = currentPosition[1];
		
		//NNE
		if (posRow <= 5 && posCol <= 6) {
			int[] possibleMoveNNE = {posRow + 2, posCol + 1};
			output[i] = possibleMoveNNE;
			i++;
		}
		
		//NEE
		if (posRow <= 6 && posCol <= 5) {
			int[] possibleMoveNEE = {posRow + 1, posCol + 2};
			output[i] = possibleMoveNEE;
			i++;
		}
		
		//SEE
		if (posRow >= 1 && posCol <= 5) {
			int[] possibleMoveSEE = {posRow - 1, posCol + 2};
			output[i] = possibleMoveSEE;
			i++;
		}

		//SSE
		if (posRow >= 2 && posCol <= 6) {
			int[] possibleMoveSSE = {posRow - 2, posCol + 1};
			output[i] = possibleMoveSSE;
			i++;
		}
		
		//SSW
		if (posRow >= 2 && posCol >= 1) {
			int[] possibleMoveSSW = {posRow - 2, posCol - 1};
			output[i] = possibleMoveSSW;
			i++;
		}
		
		//SWW
		if (posRow >= 1 && posCol >= 2) {
			int[] possibleMoveSWW = {posRow - 1, posCol - 2};
			output[i] = possibleMoveSWW;
			i++;
		}
		
		//NWW
		if (posRow <= 6 && posCol >= 2) {
			int[] possibleMoveNWW = {posRow + 1, posCol - 2};
			output[i] = possibleMoveNWW;
			i++;
		}
		
		
		//NNW
		if (posRow <= 5 && posCol >= 1) {
			int[] possibleMoveNNW = {posRow + 2, posCol - 1};
			output[i] = possibleMoveNNW;
			i++;
		}
		
		output = this.nullRemover(output);
		
		return output;
	}

	@Override
	public boolean possibleSquare(int[] origin, int[] destination, Board board) {
		
		int[][] listOfMoves = this.listPossibleMoves(origin);
		Piece pieceAtDestination = board.getSituation()[destination[0]][destination[1]].getPiece();
		
		if (board.getTurn() != this.color) { //Prevents from moving a piece who's turn it isn't!
			return false;
		}
		
		for (int[] move : listOfMoves) {
			if(move[0] == destination[0] && move[1] == destination[1]) {
				if(pieceAtDestination == null) {
					if (!board.resultsInCheckToOwnKing(origin, destination)) {
						return true;
					} else {
						return false;
					}
				}
				else if(this.color != pieceAtDestination.getColor()) {
					if (!board.resultsInCheckToOwnKing(origin, destination)) {
						return true;
					} else {
						return false;
					}
				}
			}
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

	@Override
	public boolean possibleSquareWithoutLookingForCheckToOwnKing(int[] origin, int[] destination, Board board) {
		int[][] listOfMoves = this.listPossibleMoves(origin);
		Piece pieceAtDestination = board.getSituation()[destination[0]][destination[1]].getPiece();
		
		if (board.getTurn() != this.color) { //Prevents from moving a piece who's turn it isn't!
			return false;
		}
		
		for (int[] move : listOfMoves) {
			if(move[0] == destination[0] && move[1] == destination[1]) {
				if(pieceAtDestination == null) {
					return true;
				}
				else if(this.color != pieceAtDestination.getColor()) {
					return true;
				}
			}
		}
		
		
		return false;
	}
}
