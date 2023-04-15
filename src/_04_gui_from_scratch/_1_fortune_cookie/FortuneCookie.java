package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FortuneCookie implements ActionListener{
	JFrame frame;
	JPanel panel;
	
	public void showButton() {
		System.out.println("Button Clicked");
		frame = new JFrame();
		panel = new JPanel();
		frame.setVisible(true);
		frame.setSize(100, 100);
		panel.setSize(100, 100);
	    JButton button = new JButton();
	    button.setSize(100, 100);
	    frame.add(panel);
	    panel.add(button);
	    frame.pack();
	    
	    button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		JOptionPane.showMessageDialog(null, "WooHoo");
		String fortune1 = "You will be rich!";
		String fortune2 = "You will be poor.";
		String fortune3 = "Fun times ahead.";
		String fortune4 = "Terrible times ahead.";
		String fortune5 = "I really don't know...";
		
		Random rand = new Random();
		int fortune = rand.nextInt(5);
		
		if (fortune == 0) {
			JOptionPane.showMessageDialog(frame, fortune1);
		}
		if (fortune == 1) {
			JOptionPane.showMessageDialog(frame, fortune2);
		}
		if (fortune == 2) {
			JOptionPane.showMessageDialog(frame, fortune3);
		}
		if (fortune == 3) {
			JOptionPane.showMessageDialog(frame, fortune4);
		}
		if (fortune == 4) {
			JOptionPane.showMessageDialog(frame, fortune5);
		}
		
		
	}
}
