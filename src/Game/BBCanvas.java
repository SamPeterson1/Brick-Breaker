package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class BBCanvas extends Canvas{
	private static final long serialVersionUID = -1640402340407896419L;
	BBBackground bg;
	BBPaddle paddle;
	BBBall ball;
	Bubble bubble;
	BBLevel level;
	boolean splash = true;
	boolean inSettings = false;
	ArrayList <BBBrick> bricks;
	ArrayList <SamButton> buttons;
	int [][] currentLevel = null;
	int LevelIndex = 0;
	boolean endless = false;
	Image splashScreen = new ImageIcon(getClass().getResource("/Assets/SplashBack.png")).getImage();
	public BBCanvas() {
		this.setBackground(Color.BLACK);
	}
	public void Draw() {
		BufferedImage image;
		Graphics g;
		image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		g = image.getGraphics();	
		/* DO ALL OF YOUR DRAWING BETWEEN HERE */
		Font f = new Font("Helvectiva", Font.BOLD, 50);
		g.setFont(f);
		if(!splash) {
			g.drawImage(bg.getImage(), 0, 0, 1250, 710, null);
			for(BBBrick brick: bricks) {
				for(int k = 0; k < 11; k ++) {
					for(int i = 0; i < 10; i ++) {
						if(brick.getID() == currentLevel[k][i]) {
							g.drawImage(brick.getImage(i, k), i * 120 + 30, k * 40, null);
						}
					}
				}
			}
			g.drawImage(bubble.getImage(), bubble.getX(), bubble.gety(), 40, 40, null);
			g.drawImage(bubble.getOverlay(), bubble.getX() + 5, bubble.gety() + 5, null);
			g.drawImage(paddle.getImage(), paddle.getX(), 600, paddle.getWidth(), 30, null);
			g.drawImage(ball.getImage(), ball.getX(), ball.getY(), null);
			g.setColor(Color.CYAN);
			if(!endless) {
				g.drawString("Level " + LevelIndex, 10, 50);
				if(level.getSeconds() >= 10) {
					g.drawString(level.getMins() + ":" + level.getSeconds(), 500, 50);
				} else if(level.getSeconds() == 0){
					g.drawString(level.getMins() + ":00", 500, 50);
				} else {
					g.drawString(level.getMins() + ":0" + level.getSeconds(), 500, 50);
				}
			} else {
				g.drawString("Endless", 10, 50);
			}
			g.dispose();
			g = this.getGraphics();
			g.drawImage(image, 0, 0, null); 
		} else {
			g.drawImage(splashScreen, 0, 0, null);
			g.drawImage(paddle.getImage(), paddle.getX(), 600, paddle.getWidth(), 30, null);
			g.drawImage(ball.getImage(), ball.getX(), ball.getY(), null);
			for(SamButton button: buttons) {
				g.drawImage(button.getImage(), button.getX(), button.getY(), button.getWidth(), button.getHeight(), null);
				g.drawString(button.getText(), button.getStringX(f, g), button.getStringY(f, g));
			}
			g.dispose();
			g = this.getGraphics();
			g.drawImage(image, 0, 0, null); 
		}
	}
	public void setBackground(BBBackground bg) {
		this.bg = bg; 
	}
	public void setBubble(Bubble bubble) {
		this.bubble = bubble;
	}
	public void setBricks(ArrayList <BBBrick> bricks) {
		 this.bricks = bricks;
	}
	public void setLevelData(int[][] data) {
		this.currentLevel = data;
	}
	public void addEventQueue(BBEventQueue queue)  {

		this.addKeyListener(queue);
		this.addMouseListener(queue);
		this.addMouseMotionListener(queue);

	return;
	}
	public void setPaddle(BBPaddle paddle) {
		this.paddle = paddle;
	}
	public void setBall(BBBall ball) {
		this.ball = ball;
	}
	public void updateSplash(boolean Splash) {
		splash = Splash;
	}
	public void setSettings(boolean b) {
		this.inSettings = b;
	}
	public void setButtons(ArrayList<SamButton> buttons) {
		this.buttons = buttons;
	}
	public void updatelevelIndex(int index) {
		LevelIndex = index;
	}
	public void endless(boolean endless) {
		this.endless = endless;
	}
	public void setLevel(BBLevel level) {
		this.level = level;
	}
}
