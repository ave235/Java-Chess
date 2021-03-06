

package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import chess.Board;
import chess.RandomAI;
import chess.Square;
import pieces.Piece;

public class Table extends JFrame implements MouseListener {
	
	private JLabel[] squareContainer;
	private Board brd;
	private RandomAI opponent;
	
	
	private File checkSound = new File("Sounds/check_sound.wav");
	private File moveSound = new File("Sounds/move_sound.wav");
	
	public Table(Board brd) {
		
		this.brd = brd;
		brd.setFrame(this);
		this.setTitle("Chess");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(815,839);
		this.getContentPane().setBackground(Color.WHITE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		
		ImageIcon fauxicon = new ImageIcon("Images/bk.png");
		this.setIconImage(fauxicon.getImage());
		
		this.squareContainer = new JLabel[64];
		
		int u = 0;
		int i = 7;
		int j = 0;
		while (i > -1) {
			if (i % 2 == 0) {
				j = 0;
				while (j < 8) {
					if (j % 2 == 1) {
						BlackSquare bs = new BlackSquare(brd.getSituation()[7-i][j], 7-i, j);
						brd.getSituation()[7-i][j].setGuiSquare(bs);
						bs.setBounds(j*100, i*100, 100, 100);
						this.add(bs);
						this.squareContainer[u] = bs;
						u++;
						j++;
						
						
					}
					else {
						WhiteSquare ws = new WhiteSquare(brd.getSituation()[7-i][j], 7-i, j);
						brd.getSituation()[7-i][j].setGuiSquare(ws);
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
						BlackSquare bs = new BlackSquare(brd.getSituation()[7-i][j], 7-i, j);
						brd.getSituation()[7-i][j].setGuiSquare(bs);
						bs.setBounds(j*100, i*100, 100, 100);
						this.add(bs);
						this.squareContainer[u] = bs;
						u++;
						j++;
					}
					else {
						WhiteSquare ws = new WhiteSquare(brd.getSituation()[7-i][j], 7-i, j);
						brd.getSituation()[7-i][j].setGuiSquare(ws);
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
		
		this.addMouseListener(this);
		this.setFocusable(true);
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
	
	public void tableAssignment() { //THIS HAS TO BE CALLED IN THE DRIVER FUNCTION FOR GUI TO WORK
		for (JLabel sq : this.squareContainer) {
			if (sq instanceof WhiteSquare) {
				sq = (WhiteSquare) sq;
				((WhiteSquare) sq).setTable(this);
			}
			else if (sq instanceof BlackSquare) {
				sq = (BlackSquare) sq;
				((BlackSquare) sq).setTable(this);
			}
		}
	}
	
	public void mousePressInterpret(int[] mouseClickedLocation, JLabel square) {
		if (brd.getHalfTurn()[0] == null && brd.getHalfTurn()[1] == null) {
			Piece selectedPiece = brd.getSituation()[mouseClickedLocation[0]][mouseClickedLocation[1]].getPiece();
			if (selectedPiece != null) {
				if (selectedPiece.getColor() == brd.getTurn()) {
					Square[] possibleSquare = brd.findAllLegalMoves(brd.getSituation()[mouseClickedLocation[0]][mouseClickedLocation[1]].getPiece());
					if (possibleSquare.length != 0) {
						brd.getHalfTurn()[0] = mouseClickedLocation;
						for (Square item : possibleSquare) {
							JLabel subitem = item.getGuiSquare();
							if (subitem instanceof WhiteSquare) {
								((WhiteSquare) subitem).expressSelection();
							}
							else if (subitem instanceof BlackSquare) {
								((BlackSquare) subitem).expressSelection();
							}
						}
					}
				}
				
			}
		}
		else {
			brd.getHalfTurn()[1] = mouseClickedLocation;

				try {
					brd.move(brd.getHalfTurn()[0], brd.getHalfTurn()[1]);
					this.figureOutIfOpponentShouldPlay();
				} catch (Exception e) {
					System.out.println(e);
				}
				for (JLabel sq : this.squareContainer) {
					if (sq instanceof WhiteSquare) {
						((WhiteSquare) sq).clearSelection();
					}
					else if (sq instanceof BlackSquare) {
						((BlackSquare) sq).clearSelection();
					}
				}
			
			brd.getHalfTurn()[0] = null;
			brd.getHalfTurn()[1] = null;
		}
		this.refreshBoard();
	}
	
	public void figureOutIfOpponentShouldPlay() {
		if (this.opponent != null) {
			this.opponent.makeMove();
		}
	}
	
	public void reactToSomeoneWinning(int winner) {
		String winnerText;
		if (winner == 0) {
			winnerText = "White won!";
		}
		else if (winner == 1) {
			winnerText = "Black won!";
		}
		else {
			winnerText = "Stalemate";
		}
		try {
		Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		JFrame endingScene = new JFrame();
		endingScene.setTitle("Chess");
		endingScene.setAlwaysOnTop(true);
		endingScene.setDefaultCloseOperation(EXIT_ON_CLOSE);
		endingScene.setSize(400, 400);
		JLabel endingLabel = new JLabel(winnerText);
		endingScene.add(endingLabel);
		endingScene.setVisible(true);
		
	}
	
	public void executeSelection(int[] mouseClickedLocation) {
		
	}
	
	public void removeSelection() {
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
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
	
	public String toString() {
		return "Table";
	}
	
	public static void PlaySound(File sound) {
		try {
			
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/ 1000);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public File getCheckSound() {
		return checkSound;
	}

	public void setCheckSound(File checkSound) {
		this.checkSound = checkSound;
	}

	public File getMoveSound() {
		return moveSound;
	}

	public void setMoveSound(File moveSound) {
		this.moveSound = moveSound;
	}

	public RandomAI getOpponent() {
		return opponent;
	}

	public void setOpponent(RandomAI opponent) {
		this.opponent = opponent;
	}
}
