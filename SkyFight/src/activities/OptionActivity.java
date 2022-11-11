package activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import button.*;
import input.MouseState;

public class OptionActivity extends ActivityAbs{

	SwitchActivityButton backButton;
	DefaultButton defaultSettingButton;
	SaveButton saveSettingButton;
	
	int theme = 1;
	int size = 1;
	int aircraftType = 1;
	int boardType = 1;
	
	int[] listOption = new int[]{170, 50, 620, 300};
	int[] option1 = new int[]{202, 68, 270, 40};
	int[] option2 = new int[]{202, 142, 270, 40};
	int[] option3 = new int[]{202, 216, 270, 40};
	int[] option4 = new int[]{202, 290, 270, 40};
	
	int[] select1 = new int[]{487, 68, 270, 40};
	int[] select2 = new int[]{487, 142, 270, 40};
	int[] select3 = new int[]{487, 216, 270, 40};
	int[] select4 = new int[]{487, 290, 270, 40};
	
	int xOptionText = 260;
	int[] yOptionText = new int[] {96, 170, 244, 318};
	
	int xSelectText = 545;
	int[] ySelectText = new int[] {96, 170, 244, 318};
	
	int[] posBackButton = new int[] {170, 390};
	int[] posDefaultButton = new int[] {405, 390};
	int[] posSaveButton = new int[] {640, 390 };

	Color settingLayoutColor = new Color(255,255,255);
	Color optionColor = new Color(215,183,72);
	Color selectColor = new Color(63,94,205);
	
	public OptionActivity() {
		this.myActivity();
		this.init();
	}
	
	@Override
	public void myActivity() {
		this.setSize1();		
	}

	@Override
	public void init() {
		this.setPreferredSize(new Dimension(this.activityWidth, this.activityHeight));
		this.setBackground(new Color(255,255,255));	
		
		backButton = new SwitchActivityButton(this, 170, 390);
		defaultSettingButton = new DefaultButton(this, 405, 390);
		saveSettingButton = new SaveButton(this, 640, 390);
	}

	@Override
	public void update() {
		this.backgroundImage = this.screen.getImageController().blueSkyImage; 
		backButton.setImage(this.screen.getImageController().backButtonImage);
		defaultSettingButton.setImage(this.screen.getImageController().defaultButtonImage);
		saveSettingButton.setImage(this.screen.getImageController().saveButtonImage);
	}
	
	@Override
	public void setSize1() {
		super.setSize1();
		listOption = new int[]{170, 50, 620, 300};
		
		option1 = new int[]{202, 68, 270, 40};
		option2 = new int[]{202, 142, 270, 40};
		option3 = new int[]{202, 216, 270, 40};
		option4 = new int[]{202, 290, 270, 40};
		
		select1 = new int[]{487, 68, 270, 40};
		select2 = new int[]{487, 142, 270, 40};
		select3 = new int[]{487, 216, 270, 40};
		select4 = new int[]{487, 290, 270, 40};
		
		xOptionText = 260;
		yOptionText = new int[] {96, 170, 244, 318};
		
		xSelectText = 545;
		ySelectText = new int[] {96, 170, 244, 318};
		

		posBackButton = new int[] {170, 390};
		posDefaultButton = new int[] {405, 390};
		posSaveButton = new int[] {640, 390 };
		
		this.resetButton();
	}
	
	@Override   
	public void setSize2() {
		super.setSize2();
		listOption = new int[]{195, 75, 890, 400};
		
		option1 = new int[]{270, 110, 350, 60};
		option2 = new int[]{270, 200, 350, 60};
		option3 = new int[]{270, 290, 350, 60};
		option4 = new int[]{270, 380, 350, 60};
		
		select1 = new int[]{660, 110, 350, 60};
		select2 = new int[]{660, 200, 350, 60};
		select3 = new int[]{660, 290, 350, 60};
		select4 = new int[]{660, 380, 350, 60};
		
		xOptionText = 370;
		yOptionText = new int[] {150, 240, 330, 420};
		
		xSelectText = 760;
		ySelectText = new int[] {150, 240, 330, 420};
		
		posBackButton = new int[] {195, 533};
		posDefaultButton = new int[] {565, 533};
		posSaveButton = new int[] {935, 533 };
		
		this.resetButton();
	}
	
	void resetButton() {
		setButtonSize(backButton, posBackButton[0], posBackButton[1]);
		setButtonSize(defaultSettingButton, posDefaultButton[0], posDefaultButton[1]);
		setButtonSize(saveSettingButton, posSaveButton[0], posSaveButton[1]);
	}
	
	@Override
	public void setTheme1() {
		this.backgroundImage = this.screen.getImageController().blueSkyImage; 
		settingLayoutColor = new Color(255,255,255);
		optionColor = new Color(215,183,72);
		selectColor = new Color(63,94,205);
	}

	@Override
	public void setTheme2() {
		this.backgroundImage = this.screen.getImageController().nightSkyImage; 	
		settingLayoutColor = new Color(72,52,117);
		optionColor = new Color(228,231,127);
		selectColor = new Color(172,72,144);
	}
	
	@Override
	public int action(int xMouse, int yMouse) {
		if(this.screen.getMouseState() == MouseState.LEFTPRESSED) {
			if(backButton.isPressed(xMouse, yMouse)) {
				System.out.println("Back to Home Activity");
				return 1;
			}
			else if(defaultSettingButton.isPressed(xMouse, yMouse)) {
				System.out.println("Return default option");
				defaultSettingButton.setDefault();
			}
			else if(saveSettingButton.isPressed(xMouse, yMouse)) {
				System.out.println("Save option and back to Home Activity");
				saveSettingButton.save(theme, size, aircraftType, boardType);
				this.screen.resettingAllActivities();
				return 2;
			} else {
				if(select1[0] < xMouse && xMouse < (select1[0] + select1[2]) && select1[1] < yMouse && yMouse < (select1[1] + select1[3])) {
					this.theme = (this.theme == 1) ? 2 : 1;
				}
				else if(select2[0] < xMouse && xMouse < (select2[0] + select2[2]) && select2[1] < yMouse && yMouse < (select2[1] + select2[3])) {
					this.size = (this.size == 1) ? 2 : 1;
				}
				else if(select3[0] < xMouse && xMouse < (select3[0] + select3[2]) && select3[1] < yMouse && yMouse < (select3[1] + select3[3])) {
					this.aircraftType = (this.aircraftType == 1) ? 2 : 1;
				}
				else if(select4[0] < xMouse && xMouse < (select4[0] + select4[2]) && select4[1] < yMouse && yMouse < (select4[1] + select4[3])) {
					this.boardType = (this.boardType == 1) ? 2 : 1;
				}
			}
		}
		return -1;
	}
	
	public void getCurrentSetting() {
		theme = this.screen.getTheme();
		size = this.screen.getGameSize();
		aircraftType = this.screen.getAircraftType();
		boardType = this.screen.getBoardType();

	}
	
	public void resetting() {
		theme = 1;
		size = 1;
		aircraftType = 1;
		boardType = 1;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//draw list option
		g.setColor(settingLayoutColor);
		g.fillRect(listOption[0], listOption[1], listOption[2], listOption[3]);
		//draw option
		g.setColor(optionColor);
		g.fillRect(option1[0], option1[1], option1[2], option1[3]);
		g.fillRect(option2[0], option2[1], option2[2], option2[3]);
		g.fillRect(option3[0], option3[1], option3[2], option3[3]);
		g.fillRect(option4[0], option4[1], option4[2], option4[3]);
		
		g.setColor(selectColor);
		g.fillRect(select1[0], select1[1], select1[2], select1[3]);
		g.fillRect(select2[0], select2[1], select2[2], select2[3]);
		g.fillRect(select3[0], select3[1], select3[2], select3[3]);
		g.fillRect(select4[0], select4[1], select4[2], select4[3]);
		
		Graphics2D g2d = (Graphics2D) g; 
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 30));
        
        g2d.setColor(Color.black);
        g2d.drawString("Theme", xOptionText, yOptionText[0]);
        g2d.drawString("Size", xOptionText, yOptionText[1]);
        g2d.drawString("Aircraft", xOptionText, yOptionText[2]);
        g2d.drawString("Board", xOptionText, yOptionText[3]);
        
        g2d.setColor(Color.white);
        if(theme == 1) {
        	g2d.drawString("Light", xSelectText, ySelectText[0]);        	
        } else {
        	g2d.drawString("Dark", xSelectText, ySelectText[0]);        	
        }
        if(size == 1) {
        	g2d.drawString("960x540", xSelectText, ySelectText[1]);        	
        } else {
        	g2d.drawString("1280x720", xSelectText, ySelectText[1]);        	
        }
        if(aircraftType == 1) {
        	g2d.drawString("Type 1", xSelectText, ySelectText[2]);        	
        } else {
        	g2d.drawString("Type 2", xSelectText, ySelectText[2]);        	
        }
        if(boardType == 1) {
        	g2d.drawString("Type 1", xSelectText, ySelectText[3]);        	
        } else {
        	g2d.drawString("Type 2", xSelectText, ySelectText[3]);        	
        }
        
		backButton.paint(g);
		defaultSettingButton.paint(g);
		saveSettingButton.paint(g);
	}
}
