package control;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageController {
	
	public BufferedImage logo;
	
	public BufferedImage blueSkyImage;
	public BufferedImage nightSkyImage;

	public BufferedImage blueAircraftLeftImage;
	public BufferedImage blueAircraftRightImage;
	public BufferedImage blueAircraftTopImage;
	public BufferedImage blueAircraftBottomImage;

	public BufferedImage redAircraftLeftImage;
	public BufferedImage redAircraftRightImage;
	public BufferedImage redAircraftTopImage;
	public BufferedImage redAircraftBottomImage;
	
	public BufferedImage board1Image;
	public BufferedImage board2Image;
	
	public BufferedImage quitButtonImage;
	public BufferedImage saveButtonImage;
	public BufferedImage defaultButtonImage;
	public BufferedImage startButtonImage;
	public BufferedImage optionButtonImage;
	public BufferedImage backButtonImage;
	public BufferedImage flyButtonImage;
	public BufferedImage resetButtonImage;
	public BufferedImage backPlayerButtonImage;
	public BufferedImage nextPlayerButtonImage;
	public BufferedImage homeButtonImage;
	public BufferedImage newGameButtonImage;

	public BufferedImage headShootImage;
	public BufferedImage partShootImage;
	public BufferedImage missShootImage;
	
	public BufferedImage endGame1Image;
	public BufferedImage endGame2Image;

	String logoPath = "image/logo.png";
	String blueSkyPath = "image/screen/blue_sky.jpg";
	String nightSkyPath = "image/screen/night_sky.jpg";

	String blueAircraftLeftPath = "image/aircraft/aircraft_blue_left.png";
	String blueAircraftRightPath = "image/aircraft/aircraft_blue_right.png";
	String blueAircraftTopPath = "image/aircraft/aircraft_blue_top.png";
	String blueAircraftBottomPath = "image/aircraft/aircraft_blue_bottom.png";
	
	String redAircraftLeftPath = "image/aircraft/aircraft_red_left.png";
	String redAircraftRightPath = "image/aircraft/aircraft_red_right.png";
	String redAircraftTopPath = "image/aircraft/aircraft_red_top.png";
	String redAircraftBottomPath = "image/aircraft/aircraft_red_bottom.png";
	
	String board1Path = "image/board/board_1.png";
	String board2Path = "image/board/board_2.png";
	
	String quitButtonPath = "image/button/quit_button.png";
	String startButtonPath = "image/button/start_button.png";
	String optionButtonPath = "image/button/option_button.png";
	String backButtonPath = "image/button/back_button.png";
	String saveButtonPath = "image/button/save_button.png";
	String defaultButtonPath = "image/button/default_button.png";
	String flyButtonPath = "image/button/fly_button.png";
	String resetButtonPath = "image/button/reset_button.png";
	String backPlayerButtonPath = "image/button/back_player_button.png";
	String nextPlayerButtonPath = "image/button/next_player_button.png";
	String homeButtonPath = "image/button/home_button.png";
	String newGameButtonPath = "image/button/new_game_button.png";

	String headShootPath = "image/hit_head.png";
	String partShootPath = "image/hit.png";
	String missShootPath = "image/miss.png";
	
	String endGame1Path = "image/end_game_notify.png";
	String endGame2Path = "image/end_game_notify_2.png";

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
		startButtonImage = this.readImage(startButtonPath);
		optionButtonImage = this.readImage(optionButtonPath);
		saveButtonImage = this.readImage(saveButtonPath);
		backButtonImage = this.readImage(backButtonPath);
		defaultButtonImage = this.readImage(defaultButtonPath);
		flyButtonImage = this.readImage(flyButtonPath);
		resetButtonImage = this.readImage(resetButtonPath);
		backPlayerButtonImage = this.readImage(backPlayerButtonPath);
		nextPlayerButtonImage = this.readImage(nextPlayerButtonPath);
		homeButtonImage = this.readImage(homeButtonPath);
		newGameButtonImage = this.readImage(newGameButtonPath);
	}
	
	void readingAircrafts() {
		blueAircraftBottomImage = this.readImage(blueAircraftBottomPath);
		blueAircraftLeftImage = this.readImage(blueAircraftLeftPath);
		blueAircraftRightImage = this.readImage(blueAircraftRightPath);
		blueAircraftTopImage = this.readImage(blueAircraftTopPath);
		
		redAircraftBottomImage = this.readImage(redAircraftBottomPath);
		redAircraftLeftImage = this.readImage(redAircraftLeftPath);
		redAircraftRightImage = this.readImage(redAircraftRightPath);
		redAircraftTopImage = this.readImage(redAircraftTopPath);
	}
	
	void readingBoard() {
		board1Image = this.readImage(board1Path);
		board2Image = this.readImage(board2Path);
	}
	
	public void initImage() {
		logo = readImage(logoPath);
		blueSkyImage = readImage(blueSkyPath);
		nightSkyImage = readImage(nightSkyPath);
		headShootImage = readImage(headShootPath);
		partShootImage = readImage(partShootPath);
		missShootImage = readImage(missShootPath);
		endGame1Image = readImage(endGame1Path);
		endGame2Image = readImage(endGame2Path);

		this.readingButtons();
		this.readingBoard();
		this.readingAircrafts();
	}
	
	
}
