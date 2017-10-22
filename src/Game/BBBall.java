package Game;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class BBBall {
	public BBBall() {
		image = new ImageIcon(getClass().getResource("/Assets/Ball.png")).getImage();
	}
	private int Xvel = 0;
	private int Yvel = 0;
	private int x = 1000;
	private int y = 600;
	private boolean started = false;
	BBLevel level;
	ArrayList<BBBrick> bricks;
	Image image;
	public void updatePos() {
		x += Xvel/4;
		y += Yvel/2;
	}
	public void checkRebound(boolean doBottomRebound) {
		if(x >= 1250 - 27) {
			Xvel -= Xvel * 2;
		}
		if(x <= 0) {
			Xvel = Math.abs(Xvel);
		}
		if(y <= 0) {
			Yvel = Math.abs(Yvel);
		}
		if(y >= 700 & doBottomRebound) {
			Yvel -= Yvel * 2;
		}
	}
	public void setLevel(BBLevel level) {
		this.level = level;
	}
	public void setBricks(ArrayList<BBBrick> bricks) {
		this.bricks = bricks;
	}
	public int checkObjectRebound(int x, int y, int width, int height, int gridX, int gridY) {
		Rectangle r1 = this.getBounds();
		Rectangle r2 = new Rectangle(x,y,width,height);
		Rectangle r3 = new Rectangle(x + width + 22,y + 7,22,height - 7);
		if(r1.intersects(r2)) {
			if(this.x + 20 < x) {
				Xvel -= Xvel * 2;
				level.breakBrick(gridX, gridY, bricks);
				System.out.println("LUP2");
				return 1;
			}
			if(this.y <= y - (height/2)) {
				level.breakBrick(gridX, gridY, bricks);
				Yvel -= Yvel * 2;
				System.out.println("LUP1");
				return 1;
			}
			if(this.y >= y + (height/2) & r1.intersects(r3) == false) {
				level.breakBrick(gridX, gridY, bricks);
				Yvel = Math.abs(Yvel);
				return 1;
			} else {
				System.out.println(r1.intersects(r3));
			}
			if(this.x > x) {
				Xvel = Math.abs(Xvel);
				level.breakBrick(gridX, gridY, bricks);
				System.out.println("LUP3");
				return 1;
			}
		}
		return 0;
	}
	public int checkObjectRebound(int x, int y, int width, int height) {
		Rectangle r1 = this.getBounds();
		Rectangle r2 = new Rectangle(x,y,width,height);
		if(r1.intersects(r2)) {
			if(this.x + 20 < x) {
				Xvel = Math.abs(Xvel);
				return 1;
			}
			if(this.y <= y - (height/2)) {
				Xvel = (this.x - (x + width/2))/ 5 ;
				Yvel -= Yvel * 2;
				return 1;
			}
			if(this.y >= y + (height/2)) {
				Yvel = Math.abs(Yvel);
				return 1;
			}
			if(this.x > x) {
				Xvel -= Xvel * 2;
				return 1;
			}
		}
		return 0;
	}
	public Image getImage() {
		return this.image;
	}
	public void reset() {
		this.x = 1000;
		this.y = 600;
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,27,27);
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void start(int xvel, int yvel) {
		if(!started) {
			this.Xvel = xvel;
			this.Yvel = yvel;
			started = true;
		}
	}
	public void stop() {
		started = false;
		this.Xvel = 0;
		this.Yvel = 0;
	}
	public boolean isStarted() {
		return started;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
