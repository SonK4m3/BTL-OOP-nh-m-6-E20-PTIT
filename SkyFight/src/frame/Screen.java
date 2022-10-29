package frame;

import javax.swing.JFrame;

import input.MouseState;
import input.MyMouseListener;

public class Screen extends ScreenAbs implements ScreenImp{
	
	private static final long serialVersionUID = 1L;

	public Screen(ActivityAbs activity) {
		this.init();
		this.currentActivity = activity;
		this.setUp();
	}

	@Override
	public void init() {
		this.xMouse = -1;
		this.yMouse = -1;
		this.mouseState = MouseState.RELEASED;
		this.myMouseListener = new MyMouseListener(this);
	}

	@Override
	public void setUp() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.add(currentActivity);
		this.addMouseListener(myMouseListener);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);		
	}

}
