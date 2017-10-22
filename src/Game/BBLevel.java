package Game;

import java.util.ArrayList;
import java.util.Random;

public class BBLevel {
	int level;
	int loops = 0;
	final int LEVEL_CNT = 5;
	private int[][] level1 = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,1,0,0,0,0},
			{0,0,0,1,2,1,0,0,0,0},
			{0,0,0,1,1,1,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0}
	};
	private int[][] level2 = {
			{0,0,0,0,0,0,0,0,0,10},
			{10,10,10,10,10,10,10,10,10,10},
			{0,0,0,0,0,0,10,10,10,10},
			{0,0,1,1,1,1,10,10,10,10},
			{0,0,1,2,2,1,10,10,10,10},
			{0,0,1,2,2,1,10,10,10,10},
			{0,0,1,1,1,1,10,10,10,10},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
	};
	int[][] level3 = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,10,0,10,0,0,0,0},
			{0,0,10,1,1,1,10,0,0,0},
			{0,0,0,1,2,1,0,0,0,0},
			{0,0,10,1,1,1,10,0,0,0},
			{0,0,0,10,0,10,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
	};
	int[][] level4 = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{2,2,0,0,0,0,0,0,2,2},
			{1,1,0,0,0,0,0,0,1,1},
			{1,1,0,0,0,0,0,0,1,1},
			{0,0,10,10,10,10,10,10,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
	};
	int[][] level5 = {
			{0,0,1,1,1,1,1,1,0,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,2,10,1,1,2,10,1,0},
			{0,1,10,10,1,1,10,10,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,10,1,10,1,10,1,1,0},
			{0,1,1,10,1,10,1,10,1,0},
			{0,0,1,1,1,1,1,1,0,0},
			{0,0,1,1,1,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0},
	};
	private int[][] xlevel1 = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,1,0,0,0,0},
			{0,0,0,1,2,1,0,0,0,0},
			{0,0,0,1,1,1,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0}
	};
	private int[][] xlevel2 = {
			{0,0,0,0,0,0,0,0,0,10},
			{10,10,10,10,10,10,10,10,10,10},
			{0,0,0,0,0,0,10,10,10,10},
			{0,0,1,1,1,1,10,10,10,10},
			{0,0,1,2,2,1,10,10,10,10},
			{0,0,1,2,2,1,10,10,10,10},
			{0,0,1,1,1,1,10,10,10,10},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
	};
	int[][] xlevel3 = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,10,0,10,0,0,0,0},
			{0,0,10,1,1,1,10,0,0,0},
			{0,0,0,1,2,1,0,0,0,0},
			{0,0,10,1,1,1,10,0,0,0},
			{0,0,0,10,0,10,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
	};
	int[][] xlevel4 = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{2,2,0,0,0,0,0,0,2,2},
			{1,1,0,0,0,0,0,0,1,1},
			{1,1,0,0,0,0,0,0,1,1},
			{0,0,10,10,10,10,10,10,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
	};
	int[][] xlevel5 = {
			{0,0,1,1,1,1,1,1,0,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,2,10,1,1,2,10,1,0},
			{0,1,10,10,1,1,10,10,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,1,10,1,10,1,10,1,1,0},
			{0,1,1,10,1,10,1,10,1,0},
			{0,0,1,1,1,1,1,1,0,0},
			{0,0,1,1,1,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0},
	};
	private int[][] currentLevel = level1.clone();
	private int[][][] levels = {level1, level2, level3, level4,level5};
	private int[][][] levels2 = {xlevel1, xlevel2, xlevel3, xlevel4, xlevel5};
	int[][] breaking = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0}
	};
	int[] time = {180,150,120,120,210};
	int[] timeBackup = {180,150,120,120,210};
	public BBLevel() {

	}
	public void passLevelData(BBCanvas canvas) {
		canvas.currentLevel = currentLevel;
	}
	public int[][] getLevel() {
		return this.currentLevel;
	}
	public int getLevel(int x, int y) {
		return this.currentLevel[y][x];
	}
	public void changeLevel(int x, int y, int val) {
		this.currentLevel[y][x] = val;
	}
	public void initEndless() {
		for(int i = 0; i < 10; i ++) {
			for(int j = 0; j < 11; j ++) {
				currentLevel[j][i] = 0;
			}
		}
	}
	public void checkEmptyRow() {
		int k = 0;
		for(int i = 0; i < 10; i ++) {
			if(currentLevel[10][i] == 0) {
				k ++;
			}
		}
		if(k == 10) {
			this.generateRow();
		}
	}
	public void breakBrick(int gridX, int gridY, ArrayList<BBBrick> bricks) {
		for(BBBrick brick: bricks) {
			if(brick.isbreakable() & brick.getID() == currentLevel[gridY][gridX]) {
				breaking[gridY][gridX] ++;
				if(breaking[gridY][gridX] == brick.hardness) {
					breaking[gridY][gridX] = 0;
					currentLevel[gridY][gridX] = 0;
				}
			}
		}
	}
	public void generateRow() {
		Random rand = new Random();
		int[] x = {0,0,0,0,0,0,0,0,0,0};
		int[] k = {0,0,0,0,0,0,0,0,0,0};
		for(int i = 10; i > 0; i --) {
			x[i - 1] = rand.nextInt((2 - 1) + 1) + 1;
			currentLevel[i] = currentLevel[i - 1];
			breaking[i] = breaking[i - 1];
		}
		currentLevel[0] = x;
		breaking[0] = k;
	}
	public void nextLevel() {
		if(level < LEVEL_CNT - 1) {
			level ++;
			currentLevel = levels[level].clone();
			for(int i = 0; i < 11; i ++) {
				for(int k = 0; k < 10; k ++) {
					breaking[i][k] = 0;
				}
			}
		}
	}
	public boolean isComplete() {
		int comp = 0;
		for(int i = 0; i < 11; i ++) {
			for(int k = 0; k < 10; k ++) {
				if(currentLevel[i][k] == 0 | currentLevel[i][k] == 10) {
					comp ++;
				}
			}
		}
		if(comp == 110) {
			return true;
		}
		return false;
	}
	public void restart() {
		for(int i = 0; i < 11; i ++) {
			currentLevel[i] = levels2[level][i].clone();
		}
		for(int i = 0; i < 11; i ++) {
			for(int k = 0; k < 10; k ++) {
				breaking[i][k] = 0;
			}
		}
		time[level] = timeBackup[level];
		for(int i = 0; i < 11; i ++) {
			System.out.println(" ");
			for(int k = 0; k < 10; k ++) {
				System.out.print(currentLevel[i][k]);;
			}
		}
	}
	public int getLevelIndex() {
		return level;
	}
	public boolean decrement(int gameLoopSpeed) {
		if(time[level] == 0) {
			return true;
		}
		if(loops == 1000){
			time[level] --;
			loops = 0;
		}
			loops += gameLoopSpeed;
		return false;
	}
	public int getSeconds() {
		return time[level] % 60;
	}
	public int getMins() {
		return time[level]/60;
	}
}
	
