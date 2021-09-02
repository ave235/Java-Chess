

package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import chess.Board;

public class Table extends JFrame implements MouseListener {
	
	public Table(Board brd) {
		
		
		this.setTitle("Chess");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(815,839);
		this.getContentPane().setBackground(Color.WHITE);
		this.setLayout(null);
		
		ImageIcon fauxicon = new ImageIcon("Images/bk.png");
		this.setIconImage(fauxicon.getImage());
		
		int i = 7;
		int j = 0;
		while (i > -1) {
			if (i % 2 == 0) {
				j = 0;
				while (j < 8) {
					if (j % 2 == 1) {
						BlackSquare bs = new BlackSquare(brd.getSituation()[7-i][j]);
						bs.setBounds(j*100, i*100, 100, 100);
						this.add(bs);
						j++;
					}
					else {
						WhiteSquare ws = new WhiteSquare(brd.getSituation()[7-i][j]);
						ws.setBounds(j*100, i*100, 100, 100);
						this.add(ws);
						j++;
					}
						
				}
				i--;
			}
			else {
				j = 0;
				while (j < 8) {
					if (j % 2 == 0) {
						BlackSquare bs = new BlackSquare(brd.getSituation()[7-i][j]);
						bs.setBounds(j*100, i*100, 100, 100);
						this.add(bs);
						j++;
					}
					else {
						WhiteSquare ws = new WhiteSquare(brd.getSituation()[7-i][j]);
						ws.setBounds(j*100, i*100, 100, 100);
						this.add(ws);
						j++;
					}
						
				}
				i--;
			}
		}
		
		this.setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
