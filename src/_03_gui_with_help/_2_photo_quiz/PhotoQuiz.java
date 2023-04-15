package _03_gui_with_help._2_photo_quiz;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {

	public void run() {

		JFrame quizWindow = new JFrame();
		quizWindow.setVisible(true);
		// This will make sure the program exits when you close the window
		quizWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 1. find an image on the internet, and put its URL in a String
		// variable (from your browser, right click on the image, and select
		// “Copy Image Address” )
		String puppy = "https://www.dogster.com/wp-content/uploads/2021/04/A-litter-or-group-of-puppies.jpg.optimal.jpg";

		// 2. create a variable of type "Component" that will hold your image
		Component pupImage = createImage(puppy);
		// 3. use the "createImage()" method below to initialize your Component

		// 4. add the image to the quiz window
		quizWindow.add(pupImage);
		// 5. call the pack() method on the quiz window
		quizWindow.pack();
		// 6. ask a question that relates to the image
		String question = JOptionPane.showInputDialog("is this a puppy?");
		// 7. print "CORRECT" if the user gave the right answer
		if (question.equalsIgnoreCase("yes")) {
			JOptionPane.showMessageDialog(null, "Correct");
		} else {
			JOptionPane.showMessageDialog(null, "Incorrect");
		}
		// 8. print "INCORRECT" if the answer is wrong

		// 9. remove the component from the quiz window (you may not see the
		// effect of this until step 12)
		quizWindow.remove(pupImage);
		// 10. find another image and create it (might take more than one line
		// of code)
		
		String puppys = "https://www.dogster.com/wp-content/uploads/2021/04/A-litter-or-group-of-puppies.jpg.optimal.jpg";
		Component puppyImage = createImage(puppys);
		// 11. add the second image to the quiz window
		quizWindow.add(puppyImage);
		// 12. pack the quiz window
		quizWindow.pack();
		// 13. ask another question
		
		// 14+ check answer, say if correct or incorrect, etc.

	}

	private Component createImage(String imageUrl) {
		JLabel imageLabel = new JLabel();
		URL url;
		try {
			url = new URL(imageUrl);
			Icon icon = new ImageIcon(url);
			imageLabel.setIcon(icon);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "I can't find your image!!");
		}
		
		return imageLabel;
	}

	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image
	// (imageComponent.addMouseMotionListener())
}
