package Chatbot;

public class School implements Topic {
	
	private boolean inSchoolLoop;
	private String schoolResponse;
	
	
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			DanielQMain.print("tell me about school");
			schoolResponse = DanielQMain.getInput();
			DanielQMain.print("That's my favorite part about school too.");
		}

	}

}
