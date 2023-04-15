package _01_methods._1_houses;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */

public class Houses {
	Robot rob = new Robot();
	public void run() {
		// Check the recipe to find out what code to put here
		rob.miniaturize();
		rob.setX(25);
		rob.setY(500);
		rob.setSpeed(25);
		rob.setPenWidth(5);
		rob.penDown();
		int height;
		
		for (int x = 0; x < 10; x++) {
			if (x % 2 == 0) {
				height = 60;
			} else if (x % 3 == 0) {
				height = 120;
			} else {
				height = 250;
			}
			if (x % 2 == 0) {
				
				drawFlatHouse(height);
			} else {
				drawPointyHouse(height);
			}
		}
		
		drawPointyHouse(60);
	}
	
	public void drawFlatHouse(int height)  {
		rob.setRandomPenColor();
		rob.move(height);
		rob.turn(90);
		rob.move(30);
		rob.turn(90);
		rob.move(height);
		rob.turn(-90);
		rob.setPenColor(Color.green);
		rob.move(20);
		rob.turn(-90);
	}
	
	public void drawPointyHouse(int height) {
		rob.setRandomPenColor();
		rob.move(height);
		rob.turn(45);
		rob.move(20);
		rob.turn(90);
		rob.move(20);
		rob.turn(45);
		rob.move(height);
		rob.turn(-90);
		rob.setPenColor(Color.green);
		rob.move(20);
		rob.turn(-90);
	}
}	

