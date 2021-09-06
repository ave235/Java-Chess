package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import chess.Board;
import chess.RandomAI;

public class OpeningMenu implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton vRandom = new JButton("Play against Random AI");
	JButton twoPlayer = new JButton("Two player");
	
	public OpeningMenu(){
		
		twoPlayer.setBounds(100, 40, 200, 40);
		twoPlayer.setFocusable(false);
		twoPlayer.addActionListener(this);
		
		vRandom.setBounds(100, 100, 200, 40);
		vRandom.setFocusable(false);
		vRandom.addActionListener(this);
		
		ImageIcon fauxicon = new ImageIcon("Images/bk.png");
		frame.setIconImage(fauxicon.getImage());
		frame.add(vRandom);
		frame.add(twoPlayer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Chess");
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == twoPlayer) {
			frame.dispose();
			twoPlayer();
		}
		else if (e.getSource() == vRandom) {
			frame.dispose();
			playAgainstRandomComputer();
		}
		
	}
	
	public static void twoPlayer() {
		Board test = new Board();
		test.setStartingPositions();
		Table guiTest = new Table(test);
		guiTest.tableAssignment();
	}
	
	public static void playAgainstRandomComputer() {
		Board test = new Board();
		test.setStartingPositions();
		Table guiTest = new Table(test);
		guiTest.tableAssignment();
		RandomAI opponent = new RandomAI(test, guiTest);
		guiTest.setOpponent(opponent);
	}
	
}
