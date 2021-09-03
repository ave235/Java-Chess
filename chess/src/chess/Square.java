package chess;

import javax.swing.JLabel;

import pieces.*;

public class Square {
	private Piece piece;
	private Board board;
	private JLabel guiSquare;
	private int row;
	private int col;
	
	// CONSTRUCTORS
	
	public Square(Board board) {
		this.setPiece(null);
		this.setBoard(board);
	}
	
	public Square(Board board, int row, int col) {
		this.setPiece(null);
		this.setBoard(board);
		this.setRow(row);
		this.setCol(col);
	}

	//GETTERS AND SETTERS
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public JLabel getGuiSquare() {
		return guiSquare;
	}

	public void setGuiSquare(JLabel guiSquare) {
		this.guiSquare = guiSquare;
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
