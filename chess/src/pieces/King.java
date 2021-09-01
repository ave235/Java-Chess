package pieces;

public class King implements Piece{

	private int color;
	
	public King() {
		this.setColor(0);
	}
	
	public King(int color) {
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
		int[][] output = new int[8][];
		int row = currentPosition[0];
		int col = currentPosition[1];
		int i = 0;
		
		// N
		if (row < 7) {
			int [] newPosition = {row + 1, col}; 
			output[i] = newPosition;
			i++;
		}
		
		// S
		if (row > 0) {
			int [] newPosition = {row - 1, col}; 
			output[i] = newPosition;
			i++;
		}
		
		// E
		if (col < 7) {
			int [] newPosition = {row, col + 1}; 
			output[i] = newPosition;
			i++;
		}
		
		// W
		if (col > 0) {
			int [] newPosition = {row, col - 1}; 
			output[i] = newPosition;
			i++;
		}
		
		//NE
		if (col < 7 && row < 7) {
			int [] newPosition = {row + 1, col + 1};
			output[i] = newPosition;
			i++;		
		}
		
		//SE
		if (col > 0 && row < 7) {
			int [] newPosition = {row + 1, col - 1};
			output[i] = newPosition;
			i++;		
		}
		
		//SW
		if (col > 0 && row > 0) {
			int [] newPosition = {row - 1, col - 1};
			output[i] = newPosition;
			i++;		
		}
		
		//NW
		if (col < 7 && row > 0) {
			int [] newPosition = {row - 1, col + 1};
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
