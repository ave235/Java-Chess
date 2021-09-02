

package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import chess.Board;

public class Table extends JFrame implements MouseListener {
	
	private JLabel[] squareContainer;
	
	public Table(Board brd) {
		
		
		this.setTitle("Chess");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(815,839);
		this.getContentPane().setBackground(Color.WHITE);
		this.setLayout(null);
		
		ImageIcon fauxicon = new ImageIcon("Images/bk.png");
		this.setIconImage(fauxicon.getImage());
		
		this.squareContainer = new JLabel[64];;
		
		int u = 0;
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
						this.squareContainer[u] = bs;
						u++;
						j++;
						
						
					}
					else {
						WhiteSquare ws = new WhiteSquare(brd.getSituation()[7-i][j]);
						ws.setBounds(j*100, i*100, 100, 100);
						this.add(ws);
						this.squareContainer[u] = ws;
						u++;
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
						this.squareContainer[u] = bs;
						u++;
						j++;
					}
					else {
						WhiteSquare ws = new WhiteSquare(brd.getSituation()[7-i][j]);
						ws.setBounds(j*100, i*100, 100, 100);
						this.add(ws);
						this.squareContainer[u] = ws;
						u++;
						j++;
					}
						
				}
				i--;
			}
		}
		
		this.setVisible(true);
		
	}
	
	public void refreshBoard () {
		for (JLabel sq : this.squareContainer) {
			if (sq instanceof WhiteSquare) {
				sq = (WhiteSquare) sq;
				((WhiteSquare) sq).refreshImage();
			}
			else if (sq instanceof BlackSquare) {
				sq = (BlackSquare) sq;
				((BlackSquare) sq).refreshImage();
			}
		}
		this.revalidate();
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

	public JLabel[] getSquareContainer() {
		return squareContainer;
	}

	public void setSquareContainer(JLabel[] squareContainer) {
		this.squareContainer = squareContainer;
	}
}
