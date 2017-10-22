package Game;

public class RedBrick extends BBBrick {
	public RedBrick() {
		super.holdsPowerup(false);
		super.setHardness(1);
		super.setImages("/Assets/RedBrick.png", "/Assets/RedBrick_2.png", "/Assets/RedBrick_3.png");
		super.setID(1);
	}
}
