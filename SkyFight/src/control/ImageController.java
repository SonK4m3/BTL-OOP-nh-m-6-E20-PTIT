package control;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageController {
	
	public BufferedImage quitButtonImage;
	public BufferedImage saveButtonImage;
	public BufferedImage defaultButtonImage;
	public BufferedImage startButtonImage;
	public BufferedImage optionButtonImage;
	
	String quitButtonPath = "image/button/quit_button.png";
	
	public ImageController() {
		
	}
	
	BufferedImage readImage(String filename) {
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return img;
	}
	
	void readingButtons() {
		quitButtonImage = this.readImage(quitButtonPath);
	}
	
	public void initImage() {
		this.readingButtons();
	}
	
	
}
