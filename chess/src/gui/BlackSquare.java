package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import chess.Square;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class BlackSquare extends JLabel implements MouseListener{
	
	private Square sq;
	
	ImageIcon bb = new ImageIcon("Images/bb.png");
	ImageIcon bk = new ImageIcon("Images/bk.png");
	ImageIcon bn = new ImageIcon("Images/bn.png");
	ImageIcon bp = new ImageIcon("Images/bp.png");
	ImageIcon br = new ImageIcon("Images/br.png");
	ImageIcon bq = new ImageIcon("Images/bq.png");
	ImageIcon wb = new ImageIcon("Images/wb.png");
	ImageIcon wk = new ImageIcon("Images/wk.png");
	ImageIcon wn = new ImageIcon("Images/wn.png");
	ImageIcon wp = new ImageIcon("Images/wp.png");
	ImageIcon wq = new ImageIcon("Images/wq.png");
	ImageIcon wr = new ImageIcon("Images/wr.png");
	
	public BlackSquare(Square sq) {
		
		this.setSq(sq);
		this.setBackground(new Color(179, 116, 34));
		this.setOpaque(true);
		this.setSize(50,50);
		

		
		if (this.sq.getPiece() != null) {
			Piece currentPiece = this.sq.getPiece();
			int currentColor = currentPiece.getColor();
		
			if(currentPiece instanceof Pawn && currentColor == 0) {
				this.setIcon(wp);
			}
			else if(currentPiece instanceof Pawn && currentColor == 1) {
				this.setIcon(bp);
			}
			else if(currentPiece instanceof Bishop && currentColor == 0) {
				this.setIcon(wb);
			}
			else if(currentPiece instanceof Bishop && currentColor == 1) {
				this.setIcon(bb);
			}
			else if(currentPiece instanceof Knight && currentColor == 0) {
				this.setIcon(wn);
			}
			else if(currentPiece instanceof Knight && currentColor == 1) {
				this.setIcon(bn);
			}
			else if(currentPiece instanceof King && currentColor == 0) {
				this.setIcon(wk);
			}
			else if(currentPiece instanceof King && currentColor == 1) {
				this.setIcon(bk);
			}
			else if(currentPiece instanceof Queen && currentColor == 0) {
				this.setIcon(wq);
			}
			else if(currentPiece instanceof Queen && currentColor == 1) {
				this.setIcon(bq);
			}
			else if(currentPiece instanceof Rook && currentColor == 0) {
				this.setIcon(wr);
			}
			else if(currentPiece instanceof Rook && currentColor == 1) {
				this.setIcon(br);
			}
			
		}
		
		this.setVerticalAlignment(JLabel.CENTER);
		this.setHorizontalAlignment(JLabel.CENTER);
		
		this.addMouseListener(this);
	}
	
	public void refreshImage() {
		
		if (this.sq.getPiece() != null) {
			Piece currentPiece = this.sq.getPiece();
			int currentColor = currentPiece.getColor();
		
			if(currentPiece instanceof Pawn && currentColor == 0) {
				this.setIcon(wp);
			}
			else if(currentPiece instanceof Pawn && currentColor == 1) {
				this.setIcon(bp);
			}
			else if(currentPiece instanceof Bishop && currentColor == 0) {
				this.setIcon(wb);
			}
			else if(currentPiece instanceof Bishop && currentColor == 1) {
				this.setIcon(bb);
			}
			else if(currentPiece instanceof Knight && currentColor == 0) {
				this.setIcon(wn);
			}
			else if(currentPiece instanceof Knight && currentColor == 1) {
				this.setIcon(bn);
			}
			else if(currentPiece instanceof King && currentColor == 0) {
				this.setIcon(wk);
			}
			else if(currentPiece instanceof King && currentColor == 1) {
				this.setIcon(bk);
			}
			else if(currentPiece instanceof Queen && currentColor == 0) {
				this.setIcon(wq);
			}
			else if(currentPiece instanceof Queen && currentColor == 1) {
				this.setIcon(bq);
			}
			else if(currentPiece instanceof Rook && currentColor == 0) {
				this.setIcon(wr);
			}
			else if(currentPiece instanceof Rook && currentColor == 1) {
				this.setIcon(br);
			}
			
		}
		else {
			this.setIcon(null);
		}
	}
	
	public Square getSq() {
		return sq;
	}

	public void setSq(Square sq) {
		this.sq = sq;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("You clicked on a black square!");
		System.out.println("This square contains: " + this.sq.getPiece());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
