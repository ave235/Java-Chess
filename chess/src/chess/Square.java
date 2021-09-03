package chess;

import pieces.*;

public class Square {
	private Piece piece;
	private Board board;
	
	// CONSTRUCTORS
	
	public Square(Board board) {
		this.setPiece(null);
		this.setBoard(board);
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
	
	
	
}
