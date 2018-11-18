package _00_IntroToArrays;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
public class _02_FindTheHiddenButton implements ActionListener{
	JFrame window;
	JPanel panel;
	JButton[] but;
	int hiddenButton;
	public static void main(String[] args) {
		new _02_FindTheHiddenButton().start();
	}
	
	public void start() {
		window = new JFrame("Find the Button");
		panel = new JPanel();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String sz = JOptionPane.showInputDialog(null, "Enter a positive number for the size of the grid...", "S HiddenButton", JOptionPane.QUESTION_MESSAGE);
		int size = Integer.parseInt(sz);
		but = new JButton[size];
		for(int i = 0; i<but.length; i++) {
			but[i] = new JButton();
			but[i].setToolTipText("I'm just a button. TOTALLY not the hidden one. It's that guy to the left.");
			but[i].addActionListener(this);
			but[i].setText("CLICK ME!");
			panel.add(but[i]);
		}
		window.add(panel);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);
		JOptionPane.showMessageDialog(window, "The hidden button will flash when you close this, then you try and click it!");
		Random r = new Random();
		hiddenButton = r.nextInt(size);
		but[hiddenButton].setText("I'm the hidden button!");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			JOptionPane.showMessageDialog(window, "Whaaa? Internal error. Try again.");
		}
		but[hiddenButton].setText("CLICK ME!");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton)e.getSource();
		if(buttonClicked == but[hiddenButton]) {
			JOptionPane.showMessageDialog(window, "Whoo! Correct.");
			System.exit(0);
		}
		else {
			JOptionPane.showMessageDialog(window, "XXXXXXXXXX try again!");
		}
	}
}
