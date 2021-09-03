package pieces;

import chess.Board;

public class Pawn implements Piece {
	
	private int color; //0 is white, 1 is black
	private int row;
	private int col;
	
	public Pawn() {
		this.setColor(0);
	}
	
	public Pawn(int color, int row, int col) {
		this.setColor(color);
		this.row = row;
		this.col = col;
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
			if (row == 1) {
				int[] newPosition = {row + 2, col};
				output[i] = newPosition;
				i++;
			}
			if (row < 7) {
				int[] newPosition = {row + 1, col};
				output[i] = newPosition;
				i++;
			}
			if (row < 7 && col > 0) {
				int[] leftCapture = {row + 1, col - 1};
				output[i] = leftCapture;
				i++;
			}
			if (row < 7 && col < 7) {
				int[] rightCapture = {row + 1, col + 1};
				output[i] = rightCapture;
				i++;
			}
			
		}
		
		else if (this.color == 1){ //if pawn is black
			
			if (row == 6) {
				int[] newPosition = {row - 2, col};
				output[i] = newPosition;
				i++;
			}
			if (row > 0) {
				int[] newPosition = {row - 1, col};
				output[i] = newPosition;
				i++;
			}
			if (row > 0 && col > 0) {
				int[] leftCapture = {row - 1, col - 1};
				output[i] = leftCapture;
				i++;
			}
			
			if (row > 0 && col < 7) {
				int[] rightCapture = {row - 1, col + 1};
				output[i] = rightCapture;
				i++;
			}
			
		}
		
		output = this.nullRemover(output);
		
		return output;
	}

	@Override
	public boolean possibleSquare(int[] origin, int[] destination, Board board) {
		
		Piece destPiece = board.getSituation()[destination[0]][destination[1]].getPiece();
		
		if (board.getTurn() != this.color) { //Prevents from moving a piece who's turn it isn't!
			return false;
		}
		
		if (this.color == 0) {
			
			if(origin[1] == destination[1] && destination[0] - origin[0] == 1 //single move forward
			&& destPiece == null) {
			return true;
			}
			
			if(origin[1] == destination[1] && destination[0] - origin[0] == 2 //double move forward
			&& destPiece == null && board.getSituation()[destination[0]-1][destination[1]].getPiece() == null
			&& origin[0] == 1) {
				return true;
			}
			
			if (destPiece != null) {
				if(origin[1] - destination[1] == 1 && destination[0] - origin[0] == 1 //capture left
				&& destPiece.getColor() == 1) {
					return true;
				}
				
				if(origin[1] - destination[1] == -1 && destination[0] - origin[0] == 1 //capture right
				&& destPiece.getColor() == 1) {
					return true;
				}
			}
			
		} 
		
		else {
			
			if(origin[1] == destination[1] && destination[0] - origin[0] == -1 //single move backward
			&& destPiece == null) {
				return true;
			}
			
			if(origin[1] == destination[1] && destination[0] - origin[0] == -2 //double move forward
			&& destPiece == null && board.getSituation()[destination[0]+1][destination[1]].getPiece() == null
			&& origin[0] == 6) {
				return true;
			}
			
			if (destPiece != null) {
				if(origin[1] - destination[1] == 1 && destination[0] - origin[0] == -1 //capture left
				&& destPiece.getColor() == 0) {
					return true;
				}
						
				if(origin[1] - destination[1] == -1 && destination[0] - origin[0] == -1 //capture right
				&& destPiece.getColor() == 0) {
					return true;
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
	
}
