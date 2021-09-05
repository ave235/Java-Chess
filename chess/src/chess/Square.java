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
	
	public Square copy(Square square, Board board) {
		Square output = new Square(board, square.getRow(), square.getCol());
		if (square.getPiece() != null) {
			Piece piece = square.getPiece();
			if (piece instanceof Knight) {
				output.setPiece(((Knight) piece).copy((Knight) piece));
			}
			else if (piece instanceof Bishop) {
				output.setPiece(((Bishop) piece).copy((Bishop) piece));
			}
			else if (piece instanceof King) {
				output.setPiece(((King) piece).copy((King) piece));
			}
			else if (piece instanceof Queen) {
				output.setPiece(((Queen) piece).copy((Queen) piece));
			}
			else if (piece instanceof Pawn) {
				output.setPiece(((Pawn) piece).copy((Pawn) piece));
			}
			else if (piece instanceof Rook) {
				output.setPiece(((Rook) piece).copy((Rook) piece));
			}
		}
		
		return output;
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
	
	public String toString() {
		String output = "";
		output += String.valueOf(this.row);
		output += ", ";
		output += String.valueOf(this.col);
		return output;
	}
	
	
}
