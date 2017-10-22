package Game;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class SamButton {
	BBEventQueue queue = new BBEventQueue();
	BBEvent event;
	int x;
	int y;
	int width;
	int height;
	int hasWaited = 0;
	String text;
	boolean activated = true;
	Image released;
	Image currentImage;
	public SamButton(int x, int y, int width, int height, String str, boolean active, String text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.activated = active;
		this.text = text;
		released = new ImageIcon(getClass().getResource(str)).getImage();
		currentImage = released;
		int i = (int) Math.sqrt(10);
	}
	public boolean inBounds(int x, int y) {
		if(x >= this.x & x <= this.x + width) {
			if(y >= this.y & y <= this.y + height) {
				System.out.println("ACCEPTED");
				return true;
			}
		}
		System.out.println("REJECTED");
		return false;
	}
	public Image getImage() {
		return this.currentImage;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public void setEvent(BBEvent event, BBEventQueue queue) {
		this.event = event;
		this.queue = queue;
	}
	public void deActivate() {
		activated = false;
	}
	public void activate() {
		activated = true;
	}
	public boolean isActive() {
		return activated;
	}
	public String getText() {
		return this.text;
	}
	public int getStringX(Font f, Graphics g) {
		FontMetrics metrics = g.getFontMetrics(f); 
		return (this.getWidth() - metrics.stringWidth(this.getText()))/2 + this.getX();
	}
	public int getStringY(Font f, Graphics g) {
		FontMetrics metrics = g.getFontMetrics(f);
		return (this.getHeight() - metrics.getHeight()/2 + this.getY());
	}
}
