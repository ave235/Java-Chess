package pieces;

import chess.Board;

public interface Piece {
	int getColor();
	void setColor(int color);
	int[][] listPossibleMoves(int[] currentPosition);
	boolean possibleSquare(int[] origin, int[] destination, Board board);
	boolean possibleSquareWithoutLookingForCheckToOwnKing(int[] origin, int[] destination, Board board);
	public int getRow();
	public int getCol();
	public void setRow(int row);
	public void setCol(int col);
}
