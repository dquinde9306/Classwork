package gui;

import java.util.ArrayList;
import java.util.List;
import gui.components.Visible;

public class SimonScreen extends ClickableScreen implements Runnable{

	private TextLabel label;
	private ButtonInterface[] buttons;
	private ProgressInterface progress;
	private ArrayList<MoveInterface> sequence; 
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	
	
	
	public SimonScreen(int width, int height) {
		super(width, height);
		Thread screen = new Thread(this);
		screen.start();
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterface>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);

		
	}




	private MoveInterface randomMove() {
		// TODO Auto-generated method stub
		return null;
	}




	private void addButtons() {
		// TODO Auto-generated method stub
		
	}




	private ProgressInterface getProgress() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}