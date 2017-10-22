package Game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BBPaddle {
	int width = 0;
	Image image;
	int x = 0;
	public BBPaddle() {
		width = 200;
		image = new ImageIcon(getClass().getResource("/Assets/Paddle.png")).getImage();
	}
	public void setX(int x) {
		this.x = x;
	}
	public void updateBorder() {
		if(x > 1250 - width) {
			x = 1250 - width;
		}
		if(x < 0) {
			x = 0;
		}
	}
	public int getX() {
		return this.x;
	}
	public Image getImage() {
		return this.image;
	}
	public int getWidth() {	
		return this.width;
	}
	public int getCenter() {
		return this.getX() + this.getWidth()/2;
	}
}
