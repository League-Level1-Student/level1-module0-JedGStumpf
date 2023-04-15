package _04_gui_from_scratch._2_jack_in_the_box;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class JackInTheBox implements ActionListener{
	JFrame buttonFrame;
	JButton button;
	int timesPressed = 0;
	String jackImage = "jackInTheBox.png";
	public void surprise() {
		
		buttonFrame = new JFrame();
		button = new JButton();
		Dimension BIG = new Dimension(400, 400);
		button.setPreferredSize(BIG);
		button.addActionListener(this);
		button.setText("tic tic tic Surprise!!!");
		buttonFrame.add(button);
		buttonFrame.setTitle("Jack-In-The-Box");
		buttonFrame.setVisible(true);
		buttonFrame.pack();

	}
	
	private void showPicture(String fileName) {
	     try {
	          JLabel imageLabel = createLabelImage(fileName);
	          JFrame frame = new JFrame();
	          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.pack();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}

	private JLabel createLabelImage(String fileName) {
	     try {
	          URL imageURL = getClass().getResource(fileName);
	          if (imageURL == null) {
	               System.err.println("Could not find image " + fileName);
	               return new JLabel();
	          } else {
	               Icon icon = new ImageIcon(imageURL);
	               JLabel imageLabel = new JLabel(icon);
	               return imageLabel;
	          }
	     } catch (Exception e) {
	          System.err.println("Could not find image " + fileName);
	          return new JLabel();
	     }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		JButton buttonPressed = (JButton) e.getSource();
		timesPressed++;

		if (timesPressed == 5) {
			showPicture(jackImage);
		}
		
	}


}
