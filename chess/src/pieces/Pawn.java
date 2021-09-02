package pieces;

public class Pawn implements Piece {
	
	private int color; //0 is white, 1 is black
	
	public Pawn() {
		this.setColor(0);
	}
	
	public Pawn(int color) {
		this.setColor(color);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean possibleSquare(int[] origin, int[] destination) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
