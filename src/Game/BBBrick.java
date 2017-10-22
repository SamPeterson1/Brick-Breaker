package Game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BBBrick {
	boolean holdsPowerup;
	private BBLevel level;
	int hardness;
	int ID;
	boolean breakable1 = true;
	Image image;
	Image Image1;
	Image Image2;
	Image Image3;
	public BBBrick() {
		
	}
	public void SetLevel(BBLevel level) {
		this.level = level;
	}
	public void holdsPowerup(boolean holdsPowerup) {
		this.holdsPowerup = holdsPowerup;
	}
	public void setHardness(int hardness) {
		this.hardness = hardness;
		if(this.hardness == 0) {
			this.breakable1 = false;
		}
	}
	public boolean isbreakable() {
		return this.breakable1;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public int getID() {
		return this.ID;
	}
	public void setImages(String loc, String loc2, String loc3) {
		Image1 = new ImageIcon(getClass().getResource(loc)).getImage();
		Image2 = new ImageIcon(getClass().getResource(loc2)).getImage();
		Image3 = new ImageIcon(getClass().getResource(loc3)).getImage();
	}
	public Image getImage(int x, int y) {
		switch(this.level.breaking[y][x]) {
			case 0:
				this.image = Image1;
				break;
			case 1:
				this.image = Image2;
				break;
			case 2:
				this.image = Image3;
				break;
			case 3:
				//image = Image4;
				break;
			case 4:
				//image = Image5;
				break;
		}
		return this.image;
	}
}
