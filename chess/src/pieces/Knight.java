package pieces;

import chess.Board;

public class Knight implements Piece {

	private int color;
	
	public Knight () {
		this.setColor(0);
	}
	
	public Knight(int color) {
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
		int[] possibleMoveNNE = {posRow + 2, posCol + 1};
		output[i] = possibleMoveNNE;
		i++;
		
		//NEE
		int[] possibleMoveNEE = {posRow + 1, posCol + 2};
		output[i] = possibleMoveNEE;
		i++;

		//SEE
		int[] possibleMoveSEE = {posRow - 1, posCol + 2};
		output[i] = possibleMoveSEE;
		i++;

		//SSE
		int[] possibleMoveSSE = {posRow - 2, posCol + 1};
		output[i] = possibleMoveSSE;
		i++;
		
		//SSW
		int[] possibleMoveSSW = {posRow - 2, posCol - 1};
		output[i] = possibleMoveSSW;
		i++;
		
		//SWW
		int[] possibleMoveSWW = {posRow - 1, posCol - 2};
		output[i] = possibleMoveSWW;
		i++;
		
		//NWW
		int[] possibleMoveNWW = {posRow + 1, posCol - 2};
		output[i] = possibleMoveNWW;
		i++;
		
		
		//NNW
		int[] possibleMoveNNW = {posRow + 2, posCol - 1};
		output[i] = possibleMoveNNW;
		i++;
		
		return output;
	}

	@Override
	public boolean possibleSquare(int[] origin, int[] destination, Board board) {
		
		int[][] listOfMoves = this.listPossibleMoves(origin);
		for (int[] move : listOfMoves) {
			if (move == null) {
				continue;
			}
			else if(move[0] == destination[0] && move[1] == destination[1]) {
				return true;
			}
		}
		
		return false;
	}
}
