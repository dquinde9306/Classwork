package gui;

import java.awt.Color;
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
	public void run(){
	    label.setText("");
	    nextRound();
	}



	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		progress.setRound(roundNumber);
		sequence.add(randomMove());
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence();
		changeText("Your turn.");
		label.setText("");
		acceptingInput = true;
		sequenceIndex = 0;
	}




	private void changeText(String string) {
		try{
			label.setText(string);
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}		
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
		int select = (int) (Math.random()*buttons.length);
		while(select == lastSelectedButton){
			select = (int) (Math.random()*buttons.length);
		}
		lastSelectedButton = select;
		return new MoveInterface(buttons[select]);
	}




	private void addButtons() {
		int buttonCount = 3;
		Color[] colors = {Color.red, Color.blue,Color.green};
		for(int i = 0; i < buttonCount; i++ ){
			buttons[i] = getAButton();
			buttons[i].setColor(colors[i]);
			buttons[i].setX(160 + (int)(100*Math.cos(i*2*Math.PI/(buttonCount))));
			buttons[i].setY(200 - (int)(100*Math.sin(i*2*Math.PI/(buttonCount))));
			final ButtonInterface b = buttons[i];
			buttons[i].setAction(new Action(){

				public void act(){
					if(acceptingInput){
						Thread blink = new Thread(new Runnable(){

							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(sequence.get(sequenceIndex).getButton() == b){
							sequenceIndex++;
						}else {
							progress.gameOver();
							return;
						}
						if(sequenceIndex == sequence.size()){
							Thread nextRound = new Thread(SimonScreen.this);
							nextRound.start();
						}
					}


				}

			});
			
			viewObjects.add(b);
			
			
		}

	}



	private ButtonInterface getAButton() {
		// TODO Auto-generated method stub
		return new Button();
	}




	/**
	Placeholder until partner finishes implementation of ProgressInterface
	 */

	private ProgressInterface getProgress() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub

	}


	private void playSequence() {
		ButtonInterface b = null;
		for(MoveInterface m: sequence){
			if(b!=null)b.dim();
			b = m.getButton();
			b.highlight();
			try {
				Thread.sleep((long)(2000*(2.0/(roundNumber+2))));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}
















}