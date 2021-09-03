package chess;

import pieces.*;

public class Board {
	
	private Square[][] situation;
	private int turn;
	private int[][] halfTurn;
	
	// CONSTRUCTORS
	
	public Board() {
		int rows = 8;
		int cols = 8;
		
		Square[][] newBoard = new Square[rows][cols];
		
		int i = 0;
		int j = 0;
		while(i < rows) {
			j = 0;
			while (j < cols) {
				Square sq = new Square(this, i ,j);
				newBoard[i][j] = sq;
				j++;
			}
			i++;
		}
		 
		this.situation = newBoard;
		this.setTurn(0);
		setHalfTurn(new int[2][]);
		
		
	}
	
	// GETTERS AND SETTERS
	
	public Square[][] getSituation(){
		return this.situation;
	}
	
	public void setSituation(Square[][] situation) {
		this.situation = situation;
	}
	
	
	// OTHER METHODS
	
	public void insertPiece(String piece, int row, int col, int color) {
		if (piece == "pawn") {
			Pawn pawn = new Pawn(color, row, col);
			this.situation[row][col].setPiece(pawn);
		}
		else if (piece == "rook") {
			Rook rook = new Rook(color, row, col);
			this.situation[row][col].setPiece(rook);
		}
		else if (piece == "queen") {
			Queen queen = new Queen(color, row, col);
			this.situation[row][col].setPiece(queen);
		}
		else if (piece == "knight") {
			Knight knight = new Knight(color, row, col);
			this.situation[row][col].setPiece(knight);
		}
		else if (piece == "king") {
			King king = new King(color, row, col);
			this.situation[row][col].setPiece(king);
		}
		else if (piece == "bishop") {
			Bishop bishop = new Bishop(color, row , col);
			this.situation[row][col].setPiece(bishop);
		}
	}
	
	
	public void setStartingPositions() {
		insertPiece("pawn", 1, 0, 0); insertPiece("pawn", 1, 1, 0); insertPiece("pawn", 1, 2, 0);
		insertPiece("pawn", 1, 3, 0); insertPiece("pawn", 1, 4, 0); insertPiece("pawn", 1, 5, 0);
		insertPiece("pawn", 1, 6, 0); insertPiece("pawn", 1, 7, 0); insertPiece("pawn", 6, 0, 1);
		insertPiece("pawn", 6, 1, 1); insertPiece("pawn", 6, 2, 1); insertPiece("pawn", 6, 3, 1);
		insertPiece("pawn", 6, 4, 1); insertPiece("pawn", 6, 5, 1); insertPiece("pawn", 6, 6, 1);
		insertPiece("pawn", 6, 7, 1); insertPiece("rook", 0, 0, 0); insertPiece("rook", 0, 7, 0);
		insertPiece("rook", 7, 0, 1); insertPiece("rook", 7, 7, 1); insertPiece("knight", 0, 1, 0);
		insertPiece("knight", 0, 6, 0); insertPiece("knight", 7, 1, 1); insertPiece("knight", 7, 6, 1);
		insertPiece("bishop", 0, 2, 0); insertPiece("bishop", 0, 5, 0); insertPiece("bishop", 7, 2, 1);
		insertPiece("bishop", 7, 5, 1); insertPiece("queen", 0, 3, 0); insertPiece("queen", 7, 3, 1);
		insertPiece("king", 0, 4, 0); insertPiece("king", 7, 4, 1);
	}
	
	public void drawBoardInConsole() {
		System.out.println("  -   -   -   -   -   -   -   -");
		int i = 7;
		while(i >= 0) {
			Square[] row = new Square[7];
			row = situation[i];
			System.out.print("|");
			for (Square sq : row) {
				
				if (sq.getPiece() instanceof Pawn) {
					if (sq.getPiece().getColor() == 0){
						System.out.print(" P ");
					}
					else {
						System.out.print(" p ");
					}
				}
				else if (sq.getPiece() instanceof Rook) {
					if (sq.getPiece().getColor() == 0){
						System.out.print(" R ");
					}
					else {
						System.out.print(" r ");
					}
				}
				else if (sq.getPiece() instanceof Bishop) {
					if (sq.getPiece().getColor() == 0){
						System.out.print(" B ");
					}
					else {
						System.out.print(" b ");
					}
				}
				else if (sq.getPiece() instanceof Knight) {
					if (sq.getPiece().getColor() == 0){
						System.out.print(" N ");
					}
					else {
						System.out.print(" n ");
					}
				}
				else if (sq.getPiece() instanceof King) {
					if (sq.getPiece().getColor() == 0){
						System.out.print(" K ");
					}
					else {
						System.out.print(" k ");
					}
				}
				else if (sq.getPiece() instanceof Queen) {
					if (sq.getPiece().getColor() == 0){
						System.out.print(" Q ");
					}
					else {
						System.out.print(" q ");
					}
				}
				else {
					System.out.print("   ");
				}
				System.out.print("|");
				
			}
			
			System.out.println();
			System.out.println("  -   -   -   -   -   -   -   -");
			
			i--;
		}
		System.out.println("  0   1   2   3   4   5   6   7");
		System.out.println();
	}
	
	public void move(int[] selection, int[] destination) throws IllegalArgumentException {
		Piece item = situation[selection[0]][selection[1]].getPiece();
		if (item == null) {
			throw new IllegalArgumentException("Selected Square does not contain a piece!");
		}
		else if (!item.possibleSquare(selection, destination, this)) {
			throw new IllegalArgumentException("Selected destination is not a possible move!");
		}
		else {
			situation[destination[0]][destination[1]].setPiece(situation[selection[0]][selection[1]].getPiece());
			situation[selection[0]][selection[1]].setPiece(null);
			item.setRow(destination[0]);
			item.setCol(destination[1]);
		}
		this.drawBoardInConsole();
	}
	
	public Square[] findAllPseudoLegalMoves(Piece piece) {
		
		Square[] output = new Square[100];
		
		int[] location = {piece.getRow(), piece.getCol()};
		int[][] allPossibleMoves = piece.listPossibleMoves(location);
		
		int i = 0;
		for (int[] move : allPossibleMoves) {
			if (piece.possibleSquare(location, move, this)) {
				output[i] = this.situation[location[0]][location[1]];
			}
			i++;
		}
		
		
		output = this.nullRemover(output);
		
		for (Square sq: output) {
			System.out.println(sq);
		}
		
		return output;
		
	}
	
	public Square[] nullRemover(Square[] list){
		int i = 0;
		for (Square item : list) {
			if (item != null) {
				i++;
			}
		}
		
		Square[] removed = new Square[i];
		i = 0;
		for (Square item : list) {
			if (item != null) {
				removed[i] = item;
				i++;
			}
		}
		
		return removed;
	}
	

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int[][] getHalfTurn() {
		return halfTurn;
	}

	public void setHalfTurn(int[][] halfTurn) {
		this.halfTurn = halfTurn;
	}
	
	
	
	
	
}
