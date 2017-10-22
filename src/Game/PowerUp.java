package Game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PowerUp {
	int strength = 200;
	int backup;
	int i = 0;
	int ID = 0;
	boolean active;
	Image image;
	public void activate() {
	}
	public void deActivate() {
	}
	public void setStrength(int s) {
		this.strength = s;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public int getID() {
		return this.ID;
	}
	public Image getImage() {
		return this.image;
	}
	public void setImage(String str) {
		image = new ImageIcon(getClass().getResource(str)).getImage();
	}
	public void timer() {
		if(active) {
			i ++;
			if(i == 800) {
				deActivate();
			}
		} else {
			i = 0;
		}
	}
}
