package Game;

public class Extend extends PowerUp{
	BBPaddle paddle;
	public Extend() {
		setStrength(100);
		setID(1);
		setImage("/Assets/Question_Box.png");
	}
	@Override
	public void activate() {
		if(!active) {
			paddle.width += strength;
			active = true;
		}
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
