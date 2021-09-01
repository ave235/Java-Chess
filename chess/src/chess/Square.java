package chess;

import pieces.*;

public class Square {
	private Piece piece;
	
	// CONSTRUCTORS
	
	public Square() {
		this.setPiece(null);
	}

	//GETTERS AND SETTERS
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	
	
}
