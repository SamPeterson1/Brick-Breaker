package Game;

public class BlueBrick extends BBBrick {
	public BlueBrick() {
		super.holdsPowerup(false);
		super.setHardness(2);
		super.setImages("/Assets/BlueBrick.png", "/Assets/BlueBrick_2.png", "/Assets/BlueBrick_2.png");
		super.setID(2);
	}
}
