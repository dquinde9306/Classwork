package Chatbot;

import java.util.Scanner;

public class DanielQMain {
	static Scanner input;
	static String user;
	static boolean inLoop;
	static String response;
	static Topic school;
	

	public static void main(String[] args) {
		createTopics();
		promptName();
		talkForever();
		
	}
	
	

	private static void promptName() {
		print("Hello human! I am a  board covered in semi-conductors and other such electronic components. What is your name? ");
		user = input.nextLine();
		print("Awesome I will call you " + user +" until you terminate me");
		
	}



	public static void talkForever(){
		inLoop = true;
		while(inLoop){
			print("greetings " + user + " How are you?");
			response = getInput();
			if(findKeyword(response, "good", 0)){
				print("I'm so happy you're good.");
			}
			
			else if(response.indexOf("school")>=0){
				inLoop = false;// exit this loop
				school.talk();
				
			}
			
			else{ print("I'm sorry I don't understand you");
			
			}
		}
	}
	
	
	public static boolean findKeyword(String searchString, String key, int startIndex) {
		//delete white space
		String phrase = searchString.trim();
		//set all letters to lower case
		phrase = phrase.toLowerCase();
		key = key.toLowerCase();
		// find position of key
		int psn = phrase.indexOf(key);
		//keep looking for the word until you find the right context
		
		while(psn >= 0 ){
			String before = " ";
			String after = " ";
			if(psn + key.length() < phrase.length()){
				after = phrase.substring(psn + key.length(), psn + key.length() +1).toLowerCase();
			}
			if(psn> 0){
				before = phrase.substring(psn,psn-1).toLowerCase();
			}
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0){
				psn = phrase.indexOf(key,psn+1);
			}
		}
			
		
		return false;
	}



	public static void promptInput() {
		print( user +" Try inputing a String!");
		String userInput = input.nextLine();
		print("You typed: " + userInput);
		
		
	}
	
	
	
	public static String getInput(){
		return input.nextLine();
	}
	
	
	
	public static void print(String s){
		// create a multi-line String
		String printString = " ";
		int cutoff = 35;
		//  check to see if there are words to add
		// is the length of s greater than 0
		while(s.length() > 0){
			String currentLine = " ";
			String nextWord = "";
			// while the current and next word are less than the cutoff, 
			//AND there are still words to add do the following loop
			while(currentLine.length() + nextWord.length() <= cutoff && s.length() > 0 ){
				// add next word to line'
				currentLine += nextWord;
				//remove that word
				s = s.substring(nextWord.length());
				// get following word
				int endOfWord = s.indexOf(" ");
				//check to see if this is last word
				if(endOfWord == -1){
					endOfWord = s.length() -1;	
				}
								
				nextWord = s.substring(0,endOfWord+1);
				
				
			}
			
			printString += currentLine + "\n";
			
			
		}			
		System.out.println(printString);
			
//		System.out.println("Line#" + lineCount+" : " + s);
		
}



	public static void createTopics() {
		input = new Scanner(System.in);
		school = new School();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
