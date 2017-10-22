package Game;

public class Retract extends PowerUp{
	BBPaddle paddle;
	public Retract() {
		setStrength(-100);
		setID(2);
		setImage("/Assets/Item_Box.png");
	}
	@Override
	public void activate() {
		paddle.width += strength;
		active = true;
	}
	@Override
	public void deActivate() {
		paddle.width = backup;
		active = false;
	}
	public void set(BBPaddle paddle) {
		this.paddle = paddle;
		backup = paddle.getWidth();
	}
}
