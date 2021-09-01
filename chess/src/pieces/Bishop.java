package pieces;

public class Bishop implements Piece{
	
	private int color;

	public Bishop() {
		this.setColor(0);
	}
	
	public Bishop(int color) {
		this.setColor(color);
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
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
		
		
		
		return output;
	}

	@Override
	public boolean possibleSquare(int[] origin, int[] destination) {
		
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
