package _04_gui_from_scratch._4_cuteness_tv;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CutenessTv implements MouseListener{
	JFrame frame;
	JPanel panel;
	JButton left;
	JButton middle;
	JButton right;
	
	Dimension BIG = new Dimension(600, 600);
	Dimension MED = new Dimension(500, 500);
	Dimension SMALL = new Dimension(200, 200);
	public void cuteTv() {
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(BIG);
		frame.setTitle("YouTube Links");
		
		panel = new JPanel();
		panel.setSize(MED);
		frame.add(panel);
		
		left = new JButton();
		left.setText("Ducks");
		left.setPreferredSize(SMALL);
		panel.add(left);
		left.addMouseListener(this);
		
		middle = new JButton();
		middle.setText("Frog");
		middle.setPreferredSize(SMALL);
		panel.add(middle);
		middle.addMouseListener(this);
		
		right = new JButton();
		right.setText("Unicorn");
		right.setPreferredSize(SMALL);
		panel.add(right);
		right.addMouseListener(this);
		
		frame.pack();
	}
	
	void showDucks() {
	     playVideo("https://www.youtube.com/watch?v=MtN1YnoL46Q");
	}

	void showFrog() {
	     playVideo("https://www.youtube.com/watch?v=cBkWhkAZ9ds");
	}

	void showFluffyUnicorns() {
	     playVideo("https://www.youtube.com/watch?v=a-xWhG4UU_Y");
	}
	
	void playVideo(String videoID) {
	     
	     // Workaround for Linux because "Desktop.getDesktop().browse()" doesn't
	     //work on some Linux implementations
	     try {
	     if (System.getProperty("os.name").toLowerCase().contains("linux")) {
	     if (Runtime.getRuntime().exec(new String[] {
	      "which", "xdg- open" }).getInputStream().read() != -1) {
	     Runtime.getRuntime().exec(new String[] { "xdg-open", videoID });
	     }
	     } else {
	          URI uri = new URI(videoID);
	          java.awt.Desktop.getDesktop().browse(uri);
	     }      } catch (Exception e) {
	          e.printStackTrace();
	     }
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed == left) {
			showDucks();
		} else if (buttonPressed == middle) {
			showFrog();
		} else if (buttonPressed == right) {
			showFluffyUnicorns();
		}
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
