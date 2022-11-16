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
	public BufferedImage continueButtonImage;
	
	public BufferedImage headShootImage;
	public BufferedImage partShootImage;
	public BufferedImage missShootImage;
	
	public BufferedImage endGame1Image;
	public BufferedImage endGame2Image;

	public BufferedImage pause1Image;
	public BufferedImage pause2Image;

	
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
	String continueButtonPath = "image/button/continue_button.png";
	
	String headShootPath = "image/hit_head.png";
	String partShootPath = "image/hit.png";
	String missShootPath = "image/miss.png";
	
	String endGame1Path = "image/screen/end_game_notify.png";
	String endGame2Path = "image/screen/end_game_notify_2.png";
	
	String pause1Path = "image/screen/pause_1.png";
	String pause2Path = "image/screen/pause_2.png";

	public ImageController() {
		
	}
	
	/*
	 * read image from file and return read image
	 */
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
		quitButtonImage = readImage(quitButtonPath);
		startButtonImage = readImage(startButtonPath);
		optionButtonImage = readImage(optionButtonPath);
		saveButtonImage = readImage(saveButtonPath);
		backButtonImage = readImage(backButtonPath);
		defaultButtonImage = readImage(defaultButtonPath);
		flyButtonImage = readImage(flyButtonPath);
		resetButtonImage = readImage(resetButtonPath);
		backPlayerButtonImage = readImage(backPlayerButtonPath);
		nextPlayerButtonImage = readImage(nextPlayerButtonPath);
		homeButtonImage = readImage(homeButtonPath);
		newGameButtonImage = readImage(newGameButtonPath);
		continueButtonImage = readImage(continueButtonPath);
	}
	
	void readingAircrafts() {
		blueAircraftBottomImage = readImage(blueAircraftBottomPath);
		blueAircraftLeftImage = readImage(blueAircraftLeftPath);
		blueAircraftRightImage = readImage(blueAircraftRightPath);
		blueAircraftTopImage = readImage(blueAircraftTopPath);
		
		redAircraftBottomImage = readImage(redAircraftBottomPath);
		redAircraftLeftImage = readImage(redAircraftLeftPath);
		redAircraftRightImage = readImage(redAircraftRightPath);
		redAircraftTopImage = readImage(redAircraftTopPath);
	}
	
	void readingBoard() {
		board1Image = readImage(board1Path);
		board2Image = readImage(board2Path);
	}
	
	void readScreen() {
		blueSkyImage = readImage(blueSkyPath);
		nightSkyImage = readImage(nightSkyPath);
		endGame1Image = readImage(endGame1Path);
		endGame2Image = readImage(endGame2Path);
		pause1Image = readImage(pause1Path);
		pause2Image = readImage(pause2Path);
	}
	
	public void initImage() {
		// logo image
		logo = readImage(logoPath);
		// cell state image
		headShootImage = readImage(headShootPath);
		partShootImage = readImage(partShootPath);
		missShootImage = readImage(missShootPath);
		
		this.readScreen();
		this.readingButtons();
		this.readingBoard();
		this.readingAircrafts();
	}
	
	
}
