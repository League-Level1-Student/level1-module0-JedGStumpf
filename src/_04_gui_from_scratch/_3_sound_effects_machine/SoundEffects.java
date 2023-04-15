package _04_gui_from_scratch._3_sound_effects_machine;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game_tools.Sound;


public class SoundEffects implements MouseListener  {
	JFrame frame;
	JPanel panel;
	
	JButton sawButton;
	JButton cymbalButton;
	JButton drumButton;
	JButton homerButton;
	
	String sawSound = "sawing-wood-daniel_simon.wav";
	String cymbal = "cymbal.wav";
	String drum = "drum.wav";
	String homer = "homer-woohoo.wav";
	
	static Boolean canPlaySounds = true;
	
	public void soundMachine() {

	
	frame = new JFrame();
	panel = new JPanel();
	
	frame.add(panel);
	
	sawButton = new JButton();
	panel.add(sawButton);
	sawButton.addMouseListener(this);
	
	cymbalButton = new JButton();
	panel.add(cymbalButton);
	cymbalButton.addMouseListener(this);
	
	drumButton = new JButton();
	panel.add(drumButton);
	drumButton.addMouseListener(this);
	
	homerButton = new JButton();
	panel.add(homerButton);
	homerButton.addMouseListener(this);
	
	frame.add(panel);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frame.pack();
	}
	
    public static synchronized void playSound(String fileName) {
        if (canPlaySounds) {
            Sound s = new Sound("_04_gui_from_scratch/_3_sound_effects_machine/" + fileName);
            s.play();
        } else {
            JOptionPane.showMessageDialog(null, "Cannot play "+fileName, "No Sound", JOptionPane.ERROR_MESSAGE);
        }
    }
    
	private void playSounds(String soundFile) {
		String path = "src/_03_gui_from_scratch/_3_sound_effects_machine/";
			File sound = new File(path+soundFile);
			if (sound.exists()) {
				new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		
		if (buttonClicked == sawButton) {
			playSound(sawSound);
		} else if (buttonClicked == cymbalButton) {
			playSound(cymbal);
		} else if (buttonClicked == drumButton) {
			playSound(drum);
		} else if (buttonClicked == homerButton) {
			playSound(homer);
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
