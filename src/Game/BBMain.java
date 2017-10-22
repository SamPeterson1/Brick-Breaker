package Game;

import java.util.ArrayList;

public class BBMain {
	public static void main(String args[]) {
		int[][] currentLevel = null;
		boolean b = false;
		boolean endless = false;
		boolean inSplashScreen = true;
		RedBrick redBrick = new RedBrick();
		ArrayList<BBBrick> bricks;
		ArrayList<PowerUp> powerUps;
		ArrayList<SamButton> buttons;
		BBPaddle paddle = new BBPaddle();
		BBLevel level = new BBLevel();
		bricks = new ArrayList <BBBrick>();
		powerUps = new ArrayList <PowerUp>();
		buttons = new ArrayList<SamButton>();
		BBBackground bg = new BBBackground();
		BBCanvas canvas = new BBCanvas();
		BBBall ball = new BBBall();
		BBFrame frame = new BBFrame();
		BBBrick brick = new BBBrick();
		SamButton button = new SamButton(500,300,250,75,"/Assets/BlueBrick.png", true, "Endless");
		SamButton button2 = new SamButton(500,400,250,75, "/Assets/RedBrick.png", true, "Levels");
		SteelBrick steelbrick = new SteelBrick();
		BlueBrick bluebrick = new BlueBrick();
		BBEventQueue queue = new BBEventQueue();
		BBEvent event = null;
		Bubble bubble = new Bubble();
		Extend extnd = new Extend();
		Retract retract = new Retract();
		powerUps.add(extnd);
		powerUps.add(retract);
		frame.addCanvas(canvas);
		canvas.addEventQueue(queue);
		canvas.setBackground(bg);
		bricks.add(redBrick);
		bricks.add(steelbrick);
		bricks.add(bluebrick);
		ball.setLevel(level);
		ball.setBricks(bricks);
		canvas.setPaddle(paddle);
		bg.setBackgrounds("/Assets/Background_1.png", "/Assets/Background_2.png", "/Assets/Background_3.png", "/Assets/Background_4.png", "/Assets/Background_5.png");
		canvas.setBall(ball);
		canvas.setBricks(bricks);
		level.passLevelData(canvas);
		redBrick.SetLevel(level);
		steelbrick.SetLevel(level);
		bluebrick.SetLevel(level);
		brick.SetLevel(level);
		canvas.setBubble(bubble);
		extnd.set(paddle);
		retract.set(paddle);
		bubble.setPowerUp(powerUps);
		buttons.add(button);
		buttons.add(button2);
		canvas.setButtons(buttons);
		ball.start(-5, 10);
		canvas.setLevel(level);
		while(true) {
			if(queue.isEventToProcess()) {
				event = queue.getEvent();
				if (event.getType() == BBEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'b') {
					bg.cycleBackground();
				} else if(event.getType() == BBEvent.EVENT_MOUSE_MOVE) {
					paddle.setX(event.getMouseX() - paddle.getWidth() / 2);
				}else if(event.getType() == BBEvent.EVENT_MOUSE_BUTTON_PRESS & event.isMouseLeftButton()) {
					for(SamButton button3: buttons) {
						if(button3.inBounds(event.getMouseX(), event.getMouseY())) {
							if(button3 == button) {
								canvas.updateSplash(false);
								inSplashScreen = false;
								endless = true;
								level.initEndless();
								button.deActivate();
								button2.deActivate();
								level.generateRow();
								ball.reset();
								canvas.endless(true);
								ball.stop();
							} else if(button3 == button2) {
								canvas.updateSplash(false);
								inSplashScreen = false;
								endless = false;
								button2.deActivate();
								button.deActivate();
								ball.reset();
								ball.stop();
								canvas.endless(false);
							}
						}
					}
				} else if(event.getType() == BBEvent.EVENT_MOUSE_BUTTON_PRESS & event.isMouseMiddleButton()) {
					level.nextLevel();
					canvas.setLevelData(level.getLevel());
					ball.reset();
					ball.stop();
				} else if(event.getType() == BBEvent.EVENT_MOUSE_BUTTON_PRESS & event.isMouseRightButton()) {
					ball.start(-5, 10);
				} else if(event.getType() == BBEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'r') {
					ball.reset();
					ball.stop();
				}
			}
			if(!ball.isStarted()) {
				ball.setX(paddle.getX() + paddle.getWidth() / 2 - 16);
				ball.setY(600 - 32);
			}
			if(!inSplashScreen) {
				if(!endless) {
					level.decrement(10);
				}
				if(level.getSeconds() == 0 & level.getMins() == 0) {
					ball.reset();
					ball.stop();
					level.restart();
					level.passLevelData(canvas);
				}
				ball.checkObjectRebound(paddle.getX(), 600, paddle.getWidth(), 30);
				if(ball.getY() >= 700) {
					ball.reset();
					ball.stop();
				}
				ball.updatePos();
				ball.checkRebound(false);
				if(!endless) {
					canvas.updatelevelIndex(level.getLevelIndex() + 1);
					if(level.isComplete()) {
						level.nextLevel();
						canvas.setLevelData(level.getLevel());
						ball.reset();
						ball.stop();
					}
				} else {
					level.checkEmptyRow();
				}
				bubble.generate(10);
				for(PowerUp power: powerUps) {
					power.timer();
				}
				currentLevel = level.getLevel();
				for(int i = 0; i < 11; i ++) {
					if(b) {
						b = false;
						break;
					}
					for(int k = 0; k < 10; k ++) {
						if(currentLevel[i][k] != 0) {
							int p = ball.checkObjectRebound(k * 120 + 30, i * 40, 120, 40, k, i);
							if(p == 1) {
								b = true;
								break;
							}
						}
					}
				}
				paddle.updateBorder();
				bubble.updateBubble();
				bubble.checkBubble(paddle.getX(),600, paddle.getWidth(), 30);
				canvas.Draw();
			} else {
				if(queue.isEventToProcess()) {
					event = queue.getEvent();
					if(event.getType() == BBEvent.EVENT_MOUSE_MOVE) {
						paddle.setX(event.getMouseX() - paddle.getWidth() / 2);
					}
				}
				ball.updatePos();
				ball.checkRebound(true);
				ball.checkObjectRebound(paddle.getX(), 600, paddle.getWidth(), 30);
				paddle.updateBorder();
				canvas.Draw();
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
