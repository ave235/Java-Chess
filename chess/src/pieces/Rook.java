package pieces;

public class Rook implements Piece{

	private int color;
	
	public Rook() {
		this.setColor(0);
	}
	
	public Rook(int color) {
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
