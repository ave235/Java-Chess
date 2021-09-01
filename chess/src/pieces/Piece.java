package pieces;

public interface Piece {
	int getColor();
	void setColor(int color);
	int[][] listPossibleMoves(int[] currentPosition);
	boolean possibleSquare(int[] origin, int[] destination);
}
