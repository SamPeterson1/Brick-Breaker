package Game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BBBackground {
	private Image currentImage;
	Image image1;
	Image image2;
	Image image3;
	Image image4;
	Image image5;
	int currentBackground = 1;
	public void setBackgrounds(String loc1, String loc2, String loc3, String loc4, String loc5) {
		image1 = new ImageIcon(getClass().getResource(loc1)).getImage();
		image2 = new ImageIcon(getClass().getResource(loc2)).getImage();
		image3 = new ImageIcon(getClass().getResource(loc3)).getImage();
		image4 = new ImageIcon(getClass().getResource(loc4)).getImage();
		image5 = new ImageIcon(getClass().getResource(loc5)).getImage();
		currentImage = image1;
	}
	public void setImage(int image) {
		switch(image){
			case 1:
				this.currentBackground = 1;
				currentImage = image1;
				break;
			case 2:
				this.currentBackground = 2;
				currentImage = image2;
				break;
			case 3:
				this.currentBackground = 3;
				currentImage = image3;
				break;
			case 4:
				this.currentBackground = 4;
				currentImage = image4;
				break;
			case 5:
				this.currentBackground = 5;
				currentImage = image5;
				break;
		}
	}
	public void cycleBackground() {
		if(currentBackground == 5) {
			currentBackground = 0;
		}
		currentBackground ++;
		switch(currentBackground){
			case 1:
				currentImage = image1;
				break;
			case 2:
				currentImage = image2;
				break;
			case 3:
				currentImage = image3;
				break;
			case 4:
				currentImage = image4;
				break;
			case 5:
				currentImage = image5;
				break;
		}
	}
	public Image getImage() {
		return this.currentImage;
	}
}
