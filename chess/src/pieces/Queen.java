package pieces;

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

	@Override
	public int[][] listPossibleMoves(int[] currentPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean possibleSquare(int[] origin, int[] destination) {
		// TODO Auto-generated method stub
		return false;
	}

}
