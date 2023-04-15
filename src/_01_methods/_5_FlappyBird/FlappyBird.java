package _01_methods._5_FlappyBird;

import java.util.Random;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    int birdYVelocity = -10;
    int gravity = 50;
    
    
    Random rand = new Random();
    int pipeGravity = rand.nextInt(100, 500);
    int pipeX1 = 375;
    int pipeX2 = 750;
    
    int elliX = 400;
    
    Boolean down = true;
    
    int score = 0;
    
    Boolean gameOn = true;
    
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        
    }

    @Override
    public void draw() {
    	
    	if (gameOn) {
            background(111,178,237);
            fill(166,237,111);
            stroke(237,149,111);
            
            ellipse(elliX, gravity, 30, 10);
            
            gravity += 1;
            
            if (mousePressed) {
            	gravity += birdYVelocity;
            }
            
            
            fill(10, 10, 10);
            rect(pipeX1, pipeGravity, 10, 50);
            
            fill(10, 10, 10);
            rect(pipeX2, pipeGravity, 10, 50);        
            
            if (down){
            	pipeGravity += 5;
            }
            
            if (!down) {
            	pipeGravity -= 5;
            }
            if (pipeGravity > 550) {
            	down = false;

            }
        	if (pipeGravity < 0) {
        		down = true;
        	}        
            
        	pipeX1 -=3;
        	pipeX2 -=3;
        	teleportPipes();

        	checkCollision();

    	}
    	
    	



    }
    
    public void teleportPipes() {
    	if (pipeX1 == 0) {
    		pipeX1 = 750;
    	}
    	if (pipeX2 == 0) {
    		pipeX2 = 750;
    	}
    	
    }
    
    public void checkCollision() {
    	if (elliX == pipeX1) {
    		if (pipeGravity -10 == gravity) {
    			gameOn = false;
    		} else if (pipeGravity + 10 == gravity) {
    			gameOn = false;
    		}
    	}
    	
    	if (elliX == pipeX2) {
    		if (pipeGravity -10 == gravity) {
    			gameOn = false;
    		} else if (pipeGravity + 10 == gravity) {
    			gameOn = false;
    		}
    	}
    }	
    

    
    
    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
