package Game;

public class SteelBrick extends BBBrick {
	public SteelBrick() {
		super.holdsPowerup(false);
		super.setHardness(0);
		super.setImages("/Assets/SteelBrick.png", "/Assets/SteelBrick.png", "/Assets/SteelBrick.png");
		super.setID(10);
	}
}
