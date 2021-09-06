package chess;

import javax.swing.JFrame;

import gui.Table;
import pieces.*;

public class Board {
	
	private Square[][] situation;
	private int turn;
	private int[][] halfTurn;
	private int winner;
	private Piece whiteKing;
	private Piece blackKing;
	private Table frame;
	
	// CONSTRUCTORS
	
	public Board() {
		int rows = 8;
		int cols = 8;
		int turn = 0;
		this.winner = 2;
		
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
	
	public Board copy(Board board) {
		Board output = new Board();
		Square[][] newBoard = new Square[8][8];
		
		int i = 0;
		int j = 0;
		while (i < 8) {
			j = 0;
			while (j < 8) {
				Square sq = board.getSituation()[i][j].copy(board.getSituation()[i][j], output);
				newBoard[i][j] = sq;
				Piece piece = sq.getPiece();
				if (piece instanceof King) {
					if (piece.getColor() == 0) {
						output.setWhiteKing(piece);
					}
					else {
						output.setBlackKing(piece);
					}
				}
				j++;
			}
			i++;
		}
		
		output.setSituation(newBoard);
		output.setTurn(board.getTurn());
		output.setHalfTurn(new int[2][]);
		
		return output;
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
			if (king.getColor() == 0) {
				this.setWhiteKing(king);
			}
			else {
				this.setBlackKing(king);
			}
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
		
		if (turn == 0) {
			if (this.checkFinder(this.blackKing, this)) {
				Table.PlaySound(this.getFrame().getCheckSound());
			} else {
				Table.PlaySound(this.getFrame().getMoveSound());
			}
			turn = 1;
		}
		else {
			if (this.checkFinder(this.whiteKing, this)) {
				Table.PlaySound(this.getFrame().getCheckSound());
			} else {
				Table.PlaySound(this.getFrame().getMoveSound());
			}
			turn = 0;
		}
		if (item instanceof King) {
			((King) item).setHasMoved(true);
		}
		else if (item instanceof Rook) {
			((Rook) item).setHasMoved(true);
		}
		
		if (item instanceof Pawn) {
			if (destination[0] == 7 || destination[0] == 0) {
				this.insertPiece("queen", item.getRow(), item.getCol(), item.getColor());
			}
		}
		
		this.findConclusion(this);
	}
	
	public void forceMove(int[] selection, int[] destination) {
		Piece item = situation[selection[0]][selection[1]].getPiece();
		if (item == null) {
			throw new IllegalArgumentException("Selected Square does not contain a piece!");
		}
		else {
			situation[destination[0]][destination[1]].setPiece(situation[selection[0]][selection[1]].getPiece());
			situation[selection[0]][selection[1]].setPiece(null);
			item.setRow(destination[0]);
			item.setCol(destination[1]);
		}
		if (item instanceof King) {
			((King) item).setHasMoved(true);
		}
		else if (item instanceof Rook) {
			((Rook) item).setHasMoved(true);
		}
		if (item instanceof Pawn) {
			if (destination[0] == 7 || destination[0] == 0) {
				this.insertPiece("queen", item.getRow(), item.getCol(), item.getColor());
			}
		}
	}
	
	
	public Square[] findAllPseudoLegalMoves(Piece piece) {
		
		Square[] output = new Square[100];
		
		int[] location = {piece.getRow(), piece.getCol()};
		int[][] allPossibleMoves = piece.listPossibleMoves(location);
		
		int i = 0;
		for (int[] move : allPossibleMoves) {
			if (piece.possibleSquareWithoutLookingForCheckToOwnKing(location, move, this)) {
				output[i] = this.getSituation()[move[0]][move[1]];
				i++;
			}
			
		}
		
		
		output = this.nullRemover(output);
		
		
		return output;
		
	}
	
	public Square[] findAllLegalMoves(Piece piece) {
		Square[] output = new Square[100];
		
		int[] location = {piece.getRow(), piece.getCol()};
		int[][] allPossibleMoves = piece.listPossibleMoves(location);
		
		int i = 0;
		for (int[] move : allPossibleMoves) {
			if (piece.possibleSquare(location, move, this)) {
				output[i] = this.getSituation()[move[0]][move[1]];
				i++;
			}
			
		}
		
		
		output = this.nullRemover(output);
		
		
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
	
	public boolean checkFinder(Piece king, Board board) {
		
	
		
		for (Square[] row : board.getSituation()) {
			for (Square square : row) {
				if (square.getPiece() != null) {
					Square[] moveResults = board.findAllPseudoLegalMoves(square.getPiece());
					for (Square destination : moveResults) {
						if (destination.getRow() == king.getRow() && destination.getCol() == king.getCol()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean resultsInCheckToOwnKing(int[] origin, int[] requestedMove) {

		Board theoreticalBoard = this.copy(this);
		
		theoreticalBoard.forceMove(origin, requestedMove);
		if (theoreticalBoard.getTurn() == 0) {
			theoreticalBoard.setTurn(1);
		}
		else if (theoreticalBoard.getTurn() == 1) {
			theoreticalBoard.setTurn(0);
		}
		if (theoreticalBoard.getTurn() == 1) {
			boolean output = theoreticalBoard.checkFinder(theoreticalBoard.getWhiteKing(), theoreticalBoard);
			if (theoreticalBoard.getTurn() == 0) {
				theoreticalBoard.setTurn(1);
			}
			else if (theoreticalBoard.getTurn() == 1) {
				theoreticalBoard.setTurn(0);
			}
			return output;
		}
		else {
			boolean output = theoreticalBoard.checkFinder(theoreticalBoard.getBlackKing(), theoreticalBoard);
			if (theoreticalBoard.getTurn() == 0) {
				theoreticalBoard.setTurn(1);
			}
			else if (theoreticalBoard.getTurn() == 1) {
				theoreticalBoard.setTurn(0);
			}
			return output;
		}
	}
	
	public void findConclusion(Board board) {
		int turn = board.getTurn();
		
		Square[][] situation = board.getSituation();
		int numPossibleMoves = 0;
		for (Square[] row : situation) {
			for (Square square : row) {
				if (square.getPiece() != null) {
					if (board.findAllLegalMoves(square.getPiece()).length > 0) {
						numPossibleMoves += board.findAllLegalMoves(square.getPiece()).length;
					}
				}
			}
		}
		
		if (numPossibleMoves == 0) {
			if (turn == 0) {
				board.setTurn(1);
				if (board.checkFinder(board.getWhiteKing(), board)) {
					System.out.println("BLACK WINS");
					board.setWinner(1);
					if (board.getFrame() != null) {
						board.getFrame().reactToSomeoneWinning(board.getWinner());
					}
				}
				else {
					System.out.println("STALEMATE");
					board.setWinner(-1);
					if (board.getFrame() != null) {
						board.getFrame().reactToSomeoneWinning(board.getWinner());
					}
				}
			}
			else {
				board.setTurn(0);
				if (board.checkFinder(board.getBlackKing(), board)) {
					System.out.println("WHITE WINS");
					board.setWinner(0);
					if (board.getFrame() != null) {
						board.getFrame().reactToSomeoneWinning(board.getWinner());
					}
				}
				else {
					System.out.println("STALEMATE");
					board.setWinner(-1);
					if (board.getFrame() != null) {
						board.getFrame().reactToSomeoneWinning(board.getWinner());
					}
				}
			}
		}
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

	public Piece getWhiteKing() {
		return whiteKing;
	}

	public void setWhiteKing(Piece whiteKing) {
		this.whiteKing = whiteKing;
	}

	public Piece getBlackKing() {
		return blackKing;
	}

	public void setBlackKing(Piece blackKing) {
		this.blackKing = blackKing;
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public Table getFrame() {
		return frame;
	}

	public void setFrame(Table frame) {
		this.frame = frame;
	}
	
	
	
	
	
}
