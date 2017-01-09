package gui;

public class SimonGameDaniel extends GUIApplication {

	public SimonGameDaniel(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreen s = new SimonScreen(getWidth(), getHeight());
		setScreen(s);
	}

	public static void main(String[] args) {
		SimonGameDaniel game = new SimonGameDaniel(800, 500);
		Thread app = new Thread(game);
		app.start();
	}

}