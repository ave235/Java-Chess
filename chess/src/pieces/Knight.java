package pieces;

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
