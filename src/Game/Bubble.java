package Game;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Bubble {
	int powerUp = 0;
	int x = -100;
	int y = -100;
	int Xvel = 0;
	int Yvel = 0;
	int i;
	int seed = -2039456;
	ArrayList<PowerUp> powerUps;
	Image image;
	Random rand = new Random(seed);
	Random rand2 = new Random(seed + 1);
	Random rand3 = new Random(seed + 2);
	public Bubble() {
		image = new ImageIcon(getClass().getResource("/Assets/Bubble.png")).getImage();
	}
	public void updateBubble() {
		this.x += Xvel/3;
		this.y += Yvel/3;
	}
	public Image getImage() {
		return this.image;
	}
	public int getX() {
		return this.x;
	}
	public int gety() {
		return this.y;
	}
	public void setPowerUp(ArrayList<PowerUp> powerUps) {
		this.powerUps = powerUps;
	}
	public void Catch(boolean activate) {
		this.x = -50;
		this.y = -50;
		this.Xvel = 0;
		this.Yvel = 0;
		for(PowerUp power: powerUps) {
			if(power.getID() == this.powerUp & activate) {
				power.activate();
			}
		}
	}
	public Image getOverlay() {
		Image retVal = new ImageIcon().getImage();
		for(PowerUp power: powerUps) {
			if(power.getID() == powerUp) {
				retVal = power.getImage();
			}
		}
		return retVal;
	}
	public void checkBubble(int x,int y,int width,int height) {
		Rectangle paddle = new Rectangle(x,y,width,height);
		Rectangle bubble = new Rectangle(this.x, this.y, 40, 40);
		if(bubble.intersects(paddle)) {
			Catch(true);
		} else if(this.y >= 600) {
			Catch(false);
		}
	}
	public void generate(int gameLoopSpeed) {
	if(Yvel == 0) {
		i += gameLoopSpeed;
	}
		if(i == 20000 & Yvel == 0) {
			powerUp = rand2.nextInt((2 - 1) + 1) + 1;
			y = rand3.nextInt((200 - 0) + 1) + 0;
			Yvel = 7;
			i = 0;
			seed ++;
			x = rand.nextInt((1250 - 1) + 1) + 1;
			rand.setSeed(seed);
		}
	}
}
