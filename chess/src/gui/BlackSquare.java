package gui;

import java.awt.Color;

import javax.swing.JLabel;

import chess.Square;

public class BlackSquare extends JLabel{
	
	private Square sq;
	
	public BlackSquare(Square sq) {
		
		this.setSq(sq);
		this.setBackground(Color.BLACK);
		this.setOpaque(true);
		
	}

	public Square getSq() {
		return sq;
	}

	public void setSq(Square sq) {
		this.sq = sq;
	}
	
	
	
}
